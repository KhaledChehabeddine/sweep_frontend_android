package com.example.sweep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sweep.ui.theme.SweepTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SweepTheme {
        Surface(
          color = MaterialTheme.colorScheme.primary,
          modifier = Modifier.fillMaxSize()
        ) {
          MainScreen()
        }
      }
    }
  }
}

// Scaffolds are used to easily create basic Material Design layouts, with a bottomBar, topBar and content section
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
  val pagerState = rememberPagerState()

  DestinationsNavHost(navGraph = NavGraphs.root)
}
