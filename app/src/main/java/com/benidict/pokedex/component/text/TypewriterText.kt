package com.benidict.pokedex.component.text

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(
    text: String,
    mod: Modifier = Modifier.padding(top = 0.dp),
    style: TextStyle = TextStyle(
        fontSize = TextUnit.Unspecified,
        fontWeight = FontWeight.Normal
    ),
    animSpeed: Long = 160L,
    displayDone: @Composable (() -> Unit)?= null
) {
    var textToDisplay by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = text) {
        for (i in text.toCharArray()) {
            textToDisplay += i.toString()
            delay(animSpeed)
        }
    }


    Text(
        modifier = mod,
        text = textToDisplay,
        style = style
    )

    displayDone?.let { done ->
        if (textToDisplay == text) {
            done()
        }
    }
}