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

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import dev.teogor.paletteon.dynamiccolor.MaterialDynamicColors
import dev.teogor.paletteon.ktx.getColor
import dev.teogor.paletteon.ktx.toDynamicScheme

/**
 * Creates and remember a [ColorScheme] based on the given [seedColor] and [isDark] mode.
 *
 * @param[seedColor] The color to base the scheme on.
 * @param[isDark] Whether the scheme should be dark or light.
 * @param[isAmoled] Whether the dark scheme is used with Amoled screen (Pure dark).
 * @param[style] The style of the scheme.
 * @param[contrast] The contrast level of the scheme.
 * @param[isExtendedFidelity] Whether to use the extended fidelity color set. See [MaterialDynamicColors].
 */
@Composable
public fun rememberPaletteonColorScheme(
  seedColor: Color,
  isDark: Boolean,
  isAmoled: Boolean = false,
  style: PaletteStyle = PaletteStyle.TonalSpot,
  contrast: Contrast = Contrast.Default,
  isExtendedFidelity: Boolean = false,
  modifyColorScheme: ((ColorScheme) -> ColorScheme)? = null,
): ColorScheme = remember(
  seedColor,
  isDark,
  isAmoled,
  style,
  contrast,
  isExtendedFidelity,
  modifyColorScheme,
) {
  paletteonColorScheme(
    seedColor = seedColor,
    isDark = isDark,
    isAmoled = isAmoled,
    style = style,
    contrast = contrast,
    isExtendedFidelity = isExtendedFidelity,
    modifyColorScheme = modifyColorScheme,
  )
}

/**
 * Creates a [ColorScheme] based on the given [seedColor] and [isDark] mode.
 *
 * @param[seedColor] The color to base the scheme on.
 * @param[isDark] Whether the scheme should be dark or light.
 * @param[isAmoled] Whether the dark scheme is used with Amoled screen (Pure dark).
 * @param[style] The style of the scheme.
 * @param[contrast] The contrast level of the scheme.
 * @param[isExtendedFidelity] Whether to use the extended fidelity color set. See [MaterialDynamicColors].
 */
public fun paletteonColorScheme(
  seedColor: Color,
  isDark: Boolean,
  isAmoled: Boolean,
  style: PaletteStyle = PaletteStyle.TonalSpot,
  contrast: Contrast = Contrast.Default,
  isExtendedFidelity: Boolean = false,
  modifyColorScheme: ((ColorScheme) -> ColorScheme)? = null,
): ColorScheme {
  val scheme = seedColor.toDynamicScheme(isDark, style, contrast)
  val colors = MaterialDynamicColors(isExtendedFidelity)

  return ColorScheme(
    background = if (isDark && isAmoled) Color.Black else colors.background().getColor(scheme),
    error = colors.error().getColor(scheme),
    errorContainer = colors.errorContainer().getColor(scheme),
    inverseOnSurface = colors.inverseOnSurface().getColor(scheme),
    inversePrimary = colors.inversePrimary().getColor(scheme),
    inverseSurface = colors.inverseSurface().getColor(scheme),
    onBackground = if (isDark && isAmoled) Color.White else colors.onBackground().getColor(scheme),
    onError = colors.onError().getColor(scheme),
    onErrorContainer = colors.onErrorContainer().getColor(scheme),
    onPrimary = colors.onPrimary().getColor(scheme),
    onPrimaryContainer = colors.onPrimaryContainer().getColor(scheme),
    onSecondary = colors.onSecondary().getColor(scheme),
    onSecondaryContainer = colors.onSecondaryContainer().getColor(scheme),
    onSurface = if (isDark && isAmoled) Color.White else colors.onSurface().getColor(scheme),
    onSurfaceVariant = colors.onSurfaceVariant().getColor(scheme),
    onTertiary = colors.onTertiary().getColor(scheme),
    onTertiaryContainer = colors.onTertiaryContainer().getColor(scheme),
    outline = colors.outline().getColor(scheme),
    outlineVariant = colors.outlineVariant().getColor(scheme),
    primary = colors.primary().getColor(scheme),
    primaryContainer = colors.primaryContainer().getColor(scheme),
    secondary = colors.secondary().getColor(scheme),
    secondaryContainer = colors.secondaryContainer().getColor(scheme),
    tertiary = colors.tertiary().getColor(scheme),
    tertiaryContainer = colors.tertiaryContainer().getColor(scheme),
    scrim = colors.scrim().getColor(scheme),
    surface = if (isDark && isAmoled) Color.Black else colors.surface().getColor(scheme),
    surfaceTint = colors.surfaceTint().getColor(scheme),
    surfaceBright = colors.surfaceBright().getColor(scheme),
    surfaceDim = colors.surfaceDim().getColor(scheme),
    surfaceContainer = colors.surfaceContainer().getColor(scheme),
    surfaceContainerHigh = colors.surfaceContainerHigh().getColor(scheme),
    surfaceContainerHighest = colors.surfaceContainerHighest().getColor(scheme),
    surfaceContainerLow = colors.surfaceContainerLow().getColor(scheme),
    surfaceContainerLowest = colors.surfaceContainerLowest().getColor(scheme),
    surfaceVariant = colors.surfaceVariant().getColor(scheme),
  ).let { modifyColorScheme?.invoke(it) ?: it }
}
