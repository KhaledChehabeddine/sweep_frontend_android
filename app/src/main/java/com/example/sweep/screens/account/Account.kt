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
import com.example.sweep.context.screens.AccountCategoryContext
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.account.AccountCategory
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun Account(paddingValues: PaddingValues) {
  val rememberAccountCategoryContext: AccountCategoryContext by remember {
    mutableStateOf(value = accountCategoryContext)
  }
  var rememberPageContextLoaded: Boolean by remember {
    mutableStateOf(value = false)
  }

  LaunchedEffect(key1 = rememberPageContextLoaded) {
    if (!rememberAccountCategoryContext.contextCollected) {
      var response = getApiClient().readAccountCategoryByName(name = "Main")
      var json = response.bodyAsText()
      rememberAccountCategoryContext.accountMainCategory =
        Json.decodeFromString<ApiResponse<AccountCategory>>(json).data!!

      response = getApiClient().readAccountCategoriesExcludeName(name = "Main")
      json = response.bodyAsText()
      rememberAccountCategoryContext.accountSubCategories =
        Json.decodeFromString<ApiResponse<List<AccountCategory>>>(json).data!!

      rememberAccountCategoryContext.contextCollected = true
    }

    rememberPageContextLoaded = true
  }

  if (!rememberAccountCategoryContext.contextCollected) {
    AccountLoading(paddingValues = paddingValues)
  } else {
    AccountLoaded(
      accountCategoryContext = rememberAccountCategoryContext,
      paddingValues = paddingValues
    )
  }
}
