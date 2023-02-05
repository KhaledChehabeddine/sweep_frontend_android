package com.example.sweep.utilities.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavbarItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(
        modifier = modifier,
        tonalElevation = 5.dp
    ) {
        items.forEach {item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        contentDescription = item.name,
                        imageVector = item.icon,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
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