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
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import dev.teogor.paletteon.dynamiccolor.DynamicColor
import dev.teogor.paletteon.dynamiccolor.MaterialDynamicColors
import dev.teogor.paletteon.ktx.getColor
import dev.teogor.paletteon.ktx.toDynamicScheme
import dev.teogor.paletteon.scheme.DynamicScheme

/**
 * Holds the current Paletteon theme state as a [MutableState].
 *
 * This lazy-initialized property provides a [MutableState] that contains the current
 * Paletteon theme configuration. It is initialized with the theme defined in
 * [PaletteonConfig.initialPaletteonTheme]. This state is used to track and update
 * the theme dynamically within the composition.
 */
private val rootPaletteonThemeState by lazy {
  println("Root paletteon theme state initialized")
  mutableStateOf(PaletteonConfig.Instance.initialPaletteonTheme)
}

/**
 * CompositionLocal for providing and accessing the current Paletteon theme within the composition.
 *
 * This [CompositionLocal] is used to provide the current Paletteon theme to the composable hierarchy.
 * Components that use [LocalPaletteonTheme] can access the current theme state and react to changes
 * in the theme configuration.
 */
internal val LocalPaletteonTheme = compositionLocalOf { rootPaletteonThemeState }

/**
 * Data class representing the theme configuration for Paletteon.
 *
 * @property seedColor The primary color used for the theme. Defaults to [Color.Blue].
 * @property useDarkTheme Indicates whether the dark theme should be used. Defaults to `false`.
 * @property withAmoled Indicates whether AMOLED mode should be enabled. Defaults to `false`.
 * @property style The style to be applied to the theme. Defaults to [PaletteStyle.TonalSpot].
 * @property contrast The contrast setting for the theme. Defaults to [Contrast.Default].
 * @property isExtendedFidelity Indicates whether extended fidelity is enabled. Defaults to `false`.
 */
@Immutable
public data class PaletteonTheme(
  val seedColor: Color = Color.Blue,
  val useDarkTheme: Boolean = false,
  val withAmoled: Boolean = false,
  val style: PaletteStyle = PaletteStyle.TonalSpot,
  val contrast: Contrast = Contrast.Default,
  val isExtendedFidelity: Boolean = false,
  val modifyColorScheme: (PaletteonTheme.(ColorScheme) -> ColorScheme)? = null,
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

  private val colors: MaterialDynamicColors = MaterialDynamicColors(isExtendedFidelity)
  private val scheme: DynamicScheme = seedColor.toDynamicScheme(useDarkTheme, style, contrast)

  public fun getColor(
    colorRole: MaterialDynamicColors.() -> DynamicColor = { primary() }
  ): Color {
    return colors.colorRole().getColor(scheme)
  }

  /**
   * Converts the current [PaletteonTheme] instance to a [Builder].
   */
  internal fun toBuilder(): Builder = Builder(
    seedColor = seedColor,
    useDarkTheme = useDarkTheme,
    withAmoled = withAmoled,
    style = style,
    contrast = contrast,
    isExtendedFidelity = isExtendedFidelity,
    modifyColorScheme = modifyColorScheme,
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
     * @return The current [Builder].
     */
    public val current: PaletteonTheme @Composable @ReadOnlyComposable get() = LocalPaletteonTheme.current.value
  }

  /**
   * Data class representing a builder for configuring a [PaletteonTheme].
   *
   * @property seedColor The primary color used for the theme.
   * @property useDarkTheme Indicates whether the dark theme should be used.
   * @property withAmoled Indicates whether AMOLED mode should be enabled.
   * @property style The style to be applied to the theme.
   * @property contrast The contrast setting for the theme.
   * @property isExtendedFidelity Indicates whether extended fidelity is enabled.
   * @property modifyColorScheme A lambda to modify the color scheme.
   */
  public data class Builder(
    var seedColor: Color,
    var useDarkTheme: Boolean,
    var withAmoled: Boolean,
    var style: PaletteStyle,
    var contrast: Contrast,
    var isExtendedFidelity: Boolean,
    var modifyColorScheme: (PaletteonTheme.(ColorScheme) -> ColorScheme)? = null
  ) {
    /**
     * Builds the [PaletteonTheme] from the current state of the [Builder].
     */
    public fun build(): PaletteonTheme = PaletteonTheme(
      seedColor = seedColor,
      useDarkTheme = useDarkTheme,
      withAmoled = withAmoled,
      style = style,
      contrast = contrast,
      isExtendedFidelity = isExtendedFidelity,
      modifyColorScheme = modifyColorScheme,
    )

    /**
     * Toggles the dark theme setting.
     */
    public fun toggleDarkTheme() {
      useDarkTheme = !useDarkTheme
    }

    /**
     * Toggles the AMOLED mode setting.
     */
    public fun toggleAmoled() {
      withAmoled = !withAmoled
    }

    /**
     * Toggles the extended fidelity setting.
     */
    public fun toggleExtendedFidelity() {
      isExtendedFidelity = !isExtendedFidelity
    }

    /**
     * Moves to the next [PaletteStyle] in the enum.
     */
    public fun nextPaletteStyle() {
      style = PaletteStyle.entries.let {
        val currentIndex = it.indexOf(style)
        val nextIndex = (currentIndex + 1) % it.size
        it[nextIndex]
      }
    }

    /**
     * Moves to the previous [PaletteStyle] in the enum.
     */
    public fun previousPaletteStyle() {
      style = PaletteStyle.entries.let {
        val currentIndex = it.indexOf(style)
        val prevIndex = if (currentIndex - 1 < 0) it.size - 1 else currentIndex - 1
        it[prevIndex]
      }
    }

    /**
     * Moves to the next [Contrast] in the enum.
     */
    public fun nextContrast() {
      contrast = Contrast.entries.let {
        val currentIndex = it.indexOf(contrast)
        val nextIndex = (currentIndex + 1) % it.size
        it[nextIndex]
      }
    }

    /**
     * Moves to the previous [Contrast] in the enum.
     */
    public fun previousContrast() {
      contrast = Contrast.entries.let {
        val currentIndex = it.indexOf(contrast)
        val prevIndex = if (currentIndex - 1 < 0) it.size - 1 else currentIndex - 1
        it[prevIndex]
      }
    }
  }
}

