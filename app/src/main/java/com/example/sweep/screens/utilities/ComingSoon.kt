package com.example.sweep.screens.utilities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Handyman
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.components.BottomBar
import com.example.sweep.ui.theme.SweepTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ComingSoon(navigator: DestinationsNavigator) {
  Scaffold(
    bottomBar = {
      BottomBar(
        currentPage = "account",
        navigator = navigator,
      )
    },
  ) { paddingValues ->
    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize(),
    ) {
      BoxWithConstraints(
        contentAlignment = Alignment.Center,
      ) {
        Column() {
          Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
              .fillMaxWidth()
              .padding(all = 20.dp)
              .clip(MaterialTheme.shapes.small)
              .background(color = MaterialTheme.colorScheme.onBackground)
          ) {
            Column(
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.spacedBy(20.dp),
              modifier = Modifier
                .padding(all = 10.dp),
            ) {
              Icon(
                imageVector = Icons.Default.Handyman,
                contentDescription = "Build Icon",
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                  .size(100.dp)
              )

              Text(
                text = "Coming Soon",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.tertiary,
              )
              Text(
                text = "This page is under construction",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary,
              )

              MyButton(
                onClick = {
                  navigator.popBackStack()
                }
              )
            }
          }
        }
      }
    }
  }
}

@Composable
fun MyButton(onClick: () -> Unit) {
  Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
      containerColor = MaterialTheme.colorScheme.onSecondary,
    ),
    shape = MaterialTheme.shapes.small,
    modifier = Modifier
      .height(40.dp)
  ) {
    Text(text = "Return", color = MaterialTheme.colorScheme.onBackground)
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
//    ComingSoon()
  }
}
