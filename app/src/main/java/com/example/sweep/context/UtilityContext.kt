package com.example.sweep.context

import com.example.sweep.data.components.Category
import com.example.sweep.data.components.Review
import com.example.sweep.data.components.ServiceCategoryResponse
import com.example.sweep.data.components.ServiceItemResponse

data class UtilityContext(
  var categories: List<Category>,
  var reviews: List<Review>,
  var serviceCategoryResponses: List<ServiceCategoryResponse>,
  var serviceItemResponses: List<ServiceItemResponse>,
  var utilityContextCollected: Boolean
)
