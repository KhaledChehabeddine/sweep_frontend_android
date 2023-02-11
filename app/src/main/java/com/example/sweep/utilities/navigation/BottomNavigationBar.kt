package com.example.sweep.utilities.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sweep.data.BottomNavbarItem
import com.example.sweep.data.bottomNavbarItems
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun BottomNavigationBar(
    items: List<BottomNavbarItem>,
    navController: NavController,
    onItemClick: (BottomNavbarItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        items.forEach {item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = MaterialTheme.colorScheme.onSurface
                ),
                icon = {
                    item.icon?.let {
                        Icon(
                            contentDescription = item.name,
                            imageVector = it,
                        )
                    } ?: run {
                        Icon(
                            painter = painterResource(id = item.id!!),
                            contentDescription = item.name
                        )
                    }
                },
                label = {
                    Text(text = item.name)
                },
                selected = item.route == backStackEntry.value?.destination?.route,
                onClick = { onItemClick(item) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        val navController = rememberNavController()
        BottomNavigationBar(
            items = bottomNavbarItems,
            navController = navController,
        ) {
            navController.navigate(it.route)
        }
    }
}