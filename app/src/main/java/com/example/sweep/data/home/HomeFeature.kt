package com.example.sweep.data.home

import com.example.sweep.data.home.metadata.HomeFeatureMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeFeature(
  @SerialName("active")
  val active: Boolean,
  @SerialName("home_feature_type")
  val homeFeatureType: String,
  @SerialName("metadata")
  val metadata: HomeFeatureMetadata,
  @SerialName("priority")
  val priority: Int
)
