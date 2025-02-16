package com.usmonie.compass.core.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import com.usmonie.compass.core.NavigationResult
import com.usmonie.compass.core.SharedElement
import com.usmonie.compass.core.gesture.ScreenGestureHandler
import com.usmonie.compass.core.randomUUID

@Immutable
public abstract class Screen(public val storeInBackStack: Boolean = true) {

    // Animation for opening the screen from bottom to top
    public open val enterTransition: (AnimatedContentTransitionScope<Screen>.() -> EnterTransition) = {
        EnterTransition.None
    }

    // Animation for closing the screen from top to bottom
    public open val exitTransition: (AnimatedContentTransitionScope<Screen>.() -> ExitTransition) = {
        ExitTransition.None
    }

    // No animation when returning to this screen
    public open val popEnterTransition: (AnimatedContentTransitionScope<Screen>.() -> EnterTransition) = {
        EnterTransition.None
    }

    // No animation when leaving this screen to go to advanced filters
    public open val popExitTransition: (AnimatedContentTransitionScope<Screen>.() -> ExitTransition) = {
        ExitTransition.None
    }

    // Add shared element transition support
    public open val sharedElements: List<SharedElement> = emptyList()

    // Add support for screen results
    public open val resultHandler: ((NavigationResult) -> Unit)? = null

    public open val screenGestureHandler: ScreenGestureHandler = ScreenGestureHandler.NoHandling

    public abstract val id: ScreenId
    public val uuid: String = randomUUID()

    internal var zIndex: Float = 0f

    @Composable
    public abstract fun Content()

    public open fun onCleared() {}

    /**
     * Called when the screen is about to be popped with a result
     */
    public open suspend fun onResult(result: NavigationResult) {
        resultHandler?.invoke(result)
    }

    /**
     * Helper function to create shared elements for this screen
     */
    protected fun createSharedElement(
        key: String,
        targetScreenId: ScreenId
    ): SharedElement = SharedElement(
        key = key,
        screenFromId = id,
        screenToId = targetScreenId
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Screen) return false

        if (storeInBackStack != other.storeInBackStack) return false
        if (enterTransition != other.enterTransition) return false
        if (exitTransition != other.exitTransition) return false
        if (popEnterTransition != other.popEnterTransition) return false
        if (popExitTransition != other.popExitTransition) return false
        if (screenGestureHandler != other.screenGestureHandler) return false
        if (id != other.id) return false
        if (uuid != other.uuid) return false
        if (sharedElements != other.sharedElements) return false

        return true
    }

    override fun hashCode(): Int {
        var result = storeInBackStack.hashCode()
        result = 31 * result + enterTransition.hashCode()
        result = 31 * result + exitTransition.hashCode()
        result = 31 * result + popEnterTransition.hashCode()
        result = 31 * result + popExitTransition.hashCode()
        result = 31 * result + screenGestureHandler.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + uuid.hashCode()
        result = 31 * result + sharedElements.hashCode()
        return result
    }
}
