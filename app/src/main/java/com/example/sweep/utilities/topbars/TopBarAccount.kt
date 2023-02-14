package com.example.sweep.utilities.topbars

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun TopBarAccount() {
    CenterAlignedTopAppBar(
        actions = { },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
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