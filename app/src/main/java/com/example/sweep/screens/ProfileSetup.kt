package com.example.sweep.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun ProfileSetupScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ){

        Spacer(modifier = Modifier.height(50.dp));

        Icon(
            Icons.Default.AccountCircle,
            contentDescription = "",
            modifier = Modifier
                .size(200.dp)
        )

        Name()
        LastName()
        DOB()
        DropdownMenu()

    }

}

@Composable
fun Name(){
    val name_ = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = name_.value,
        onValueChange = {
            name_.value = it
        },
        label = {
            Text("Last Name")
        },
        singleLine = true,

    )
}

@Composable
fun LastName(){
    val Lastname = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = Lastname.value,
        onValueChange = {
            Lastname.value = it
        },
        label = {
            Text("First Name")
        },
        singleLine = true,

        )
}

@Composable
fun DOB(){
    val DOB = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = DOB.value,
        onValueChange = {
            DOB.value = it
        },
        label = {
            Text("Date of Birth")
        },
        singleLine = true,

        )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropdownMenu() {
    val options = listOf("Male", "Female", "Non-Binary", "IDK", " AC-130H Gunship")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
//            label = { Text("Label") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
//            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(

                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                    text = {selectedOptionText}
                )
//                {
//                    Text(text = selectionOption)
//                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        ProfileSetupScreen()
    }
}