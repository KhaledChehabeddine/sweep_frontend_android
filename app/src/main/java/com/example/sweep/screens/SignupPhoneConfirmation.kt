package com.example.sweep.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun PhoneVerification() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PhoneNumberField()

            Button(
                onClick = {}
            ) {
                Text(
                    "Send Code",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .width(100.dp)
                )
            }

            VerificationCode()
            Text(
                "Already have an Account?",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun PhoneNumberField() {
    val phoneNumber = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = phoneNumber.value,
        onValueChange = {
            phoneNumber.value = it
        },
        label = {
            Text("Phone Number")
        },

        singleLine = true

    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        PhoneVerification()
    }
}
