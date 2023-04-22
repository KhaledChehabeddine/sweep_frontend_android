package com.example.sweep.context.components

import com.example.sweep.data.components.ServiceCategoryResponse

data class ServiceCategoryResponseContext(
  var contextCollected: Boolean,
  var serviceCategoryResponses: List<ServiceCategoryResponse>
)
