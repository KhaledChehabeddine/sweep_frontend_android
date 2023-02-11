package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
                        ) {

                        }
                    }
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(77.5.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(top = 20.dp).height(height = 235.dp),
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
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)
                                          .fillMaxWidth()) {
                    Row(modifier = Modifier.padding(
                        start = 20.dp,
                        top = 20.dp,
                        end = 20.dp,
                        bottom = 10.dp
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
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 20.dp
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
                    Row(modifier = Modifier.padding(
                        start = 20.dp,
                        bottom = 30.dp
                    )) {
                        Card(
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                            modifier = Modifier.height(height = 160.dp)
                                .width(width = 250.dp)
                                .padding(end = 20.dp)
                        ) {

                        }
                        Card(
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                            modifier = Modifier.height(height = 160.dp)
                                .width(width = 250.dp)
                        ) {

                        }
                    }

                    Row(modifier = Modifier.padding(
                        start = 20.dp,
                        top = 20.dp,
                        end = 20.dp,
                        bottom = 10.dp
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
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 20.dp
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
                    Row(modifier = Modifier.padding(
                        start = 20.dp,
                        bottom = 30.dp
                    )) {
                        Card(
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                            modifier = Modifier.height(height = 160.dp)
                                .width(width = 250.dp)
                                .padding(end = 20.dp)
                        ) {

                        }
                        Card(
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                            modifier = Modifier.height(height = 160.dp)
                                .width(width = 250.dp)
                        ) {

                        }
                    }
                }
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(paddingValues: PaddingValues) {
//    Surface(
//        color = MaterialTheme.colorScheme.background,
//        modifier = Modifier.fillMaxSize()
//                           .padding(paddingValues)
//    ) {
//        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally){
//            item {
//                Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)
//                    .padding(all = 20.dp)) {
//                    Row {
//                        Card(
//                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
//                            modifier = Modifier.height(height = 225.dp)
//                                .fillMaxWidth()
//                        ) {
//
//                        }
//                    }
//                    LazyVerticalGrid(
//                        columns = GridCells.Adaptive(77.5.dp),
//                        horizontalArrangement = Arrangement.spacedBy(10.dp),
//                        modifier = Modifier.padding(top = 20.dp),
//                        verticalArrangement = Arrangement.spacedBy(10.dp)
//                    ) {
//                        items(serviceCategories) { serviceCategory ->
//                            Card(
//                                colors = CardDefaults.cardColors(
//                                    containerColor = MaterialTheme.colorScheme.secondaryContainer
//                                ),
//                                modifier = Modifier.height(height = 112.5.dp)
//                            ) {
//                                Column(
//                                    modifier = Modifier.fillMaxSize(),
//                                    verticalArrangement = Arrangement.Center
//                                ) {
//                                    Row(
//                                        horizontalArrangement = Arrangement.Center,
//                                        modifier = Modifier.fillMaxWidth()
//                                    ) {
//                                        IconButton(
//                                            colors = IconButtonDefaults.iconButtonColors(
//                                                containerColor = MaterialTheme.colorScheme.onBackground,
//                                                contentColor = MaterialTheme.colorScheme.onSecondary
//                                            ),
//                                            modifier = Modifier.clip(CircleShape).then(Modifier.size(50.dp)),
//                                            onClick = {
//                                                /* TODO */
//                                            }
//                                        ) {
//                                            Icon(
//                                                contentDescription = serviceCategory.name,
//                                                imageVector = serviceCategory.icon,
//                                            )
//                                        }
//                                    }
//                                    Row(
//                                        horizontalArrangement = Arrangement.Center,
//                                        modifier = Modifier.fillMaxWidth()
//                                            .padding(top = 20.dp)
//                                    ) {
//                                        Text(
//                                            color = MaterialTheme.colorScheme.onSurface,
//                                            text = serviceCategory.name,
//                                            style = MaterialTheme.typography.labelMedium
//                                        )
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                Spacer(modifier = Modifier.padding(top = 20.dp))
//                Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)
//                    .fillMaxWidth()) {
//                    Row(modifier = Modifier.padding(
//                        start = 20.dp,
//                        top = 20.dp,
//                        end = 20.dp,
//                        bottom = 10.dp
//                    )) {
//                        Box(
//                            modifier = Modifier.size(
//                                height = 24.dp,
//                                width = 240.dp
//                            ).background(
//                                color = MaterialTheme.colorScheme.tertiary,
//                                shape = CircleShape
//                            )
//                        )
//                    }
//                    Row(modifier = Modifier.padding(
//                        start = 20.dp,
//                        end = 20.dp,
//                        bottom = 20.dp
//                    )) {
//                        Box(
//                            modifier = Modifier.size(
//                                height = 12.dp,
//                                width = 360.dp
//                            ).background(
//                                color = MaterialTheme.colorScheme.tertiaryContainer,
//                                shape = CircleShape
//                            )
//                        )
//                    }
//                    Row(modifier = Modifier.padding(
//                        start = 20.dp,
//                        bottom = 20.dp
//                    )) {
//                        Card(
//                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
//                            modifier = Modifier.height(height = 180.dp)
//                                .width(width = 250.dp)
//                                .padding(end = 20.dp)
//                        ) {
//
//                        }
//                        Card(
//                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
//                            modifier = Modifier.height(height = 180.dp)
//                                .width(width = 250.dp)
//                        ) {
//
//                        }
//                    }
//                    Row(modifier = Modifier.padding(
//                        start = 20.dp,
//                        bottom = 20.dp
//                    )) {
//                        Card(
//                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
//                            modifier = Modifier.height(height = 180.dp)
//                                .width(width = 250.dp)
//                                .padding(end = 20.dp)
//                        ) {
//
//                        }
//                        Card(
//                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
//                            modifier = Modifier.height(height = 180.dp)
//                                .width(width = 250.dp)
//                        ) {
//
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        HomeScreen(PaddingValues())
    }
}