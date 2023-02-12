package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme
import com.example.sweep.utilities.ServiceCategoryGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
                           .padding(paddingValues = paddingValues)
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)
                                       .padding(all = 20.dp)
                ) {
                    Row {
                        Card(
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                            modifier = Modifier.height(height = 225.dp)
                                               .fillMaxWidth()
                                               .clickable {
                                                    /* TODO */
                                               }
                        ) {

                        }
                    }
                    Row(modifier = Modifier.padding(top = 20.dp)) {
                        ServiceCategoryGrid()
                    }
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)
                                          .fillMaxWidth()) {
                    for (i in 1..2) {
                        Row(modifier = Modifier.padding(
                                bottom = 10.dp,
                                end = 20.dp,
                                start = 20.dp,
                                top = 20.dp
                        )) {
                            Box(
                                modifier = Modifier.size(
                                    height = 24.dp,
                                    width = 240.dp
                                ).background(
                                    color = MaterialTheme.colorScheme.tertiary,
                                    shape = CircleShape
                                )
                            )
                        }
                        Row(modifier = Modifier.padding(
                                bottom = 20.dp,
                                end = 20.dp,
                                start = 20.dp
                        )) {
                            Box(
                                modifier = Modifier.size(
                                    height = 12.dp,
                                    width = 360.dp
                                ).background(
                                    color = MaterialTheme.colorScheme.tertiaryContainer,
                                    shape = CircleShape
                                )
                            )
                        }
                        LazyRow(modifier = Modifier.padding(
                                    bottom = 30.dp,
                                    start = 20.dp
                        )) {
                            item {
                                for (j in 1..3) {
                                    Card(
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                                        modifier = Modifier.size(
                                            height = 160.dp,
                                            width = 250.dp
                                        ).padding(end = 20.dp)
                                            .clickable {
                                                /* TODO */
                                            }
                                    ) {

                                    }
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