package com.example.sweep.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.sweep.components.ServiceCategoryGrid
import com.example.sweep.context.components.ServiceCategoryResponseContext
import com.example.sweep.context.screens.home.HomeMainFeaturePromotionResponseContext
import com.example.sweep.context.screens.home.HomeMainFeatureRewardResponseContext
import com.example.sweep.context.screens.home.HomeSubFeatureContext
import com.example.sweep.functions.svgS3UrlToPainter
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeLoaded(
  homeMainFeaturePromotionResponseContext: HomeMainFeaturePromotionResponseContext,
  homeMainFeatureRewardResponseContext: HomeMainFeatureRewardResponseContext,
  homeSubFeatureContext: HomeSubFeatureContext,
  paddingValues: PaddingValues,
  pagerState: PagerState,
  serviceCategoryResponseContext: ServiceCategoryResponseContext
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
          Row {
            HorizontalPager(
              pageCount = homeMainFeaturePromotionResponseContext.homeMainFeaturePromotionResponses.size +
                homeMainFeatureRewardResponseContext.homeMainFeatureRewardResponses.size,
              state = pagerState
            ) { page ->
              Card(
                modifier = Modifier
                  .graphicsLayer {
                    val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction)
                      .absoluteValue

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
                  if (
                    page < homeMainFeaturePromotionResponseContext.homeMainFeaturePromotionResponses.size
                  ) {
                    "Promotion"
                  } else {
                    "Reward"
                  },
                  painter = svgS3UrlToPainter(
                    url =
                    if (
                      page < homeMainFeaturePromotionResponseContext.homeMainFeaturePromotionResponses.size
                    ) {
                      homeMainFeaturePromotionResponseContext.homeMainFeaturePromotionResponses[page].imageUrl
                    } else {
                      homeMainFeatureRewardResponseContext.homeMainFeatureRewardResponses[page].imageUrl
                    }
                  ),
                  modifier = Modifier
                    .height(height = 200.dp)
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .clickable(
                      indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                      interactionSource = remember {
                        MutableInteractionSource()
                      }
                    ) {
                      /* TODO */
                    }
                )
              }
            }
          }
          Row(modifier = Modifier.padding(top = 20.dp)) {
            ServiceCategoryGrid(
              serviceCategoryResponses = serviceCategoryResponseContext.serviceCategoryResponses
            )
          }
        }
        Spacer(modifier = Modifier.height(height = 20.dp))
        Column(
          modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onBackground)
            .fillMaxWidth()
            .padding(start = 20.dp)
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
            ) {
              Column(modifier = Modifier.padding(end = 20.dp)) {
                Row(
                  modifier = Modifier
                    .padding(
                      bottom = 10.dp,
                      top = 20.dp
                    )
                ) {
                  Text(
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.headlineLarge,
                    text = homeSubFeature.title
                  )
                }
                Row(modifier = Modifier.padding(bottom = 20.dp)) {
                  Text(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    style = MaterialTheme.typography.labelMedium,
                    text = homeSubFeature.subtitle
                  )
                }
              }
              LazyRow {
                item {
                  homeSubFeatureContext.serviceFirmResponsesMapById[homeSubFeature.id]!!.forEach {
                      serviceFirmResponse ->
                    Image(
                      contentDescription = serviceFirmResponse.description,
                      modifier = Modifier
                        .height(height = 150.dp)
                        .aspectRatio(ratio = 16f / 9f)
                        .padding(end = 20.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .clickable(
                          indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                          interactionSource = remember {
                            MutableInteractionSource()
                          }
                        ) {
                          /* TODO */
                        },
                      painter = svgS3UrlToPainter(url = serviceFirmResponse.imageUrl)
                    )
                  }
                  homeSubFeatureContext.serviceWorkerResponsesMapById[homeSubFeature.id]!!.forEach {
                      serviceWorkerResponse ->
                    Image(
                      contentDescription = serviceWorkerResponse.description,
                      modifier = Modifier
                        .height(150.dp)
                        .aspectRatio(ratio = 16f / 9f)
                        .padding(end = 20.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .clickable(
                          indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                          interactionSource = remember {
                            MutableInteractionSource()
                          }
                        ) {
                          /* TODO */
                        },
                      painter = svgS3UrlToPainter(url = serviceWorkerResponse.imageUrl)
                    )
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
