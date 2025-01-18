package com.benidict.network.module

import com.benidict.network.datasource.PokemonRemoteDataSourceImpl
import com.benidict.network.pagingsource.PokemonPagingSource
import com.benidict.network.service.PokeDexService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun providePokemonRemoteDataSourceImpl(
        pokeDexService: PokeDexService
    ) = PokemonRemoteDataSourceImpl(pokeDexService)

    @Provides
    @Singleton
    fun providePokemonPagingSource(
        pokemonRemoteDataSourceImpl: PokemonRemoteDataSourceImpl
    ) = PokemonPagingSource(pokemonRemoteDataSourceImpl)
}