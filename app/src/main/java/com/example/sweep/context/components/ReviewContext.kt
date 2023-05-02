package com.example.sweep.context.components

import com.example.sweep.data.components.Review

data class ReviewContext(
  var contextCollected: Boolean,
  var review: Review
)
