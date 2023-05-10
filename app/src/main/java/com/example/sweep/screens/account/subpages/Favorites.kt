package com.example.sweep.screens.account.subpages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.components.BottomBar
import com.example.sweep.components.topbars.accountSubpages.TopBarFavorites
import com.example.sweep.ui.theme.SweepTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Favorites(navigator: DestinationsNavigator) {
  Scaffold(
    topBar = {
      TopBarFavorites(navigator = navigator)
    },
    bottomBar = {
      BottomBar(
        currentPage = "account",
        navigator = navigator,
      )
    },
  ) { paddingValues ->
    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
    ) {
      Column() {
        LazyColumn() {
          items(10) {
            FavoritesPage()
          }
        }
      }
    }
  }
}

@Composable
fun FavoritesPage() {
  BoxWithConstraints {
    Column() {
      Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
          .fillMaxWidth()
          .padding(
            top = 10.dp,
            bottom = 10.dp,
            start = 20.dp,
            end = 20.dp
          )
          .clip(MaterialTheme.shapes.small)
          .background(color = MaterialTheme.colorScheme.onBackground)
      ) {
        Column(
          modifier = Modifier
            .padding(all = 10.dp),
        ) {
          Box(
            modifier = Modifier
              .height(200.dp)
//              .padding(
//                top = 10.dp,
//                bottom = 10.dp,
//                start = 20.dp,
//                end = 20.dp
//              )
              .fillMaxWidth()
              .clip(MaterialTheme.shapes.small)
              .background(
                color = MaterialTheme.colorScheme.secondaryContainer
              )
              .clickable(
                indication = rememberRipple(
                  color = MaterialTheme.colorScheme
                    .onSecondaryContainer
                ),
                interactionSource = remember {
                  MutableInteractionSource()
                }
              ) {
              }
          )
          Row(
            modifier = Modifier
              .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
          ) {
            SupportSection()
            Icon(
              imageVector = Icons.Default.Favorite,
              contentDescription = "favorite Icon",
              tint = MaterialTheme.colorScheme.onSecondary,
              modifier = Modifier
                .size(30.dp)
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
private fun Preview() {
  SweepTheme {
//    Favorites()
  }
}
