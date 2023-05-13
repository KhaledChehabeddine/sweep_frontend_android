package com.example.sweep.context.screens.home

import com.example.sweep.context.screens.user.CompanyContext
import com.example.sweep.context.screens.user.WorkerContext
import com.example.sweep.data.home.HomeMainFeaturePromotion
import kotlinx.serialization.Serializable

@Serializable
data class HomeMainFeaturePromotionContext(
  var contextCollected: Boolean,
  var companyContextsById: Map<String, List<CompanyContext>>,
  var homeMainFeaturePromotionById: Map<String, HomeMainFeaturePromotion>,
  var homeMainFeaturePromotions: List<HomeMainFeaturePromotion>,
  var workerContextsById: Map<String, List<WorkerContext>>
)
