package com.example.sweep.data.components

import com.example.sweep.data.components.metadata.ServiceItemMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceItem(
  @SerialName("description")
  val description: String,
  @SerialName("_id")
  val id: String,
  @SerialName("image")
  val image: String = "",
  @SerialName("image_path")
  val imagePath: String,
  @SerialName("image_url")
  val imageUrl: String,
  @SerialName("metadata")
  val metadata: ServiceItemMetadata,
  @SerialName("name")
  val name: String,
  @SerialName("price")
  val price: Float
)
