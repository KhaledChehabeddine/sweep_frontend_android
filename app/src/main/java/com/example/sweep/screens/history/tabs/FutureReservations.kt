package com.example.sweep.screens.history.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.screens.history.DisplayHistoryTabItems
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun FutureReservations(paddingValues: PaddingValues) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                for (i in 0..2) {
                    DisplayHistoryTabItems()
                    if (i != 2) Spacer(modifier = Modifier.height(height = 20.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        FutureReservations(paddingValues = PaddingValues())
    }
}
