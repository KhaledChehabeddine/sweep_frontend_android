package com.example.sweep.data.components

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
  @SerialName("feedback")
  val feedback: String,
  @SerialName("_id")
  val id: String,
  @SerialName("rating")
  val rating: Int,
  @SerialName("reviewer")
  val reviewer: String,
  @SerialName("service_item_id")
  val serviceItemId: String
)
