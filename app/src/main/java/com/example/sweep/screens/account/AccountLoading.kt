package com.example.sweep.screens.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
fun AccountLoading(paddingValues: PaddingValues) {
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
        Row {
          BoxWithConstraints {
            Box(
              modifier = Modifier
                .height(height = maxHeight)
                .fillMaxWidth()
                .padding(all = 20.dp)
                .clip(MaterialTheme.shapes.small)
                .background(color = MaterialTheme.colorScheme.onBackground)
            ) {
              Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
                  )
              ) {
                repeat(times = 4) {
                  Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                  ) {
                    Row {
                      Box(
                        modifier = Modifier
                          .size(size = 60.dp)
                          .placeholder(
                            color = MaterialTheme.colorScheme.background,
                            highlight = PlaceholderHighlight.shimmer(),
                            visible = true
                          )
                      )
                    }
                    Row(modifier = Modifier.padding(top = 5.dp)) {
                      Box(
                        modifier = Modifier
                          .size(
                            height = 14.dp,
                            width = 60.dp
                          )
                          .placeholder(
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            highlight = PlaceholderHighlight.shimmer(),
                            visible = true
                          )
                      )
                    }
                  }
                }
              }
            }
          }
        }
        repeat(times = 3) { index ->
          Row {
            BoxWithConstraints {
              Box(
                modifier = Modifier
                  .height(height = maxHeight)
                  .fillMaxWidth()
                  .padding(all = 20.dp)
                  .clip(MaterialTheme.shapes.small)
                  .background(color = MaterialTheme.colorScheme.onBackground)
              ) {
                Column(modifier = Modifier.padding(all = 20.dp)) {
                  Row {
                    Box(
                      modifier = Modifier
                        .height(height = 16.dp)
                        .fillMaxWidth(fraction = 0.5f)
                        .placeholder(
                          color = MaterialTheme.colorScheme.onSurfaceVariant,
                          highlight = PlaceholderHighlight.shimmer(),
                          visible = true
                        )
                    )
                  }
                  Spacer(modifier = Modifier.height(height = 5.dp))
                  SubCategory(times = if (index == 0) 4 else 3)
                }
              }
            }
          }
        }
      }
    }
  }
}

@Composable
private fun SubCategory(times: Int) {
  repeat(times = times) { index ->
    Row(modifier = Modifier.fillMaxWidth()) {
      Row(
        modifier = Modifier.padding(vertical = 10.dp),
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
    if (index != times - 1) Divider()
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    AccountLoading(paddingValues = PaddingValues())
  }
}
