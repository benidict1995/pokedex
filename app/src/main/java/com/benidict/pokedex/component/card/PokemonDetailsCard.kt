package com.benidict.pokedex.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.benidict.model.dto.PokemonDetailsDTO
import com.benidict.pokedex.component.image.PokemonImageProfile
import com.benidict.pokedex.component.text.TypewriterText
import java.util.Locale

@Composable
fun PokemonDetailsCard(pokemonDetailsDTO: PokemonDetailsDTO? = null) {
    val name = pokemonDetailsDTO?.name?.capitalize(Locale.US).orEmpty()
    val details = "Height: ${
        pokemonDetailsDTO?.height?.toString().orEmpty()
    }\nWeight: ${pokemonDetailsDTO?.weight?.toString().orEmpty()}"
    Row {
        Card {
            PokemonImageProfile(pokemonDetailsDTO?.sprites?.frontDefault.orEmpty())
        }
        Column(modifier = Modifier.padding(start = 4.dp)) {
            TypewriterText(name, fontWeight = FontWeight.Bold, fontSize = 24) {
                TypewriterText(details, mod = Modifier.padding(top = 4.dp), fontWeight = FontWeight.Medium, fontSize = 16)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsCardPreview() {
    MaterialTheme {
        PokemonDetailsCard()
    }
}