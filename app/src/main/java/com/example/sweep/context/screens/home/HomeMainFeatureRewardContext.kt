package com.example.sweep.context.screens.home

import com.example.sweep.data.home.HomeMainFeatureReward

data class HomeMainFeatureRewardContext(
  var contextCollected: Boolean,
  var homeMainFeatureRewards: List<HomeMainFeatureReward>
)
