package com.usmonie.compass.state

import androidx.compose.runtime.Stable

/**
 * A base class for representing the states of a screen in MVI architecture
 */
@Stable
public interface ScreenState

/**
 * A subclass of ScreenState that represents an error state
 */
@Stable
public abstract class  ErrorState(error: Throwable) : ScreenState {

    /**
     * A value to get the error message
     * @return the error message or "Unknown error" if the message is null
     */
    public val message: String = error.message ?: "Unknown error"
}

/**
 * A base class for representing the events that occur on a screen in MVI architecture
 */
public interface ScreenEvent


/**
 * A base class for representing the actions that are performed on a screen in MVI architecture
 */
public interface ScreenAction

/**
 *  A base class for representing the effects that are triggered on a screen in MVI architecture
 */
public interface ScreenEffect
