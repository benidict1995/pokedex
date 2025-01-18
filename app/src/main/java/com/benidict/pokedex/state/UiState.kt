package com.benidict.pokedex.state

sealed class UiState<out T, out E> {
    object onLoading: UiState<Nothing, Nothing>()
    data class onSuccess<T>(val data: T): UiState<T, Nothing>()
    data class onError<E>(val error: E): UiState<Nothing, E>()
}