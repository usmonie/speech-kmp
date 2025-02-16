package com.usmonie.compass.core.ui

import androidx.collection.mutableScatterMapOf
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.usmonie.compass.core.LocalRouteManager
import com.usmonie.compass.core.RouteManager

@Composable
public fun Root(
    routeManager: RouteManager,
    modifier: Modifier = Modifier,
    isGestureNavigationEnabled: Boolean = false,
    backgroundColor: Color = Color.White
) {
    CompositionLocalProvider(LocalRouteManager provides routeManager) {
        val state by routeManager.state.collectAsState()
        val canPop by state.canPop
        BackGestureHandler(
            isGestureNavigationEnabled = isGestureNavigationEnabled && canPop,
            onBack = { it.collect(routeManager::gestureHandle) },
            onBackPressed = routeManager::popBackstack,
            getDraggingOffset = { state.draggingOffset.value }
        ) {
            val currentScreen by state.currentScreen
            AnimatedScreenStack(
                currentScreen = currentScreen,
                saveableState = { screen, content ->
                    routeManager.SaveableStateProvider(screen, content)
                },
                modifier = modifier.background(backgroundColor)
            )
        }
    }
}

@Composable
private fun AnimatedScreenStack(
    currentScreen: Screen,
    saveableState: @Composable (Screen, @Composable () -> Unit) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        // Animate current screen
        AnimatedContent(
            targetState = currentScreen,
            transitionSpec = { getContentTransform(initialState, targetState) },
            modifier = Modifier.fillMaxSize(),
        ) { screen ->
            saveableState(screen) {
                screen.Content()
            }
        }
    }
}

private fun AnimatedContentTransitionScope<Screen>.getContentTransform(
    initialState: Screen,
    targetState: Screen
): ContentTransform {
    val initialZIndex = initialState.zIndex
    val targetZIndex = targetState.zIndex

    val enterTransition: AnimatedContentTransitionScope<Screen>.() -> EnterTransition
    val exitTransition: AnimatedContentTransitionScope<Screen>.() -> ExitTransition

    when {
        targetZIndex > initialZIndex -> {
            enterTransition = targetState.enterTransition
            exitTransition = initialState.exitTransition
        }

        targetZIndex < initialZIndex -> {
            enterTransition = targetState.popEnterTransition
            exitTransition = initialState.popExitTransition
        }

        else -> {
            enterTransition = { EnterTransition.None }
            exitTransition = { ExitTransition.None }
        }
    }

    return enterTransition().togetherWith(exitTransition())
}

@Composable
private fun AnimationScreen(
    currentScreen: Screen,
    enterTransition: AnimatedContentTransitionScope<Screen>.() -> EnterTransition,
    exitTransition: AnimatedContentTransitionScope<Screen>.() -> ExitTransition,
    saveableState: @Composable (Screen, @Composable () -> Unit) -> Unit,
    modifier: Modifier
) {
    val zIndices = remember { mutableScatterMapOf<ScreenId, Float>() }
    val transition = updateTransition(currentScreen, label = "screen_updating")

    transition.AnimatedContent(
        modifier = modifier,
        transitionSpec = {
            // If the initialState of the AnimatedContent is not in visibleEntries, we are in
            // a case where visible has cleared the old state for some reason, so instead of
            // attempting to animate away from the initialState, we skip the animation.
            val initialZIndex = zIndices[initialState.id]
                ?: 0f.also { zIndices[initialState.id] = 0f }
            val targetZIndex = when {
                targetState.id == initialState.id -> initialZIndex
                else -> initialZIndex + 1f
            }.also { zIndices[targetState.id] = it }

            ContentTransform(
                enterTransition(this),
                exitTransition(this),
                targetZIndex
            )
        },
        contentAlignment = Alignment.Center,
        content = { screen ->
            saveableState(screen) {
                screen.Content()
            }
        }
    )

    LaunchedEffect(transition.currentState, transition.targetState) {
        if (transition.currentState == transition.targetState) {
            zIndices.forEach { key, _ -> if (key != transition.targetState.id) zIndices.remove(key) }
        }
    }
}
