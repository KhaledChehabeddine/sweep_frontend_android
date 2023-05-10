package com.example.sweep.screens.account.subpages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.components.BottomBar
import com.example.sweep.components.topbars.accountSubpages.TopBarAddresses
import com.example.sweep.ui.theme.SweepTheme
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Addresses(navigator: DestinationsNavigator) {
  val times = 5
  Scaffold(
    topBar = {
      TopBarAddresses(navigator = navigator)
    },
    bottomBar = {
      BottomBar(
        currentPage = "account",
        navigator = navigator,
      )
    },
  ) { paddingValues ->
    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues),
    ) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        repeat(times = times) { index ->
          AddressEntry()
          if (index != times - 1) Divider()
        }
      }
    }
  }
}

@Composable
fun AddressEntry() {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(10.dp),

    ) {
      Icon(
        imageVector = Icons.Default.LocationOn,
        contentDescription = "Address",
        tint = MaterialTheme.colorScheme.outline,
        modifier = Modifier
          .size(40.dp)
      )
      Box(
        modifier = Modifier
          .height(height = 30.dp)
          .fillMaxWidth(fraction = 0.5f)
          .padding(start = 10.dp, end = 10.dp)
          .placeholder(
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            highlight = PlaceholderHighlight.shimmer(),
            visible = true
          )
      )
    }
    Row() {
      IconButton(
        onClick = { /*TODO*/ }
      ) {
        Icon(
          imageVector = Icons.Default.Edit,
          contentDescription = "Address",
          tint = MaterialTheme.colorScheme.onSecondary,
          modifier = Modifier
            .size(50.dp)
        )
      }

      IconButton(
        onClick = { /*TODO*/ }
      ) {
        Icon(
          imageVector = Icons.Default.Delete,
          contentDescription = "Address",
          tint = MaterialTheme.colorScheme.error,
          modifier = Modifier
            .size(50.dp)
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
//    Addresses(5)
  }
}
