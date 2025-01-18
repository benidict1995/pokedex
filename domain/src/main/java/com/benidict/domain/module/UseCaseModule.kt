package com.benidict.domain.module

import com.benidict.data.repository.PokemonRepositoryImpl
import com.benidict.domain.usecase.details.LoadPokemonDetailsUseCase
import com.benidict.domain.usecase.list.LoadPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideLoadPokemonListUseCase(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ) = LoadPokemonListUseCase(pokemonRepositoryImpl)

    @Provides
    @ViewModelScoped
    fun provideLoadPokemonDetailsUseCase(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ) = LoadPokemonDetailsUseCase(pokemonRepositoryImpl)
}