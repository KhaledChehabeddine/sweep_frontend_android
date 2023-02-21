package com.example.sweep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sweep.screens.*
import com.example.sweep.ui.theme.SweepTheme
import com.example.sweep.data.bottomNavbarItems
import com.example.sweep.navigation.BottomBar
import com.example.sweep.navigation.Content
import com.example.sweep.navigation.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SweepTheme {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(
                items = bottomNavbarItems,
                navController = navController
            ) {
                navController.navigate(route = it.route)
            }
        },
        content = { paddingValues ->
            Content(
                navController = navController,
                paddingValues = paddingValues
            )
        },
        topBar = {
            TopBar(navController = navController)
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        MainScreen()
    }
}