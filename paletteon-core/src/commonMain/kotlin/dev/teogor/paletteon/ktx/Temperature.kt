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

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import dev.teogor.paletteon.temperature.TemperatureCache

/**
 * Creates a [TemperatureCache] for a color using color temperature theory.
 *
 * The cache allows efficient calculation of complementary and analogous colors based on the given color.
 * It operates using the HCT (Hue, Chroma, Tone) color model to determine colors with similar tone and chroma.
 *
 * @param baseColor The color to find complementary and analogous colors for. The resulting colors
 * will have the same tone and chroma as this color, with adjustments based on hue limits.
 * @return A [TemperatureCache] instance for the specified color.
 */
public fun TemperatureCache(baseColor: Color): TemperatureCache {
  return TemperatureCache(baseColor.toHct())
}

/**
 * Computes the cool-warm factor of a color.
 *
 * The cool-warm factor indicates whether a color is perceived as cool or warm based on color science.
 * - Values below 0 are considered cool.
 * - Values above 0 are considered warm.
 *
 * This method uses the Lab/LCH color space and the algorithm from Ou, Woodcock, and Wright.
 * The range of the factor is approximately -9.66 (cool) to 8.61 (warm), assuming maximum Lab chroma.
 *
 * @param color The color to compute the cool-warm factor for.
 * @return A value indicating the cool-warm factor of the color. Values below 0 are cool, and values above 0 are warm.
 */
public fun TemperatureCache.Companion.calculateCoolWarmFactor(color: Color): Double {
  return rawTemperature(color.toHct())
}

/**
 * Checks if the color is considered warm based on its cool-warm factor.
 *
 * @receiver The color to check.
 * @return `true` if the color is warm, `false` otherwise.
 */
@Stable
public fun Color.isWarm(): Boolean {
  return TemperatureCache.calculateCoolWarmFactor(this) > 0
}

/**
 * Checks if the color is considered cool based on its cool-warm factor.
 *
 * @receiver The color to check.
 * @return `true` if the color is cool, `false` otherwise.
 */
@Stable
public fun Color.isCool(): Boolean {
  return TemperatureCache.calculateCoolWarmFactor(this) < 0
}
