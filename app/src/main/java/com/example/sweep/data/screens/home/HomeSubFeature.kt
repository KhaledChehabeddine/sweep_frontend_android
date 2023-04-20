package com.example.sweep.data.screens.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeSubFeature(
  @SerialName("home_feature_item_ids")
  val homeFeatureItemIds: List<String>,
  @SerialName("_id")
  val id: String,
  @SerialName("subtitle")
  val subtitle: String,
  @SerialName("title")
  val title: String
)