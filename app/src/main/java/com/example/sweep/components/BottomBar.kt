package com.example.sweep.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.sweep.R.drawable.ic_sweep_logo
import com.example.sweep.screens.destinations.HomeDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun BottomBar(
  currentPage: String,
  navigator: DestinationsNavigator
) {
  NavigationBar(containerColor = MaterialTheme.colorScheme.background) {
    NavigationBarItem(
      colors = NavigationBarItemDefaults.colors(unselectedTextColor = MaterialTheme.colorScheme.onSurface),
      icon = {
        Icon(
          contentDescription = "Home",
          imageVector = Icons.Outlined.Home
        )
      },
      label = {
        Text(
          style = MaterialTheme.typography.bodySmall,
          text = "Home"
        )
      },
      onClick = {
        navigator.navigate(direction = HomeDestination())
      },
      selected = currentPage == "home",
    )
    NavigationBarItem(
      colors = NavigationBarItemDefaults.colors(unselectedTextColor = MaterialTheme.colorScheme.onSurface),
      icon = {
        Icon(
          contentDescription = "Search",
          imageVector = Icons.Outlined.Search
        )
      },
      label = {
        Text(
          style = MaterialTheme.typography.bodySmall,
          text = "Search"
        )
      },
      onClick = {
        /* TODO */
      },
      selected = currentPage == "search",
    )
    NavigationBarItem(
      colors = NavigationBarItemDefaults.colors(unselectedTextColor = MaterialTheme.colorScheme.onSurface),
      icon = {
        Icon(
          contentDescription = "Sweep",
          painter = painterResource(id = ic_sweep_logo),
        )
      },
      label = {
        Text(
          style = MaterialTheme.typography.bodySmall,
          text = "Search"
        )
      },
      onClick = {
        /* TODO */
      },
      selected = currentPage == "sweep",
    )
    NavigationBarItem(
      colors = NavigationBarItemDefaults.colors(unselectedTextColor = MaterialTheme.colorScheme.onSurface),
      icon = {
        Icon(
          contentDescription = "History",
          imageVector = Icons.Outlined.History
        )
      },
      label = {
        Text(
          style = MaterialTheme.typography.bodySmall,
          text = "History"
        )
      },
      onClick = {
        /* TODO */
      },
      selected = currentPage == "history",
    )
    NavigationBarItem(
      colors = NavigationBarItemDefaults.colors(unselectedTextColor = MaterialTheme.colorScheme.onSurface),
      icon = {
        Icon(
          contentDescription = "Account",
          imageVector = Icons.Outlined.AccountCircle
        )
      },
      label = {
        Text(
          style = MaterialTheme.typography.bodySmall,
          text = "Account"
        )
      },
      onClick = {
        /* TODO */
      },
      selected = currentPage == "account",
    )
  }
}
