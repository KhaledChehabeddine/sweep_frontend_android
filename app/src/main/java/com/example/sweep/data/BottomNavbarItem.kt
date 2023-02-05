package com.example.sweep.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavbarItem(
    val icon: ImageVector,
    val name: String,
    val route: String
)

val bottomNavbarItems = listOf(
    BottomNavbarItem(
        icon = Icons.Outlined.Home,
        name = "Home",
        route = "home"
    ),
    BottomNavbarItem(
        icon = Icons.Outlined.Search,
        name = "Search",
        route = "search"
    ),
    BottomNavbarItem(
        icon = Icons.Outlined.Home,
        name = "Sweep",
        route = "sweep"
    ),
    BottomNavbarItem(
        icon = Icons.Outlined.History,
        name = "History",
        route = "history"
    ),
    BottomNavbarItem(
        icon = Icons.Outlined.AccountCircle,
        name = "Account",
        route = "account"
    )
)