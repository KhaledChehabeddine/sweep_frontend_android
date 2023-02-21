package com.example.sweep.utilities.topbars

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.data.historyTabItems
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun TopBarHistory() {
    CenterAlignedTopAppBar(
        actions = { },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = { },
        title = {
            var state by remember {
                mutableStateOf(0)
            }

            TabRow(
                containerColor = MaterialTheme.colorScheme.background,
                selectedTabIndex = state
            ) {
                historyTabItems.forEachIndexed { index, historyTabItem ->
                    Tab(
                        onClick = {
                            state = index
                        },
                        text = {
                            Text(
                                style = MaterialTheme.typography.bodyMedium,
                                text = historyTabItem.name
                            )
                        },
                        selected = state == index,
                        unselectedContentColor = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        TopBarHistory()
    }
}