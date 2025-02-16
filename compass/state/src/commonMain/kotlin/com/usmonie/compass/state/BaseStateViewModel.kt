package com.usmonie.compass.state

public open class BaseStateViewModel<S : ScreenState, in A : ScreenAction, V : ScreenEvent, out F : ScreenEffect>(
    initialState: S,
    private val stateManager: StateManager<S, V>,
    private val actionProcessor: ActionProcessor<A, S, V>,
    private val eventHandler: EventHandler<V, S, F>
) : StateViewModel<S, A, V, F>(initialState) {

    override suspend fun processAction(action: A): V = actionProcessor.process(viewModelScope, ::handleState, action, state.value)

    override suspend fun handleEvent(event: V): F? = eventHandler.handle(event, state.value)

    override fun S.reduce(event: V): S = stateManager.reduce(this, event)
}