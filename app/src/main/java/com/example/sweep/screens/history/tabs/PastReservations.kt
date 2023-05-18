package com.example.sweep.screens.history.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun PastReservations(paddingValues: PaddingValues) {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier.fillMaxSize()
      .padding(paddingValues = paddingValues)
  ) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
      item {
        Row(
          modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.onBackground)
            .clickable(
              indication = rememberRipple(
                color = MaterialTheme.colorScheme.onSecondaryContainer
              ),
              interactionSource = remember {
                MutableInteractionSource()
              }
            ) {
            }.padding(all = 20.dp)
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
          ) {
            Box(
              modifier = Modifier.size(size = 80.dp)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
            )
          }
          Spacer(modifier = Modifier.padding(all = 5.dp))
          Column {
            Text(
              text = "Jamil's Cleaning Services",
              color = MaterialTheme.colorScheme.onSecondary,
            )
            Spacer(modifier = Modifier.height(height = 5.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Column() {
                Text(
                  text = "May 20, 2023",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(height = 5.dp))
                Text(
                  text = "2:00 PM - 3:00 PM",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
              }

              Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                  .clip(MaterialTheme.shapes.small)
              ) {
                Text(text = "Review")
              }
            }
          }
        }
        Spacer(modifier = Modifier.padding(all = 5.dp))
        Row(
          modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.onBackground)
            .clickable(
              indication = rememberRipple(
                color = MaterialTheme.colorScheme.onSecondaryContainer
              ),
              interactionSource = remember {
                MutableInteractionSource()
              }
            ) {
            }.padding(all = 20.dp)
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
          ) {
            Box(
              modifier = Modifier.size(size = 80.dp)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
            )
          }
          Spacer(modifier = Modifier.padding(all = 5.dp))
          Column {
            Text(
              text = "Anti-Pests",
              color = MaterialTheme.colorScheme.onSecondary,
            )
            Spacer(modifier = Modifier.height(height = 5.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Column() {
                Text(
                  text = "March 5, 2023",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(height = 5.dp))
                Text(
                  text = "10:00 AM - 1:00 PM",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
              }

              Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                  .clip(MaterialTheme.shapes.small)
              ) {
                Text(text = "Review")
              }
            }
          }
        }
        Spacer(modifier = Modifier.padding(all = 5.dp))
        Row(
          modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.onBackground)
            .clickable(
              indication = rememberRipple(
                color = MaterialTheme.colorScheme.onSecondaryContainer
              ),
              interactionSource = remember {
                MutableInteractionSource()
              }
            ) {
            }.padding(all = 20.dp)
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
          ) {
            Box(
              modifier = Modifier.size(size = 80.dp)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
            )
          }
          Spacer(modifier = Modifier.padding(all = 5.dp))
          Column {
            Text(
              text = "Hashem Plumbing",
              color = MaterialTheme.colorScheme.onSecondary,
            )
            Spacer(modifier = Modifier.height(height = 5.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Column() {
                Text(
                  text = "September 3, 2022",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(height = 5.dp))
                Text(
                  text = "4:00 PM - 5:00 PM",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
              }

              Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                  .clip(MaterialTheme.shapes.small)
              ) {
                Text(text = "Review")
              }
            }
          }
        }
        Spacer(modifier = Modifier.padding(all = 5.dp))
        Row(
          modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.onBackground)
            .clickable(
              indication = rememberRipple(
                color = MaterialTheme.colorScheme.onSecondaryContainer
              ),
              interactionSource = remember {
                MutableInteractionSource()
              }
            ) {
            }.padding(all = 20.dp)
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
          ) {
            Box(
              modifier = Modifier.size(size = 80.dp)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
            )
          }
          Spacer(modifier = Modifier.padding(all = 5.dp))
          Column {
            Text(
              text = "VoltZ Electric",
              color = MaterialTheme.colorScheme.onSecondary,
            )
            Spacer(modifier = Modifier.height(height = 5.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Column() {
                Text(
                  text = "August 31, 2022",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(height = 5.dp))
                Text(
                  text = "9:00 AM - 10:00 AM",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
              }

              Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                  .clip(MaterialTheme.shapes.small)
              ) {
                Text(text = "Review")
              }
            }
          }
        }
        Spacer(modifier = Modifier.padding(all = 5.dp))
        Row(
          modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.onBackground)
            .clickable(
              indication = rememberRipple(
                color = MaterialTheme.colorScheme.onSecondaryContainer
              ),
              interactionSource = remember {
                MutableInteractionSource()
              }
            ) {
            }.padding(all = 20.dp)
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
          ) {
            Box(
              modifier = Modifier.size(size = 80.dp)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
            )
          }
          Spacer(modifier = Modifier.padding(all = 5.dp))
          Column {
            Text(
              text = "Khaled Carpentry",
              color = MaterialTheme.colorScheme.onSecondary,
            )
            Spacer(modifier = Modifier.height(height = 5.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Column() {
                Text(
                  text = "June 20, 2022",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(height = 5.dp))
                Text(
                  text = "2:00 PM - 3:00 PM",
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  style = MaterialTheme.typography.bodyMedium
                )
              }

              Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                  .clip(MaterialTheme.shapes.small)
              ) {
                Text(text = "Review")
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
    PastReservations(paddingValues = PaddingValues())
  }
}
