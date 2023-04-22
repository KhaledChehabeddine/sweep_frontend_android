package com.example.sweep.data.components

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceWorkerResponse(
  @SerialName("category_ids")
  val categoryIds: List<String>,
  @SerialName("description")
  val description: String,
  @SerialName("file_path")
  val filePath: String,
  @SerialName("flags")
  val flags: List<String>,
  @SerialName("_id")
  val id: String,
  @SerialName("image_url")
  val imageUrl: String,
  @SerialName("rating")
  val rating: Float,
  @SerialName("review_ids")
  val reviewIds: List<String>,
  @SerialName("service_item_ids")
  val serviceItemIds: List<String>,
  @SerialName("worker_id")
  val workerId: String
)