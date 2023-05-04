package com.example.sweep.data.user

import com.example.sweep.data.components.Category
import com.example.sweep.data.components.Review
import com.example.sweep.data.user.metadata.ServiceProviderMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceProvider(
  @SerialName("average_rating")
  val averageRating: Float,
  @SerialName("categories")
  val categories: List<Category>,
  @SerialName("description")
  val description: String,
  @SerialName("metadata")
  val metadata: ServiceProviderMetadata,
  @SerialName("reviews")
  val reviews: List<Review>,
  @SerialName("service_provider_type")
  val serviceProviderType: String,
  @SerialName("user")
  val user: User
)
