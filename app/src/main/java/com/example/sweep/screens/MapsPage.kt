package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun MapsPage() {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier
      .fillMaxSize()
  ) {
    Column(
      verticalArrangement = Arrangement.spacedBy(10.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth(),
    ) {
      Column(
        modifier = Modifier
          .padding(start = 10.dp, end = 10.dp, top = 10.dp)
          .clip(MaterialTheme.shapes.small)
          .background(color = MaterialTheme.colorScheme.onBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Text(
          text = "Select your location on the map below",
          style = MaterialTheme.typography.titleMedium,
          color = MaterialTheme.colorScheme.onSecondary,
          modifier = Modifier
            .padding(10.dp)
        )
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
          value = text,
          onValueChange = { text = it },
          label = { Text("Name") },
          modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
        )
      }

      Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
          .fillMaxSize()
          .background(color = MaterialTheme.colorScheme.error),
      ) {
//        Text(
//          text = "* insert map here *",
//          style = MaterialTheme.typography.displaySmall,
//          color = MaterialTheme.colorScheme.onSecondary,
//          modifier = Modifier
//            .padding(10.dp)
//            .rotate(-45f)
//        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    MapsPage()
  }
}
