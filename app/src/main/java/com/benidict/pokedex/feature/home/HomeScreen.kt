package com.benidict.pokedex.feature.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.benidict.pokedex.R
import com.benidict.pokedex.component.card.PokemonCard
import com.benidict.pokedex.component.layout.MainLayout
import com.benidict.pokedex.component.refresh.PullDownToRefreshView
import com.benidict.pokedex.ui.theme.PokedexTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeViewModel, onChoosePokemon: (String) -> Unit) {
    val pokemons = viewModel.pokemonPager.collectAsLazyPagingItems()
    var isRefreshing by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = isRefreshing) {
        launch(Dispatchers.Main) {
            pokemons.refresh()
        }
    }
    MainLayout(
        hasTopBar = true,
        titleTopBar = stringResource(R.string.poke_dex)
    ) { paddingValue ->

        Column(
            modifier = Modifier.padding(paddingValue)
        ) {

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                PullDownToRefreshView(
                    items = pokemons,
                    content = { pos ->
                        pokemons[pos]?.let {
                            PokemonCard(pokemonDTO = it) { pokemon ->
                                onChoosePokemon(pokemon.name.orEmpty())
                            }
                        }
                        isRefreshing = false
                    },
                    isRefreshing,
                    onRefresh = {
                        isRefreshing = true
                    }
                )
            }

            pokemons.apply {
                when {
                    loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                            )
                        }
                    }

                    loadState.refresh is LoadState.Error -> {
                        val err = pokemons.loadState.refresh as LoadState.Error

                        Log.d("makerChecker", "Error refresh:::::${err.error}")
                    }

                    loadState.append is LoadState.Error -> {
                        val err = pokemons.loadState.refresh as LoadState.Error

                        Log.d("makerChecker", "Error append:::::${err.error}")
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    PokedexTheme {
        val viewModel = hiltViewModel<HomeViewModel>()
        HomeScreen(viewModel) {

        }
    }
}