package com.example.sweep.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sweep.api.getApiClient
import com.example.sweep.context.accountContext
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.screens.account.AccountCategory
import com.example.sweep.data.screens.account.AccountCategoryItemResponse
import com.example.sweep.functions.svgS3UrlToPainter
import com.example.sweep.screens.loading.AccountLoading
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun Account(paddingValues: PaddingValues) {
  var rememberAccountCategories: List<AccountCategory> by remember {
    mutableStateOf(value = accountContext.accountCategories)
  }
  var rememberAccountCategoryItemResponsesByCategory: List<List<AccountCategoryItemResponse>> by remember {
    mutableStateOf(value = accountContext.accountCategoryItemResponsesByCategory)
  }
  var rememberAccountContextCollected: Boolean by remember {
    mutableStateOf(value = accountContext.accountContextCollected)
  }

  LaunchedEffect(Unit) {
    if (rememberAccountContextCollected) return@LaunchedEffect

    var response = getApiClient().readAccountCategories()
    var json = response.bodyAsText()
    rememberAccountCategories = Json.decodeFromString<ApiResponse<List<AccountCategory>>>(json).data!!

    for (accountCategory in rememberAccountCategories) {
      response = getApiClient().readAccountCategoryItemsByAccountCategoryName(
        accountCategoryName = accountCategory.name
      )
      json = response.bodyAsText()
      rememberAccountCategoryItemResponsesByCategory +=
        listOf(Json.decodeFromString<ApiResponse<List<AccountCategoryItemResponse>>>(json).data!!)
    }

    rememberAccountContextCollected = true
    accountContext.accountCategories = rememberAccountCategories
    accountContext.accountCategoryItemResponsesByCategory = rememberAccountCategoryItemResponsesByCategory
    accountContext.accountContextCollected = true
  }

  if (!rememberAccountContextCollected) {
    AccountLoading(paddingValues = paddingValues)
  } else {
    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
    ) {
      LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        item {
          Row {
            BoxWithConstraints {
              Box(
                modifier = Modifier
                  .height(height = maxHeight)
                  .fillMaxWidth()
                  .padding(all = 20.dp)
                  .clip(MaterialTheme.shapes.small)
                  .background(color = MaterialTheme.colorScheme.onBackground)
              ) {
                Row(
                  horizontalArrangement = Arrangement.SpaceBetween,
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                      horizontal = 20.dp,
                      vertical = 10.dp
                    )
                ) {
                  rememberAccountCategoryItemResponsesByCategory[0].forEach { accountMainCategoryItemResponse ->
                    Column(
                      modifier = Modifier.fillMaxHeight(),
                      verticalArrangement = Arrangement.Center
                    ) {
                      Row {
                        Box(
                          contentAlignment = Alignment.Center,
                          modifier = Modifier
                            .size(size = 60.dp)
                            .clip(MaterialTheme.shapes.small)
                            .background(color = MaterialTheme.colorScheme.background)
                            .clickable(
                              indication = rememberRipple(color = MaterialTheme.colorScheme.secondary),
                              interactionSource = remember {
                                MutableInteractionSource()
                              }
                            ) {
                            }
                        ) {
                          Image(
                            contentDescription = accountMainCategoryItemResponse.name,
                            modifier = Modifier.size(size = 40.dp),
                            painter = svgS3UrlToPainter(url = accountMainCategoryItemResponse.imageUrl)
                          )
                        }
                      }
                      Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                          .width(width = 60.dp)
                          .padding(top = 5.dp)
                      ) {
                        Text(
                          color = MaterialTheme.colorScheme.onSurface,
                          style = MaterialTheme.typography.displayMedium,
                          text = accountMainCategoryItemResponse.name
                        )
                      }
                    }
                  }
                }
              }
            }
          }
          for (index in 1 until rememberAccountCategoryItemResponsesByCategory.size) {
            Row {
              BoxWithConstraints {
                Box(
                  modifier = Modifier
                    .height(height = maxHeight)
                    .fillMaxWidth()
                    .padding(all = 20.dp)
                    .clip(RoundedCornerShape(percent = 8))
                    .background(color = MaterialTheme.colorScheme.onBackground)
                ) {
                  Column(modifier = Modifier.padding(all = 20.dp)) {
                    Row {
                      Text(
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineMedium,
                        text = rememberAccountCategories[index].name
                      )
                    }
                    Spacer(modifier = Modifier.height(height = 5.dp))
                    SubCategory(accountCategoryItemResponses = rememberAccountCategoryItemResponsesByCategory[index])
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

@Composable
private fun SubCategory(accountCategoryItemResponses: List<AccountCategoryItemResponse>) {
  accountCategoryItemResponses.forEachIndexed { index, accountCategoryItemResponse ->
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .clickable(
          indication = rememberRipple(color = MaterialTheme.colorScheme.primaryContainer),
          interactionSource = remember {
            MutableInteractionSource()
          }
        ) {
        }
    ) {
      Row(
        modifier = Modifier.padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Image(
          contentDescription = accountCategoryItemResponse.name,
          modifier = Modifier.size(size = 24.dp),
          painter = svgS3UrlToPainter(url = accountCategoryItemResponse.imageUrl)
        )
        Text(
          color = MaterialTheme.colorScheme.onSurface,
          fontWeight = FontWeight.Medium,
          modifier = Modifier.padding(start = 10.dp),
          style = MaterialTheme.typography.displayMedium,
          text = accountCategoryItemResponse.name
        )
      }
    }
    if (index != accountCategoryItemResponses.size - 1) Divider()
  }
}
