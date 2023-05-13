package com.example.sweep.context.components

import com.example.sweep.data.components.Review
import kotlinx.serialization.Serializable

@Serializable
data class ReviewContext(
  var contextCollected: Boolean,
  var review: Review
)
