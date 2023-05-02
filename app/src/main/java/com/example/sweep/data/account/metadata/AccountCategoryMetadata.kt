package com.example.sweep.data.account.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCategoryMetadata(
  @SerialName("created_date")
  val createdDate: String,
  @SerialName("total_account_category_items")
  val totalAccountCategoryItems: Int,
  @SerialName("updated_date")
  val updatedDate: String
)
