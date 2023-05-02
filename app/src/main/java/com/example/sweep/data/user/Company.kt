package com.example.sweep.data.user

import com.example.sweep.data.user.metadata.CompanyMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
  @SerialName("banner_image")
  val bannerImage: String = "",
  @SerialName("banner_image_path")
  val bannerImagePath: String,
  @SerialName("banner_image_url")
  val bannerImageUrl: String,
  @SerialName("_id")
  val id: String,
  @SerialName("logo_image")
  val logoImage: String = "",
  @SerialName("logo_image_path")
  val logoImagePath: String,
  @SerialName("logo_image_url")
  val logoImageUrl: String,
  @SerialName("name")
  val name: String,
  @SerialName("metadata")
  val metadata: CompanyMetadata,
  @SerialName("service_category_ids")
  val serviceCategoryIds: List<String>,
  @SerialName("service_provider")
  val serviceProvider: ServiceProvider
)
