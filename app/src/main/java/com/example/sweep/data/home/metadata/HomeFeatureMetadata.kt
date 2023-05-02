package com.example.sweep.data.home.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeFeatureMetadata(
  @SerialName("created_date")
  val createdDate: String,
  @SerialName("updated_date")
  val updatedDate: String
)
