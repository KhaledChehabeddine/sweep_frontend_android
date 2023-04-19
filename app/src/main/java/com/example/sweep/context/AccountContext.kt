package com.example.sweep.context

import com.example.sweep.data.screens.account.AccountCategory
import com.example.sweep.data.screens.account.AccountCategoryItemResponse

data class AccountContext(
  var accountCategories: List<AccountCategory>,
  var accountCategoryItemResponsesByCategory: List<List<AccountCategoryItemResponse>>,
  var accountContextCollected: Boolean
)
