package com.example.sweep.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sweep.screens.*
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
            HomeScreen(paddingValues)
        }
        composable(route = "search") {
            SearchScreen(paddingValues)
        }
        composable(route = "sweep") {
            SweepScreen(paddingValues)
        }
        composable(route = "history") {
            PastReservations(paddingValues)
        }
        composable(route = "account") {
            AccountScreen(paddingValues)
        }
    }
}