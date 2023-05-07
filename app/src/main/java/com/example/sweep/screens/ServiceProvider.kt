package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.components.BottomBar
import com.example.sweep.ui.theme.SweepTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ServiceProvider(
  navigator: DestinationsNavigator,
  serviceProviderId: String,
  serviceProviderType: String
) {
  Scaffold(
    bottomBar = {
      BottomBar(
        currentPage = "home",
        navigator = navigator
      )
    },
    topBar = { }
  ) { paddingValues ->
    ServiceProviderScreen(
      navigator = navigator,
      paddingValues = paddingValues
    )
  }
}

@Composable
private fun ServiceProviderScreen(
  navigator: DestinationsNavigator,
  paddingValues: PaddingValues
) {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues = paddingValues)
  ) {
    LazyColumn {
      item {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(ratio = 16f / 9f)
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .padding(all = 10.dp)
        ) {
          IconButton(
            colors = IconButtonDefaults.iconButtonColors(
              containerColor = MaterialTheme.colorScheme.onBackground,
              contentColor = MaterialTheme.colorScheme.onSurface
            ),
            onClick = {
              navigator.popBackStack()
            }
          ) {
            Icon(
              contentDescription = "Back",
              imageVector = Icons.Outlined.ArrowBackIos
            )
          }
        }
        Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)) {
          Column(modifier = Modifier.padding(all = 20.dp)) {
            Box(
              modifier = Modifier
                .height(height = 22.dp)
                .fillMaxWidth(fraction = 0.5f)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
            )
            Spacer(modifier = Modifier.height(height = 5.dp))
            Box(
              modifier = Modifier
                .height(height = 22.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium)
                .background(color = MaterialTheme.colorScheme.onTertiaryContainer)
            )
          }
          Divider()
          Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
              .fillMaxWidth()
              .padding(all = 20.dp),
          ) {
            Column {
              Row {
                Box(
                  modifier = Modifier
                    .height(height = 52.dp)
                    .width(width = 78.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
                    .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                )
                Spacer(modifier = Modifier.width(width = 10.dp))
                Column {
                  Row {
                    repeat(times = 4) {
                      Icon(
                        contentDescription = "Star",
                        imageVector = Icons.Outlined.Star,
                        tint = MaterialTheme.colorScheme.surfaceVariant
                      )
                    }
                    Icon(
                      contentDescription = "Star",
                      imageVector = Icons.Outlined.Star,
                      tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                  }
                  Spacer(modifier = Modifier.height(height = 5.dp))
                  Row {
                    Box(
                      modifier = Modifier
                        .height(height = 16.dp)
                        .width(width = 70.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                        .background(color = MaterialTheme.colorScheme.onTertiaryContainer)
                    )
                  }
                }
              }
            }
            IconButton(
              colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
              onClick = {
                /*TODO*/
              }
            ) {
              Icon(
                contentDescription = "Forward",
                imageVector = Icons.Outlined.ArrowForwardIos
              )
            }
          }
          Divider()
          LazyRow(modifier = Modifier.padding(all = 20.dp)) {
            item {
              repeat(times = 5) {
                Box(
                  modifier = Modifier
                    .height(height = 30.dp)
                    .width(width = 85.dp)
                    .clip(shape = MaterialTheme.shapes.small)
                    .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
                )
                Spacer(modifier = Modifier.width(width = 10.dp))
              }
            }
          }
        }
        Spacer(modifier = Modifier.height(height = 20.dp))
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.onBackground)
        ) {
          repeat(times = 2) {
            Row(modifier = Modifier.padding(all = 20.dp)) {
              Box(
                modifier = Modifier
                  .height(height = 22.dp)
                  .fillMaxWidth(fraction = 0.5f)
                  .clip(shape = MaterialTheme.shapes.medium)
                  .background(color = MaterialTheme.colorScheme.inverseOnSurface)
              )
            }
            Divider()
            repeat(times = 3) {
              Row(modifier = Modifier.padding(all = 20.dp)) {
                Column(modifier = Modifier.weight(weight = 0.60f)) {
                  Box(
                    modifier = Modifier
                      .height(height = 20.dp)
                      .fillMaxWidth()
                      .clip(shape = MaterialTheme.shapes.medium)
                      .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                  )
                  Spacer(modifier = Modifier.height(height = 10.dp))
                  Box(
                    modifier = Modifier
                      .height(height = 16.dp)
                      .fillMaxWidth(fraction = 0.85f)
                      .clip(shape = MaterialTheme.shapes.medium)
                      .background(color = MaterialTheme.colorScheme.onTertiaryContainer)
                  )
                }
                Spacer(modifier = Modifier.width(width = 10.dp))
                Column(modifier = Modifier.weight(weight = 0.40f)) {
                  Box(
                    modifier = Modifier
                      .fillMaxWidth()
                      .aspectRatio(ratio = 16f / 9f)
                      .clip(shape = MaterialTheme.shapes.small)
                      .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                  )
                }
              }
            }
          }
        }
      }
    }
//    Image(
//      contentDescription = workerContext.worker.metadata.formattedName,
//      modifier = Modifier
//        .fillMaxWidth()
//        .aspectRatio(ratio = 16f / 9f)
//        .clip(shape = MaterialTheme.shapes.small)
//        .background(color = MaterialTheme.colorScheme.secondaryContainer),
//      painter = svgS3UrlToPainter(url = workerContext.worker.bannerImageUrl)
//    )
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
//    ServiceProviderScreen(paddingValues = PaddingValues())
  }
}