/**
 * Configures the current [PaletteonTheme] using a DSL-style builder.
 *
 * This function modifies the theme in the current composition using the provided
 * DSL-style builder block. The updated theme is applied to the composition state.
 *
 * @param block A lambda function where you can configure the theme using the [PaletteonTheme.Builder] receiver.
 */
@PaletteonDsl
@Composable
public fun configurePaletteonTheme(
  block: PaletteonTheme.Builder.() -> Unit
) {
  var theme by PaletteonTheme.currentState
  theme = applyThemeModifications(theme, block)
}

/**
 * Configures a new [PaletteonTheme] using a DSL-style builder.
 *
 * This function modifies the given [PaletteonTheme] instance using the provided
 * DSL-style builder block and returns the updated theme.
 *
 * @param theme The current [PaletteonTheme] instance to be modified.
 * @param block A lambda function where you can configure the theme using the [PaletteonTheme.Builder] receiver.
 * @return The newly built [PaletteonTheme] with applied modifications.
 */
@PaletteonDsl
public fun configurePaletteonTheme(
  theme: PaletteonTheme,
  block: PaletteonTheme.Builder.() -> Unit
): PaletteonTheme {
  return applyThemeModifications(theme, block)
}

/**
 * Applies modifications to a [PaletteonTheme] using a DSL-style builder.
 *
 * This function handles the creation and application of theme modifications using the
 * provided DSL-style builder block.
 *
 * @param theme The current [PaletteonTheme] instance to be modified.
 * @param block A lambda function where you can configure the theme using the [PaletteonTheme.Builder] receiver.
 * @return The newly built [PaletteonTheme] with applied modifications.
 */
private fun applyThemeModifications(
  theme: PaletteonTheme,
  block: PaletteonTheme.Builder.() -> Unit
): PaletteonTheme {
  val builder = theme.toBuilder()
  builder.block()
  return builder.build()
}
