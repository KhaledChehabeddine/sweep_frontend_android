package com.example.sweep.utilities

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.data.serviceCategories
import com.example.sweep.ui.theme.SweepTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceCategoryGrid() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(77.5.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.height(height = 235.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(serviceCategories) { serviceCategory ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier.height(height = 112.5.dp).clickable {
                    /* TODO */
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(size = 50.dp)
                                               .background(
                                                   color = MaterialTheme.colorScheme.onBackground,
                                                   shape = CircleShape
                                               )
                        ) {
                            Icon(
                                contentDescription = serviceCategory.name,
                                imageVector = serviceCategory.icon,
                                modifier = Modifier.size(size = 30.dp),
                            )
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Text(
                            color = MaterialTheme.colorScheme.onSurface,
                            text = serviceCategory.name,
                            style = MaterialTheme.typography.labelMedium
                        )
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
        ServiceCategoryGrid()
    }
}