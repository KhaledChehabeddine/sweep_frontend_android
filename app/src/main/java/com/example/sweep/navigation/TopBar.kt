package com.example.sweep.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.utilities.topbars.*

@Composable
fun TopBar(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            TopBarHome()
        }
        composable(route = "search") {
            TopBarSearch()
        }
        composable(route = "sweep") {
            TopBarSweep()
        }
        composable(route = "history") {
            TopBarHistory()
        }
        composable(route = "account") {
            TopBarAccount()
        }
    }
}