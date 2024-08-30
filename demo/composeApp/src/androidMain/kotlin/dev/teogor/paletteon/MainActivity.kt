/*
 * Copyright 2024 Teogor (Teodor Grigor)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.teogor.paletteon

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.android.material.color.DynamicColors

public class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    enableEdgeToEdge(
      statusBarStyle = SystemBarStyle.auto(
        android.graphics.Color.TRANSPARENT,
        android.graphics.Color.TRANSPARENT
      ),
      navigationBarStyle = SystemBarStyle.auto(
        android.graphics.Color.TRANSPARENT,
        android.graphics.Color.TRANSPARENT
      ),
    )
    WindowCompat.setDecorFitsSystemWindows(window, false)

    DynamicColors.isDynamicColorAvailable()
    DynamicColors.applyToActivitiesIfAvailable(application)

    setContent {
      SetWindowAppearance()
      App(
        insets = WindowInsets.systemBars,
      )
    }
  }
}

@Preview
@Composable
public fun AppAndroidPreview() {
  App(WindowInsets.systemBars)
}

@Composable
private fun SetWindowAppearance(
  darkTheme: Boolean = isSystemInDarkTheme(),
  statusBarColor: Color = Color.Transparent,
  statusBarContentDark: Boolean = !darkTheme,
  navigationBarColor: Color = Color.Transparent,
  navigationBarContentDark: Boolean = !darkTheme,
) {
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window

      window.statusBarColor = statusBarColor.toArgb()
      window.navigationBarColor = navigationBarColor.toArgb()

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isNavigationBarContrastEnforced = false
      }

      val insetsController = WindowCompat.getInsetsController(window, view)

      // Status Bar Content Appearance
      insetsController.isAppearanceLightStatusBars = statusBarContentDark
      // Navigation Bar Content Appearance
      insetsController.isAppearanceLightNavigationBars = navigationBarContentDark
    }
  }
}
