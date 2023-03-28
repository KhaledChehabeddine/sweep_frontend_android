package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.data.screens.account.AccountSubCategory
import com.example.sweep.data.screens.account.accountMainCategory
import com.example.sweep.data.screens.account.accountSubCategories
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun AccountScreen(paddingValues: PaddingValues) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Row {
                    Box(
                        modifier = Modifier.height(height = 150.dp)
                            .fillMaxWidth()
                            .padding(all = 20.dp)
                            .clip(RoundedCornerShape(percent = 8))
                            .background(
                                color = MaterialTheme.colorScheme.onBackground
                            )
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 20.dp)
                        ) {
                            accountMainCategory.mainCategoryItems.forEach { accountMainCategoryItem ->
                                Column(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier.size(size = 60.dp)
                                            .clip(RoundedCornerShape(percent = 16))
                                            .background(
                                                color = MaterialTheme.colorScheme.background
                                            ).clickable(
                                                indication = rememberRipple(
                                                    color = MaterialTheme.colorScheme.secondary
                                                ),
                                                interactionSource = remember {
                                                    MutableInteractionSource()
                                                }
                                            ) {
                                            }
                                    ) {
                                        Icon(
                                            contentDescription = accountMainCategoryItem.name,
                                            imageVector = accountMainCategoryItem.icon,
                                            tint = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.size(size = 40.dp)
                                        )
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        modifier = Modifier.width(width = 60.dp)
                                            .padding(top = 5.dp)
                                    ) {
                                        Text(
                                            color = MaterialTheme.colorScheme.onSurface,
                                            style = MaterialTheme.typography.displayMedium,
                                            text = accountMainCategoryItem.name
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                accountSubCategories.forEach { accountSubCategory ->
                    Row {
                        BoxWithConstraints {
                            Box(
                                modifier = Modifier.height(height = maxHeight)
                                    .fillMaxWidth()
                                    .padding(all = 20.dp)
                                    .clip(RoundedCornerShape(percent = 8))
                                    .background(
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                            ) {
                                Column(modifier = Modifier.padding(all = 20.dp)) {
                                    Row {
                                        Text(
                                            color = MaterialTheme.colorScheme.onSurface,
                                            style = MaterialTheme.typography.headlineMedium,
                                            text = accountSubCategory.category
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(height = 5.dp))
                                    DisplaySubCategory(subCategory = accountSubCategory)
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
private fun DisplaySubCategory(subCategory: AccountSubCategory) {
    var subCategorySize = subCategory.subCategoryItems.size
    subCategory.subCategoryItems.forEach { subCategoryItem ->
        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable(
                    indication = rememberRipple(
                        color = MaterialTheme.colorScheme.primaryContainer
                    ),
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
                Icon(
                    contentDescription = subCategoryItem.name,
                    imageVector = subCategoryItem.icon,
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 10.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    text = subCategoryItem.name
                )
            }
        }
        if (--subCategorySize != 0) Divider()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        AccountScreen(paddingValues = PaddingValues())
    }
}
