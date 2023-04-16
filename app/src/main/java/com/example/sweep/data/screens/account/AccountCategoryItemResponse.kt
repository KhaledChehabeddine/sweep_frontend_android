package com.example.sweep.data.screens.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCategoryItemResponse(
  @SerialName("account_category_name")
  val accountCategoryName: String,
  @SerialName("file_path")
  val filePath: String,
  @SerialName("_id")
  val id: String,
  @SerialName("image_url")
  val imageUrl: String,
  @SerialName("name")
  val name: String
)
