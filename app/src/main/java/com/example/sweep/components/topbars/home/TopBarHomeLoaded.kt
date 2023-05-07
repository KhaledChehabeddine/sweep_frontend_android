package com.example.sweep.components.topbars.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.sweep.data.notificationIcon

@Composable
fun TopBarHomeLoaded() {
  CenterAlignedTopAppBar(
    actions = {
      if (notificationIcon.badgeCount > 0) {
        IconButton(
          colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
          onClick = {
            /* TODO */
          }
        ) {
          BadgedBox(
            badge = {
              Badge()
            }
          ) {
            Icon(
              contentDescription = "Notifications",
              imageVector = Icons.Outlined.Notifications
            )
          }
        }
      } else {
        IconButton(
          colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
          onClick = {
            /* TODO */
          }
        ) {
          Icon(
            contentDescription = "Notifications",
            imageVector = Icons.Outlined.Notifications
          )
        }
      }
    },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.background),
    navigationIcon = {
      IconButton(
        colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
        onClick = {
          /* TODO */
        }
      ) {
        Icon(
          contentDescription = "Menu",
          imageVector = Icons.Outlined.Menu
        )
      }
    },
    title = { }
  )
}
