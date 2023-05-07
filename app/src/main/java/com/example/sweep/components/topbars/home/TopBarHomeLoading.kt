package com.example.sweep.components.topbars.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.sweep.data.notificationIcon

@Composable
fun TopBarHomeLoading() {
  CenterAlignedTopAppBar(
    actions = {
      if (notificationIcon.badgeCount > 0) {
        BadgedBox(
          badge = {
            Badge()
          }
        ) {
          Icon(
            contentDescription = "Notifications",
            imageVector = Icons.Outlined.Notifications,
            tint = MaterialTheme.colorScheme.onSurface
          )
        }
      } else {
        Icon(
          contentDescription = "Notifications",
          imageVector = Icons.Outlined.Notifications,
          tint = MaterialTheme.colorScheme.onSurface
        )
      }
    },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.background),
    navigationIcon = {
      Icon(
        contentDescription = "Menu",
        imageVector = Icons.Outlined.Menu,
        tint = MaterialTheme.colorScheme.onSurface
      )
    },
    title = { }
  )
}
