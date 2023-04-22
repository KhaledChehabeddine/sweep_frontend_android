package com.example.sweep.screens.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sweep.context.screens.account.AccountCategoryContext
import com.example.sweep.context.screens.account.AccountCategoryItemResponseContext
import com.example.sweep.data.screens.account.AccountCategoryItemResponse
import com.example.sweep.functions.svgS3UrlToPainter

@Composable
fun AccountLoaded(
  accountCategoryContext: AccountCategoryContext,
  accountCategoryItemResponseContext: AccountCategoryItemResponseContext,
  paddingValues: PaddingValues
) {
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
                accountCategoryItemResponseContext
                  .accountCategoryItemResponsesMapByCategory[accountCategoryContext.accountCategories[0].id]!!
                  .forEach { accountMainCategoryItemResponse ->
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
                              /* TODO */
                            }
                        ) {
                          Image(
                            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface),
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
        for (index in 1 until accountCategoryItemResponseContext.accountCategoryItemResponsesMapByCategory.size) {
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
                      text = accountCategoryContext.accountCategories[index].name
                    )
                  }
                  Spacer(modifier = Modifier.height(height = 5.dp))
                  AccountSubCategory(
                    accountCategoryItemResponses =
                    accountCategoryItemResponseContext
                      .accountCategoryItemResponsesMapByCategory[accountCategoryContext.accountCategories[index].id]!!
                  )
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
private fun AccountSubCategory(accountCategoryItemResponses: List<AccountCategoryItemResponse>) {
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
          colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface),
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