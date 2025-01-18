package com.benidict.pokedex.navigation.route

import kotlinx.serialization.Serializable

@Serializable
object LandingRoute

@Serializable
object DashBoardRoute

@Serializable
object HomeRoute

@Serializable
object SearchRoute

@Serializable
data class PokemonDetailsRoute(
    val name: String
)