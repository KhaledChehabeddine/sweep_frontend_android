package com.example.sweep.utilities.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.screens.*
import com.example.sweep.utilities.topbars.TopBar

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues = PaddingValues(),
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(paddingValues)
        }
        composable(route = "search") {
            SearchScreen(paddingValues)
        }
        composable(route = "sweep") {
            SweepScreen(paddingValues)
        }
        composable(route = "history") {
            HistoryScreen(paddingValues)
        }
        composable(route = "account") {
            AccountScreen(paddingValues)
        }
    }
}

@Composable
fun NavigationTopBar(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            TopBar()
        }
        composable(route = "search") {
            TopBar()
//            SearchView()
        }
        composable(route = "sweep") {
            TopBar()

        }
        composable(route = "history") {
            TopBar()
        }
        composable(route = "account") {
            TopBar()
        }
    }
}