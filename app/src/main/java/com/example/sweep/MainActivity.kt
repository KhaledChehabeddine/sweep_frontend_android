package com.example.sweep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sweep.ui.theme.SweepTheme
import com.example.sweep.data.bottomNavbarItems
import com.example.sweep.navigation.BottomBar
import com.example.sweep.navigation.Content
import com.example.sweep.navigation.TopBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SweepTheme {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val pagerState = rememberPagerState()

    Scaffold(
        bottomBar = {
            BottomBar(
                items = bottomNavbarItems,
                navController = navController
            ) { bottomNavbarItem ->
                navController.navigate(route = bottomNavbarItem.route)
            }
        },
        content = { paddingValues ->
            Content(
                navController = navController,
                paddingValues = paddingValues,
                pagerState = pagerState
            )
        },
        topBar = {
            TopBar(
                navController = navController,
                pagerState = pagerState
            )
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