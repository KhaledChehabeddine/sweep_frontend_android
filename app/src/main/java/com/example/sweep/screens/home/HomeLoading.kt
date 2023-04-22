package com.example.sweep.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.components.loading.ServiceCategoryGridLoading
import com.example.sweep.ui.theme.SweepTheme
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun HomeLoading(paddingValues: PaddingValues) {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues = paddingValues)
  ) {
    LazyColumn(
      horizontalAlignment = Alignment.CenterHorizontally,
      userScrollEnabled = false
    ) {
      item {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onBackground)
            .padding(all = 20.dp)
        ) {
          Row {
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 16f / 9f)
                .placeholder(
                  color = MaterialTheme.colorScheme.secondaryContainer,
                  highlight = PlaceholderHighlight.shimmer(),
                  shape = MaterialTheme.shapes.medium,
                  visible = true
                )
            )
          }
          Row(modifier = Modifier.padding(top = 20.dp)) {
            ServiceCategoryGridLoading()
          }
        }
        Spacer(modifier = Modifier.height(height = 20.dp))
        Column(
          modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onBackground)
            .fillMaxWidth()
            .padding(start = 20.dp)
        ) {
          repeat(times = 2) {
            Column {
              Column(modifier = Modifier.padding(end = 20.dp)) {
                Row(
                  modifier = Modifier
                    .padding(
                      bottom = 10.dp,
                      top = 20.dp
                    )
                ) {
                  Box(
                    modifier = Modifier
                      .height(height = 26.dp)
                      .fillMaxWidth(fraction = 0.60f)
                      .placeholder(
                        color = MaterialTheme.colorScheme.tertiary,
                        highlight = PlaceholderHighlight.shimmer(),
                        shape = MaterialTheme.shapes.extraLarge,
                        visible = true
                      )
                  )
                }
                Row(modifier = Modifier.padding(bottom = 20.dp)) {
                  Box(
                    modifier = Modifier
                      .height(height = 14.dp)
                      .fillMaxWidth()
                      .placeholder(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        highlight = PlaceholderHighlight.shimmer(),
                        shape = MaterialTheme.shapes.extraLarge,
                        visible = true
                      )
                  )
                }
              }
              LazyRow(userScrollEnabled = false) {
                item {
                  repeat(times = 3) {
                    Box(
                      modifier = Modifier
                        .height(height = 150.dp)
                        .aspectRatio(ratio = 16f / 9f)
                        .padding(end = 20.dp)
                        .placeholder(
                          color = MaterialTheme.colorScheme.secondaryContainer,
                          highlight = PlaceholderHighlight.shimmer(),
                          shape = MaterialTheme.shapes.medium,
                          visible = true
                        )
                    )
                  }
                }
              }
              Spacer(modifier = Modifier.height(height = 20.dp))
            }
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
    HomeLoading(paddingValues = PaddingValues())
  }
}
