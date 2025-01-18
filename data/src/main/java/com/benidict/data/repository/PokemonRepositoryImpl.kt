package com.benidict.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.benidict.model.dto.PokemonDTO
import com.benidict.network.datasource.PokemonRemoteDataSourceImpl
import com.benidict.network.pagingsource.PokemonPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
   private val pokemonRemoteDataSourceImpl: PokemonRemoteDataSourceImpl
) {

    companion object {
        const val PAGE_SIZE = 10
    }

    fun loadPokemon() = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE
        ),
        pagingSourceFactory = {
            PokemonPagingSource(
                pokemonRemoteDataSourceImpl = pokemonRemoteDataSourceImpl
            )
        }
    )

    suspend fun loadPokemonDetails(
        name: String
    ) = withContext(Dispatchers.IO) {
        pokemonRemoteDataSourceImpl.loadPokemonDetails(name)
    }

}