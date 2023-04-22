package com.example.sweep.components.topbars

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.data.historyTabItems
import com.example.sweep.ui.theme.SweepTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TopBarHistory(pagerState: PagerState = rememberPagerState()) {
  CenterAlignedTopAppBar(
    actions = { },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
      containerColor = MaterialTheme.colorScheme.background
    ),
    navigationIcon = { },
    title = {
      val coroutineScope = rememberCoroutineScope()
      TabRow(
        containerColor = MaterialTheme.colorScheme.background,
        selectedTabIndex = pagerState.currentPage
      ) {
        historyTabItems.forEachIndexed { index, historyTabItem ->
          Tab(
            onClick = {
              coroutineScope.launch {
                pagerState.animateScrollToPage(index)
              }
            },
            text = {
              Text(
                style = MaterialTheme.typography.titleMedium,
                text = historyTabItem.name
              )
            },
            selected = pagerState.currentPage == index,
            unselectedContentColor = MaterialTheme.colorScheme.onSurface
          )
        }
      }
    }
  )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    TopBarHistory(pagerState = rememberPagerState())
  }
}
