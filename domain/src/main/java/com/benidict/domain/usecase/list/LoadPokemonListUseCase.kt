package com.benidict.domain.usecase.list

import androidx.paging.PagingData
import androidx.paging.map
import com.benidict.data.repository.PokemonRepositoryImpl
import com.benidict.model.dto.PokemonDTO
import com.benidict.model.dto.PokemonDetailsDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoadPokemonListUseCase @Inject constructor(
    private val pokemonRepositoryImpl: PokemonRepositoryImpl
) {

    fun invoke(): Flow<PagingData<PokemonDetailsDTO>> =
        pokemonRepositoryImpl.loadPokemon().flow.map { pagingData ->
            pagingData.map { pokemonDTO ->
                pokemonRepositoryImpl.loadPokemonDetails(pokemonDTO.name)
            }
        }
//     fun invoke(): Flow<PagingData<PokemonDTO>> =
//        pokemonRepositoryImpl.loadPokemon().flow.map { pagingData ->
//            pagingData.map { pokemonDTO ->
//
//                PokemonDTO.uppercaseTheFirstLetter(pokemonDTO)
//            }
//        }
}