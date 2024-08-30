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

package dev.teogor.paletteon.kobweb

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import dev.teogor.paletteon.Contrast
import dev.teogor.paletteon.PaletteStyle
import dev.teogor.paletteon.paletteonColorScheme
import kotlinx.browser.localStorage

/**
 * Holds the current Paletteon theme state as a [MutableState].
 *
 * This lazy-initialized property provides a [MutableState] that contains the current
 * Paletteon theme configuration. It is initialized with the theme defined in
 * [PaletteonConfig.initialPaletteonTheme]. This state is used to track and update
 * the theme dynamically within the composition.
 */
private val rootPaletteonThemeState by lazy {
  mutableStateOf(PaletteonConfig.Instance.initialPaletteonTheme)
}

/**
 * CompositionLocal for providing and accessing the current Paletteon theme within the composition.
 *
 * This [CompositionLocal] is used to provide the current Paletteon theme to the composable hierarchy.
 * Components that use [LocalPaletteonTheme] can access the current theme state and react to changes
 * in the theme configuration.
 */
private val LocalPaletteonTheme = compositionLocalOf { rootPaletteonThemeState }

/**
 * Data class representing the theme configuration for Paletteon.
 *
 * @property seedColor The primary color used for the theme. Defaults to [Color.Blue].
 * @property useDarkTheme Indicates whether the dark theme should be used. Defaults to `false`.
 * @property withAmoled Indicates whether AMOLED mode should be enabled. Defaults to `false`.
 * @property style The style to be applied to the theme. Defaults to [PaletteStyle.TonalSpot].
 * @property contrast The contrast setting for the theme. Defaults to [Contrast.Default].
 * @property isExtendedFidelity Indicates whether extended fidelity is enabled. Defaults to `false`.
 * @property animate Indicates whether animations should be applied to the theme changes. Defaults to `false`.
 */
public data class PaletteonTheme(
  val seedColor: Color = Color.Blue,
  val useDarkTheme: Boolean = false,
  val withAmoled: Boolean = false,
  val style: PaletteStyle = PaletteStyle.TonalSpot,
  val contrast: Contrast = Contrast.Default,
  val isExtendedFidelity: Boolean = false,
  val animate: Boolean = false,
) {
  /**
   * Computes the color scheme based on the current theme settings.
   *
   * The color scheme is derived from the primary color (`seedColor`), theme mode (`useDarkTheme`), AMOLED mode
   * (`withAmoled`), style (`style`), contrast setting (`contrast`), and extended fidelity (`isExtendedFidelity`).
   * This computed [ColorScheme] is used to apply consistent colors throughout the application based on the theme.
   */
  val colorScheme: ColorScheme = paletteonColorScheme(
    seedColor = seedColor,
    isDark = useDarkTheme,
    isAmoled = withAmoled,
    style = style,
    contrast = contrast,
    isExtendedFidelity = isExtendedFidelity,
  )

  public companion object {
    /**
     * The current Paletteon theme, exposed as a [MutableState] so that you can change it and have the UI update.
     *
     * This property provides a [MutableState] that holds the current Paletteon theme. It allows
     * components to observe and react to changes in the theme configuration.
     *
     * @return The [MutableState] of the current Paletteon theme.
     */
    public val currentState: MutableState<PaletteonTheme> @Composable get() = LocalPaletteonTheme.current

    /**
     * The current Paletteon theme.
     *
     * This property provides read-only access to the current Paletteon theme. It returns the
     * value of the theme as provided by [LocalPaletteonTheme]. Components that need to access
     * the theme configuration can use this property.
     *
     * @return The current [PaletteonTheme].
     */
    public val current: PaletteonTheme @Composable @ReadOnlyComposable get() = LocalPaletteonTheme.current.value
  }
}

/**
 * Retrieves a [Color] from local storage. Returns a default color if not found or invalid.
 *
 * @param defaultColor The default color to return if no value is found or if the stored value is invalid.
 * @return The retrieved or default [Color].
 */
