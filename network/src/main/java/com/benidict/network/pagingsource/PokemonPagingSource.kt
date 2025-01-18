package com.benidict.network.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.benidict.model.dto.PokemonDTO
import com.benidict.network.datasource.PokemonRemoteDataSourceImpl

class PokemonPagingSource constructor(
    private val pokemonRemoteDataSourceImpl: PokemonRemoteDataSourceImpl
): PagingSource<
        Int,
        PokemonDTO
        >() {

    override fun getRefreshKey(state: PagingState<Int, PokemonDTO>): Int? = state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonDTO> {
        return try {
            val page = params.key ?: 1
            val response = pokemonRemoteDataSourceImpl.loadPokemon(page, 20)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1),
                )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}