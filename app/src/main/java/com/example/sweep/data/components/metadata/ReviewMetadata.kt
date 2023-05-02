package com.example.sweep.data.components.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewMetadata(
  @SerialName("created_date")
  val createdDate: String
)
