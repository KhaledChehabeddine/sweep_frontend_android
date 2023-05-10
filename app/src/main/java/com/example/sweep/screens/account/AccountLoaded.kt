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
import com.example.sweep.context.screens.AccountCategoryContext
import com.example.sweep.data.account.AccountCategoryItem
import com.example.sweep.destinations.AddressesDestination
import com.example.sweep.destinations.ComingSoonDestination
import com.example.sweep.destinations.FavoritesDestination
import com.example.sweep.destinations.ProfileDestination
import com.example.sweep.destinations.SupportDestination
import com.example.sweep.functions.svgS3UrlToPainter
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun AccountLoaded(
  accountCategoryContext: AccountCategoryContext,
  paddingValues: PaddingValues,
  navigator: DestinationsNavigator
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
                accountCategoryContext.accountMainCategory?.accountCategoryItems?.forEach { accountCategoryItem ->
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
                            when (accountCategoryItem.name) {
                              "Profile" -> {
                                navigator.navigate(direction = ProfileDestination())
                              }
                              "Support" -> {
                                navigator.navigate(direction = SupportDestination())
                              }
                              "Language" -> {
                                navigator.navigate(direction = ComingSoonDestination())
                              }
                              "Payments" -> {
                                navigator.navigate(direction = ComingSoonDestination())
                              }
                            }
                          }
                      ) {
                        Image(
                          colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface),
                          contentDescription = accountCategoryItem.name,
                          modifier = Modifier.size(size = 40.dp),
                          painter = svgS3UrlToPainter(url = accountCategoryItem.imageUrl)
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
                        text = accountCategoryItem.name
                      )
                    }
                  }
                }
              }
            }
          }
        }
        repeat(accountCategoryContext.accountSubCategories.size) { index ->
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
                Column(modifier = Modifier.padding(all = 20.dp)) {
                  Row {
                    Text(
                      color = MaterialTheme.colorScheme.onSurface,
                      style = MaterialTheme.typography.headlineMedium,
                      text = accountCategoryContext.accountSubCategories[index].name
                    )
                  }
                  Spacer(modifier = Modifier.height(height = 5.dp))
                  AccountSubCategory(
                    navigator = navigator,
                    accountCategoryItems = accountCategoryContext.accountSubCategories[index].accountCategoryItems
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

@Destination
@Composable
fun AccountSubCategory(
  navigator: DestinationsNavigator,
  accountCategoryItems: List<AccountCategoryItem>
) {
  accountCategoryItems.forEachIndexed { index, accountCategoryItem ->
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .clickable(
          indication = rememberRipple(color = MaterialTheme.colorScheme.primaryContainer),
          interactionSource = remember {
            MutableInteractionSource()
          }
        ) {
          when (accountCategoryItem.name) {
            "Addresses" -> {
              navigator.navigate(direction = AddressesDestination())
            }
            "Favorites" -> {
              navigator.navigate(direction = FavoritesDestination())
            }
            "Notifications" -> {
              navigator.navigate(direction = ComingSoonDestination())
            }
            "Preferences" -> {
              navigator.navigate(direction = ComingSoonDestination())
            }
            "Add Funds" -> {
              navigator.navigate(direction = ComingSoonDestination())
            }
            "Send Funds" -> {
              navigator.navigate(direction = ComingSoonDestination())
            }
            "Wallet" -> {
              navigator.navigate(direction = ComingSoonDestination())
            }
            "FAQ" -> {
              navigator.navigate(direction = ComingSoonDestination())
            }
            "Legal" -> {
              navigator.navigate(direction = ComingSoonDestination())
            }
            "Support Tickets" -> {
              navigator.navigate(direction = ComingSoonDestination())
            }
          }
        }
    ) {
      Row(
        modifier = Modifier.padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Image(
          colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface),
          contentDescription = accountCategoryItem.name,
          modifier = Modifier.size(size = 24.dp),
          painter = svgS3UrlToPainter(url = accountCategoryItem.imageUrl)
        )
        Text(
          color = MaterialTheme.colorScheme.onSurface,
          fontWeight = FontWeight.Medium,
          modifier = Modifier.padding(start = 10.dp),
          style = MaterialTheme.typography.displayMedium,
          text = accountCategoryItem.name
        )
      }
    }
    if (index != accountCategoryItems.size - 1) Divider()
  }
}
