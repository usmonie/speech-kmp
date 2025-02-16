package wtf.speech.free.features.feed.ui

import com.usmonie.compass.state.ScreenState
import wtf.speech.free.features.timeline.kit.TimelineState

public data class TimelineScreenState(
    public val timeline: TimelineState = TimelineState(),
) : ScreenState {
}