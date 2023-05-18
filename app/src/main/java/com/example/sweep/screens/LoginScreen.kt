package com.example.sweep.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.destinations.HomeDestination
import com.example.sweep.destinations.SignUpPageDestination
import com.example.sweep.ui.theme.SweepTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun LoginPage(navigator: DestinationsNavigator) {
  Scaffold() { paddingValues ->
    Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      val img = com.example.sweep.R.drawable.ic_sweep_logo
      Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Icon(
          painter = painterResource(id = img),
          contentDescription = "logo",
          modifier = Modifier.size(100.dp),
          tint = MaterialTheme.colorScheme.onSecondary,
        )

        Text(
          "Hello and Welcome!",
          color = MaterialTheme.colorScheme.onSecondary,
          style = MaterialTheme.typography.titleLarge,
          modifier = Modifier
            .padding(10.dp)
        )

        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
        ) {
          val username = remember {
            mutableStateOf("")
          }

          val password = remember {
            mutableStateOf("")
          }

          val passwordVisible by rememberSaveable { mutableStateOf(false) }

          Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)

          ) {
            OutlinedTextField(
              value = username.value,
              onValueChange = {
                username.value = it
              },
              label = {
                Text("Username")
              },
              singleLine = true
            )

            OutlinedTextField(
              value = password.value,
              onValueChange = {
                password.value = it
              },
              label = {
                Text("Password")
              },
              singleLine = true,
              visualTransformation = if (passwordVisible) {
                VisualTransformation.None
              } else {
                PasswordVisualTransformation()
              }
            )

            Button(
              onClick = {
                navigator.navigate(HomeDestination)
              },
              shape = MaterialTheme.shapes.small,
              colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSecondary),
              modifier = Modifier
                .padding(10.dp)
            ) {
              Text(text = "Submit")
            }

            Text(
              "Don't Have an Account? Create one here!",
              color = MaterialTheme.colorScheme.onSecondary,
              style = MaterialTheme.typography.titleSmall,
              modifier = Modifier.clickable(
                onClick = {
                  navigator.navigate(SignUpPageDestination())
                }
              )
            )
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
//    LoginPage()
  }
}
