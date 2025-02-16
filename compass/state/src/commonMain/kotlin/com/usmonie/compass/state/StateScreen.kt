package com.usmonie.compass.state

import com.usmonie.compass.core.ui.Screen

public abstract class StateScreen<
        S : ScreenState,
        A : ScreenAction,
        V : ScreenEvent,
        F : ScreenEffect,
        VM : StateViewModel<S, A, V, F>
        >(protected val viewModel: VM) : Screen() {

    override fun onCleared() {
        viewModel.onDispose()
    }
}
