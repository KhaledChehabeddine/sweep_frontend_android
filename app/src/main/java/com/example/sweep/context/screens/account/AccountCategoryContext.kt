package com.example.sweep.context.screens.account

import com.example.sweep.data.screens.account.AccountCategory

data class AccountCategoryContext(
  var contextCollected: Boolean,
  var accountCategories: List<AccountCategory>
)
