package com.example.sweep.context

import com.example.sweep.context.components.ServiceCategoryResponseContext
import com.example.sweep.context.screens.account.AccountCategoryContext
import com.example.sweep.context.screens.account.AccountCategoryItemResponseContext
import com.example.sweep.context.screens.home.HomeMainFeaturePromotionResponseContext
import com.example.sweep.context.screens.home.HomeMainFeatureRewardResponseContext
import com.example.sweep.context.screens.home.HomeSubFeatureContext

var accountCategoryContext = AccountCategoryContext(
  contextCollected = false,
  accountCategories = emptyList()
)

var accountCategoryItemResponseContext = AccountCategoryItemResponseContext(
  contextCollected = false,
  accountCategoryItemResponsesMapByCategory = hashMapOf()
)

var homeMainFeaturePromotionResponseContext = HomeMainFeaturePromotionResponseContext(
  contextCollected = false,
  homeMainFeaturePromotionResponses = emptyList(),
  serviceFirmResponsesMapById = hashMapOf(),
  serviceWorkerResponsesMapById = hashMapOf()
)

var homeMainFeatureRewardResponseContext = HomeMainFeatureRewardResponseContext(
  contextCollected = false,
  homeMainFeatureRewardResponses = emptyList()
)

var homeSubFeatureContext = HomeSubFeatureContext(
  contextCollected = false,
  homeSubFeatures = emptyList(),
  serviceFirmResponsesMapById = hashMapOf(),
  serviceWorkerResponsesMapById = hashMapOf()
)

var serviceCategoryResponseContext = ServiceCategoryResponseContext(
  contextCollected = false,
  serviceCategoryResponses = emptyList()
)
