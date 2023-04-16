package com.example.sweep.context

import com.example.sweep.data.screens.account.AccountCategory
import com.example.sweep.data.screens.account.AccountCategoryItemResponse

data class AccountContext(
  var accountContextCollected: Boolean,
  var accountCategories: List<AccountCategory>,
  var accountCategoryItemResponsesByCategory: List<List<AccountCategoryItemResponse>>
)
