package com.example.sweep.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.utilities.topbars.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopBar(
    navController: NavHostController,
    pagerState: PagerState = rememberPagerState()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            TopBarHome()
        }
        composable(route = "search") { }
        composable(route = "sweep") {
            TopBarSweep()
        }
        composable(route = "history") {
            TopBarHistory(pagerState = pagerState)
        }
        composable(route = "account") {
            TopBarAccount()
        }
    }
}