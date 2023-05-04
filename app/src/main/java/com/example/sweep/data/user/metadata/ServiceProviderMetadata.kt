package com.example.sweep.data.user.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceProviderMetadata(
  @SerialName("total_categories")
  val totalCategories: Int,
  @SerialName("total_reviews")
  val totalReviews: Int
)
