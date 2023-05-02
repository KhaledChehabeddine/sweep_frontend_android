package com.example.sweep.data.components.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryMetadata(
  @SerialName("created_date")
  val createdDate: String,
  @SerialName("total_service_items")
  val totalServiceItems: Int,
  @SerialName("updated_date")
  val updatedDate: String
)
