package com.example.sweep.data.account

import com.example.sweep.data.account.metadata.AccountCategoryItemMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCategoryItem(
  @SerialName("image")
  val image: String = "",
  @SerialName("image_path")
  val imagePath: String,
  @SerialName("image_url")
  val imageUrl: String,
  @SerialName("metadata")
  val metadata: AccountCategoryItemMetadata,
  @SerialName("name")
  val name: String
)
