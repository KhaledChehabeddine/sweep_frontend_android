package com.example.sweep.context.components

import com.example.sweep.data.components.Review
import com.example.sweep.data.components.ServiceItemResponse

data class ReviewContext(
  var contextCollected: Boolean,
  var reviews: List<Review>,
  var serviceItemResponseMapById: HashMap<String, ServiceItemResponse>
)
