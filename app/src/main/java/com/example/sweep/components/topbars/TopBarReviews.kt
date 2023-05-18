package com.example.sweep.components.topbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.sweep.destinations.HomeDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarReviews(navigator: DestinationsNavigator) {
  CenterAlignedTopAppBar(
    actions = { },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
      containerColor = MaterialTheme.colorScheme.background
    ),
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
        style = MaterialTheme.typography.headlineLarge,
        text = "Reviews"
      )
    }
  )
}
