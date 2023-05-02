package com.example.sweep.context.screens

import com.example.sweep.data.account.AccountCategory

data class AccountCategoryContext(
  var contextCollected: Boolean,
  var accountMainCategory: AccountCategory?,
  var accountSubCategories: List<AccountCategory>
)
