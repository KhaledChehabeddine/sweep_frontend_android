package com.example.sweep.utilities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.isContainer
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.sweep.ui.theme.SweepTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun SweepSearchBar(systemUiController: SystemUiController) {
    val isActive = rememberSaveable {
        mutableStateOf(value = false)
    }
    val searchQuery = rememberSaveable {
        mutableStateOf(value = "")
    }

    val focusManager = LocalFocusManager.current

    systemUiController.setStatusBarColor(
        color = if (isActive.value) MaterialTheme.colorScheme.secondaryContainer
                else MaterialTheme.colorScheme.background
    )

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
                isActive.value = false
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
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.onSurface
                        ),
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
                        overlineText = {
                            Text(text = resultText)
                        },
                        icon = {
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
                        text = {
                            Text(text = "Additional info")
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        SweepSearchBar(systemUiController = rememberSystemUiController())
    }
}