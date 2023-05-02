package com.example.sweep.data.home.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeSubFeatureMetadata(
  @SerialName("total_companies")
  val totalCompanies: Int,
  @SerialName("total_service_providers")
  val totalServiceProviders: Int,
  @SerialName("total_workers")
  val totalWorkers: Int
)
