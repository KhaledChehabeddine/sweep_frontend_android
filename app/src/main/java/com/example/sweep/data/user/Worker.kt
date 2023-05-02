package com.example.sweep.data.user

import com.example.sweep.data.user.metadata.WorkerMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Worker(
  @SerialName("banner_image")
  val bannerImage: String = "",
  @SerialName("banner_image_path")
  val bannerImagePath: String,
  @SerialName("banner_image_url")
  val bannerImageUrl: String,
  @SerialName("company_id")
  val companyId: String,
  @SerialName("first_name")
  val firstName: String,
  @SerialName("_id")
  val id: String,
  @SerialName("last_name")
  val lastName: String,
  @SerialName("metadata")
  val metadata: WorkerMetadata,
  @SerialName("middle_name")
  val middleName: String,
  @SerialName("profile_image")
  val profileImage: String = "",
  @SerialName("profile_image_path")
  val profileImagePath: String,
  @SerialName("profile_image_url")
  val profileImageUrl: String,
  @SerialName("service_category_id")
  val serviceCategoryId: String,
  @SerialName("service_provider")
  val serviceProvider: ServiceProvider
)
