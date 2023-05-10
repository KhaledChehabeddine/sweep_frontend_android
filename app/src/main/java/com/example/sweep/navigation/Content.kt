package com.example.sweep.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.screens.SearchScreen
import com.example.sweep.screens.SweepScreen
import com.example.sweep.screens.history.HistoryScreen
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Content(
  navController: NavHostController,
  paddingValues: PaddingValues = PaddingValues(),
  pagerState: PagerState = rememberPagerState(),
  systemUiController: SystemUiController = rememberSystemUiController()
) {
  NavHost(
    navController = navController,
    startDestination = "home"
  ) {
    composable(route = "home") {
//      Home()
    }
    composable(route = "search") {
      SearchScreen(systemUiController = systemUiController)
    }
    composable(route = "sweep") {
      SweepScreen(paddingValues = paddingValues)
    }
    composable(route = "history") {
      HistoryScreen(
        paddingValues = paddingValues,
        pagerState = pagerState
      )
    }
    composable(route = "account") {
//      Account(paddingValues = paddingValues)
    }
  }
}
