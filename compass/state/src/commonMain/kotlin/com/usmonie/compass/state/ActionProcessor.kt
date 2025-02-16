package com.usmonie.compass.state

import kotlinx.coroutines.CoroutineScope

public interface ActionProcessor<Action : ScreenAction, State : ScreenState, out Event : ScreenEvent> {
    public suspend fun process(
        coroutineScope: CoroutineScope,
        onHandleState: suspend (Event) -> Unit,
        action: Action,
        state: State
    ): Event
}
