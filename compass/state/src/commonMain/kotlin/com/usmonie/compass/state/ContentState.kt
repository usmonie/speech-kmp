package com.usmonie.compass.state

import androidx.compose.runtime.Immutable

/**
 * A class represents content state
 */
@Immutable
public sealed class ContentState<T>(public val item: T?) {
    public data class Success<T>(val data: T) : ContentState<T>(data)
    public data class Error<T, E : ErrorState>(val error: E) : ContentState<T>(null)
    public class Loading<T> : ContentState<T>(null)
}

public inline fun <T> ContentState<T>.updateData(
    onSuccess: (T) -> T
): ContentState<T> {
    return when (this) {
        is ContentState.Error<*, *> -> this
        is ContentState.Loading -> this
        is ContentState.Success -> ContentState.Success(onSuccess(data))
    }
}
