package com.benidict.pokedex.utils

import android.util.Log
import androidx.compose.ui.text.capitalize
import com.benidict.model.dto.PokemonDetailsDTO
import com.benidict.model.dto.TypeDTO
import java.util.Locale

fun pokemonInformation(pokemonDetailsDTO: PokemonDetailsDTO): String {
    return "${pokemonDetailsDTO.name?.capitalize(Locale.ENGLISH)} is a ${
        convertArrayOfStringToSlash(
            pokemonDetailsDTO.types ?: emptyList()
        )
    } type Pokemon."
}

private fun convertArrayOfStringToSlash(types: List<TypeDTO>): String {
    var typeDescription = ""
    types.forEach {
        typeDescription += "${it.type.name.capitalize(Locale.ENGLISH)}/"
    }
    return typeDescription.substring(0, typeDescription.length - 1)
}