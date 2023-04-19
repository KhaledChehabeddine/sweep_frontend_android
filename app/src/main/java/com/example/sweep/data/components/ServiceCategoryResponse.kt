package com.example.sweep.data.components

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceCategoryResponse(
  @SerialName("active")
  val active: Boolean,
  @SerialName("file_path")
  val filePath: String,
  @SerialName("_id")
  val id: String,
  @SerialName("image_url")
  val imageUrl: String,
  @SerialName("name")
  val name: String
)
