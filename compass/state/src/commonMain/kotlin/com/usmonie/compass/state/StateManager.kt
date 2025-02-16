package com.usmonie.compass.state

public interface StateManager<State : ScreenState, in Event : ScreenEvent> {
    public fun reduce(state: State, event: Event): State
}
