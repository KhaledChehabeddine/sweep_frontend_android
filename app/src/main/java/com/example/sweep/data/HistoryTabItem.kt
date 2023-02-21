package com.example.sweep.data

import androidx.compose.foundation.layout.PaddingValues
import com.example.sweep.screens.history.tabs.FutureReservations
import com.example.sweep.screens.history.tabs.PastReservations

data class HistoryTabItem(
    val name: String
//    val screen: Unit
)

val historyTabItems = listOf(
    HistoryTabItem(
        name = "Past Reservations",
//        screen = PastReservations(paddingValues = PaddingValues())
    ),
    HistoryTabItem(
        name = "Future Reservations",
//        screen = FutureReservations(paddingValues = PaddingValues())
    )
)