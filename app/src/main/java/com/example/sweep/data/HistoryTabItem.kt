package com.example.sweep.data

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.sweep.screens.history.tabs.FutureReservations
import com.example.sweep.screens.history.tabs.PastReservations

data class HistoryTabItem(
    val name: String,
    val screen: @Composable (PaddingValues) -> Unit
)

val historyTabItems = listOf(
    HistoryTabItem(
        name = "Past Reservations",
        screen = { paddingValues ->
            PastReservations(paddingValues = paddingValues)
        }
    ),
    HistoryTabItem(
        name = "Future Reservations",
        screen = { paddingValues ->
            FutureReservations(paddingValues = paddingValues)
        }
    )
)
