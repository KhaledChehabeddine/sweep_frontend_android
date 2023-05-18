package com.example.sweep.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.sweep.components.BottomBar
import com.example.sweep.components.topbars.home.TopBarHomeSubFeature
import com.example.sweep.data.home.HomeMainFeatureReward
import com.example.sweep.functions.svgS3UrlToPainter
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalComposeUiApi::class)
@Destination
@Composable
fun HomeMainFeatureReward(
  homeMainFeatureReward: HomeMainFeatureReward,
  navigator: DestinationsNavigator
) {
  Scaffold(
    bottomBar = {
      BottomBar(
        currentPage = "home",
        navigator = navigator
      )
    },
    topBar = {
      TopBarHomeSubFeature(
        navigator = navigator,
        title = ""
      )
    }
  ) { paddingValues ->
    val focusRequester = remember {
      FocusRequester()
    }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
      mutableStateOf(TextFieldValue(""))
    }

    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
    ) {
      Column(
        modifier = Modifier.padding(all = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
      ) {
        Image(
          contentDescription = homeMainFeatureReward.homeMainFeature.homeFeature.homeFeatureType,
          modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(ratio = 16f / 9f)
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.secondaryContainer),
          painter = svgS3UrlToPainter(url = homeMainFeatureReward.homeMainFeature.imageUrl)
        )
        Spacer(modifier = Modifier.height(height = 20.dp))
        TextField(
          colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedIndicatorColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
          ),
          label = {
            Text(text = "Enter reward code")
          },
          keyboardActions = KeyboardActions(
            onDone = {
              keyboardController?.hide()
              focusManager.clearFocus()
            }
          ),
          keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
          modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester = focusRequester),
          onValueChange = { query ->
            text = query
          },
          value = text,
        )
        Spacer(modifier = Modifier.height(height = 20.dp))
        Button(
          colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondaryContainer
          ),
          modifier = Modifier.fillMaxWidth(fraction = 0.60f),
          onClick = {
            /* TODO */
          },
        ) {
          Text(
            text = "Submit",
            style = MaterialTheme.typography.bodyMedium
          )
        }
      }
    }
  }
}