private fun getSeedColorFromLocalStorage(defaultColor: Color = Color.Gray): Color {
  return localStorage.getItem(Constants.Storage.SEED_COLOR_KEY)?.let {
    Color(it.toLongOrNull() ?: defaultColor.value.toLong())
  } ?: defaultColor
}

/**
 * Retrieves a [Boolean] value from local storage. Returns a default value if not found or invalid.
 *
 * @param key The key used to retrieve the value.
 * @param defaultValue The default value to return if no value is found or if the stored value is invalid.
 * @return The retrieved or default [Boolean] value.
 */
private fun getBooleanFromLocalStorage(key: String, defaultValue: Boolean): Boolean {
  return localStorage.getItem(key)?.toBoolean() ?: defaultValue
}

/**
 * Retrieves a [PaletteStyle] from local storage. Returns a default style if not found or invalid.
 *
 * @param defaultStyle The default style to return if no value is found or if the stored value is invalid.
 * @return The retrieved or default [PaletteStyle].
 */
private fun getPaletteStyleFromLocalStorage(defaultStyle: PaletteStyle = PaletteStyle.TonalSpot): PaletteStyle {
  return PaletteStyle.valueOf(
    localStorage.getItem(Constants.Storage.STYLE_KEY) ?: defaultStyle.name
  )
}

/**
 * Retrieves a [Contrast] from local storage. Returns a default contrast if not found or invalid.
 *
 * @param defaultContrast The default contrast to return if no value is found or if the stored value is invalid.
 * @return The retrieved or default [Contrast].
 */
private fun getContrastFromLocalStorage(defaultContrast: Contrast = Contrast.Default): Contrast {
  return Contrast.valueOf(
    localStorage.getItem(Constants.Storage.CONTRAST_KEY) ?: defaultContrast.name
  )
}

/**
 * Retrieves the current Paletteon theme from local storage or provides default values if not found.
 *
 * @return The current [PaletteonTheme] with values from local storage or defaults.
 */
public fun getInitialPaletteonTheme(): PaletteonTheme {
  val seedColor = getSeedColorFromLocalStorage()
  val useDarkTheme = getBooleanFromLocalStorage(
    key = Constants.Storage.DARK_THEME_KEY,
    defaultValue = true
  )
  val withAmoled = getBooleanFromLocalStorage(
    key = Constants.Storage.AMOLED_KEY,
    defaultValue = false
  )
  val style = getPaletteStyleFromLocalStorage()
  val contrast = getContrastFromLocalStorage()
  val isExtendedFidelity = getBooleanFromLocalStorage(
    key = Constants.Storage.EXTENDED_FIDELITY_KEY,
    defaultValue = false
  )
  val animate = getBooleanFromLocalStorage(
    key = Constants.Storage.ANIMATE_KEY,
    defaultValue = false
  )

  return PaletteonTheme(
    seedColor = seedColor,
    useDarkTheme = useDarkTheme,
    withAmoled = withAmoled,
    style = style,
    contrast = contrast,
    isExtendedFidelity = isExtendedFidelity,
    animate = animate
  )
}

/**
 * Saves the given [PaletteonTheme] to local storage.
 *
 * @param theme The [PaletteonTheme] to save.
 */
public fun savePaletteonTheme(theme: PaletteonTheme) {
  localStorage.setItem(
    Constants.Storage.SEED_COLOR_KEY,
    theme.seedColor.value.toString()
  )
  localStorage.setItem(
    Constants.Storage.DARK_THEME_KEY,
    theme.useDarkTheme.toString()
  )
  localStorage.setItem(
    Constants.Storage.AMOLED_KEY,
    theme.withAmoled.toString()
  )
  localStorage.setItem(
    Constants.Storage.STYLE_KEY,
    theme.style.name
  )
  localStorage.setItem(
    Constants.Storage.CONTRAST_KEY,
    theme.contrast.name
  )
  localStorage.setItem(
    Constants.Storage.EXTENDED_FIDELITY_KEY,
    theme.isExtendedFidelity.toString()
  )
  localStorage.setItem(
    Constants.Storage.ANIMATE_KEY,
    theme.animate.toString()
  )
}
