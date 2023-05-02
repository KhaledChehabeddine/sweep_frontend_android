package com.example.sweep.data.home

import com.example.sweep.data.home.metadata.HomeSubFeatureMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeSubFeature(
  @SerialName("company_ids")
  val companyIds: List<String>,
  @SerialName("home_feature")
  val homeFeature: HomeFeature,
  @SerialName("_id")
  val id: String,
  @SerialName("metadata")
  val metadata: HomeSubFeatureMetadata,
  @SerialName("subtitle")
  val subtitle: String,
  @SerialName("title")
  val title: String,
  @SerialName("worker_ids")
  val workerIds: List<String>
)
