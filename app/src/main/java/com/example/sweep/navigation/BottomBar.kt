package com.example.sweep.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sweep.data.BottomNavbarItem

@Composable
fun BottomBar(
    items: List<BottomNavbarItem>,
    navController: NavController,
    onItemClick: (BottomNavbarItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(containerColor = MaterialTheme.colorScheme.background) {
        items.forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = MaterialTheme.colorScheme.onSurface
                ),
                icon = {
                    item.icon?.let {
                        Icon(
                            contentDescription = item.name,
                            imageVector = it
                        )
                    } ?: Icon(
                        painter = painterResource(id = item.id!!),
                        contentDescription = item.name
                    )
                },
                label = {
                    Text(text = item.name)
                },
                onClick = {
                    onItemClick(item)
                },
                selected = item.route == backStackEntry.value?.destination?.route
            )
        }
    }
}
