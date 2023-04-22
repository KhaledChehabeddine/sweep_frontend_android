package com.example.sweep.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.example.sweep.data.components.ServiceCategoryResponse
import com.example.sweep.functions.svgS3UrlToPainter

@Composable
fun ServiceCategoryGrid(serviceCategoryResponses: List<ServiceCategoryResponse>) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(count = 4),
    horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
    modifier = Modifier.height(height = 210.dp),
    userScrollEnabled = false,
    verticalArrangement = Arrangement.spacedBy(space = 10.dp)
  ) {
    items(serviceCategoryResponses) { serviceCategoryResponse ->
      Box(
        modifier = Modifier
          .height(height = 100.dp)
          .clip(shape = MaterialTheme.shapes.small)
          .background(
            color = if (serviceCategoryResponse.active) {
              MaterialTheme.colorScheme.secondaryContainer
            } else {
              MaterialTheme.colorScheme.tertiaryContainer
            }
          )
          .clickable(
            indication = if (serviceCategoryResponse.active) {
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
              Image(
                colorFilter = ColorFilter.tint(
                  color = if (serviceCategoryResponse.active) {
                    MaterialTheme.colorScheme.onSecondary
                  } else {
                    MaterialTheme.colorScheme.tertiary
                  }
                ),
                contentDescription = serviceCategoryResponse.name,
                modifier = Modifier.size(size = 30.dp),
                painter = svgS3UrlToPainter(url = serviceCategoryResponse.imageUrl)
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
              text = serviceCategoryResponse.name,
              style = MaterialTheme.typography.labelMedium
            )
          }
        }
      }
    }
  }
}
