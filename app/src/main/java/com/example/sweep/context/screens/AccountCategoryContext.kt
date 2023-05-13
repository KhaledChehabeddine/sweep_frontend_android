package com.example.sweep.context.screens

import com.example.sweep.data.account.AccountCategory
import kotlinx.serialization.Serializable

@Serializable
data class AccountCategoryContext(
  var contextCollected: Boolean,
  var accountMainCategory: AccountCategory?,
  var accountSubCategories: List<AccountCategory>
)
