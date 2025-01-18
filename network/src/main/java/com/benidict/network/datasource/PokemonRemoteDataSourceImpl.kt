package com.benidict.network.datasource

import com.benidict.network.service.PokeDexService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(
    private val pokeDexService: PokeDexService
) {

    suspend fun loadPokemon(
        offset: Int,
        limit: Int
    ) = withContext(Dispatchers.IO) {
        pokeDexService.loadPokemon(
            offset = offset,
            limit = limit
        )
    }

    suspend fun loadPokemonDetails(
        name: String
    ) = withContext(Dispatchers.IO) {
        pokeDexService.loadPokemonDetails(name)
    }
}