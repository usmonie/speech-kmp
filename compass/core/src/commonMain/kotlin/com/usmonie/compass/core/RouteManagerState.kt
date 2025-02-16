package com.usmonie.compass.core

import androidx.collection.MutableObjectList
import androidx.collection.MutableScatterMap
import androidx.collection.ObjectList
import androidx.collection.ScatterMap
import androidx.collection.mutableObjectListOf
import androidx.collection.mutableScatterMapOf
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import com.usmonie.compass.core.ui.Screen
import com.usmonie.compass.core.utils.LinkedStack

/**
 * Represents the current state of the navigation system.
 * Includes information about current and previous screens, navigation direction,
 * transition animations, and gesture-based navigation state.
 */
@Immutable
public data class RouteManagerState(
    val navigationState: Navigating? = null,
    internal val sharedElementsState: MutableObjectList<SharedElement> = mutableObjectListOf(),
    internal val backStack: LinkedStack<NavigationGraph, Screen> = LinkedStack(),
    internal val graphsState: MutableScatterMap<GraphId, NavigationGraph> = mutableScatterMapOf(),
    internal val graphFactoriesState: MutableScatterMap<GraphId, NavigationGraphFactory> = mutableScatterMapOf(),
) {
    public val sharedElements: ObjectList<SharedElement> get() = sharedElementsState
    public val graphs: ScatterMap<GraphId, NavigationGraph> get() = graphsState
    public val graphFactories: ScatterMap<GraphId, NavigationGraphFactory> get() = graphFactoriesState
    public val currentGraph: NavigationGraph get() = backStack.peekKey()
    public val currentScreen: State<Screen> by lazy { mutableStateOf(backStack.peek()) }

    /**
     * Animatable value for gesture-based navigation.
     * -1f represents no drag, 0f represents fully visible previous screen
     */
    @Stable
    public val draggingOffset: Animatable<Float, AnimationVector1D> = Animatable(-1f)

    public val previousScreen: Screen?
        get() = backStack.peekPast()

    /**
     * Whether navigation back is possible from the current state
     */
    public val canPop: State<Boolean> = mutableStateOf(previousScreen != null)

    /**
     * Whether the previous screen should be shown (during gesture navigation)
     */
    internal val showPrevious: State<Boolean> = derivedStateOf {
        canPop.value && (draggingOffset.isRunning || draggingOffset.value > -1f)
    }

    /**
     * Whether shared element transition should be used
     */
    public val useSharedElementTransition: Boolean
        get() = sharedElements.isNotEmpty()

    /**
     * Returns appropriate enter transition based on navigation state
     */
    @Stable
    public val enterTransition: AnimatedContentTransitionScope<Screen>.() -> EnterTransition
        get() = {
            when {
                navigationState == null -> EnterTransition.None
                useSharedElementTransition -> getSharedElementEnterTransition()
                navigationState == Navigating.BACK -> currentScreen.value.popEnterTransition(this)
                navigationState == Navigating.FORWARD -> currentScreen.value.enterTransition(this)
                else -> EnterTransition.None
            }
        }

    /**
     * Returns appropriate exit transition based on navigation state
     */
    @Stable
    public val exitTransition: AnimatedContentTransitionScope<Screen>.() -> ExitTransition
        get() = {
            when {
                navigationState == null -> ExitTransition.None
                useSharedElementTransition -> getSharedElementExitTransition()
                navigationState == Navigating.BACK -> currentScreen.value.popExitTransition(this)
                navigationState == Navigating.FORWARD -> currentScreen.value.exitTransition(this)
                else -> ExitTransition.None
            }
        }

    /**
     * Gets the shared element enter transition if available
     */
    @Stable
    private fun AnimatedContentTransitionScope<Screen>.getSharedElementEnterTransition(): EnterTransition {
        return when (navigationState) {
            Navigating.FORWARD -> sharedElements.fold(EnterTransition.None) { acc, element ->
                acc /* + element.createEnterTransition() */
            }

            Navigating.BACK -> sharedElements.fold(EnterTransition.None) { acc, element ->
                acc /* + element.createPopEnterTransition() */
            }

            null -> EnterTransition.None
        }
    }

    /**
     * Gets the shared element exit transition if available
     */
    @Stable
    private fun AnimatedContentTransitionScope<Screen>.getSharedElementExitTransition(): ExitTransition {
        return when (navigationState) {
            Navigating.FORWARD -> sharedElements.fold(ExitTransition.None) { acc, element ->
                acc /* + element.createExitTransition() */
            }

            Navigating.BACK -> sharedElements.fold(ExitTransition.None) { acc, element ->
                acc /* + element.createPopExitTransition() */
            }

            null -> ExitTransition.None
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RouteManagerState) return false

        try {
            if (navigationState != other.navigationState) return false
            if (sharedElementsState != other.sharedElementsState) return false
            if (backStack != other.backStack) return false
            if (graphsState != other.graphsState) return false
            if (graphFactoriesState != other.graphFactoriesState) return false
            if (draggingOffset.value != other.draggingOffset.value) return false
            if (currentScreen.value != other.currentScreen.value) return false
            if (canPop.value != other.canPop.value) return false
            if (showPrevious.value != other.showPrevious.value) return false
        } catch (e: Exception) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        var result = navigationState?.hashCode() ?: 0
        result = 31 * result + sharedElementsState.hashCode()
        result = 31 * result + backStack.hashCode()
        result = 31 * result + graphsState.hashCode()
        result = 31 * result + graphFactoriesState.hashCode()
        result = 31 * result + draggingOffset.value.hashCode()
        result = 31 * result + currentScreen.value.hashCode()
        result = 31 * result + canPop.value.hashCode()
        result = 31 * result + showPrevious.value.hashCode()
        return result
    }

    override fun toString(): String = buildString {
        append("RouteManagerState(")
        append("navigationState=$navigationState, ")
        append("currentScreen=${currentScreen.value}, ")
        append("previousScreen=$previousScreen, ")
        append("canPop=${canPop.value}, ")
        append("showPrevious=${showPrevious.value}, ")
        append("draggingOffset=${draggingOffset.value}, ")
        append("useSharedElementTransition=$useSharedElementTransition, ")
        append("backStack=$backStack, ")
        append("sharedElements=$sharedElements")
        append(")")
    }

    /**
     * Enum representing the direction of navigation
     */
    public enum class Navigating {
        /**
         * Navigating forward to a new screen
         */
        FORWARD,

        /**
         * Navigating back to previous screen
         */
        BACK
    }
}
