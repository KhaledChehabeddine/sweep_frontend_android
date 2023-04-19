package com.example.sweep.data.screens.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeMainFeatureItemResponse(
  @SerialName("file_path")
  val filePath: String,
  @SerialName("_id")
  val id: String,
  @SerialName("image")
  val image: String,
  @SerialName("promotion_home_feature_item_ids")
  val promotionHomeFeatureItemIds: List<String>,
  @SerialName("reward_amount")
  val rewardAmount: Float,
  @SerialName("reward_code")
  val rewardCode: String,
  @SerialName("type")
  val type: String
)
