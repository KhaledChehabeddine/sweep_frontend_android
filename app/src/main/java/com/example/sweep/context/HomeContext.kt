package com.example.sweep.context

import com.example.sweep.data.screens.home.HomeFeatureItemResponse
import com.example.sweep.data.screens.home.HomeMainFeatureItemResponse
import com.example.sweep.data.screens.home.HomeSubFeature

data class HomeContext(
  var homeContextCollected: Boolean,
  var homeFeatureItemResponses: List<HomeFeatureItemResponse>,
  var homeMainFeatureItemResponses: List<HomeMainFeatureItemResponse>,
  var homeSubFeatures: List<HomeSubFeature>
)
