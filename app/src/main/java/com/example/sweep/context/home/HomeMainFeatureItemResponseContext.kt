package com.example.sweep.context.home

import com.example.sweep.data.screens.home.HomeFeatureItemResponse
import com.example.sweep.data.screens.home.HomeMainFeatureItemResponse

data class HomeMainFeatureItemResponseContext(
  var contextCollected: Boolean,
  var promotionHomeFeatureItemResponsesMapById: HashMap<String, List<HomeFeatureItemResponse>>,
  var homeMainFeatureItemResponses: List<HomeMainFeatureItemResponse>
)
