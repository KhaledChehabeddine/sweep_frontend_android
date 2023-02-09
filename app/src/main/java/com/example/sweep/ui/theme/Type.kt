package com.example.sweep.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sweep.R

val Rubik = FontFamily(
    Font(R.font.rubik_regular),
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)

//    Font(R.font.rubik_black),
//    Font(R.font.rubik_black_italic),
//    Font(R.font.rubik_bold_italic),
//    Font(R.font.rubik_extrabold),
//    Font(R.font.rubik_extrabold_italic),
//    Font(R.font.rubik_italic),
//    Font(R.font.rubik_light),
//    Font(R.font.rubik_light_italic),
//    Font(R.font.rubik_medium),
//    Font(R.font.rubik_medium_italic),

//    Font(R.font.rubik_semibold),
//    Font(R.font.rubik_semibold_italic),
//    Font(R.font.rubk_bold),