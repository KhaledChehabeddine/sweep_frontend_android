package com.example.sweep.components.topbars.account

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSupport() {
  CenterAlignedTopAppBar(
    actions = { },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
      containerColor = MaterialTheme.colorScheme.background
    ),

    navigationIcon = {
      IconButton(onClick = { /*TODO*/ }) {
        Icon(
          modifier = Modifier
            .padding(10.dp),
          imageVector = Icons.Default.ArrowBack,
          contentDescription = "Back Icon",
          tint = MaterialTheme.colorScheme.onSecondary
        )
      }
    },
    title = {
      Text(
        style = MaterialTheme.typography.headlineLarge,
        text = "Support"
      )
    }
  )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    TopBarSupport()
  }
}
