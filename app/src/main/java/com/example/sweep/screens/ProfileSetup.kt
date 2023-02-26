package com.example.sweep.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun ProfileSetupScreen(paddingValues: PaddingValues) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ){

        Spacer(modifier = Modifier.height(50.dp));

        Icon(
            Icons.Default.AccountCircle,
            contentDescription = "",
            modifier = Modifier
//                .border(border: BorderStroke, shape: Shape),
                .size(200.dp)
        )

        Name()
        LastName()
        DOB()

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

@Composable
fun dropDownGenderMenu(){
    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    val mGender = listOf("Male", "Female", "Non-Binary", "Attack Helicopter")

    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {

        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text("Label")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            mGender.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label
                    mExpanded = false
                }) {
                    Text(text = label)
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
        ProfileSetupScreen(PaddingValues())
    }
}