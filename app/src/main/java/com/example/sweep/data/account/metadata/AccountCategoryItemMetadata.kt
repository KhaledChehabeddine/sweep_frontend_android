package com.example.sweep.data.account.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCategoryItemMetadata(
  @SerialName("image_format")
  val imageFormat: String,
  @SerialName("image_height")
  val imageHeight: Int,
  @SerialName("image_width")
  val imageWidth: Int
)
