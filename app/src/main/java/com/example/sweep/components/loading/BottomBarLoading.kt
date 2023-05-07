package com.example.sweep.components.loading

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.sweep.R

@Composable
fun BottomBarLoading(currentPage: String) {
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
        /* TODO */
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
          painter = painterResource(id = R.drawable.ic_sweep_logo),
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
