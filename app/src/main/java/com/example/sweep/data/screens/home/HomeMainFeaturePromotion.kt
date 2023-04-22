package com.example.sweep.data.screens.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeMainFeaturePromotion(
  @SerialName("file_path")
  val filePath: String,
  @SerialName("_id")
  val id: String,
  @SerialName("image")
  val image: String,
  @SerialName("service_firm_ids")
  val serviceFirmIds: List<String>,
  @SerialName("service_worker_ids")
  val serviceWorkerIds: List<String>
)
