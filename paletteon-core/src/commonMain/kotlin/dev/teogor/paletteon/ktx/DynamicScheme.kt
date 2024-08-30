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

package dev.teogor.paletteon.ktx

import androidx.compose.ui.graphics.Color
import dev.teogor.paletteon.Contrast
import dev.teogor.paletteon.PaletteStyle
import dev.teogor.paletteon.scheme.DynamicScheme
import dev.teogor.paletteon.scheme.SchemeContent
import dev.teogor.paletteon.scheme.SchemeExpressive
import dev.teogor.paletteon.scheme.SchemeFidelity
import dev.teogor.paletteon.scheme.SchemeFruitSalad
import dev.teogor.paletteon.scheme.SchemeMonochrome
import dev.teogor.paletteon.scheme.SchemeNeutral
import dev.teogor.paletteon.scheme.SchemeRainbow
import dev.teogor.paletteon.scheme.SchemeTonalSpot
import dev.teogor.paletteon.scheme.SchemeVibrant

/**
 * Retrieves the [Color] that was used to generate this [DynamicScheme].
 *
 * @return The [Color] used as the source for creating the [DynamicScheme].
 */
public val DynamicScheme.sourceColor: Color
  get() = Color(sourceColorArgb)


/**
 * Generates a [DynamicScheme] based on the specified [Color] and configuration parameters.
 *
 * This function creates a [DynamicScheme] that adjusts to the provided color, mode (dark or light),
 * style, and contrast level.
 *
 * @param isDark A boolean flag indicating whether the scheme should be dark (`true`) or light (`false`).
 * @param style The style of the scheme. Refer to [PaletteStyle] for available options.
 * @param contrast The contrast level to apply to the scheme. Defaults to [Contrast.Default].
 * @return The [DynamicScheme] generated according to the specified parameters.
 */
public fun Color.toDynamicScheme(
  isDark: Boolean,
  style: PaletteStyle,
  contrast: Contrast = Contrast.Default,
): DynamicScheme {
  val hctColor = toHct()
  val contrastLevel = contrast.value
  return when (style) {
    PaletteStyle.TonalSpot -> SchemeTonalSpot(hctColor, isDark, contrastLevel)
    PaletteStyle.Neutral -> SchemeNeutral(hctColor, isDark, contrastLevel)
    PaletteStyle.Vibrant -> SchemeVibrant(hctColor, isDark, contrastLevel)
    PaletteStyle.Expressive -> SchemeExpressive(hctColor, isDark, contrastLevel)
    PaletteStyle.Rainbow -> SchemeRainbow(hctColor, isDark, contrastLevel)
    PaletteStyle.FruitSalad -> SchemeFruitSalad(hctColor, isDark, contrastLevel)
    PaletteStyle.Monochrome -> SchemeMonochrome(hctColor, isDark, contrastLevel)
    PaletteStyle.Fidelity -> SchemeFidelity(hctColor, isDark, contrastLevel)
    PaletteStyle.Content -> SchemeContent(hctColor, isDark, contrastLevel)
  }
}
