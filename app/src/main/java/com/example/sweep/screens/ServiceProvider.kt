package com.example.sweep.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sweep.context.screens.user.CompanyContext
import com.example.sweep.context.screens.user.WorkerContext
import com.example.sweep.destinations.ServiceItemDestination
import com.example.sweep.functions.svgS3UrlToPainter
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ServiceProvider(
  companyContext: CompanyContext? = null,
  navigator: DestinationsNavigator,
  serviceProviderType: String,
  workerContext: WorkerContext? = null
) {
  Scaffold(
    bottomBar = { },
    topBar = { }
  ) { paddingValues ->
    if (serviceProviderType == "company") {
      CompanyScreen(
        companyContext = companyContext!!,
        navigator = navigator,
        paddingValues = paddingValues
      )
    } else {
      WorkerScreen(
        workerContext = workerContext!!,
        navigator = navigator,
        paddingValues = paddingValues
      )
    }
  }
}

@Composable
private fun CompanyScreen(
  companyContext: CompanyContext,
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
        Box {
          Image(
            contentDescription = companyContext.company.name,
            modifier = Modifier
              .fillMaxWidth()
              .aspectRatio(ratio = 16f / 9f)
              .background(color = MaterialTheme.colorScheme.secondaryContainer),
            painter = svgS3UrlToPainter(url = companyContext.company.bannerImageUrl)
          )
          Box(modifier = Modifier.padding(all = 10.dp)) {
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
          Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
              .fillMaxWidth()
              .aspectRatio(ratio = 16f / 9f)
          ) {
            Image(
              contentDescription = companyContext.company.name,
              modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(fraction = 0.20f)
                .aspectRatio(ratio = 1f)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.onBackground)
                .border(
                  color = MaterialTheme.colorScheme.onSurface,
                  shape = CircleShape,
                  width = 3.dp
                ),
              painter = svgS3UrlToPainter(url = companyContext.company.logoImageUrl)
            )
          }
        }
        Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)) {
          Column(modifier = Modifier.padding(all = 20.dp)) {
            Text(
              color = MaterialTheme.colorScheme.onSurface,
              style = MaterialTheme.typography.bodyLarge,
              text = companyContext.company.name
            )
            Spacer(modifier = Modifier.height(height = 10.dp))
            Text(
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              fontWeight = FontWeight.Normal,
              style = MaterialTheme.typography.headlineMedium,
              text = companyContext.company.serviceProvider.description
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
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  color = MaterialTheme.colorScheme.onSurface,
                  fontSize = 52.sp,
                  text = companyContext.company.serviceProvider.averageRating.toString()
                )
                Spacer(modifier = Modifier.width(width = 10.dp))
                Column {
                  val rating = companyContext.company.serviceProvider.averageRating
                  val ratingBoxColor: Color = if (rating >= 4.5f) {
                    MaterialTheme.colorScheme.surfaceVariant
                  } else if (rating >= 3.0f) {
                    MaterialTheme.colorScheme.primary
                  } else if (rating > 0.0f) {
                    MaterialTheme.colorScheme.error
                  } else {
                    MaterialTheme.colorScheme.inverseOnSurface
                  }

                  Row {
                    for (i in 1..companyContext.company.serviceProvider.averageRating.toInt()) {
                      Icon(
                        contentDescription = "Star",
                        imageVector = Icons.Outlined.Star,
                        tint = ratingBoxColor
                      )
                    }
                    for (i in 1..(5 - companyContext.company.serviceProvider.averageRating.toInt())) {
                      Icon(
                        contentDescription = "Star",
                        imageVector = Icons.Outlined.Star,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(height = 5.dp))
                  Row {
                    Text(
                      color = MaterialTheme.colorScheme.tertiary,
                      fontWeight = FontWeight.Normal,
                      style = MaterialTheme.typography.headlineMedium,
                      text = "Based on ${companyContext.company.serviceProvider.metadata.totalReviews} reviews"
                    )
                  }
                }
              }
            }
            IconButton(
              colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
              onClick = {
                /* TODO */
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
              for (category in companyContext.company.serviceProvider.categories) {
                BoxWithConstraints {
                  Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                      .height(height = maxHeight)
                      .width(width = maxWidth)
                      .clip(shape = MaterialTheme.shapes.small)
                      .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
                  ) {
                    Text(
                      color = MaterialTheme.colorScheme.onBackground,
                      fontWeight = FontWeight.Normal,
                      modifier = Modifier.padding(all = 10.dp),
                      style = MaterialTheme.typography.headlineMedium,
                      text = category.name
                    )
                  }
                }
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
          for (category in companyContext.company.serviceProvider.categories) {
            Row(modifier = Modifier.padding(all = 20.dp)) {
              Text(
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge,
                text = category.name
              )
            }
            Divider()
            for (serviceItem in category.serviceItems) {
              Row(
                modifier = Modifier
                  .clickable(
                    indication = rememberRipple(
                      color = MaterialTheme.colorScheme.onSecondaryContainer
                    ),
                    interactionSource = remember {
                      MutableInteractionSource()
                    }
                  ) {
                    navigator.navigate(direction = ServiceItemDestination(serviceItem = serviceItem))
                  }
                  .padding(all = 20.dp)
              ) {
                Column(modifier = Modifier.weight(weight = 0.60f)) {
                  Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                    text = serviceItem.name
                  )
                  Spacer(modifier = Modifier.height(height = 10.dp))
                  Text(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.headlineMedium,
                    text = serviceItem.description
                  )
                  Spacer(modifier = Modifier.height(height = 10.dp))
                  Text(
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.headlineMedium,
                    text = "%.2f $ / hour".format(serviceItem.price)
                  )
                }
                Spacer(modifier = Modifier.width(width = 10.dp))
                Column(modifier = Modifier.weight(weight = 0.40f)) {
                  Image(
                    contentDescription = serviceItem.name,
                    modifier = Modifier
                      .fillMaxWidth()
                      .aspectRatio(ratio = 16f / 9f)
                      .clip(shape = MaterialTheme.shapes.small)
                      .background(color = MaterialTheme.colorScheme.secondaryContainer),
                    painter = svgS3UrlToPainter(url = serviceItem.imageUrl)
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

@Composable
private fun WorkerScreen(
  workerContext: WorkerContext,
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
        Box {
          Image(
            contentDescription = workerContext.worker.metadata.formattedName,
            modifier = Modifier
              .fillMaxWidth()
              .aspectRatio(ratio = 16f / 9f)
              .background(color = MaterialTheme.colorScheme.secondaryContainer),
            painter = svgS3UrlToPainter(url = workerContext.worker.bannerImageUrl)
          )
          Box(modifier = Modifier.padding(all = 10.dp)) {
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
          Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
              .fillMaxWidth()
              .aspectRatio(ratio = 16f / 9f)
          ) {
            Image(
              contentDescription = workerContext.worker.metadata.formattedName,
              modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(fraction = 0.20f)
                .aspectRatio(ratio = 1f)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.onBackground)
                .border(
                  color = MaterialTheme.colorScheme.onSurface,
                  shape = CircleShape,
                  width = 3.dp
                ),
              painter = svgS3UrlToPainter(url = workerContext.worker.profileImageUrl)
            )
          }
        }
        Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)) {
          Column(modifier = Modifier.padding(all = 20.dp)) {
            Text(
              color = MaterialTheme.colorScheme.onSurface,
              style = MaterialTheme.typography.bodyLarge,
              text = workerContext.worker.metadata.formattedName
            )
            Spacer(modifier = Modifier.height(height = 10.dp))
            Text(
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              fontWeight = FontWeight.Normal,
              style = MaterialTheme.typography.headlineMedium,
              text = workerContext.worker.serviceProvider.description
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
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  color = MaterialTheme.colorScheme.onSurface,
                  fontSize = 52.sp,
                  text = workerContext.worker.serviceProvider.averageRating.toString()
                )
                Spacer(modifier = Modifier.width(width = 10.dp))
                Column {
                  val rating = workerContext.worker.serviceProvider.averageRating
                  val ratingBoxColor: Color = if (rating >= 4.5f) {
                    MaterialTheme.colorScheme.surfaceVariant
                  } else if (rating >= 3.0f) {
                    MaterialTheme.colorScheme.primary
                  } else if (rating > 0.0f) {
                    MaterialTheme.colorScheme.error
                  } else {
                    MaterialTheme.colorScheme.inverseOnSurface
                  }

                  Row {
                    for (i in 1..workerContext.worker.serviceProvider.averageRating.toInt()) {
                      Icon(
                        contentDescription = "Star",
                        imageVector = Icons.Outlined.Star,
                        tint = ratingBoxColor
                      )
                    }
                    for (i in 1..(5 - workerContext.worker.serviceProvider.averageRating.toInt())) {
                      Icon(
                        contentDescription = "Star",
                        imageVector = Icons.Outlined.Star,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(height = 5.dp))
                  Row {
                    Text(
                      color = MaterialTheme.colorScheme.tertiary,
                      fontWeight = FontWeight.Normal,
                      style = MaterialTheme.typography.headlineMedium,
                      text = "Based on ${workerContext.worker.serviceProvider.metadata.totalReviews} reviews"
                    )
                  }
                }
              }
            }
            IconButton(
              colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
              onClick = {
                /* TODO */
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
              for (category in workerContext.worker.serviceProvider.categories) {
                BoxWithConstraints {
                  Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                      .height(height = maxHeight)
                      .width(width = maxWidth)
                      .clip(shape = MaterialTheme.shapes.small)
                      .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
                  ) {
                    Text(
                      color = MaterialTheme.colorScheme.onBackground,
                      fontWeight = FontWeight.Normal,
                      modifier = Modifier.padding(all = 10.dp),
                      style = MaterialTheme.typography.headlineMedium,
                      text = category.name
                    )
                  }
                }
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
          for (category in workerContext.worker.serviceProvider.categories) {
            Row(modifier = Modifier.padding(all = 20.dp)) {
              Text(
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge,
                text = category.name
              )
            }
            Divider()
            for (serviceItem in category.serviceItems) {
              Row(
                modifier = Modifier
                  .clickable(
                    indication = rememberRipple(
                      color = MaterialTheme.colorScheme.onSecondaryContainer
                    ),
                    interactionSource = remember {
                      MutableInteractionSource()
                    }
                  ) {
                    navigator.navigate(direction = ServiceItemDestination(serviceItem = serviceItem))
                  }
                  .padding(all = 20.dp)
              ) {
                Column(modifier = Modifier.weight(weight = 0.60f)) {
                  Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                    text = serviceItem.name
                  )
                  Spacer(modifier = Modifier.height(height = 10.dp))
                  Text(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.headlineMedium,
                    text = serviceItem.description
                  )
                  Spacer(modifier = Modifier.height(height = 10.dp))
                  Text(
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.headlineMedium,
                    text = "%.2f $ / hour".format(serviceItem.price)
                  )
                }
                Spacer(modifier = Modifier.width(width = 10.dp))
                Column(modifier = Modifier.weight(weight = 0.40f)) {
                  Image(
                    contentDescription = serviceItem.name,
                    modifier = Modifier
                      .fillMaxWidth()
                      .aspectRatio(ratio = 16f / 9f)
                      .clip(shape = MaterialTheme.shapes.small)
                      .background(color = MaterialTheme.colorScheme.secondaryContainer),
                    painter = svgS3UrlToPainter(url = serviceItem.imageUrl)
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
