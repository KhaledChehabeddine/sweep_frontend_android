package com.example.sweep.utilities.topbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweep.data.notificationIcon
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun TopBarHome() {
    CenterAlignedTopAppBar(
        actions = {
            if (notificationIcon.badgeCount > 0)
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
                    onClick = {
                        /* TODO */
                    }
                ) {
                    BadgedBox(badge = {
                        Badge()
                    }) {
                        Icon(
                            contentDescription = "Notifications",
                            imageVector = Icons.Outlined.Notifications
                        )
                    }
                }
            else
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
                    onClick = {
                        /* TODO */
                    }
                ) {
                    Icon(
                        contentDescription = "Notifications",
                        imageVector = Icons.Outlined.Notifications
                    )
                }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = {
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
                onClick = {
                    /* TODO */
                }
            ) {
                Icon(
                    contentDescription = "Menu",
                    imageVector = Icons.Outlined.Menu,
                )
            }
        },
        title = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        TopBarHome()
    }
}