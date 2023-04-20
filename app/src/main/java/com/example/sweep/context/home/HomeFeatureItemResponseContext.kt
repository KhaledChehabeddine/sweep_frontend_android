package com.example.sweep.context.home

import com.example.sweep.data.components.Category
import com.example.sweep.data.components.Review
import com.example.sweep.data.components.ServiceItemResponse
import com.example.sweep.data.screens.home.HomeFeatureItemResponse

data class HomeFeatureItemResponseContext(
  var categoriesMapById: HashMap<String, List<Category>>,
  var contextCollected: Boolean,
  var homeFeatureItemResponses: List<HomeFeatureItemResponse>,
  var reviewsMapById: HashMap<String, List<Review>>,
  var serviceItemResponsesMapById: HashMap<String, List<ServiceItemResponse>>
)
