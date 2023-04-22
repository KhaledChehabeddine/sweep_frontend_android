package com.example.sweep.screens.account

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.sweep.api.getApiClient
import com.example.sweep.context.accountCategoryContext
import com.example.sweep.context.accountCategoryItemResponseContext
import com.example.sweep.context.screens.account.AccountCategoryContext
import com.example.sweep.context.screens.account.AccountCategoryItemResponseContext
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.screens.account.AccountCategory
import com.example.sweep.data.screens.account.AccountCategoryItemResponse
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun Account(paddingValues: PaddingValues) {
  val rememberAccountCategoryContext: AccountCategoryContext by remember {
    mutableStateOf(value = accountCategoryContext)
  }
  val rememberAccountCategoryItemResponseContext: AccountCategoryItemResponseContext by remember {
    mutableStateOf(value = accountCategoryItemResponseContext)
  }
  var rememberStateLoaded: Boolean by remember {
    mutableStateOf(value = false)
  }

  LaunchedEffect(key1 = rememberStateLoaded) {
    if (!rememberAccountCategoryContext.contextCollected) {
      val response = getApiClient().readAccountCategories()
      val json = response.bodyAsText()
      rememberAccountCategoryContext.accountCategories =
        Json.decodeFromString<ApiResponse<List<AccountCategory>>>(json).data!!

      rememberAccountCategoryContext.contextCollected = true
    }

    if (!rememberAccountCategoryItemResponseContext.contextCollected) {
      for (accountCategory in rememberAccountCategoryContext.accountCategories) {
        val response = getApiClient().readAccountCategoryItemsByAccountCategoryName(
          accountCategoryName = accountCategory.name
        )
        val json = response.bodyAsText()
        rememberAccountCategoryItemResponseContext.accountCategoryItemResponsesMapByCategory[accountCategory.id] =
          Json.decodeFromString<ApiResponse<List<AccountCategoryItemResponse>>>(json).data!!
      }

      rememberAccountCategoryItemResponseContext.contextCollected = true
    }

    rememberStateLoaded = true
  }

  if (
    !rememberAccountCategoryContext.contextCollected ||
    !rememberAccountCategoryItemResponseContext.contextCollected
  ) {
    AccountLoading(paddingValues = paddingValues)
  } else {
    AccountLoaded(
      accountCategoryContext = rememberAccountCategoryContext,
      accountCategoryItemResponseContext = rememberAccountCategoryItemResponseContext,
      paddingValues = paddingValues
    )
  }
}
