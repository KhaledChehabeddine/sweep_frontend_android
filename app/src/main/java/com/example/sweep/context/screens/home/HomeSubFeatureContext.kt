package com.example.sweep.context.screens.home

import com.example.sweep.data.components.ServiceFirmResponse
import com.example.sweep.data.components.ServiceWorkerResponse
import com.example.sweep.data.screens.home.HomeSubFeature

data class HomeSubFeatureContext(
  var contextCollected: Boolean,
  var homeSubFeatures: List<HomeSubFeature>,
  var serviceFirmResponsesMapById: HashMap<String, List<ServiceFirmResponse>>,
  var serviceWorkerResponsesMapById: HashMap<String, List<ServiceWorkerResponse>>
)
