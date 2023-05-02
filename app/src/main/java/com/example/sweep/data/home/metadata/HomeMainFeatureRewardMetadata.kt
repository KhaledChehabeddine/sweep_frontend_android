package com.example.sweep.data.home.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeMainFeatureRewardMetadata(
  @SerialName("total_amount_claimed")
  val totalAmountClaimed: Float,
  @SerialName("total_claimed_customers")
  val totalClaimedCustomers: Int
)
