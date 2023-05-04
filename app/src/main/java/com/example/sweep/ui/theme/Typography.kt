package com.example.sweep.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sweep.R

private val rubikFontFamily = FontFamily(
  Font(
    resId = R.font.rubik_light,
    weight = FontWeight.Light
  ),
  Font(
    resId = R.font.rubik_light_italic,
    style = FontStyle.Italic,
    weight = FontWeight.Light
  ),

  Font(resId = R.font.rubik_regular),

  Font(
    resId = R.font.rubik_italic,
    style = FontStyle.Italic
  ),

  Font(
    resId = R.font.rubik_medium,
    weight = FontWeight.Medium
  ),
  Font(
    resId = R.font.rubik_medium_italic,
    style = FontStyle.Italic,
    weight = FontWeight.Medium
  ),

  Font(
    resId = R.font.rubik_semi_bold,
    weight = FontWeight.SemiBold
  ),
  Font(
    resId = R.font.rubik_semi_bold_italic,
    style = FontStyle.Italic,
    weight = FontWeight.SemiBold
  ),

  Font(
    resId = R.font.rubik_bold,
    weight = FontWeight.Bold
  ),
  Font(
    resId = R.font.rubik_bold_italic,
    style = FontStyle.Italic,
    weight = FontWeight.Bold
  ),

  Font(
    resId = R.font.rubik_extra_bold,
    weight = FontWeight.ExtraBold
  ),
  Font(
    resId = R.font.rubik_extra_bold_italic,
    style = FontStyle.Italic,
    weight = FontWeight.ExtraBold
  ),

  Font(
    resId = R.font.rubik_black,
    weight = FontWeight.Black
  ),
  Font(
    resId = R.font.rubik_black_italic,
    style = FontStyle.Italic,
    weight = FontWeight.Black
  )
)

// Set of Material typography styles to start with
val Typography = Typography(
  bodyMedium = TextStyle(
    fontFamily = rubikFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp
  ),

  displayMedium = TextStyle(
    fontFamily = rubikFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp
  ),

  headlineLarge = TextStyle(
    fontFamily = rubikFontFamily,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 32.sp,
    letterSpacing = 0.5.sp
  ),

  headlineMedium = TextStyle(
    fontFamily = rubikFontFamily,
    fontSize = 14.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 20.sp
  ),

  labelMedium = TextStyle(
    fontFamily = rubikFontFamily,
    fontSize = 12.sp,
    lineHeight = 16.sp
  ),

  titleMedium = TextStyle(
    fontFamily = rubikFontFamily,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
  ),

  titleLarge = TextStyle(
    fontFamily = rubikFontFamily,
    fontSize = 20.sp,
    fontWeight = FontWeight.Medium
  )
)
