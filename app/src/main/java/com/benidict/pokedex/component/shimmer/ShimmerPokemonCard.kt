package com.benidict.pokedex.component.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerPokemonCard() {
    Column {
        repeat(6) {
            Spacer(modifier = Modifier.height(8.dp))
            ShimmerEffect(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(60.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray, RectangleShape),
                durationMillis = 1000
            )
        }
    }
}