package com.usmonie.compass.core

import androidx.collection.MutableScatterMap
import androidx.collection.ObjectList
import androidx.collection.ScatterMap
import androidx.collection.emptyScatterMap
import androidx.collection.mutableObjectListOf
import androidx.collection.mutableScatterMapOf
import androidx.collection.objectListOf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReusableContent
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.LocalSaveableStateRegistry
import androidx.compose.runtime.saveable.SaveableStateRegistry
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.util.fastForEach
import com.usmonie.compass.core.gesture.Edge
import com.usmonie.compass.core.gesture.Gesture
import com.usmonie.compass.core.gesture.ScreenGestureHandler
import com.usmonie.compass.core.ui.DeepLinkScreenFactory
import com.usmonie.compass.core.ui.Screen
import com.usmonie.compass.core.ui.ScreenId
import com.usmonie.compass.core.utils.LinkedStack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch

@Immutable
public class BaseRouteManager internal constructor(
    private val routeManagerState: RouteManagerState
) : RouteManager {
    private val routeManagerScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private val currentState: MutableStateFlow<RouteManagerState> by lazy {
        MutableStateFlow(routeManagerState)
    }

    override val state: StateFlow<RouteManagerState> by lazy { currentState.asStateFlow() }

    private val currentGraph: NavigationGraph
        get() = state.value.currentGraph

    private val registryHolders = mutableMapOf<String, RegistryHolder>()
    private var parentSaveableStateRegistry: SaveableStateRegistry? = null
    private val screensSavedStates: MutableScatterMap<String, Map<String, List<Any?>>> =
        mutableScatterMapOf()

    private val resultRegistry = NavigationResultRegistry()

    private var currentZIndex = 0f

    public override fun navigateTo(
        graph: NavigationGraph,
        storeInBackStack: Boolean,
        params: ScatterMap<String, String>,
        extras: Extra?,
        sharedElements: ObjectList<SharedElement>,
        replace: Boolean,
    ): Boolean {
        currentZIndex += 1f
        val state = currentState.updateAndGet {
            val rootScreen = graph.rootScreenFactory(storeInBackStack, params, extras)

            val newState = it.copy(
                sharedElementsState = it.sharedElementsState.apply { addAll(sharedElements) },
                navigationState = RouteManagerState.Navigating.FORWARD,
                backStack = it.backStack.apply {
                    if (replace) {
                        popKey().second.fastForEach { screen ->
                            screen.onCleared()
                            removeState(screen.id.id)
                        }
                    }
                    put(graph, rootScreen)
                },
                graphsState = it.graphsState.apply { put(graph.id, graph) },
            )

            newState
        }

        return true
    }

    override fun navigateTo(
        graphId: GraphId,
        storeInBackStack: Boolean,
        params: ScatterMap<String, String>,
        extras: Extra?,
        sharedElements: ObjectList<SharedElement>,
        replace: Boolean,
    ): Boolean {
        val current = currentState.value

        val graph: NavigationGraph =
            state.value.graphs[graphId] ?: current.graphFactories[graphId]?.invoke(
                params,
                extras,
                storeInBackStack
            ) ?: throw NavigationError.GraphNotFound(graphId)

        navigateTo(graph, storeInBackStack, params, extras, sharedElements, replace)

        return true
    }

    override fun navigateTo(
        screenId: ScreenId,
        storeInBackStack: Boolean,
        params: ScatterMap<String, String>?,
        extras: Extra?,
        sharedElements: ObjectList<SharedElement>,
        replace: Boolean,
    ): Boolean {
        currentZIndex += 1f
        val nextScreen = currentGraph.findScreen(
            screenId,
            storeInBackStack,
            params,
            extras,
            sharedElements
        ) ?: throw NavigationError.ScreenNotFound(screenId, currentGraph.id)
        navigateToScreen(currentGraph, nextScreen, sharedElements)
        return true
    }

    override fun <T : NavigationResult> navigateForResult(
        graphId: GraphId,
        storeInBackStack: Boolean,
        params: ScatterMap<String, String>?,
        extras: Extra?,
        sharedElements: ObjectList<SharedElement>,
        onResult: suspend (T) -> Unit
    ): Boolean {
        val graph = state.value.graphs[graphId] ?: state.value.graphFactories[graphId]?.invoke(
            params ?: emptyScatterMap(),
            extras,
            storeInBackStack
        ) ?: throw NavigationError.GraphNotFound(graphId)

        val rootScreen = graph.rootScreenFactory(storeInBackStack, params, extras)

        val channel = Channel<NavigationResult>(Channel.CONFLATED)
        resultRegistry.registerResultListener(rootScreen.id, channel)

        navigateTo(
            graph,
            storeInBackStack,
            params ?: emptyScatterMap(),
            extras,
            sharedElements,
            false
        )

        routeManagerScope.launch {
            try {
                val result = channel.receive()
                @Suppress("UNCHECKED_CAST")
                onResult(result as T)
            } finally {
                channel.close()
                resultRegistry.removeResultListener(rootScreen.id)
            }
        }

        return true
    }

    override fun <T : NavigationResult> navigateForResult(
        graph: NavigationGraph,
        storeInBackStack: Boolean,
        params: ScatterMap<String, String>?,
        extras: Extra?,
        sharedElements: ObjectList<SharedElement>,
        onResult: suspend (T) -> Unit
    ): Boolean {
        val channel = Channel<NavigationResult>(Channel.CONFLATED)
        resultRegistry.registerResultListener(graph.rootScreenFactory.id, channel)

        navigateTo(
            graph,
            storeInBackStack,
            params ?: emptyScatterMap(),
            extras,
            sharedElements,
            false
        )
        routeManagerScope.launch {
            try {
                val result = channel.receive()
                @Suppress("UNCHECKED_CAST")
                onResult(result as T)
            } finally {
                channel.close()
                resultRegistry.removeResultListener(graph.rootScreenFactory.id)
            }
        }

        return true
    }

    override fun <T : NavigationResult> navigateForResult(
        screenId: ScreenId,
        storeInBackStack: Boolean,
        params: ScatterMap<String, String>?,
        extras: Extra?,
        sharedElements: ObjectList<SharedElement>,
        onResult: suspend (T) -> Unit
    ): Boolean {
        val screen =
            findScreenInGraphOrThrow(screenId, storeInBackStack, params, extras, sharedElements)
        val channel = Channel<NavigationResult>(Channel.CONFLATED)
        // Pass the channel to register
        resultRegistry.registerResultListener(screenId, channel)

        // Navigate to screen first
        navigateToScreen(currentGraph, screen, sharedElements)

        routeManagerScope.launch {
            try {
                // Wait for single result
                val result = channel.receive()

                @Suppress("UNCHECKED_CAST")
                onResult(result as T)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                channel.close()
                resultRegistry.removeResultListener(screenId)
            }
        }

        return true
    }

    override suspend fun <T : NavigationResult> popWithResult(result: T): Boolean {
        resultRegistry.deliverResult(result)

        return popBackstack()
    }

    override fun popBackstack(): Boolean {
        if (!state.value.canPop.value) {
            return false
        }
        currentZIndex--
        currentState.update {
            val backstack = it.backStack
            val poppedScreen = backstack.pop() // Удалить экран
            poppedScreen.onCleared()
            removeState(poppedScreen.id.id)

            it.copy(
                backStack = backstack,
                navigationState = RouteManagerState.Navigating.BACK,
            )
        }

        return true
    }

    override fun popUntil(screenId: ScreenId): Boolean {
        if (!state.value.canPop.value) {
            return false
        }

        currentState.update {
            it.copy(
                navigationState = RouteManagerState.Navigating.BACK,
                backStack = it.backStack.apply {
                    removeUntil { _, screen ->
                        val found = screen.id == screenId
                        if (!found) {
                            screen.onCleared()
                            removeState(screen.id.id)
                        }
                        found
                    }
                }
            )
        }
        return true
    }

    override fun popGraph(): Boolean {
        if (!state.value.canPop.value) {
            return false
        }

        currentState.update {
            it.copy(
                navigationState = RouteManagerState.Navigating.BACK,
                backStack = it.backStack.apply {
                    popKey().second.fastForEach { screen ->
                        screen.onCleared()
                        removeState(screen.id.id)
                    }
                }
            )
        }

        return true
    }

    override fun handleDeepLink(
        deepLink: String,
        storeInBackStack: Boolean,
        extras: Extra?
    ): Boolean {
        val matchingScreenBuilder = state
            .value
            .graphFactories
            .asMap()
            .values
            .asSequence()
            .flatMap { it.screensFactories.asMap().values }
            .filterIsInstance<DeepLinkScreenFactory>()
            .firstOrNull { it.matches(deepLink) }

        matchingScreenBuilder?.let {
            val parameters = it.extractParameters(deepLink)
            navigateTo(matchingScreenBuilder.id, storeInBackStack, parameters, extras)
            return true
        }
        return false
    }

    override suspend fun gestureHandle(gesture: Gesture): Boolean {
        if (!state.value.canPop.value) return false

        val gestureStarting =
            when (val handler = state.value.currentScreen.value.screenGestureHandler) {
                is ScreenGestureHandler.Handling -> handler.padding
                else -> Float.MAX_VALUE
            }

        val backHandled = when (gesture) {
            is Gesture.End -> handleGestureEnd(gesture)
            is Gesture.Sliding -> handleSliding(gesture)
            is Gesture.Start -> gestureStarting >= gesture.positionX
        }

        return backHandled
    }

    override fun registerGraph(graph: NavigationGraphFactory) {
        currentState.update {
            it.copy(graphFactoriesState = it.graphFactoriesState.apply { put(graph.id, graph) })
        }
    }

    override fun registerGraph(graph: NavigationGraph) {
        currentState.update {
            it.copy(graphsState = it.graphsState.apply { put(graph.id, graph) })
        }
    }

    override fun removeState(key: String) {
        val registryHolder = registryHolders[key]
        if (registryHolder != null) {
            registryHolder.shouldSave = false
        } else {
            screensSavedStates -= key
        }
    }

    @Composable
    override fun SaveableStateProvider(screen: Screen, content: @Composable () -> Unit) {
        val key = screen.uuid
        ReusableContent(key) {
            val registryHolder = remember {
                require(parentSaveableStateRegistry?.canBeSaved(key) ?: true) {
                    "Type of the key $key is not supported. On Android you can only use types " +
                            "which can be stored inside the Bundle."
                }
                RegistryHolder(key)
            }

            CompositionLocalProvider(
                LocalSaveableStateRegistry provides registryHolder.registry,
                content = content
            )

            DisposableEffect(Unit) {
/*
				Temporary disabled this check cause it throws error when
				trying to gesture back during screen changing animation
 */
//				require(key !in registryHolders) { "Key $key was used multiple times " }
                screensSavedStates -= key
                registryHolders[key] = registryHolder

                onDispose {
                    registryHolder.saveTo(screensSavedStates)
                    registryHolders -= key
                }
            }
        }
    }

    private fun navigateToScreen(
        graph: NavigationGraph,
        screen: Screen,
        sharedElements: ObjectList<SharedElement>
    ) {
        val state = currentState.updateAndGet {
            it.copy(
                backStack = it.backStack.apply {
                    val currentScreen = peekOrNull()
                    if (currentScreen?.storeInBackStack == false) {
                        val poppedScreen = pop()
                        poppedScreen.onCleared()
                        removeState(poppedScreen.id.id)
                    }
                    put(graph, screen)
                },
                navigationState = RouteManagerState.Navigating.FORWARD,
                sharedElementsState = it.sharedElementsState.apply { addAll(sharedElements) },
            )
        }
    }

    private fun findScreenInGraphOrThrow(
        screenId: ScreenId,
        storeInBackStack: Boolean = true,
        params: ScatterMap<String, String>? = null,
        extras: Extra? = null,
        sharedElements: ObjectList<SharedElement> = objectListOf(),
        navigationGraph: NavigationGraph = currentGraph,
    ) = navigationGraph.findScreen(screenId, storeInBackStack, params, extras, sharedElements)
        ?: throw NavigationError.ScreenNotFound(screenId, navigationGraph.id)

    private suspend fun handleGestureEnd(gesture: Gesture.End): Boolean {
        val state = currentState.value
        if (!state.canPop.value) {
            return false
        }
        val offset = state.draggingOffset.value

        if (offset < gesture.screenWidth * SCREEN_WIDTH_PORTION_FOR_BACK_GESTURE) {
            state.draggingOffset.animateTo(-1f)
            return false
        }

        return try {
            state.draggingOffset.animateTo(gesture.screenWidth) {
                if (value == targetValue) {
                    popBackstack()
                }
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    private suspend fun handleSliding(gesture: Gesture.Sliding): Boolean {
        val state = currentState.value
        if (!state.canPop.value) {
            return false
        }

        return if (state.previousScreen != null) {
            state.draggingOffset.snapTo(
                when (gesture.edge) {
                    Edge.LEFT_TO_RIGHT -> gesture.positionX
                    Edge.RIGHT_TO_LEFT -> gesture.screenWidth - gesture.positionX
                }
            )
            true
        } else {
            false
        }
    }

    public companion object {
        private const val SCREEN_WIDTH_PORTION_FOR_BACK_GESTURE = .20

        public inline fun build(
            initialGraphId: GraphId,
            extras: Extra? = null,
            params: ScatterMap<String, String> = emptyScatterMap(),
            block: Builder.() -> Unit
        ): BaseRouteManager = Builder(initialGraphId).apply(block).build(extras, params)

        /**
         * To keep current page and current page offset saved
         */
        public val Saver: Saver<RouteManager, *> = listSaver(
            save = {
                listOf(it.state.value)
            },
            restore = {
                BaseRouteManager(it[0])
            }
        )
    }

    internal inner class RegistryHolder(private val key: String) {
        var shouldSave = true
        val registry: SaveableStateRegistry = SaveableStateRegistry(screensSavedStates[key]) {
            parentSaveableStateRegistry?.canBeSaved(it) != false
        }

        fun saveTo(map: MutableScatterMap<String, Map<String, List<Any?>>>) {
            if (shouldSave) {
                val savedData = registry.performSave()
                if (savedData.isEmpty()) {
                    map -= key
                } else {
                    map[key] = savedData
                }
            }
        }
    }

    public class Builder(private val initialGraphId: GraphId) {
        private val graphFactories: MutableScatterMap<GraphId, NavigationGraphFactory> =
            mutableScatterMapOf()

        private val graphs: MutableScatterMap<GraphId, NavigationGraph> =
            mutableScatterMapOf()

        public fun registerGraphFactory(graphFactory: NavigationGraphFactory) {
            graphFactories[graphFactory.id] = graphFactory
        }

        public fun registerGraph(graph: NavigationGraph) {
            graphs[graph.id] = graph
        }

        public fun build(
            extras: Extra? = null,
            params: ScatterMap<String, String> = emptyScatterMap(),
        ): BaseRouteManager {
            val currentGraph = graphs[initialGraphId] ?: graphFactories[initialGraphId]?.invoke(
                storeInBackstack = true
            )
            ?: throw NoSuchElementException("There is no $initialGraphId in registered graph factories: $graphFactories")

            val rootScreen = currentGraph.rootScreenFactory.invoke(params = params, extra = extras)
            val backstack = LinkedStack<NavigationGraph, Screen>().apply {
                put(currentGraph, rootScreen)
            }

            if (!graphs.contains(currentGraph.id)) {
                graphs.put(currentGraph.id, currentGraph)
            }

            val state = RouteManagerState(
                navigationState = null,
                backStack = backstack,
                sharedElementsState = mutableObjectListOf(),
                graphsState = graphs,
                graphFactoriesState = graphFactories
            )
            return BaseRouteManager(state)
        }
    }
}

@Composable
public fun rememberRouteManager(
    initialGraphId: GraphId,
    extras: Extra? = null,
    params: ScatterMap<String, String> = emptyScatterMap(),
    builder: BaseRouteManager.Builder.() -> Unit
): RouteManager = rememberSaveable(saver = BaseRouteManager.Saver) { getRouteManager(initialGraphId, extras, params, builder) }

public fun getRouteManager(
    initialGraphId: GraphId,
    extras: Extra? = null,
    params: ScatterMap<String, String> = emptyScatterMap(),
    builder: BaseRouteManager.Builder.() -> Unit
): RouteManager = BaseRouteManager.build(initialGraphId, extras, params, builder)

public fun getRouteManager(): RouteManager = BaseRouteManager(RouteManagerState())

public val LocalRouteManager: ProvidableCompositionLocal<RouteManager> = staticCompositionLocalOf {
    error("No RouteManager provided!")
}
