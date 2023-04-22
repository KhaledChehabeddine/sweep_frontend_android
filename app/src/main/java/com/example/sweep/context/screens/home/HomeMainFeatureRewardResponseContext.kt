package com.example.sweep.context.screens.home

import com.example.sweep.data.screens.home.HomeMainFeatureRewardResponse

data class HomeMainFeatureRewardResponseContext(
  var contextCollected: Boolean,
  var homeMainFeatureRewardResponses: List<HomeMainFeatureRewardResponse>
)
