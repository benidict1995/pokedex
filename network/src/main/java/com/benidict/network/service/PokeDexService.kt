package com.benidict.network.service

import com.benidict.model.base.BaseResp
import com.benidict.model.dto.PokemonDTO
import com.benidict.model.dto.PokemonDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeDexService {
    @GET("pokemon")
    suspend fun loadPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): BaseResp<PokemonDTO>

    @GET("pokemon/{name}")
    suspend fun loadPokemonDetails(
        @Path("name") name: String,
    ): PokemonDetailsDTO
}