package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.data.serviceCategories
import com.example.sweep.ui.theme.SweepTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
                           .padding(paddingValues)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Column(
                Modifier.background(color = MaterialTheme.colorScheme.onBackground)
                        .padding(all = 20.dp)
            ) {
                Row {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                        modifier = Modifier.height(height = 225.dp)
                                           .fillMaxWidth()
                    ) {

                    }
                }
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(77.5.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(serviceCategories) { serviceCategory ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer
                            ),
                            modifier = Modifier.height(height = 112.5.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    IconButton(
                                        colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = MaterialTheme.colorScheme.onBackground,
                                            contentColor = MaterialTheme.colorScheme.onSecondary
                                        ),
                                        modifier = Modifier.clip(CircleShape).then(Modifier.size(50.dp)),
                                        onClick = {
                                            /* TODO */
                                        }
                                    ) {
                                        Icon(
                                            contentDescription = serviceCategory.name,
                                            imageVector = serviceCategory.icon,
                                        )
                                    }
                                }
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxWidth()
                                                       .padding(top = 10.dp)
                                ) {
                                    Text(
                                        text = serviceCategory.name,
                                        color = MaterialTheme.colorScheme.onSurface,
                                    )
                                }
                            }
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
        HomeScreen(PaddingValues())
    }
}