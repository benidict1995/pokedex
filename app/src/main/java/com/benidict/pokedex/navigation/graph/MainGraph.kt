package com.benidict.pokedex.navigation.graph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.benidict.pokedex.feature.details.DetailsScreen
import com.benidict.pokedex.feature.details.DetailsViewModel
import com.benidict.pokedex.feature.home.HomeScreen
import com.benidict.pokedex.feature.home.HomeViewModel
import com.benidict.pokedex.navigation.route.HomeRoute
import com.benidict.pokedex.navigation.route.PokemonDetailsRoute

@Composable
fun SetUpGraph(navController: NavHostController) {
    NavHost(navController, startDestination = HomeRoute) {
        composable<HomeRoute> {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel) { pokemonName ->
                navController.navigate(route = PokemonDetailsRoute(pokemonName))
            }
        }
        composable<PokemonDetailsRoute> { backStackEntry ->
            val pokemonName = backStackEntry.toRoute<PokemonDetailsRoute>()
            val viewModel = hiltViewModel<DetailsViewModel>()
            DetailsScreen(viewModel, pokemonName.name) {
                navController.popBackStack()
            }
        }
    }
}