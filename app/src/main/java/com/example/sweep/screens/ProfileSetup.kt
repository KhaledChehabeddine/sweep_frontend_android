package com.example.sweep.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.destinations.HomeDestination
import com.example.sweep.ui.theme.SweepTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ProfileSetupScreen(navigator: DestinationsNavigator) {
  Scaffold() { paddingValues ->
    Column(
      verticalArrangement = Arrangement.spacedBy(15.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      Spacer(modifier = Modifier.height(50.dp))

      Icon(
        Icons.Default.AccountCircle,
        tint = MaterialTheme.colorScheme.onSecondary,
        contentDescription = "",
        modifier = Modifier
          .size(200.dp)
      )

      FirstName()
      LastName()
      DOB()
      DropDownMenu()

      Button(
        onClick = {
          navigator.navigate(HomeDestination)
        },
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSecondary),
        modifier = Modifier.padding(10.dp)
      ) {
        Text(text = "Submit")
      }
    }
  }
}

@Composable
fun FirstName() {
  val name = remember {
    mutableStateOf("")
  }
  OutlinedTextField(
    value = name.value,
    onValueChange = {
      name.value = it
    },
    label = {
      Text(
        "First Name",
      )
    },
    singleLine = true

  )
}

@Composable
fun LastName() {
  val lastname = remember {
    mutableStateOf("")
  }
  OutlinedTextField(
    value = lastname.value,
    onValueChange = {
      lastname.value = it
    },
    label = {
      Text(
        "Last Name",
      )
    },
    singleLine = true

  )
}

@Composable
fun DOB() {
  val birthdate = remember {
    mutableStateOf("")
  }
  OutlinedTextField(
    value = birthdate.value,
    onValueChange = {
      birthdate.value = it
    },
    label = {
      Text(
        "Date of Birth",
      )
    },
    singleLine = true

  )
}

@Composable
fun DropDownMenu() {
  var expanded by remember { mutableStateOf(false) }
  val suggestions = listOf("Man", "Woman", "Other", "Rather Not Specify")
  var selectedText by remember { mutableStateOf("") }

  val icon = if (expanded) {
    Icons.Filled.KeyboardArrowUp
  } else {
    Icons.Filled.KeyboardArrowDown
  }

  Column() {
    OutlinedTextField(
      value = selectedText,
      enabled = false,
      onValueChange = { selectedText = it },
      textStyle = MaterialTheme.typography.bodyLarge,
      modifier = Modifier
        .clickable { expanded = !expanded },
      label = {
        Text(
          "Gender",
        )
      },
      trailingIcon = {
        Icon(
          icon,
          "contentDescription",
//          Modifier.clickable { expanded = !expanded }
        )
      }
    )
    MaterialTheme(
      MaterialTheme.colorScheme.copy(surface = Color.White),
    ) {
      DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
          .fillMaxWidth(fraction = 0.6f)
      ) {
        suggestions.forEach { label ->
          DropdownMenuItem(
            {
              Text(
                text = label,
                color = MaterialTheme.colorScheme.onSurface
              )
            },
            modifier = Modifier
              .background(MaterialTheme.colorScheme.surface),
            onClick = {
              selectedText = label
              expanded = false
            }
          )
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
//    ProfileSetupScreen()
  }
}
