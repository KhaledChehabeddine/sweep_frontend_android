package com.example.sweep.utilities.topbars

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.ui.theme.SweepTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarAccount() {
    CenterAlignedTopAppBar(
        actions = { },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = { },
        title = {
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = "Jamil Shoujah"
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        TopBarAccount()
    }
}
