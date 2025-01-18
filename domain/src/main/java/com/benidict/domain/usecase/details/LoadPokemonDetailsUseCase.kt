package com.benidict.domain.usecase.details

import androidx.compose.ui.text.toLowerCase
import com.benidict.data.repository.PokemonRepositoryImpl
import java.util.Locale
import javax.inject.Inject

class LoadPokemonDetailsUseCase @Inject constructor(
    private val pokemonRepositoryImpl: PokemonRepositoryImpl
) {
    suspend fun invoke(name: String) = pokemonRepositoryImpl.loadPokemonDetails(name.toLowerCase(
        Locale.US
    ))
}