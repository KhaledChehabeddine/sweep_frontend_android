package com.example.sweep.context.screens.home

import com.example.sweep.context.screens.user.CompanyContext
import com.example.sweep.context.screens.user.WorkerContext
import com.example.sweep.data.home.HomeSubFeature

data class HomeSubFeatureContext(
  var companyContextsById: Map<String, List<CompanyContext>>,
  var contextCollected: Boolean,
  var homeSubFeatureById: Map<String, HomeSubFeature>,
  var homeSubFeatures: List<HomeSubFeature>,
  var workerContextsById: Map<String, List<WorkerContext>>
)
