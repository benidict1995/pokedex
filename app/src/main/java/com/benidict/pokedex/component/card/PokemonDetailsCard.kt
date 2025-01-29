package com.benidict.pokedex.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benidict.model.dto.PokemonDetailsDTO
import com.benidict.pokedex.R
import com.benidict.pokedex.component.image.PokemonImageProfile
import com.benidict.pokedex.component.text.TypewriterText
import java.util.Locale

@Composable
fun PokemonDetailsCard(pokemonDetailsDTO: PokemonDetailsDTO? = null, isShow: (Boolean) -> Unit) {
    val name = pokemonDetailsDTO?.name?.capitalize(Locale.US).orEmpty()
    val details = "${stringResource(R.string.height)} ${
        pokemonDetailsDTO?.height?.toString().orEmpty()
    }\n${stringResource(R.string.weight)} ${pokemonDetailsDTO?.weight?.toString().orEmpty()}"
    Row {
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            PokemonImageProfile(pokemonDetailsDTO?.sprites?.frontDefault.orEmpty())
        }
        Column(modifier = Modifier.padding(start = 4.dp)) {
            TypewriterText(name, fontWeight = FontWeight.Bold, fontSize = 24.sp) {
                TypewriterText(
                    details,
                    mod = Modifier.padding(top = 4.dp),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                ) {
                    isShow(true)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsCardPreview() {
    MaterialTheme {
        PokemonDetailsCard {

        }
    }
}