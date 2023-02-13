package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme
import com.example.sweep.utilities.ServiceCategoryGrid

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
                        Box(
                            modifier = Modifier.height(height = 225.dp)
                                               .fillMaxWidth()
                                               .clip(RoundedCornerShape(percent = 8))
                                               .background(color = MaterialTheme.colorScheme.secondaryContainer)
                                               .clickable(
                                                   indication = rememberRipple(
                                                       color = MaterialTheme.colorScheme
                                                           .onSecondaryContainer
                                                   ),
                                                   interactionSource = remember {
                                                       MutableInteractionSource()
                                                   }
                                               ) {
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
                                    Box(modifier = Modifier.size(
                                                                height = 160.dp,
                                                                width = 250.dp
                                                          ).padding(end = 20.dp)
                                                           .clip(RoundedCornerShape(percent = 8))
                                                           .background(
                                                               color = MaterialTheme.colorScheme.secondaryContainer
                                                           )
                                                           .clickable(
                                                               indication = rememberRipple(
                                                                   color = MaterialTheme.colorScheme
                                                                                        .onSecondaryContainer
                                                               ),
                                                               interactionSource = remember {
                                                                     MutableInteractionSource()
                                                               }
                                                           ) {
                                                                /* TODO */
                                                           }
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