package com.example.sweep.data.home

import com.example.sweep.data.home.metadata.HomeMainFeatureRewardMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeMainFeatureReward(
  @SerialName("amount")
  val amount: Float,
  @SerialName("claimed_customer_ids")
  val claimedCustomerIds: List<String>,
  @SerialName("code")
  val code: String,
  @SerialName("home_main_feature")
  val homeMainFeature: HomeMainFeature,
  @SerialName("_id")
  val id: String,
  @SerialName("metadata")
  val metadata: HomeMainFeatureRewardMetadata
)
