package com.example.sweep.utilities.topbars

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.ui.theme.SweepTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSweep() {
  CenterAlignedTopAppBar(
    actions = { },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
      containerColor = MaterialTheme.colorScheme.onSecondaryContainer
    ),
    navigationIcon = { },
    title = {
      Text(
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineLarge,
        text = "Sweepers"
      )
    }
  )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    TopBarSweep()
  }
}
