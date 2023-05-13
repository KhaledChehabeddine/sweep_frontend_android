package com.example.sweep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sweep.ui.theme.SweepTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SweepTheme {
        Surface(
          color = Color.Transparent,
          modifier = Modifier.fillMaxSize()
        ) {
          MainScreen()
        }
      }
    }
  }
}

// Scaffolds are used to easily create basic Material Design layouts, with a bottomBar, topBar and content section
@Composable
fun MainScreen() {
  DestinationsNavHost(navGraph = NavGraphs.root)
}
