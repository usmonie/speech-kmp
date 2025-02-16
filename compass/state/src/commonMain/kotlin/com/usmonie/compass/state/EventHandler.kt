package com.usmonie.compass.state

public interface EventHandler<in Event : ScreenEvent, in State : ScreenState, out Effect : ScreenEffect> {
    public fun handle(event: Event, state: State): Effect?
}