package com.example.sweep.data.user.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkerMetadata(
  @SerialName("banner_image_format")
  val bannerImageFormat: String,
  @SerialName("banner_image_height")
  val bannerImageHeight: Int,
  @SerialName("banner_image_width")
  val bannerImageWidth: Int,
  @SerialName("formatted_name")
  val formattedName: String,
  @SerialName("profile_image_format")
  val profileImageFormat: String,
  @SerialName("profile_image_height")
  val profileImageHeight: Int,
  @SerialName("profile_image_width")
  val profileImageWidth: Int
)
