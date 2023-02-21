package com.example.sweep.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.screens.*
import com.example.sweep.screens.history.HistoryScreen
import com.example.sweep.screens.history.tabs.PastReservations

@Composable
fun Content(
    navController: NavHostController,
    paddingValues: PaddingValues = PaddingValues(),
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(paddingValues = paddingValues)
        }
        composable(route = "search") {
            SearchScreen(paddingValues = paddingValues)
        }
        composable(route = "sweep") {
            SweepScreen(paddingValues = paddingValues)
        }
        composable(route = "history") {
            HistoryScreen(paddingValues = paddingValues)
        }
        composable(route = "account") {
            AccountScreen(paddingValues = paddingValues)
        }
    }
}