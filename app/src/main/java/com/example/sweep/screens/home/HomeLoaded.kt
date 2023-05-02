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
          Row {
            HorizontalPager(
              pageCount = homeMainFeaturePromotionContext.homeMainFeaturePromotions.size +
                homeMainFeatureRewardContext.homeMainFeatureRewards.size,
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
                  if (page < homeMainFeaturePromotionContext.homeMainFeaturePromotions.size) {
                    "Promotion"
                  } else {
                    "Reward"
                  },
                  painter = svgS3UrlToPainter(
                    url =
                    if (page < homeMainFeaturePromotionContext.homeMainFeaturePromotions.size) {
                      homeMainFeaturePromotionContext.homeMainFeaturePromotions[page].homeMainFeature.imageUrl
                    } else {
                      homeMainFeatureRewardContext.homeMainFeatureRewards[page].homeMainFeature.imageUrl
                    }
                  ),
                  modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 16f / 9f)
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
            ServiceCategoryGrid(serviceCategories = serviceCategoryContext.serviceCategories)
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
                  homeSubFeatureContext.companyContextsById[homeSubFeature.id]!!.forEach { companyContext ->
                    Image(
                      contentDescription = companyContext.company.name,
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
                      painter = svgS3UrlToPainter(url = companyContext.company.bannerImageUrl)
                    )
                  }
                  homeSubFeatureContext.workerContextsById[homeSubFeature.id]!!.forEach { workerContext ->
                    Image(
                      contentDescription = workerContext.worker.metadata.formattedName,
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
                      painter = svgS3UrlToPainter(url = workerContext.worker.bannerImageUrl)
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
