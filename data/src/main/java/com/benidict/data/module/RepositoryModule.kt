package com.benidict.data.module

import com.benidict.data.repository.PokemonRepositoryImpl
import com.benidict.network.datasource.PokemonRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePokemonRepositoryImpl(
        pokemonRemoteDataSourceImpl: PokemonRemoteDataSourceImpl
    ) = PokemonRepositoryImpl(pokemonRemoteDataSourceImpl)
}