package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.data.SubCategory
import com.example.sweep.data.accountCategories
import com.example.sweep.data.accountDetailsCategories
import com.example.sweep.data.financesCategories
import com.example.sweep.data.helpCenterCategories
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
                            accountCategories.forEach { accountCategory ->
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
                                            contentDescription = accountCategory.name,
                                            imageVector = accountCategory.icon,
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
                                            text = accountCategory.name
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                Row {
                    Box(
                        modifier = Modifier.height(height = 278.dp)
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
                                    text = "Account Details"
                                )
                            }
                            DisplaySubCategory(subCategories = accountDetailsCategories)
                        }
                    }
                }
                Row {
                    Box(
                        modifier = Modifier.height(height = 233.dp)
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
                                    text = "Finances"
                                )
                            }
                            DisplaySubCategory(subCategories = financesCategories)
                        }
                    }
                }
                Row {
                    Box(
                        modifier = Modifier.height(height = 233.dp)
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
                                    text = "Help Center"
                                )
                            }
                            DisplaySubCategory(subCategories = helpCenterCategories)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DisplaySubCategory(subCategories: List<SubCategory>) {
    subCategories.forEach { subCategory ->
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
                    contentDescription = subCategory.name,
                    imageVector = subCategory.icon,
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 10.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    text = subCategory.name
                )
            }
        }
        if (!subCategory.isLast) Divider()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        AccountScreen(paddingValues = PaddingValues())
    }
}
