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
import androidx.compose.ui.graphics.toArgb
import com.github.ajalt.colormath.model.HSL
import dev.teogor.paletteon.contrast.Contrast
import dev.teogor.paletteon.dislike.DislikeAnalyzer
import dev.teogor.paletteon.internal.toColormathColor
import dev.teogor.paletteon.internal.toComposeColor
import dev.teogor.paletteon.utils.ColorUtils

/**
 * Checks if the [Color] is considered light.
 *
 * This function determines whether the color is light based on its luminance value.
 * Colors with a luminance greater than `0.5` are considered light.
 * The function also considers transparency and will return false for transparent colors.
 *
 * @receiver The [Color] to check.
 * @return `true` if the color is light, `false` otherwise.
 */
@Stable
public fun Color.isLight(): Boolean {
  return this != Color.Transparent && ColorUtils.calculateLuminance(toArgb()) > 0.5
}

/**
 * Lightens the color by the specified ratio.
 *
 * This function lightens the color by adjusting its tone based on the provided ratio.
 * A ratio of `1.0` lightens the color to its maximum extent, while values greater than `1.0` will lighten the color even more.
 * If the resulting tone is invalid, the original color is returned.
 *
 * @receiver The [Color] to lighten.
 * @param ratio The ratio by which to lighten the color; must be greater than `0.0`.
 * @return The lightened [Color], or the original color if the lightened color is not valid.
 */
@Stable
public fun Color.lighten(ratio: Float = 1.0f): Color {
  val hct = toHct()
  val tone = Contrast.lighter(hct.tone, ratio.toDouble()).takeIf { it > -1 }
  return if (tone == null) this else hct.withTone(tone).toColor()
}

/**
 * Darkens the color by the specified ratio.
 *
 * This function darkens the color by adjusting its tone based on the provided ratio.
 * A ratio of `1.1` darkens the color to a slightly darker tone, while values greater than `1.1` will darken the color further.
 * If the resulting tone is invalid, the original color is returned.
 *
 * @receiver The [Color] to darken.
 * @param ratio The ratio by which to darken the color; must be greater than `0.0`.
 * @return The darkened [Color], or the original color if the darkened color is not valid.
 */
@Stable
public fun Color.darken(ratio: Float = 1.1f): Color {
  val hct = toHct()
  val tone = Contrast.darker(hct.tone, ratio.toDouble()).takeIf { it > -1 }
  return if (tone == null) this else hct.withTone(tone).toColor()
}

/**
 * Determines if the color is disliked.
 *
 * A color is considered disliked if it is a dark yellow-green that is not neutral.
 *
 * @receiver The [Color] to check.
 * @return `true` if the color is disliked, `false` otherwise.
 */
@Stable
public fun Color.isDisliked(): Boolean {
  return DislikeAnalyzer.isDisliked(toHct())
}

/**
 * Lightens the color if it is disliked to make it more likable.
 *
 * If the color is identified as disliked, this function lightens it to adjust its hue, making it more acceptable.
 * The result is a color that is not disliked.
 *
 * @receiver The [Color] to check and potentially adjust.
 * @return A lightened [Color] that is not disliked.
 */
@Stable
public fun Color.fixIfDisliked(): Color {
  return DislikeAnalyzer.fixIfDisliked(toHct()).toColor()
}

/**
 * Creates a new [Color] with the same hue as this color, but with the saturation and lightness of another color.
 *
 * This function matches the hue of the receiver color with the saturation and lightness of the [other] color.
 * The resulting color has the same hue as the receiver color but adjusted saturation and lightness from the [other] color.
 *
 * @receiver The [Color] to match hue.
 * @param other The [Color] to match saturation and lightness.
 * @return A new [Color] with the same hue as the receiver color, but with the saturation and lightness of [other].
 */
@Stable
internal fun Color.matchSaturation(other: Color): Color {
  val hsl = toColormathColor().toHSL()
  val otherHsl = other.toColormathColor().toHSL()
  return HSL(hsl.h, otherHsl.s, otherHsl.l).toComposeColor()
}
