package com.example.sweep.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.data.serviceCategories
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun ServiceCategoryGrid() {
  LazyVerticalGrid(
    columns = GridCells.Fixed(count = 4),
    horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
    modifier = Modifier.height(height = 210.dp),
    userScrollEnabled = false,
    verticalArrangement = Arrangement.spacedBy(space = 10.dp)
  ) {
    items(serviceCategories) { serviceCategory ->
      Box(
        modifier = Modifier
          .height(height = 100.dp)
          .background(
            color = if (serviceCategory.active) {
              MaterialTheme.colorScheme.secondaryContainer
            } else {
              MaterialTheme.colorScheme.tertiaryContainer
            },
            shape = MaterialTheme.shapes.small
          )
          .clickable(
            indication = if (serviceCategory.active) {
              rememberRipple(color = MaterialTheme.colorScheme.onSecondaryContainer)
            } else {
              null
            },
            interactionSource = remember {
              MutableInteractionSource()
            }
          ) {
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
              modifier = Modifier
                .size(size = 50.dp)
                .background(
                  color = MaterialTheme.colorScheme.onBackground,
                  shape = MaterialTheme.shapes.extraLarge
                )
            ) {
              Icon(
                contentDescription = serviceCategory.name,
                imageVector = serviceCategory.icon,
                modifier = Modifier.size(size = 30.dp),
                tint = if (serviceCategory.active) {
                  MaterialTheme.colorScheme.onSecondary
                } else {
                  MaterialTheme.colorScheme.tertiary
                }
              )
            }
          }
          Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 10.dp)
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
