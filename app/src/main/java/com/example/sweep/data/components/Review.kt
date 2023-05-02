package com.example.sweep.data.components

import com.example.sweep.data.components.metadata.ReviewMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
  @SerialName("customer_id")
  val customerId: String,
  @SerialName("feedback")
  val feedback: String,
  @SerialName("_id")
  val id: String,
  @SerialName("metadata")
  val metadata: ReviewMetadata,
  @SerialName("rating")
  val rating: Int
)
