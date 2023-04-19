package com.example.sweep.data.components

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceItemResponse(
  @SerialName("description")
  val description: String,
  @SerialName("file_path")
  val filePath: String,
  @SerialName("_id")
  val id: String,
  @SerialName("image_url")
  val imageUrl: String,
  @SerialName("name")
  val name: String,
  @SerialName("price")
  val price: Float
)
