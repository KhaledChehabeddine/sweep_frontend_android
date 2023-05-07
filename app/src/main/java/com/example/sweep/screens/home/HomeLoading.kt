package com.example.sweep.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sweep.components.loading.BottomBarLoading
import com.example.sweep.components.loading.ServiceCategoryGridLoading
import com.example.sweep.components.topbars.home.TopBarHomeLoading
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun HomeLoading() {
  Scaffold(
    bottomBar = {
      BottomBarLoading(currentPage = "home")
    },
    topBar = {
      TopBarHomeLoading()
    }
  ) { paddingValues ->
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
            Spacer(modifier = Modifier.height(height = 20.dp))
            ServiceCategoryGridLoading()
          }
          Spacer(modifier = Modifier.height(height = 20.dp))
          Column(
            modifier = Modifier
              .background(color = MaterialTheme.colorScheme.onBackground)
              .padding(horizontal = 20.dp)
              .fillMaxWidth()
          ) {
            repeat(times = 2) {
              Spacer(modifier = Modifier.height(height = 20.dp))
              Box(
                modifier = Modifier
                  .height(height = 22.dp)
                  .fillMaxWidth(fraction = 0.60f)
                  .placeholder(
                    color = MaterialTheme.colorScheme.tertiary,
                    highlight = PlaceholderHighlight.shimmer(),
                    shape = MaterialTheme.shapes.extraLarge,
                    visible = true
                  )
              )
              Spacer(modifier = Modifier.height(height = 5.dp))
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
              Spacer(modifier = Modifier.height(height = 10.dp))
              LazyRow(userScrollEnabled = false) {
                item {
                  repeat(times = 2) {
                    Column(modifier = Modifier.width(width = 270.dp)) {
                      Box(
                        modifier = Modifier
                          .fillMaxWidth()
                          .aspectRatio(ratio = 16f / 9f)
                          .placeholder(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            highlight = PlaceholderHighlight.shimmer(),
                            shape = MaterialTheme.shapes.small,
                            visible = true
                          )
                      )
                      Spacer(modifier = Modifier.height(height = 10.dp))
                      Box(
                        modifier = Modifier
                          .height(height = 20.dp)
                          .fillMaxWidth(fraction = 0.60f)
                          .placeholder(
                            color = MaterialTheme.colorScheme.tertiary,
                            highlight = PlaceholderHighlight.shimmer(),
                            shape = MaterialTheme.shapes.extraLarge,
                            visible = true
                          )
                      )
                      Spacer(modifier = Modifier.height(height = 5.dp))
                      Box(
                        modifier = Modifier
                          .height(height = 14.dp)
                          .fillMaxWidth(fraction = 0.30f)
                          .placeholder(
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            highlight = PlaceholderHighlight.shimmer(),
                            shape = MaterialTheme.shapes.extraLarge,
                            visible = true
                          )
                      )
                      Spacer(modifier = Modifier.height(height = 5.dp))
                      Box(
                        modifier = Modifier
                          .height(height = 25.dp)
                          .fillMaxWidth(fraction = 0.25f)
                          .placeholder(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            highlight = PlaceholderHighlight.shimmer(),
                            shape = MaterialTheme.shapes.small,
                            visible = true
                          )
                      )
                    }
                    Spacer(modifier = Modifier.width(width = 20.dp))
                  }
                }
              }
              Spacer(modifier = Modifier.height(height = 30.dp))
            }
          }
        }
      }
    }
  }
}
