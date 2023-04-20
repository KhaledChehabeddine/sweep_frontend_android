package com.example.sweep.context.home

import com.example.sweep.data.screens.home.HomeFeatureItemResponse
import com.example.sweep.data.screens.home.HomeSubFeature

data class HomeSubFeatureContext(
  var contextCollected: Boolean,
  var homeFeatureItemResponsesMapById: HashMap<String, List<HomeFeatureItemResponse>>,
  var homeSubFeatures: List<HomeSubFeature>
)
