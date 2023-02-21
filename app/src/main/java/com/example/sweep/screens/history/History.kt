package com.example.sweep.screens.history

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.data.historyTabItems
import com.example.sweep.ui.theme.SweepTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HistoryScreen(paddingValues: PaddingValues) {
    val historyPagerState = rememberPagerState()

    HorizontalPager(
        count = historyTabItems.size,
        state = historyPagerState
    ) {
        historyTabItems[it].screen(paddingValues)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        HistoryScreen(paddingValues = PaddingValues())
    }
}