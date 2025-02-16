package wtf.speech.free.features.feed.ui

import androidx.compose.runtime.Composable
import com.usmonie.compass.core.ui.ScreenId
import com.usmonie.compass.state.StateScreen
import wtf.speech.free.features.timeline.kit.TimelinePreview

internal class TimelineScreen(viewModel: TimelineViewModel) :
    StateScreen<TimelineScreenState, TimelineScreenAction, TimelineScreenEvent, TimelineScreenEffect, TimelineViewModel>(
        viewModel
    ) {
    override val id: ScreenId = ScreenId("TimelineScreen")

    @Composable
    override fun Content() {
        TimelinePreview()
    }
}