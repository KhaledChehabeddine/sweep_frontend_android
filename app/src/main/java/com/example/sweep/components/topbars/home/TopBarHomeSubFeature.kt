package com.example.sweep.components.topbars.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.sweep.screens.destinations.HomeDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun TopBarHomeSubFeature(
  navigator: DestinationsNavigator,
  title: String
) {
  CenterAlignedTopAppBar(
    actions = { },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.background),
    navigationIcon = {
      IconButton(
        colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
        onClick = {
          navigator.navigate(direction = HomeDestination())
        }
      ) {
        Icon(
          contentDescription = "Back",
          imageVector = Icons.Outlined.ArrowBackIos
        )
      }
    },
    title = {
      Text(
        color = MaterialTheme.colorScheme.onSurface,
        style = MaterialTheme.typography.bodyLarge,
        text = title
      )
    }
  )
}
