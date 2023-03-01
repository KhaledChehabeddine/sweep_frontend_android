package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.isContainer
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.sweep.ui.theme.SweepTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        val focusManager = LocalFocusManager.current
        val isActive = rememberSaveable {
            mutableStateOf(value = false)
        }
        val searchQuery = rememberSaveable {
            mutableStateOf(value = "")
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                               .zIndex(zIndex = 1f)
                               .semantics {
                                   isContainer = true
                               }
        ) {
            SearchBar(
                active = isActive.value,
                colors = SearchBarDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                leadingIcon = {
                    if (isActive.value)
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = MaterialTheme.colorScheme.onSurface
                            ),
                            onClick = {
                                /* TODO */
                            }
                        ) {
                            Icon(
                                contentDescription = "Arrow back",
                                imageVector = Icons.Default.ArrowBack,
                            )
                        }
                    else
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = MaterialTheme.colorScheme.onSurface
                            ),
                            onClick = {
                                /* TODO */
                            }
                        ) {
                            Icon(
                                contentDescription = "Search",
                                imageVector = Icons.Default.Search,
                            )
                        }
                },
                onQueryChange = { query ->
                    searchQuery.value = query
                },
                onActiveChange = { active ->
                    isActive.value = active
                    if (!isActive.value) focusManager.clearFocus()
                },
                onSearch = {
                    focusManager.clearFocus()
                },
                placeholder = {
                    Text(
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyMedium,
                        text = "Search for a firm or person"
                    )
                },
                query = searchQuery.value,
                trailingIcon = {
                    if (isActive.value)
                        IconButton(
                            onClick = {
                                if (searchQuery.value.isBlank()) {
                                    focusManager.clearFocus()
                                    isActive.value = false
                                }
                                searchQuery.value = ""
                            }
                        ) {
                            Icon(
                                contentDescription = "Close",
                                imageVector = Icons.Default.Close,
                            )
                        }
                    else
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = MaterialTheme.colorScheme.onSurface
                            ),
                            onClick = {
                                /* TODO */
                            }
                        ) {
                            Icon(
                                contentDescription = "Microphone",
                                imageVector = Icons.Outlined.Mic
                            )
                        }
                }
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(count = 4) { index ->
                        val resultText = "Suggestion $index"
                        ListItem(
                            headlineText = {
                                Text(text = resultText)
                            },
                            leadingContent = {
                                Icon(
                                    contentDescription = null,
                                    imageVector = Icons.Filled.Star
                                )
                            },
                            modifier = Modifier.clickable {
                                                    searchQuery.value = resultText
                                                    focusManager.clearFocus()
                                                    isActive.value = false
                                               },
                            supportingText = {
                                Text(text = "Additional info")
                            }
                        )
                    }
                }
            }
        }

        LazyColumn(
            modifier = Modifier.padding(
                                    end = 20.dp,
                                    start = 20.dp,
                                    top = 90.dp
                              )
        ) {
            item {
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                    text = "Recent Searches"
                )
                Spacer(modifier = Modifier.height(height = 10.dp))
                LazyRow {
                    item {
                        for (i in 0..5) {
                            if (i != 0) Spacer(modifier = Modifier.padding(start = 10.dp))
                            Box(
                                modifier = Modifier.size(
                                                        height = 40.dp,
                                                        width = 100.dp
                                                  ).clip(RoundedCornerShape(size = 10.dp))
                                                   .background(color = MaterialTheme.colorScheme.secondaryContainer)
                                                   .clickable(
                                                       indication = rememberRipple(
                                                           color = MaterialTheme.colorScheme.onSecondaryContainer
                                                       ),
                                                       interactionSource = remember {
                                                           MutableInteractionSource()
                                                       }
                                                   ) {
                                                       /* TODO */
                                                   }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(height = 20.dp))
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                    text = "Categories"
                )
                Spacer(modifier = Modifier.height(height = 15.dp))
                Column {
                    for (i in 0..9)
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(space = 10.dp)
                        ) {
                            for (j in 0..1)
                                Column(
                                    modifier = Modifier.fillMaxWidth()
                                                       .weight(1f)

                                ) {
                                    Box(
                                        modifier = Modifier.height(100.dp)
                                                           .fillMaxWidth()
                                                           .clip(RoundedCornerShape(10.dp))
                                                           .background(
                                                               color = MaterialTheme.colorScheme.secondaryContainer
                                                           )
                                                           .clickable(
                                                               indication = rememberRipple(
                                                                   color = MaterialTheme.colorScheme
                                                                                        .onSecondaryContainer
                                                               ),
                                                               interactionSource = remember {
                                                                   MutableInteractionSource()
                                                               }
                                                           ) {
                                                                /* TODO */
                                                           }
                                    )
                                    Spacer(modifier = Modifier.height(height = 10.dp))
                                    Box(
                                        modifier = Modifier.height(height = 16.dp)
                                                           .fillMaxWidth()
                                                           .clip(CircleShape)
                                                           .background(color = MaterialTheme.colorScheme.tertiary)
                                    )
                                    Spacer(modifier = Modifier.height(height = 5.dp))
                                    Box(
                                        modifier = Modifier.height(height = 10.dp)
                                                           .fillMaxWidth(fraction = 0.5f)
                                                           .clip(CircleShape)
                                                           .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                                    )
                                    Spacer(modifier = Modifier.height(height = 15.dp))
                                }
                        }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        SearchScreen()
    }
}