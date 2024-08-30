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

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import dev.teogor.paletteon.blend.Blend
import dev.teogor.paletteon.hct.Hct

/**
 * Blends the hue of the `fromColor` towards the hue of the `toColor`, while keeping the original
 * color recognizable and shifted towards the target color.
 *
 * If you want to adjust the saturation of `fromColor` to match the saturation of `toColor`,
 * set `matchSaturation` to `true`.
 *
 * @param fromColor The [Color] to blend from.
 * @param toColor The [Color] to blend towards.
 * @param matchSaturation Whether to adjust the saturation of `fromColor` to match that of `toColor`.
 * @return The [Color] resulting from the blend.
 */
@Stable
public fun Blend.harmonize(
  fromColor: Color,
  toColor: Color,
  matchSaturation: Boolean = false,
): Color {
  val adjustedFromColor = if (matchSaturation) {
    fromColor.matchSaturation(toColor)
  } else {
    fromColor
  }

  val fromHct = Hct.from(adjustedFromColor)
  val toHct = Hct.from(toColor)
  return harmonize(fromHct, toHct).toColor()
}

/**
 * Blends the hue of this [Color] towards the hue of the specified [other] color, while keeping the
 * original color recognizable and shifted towards the target color.
 *
 * If you want to adjust the saturation of this color to match the saturation of [other], set
 * `matchSaturation` to `true`.
 *
 * @receiver The [Color] to blend from.
 * @param other The [Color] to blend towards.
 * @param matchSaturation Whether to adjust the saturation of this color to match that of `other`.
 * @return The [Color] resulting from the blend.
 */
@Stable
public fun Color.harmonize(
  other: Color,
  matchSaturation: Boolean = false,
): Color {
  return Blend.harmonize(fromColor = this, toColor = other, matchSaturation = matchSaturation)
}

/**
 * Returns the [Color] that represents the given `color` harmonized with the primary color of this
 * [ColorScheme].
 *
 * If you want to adjust the saturation of `color` to match the saturation of [ColorScheme.primary],
 * set `matchSaturation` to `true`.
 *
 * @param color The [Color] to harmonize with the primary color of the scheme.
 * @param matchSaturation Whether to adjust the saturation of `color` to match that of [ColorScheme.primary].
 * @return The [Color] harmonized with the primary color of the scheme.
 */
@Stable
public fun ColorScheme.harmonizeWithPrimary(
  color: Color,
  matchSaturation: Boolean = false
): Color {
  return Blend.harmonize(fromColor = color, toColor = primary, matchSaturation = matchSaturation)
}
