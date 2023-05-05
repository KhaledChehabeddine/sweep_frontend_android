package com.example.sweep.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorPalette = darkColorScheme(
  primary = md_theme_dark_primary,
  onPrimary = md_theme_dark_onPrimary,
  primaryContainer = md_theme_dark_primaryContainer,
  onPrimaryContainer = md_theme_dark_onPrimaryContainer,
  inversePrimary = md_theme_dark_inversePrimary,

  secondary = md_theme_dark_secondary,
  onSecondary = md_theme_dark_onSecondary,
  secondaryContainer = md_theme_dark_secondaryContainer,
  onSecondaryContainer = md_theme_dark_onSecondaryContainer,

  tertiary = md_theme_dark_tertiary,
  onTertiary = md_theme_dark_onTertiary,
  tertiaryContainer = md_theme_dark_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_onTertiaryContainer,

  background = md_theme_dark_background,
  onBackground = md_theme_dark_onBackground,

  surface = md_theme_dark_surface,
  onSurface = md_theme_dark_onSurface,
  surfaceVariant = md_theme_dark_surfaceVariant,
  onSurfaceVariant = md_theme_dark_onSurfaceVariant,
  surfaceTint = md_theme_dark_surfaceTint,
  inverseSurface = md_theme_dark_inverseSurface,
  inverseOnSurface = md_theme_dark_inverseOnSurface,

  error = md_theme_dark_error,
  errorContainer = md_theme_dark_errorContainer,
  onError = md_theme_dark_onError,
  onErrorContainer = md_theme_dark_onErrorContainer,

  outline = md_theme_dark_outline
)

private val lightColorPalette = lightColorScheme(
  primary = amber400,
  onPrimary = amber100,
  primaryContainer = blue200,
  onPrimaryContainer = md_theme_light_onPrimaryContainer,
  inversePrimary = md_theme_light_inversePrimary,

  secondary = blue300,
  onSecondary = blue700,
  secondaryContainer = blue100,
  onSecondaryContainer = blue500,

  tertiary = cool_gray400,
  onTertiary = emerald300,
  tertiaryContainer = cool_gray200,
  onTertiaryContainer = cool_gray300,

  background = blue50,
  onBackground = white900,

  surface = emerald100,
  onSurface = blue_gray900,
  surfaceVariant = emerald400,
  onSurfaceVariant = blue_gray400,
  surfaceTint = md_theme_light_surfaceTint,
  inverseSurface = black20,
  inverseOnSurface = black100,

  error = rose400,
  onError = rose100,
  errorContainer = md_theme_light_errorContainer,
  onErrorContainer = md_theme_light_onErrorContainer,

  outline = md_theme_light_outline
)

@Composable
fun SweepTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> darkColorPalette
    else -> lightColorPalette
  }

  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val currentWindow = (view.context as Activity).window
      currentWindow.statusBarColor = colorScheme.background.toArgb()
      WindowCompat.getInsetsController(currentWindow, view).isAppearanceLightStatusBars = !darkTheme
    }
  }

  MaterialTheme(
    content = content,
    colorScheme = colorScheme,
    typography = Typography
  )
}
