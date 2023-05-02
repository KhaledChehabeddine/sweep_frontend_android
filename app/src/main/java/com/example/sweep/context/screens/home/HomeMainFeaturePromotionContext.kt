package com.example.sweep.context.screens.home

import com.example.sweep.context.screens.user.CompanyContext
import com.example.sweep.context.screens.user.WorkerContext
import com.example.sweep.data.home.HomeMainFeaturePromotion

data class HomeMainFeaturePromotionContext(
  var contextCollected: Boolean,
  var companyContextsById: Map<String, List<CompanyContext>>,
  var homeMainFeaturePromotions: List<HomeMainFeaturePromotion>,
  var workerContextsById: Map<String, List<WorkerContext>>
)
