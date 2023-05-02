package com.example.sweep.data.account

import com.example.sweep.data.account.metadata.AccountCategoryMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCategory(
  @SerialName("account_category_items")
  val accountCategoryItems: List<AccountCategoryItem>,
  @SerialName("_id")
  val id: String,
  @SerialName("metadata")
  val metadata: AccountCategoryMetadata,
  @SerialName("name")
  val name: String
)
