package com.example.sweep.data.home

import com.example.sweep.data.home.metadata.HomeMainFeaturePromotionMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeMainFeaturePromotion(
  @SerialName("company_ids")
  val companyIds: List<String>,
  @SerialName("home_main_feature")
  val homeMainFeature: HomeMainFeature,
  @SerialName("_id")
  val id: String,
  @SerialName("metadata")
  val metadata: HomeMainFeaturePromotionMetadata,
  @SerialName("worker_ids")
  val workerIds: List<String>
)
