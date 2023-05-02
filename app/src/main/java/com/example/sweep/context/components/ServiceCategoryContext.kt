package com.example.sweep.context.components

import com.example.sweep.data.components.ServiceCategory

data class ServiceCategoryContext(
  var contextCollected: Boolean,
  var serviceCategories: List<ServiceCategory>
)
