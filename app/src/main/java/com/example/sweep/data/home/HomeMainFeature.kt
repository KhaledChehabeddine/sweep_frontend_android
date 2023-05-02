package com.example.sweep.data.home

import com.example.sweep.data.home.metadata.HomeMainFeatureMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeMainFeature(
  @SerialName("home_feature")
  val homeFeature: HomeFeature,
  @SerialName("home_main_feature_type")
  val homeMainFeatureType: String,
  @SerialName("image")
  val image: String = "",
  @SerialName("image_path")
  val imagePath: String,
  @SerialName("image_url")
  val imageUrl: String,
  @SerialName("metadata")
  val metadata: HomeMainFeatureMetadata
)
