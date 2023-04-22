package com.example.sweep.context.screens.home

import com.example.sweep.data.components.ServiceFirmResponse
import com.example.sweep.data.components.ServiceWorkerResponse
import com.example.sweep.data.screens.home.HomeMainFeaturePromotionResponse

data class HomeMainFeaturePromotionResponseContext(
  var contextCollected: Boolean,
  var homeMainFeaturePromotionResponses: List<HomeMainFeaturePromotionResponse>,
  var serviceFirmResponsesMapById: HashMap<String, List<ServiceFirmResponse>>,
  var serviceWorkerResponsesMapById: HashMap<String, List<ServiceWorkerResponse>>
)
