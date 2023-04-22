package com.example.sweep.screens.history

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.data.historyTabItems
import com.example.sweep.ui.theme.SweepTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HistoryScreen(
  paddingValues: PaddingValues,
  pagerState: PagerState = rememberPagerState()
) {
  HorizontalPager(
    pageCount = historyTabItems.size,
    state = pagerState
  ) {
    historyTabItems[it].screen(paddingValues)
  }
}

@Composable
fun DisplayHistoryTabItems() {
  Row(
    modifier = Modifier.fillMaxWidth()
      .background(MaterialTheme.colorScheme.onBackground)
      .clickable(
        indication = rememberRipple(
          color = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        interactionSource = remember {
          MutableInteractionSource()
        }
      ) {
      }.padding(all = 20.dp)
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.height(height = 95.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Box(
        modifier = Modifier.size(size = 80.dp)
          .clip(shape = CircleShape)
          .background(color = MaterialTheme.colorScheme.secondaryContainer)
      ) {
      }
      Box(
        modifier = Modifier.size(
          height = 10.dp,
          width = 20.dp
        )
          .clip(shape = CircleShape)
          .background(color = MaterialTheme.colorScheme.onTertiary)
      ) {
      }
    }
    Spacer(modifier = Modifier.padding(all = 5.dp))
    Column {
      Box(
        modifier = Modifier.size(
          height = 10.dp,
          width = 175.dp
        )
          .clip(shape = CircleShape)
          .background(color = MaterialTheme.colorScheme.secondary)
      ) {
      }
      Spacer(modifier = Modifier.height(height = 5.dp))
      Box(
        modifier = Modifier.height(height = 14.dp)
          .fillMaxWidth()
          .clip(shape = CircleShape)
          .background(color = MaterialTheme.colorScheme.onSurfaceVariant)
      ) {
      }
      Spacer(modifier = Modifier.height(height = 20.dp))
      for (j in 0..1) {
        if (j != 0) Spacer(modifier = Modifier.height(height = 5.dp))
        Box(
          modifier = Modifier.height(height = 12.dp)
            .fillMaxWidth()
            .clip(shape = CircleShape)
            .background(
              color = MaterialTheme.colorScheme.tertiaryContainer
            )
        ) {
        }
      }
      Spacer(modifier = Modifier.height(height = 5.dp))
      Box(
        modifier = Modifier.size(
          height = 12.dp,
          width = 100.dp
        )
          .clip(shape = CircleShape)
          .background(color = MaterialTheme.colorScheme.tertiaryContainer)
      ) {
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    HistoryScreen(
      pagerState = rememberPagerState(),
      paddingValues = PaddingValues()
    )
  }
}
