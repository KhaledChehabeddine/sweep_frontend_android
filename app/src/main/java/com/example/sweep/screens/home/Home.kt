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
import com.example.sweep.context.components.ServiceCategoryContext
import com.example.sweep.context.homeMainFeaturePromotionContext
import com.example.sweep.context.homeMainFeatureRewardContext
import com.example.sweep.context.homeSubFeatureContext
import com.example.sweep.context.screens.home.HomeMainFeaturePromotionContext
import com.example.sweep.context.screens.home.HomeMainFeatureRewardContext
import com.example.sweep.context.screens.home.HomeSubFeatureContext
import com.example.sweep.context.serviceCategoryContext
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.components.ServiceCategory
import com.example.sweep.data.home.HomeMainFeaturePromotion
import com.example.sweep.data.home.HomeMainFeatureReward
import com.example.sweep.data.home.HomeSubFeature
import com.example.sweep.functions.coroutine.getServiceProviderContexts
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(paddingValues: PaddingValues) {
  val rememberHomeMainFeaturePromotionContext: HomeMainFeaturePromotionContext by remember {
    mutableStateOf(value = homeMainFeaturePromotionContext)
  }
  val rememberHomeMainFeatureRewardContext: HomeMainFeatureRewardContext by remember {
    mutableStateOf(value = homeMainFeatureRewardContext)
  }
  val rememberHomeSubFeatureContext: HomeSubFeatureContext by remember {
    mutableStateOf(value = homeSubFeatureContext)
  }
  var rememberPageContextLoaded: Boolean by remember {
    mutableStateOf(value = false)
  }
  val rememberPagerState: PagerState = rememberPagerState()
  val rememberServiceCategoryContext: ServiceCategoryContext by remember {
    mutableStateOf(value = serviceCategoryContext)
  }

  LaunchedEffect(key1 = rememberPageContextLoaded) {
    if (!rememberHomeMainFeaturePromotionContext.contextCollected) {
      val response = getApiClient().readHomeMainFeaturePromotions()
      val json = response.bodyAsText()
      rememberHomeMainFeaturePromotionContext.homeMainFeaturePromotions =
        Json.decodeFromString<ApiResponse<List<HomeMainFeaturePromotion>>>(json).data!!

      for (homeMainFeaturePromotion in rememberHomeMainFeaturePromotionContext.homeMainFeaturePromotions) {
        val serviceProviders = getServiceProviderContexts(
          companyIds = homeMainFeaturePromotion.companyIds,
          workerIds = homeMainFeaturePromotion.workerIds
        )
        rememberHomeMainFeaturePromotionContext.companyContextsById +=
          Pair(homeMainFeaturePromotion.id, serviceProviders.first)
        rememberHomeMainFeaturePromotionContext.workerContextsById +=
          Pair(homeMainFeaturePromotion.id, serviceProviders.second)
      }

      rememberHomeMainFeaturePromotionContext.contextCollected = true
    }

    if (!rememberHomeMainFeatureRewardContext.contextCollected) {
      val response = getApiClient().readHomeMainFeatureRewards()
      val json = response.bodyAsText()
      rememberHomeMainFeatureRewardContext.homeMainFeatureRewards =
        Json.decodeFromString<ApiResponse<List<HomeMainFeatureReward>>>(json).data!!

      rememberHomeMainFeatureRewardContext.contextCollected = true
    }

    if (!rememberHomeSubFeatureContext.contextCollected) {
      val response = getApiClient().readHomeSubFeatures()
      val json = response.bodyAsText()
      rememberHomeSubFeatureContext.homeSubFeatures =
        Json.decodeFromString<ApiResponse<List<HomeSubFeature>>>(json).data!!

      for (homeSubFeature in rememberHomeSubFeatureContext.homeSubFeatures) {
        val serviceResponses = getServiceProviderContexts(
          companyIds = homeSubFeature.companyIds,
          workerIds = homeSubFeature.workerIds
        )
        rememberHomeSubFeatureContext.companyContextsById += Pair(homeSubFeature.id, serviceResponses.first)
        rememberHomeSubFeatureContext.workerContextsById += Pair(homeSubFeature.id, serviceResponses.second)
      }

      rememberHomeSubFeatureContext.contextCollected = true
    }

    if (!rememberServiceCategoryContext.contextCollected) {
      val response = getApiClient().readServiceCategories()
      val json = response.bodyAsText()
      rememberServiceCategoryContext.serviceCategories =
        Json.decodeFromString<ApiResponse<List<ServiceCategory>>>(json).data!!

      rememberServiceCategoryContext.contextCollected = true
    }

    rememberPageContextLoaded = true
  }

  if (
    !rememberHomeMainFeaturePromotionContext.contextCollected &&
    !rememberHomeMainFeatureRewardContext.contextCollected &&
    !rememberHomeSubFeatureContext.contextCollected &&
    !rememberServiceCategoryContext.contextCollected
  ) {
    HomeLoading(paddingValues = paddingValues)
  } else {
    HomeLoaded(
      homeMainFeaturePromotionContext = rememberHomeMainFeaturePromotionContext,
      homeMainFeatureRewardContext = rememberHomeMainFeatureRewardContext,
      homeSubFeatureContext = rememberHomeSubFeatureContext,
      paddingValues = paddingValues,
      pagerState = rememberPagerState,
      serviceCategoryContext = rememberServiceCategoryContext
    )
  }
}
