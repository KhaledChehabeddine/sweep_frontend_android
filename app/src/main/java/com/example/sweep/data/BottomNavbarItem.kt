package com.example.sweep.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavbarItem(
    val icon: ImageVector? = null,
    val id: Int? = null,
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
        id = com.example.sweep.R.drawable.ic_launcher_sweep_logo,
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
