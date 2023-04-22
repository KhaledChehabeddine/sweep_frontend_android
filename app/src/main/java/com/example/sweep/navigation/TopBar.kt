package com.example.sweep.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.components.topbars.TopBarAccount
import com.example.sweep.components.topbars.TopBarHistory
import com.example.sweep.components.topbars.TopBarHome
import com.example.sweep.components.topbars.TopBarSweep
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopBar(
  navController: NavHostController,
  pagerState: PagerState = rememberPagerState(),
  systemUiController: SystemUiController = rememberSystemUiController()
) {
  NavHost(
    navController = navController,
    startDestination = "home"
  ) {
    composable(route = "home") {
      TopBarHome()
      systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.background)
    }
    composable(route = "search") {
      systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.background)
    }
    composable(route = "sweep") {
      TopBarSweep()
      systemUiController.setStatusBarColor(
        color = MaterialTheme.colorScheme.onSecondaryContainer
      )
    }
    composable(route = "history") {
      TopBarHistory(pagerState = pagerState)
      systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.background)
    }
    composable(route = "account") {
      TopBarAccount()
      systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.background)
    }
  }
}
