package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.api.getApiClient
import com.example.sweep.components.ServiceCategoryGrid
import com.example.sweep.context.homeContext
import com.example.sweep.context.utilityContext
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.components.Category
import com.example.sweep.data.components.ServiceCategoryResponse
import com.example.sweep.data.components.ServiceItemResponse
import com.example.sweep.data.screens.home.HomeFeatureItemResponse
import com.example.sweep.data.screens.home.HomeMainFeatureItemResponse
import com.example.sweep.data.screens.home.HomeSubFeature
import com.example.sweep.screens.loading.HomeLoading
import com.example.sweep.ui.theme.SweepTheme
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun Home(paddingValues: PaddingValues) {
  var rememberHomeContextCollected: Boolean by remember {
    mutableStateOf(value = homeContext.homeContextCollected)
  }
  var rememberHomeFeatureItemResponses: List<HomeFeatureItemResponse> by remember {
    mutableStateOf(value = homeContext.homeFeatureItemResponses)
  }
  var rememberHomeMainFeatureItemResponses: List<HomeMainFeatureItemResponse> by remember {
    mutableStateOf(value = homeContext.homeMainFeatureItemResponses)
  }
  var rememberHomeSubFeatures: List<HomeSubFeature> by remember {
    mutableStateOf(value = homeContext.homeSubFeatures)
  }
  var rememberCategories: List<Category> by remember {
    mutableStateOf(value = utilityContext.categories)
  }
  var rememberServiceCategoryResponses: List<ServiceCategoryResponse> by remember {
    mutableStateOf(value = utilityContext.serviceCategoryResponses)
  }
  var rememberServiceItemResponses: List<ServiceItemResponse> by remember {
    mutableStateOf(value = utilityContext.serviceItemResponses)
  }
  var rememberUtilityContextCollected: Boolean by remember {
    mutableStateOf(value = utilityContext.utilityContextCollected)
  }

  LaunchedEffect(Unit) {
    if (rememberHomeContextCollected) return@LaunchedEffect

    var response = getApiClient().readHomeMainFeatureItems()
    var json = response.bodyAsText()
    rememberHomeMainFeatureItemResponses =
      Json.decodeFromString<ApiResponse<List<HomeMainFeatureItemResponse>>>(json).data!!

    response = getApiClient().readHomeSubFeatures()
    json = response.bodyAsText()
    rememberHomeSubFeatures = Json.decodeFromString<ApiResponse<List<HomeSubFeature>>>(json).data!!

    rememberHomeContextCollected = true
    homeContext.homeMainFeatureItemResponses = rememberHomeMainFeatureItemResponses
    homeContext.homeContextCollected = true

    if (rememberUtilityContextCollected) return@LaunchedEffect

    response = getApiClient().readCategories()
    json = response.bodyAsText()
    rememberCategories = Json.decodeFromString<ApiResponse<List<Category>>>(json).data!!

    response = getApiClient().readServiceCategories()
    json = response.bodyAsText()
    rememberServiceCategoryResponses = Json.decodeFromString<ApiResponse<List<ServiceCategoryResponse>>>(json).data!!

    rememberUtilityContextCollected = true
    utilityContext.serviceCategoryResponses = rememberServiceCategoryResponses
    utilityContext.utilityContextCollected = true
  }

//  LaunchedEffect(Unit) {
//    for (serviceCategory in serviceCategories) {
//      getApiClient().createServiceCategory(Json.encodeToString(value = serviceCategory))
//    }
//  }

  if (false
//    !rememberHomeContextCollected && !rememberUtilityContextCollected
  ) {
    HomeLoading(paddingValues = paddingValues)
  } else {
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
              Box(
                modifier = Modifier
                  .height(height = 200.dp)
                  .fillMaxWidth()
                  .clip(MaterialTheme.shapes.medium)
                  .background(color = MaterialTheme.colorScheme.secondaryContainer)
                  .clickable(
                    indication = rememberRipple(color = MaterialTheme.colorScheme.onSecondaryContainer),
                    interactionSource = remember {
                      MutableInteractionSource()
                    }
                  ) {
                    /* TODO */
                  }
              ) {
              }
            }
            Row(modifier = Modifier.padding(top = 20.dp)) {
              ServiceCategoryGrid()
            }
          }
          Spacer(modifier = Modifier.height(height = 20.dp))
          Column(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)
              .fillMaxWidth()
          ) {
            for (i in 1..2) {
              Column(
                modifier = Modifier.clickable(
                  indication = rememberRipple(
                    color = MaterialTheme.colorScheme.tertiary
                  ),
                  interactionSource = remember {
                    MutableInteractionSource()
                  }
                ) {
                  /* TODO */
                }
              ) {
                Row(
                  modifier = Modifier.padding(
                    bottom = 10.dp,
                    end = 20.dp,
                    start = 20.dp,
                    top = 20.dp
                  )
                ) {
                  Box(
                    modifier = Modifier.size(
                      height = 24.dp,
                      width = 240.dp
                    )
                      .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                      )
                  )
                }
                Row(
                  modifier = Modifier.padding(
                    bottom = 20.dp,
                    end = 20.dp,
                    start = 20.dp
                  )
                ) {
                  Box(
                    modifier = Modifier.size(
                      height = 12.dp,
                      width = 360.dp
                    )
                      .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = CircleShape
                      )
                  )
                }
                LazyRow(
                  modifier = Modifier.padding(
                    bottom = 30.dp,
                    start = 20.dp
                  )
                ) {
                  item {
                    for (j in 1..3) {
                      Box(
                        modifier = Modifier.size(
                          height = 160.dp,
                          width = 250.dp
                        )
                          .padding(end = 20.dp)
                          .clip(
                            RoundedCornerShape(percent = 8)
                          )
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
                            /* TODO */
                          }
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
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    Home(paddingValues = PaddingValues())
  }
}
