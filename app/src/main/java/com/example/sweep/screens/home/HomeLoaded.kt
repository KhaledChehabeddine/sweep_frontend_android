package com.example.sweep.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.sweep.components.ServiceCategoryGrid
import com.example.sweep.context.components.ServiceCategoryContext
import com.example.sweep.context.screens.home.HomeMainFeaturePromotionContext
import com.example.sweep.context.screens.home.HomeMainFeatureRewardContext
import com.example.sweep.context.screens.home.HomeSubFeatureContext
import com.example.sweep.functions.svgS3UrlToPainter
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeLoaded(
  homeMainFeaturePromotionContext: HomeMainFeaturePromotionContext,
  homeMainFeatureRewardContext: HomeMainFeatureRewardContext,
  homeSubFeatureContext: HomeSubFeatureContext,
  paddingValues: PaddingValues,
  pagerState: PagerState,
  serviceCategoryContext: ServiceCategoryContext
) {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues = paddingValues)
  ) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
      item {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onBackground)
            .padding(all = 20.dp)
        ) {
          HorizontalPager(
            pageCount = homeMainFeaturePromotionContext.homeMainFeaturePromotions.size +
              homeMainFeatureRewardContext.homeMainFeatureRewards.size,
            state = pagerState
          ) { page ->
            Card(
              modifier = Modifier
                .graphicsLayer {
                  val pageOffset =
                    ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                  lerp(
                    fraction = 1f - pageOffset.coerceIn(0f, 1f),
                    start = 0.85f,
                    stop = 1f
                  ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                  }

                  alpha = lerp(
                    fraction = 1f - pageOffset.coerceIn(0f, 1f),
                    start = 0.5f,
                    stop = 1f
                  )
                }
            ) {
              Image(
                contentDescription =
                if (page < homeMainFeaturePromotionContext.homeMainFeaturePromotions.size) {
                  "Promotion"
                } else {
                  "Reward"
                },
                modifier = Modifier
                  .fillMaxWidth()
                  .aspectRatio(ratio = 16f / 9f)
                  .clip(MaterialTheme.shapes.medium)
                  .background(color = MaterialTheme.colorScheme.secondaryContainer)
                  .clickable(
                    indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                    interactionSource = remember {
                      MutableInteractionSource()
                    }
                  ) {
                    /* TODO */
                  },
                painter = svgS3UrlToPainter(
                  url =
                  if (page < homeMainFeaturePromotionContext.homeMainFeaturePromotions.size) {
                    homeMainFeaturePromotionContext.homeMainFeaturePromotions[page].homeMainFeature.imageUrl
                  } else {
                    homeMainFeatureRewardContext
                      .homeMainFeatureRewards[page - homeMainFeaturePromotionContext.homeMainFeaturePromotions.size]
                      .homeMainFeature
                      .imageUrl
                  }
                )
              )
            }
          }
          Spacer(modifier = Modifier.height(height = 20.dp))
          ServiceCategoryGrid(serviceCategories = serviceCategoryContext.serviceCategories)
        }
        Spacer(modifier = Modifier.height(height = 20.dp))
        Column(
          modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onBackground)
            .fillMaxWidth()
        ) {
          homeSubFeatureContext.homeSubFeatures.forEach { homeSubFeature ->
            Column(
              modifier = Modifier
                .clickable(
                  indication = rememberRipple(color = MaterialTheme.colorScheme.tertiary),
                  interactionSource = remember {
                    MutableInteractionSource()
                  }
                ) {
                  /* TODO */
                }
                .padding(start = 20.dp)
            ) {
              Column(modifier = Modifier.padding(end = 20.dp)) {
                Spacer(modifier = Modifier.height(height = 20.dp))
                Text(
                  color = MaterialTheme.colorScheme.onSurface,
                  style = MaterialTheme.typography.headlineLarge,
                  text = homeSubFeature.title
                )
                Spacer(modifier = Modifier.height(height = 5.dp))
                Text(
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.labelMedium,
                  text = homeSubFeature.subtitle
                )
              }
              Spacer(modifier = Modifier.height(height = 10.dp))
              LazyRow {
                item {
                  homeSubFeatureContext.companyContextsById[homeSubFeature.id]!!.forEach { companyContext ->
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

                    Column(modifier = Modifier.width(width = 270.dp)) {
                      Image(
                        contentDescription = companyContext.company.name,
                        modifier = Modifier
                          .fillMaxWidth()
                          .aspectRatio(ratio = 16f / 9f)
                          .clip(MaterialTheme.shapes.small)
                          .background(color = MaterialTheme.colorScheme.secondaryContainer)
                          .clickable(
                            indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                            interactionSource = remember {
                              MutableInteractionSource()
                            }
                          ) {
                            /* TODO */
                          },
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
                    Spacer(modifier = Modifier.width(width = 20.dp))
                  }
                  homeSubFeatureContext.workerContextsById[homeSubFeature.id]!!.forEach { workerContext ->
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

                    Column(modifier = Modifier.width(width = 270.dp)) {
                      Image(
                        contentDescription = workerContext.worker.metadata.formattedName,
                        modifier = Modifier
                          .fillMaxWidth()
                          .aspectRatio(ratio = 16f / 9f)
                          .clip(MaterialTheme.shapes.small)
                          .background(color = MaterialTheme.colorScheme.secondaryContainer)
                          .clickable(
                            indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                            interactionSource = remember {
                              MutableInteractionSource()
                            }
                          ) {
                            /* TODO */
                          },
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
                    Spacer(modifier = Modifier.width(width = 20.dp))
                  }
                }
              }
              Spacer(modifier = Modifier.height(height = 20.dp))
            }
          }
        }
      }
    }
  }
}
