package com.example.sweep.screens.account.subpages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun Support() {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier
      .fillMaxSize(),
  ) {
    BoxWithConstraints {
      Column() {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(
              top = 0.dp,
              start = 20.dp,
              end = 20.dp,
              bottom = 20.dp,
            )
            .clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.onBackground)
        ) {
          Column {
            for (i in 0..5) {
              SupportSection()
              Divider()
            }
            SupportSection()
          }
        }
      }
    }
  }
}

@Composable
fun SupportSection() {
  Row(
    modifier = Modifier
      .padding(all = 10.dp)
      .height(height = 50.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      modifier = Modifier
        .size(size = 24.dp)
        .placeholder(
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          highlight = PlaceholderHighlight.shimmer(),
          visible = true
        )
    )
    Box(
      modifier = Modifier
        .height(height = 14.dp)
        .fillMaxWidth(fraction = 0.5f)
        .padding(start = 10.dp)
        .placeholder(
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          highlight = PlaceholderHighlight.shimmer(),
          visible = true
        )
    )
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    Support()
  }
}
