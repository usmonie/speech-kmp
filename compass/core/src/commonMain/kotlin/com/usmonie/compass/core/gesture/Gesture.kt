package com.usmonie.compass.core.gesture

public sealed class Gesture {
    public data class Start(
        val positionX: Float,
        val positionY: Float,
        val screenWidth: Float,
        val edge: Edge,
    ) : Gesture()

    public data class Sliding(
        val positionX: Float,
        val positionY: Float,
        val screenWidth: Float,
        val edge: Edge,
    ) : Gesture()

    public data class End(val screenWidth: Float) : Gesture()
}

public enum class Edge {
    LEFT_TO_RIGHT,
    RIGHT_TO_LEFT,
}

public sealed class ScreenGestureHandler {
    public data object NoHandling : ScreenGestureHandler()

    public data class Handling(val padding: Float) : ScreenGestureHandler()
}

public expect val isGestureSupported: Boolean