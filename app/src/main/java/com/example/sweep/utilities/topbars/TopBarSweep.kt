package com.example.sweep.utilities.topbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.outlined.Menu
//import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun TopBarSweep() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(100.dp)
                .background(Color.Blue),
        ) {
            Text(text = "Sweepers",
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
        }
}
@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        TopBarSweep()
    }
}