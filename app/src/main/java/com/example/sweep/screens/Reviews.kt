package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sweep.components.topbars.TopBarReviews
import com.example.sweep.context.screens.user.CompanyContext
import com.example.sweep.context.screens.user.WorkerContext
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun Reviews(
  companyContext: CompanyContext? = null,
  navigator: DestinationsNavigator,
  serviceProviderType: String,
  workerContext: WorkerContext? = null
) {
  Scaffold(
    bottomBar = { },
    topBar = {
      TopBarReviews(navigator = navigator)
    }
  ) { paddingValues ->
    if (serviceProviderType == "company") {
      CompanyScreen(
        companyContext = companyContext!!,
        paddingValues = paddingValues
      )
    }
//    } else {
//      WorkerScreen(
//        workerContext = workerContext!!,
//        navigator = navigator,
//        paddingValues = paddingValues
//      )
//    }
  }
}

@Composable
private fun CompanyScreen(
  companyContext: CompanyContext,
  paddingValues: PaddingValues
) {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues = paddingValues)
  ) {
    LazyColumn {
      item {
        Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)) {
          Row(modifier = Modifier.padding(all = 20.dp)) {
            Text(
              color = MaterialTheme.colorScheme.onSurface,
              fontSize = 52.sp,
              text = companyContext.company.serviceProvider.averageRating.toString()
            )
            Spacer(modifier = Modifier.width(width = 10.dp))
            Column {
              val rating = companyContext.company.serviceProvider.averageRating
              val ratingBoxColor: Color = if (rating >= 4.5f) {
                MaterialTheme.colorScheme.surfaceVariant
              } else if (rating >= 3.0f) {
                MaterialTheme.colorScheme.primary
              } else if (rating > 0.0f) {
                MaterialTheme.colorScheme.error
              } else {
                MaterialTheme.colorScheme.inverseOnSurface
              }

              Row {
                for (i in 1..companyContext.company.serviceProvider.averageRating.toInt()) {
                  Icon(
                    contentDescription = "Star",
                    imageVector = Icons.Outlined.Star,
                    tint = ratingBoxColor
                  )
                }
                for (i in 1..(5 - companyContext.company.serviceProvider.averageRating.toInt())) {
                  Icon(
                    contentDescription = "Star",
                    imageVector = Icons.Outlined.Star,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }
              Spacer(modifier = Modifier.height(height = 5.dp))
              Row {
                Text(
                  color = MaterialTheme.colorScheme.tertiary,
                  fontWeight = FontWeight.Normal,
                  style = MaterialTheme.typography.headlineMedium,
                  text = "Based on ${companyContext.company.serviceProvider.metadata.totalReviews} reviews"
                )
              }
            }
          }
        }
        Column(modifier = Modifier.padding(all = 20.dp)) {
          for (review in companyContext.serviceProviderContext.reviewContexts) {
            BoxWithConstraints {
              Box(
                modifier = Modifier
                  .height(height = maxHeight)
                  .width(width = maxWidth)
                  .clip(shape = MaterialTheme.shapes.small)
                  .background(color = MaterialTheme.colorScheme.onBackground)
              ) {
                Row {
                }
              }
            }
          }
        }
      }
    }
  }
}
