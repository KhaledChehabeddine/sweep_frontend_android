package com.example.sweep.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sweep.data.components.ServiceItem
import com.example.sweep.functions.svgS3UrlToPainter
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlin.math.roundToInt

@Destination
@Composable
fun ServiceItem(
  navigator: DestinationsNavigator,
  serviceItem: ServiceItem
) {
  Scaffold(
    bottomBar = { },
    topBar = { }
  ) { paddingValues ->
    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      LazyColumn {
        item {
          Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)) {
            Box {
              Image(
                contentDescription = serviceItem.name,
                modifier = Modifier
                  .fillMaxWidth()
                  .aspectRatio(ratio = 16f / 9f)
                  .background(color = MaterialTheme.colorScheme.secondaryContainer),
                painter = svgS3UrlToPainter(url = serviceItem.imageUrl)
              )
              Box(modifier = Modifier.padding(all = 10.dp)) {
                IconButton(
                  colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    contentColor = MaterialTheme.colorScheme.onSurface
                  ),
                  onClick = {
                    navigator.popBackStack()
                  }
                ) {
                  Icon(
                    contentDescription = "Back",
                    imageVector = Icons.Outlined.Close
                  )
                }
              }
            }
            Column(modifier = Modifier.padding(all = 20.dp)) {
              Text(
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge,
                text = serviceItem.name
              )
              Spacer(modifier = Modifier.height(height = 10.dp))
              Text(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.headlineMedium,
                text = serviceItem.description
              )
              Spacer(modifier = Modifier.height(height = 10.dp))
              Text(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.headlineMedium,
                text = "%.2f $ / hour".format(serviceItem.price)
              )
            }
          }
          Spacer(modifier = Modifier.height(height = 20.dp))
          Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
            ) {
              val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
              var sliderPosition by remember { mutableStateOf(value = 0f) }

              Text(
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge,
                text = "Select a date and number of hours"
              )
              Spacer(modifier = Modifier.height(height = 10.dp))
              DatePicker(
                colors = DatePickerDefaults.colors(
                  containerColor = MaterialTheme.colorScheme.background,
                  currentYearContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                  headlineContentColor = MaterialTheme.colorScheme.onSurface,
                  selectedDayContainerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                  selectedDayContentColor = MaterialTheme.colorScheme.secondaryContainer,
                  selectedYearContainerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                  selectedYearContentColor = MaterialTheme.colorScheme.secondaryContainer,
                  titleContentColor = MaterialTheme.colorScheme.onSurface,
                  todayContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                  todayDateBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
                ),
                state = datePickerState
              )
              Spacer(modifier = Modifier.height(height = 10.dp))
              Column {
                Text(
                  color = MaterialTheme.colorScheme.onSurface,
                  style = MaterialTheme.typography.bodyLarge,
                  text = "%.0f Hours".format(sliderPosition)
                )
                Slider(
                  colors = SliderDefaults.colors(
                    activeTrackColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    inactiveTrackColor = MaterialTheme.colorScheme.background,
                    thumbColor = MaterialTheme.colorScheme.onSecondaryContainer
                  ),
                  onValueChange = { value ->
                    sliderPosition = value.roundToInt().toFloat()
                  },
                  onValueChangeFinished = { },
                  steps = 9,
                  value = sliderPosition,
                  valueRange = 0f..10f
                )
              }
            }
          }
          Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)) {
            Column(
              horizontalAlignment = Alignment.CenterHorizontally,
              modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
            ) {
              Button(
                colors = ButtonDefaults.buttonColors(
                  containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                  contentColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                onClick = {
                  /* TODO */
                }
              ) {
                Text(
                  color = MaterialTheme.colorScheme.background,
                  style = MaterialTheme.typography.bodyLarge,
                  text = "Book now"
                )
              }
            }
          }
        }
      }
    }
  }
}
