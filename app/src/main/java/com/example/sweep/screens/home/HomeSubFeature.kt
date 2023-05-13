package com.example.sweep.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sweep.components.BottomBar
import com.example.sweep.components.topbars.home.TopBarHomeSubFeature
import com.example.sweep.context.homeSubFeatureContext
import com.example.sweep.context.screens.home.HomeSubFeatureContext
import com.example.sweep.data.home.HomeSubFeature
import com.example.sweep.destinations.ServiceProviderDestination
import com.example.sweep.functions.svgS3UrlToPainter
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun HomeSubFeature(
  homeSubFeature: HomeSubFeature,
  navigator: DestinationsNavigator
) {
  val rememberHomeSubFeatureContext: HomeSubFeatureContext by remember {
    mutableStateOf(value = homeSubFeatureContext)
  }

  Scaffold(
    bottomBar = {
      BottomBar(
        currentPage = "home",
        navigator = navigator
      )
    },
    topBar = {
      TopBarHomeSubFeature(
        navigator = navigator,
        title = homeSubFeature.title
      )
    }
  ) { paddingValues ->
    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
    ) {
      LazyColumn {
        item {
          Text(
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 20.dp),
            style = MaterialTheme.typography.labelMedium,
            text = homeSubFeature.subtitle,
            textAlign = TextAlign.Center
          )
          rememberHomeSubFeatureContext.companyContextsById[homeSubFeature.id]!!.forEach { companyContext ->
            val rating = companyContext.company.serviceProvider.averageRating
            val ratingBoxColor: Color?
            val ratingContentColor: Color?
            if (rating >= 4.5f) {
              ratingBoxColor = MaterialTheme.colorScheme.surface
              ratingContentColor = MaterialTheme.colorScheme.surfaceVariant
            } else if (rating >= 3.0f) {
              ratingBoxColor = MaterialTheme.colorScheme.onPrimary
              ratingContentColor = MaterialTheme.colorScheme.primary
            } else if (rating > 0.0f) {
              ratingBoxColor = MaterialTheme.colorScheme.onError
              ratingContentColor = MaterialTheme.colorScheme.error
            } else {
              ratingBoxColor = MaterialTheme.colorScheme.inverseSurface
              ratingContentColor = MaterialTheme.colorScheme.inverseOnSurface
            }

            Column(
              modifier = Modifier
                .clickable(
                  indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                  interactionSource = remember {
                    MutableInteractionSource()
                  }
                ) {
                  navigator.navigate(
                    direction = ServiceProviderDestination(
                      companyContext = companyContext,
                      serviceProviderType = companyContext.company.serviceProvider.serviceProviderType,
                    )
                  )
                }
            ) {
              Column(modifier = Modifier.padding(all = 20.dp)) {
                Image(
                  contentDescription = companyContext.company.name,
                  modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 16f / 9f)
                    .clip(shape = MaterialTheme.shapes.small)
                    .background(color = MaterialTheme.colorScheme.secondaryContainer),
                  painter = svgS3UrlToPainter(url = companyContext.company.bannerImageUrl)
                )
                Spacer(modifier = Modifier.height(height = 10.dp))
                Text(
                  color = MaterialTheme.colorScheme.onSurface,
                  style = MaterialTheme.typography.titleMedium,
                  text = companyContext.company.name
                )
                Spacer(modifier = Modifier.height(height = 5.dp))
                Text(
                  color = MaterialTheme.colorScheme.onSurface,
                  style = MaterialTheme.typography.labelMedium,
                  text = companyContext.company.serviceProvider.serviceProviderType
                    .replaceFirstChar(Char::uppercase)
                )
                Spacer(modifier = Modifier.height(height = 10.dp))
                Box(
                  contentAlignment = Alignment.Center,
                  modifier = Modifier
                    .height(height = 25.dp)
                    .width(width = 65.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(color = ratingBoxColor)
                ) {
                  Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Icon(
                      contentDescription = "Star",
                      imageVector = Icons.Default.Star,
                      modifier = Modifier.size(size = 20.dp),
                      tint = ratingContentColor,
                    )
                    Spacer(modifier = Modifier.width(width = 5.dp))
                    Text(
                      color = ratingContentColor,
                      style = MaterialTheme.typography.displayMedium,
                      text = companyContext.company.serviceProvider.averageRating.toString()
                    )
                  }
                }
              }
            }
          }
          rememberHomeSubFeatureContext.workerContextsById[homeSubFeature.id]!!.forEach { workerContext ->
            val rating = workerContext.worker.serviceProvider.averageRating
            val ratingBoxColor: Color?
            val ratingContentColor: Color?
            if (rating >= 4.5f) {
              ratingBoxColor = MaterialTheme.colorScheme.surface
              ratingContentColor = MaterialTheme.colorScheme.surfaceVariant
            } else if (rating >= 3.0f) {
              ratingBoxColor = MaterialTheme.colorScheme.onPrimary
              ratingContentColor = MaterialTheme.colorScheme.primary
            } else if (rating > 0.0f) {
              ratingBoxColor = MaterialTheme.colorScheme.onError
              ratingContentColor = MaterialTheme.colorScheme.error
            } else {
              ratingBoxColor = MaterialTheme.colorScheme.inverseSurface
              ratingContentColor = MaterialTheme.colorScheme.inverseOnSurface
            }

            Column(
              modifier = Modifier
                .clickable(
                  indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                  interactionSource = remember {
                    MutableInteractionSource()
                  }
                ) {
                  navigator.navigate(
                    direction = ServiceProviderDestination(
                      serviceProviderType = workerContext.worker.serviceProvider.serviceProviderType,
                      workerContext = workerContext
                    )
                  )
                }
            ) {
              Column(modifier = Modifier.padding(all = 20.dp)) {
                Image(
                  contentDescription = workerContext.worker.metadata.formattedName,
                  modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 16f / 9f)
                    .clip(shape = MaterialTheme.shapes.small)
                    .background(color = MaterialTheme.colorScheme.secondaryContainer),
                  painter = svgS3UrlToPainter(url = workerContext.worker.bannerImageUrl)
                )
                Spacer(modifier = Modifier.height(height = 10.dp))
                Text(
                  color = MaterialTheme.colorScheme.onSurface,
                  style = MaterialTheme.typography.titleMedium,
                  text = workerContext.worker.metadata.formattedName
                )
                Spacer(modifier = Modifier.height(height = 5.dp))
                Text(
                  color = MaterialTheme.colorScheme.onSurface,
                  style = MaterialTheme.typography.labelMedium,
                  text = workerContext.worker.serviceProvider.serviceProviderType
                    .replaceFirstChar(Char::uppercase)
                )
                Spacer(modifier = Modifier.height(height = 10.dp))
                Box(
                  contentAlignment = Alignment.Center,
                  modifier = Modifier
                    .height(height = 25.dp)
                    .width(width = 65.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(color = ratingBoxColor)
                ) {
                  Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Icon(
                      contentDescription = "Star",
                      imageVector = Icons.Default.Star,
                      modifier = Modifier.size(size = 20.dp),
                      tint = ratingContentColor,
                    )
                    Spacer(modifier = Modifier.width(width = 5.dp))
                    Text(
                      color = ratingContentColor,
                      style = MaterialTheme.typography.displayMedium,
                      text = workerContext.worker.serviceProvider.averageRating.toString()
                    )
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
