package com.example.sweep.utilities.topbars

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun TopBarSearch() {
    CenterAlignedTopAppBar(
        actions = {
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
                onClick = {
                    /* TODO */
                }

            ) {
                Icon(
                    contentDescription = "Menu",
                    imageVector = Icons.Default.Menu,
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        navigationIcon = {
           IconButton(
               colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
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
        title = {
            val focusManager = LocalFocusManager.current
            val isFocused = remember {
                mutableStateOf(value = false)
            }
            val searchValue = remember {
                mutableStateOf(value = "")
            }

            OutlinedTextField(
                keyboardActions = KeyboardActions {
                    focusManager.clearFocus()
                },
                modifier = Modifier.onFocusChanged { focusState ->
                    isFocused.value = focusState.isFocused
                },
                onValueChange = { searchQuery ->
                    searchValue.value =  searchQuery
                },
                placeholder = {
                    Text(
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyMedium,
                        text = "Search for a firm or person"
                    )
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyMedium,
                trailingIcon = {
                    if (isFocused.value)
                        IconButton(
                            onClick = {
                                if (searchValue.value.isBlank()) focusManager.clearFocus()
                                searchValue.value = ""
                            }
                        ) {
                            Icon(
                                contentDescription = "Close",
                                imageVector = Icons.Default.Close,
                            )
                        }
                },
                value = searchValue.value
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        TopBarSearch()
    }
}