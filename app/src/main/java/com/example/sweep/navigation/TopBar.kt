package com.example.sweep.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.utilities.topbars.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopBar(
    navController: NavHostController,
    pagerState: PagerState = rememberPagerState(),
    systemUiController: SystemUiController = rememberSystemUiController()
) {
//    val systemUiController = rememberSystemUiController()

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
            systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.onSecondaryContainer)
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