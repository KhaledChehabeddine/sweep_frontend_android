package com.example.sweep.utilities.topbars

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.data.historyTabItems
import com.example.sweep.ui.theme.SweepTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
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
                        unselectedContentColor = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        TopBarHistory(pagerState = rememberPagerState())
    }
}