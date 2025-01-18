package com.benidict.pokedex.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.benidict.domain.usecase.list.LoadPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val loadPokemonListUseCase: LoadPokemonListUseCase
): ViewModel() {


    val pokemonPager = loadPokemonListUseCase.invoke()
        .cachedIn(viewModelScope)

}