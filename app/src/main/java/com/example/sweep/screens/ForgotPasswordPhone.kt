package com.example.sweep.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun ForgotPasswordPhone() {
    IconButton(
        modifier = Modifier.padding(top = 20.dp),
        onClick = {}
    ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "",
            modifier = Modifier
                .size(50.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Forgot Password?",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displaySmall
            )

            Text(
                "You can receive the verification code via your phone number to reset your password.",
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .width(300.dp)
            )
            InputFieldsPhone()

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
        }
    }
}

@Composable
fun InputFieldsPhone() {
    val inputValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = inputValue.value,
        onValueChange = {
            inputValue.value = it
        },
        label = {
            Text("Phone Number")
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                Icons.Default.Phone,
                contentDescription = "",
                modifier = Modifier
                    .size(25.dp)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        ForgotPasswordPhone()
    }
}
