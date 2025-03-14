package com.usmonie.compass.state

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * An abstract base ViewModel class following the MVI (Model-View-Intent) architecture pattern.
 *
 * @param S The type of the screen state.
 * @param A The type of the user action on the screen.
 * @param V The type of the event on the screen.
 * @param F The type of the effect on the screen.
 * @param initialState The initial state of the screen.
 * @param defaultDispatcher The default coroutine dispatcher that the ViewModel will use.
 */
public abstract class StateViewModel<S : ScreenState, in A : ScreenAction, V : ScreenEvent, out F : ScreenEffect>(
    initialState: S,
    protected val defaultDispatcher: CoroutineDispatcher = Dispatchers.Main.immediate
) : ViewModel {
    private val viewModelJob = SupervisorJob()
    protected val viewModelScope: CoroutineScope = CoroutineScope(viewModelJob + defaultDispatcher)

    private val _state = MutableStateFlow(initialState)
    public val state: StateFlow<S> = _state.asStateFlow()

    private val _effect = Channel<F>()
    /**
     * Note: only one subscriber per viewmodel
     * */
    public val effect: Flow<F> = _effect.receiveAsFlow()

    /**
     * Handles user actions by converting them into events, then into state changes and possible side effects.
     *
     * @param action The user action to be handled.
     */
    @Suppress("TooGenericExceptionCaught")
    public fun handleAction(action: A) {
        viewModelScope.launch {
            try {
                val event = processAction(action)
                handleState(event)
            } catch (e: Exception) {
                onReduceError(e)
            }
        }
    }

    protected suspend fun handleState(event: V) {
        val newState = state.value.reduce(event)
        _state.emit(newState)
        handleEvent(event)?.let { _effect.send(it) }
    }

    /**
     * A function to be called when an error occurs during the reduction of state.
     * By default, it does nothing but can be
     * overridden in subclasses to handle errors appropriately.
     *
     * @param exception The exception that occurred during state reduction.
     */
    protected open fun onReduceError(exception: Exception) {
        // Default implementation does nothing
        exception.printStackTrace()
    }

    /**
     * Reduces the current state to a new state based on the given event.
     *
     * @param event The event to reduce the state upon.
     * @return The new state.
     */
    protected abstract fun S.reduce(event: V): S

    /**
     * Processes a user action and converts it into an event.
     *
     * @param action The user action to process.
     * @return The resulting event.
     */
    protected abstract suspend fun processAction(action: A): V

    /**
     * Handles an event and potentially produces a side effect.
     *
     * @param event The event to handle.
     * @return The side effect to emit, or null if no side effect is produced.
     */
    protected abstract suspend fun handleEvent(event: V): F?

    /**
     * Clears the resources of the ViewModel, particularly cancelling any ongoing coroutine work.
     */
    override fun onDispose() {
        viewModelJob.cancel()
    }

    /**
     * Launches a coroutine in the ViewModel's scope with an exception handler
     * to prevent uncaught exceptions from crashing the app.
     *
     * @param block The suspending block of code to execute.
     */
    protected fun CoroutineScope.launchSafe(
        block: suspend CoroutineScope.() -> Unit
    ): Job = launch(
        CoroutineExceptionHandler { _, throwable ->
            // Default error handling
            throwable.printStackTrace()
        }
    ) {
        block()
    }
}
