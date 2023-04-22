package com.example.sweep.data.screens.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeMainFeatureRewardResponse(
  @SerialName("amount")
  val amount: Float,
  @SerialName("code")
  val code: String,
  @SerialName("file_path")
  val filePath: String,
  @SerialName("_id")
  val id: String,
  @SerialName("image_url")
  val imageUrl: String
)
