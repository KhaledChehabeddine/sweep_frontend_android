package com.example.sweep.context.screens.account

import com.example.sweep.data.screens.account.AccountCategoryItemResponse

data class AccountCategoryItemResponseContext(
  var contextCollected: Boolean,
  var accountCategoryItemResponsesMapByCategory: HashMap<String, List<AccountCategoryItemResponse>>
)
