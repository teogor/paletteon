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

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import dev.teogor.paletteon.internal.animateColors

/**
 * A custom theme based on Paletteon, which adapts to the provided seed color
 * and other configuration parameters.
 *
 * This theme allows for extensive customization, including the ability to
 * animate color transitions, adjust contrast levels, and use an extended fidelity
 * color set, all while following the Material Design guidelines.
 *
 * @param seedColor The base color used to generate the entire color scheme.
 * @param useDarkTheme Whether to apply a dark theme based on system preferences.
 * @param withAmoled Whether to enforce pure black for AMOLED displays when using dark theme.
 * @param style The desired color scheme style, defined by [PaletteStyle].
 * @param contrast The contrast to apply across the color scheme.
 * @param shapes The shape styles to be used in this theme, defaulting to Material shapes.
 * @param typography The typography styles to be used in this theme, defaulting to Material typography.
 * @param isExtendedFidelity Whether to use an extended set of color fidelity rules.
 * @param animate Whether to animate transitions between color states.
 * @param animationSpec The animation specification, defining the animation behavior.
 * @param content The content to be displayed within this theme.
 *
 * @see paletteonColorScheme
 * @see PaletteStyle
 */
@Composable
public fun PaletteonDynamicTheme(
  seedColor: Color,
  useDarkTheme: Boolean = isSystemInDarkTheme(),
  withAmoled: Boolean = false,
  style: PaletteStyle = PaletteStyle.TonalSpot,
  contrast: Contrast = Contrast.Default,
  isExtendedFidelity: Boolean = false,
  shapes: Shapes = MaterialTheme.shapes,
  typography: Typography = MaterialTheme.typography,
  animate: Boolean = false,
  animationSpec: AnimationSpec<Color> = spring(stiffness = Spring.StiffnessLow),
  content: @Composable () -> Unit,
) {
  CompositionLocalProvider(
    LocalPaletteonTheme provides mutableStateOf(
      PaletteonTheme(
        seedColor = seedColor,
        useDarkTheme = useDarkTheme,
        withAmoled = withAmoled,
        style = style,
        contrast = contrast,
        isExtendedFidelity = isExtendedFidelity,
      )
    )
  ) {
    val paletteonTheme = PaletteonTheme.current

    val colorScheme = paletteonTheme.colorScheme
    val scheme = if (!animate) {
      colorScheme
    } else {
      colorScheme.animateColors(animationSpec)
    }

    MaterialTheme(
      colorScheme = scheme,
      shapes = shapes,
      typography = typography,
      content = content,
    )
  }
}
