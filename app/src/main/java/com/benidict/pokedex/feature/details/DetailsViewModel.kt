package com.benidict.pokedex.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benidict.domain.usecase.details.LoadPokemonDetailsUseCase
import com.benidict.model.dto.PokemonDetailsDTO
import com.benidict.pokedex.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val loadPokemonDetailsUseCase: LoadPokemonDetailsUseCase
) : ViewModel() {

    private val _uiState: MutableSharedFlow<UiState<PokemonDetailsDTO, Exception>> = MutableSharedFlow()
    val uiState = _uiState.asSharedFlow()

    fun loadPokemonDetails(name: String) {
        viewModelScope.launch {
            _uiState.emit(UiState.onLoading)
            try {
                val invoke = loadPokemonDetailsUseCase.invoke(name)
                _uiState.emit(UiState.onSuccess(data = invoke))
            } catch (e: Exception) {
                _uiState.emit(UiState.onError(e))
            }
        }
    }
}