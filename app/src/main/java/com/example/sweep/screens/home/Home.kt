package com.example.sweep.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.sweep.api.getApiClient
import com.example.sweep.context.components.ServiceCategoryResponseContext
import com.example.sweep.context.homeMainFeaturePromotionResponseContext
import com.example.sweep.context.homeMainFeatureRewardResponseContext
import com.example.sweep.context.homeSubFeatureContext
import com.example.sweep.context.screens.home.HomeMainFeaturePromotionResponseContext
import com.example.sweep.context.screens.home.HomeMainFeatureRewardResponseContext
import com.example.sweep.context.screens.home.HomeSubFeatureContext
import com.example.sweep.context.serviceCategoryResponseContext
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.components.ServiceCategoryResponse
import com.example.sweep.data.screens.home.HomeMainFeaturePromotionResponse
import com.example.sweep.data.screens.home.HomeMainFeatureRewardResponse
import com.example.sweep.data.screens.home.HomeSubFeature
import com.example.sweep.functions.coroutines.getServiceResponses
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(paddingValues: PaddingValues) {
  val rememberHomeMainFeaturePromotionResponseContext: HomeMainFeaturePromotionResponseContext by remember {
    mutableStateOf(value = homeMainFeaturePromotionResponseContext)
  }
  val rememberHomeMainFeatureRewardResponseContext: HomeMainFeatureRewardResponseContext by remember {
    mutableStateOf(value = homeMainFeatureRewardResponseContext)
  }
  val rememberHomeSubFeatureContext: HomeSubFeatureContext by remember {
    mutableStateOf(value = homeSubFeatureContext)
  }
  val rememberPagerState: PagerState = rememberPagerState()
  val rememberServiceCategoryResponseContext: ServiceCategoryResponseContext by remember {
    mutableStateOf(value = serviceCategoryResponseContext)
  }
  var rememberStateLoaded: Boolean by remember {
    mutableStateOf(value = false)
  }

  LaunchedEffect(key1 = rememberStateLoaded) {
    if (!rememberHomeMainFeaturePromotionResponseContext.contextCollected) {
      val response = getApiClient().readHomeMainFeaturePromotions()
      val json = response.bodyAsText()
      rememberHomeMainFeaturePromotionResponseContext.homeMainFeaturePromotionResponses =
        Json.decodeFromString<ApiResponse<List<HomeMainFeaturePromotionResponse>>>(json).data!!

      for (
      homeMainFeaturePromotion in rememberHomeMainFeaturePromotionResponseContext.homeMainFeaturePromotionResponses
      ) {
        val serviceResponses = getServiceResponses(
          serviceFirmIds = homeMainFeaturePromotion.serviceFirmIds,
          serviceWorkerIds = homeMainFeaturePromotion.serviceWorkerIds
        )
        rememberHomeMainFeaturePromotionResponseContext.serviceFirmResponsesMapById[homeMainFeaturePromotion.id] =
          serviceResponses.first
        rememberHomeMainFeaturePromotionResponseContext.serviceWorkerResponsesMapById[homeMainFeaturePromotion.id] =
          serviceResponses.second
      }

      rememberHomeMainFeaturePromotionResponseContext.contextCollected = true
    }

    if (!rememberHomeMainFeatureRewardResponseContext.contextCollected) {
      val response = getApiClient().readHomeMainFeatureRewards()
      val json = response.bodyAsText()
      rememberHomeMainFeatureRewardResponseContext.homeMainFeatureRewardResponses =
        Json.decodeFromString<ApiResponse<List<HomeMainFeatureRewardResponse>>>(json).data!!

      rememberHomeMainFeatureRewardResponseContext.contextCollected = true
    }

    if (!rememberHomeSubFeatureContext.contextCollected) {
      val response = getApiClient().readHomeSubFeatures()
      val json = response.bodyAsText()
      rememberHomeSubFeatureContext.homeSubFeatures =
        Json.decodeFromString<ApiResponse<List<HomeSubFeature>>>(json).data!!

      for (homeSubFeature in rememberHomeSubFeatureContext.homeSubFeatures) {
        val serviceResponses = getServiceResponses(
          serviceFirmIds = homeSubFeature.serviceFirmIds,
          serviceWorkerIds = homeSubFeature.serviceWorkerIds
        )
        rememberHomeSubFeatureContext.serviceFirmResponsesMapById[homeSubFeature.id] = serviceResponses.first
        rememberHomeSubFeatureContext.serviceWorkerResponsesMapById[homeSubFeature.id] = serviceResponses.second
      }

      rememberHomeSubFeatureContext.contextCollected = true
    }

    if (!rememberServiceCategoryResponseContext.contextCollected) {
      val response = getApiClient().readServiceCategories()
      val json = response.bodyAsText()
      rememberServiceCategoryResponseContext.serviceCategoryResponses =
        Json.decodeFromString<ApiResponse<List<ServiceCategoryResponse>>>(json).data!!

      rememberServiceCategoryResponseContext.contextCollected = true
    }

    rememberStateLoaded = true
  }

  if (
    !rememberHomeMainFeaturePromotionResponseContext.contextCollected &&
    !rememberHomeMainFeatureRewardResponseContext.contextCollected &&
    !rememberHomeSubFeatureContext.contextCollected &&
    !rememberServiceCategoryResponseContext.contextCollected
  ) {
    HomeLoading(paddingValues = paddingValues)
  } else {
    HomeLoaded(
      homeMainFeaturePromotionResponseContext = rememberHomeMainFeaturePromotionResponseContext,
      homeMainFeatureRewardResponseContext = rememberHomeMainFeatureRewardResponseContext,
      homeSubFeatureContext = rememberHomeSubFeatureContext,
      paddingValues = paddingValues,
      pagerState = rememberPagerState,
      serviceCategoryResponseContext = rememberServiceCategoryResponseContext
    )
  }
}
