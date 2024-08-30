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
import androidx.compose.ui.graphics.toArgb
import dev.teogor.paletteon.blend.Blend


/**
 * Blends two colors together, adjusting hue, chroma, and tone based on the specified amount.
 *
 * This function computes a color that is a blend between the [from] color and the [to] color.
 * The blending amount determines how much of the [to] color is mixed with the [from] color.
 * An amount of `0.0` results in the original [from] color, while `1.0` results in the [to] color.
 *
 * @param from The [Color] to blend from.
 * @param to The [Color] to blend to.
 * @param amount The proportion of blending; a value between `0.0` (fully [from]) and `1.0` (fully [to]).
 * @return The resulting [Color] that is blended from [from] towards [to].
 */
public fun Blend.blend(
  from: Color,
  to: Color,
  amount: Float
): Color {
  val blended = cam16Ucs(from.toArgb(), to.toArgb(), amount.toDouble())
  return Color(blended)
}

/**
 * Blends this [Color] into another color, adjusting hue, chroma, and tone based on the specified amount.
 *
 * This extension function computes a color that is a blend between the receiver [Color] and the [to] color.
 * The blending amount determines how much of the [to] color is mixed with the receiver color.
 * An amount of `0.0` results in the receiver color, while `1.0` results in the [to] color.
 *
 * @param to The [Color] to blend to.
 * @param amount The proportion of blending; a value between `0.0` (fully receiver color) and `1.0` (fully [to]).
 * @return The resulting [Color] that is blended from the receiver color towards [to].
 */
public fun Color.blend(
  to: Color,
  amount: Float = 0.5f
): Color = Blend.blend(this, to, amount)

/**
 * Blends the hue of one color into another while maintaining the original chroma and tone.
 *
 * This function computes a color that has the hue blended from the [from] color towards the [to] color.
 * The chroma and tone of the original color remain unchanged.
 * The blending amount determines how much of the [to] color's hue is mixed with the [from] color's hue.
 *
 * @param from The [Color] to blend the hue from.
 * @param to The [Color] to blend the hue to.
 * @param amount The proportion of hue blending; a value between `0.0` (fully [from] hue) and `1.0` (fully [to] hue).
 * @return The resulting [Color] with the hue of [from] blended towards [to], while chroma and tone remain constant.
 */
public fun Blend.blendHue(
  from: Color,
  to: Color,
  amount: Float
): Color {
  val blended = hctHue(from.toArgb(), to.toArgb(), amount.toDouble())
  return Color(blended)
}

/**
 * Blends the hue of this [Color] into another color while maintaining the original chroma and tone.
 *
 * This extension function computes a color that has the hue of the receiver color blended into the [to] color.
 * The chroma and tone of the receiver color remain unchanged.
 * The blending amount determines how much of the [to] color's hue is mixed with the receiver color's hue.
 *
 * @param to The [Color] to blend the hue to.
 * @param amount The proportion of hue blending; a value between `0.0` (fully receiver hue) and `1.0` (fully [to] hue).
 * @return The resulting [Color] with the hue of the receiver color blended towards [to], while chroma and tone remain constant.
 */
public fun Color.blendHue(
  to: Color,
  amount: Float = 0.5f
): Color = Blend.blendHue(this, to, amount)
