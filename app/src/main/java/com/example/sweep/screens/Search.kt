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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme
import com.example.sweep.utilities.SweepSearchBar
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/*
 * SweepSearchBar() added to the content of Scaffold, because when expanded it becomes bigger than the topBar and
 * causes visual bugs
 */
@Composable
fun SearchScreen(systemUiController: SystemUiController) {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier.fillMaxSize()
  ) {
    SweepSearchBar(systemUiController = systemUiController)

    LazyColumn(
      modifier = Modifier.padding(
        end = 20.dp,
        start = 20.dp,
        top = 90.dp
      )
    ) {
      item {
        Text(
          color = MaterialTheme.colorScheme.onSurface,
          style = MaterialTheme.typography.titleLarge,
          text = "Recent Searches"
        )
        Spacer(modifier = Modifier.height(height = 10.dp))
        LazyRow {
          item {
            for (i in 0..5) {
              if (i != 0) Spacer(modifier = Modifier.padding(start = 10.dp))
              Box(
                modifier = Modifier.size(
                  height = 40.dp,
                  width = 100.dp
                )
                  .clip(RoundedCornerShape(size = 10.dp))
                  .background(
                    color = MaterialTheme.colorScheme.secondaryContainer
                  )
                  .clickable(
                    indication = rememberRipple(
                      color = MaterialTheme.colorScheme.onSecondaryContainer
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
        Spacer(modifier = Modifier.height(height = 20.dp))
        Text(
          color = MaterialTheme.colorScheme.onSurface,
          style = MaterialTheme.typography.titleLarge,
          text = "Categories"
        )
        Spacer(modifier = Modifier.height(height = 15.dp))
        Column {
          for (i in 0..9)
            Row(
              horizontalArrangement = Arrangement.spacedBy(space = 10.dp)
            ) {
              for (j in 0..1)
                Column(
                  modifier = Modifier.fillMaxWidth()
                    .weight(1f)

                ) {
                  Box(
                    modifier = Modifier.height(100.dp)
                      .fillMaxWidth()
                      .clip(RoundedCornerShape(10.dp))
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
                  Spacer(modifier = Modifier.height(height = 10.dp))
                  Box(
                    modifier = Modifier.height(height = 16.dp)
                      .fillMaxWidth()
                      .clip(CircleShape)
                      .background(
                        color = MaterialTheme.colorScheme.tertiary
                      )
                  )
                  Spacer(modifier = Modifier.height(height = 5.dp))
                  Box(
                    modifier = Modifier.height(height = 10.dp)
                      .fillMaxWidth(fraction = 0.5f)
                      .clip(CircleShape)
                      .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer
                      )
                  )
                  Spacer(modifier = Modifier.height(height = 15.dp))
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
    SearchScreen(systemUiController = rememberSystemUiController())
  }
}
