package com.example.sweep.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.screens.AccountScreen
import com.example.sweep.screens.HomeScreen
import com.example.sweep.screens.SearchScreen
import com.example.sweep.screens.SweepScreen
import com.example.sweep.screens.history.HistoryScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalPagerApi::class)
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
      HomeScreen(paddingValues = paddingValues)
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
      AccountScreen(paddingValues = paddingValues)
    }
  }
}
