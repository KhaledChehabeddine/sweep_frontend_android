package com.example.sweep.components.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun ServiceCategoryGridLoading() {
  LazyVerticalGrid(
    columns = GridCells.Fixed(count = 4),
    horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
    modifier = Modifier.height(height = 210.dp),
    userScrollEnabled = false,
    verticalArrangement = Arrangement.spacedBy(space = 10.dp)
  ) {
    items(count = 8) {
      Box(
        modifier = Modifier
          .height(height = 100.dp)
          .placeholder(
            color = MaterialTheme.colorScheme.secondaryContainer,
            highlight = PlaceholderHighlight.shimmer(),
            visible = true
          )
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    ServiceCategoryGridLoading()
  }
}
