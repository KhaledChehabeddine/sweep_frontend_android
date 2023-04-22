package com.example.sweep.context.components

import com.example.sweep.data.components.Category
import com.example.sweep.data.components.ServiceItemResponse

data class CategoryContext(
  var categories: List<Category>,
  var contextCollected: Boolean,
  var serviceItemResponsesMapById: HashMap<String, List<ServiceItemResponse>>
)
