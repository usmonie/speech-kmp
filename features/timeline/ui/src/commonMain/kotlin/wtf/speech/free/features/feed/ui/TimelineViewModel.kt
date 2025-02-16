package wtf.speech.free.features.feed.ui

import com.usmonie.compass.state.StateViewModel

internal class TimelineViewModel : StateViewModel<TimelineScreenState, TimelineScreenAction, TimelineScreenEvent, TimelineScreenEffect>(
    TimelineScreenState()
){
    override fun TimelineScreenState.reduce(event: TimelineScreenEvent): TimelineScreenState {
        TODO("Not yet implemented")
    }

    override suspend fun processAction(action: TimelineScreenAction): TimelineScreenEvent {
        TODO("Not yet implemented")
    }

    override suspend fun handleEvent(event: TimelineScreenEvent): TimelineScreenEffect? {
        TODO("Not yet implemented")
    }
}