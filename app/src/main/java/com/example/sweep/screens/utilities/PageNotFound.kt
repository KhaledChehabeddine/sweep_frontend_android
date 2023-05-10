package com.example.sweep.screens.utilities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun Page(navigator: DestinationsNavigator) {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier
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
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
              .padding(all = 10.dp),
          ) {
            Icon(
              imageVector = Icons.Default.Warning,
              contentDescription = "Build Icon",
              tint = MaterialTheme.colorScheme.error,
              modifier = Modifier
                .size(100.dp)
                .padding(20.dp)
            )

            Text(
              text = "404",
              style = MaterialTheme.typography.displayLarge,
              color = MaterialTheme.colorScheme.tertiary,
            )
            Text(
              text = "Page not found",
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

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
//    Page()
  }
}
