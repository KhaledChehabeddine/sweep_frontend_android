package com.example.sweep.data.components.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceCategoryMetadata(
  @SerialName("created_date")
  val createdDate: String,
  @SerialName("image_format")
  val imageFormat: String,
  @SerialName("image_height")
  val imageHeight: Int,
  @SerialName("image_width")
  val imageWidth: Int,
  @SerialName("updated_date")
  val updatedDate: String
)
