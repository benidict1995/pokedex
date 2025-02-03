package com.benidict.pokedex.feature.details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.benidict.model.dto.PokemonDetailsDTO
import com.benidict.pokedex.R
import com.benidict.pokedex.component.card.PokemonDetailsCard
import com.benidict.pokedex.component.layout.MainLayout
import com.benidict.pokedex.component.list.AbilityList
import com.benidict.pokedex.component.text.TypewriterText
import com.benidict.pokedex.state.UiState
import com.benidict.pokedex.ui.theme.PokedexTheme
import com.benidict.pokedex.utils.pokemonInformation
import java.util.Locale

@Composable
fun DetailsScreen(viewModel: DetailsViewModel, pokemonName: String, onBackPressed: () -> Unit) {
    var pokemonDetailsState by remember { mutableStateOf(PokemonDetailsDTO()) }
    var isDetailsSectionShow by remember { mutableStateOf(false) }
    LaunchedEffect(viewModel) {
        viewModel.loadPokemonDetails(pokemonName)
        viewModel.uiState.collect { state ->
            when (state) {
                UiState.onLoading -> {
                    Log.d("makerChecker", "loading state")
                }

                is UiState.onSuccess -> {
                    pokemonDetailsState = state.data
                    Log.d("makerChecker", "success state: ${state.data}")
                }

                is UiState.onError -> {
                    Log.d("makerChecker", "error state: ${state.error}")
                }
            }
        }
    }
    MainLayout(
        hasBackButton = true,
        hasTopBar = true,
        titleTopBar = stringResource(R.string.pokemon_info),
        onBackPressed = {
            onBackPressed()
        }) {
        Box(modifier = Modifier
            .padding(it)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
            if (pokemonDetailsState.name?.isNotEmpty() == true) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    PokemonDetailsCard(pokemonDetailsState) { isShow ->
                        isDetailsSectionShow = isShow
                    }
                    if (isDetailsSectionShow) {
                        TypewriterText(
                            pokemonInformation(pokemonDetailsState),
                            style = TextStyle(
                                fontWeight = FontWeight.Normal
                            ),
                            animSpeed = 50
                        )
                        HorizontalDivider(thickness = 2.dp)
                        Text(
                            text = stringResource(R.string.abilities).capitalize(Locale.ENGLISH),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        AbilityList(pokemonDetailsState.abilities ?: emptyList())
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    PokedexTheme {
        val viewModel = hiltViewModel<DetailsViewModel>()
        DetailsScreen(viewModel, "") {

        }
    }
}