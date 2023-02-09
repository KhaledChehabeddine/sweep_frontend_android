package com.example.sweep.utilities.topbars

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        actions = {
            IconButton(
                modifier = Modifier.clip(RoundedCornerShape(50.dp))
                    .background(MaterialTheme.colorScheme.secondary),
                onClick = { }
            ) {
                Icon(
                    contentDescription = "Notifications",
                    imageVector = Icons.Outlined.Notifications,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    contentDescription = "Menu",
                    imageVector = Icons.Outlined.Menu,
                    tint = MaterialTheme.colorScheme.onSurface
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
        TopBar()
    }
}