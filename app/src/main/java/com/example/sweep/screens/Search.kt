package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.components.BottomBar
// import com.example.sweep.components.SweepSearchBar
import com.example.sweep.ui.theme.SweepTheme
// import com.google.accompanist.systemuicontroller.SystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/*
 * SweepSearchBar() added to the content of Scaffold, because when expanded it becomes bigger than the topBar and
 * causes visual bugs
 */
@Destination
@Composable
fun SearchScreen(
  navigator: DestinationsNavigator
//  systemUiController: SystemUiController
) {
  Scaffold(
    bottomBar = {
      BottomBar(
        currentPage = "account",
        navigator = navigator,
      )
    }
  ) { paddingValues ->
    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
    ) {
//      SweepSearchBar(systemUiController = systemUiController)

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
              Box(
                contentAlignment = androidx.compose.ui.Alignment.Center,
                modifier = Modifier
                  .size(
                    height = 40.dp,
                    width = 100.dp
                  )
                  .clip(MaterialTheme.shapes.small)
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
              ) {
                Text(
                  text = "Bugstas",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurface,
                )
              }

              Spacer(modifier = Modifier.width(width = 10.dp))

              Box(
                contentAlignment = androidx.compose.ui.Alignment.Center,
                modifier = Modifier
                  .size(
                    height = 40.dp,
                    width = 220.dp
                  )
                  .clip(MaterialTheme.shapes.small)
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
              ) {
                Text(
                  text = "Jamil's Cleaning Services",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurface,
                )
              }

              Spacer(modifier = Modifier.width(width = 10.dp))

              Box(
                contentAlignment = androidx.compose.ui.Alignment.Center,
                modifier = Modifier
                  .size(
                    height = 40.dp,
                    width = 150.dp
                  )
                  .clip(MaterialTheme.shapes.small)
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
              ) {
                Text(
                  text = "VoltZ Electric",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurface,
                )
              }
            }
          }
          Spacer(modifier = Modifier.height(height = 20.dp))
          Text(
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge,
            text = "Recommended"
          )
          Spacer(modifier = Modifier.height(height = 15.dp))
          Column {
            Row(
              horizontalArrangement = Arrangement.spacedBy(space = 10.dp)
            ) {
              Column(
                modifier = Modifier
                  .fillMaxWidth()
                  .weight(1f)

              ) {
                Box(
                  modifier = Modifier
                    .height(150.dp)
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
                Text(
                  text = "VoltZ Electric",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(modifier = Modifier.height(height = 15.dp))

                Box(
                  modifier = Modifier
                    .height(150.dp)
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
                Text(
                  text = "Jamil's Cleaning Services",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(modifier = Modifier.height(height = 15.dp))

                Box(
                  modifier = Modifier
                    .height(150.dp)
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
                Text(
                  text = "Khaled's Auto Repair",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(modifier = Modifier.height(height = 15.dp))

                Box(
                  modifier = Modifier
                    .height(150.dp)
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
                Text(
                  text = "Anti-Pest",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(modifier = Modifier.height(height = 15.dp))
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
//    SearchScreen(systemUiController = rememberSystemUiController())
  }
}
