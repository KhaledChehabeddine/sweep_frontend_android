package com.example.sweep.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun SignUpPage() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
        ,

    ) {
        val img = com.example.sweep.R.drawable.ic_launcher_sweep_logo
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Icon(
                painter = painterResource(id = img),
                contentDescription = "logo",
                modifier = Modifier.size(100.dp),
                tint = MaterialTheme.colorScheme.primary
            )

            Text("Welcome to Sweep!",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displaySmall,
                )

            Surface(
                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                shadowElevation = 10.dp,
            ){
                SignUp()
            }
        }
    }
}

@Composable
fun SignUp(){

    val username =  remember {
        mutableStateOf("")
    }

    val password =  remember {
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
            singleLine = true,
        )

        OutlinedTextField(
            value = username.value,
            onValueChange = {
                username.value = it
            },
            label = {
                Text("Email")
            },
            singleLine = true,
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
            } else PasswordVisualTransformation(),
        )

        Button(
            onClick = {},
            modifier = Modifier.padding(10.dp),
        ) {
            Text(text = "Submit")
        }

        Text("Already have an Account?",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall,
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        SignUpPage()
    }
}