package com.usmonie.compass.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.coerceIn
import androidx.compose.ui.unit.dp
import com.usmonie.compass.core.LocalRouteManager
import com.usmonie.compass.core.RouteManager
import com.usmonie.compass.core.RouteManagerState
import com.usmonie.compass.core.gesture.Gesture
import kotlinx.coroutines.flow.Flow

@Composable
public expect fun PredictiveBackHandler(
    enabled: Boolean = true,
    isGestureEnabled: Boolean,
    onBack: suspend (progress: Flow<Gesture>) -> Unit,
    onBackPressed: () -> Unit,
    getDraggingOffset: () -> Float,
    content: @Composable BoxScope.() -> Unit,
)

@Composable
public fun BackGestureHandler(
    saveableState: @Composable (Screen, @Composable () -> Unit) -> Unit,
    isGestureNavigationEnabled: Boolean,
    routeManager: RouteManager,
    content: @Composable (BoxScope.() -> Unit)
) {

    val state by routeManager.state.collectAsState()
    val canPop by state.canPop
    PredictiveBackHandler(
        canPop,
        isGestureNavigationEnabled,
        { it.collect(routeManager::gestureHandle) },
        routeManager::popBackstack,
        { state.draggingOffset.value },
    ) {
        Box(Modifier.fillMaxSize()) {
            if (isGestureNavigationEnabled && state.draggingOffset.value > -1f) {
                PreviousScreen(saveableState)
            }
            CurrentScreen(content)
        }
    }
}

@Composable
internal fun BackGestureHandler(
    isGestureNavigationEnabled: Boolean,
    onBack: suspend (progress: Flow<Gesture>) -> Unit,
    onBackPressed: () -> Unit,
    getDraggingOffset: () -> Float,
    content: @Composable BoxScope.() -> Unit
) {
    val routeManager = LocalRouteManager.current

    val state by routeManager.state.collectAsState()
    val canPop by state.canPop
    PredictiveBackHandler(
        enabled = canPop,
        isGestureEnabled = isGestureNavigationEnabled,
        onBack = onBack,
        onBackPressed = onBackPressed,
        getDraggingOffset = getDraggingOffset
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (isGestureNavigationEnabled && state.draggingOffset.value > -1f) {
                PreviousScreen { screen, content ->
                    routeManager.SaveableStateProvider(screen, content)
                }
            }
            CurrentScreen {
                content()
            }
        }
    }
}

@Composable
private fun PreviousScreen(saveableState: @Composable (Screen, @Composable () -> Unit) -> Unit) {
    val routeManager = LocalRouteManager.current
    val state by routeManager.state.collectAsState()
    val previousScreen = state.previousScreen
    val showPrevious by state.showPrevious
    if (showPrevious && previousScreen != null) {
        Box(
            Modifier
                .graphicsLayer {
                    val prevOffset = if (showPrevious) {
                        offset(state)
                    } else {
                        0.dp
                    }.toPx()

                    translationX = prevOffset
                }
                .fillMaxSize()
        ) {
            saveableState(previousScreen) {
                previousScreen.Content()
            }
        }
    }
}

@Composable
private fun CurrentScreen(
    content: @Composable (BoxScope.() -> Unit)
) {
    val routeManager = LocalRouteManager.current
    val state by routeManager.state.collectAsState()

    Box(
        Modifier
            .graphicsLayer {
                translationX = state.draggingOffset.value + 1f
                shadowElevation = 24.dp.toPx()
            }
            .fillMaxSize()
    ) {
        content()
    }
}

private val MAX_PREV_SCREEN_OFFSET = -(180.dp)
private const val PREVIOUS_SCREEN_RATIO = 0.6f

private fun GraphicsLayerScope.offset(state: RouteManagerState) =
    (MAX_PREV_SCREEN_OFFSET + state.draggingOffset.value.toDp() * PREVIOUS_SCREEN_RATIO)
        .coerceIn(MAX_PREV_SCREEN_OFFSET, 0.dp)