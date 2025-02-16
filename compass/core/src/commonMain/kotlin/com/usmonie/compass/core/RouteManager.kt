package com.usmonie.compass.core

import androidx.collection.ObjectList
import androidx.collection.ScatterMap
import androidx.collection.emptyObjectList
import androidx.collection.emptyScatterMap
import androidx.compose.runtime.Immutable
import com.usmonie.compass.core.gesture.Gesture
import com.usmonie.compass.core.ui.ScreenId
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.cancellation.CancellationException

@Immutable
public interface RouteManager : ScreenSaveableStateHolder {
    /**
     * Current state of the navigation system.
     */
    public val state: StateFlow<RouteManagerState>


    /**
     * Navigates to a new navigation graph.
     *
     * @param graph The navigation graph to navigate to.
     */
    @Throws(NavigationError::class)
    public fun navigateTo(
        graph: NavigationGraph,
        storeInBackStack: Boolean,
        params: ScatterMap<String, String>,
        extras: Extra?,
        sharedElements: ObjectList<SharedElement>,
        replace: Boolean = false,
    ): Boolean

    /**
     * Navigates to a different navigation graph using its ID.
     *
     * @param graphId The ID of the graph to navigate to.
     * @param storeInBackStack Whether to store the current graph in back stack.
     * @param params Optional parameters to pass to the initial screen.
     * @param extras Optional extras to pass to the initial screen.
     * @param sharedElements List of shared elements for transition.
     * @return True if navigation was successful, false otherwise.
     */
    @Throws(NavigationError::class)
    public fun navigateTo(
        graphId: GraphId,
        storeInBackStack: Boolean = true,
        params: ScatterMap<String, String> = emptyScatterMap(),
        extras: Extra? = null,
        sharedElements: ObjectList<SharedElement> = emptyObjectList(),
        replace: Boolean = false,
    ): Boolean

    /**
     * Navigates to a screen with type-safe result handling.
     *
     * @param T The type of result expected from the screen.
     * @param graphId The ID of the graph to navigate to.
     * @param storeInBackStack Whether to store the current screen in back stack.
     * @param params Optional parameters to pass to the screen.
     * @param extras Optional extras to pass to the screen.
     * @param sharedElements List of shared elements for transition.
     * @param onResult Callback to handle the result when the screen is popped.
     * @return True if navigation was successful, false otherwise.
     */
    @Throws(
        NavigationError::class,
        CancellationException::class
    )
    public fun <T : NavigationResult> navigateForResult(
        graphId: GraphId,
        storeInBackStack: Boolean = true,
        params: ScatterMap<String, String>? = null,
        extras: Extra? = null,
        sharedElements: ObjectList<SharedElement> = emptyObjectList(),
        onResult: suspend (T) -> Unit
    ): Boolean

    /**
     * Navigates to a screen with type-safe result handling.
     *
     * @param T The type of result expected from the screen.
     * @param screenId The ID of the screen to navigate to.
     * @param storeInBackStack Whether to store the current screen in back stack.
     * @param params Optional parameters to pass to the screen.
     * @param extras Optional extras to pass to the screen.
     * @param sharedElements List of shared elements for transition.
     * @param onResult Callback to handle the result when the screen is popped.
     * @return True if navigation was successful, false otherwise.
     */
    @Throws(
        NavigationError::class,
        CancellationException::class
    )
    public fun <T : NavigationResult> navigateForResult(
        graph: NavigationGraph,
        storeInBackStack: Boolean = true,
        params: ScatterMap<String, String>? = null,
        extras: Extra? = null,
        sharedElements: ObjectList<SharedElement> = emptyObjectList(),
        onResult: suspend (T) -> Unit
    ): Boolean

    /**
     * Navigates to a screen with type-safe result handling.
     *
     * @param T The type of result expected from the screen.
     * @param screenId The ID of the screen to navigate to.
     * @param storeInBackStack Whether to store the current screen in back stack.
     * @param params Optional parameters to pass to the screen.
     * @param extras Optional extras to pass to the screen.
     * @param sharedElements List of shared elements for transition.
     * @param onResult Callback to handle the result when the screen is popped.
     * @return True if navigation was successful, false otherwise.
     */
    @Throws(
        NavigationError::class,
        CancellationException::class
    )
    public fun <T : NavigationResult> navigateForResult(
        screenId: ScreenId,
        storeInBackStack: Boolean = true,
        params: ScatterMap<String, String>? = null,
        extras: Extra? = null,
        sharedElements: ObjectList<SharedElement> = emptyObjectList(),
        onResult: suspend (T) -> Unit
    ): Boolean

    /**
     * Navigates to a specified screen.
     *
     * @param screenId The ID of the screen to navigate to.
     * @param storeInBackStack Whether to store the current screen in back stack.
     * @param params Optional parameters for the screen.
     * @param extras Optional extras for the screen.
     * @param sharedElements List of shared elements for transition.
     * @return True if navigation was successful, false otherwise.
     */
    @Throws(NavigationError::class)
    public fun navigateTo(
        screenId: ScreenId,
        storeInBackStack: Boolean = true,
        params: ScatterMap<String, String>? = null,
        extras: Extra? = null,
        sharedElements: ObjectList<SharedElement> = emptyObjectList(),
        replace: Boolean = false,
    ): Boolean

    /**
     * Pops the current screen and returns a result.
     *
     * @param T The type of result being returned.
     * @param result The result to return to the previous screen.
     */
    public suspend fun <T : NavigationResult> popWithResult(result: T): Boolean

    /**
     * Navigates back to the previous screen or closes the current graph.
     *
     * @return True if back navigation was successful, false otherwise.
     */
    public fun popBackstack(): Boolean

    /**
     * Pops screens until reaching the screen with specified ID.
     *
     * @param screenId The ID of the target screen.
     * @return True if pop operation was successful, false otherwise.
     */
    public fun popUntil(screenId: ScreenId): Boolean

    /**
     * Pops the current navigation graph.
     *
     * @return True if pop operation was successful, false otherwise.
     */
    public fun popGraph(): Boolean

    /**
     * Handles deep link navigation.
     *
     * @param deepLink The deep link URI to handle.
     * @param storeInBackStack Whether to store the current screen in back stack.
     * @param extras Optional extras to pass to the target screen.
     * @return True if deep link was handled successfully, false otherwise.
     */
    @Throws(NavigationError::class)
    public fun handleDeepLink(
        deepLink: String,
        storeInBackStack: Boolean = true,
        extras: Extra? = null
    ): Boolean

    /**
     * Handles gesture-based navigation.
     *
     * @param gesture The gesture to handle.
     * @return True if gesture was handled successfully, false otherwise.
     */
    public suspend fun gestureHandle(gesture: Gesture): Boolean

    /**
     * Registers a new [NavigationGraphFactory] with the manager.
     *
     * @param graph The navigation graph factory to register.
     */
    public fun registerGraph(graph: NavigationGraphFactory)

    /**
     * Registers a new [NavigationGraph] with the manager.
     *
     * @param graph The navigation graph to register.
     */
    public fun registerGraph(graph: NavigationGraph)
}

/**
 * Sealed class representing different types of navigation errors.
 */
public sealed class NavigationError : Exception() {
    public data class ScreenNotFound(val screenId: ScreenId, val graphId: GraphId) :
        NavigationError()

    public data class GraphNotFound(val graphId: GraphId) : NavigationError()
    public data class InvalidParams(override val message: String) : NavigationError()
    public data class NavigationFailed(override val cause: Throwable) : NavigationError()
}
