package com.example.sweep.data.user.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyMetadata(
  @SerialName("banner_image_format")
  val bannerImageFormat: String,
  @SerialName("banner_image_height")
  val bannerImageHeight: Int,
  @SerialName("banner_image_width")
  val bannerImageWidth: Int,
  @SerialName("logo_image_format")
  val logoImageFormat: String,
  @SerialName("logo_image_height")
  val logoImageHeight: Int,
  @SerialName("logo_image_width")
  val logoImageWidth: Int,
  @SerialName("total_employees")
  val totalEmployees: Int,
  @SerialName("total_service_categories")
  val totalServiceCategories: Int
)
