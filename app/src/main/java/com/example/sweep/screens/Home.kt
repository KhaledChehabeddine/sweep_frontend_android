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
import androidx.compose.runtime.mutableStateMapOf
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
import com.example.sweep.context.homeFeatureItemResponseContext
import com.example.sweep.context.homeMainFeatureItemResponseContext
import com.example.sweep.context.homeSubFeatureContext
import com.example.sweep.context.serviceCategoryResponseContext
import com.example.sweep.context.serviceItemResponseContext
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.components.Category
import com.example.sweep.data.components.Review
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
  var rememberHomeFeatureItemResponseCategoriesMapById: HashMap<String, List<Category>> by remember {
    mutableStateMapOf()
  }
  rememberHomeFeatureItemResponseCategoriesMapById = homeFeatureItemResponseContext.categoriesMapById
  var rememberHomeFeatureItemResponseContextCollected: Boolean by remember {
    mutableStateOf(value = homeFeatureItemResponseContext.contextCollected)
  }
  var rememberHomeFeatureItemResponseHomeFeatureItemResponses: List<HomeFeatureItemResponse> by remember {
    mutableStateOf(value = homeFeatureItemResponseContext.homeFeatureItemResponses)
  }
  var rememberHomeFeatureItemResponseReviewsMapById: HashMap<String, List<Review>> by remember {
    mutableStateMapOf()
  }
  rememberHomeFeatureItemResponseReviewsMapById = homeFeatureItemResponseContext.reviewsMapById
  var rememberHomeFeatureItemResponseServiceItemResponsesMapById:
    HashMap<String, List<ServiceItemResponse>> by remember {
      mutableStateMapOf()
    }
  rememberHomeFeatureItemResponseServiceItemResponsesMapById =
    homeFeatureItemResponseContext.serviceItemResponsesMapById

  var rememberHomeMainFeatureItemResponseContextCollected: Boolean by remember {
    mutableStateOf(value = homeMainFeatureItemResponseContext.contextCollected)
  }
  var rememberHomeMainFeatureItemResponsePromotionHomeFeatureItemResponsesMapById:
    HashMap<String, List<HomeFeatureItemResponse>> by remember {
      mutableStateMapOf()
    }
  rememberHomeMainFeatureItemResponsePromotionHomeFeatureItemResponsesMapById =
    homeMainFeatureItemResponseContext.promotionHomeFeatureItemResponsesMapById
  var rememberHomeMainFeatureItemResponseHomeMainFeatureItemResponses:
    List<HomeMainFeatureItemResponse> by remember {
      mutableStateOf(value = homeMainFeatureItemResponseContext.homeMainFeatureItemResponses)
    }

  var rememberHomeSubFeatureContextCollected: Boolean by remember {
    mutableStateOf(value = homeSubFeatureContext.contextCollected)
  }
  var rememberHomeSubFeatureHomeFeatureItemResponsesMapById:
    HashMap<String, List<HomeFeatureItemResponse>> by remember {
      mutableStateMapOf()
    }
  rememberHomeSubFeatureHomeFeatureItemResponsesMapById = homeSubFeatureContext.homeFeatureItemResponsesMapById
  var rememberHomeSubFeatureHomeSubFeatures: List<HomeSubFeature> by remember {
    mutableStateOf(value = homeSubFeatureContext.homeSubFeatures)
  }

  var rememberServiceCategoryResponseContextCollected: Boolean by remember {
    mutableStateOf(value = serviceCategoryResponseContext.contextCollected)
  }
  var rememberServiceCategoryResponseServiceCategoryResponses: List<ServiceCategoryResponse> by remember {
    mutableStateOf(value = serviceCategoryResponseContext.serviceCategoryResponses)
  }

  var rememberServiceItemResponseContextCollected: Boolean by remember {
    mutableStateOf(value = serviceItemResponseContext.contextCollected)
  }
  var rememberServiceItemResponseServiceItemResponses: List<ServiceItemResponse> by remember {
    mutableStateOf(value = serviceItemResponseContext.serviceItemResponses)
  }

  LaunchedEffect(Unit) {
    if (rememberHomeFeatureItemResponseContextCollected) return@LaunchedEffect

    var response = getApiClient().readHomeFeatureItems()
    var json = response.bodyAsText()
    rememberHomeFeatureItemResponseHomeFeatureItemResponses =
      Json.decodeFromString<ApiResponse<List<HomeFeatureItemResponse>>>(json).data!!

    for (homeFeatureItemResponse in rememberHomeFeatureItemResponseHomeFeatureItemResponses) {

    }

//    if (rememberHomeContextCollected) return@LaunchedEffect
//
//    var response = getApiClient().readHomeMainFeatureItems()
//    var json = response.bodyAsText()
//    rememberHomeMainFeatureItemResponses =
//      Json.decodeFromString<ApiResponse<List<HomeMainFeatureItemResponse>>>(json).data!!
//
//    response = getApiClient().readHomeSubFeatures()
//    json = response.bodyAsText()
//    rememberHomeSubFeatures = Json.decodeFromString<ApiResponse<List<HomeSubFeature>>>(json).data!!
//
//    for (homeSubFeature in rememberHomeSubFeatures) {
//      for (homeFeatureItemId in homeSubFeature.homeFeatureItemIds) {
//        response = getApiClient().readHomeFeatureItemById(id = homeSubFeature.id)
//        json = response.bodyAsText()
//        val homeFeatureItemResponse = Json.decodeFromString<ApiResponse<HomeFeatureItemResponse>>(json).data!!
//
//        if (rememberHomeFeatureItemResponsesMap.containsKey(homeSubFeature.id)) {
//          rememberHomeFeatureItemResponsesMap[homeSubFeature.id]!!.add(homeFeatureItemResponse)
//        } else {
//          rememberHomeFeatureItemResponsesMap[homeSubFeature.id] = arrayListOf(homeFeatureItemResponse)
//        }
//      }
//    }
//
//    rememberHomeContextCollected = true
//    homeContext.homeFeatureItemResponsesMap = rememberHomeFeatureItemResponsesMap
//    homeContext.homeMainFeatureItemResponses = rememberHomeMainFeatureItemResponses
//    homeContext.homeSubFeatures = rememberHomeSubFeatures
//    homeContext.homeContextCollected = true
//
//    if (rememberUtilityContextCollected) return@LaunchedEffect
//
//    response = getApiClient().readCategories()
//    json = response.bodyAsText()
//    rememberCategories = Json.decodeFromString<ApiResponse<List<Category>>>(json).data!!
//
//    response = getApiClient().readServiceCategories()
//    json = response.bodyAsText()
//    rememberServiceCategoryResponses = Json.decodeFromString<ApiResponse<List<ServiceCategoryResponse>>>(json).data!!
//
//    rememberUtilityContextCollected = true
//    utilityContext.serviceCategoryResponses = rememberServiceCategoryResponses
//    utilityContext.utilityContextCollected = true
  }

  if (
    false
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
              ServiceCategoryGrid(serviceCategoryResponses = rememberServiceCategoryResponseServiceCategoryResponses)
            }
          }
          Spacer(modifier = Modifier.height(height = 20.dp))
          Column(
            modifier = Modifier
              .background(color = MaterialTheme.colorScheme.onBackground)
              .fillMaxWidth()
          ) {
            repeat(times = 2) {
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
                  }
                }
              }

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

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    Home(paddingValues = PaddingValues())
  }
}
