package com.example.sweep.data.user.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserMetadata(
  @SerialName("created_date")
  val createdDate: String,
  @SerialName("last_login_date")
  val lastLoginDate: String,
  @SerialName("updated_date")
  val updatedDate: String
)
