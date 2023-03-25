package com.example.sweep.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme
import com.example.sweep.utilities.ServiceCategoryGrid

@Composable
fun SweepScreen(paddingValues: PaddingValues) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Row(modifier = Modifier.padding(vertical = 20.dp)) {
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    text = "Feel unsafe? Hire a Sweeper, hand-selected and verified employees from Sweep!",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row(modifier = Modifier.padding(top = 20.dp)) {
                ServiceCategoryGrid()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        SweepScreen(paddingValues = PaddingValues())
    }
}
