package com.benidict.pokedex.component.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.benidict.pokedex.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
    hasBackButton: Boolean = false,
    hasTopBar: Boolean = false,
    hasBottomBar: Boolean = false,
    hasFloatingActionButton: Boolean = false,
    titleTopBar: String = "",
    onBackPressed: (() -> Unit) ?= null,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            if (hasTopBar) {
                CenterAlignedTopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(titleTopBar, fontWeight = FontWeight.Bold)
                    },
                    navigationIcon = {
                        if (hasBackButton) {
                            IconButton(onClick = { onBackPressed?.let { it() } }) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (hasBottomBar) {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Bottom app bar",
                    )
                }

            }
        },
        floatingActionButton = {
            if (hasFloatingActionButton) {
//                FloatingActionButton(onClick = { presses++ }) {
//                    Icon(Icons.Default.Add, contentDescription = "Add")
//                }
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}

@Composable
@Preview(showBackground = true)
fun MainLayoutPreview() {

}