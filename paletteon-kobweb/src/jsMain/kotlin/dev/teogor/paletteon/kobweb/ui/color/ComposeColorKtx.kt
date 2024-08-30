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

package dev.teogor.paletteon.kobweb.ui.color

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.rgba
import kotlin.math.roundToInt

/**
 * Returns the red component of the color as an integer between 0 and 255.
 */
@Stable
public val Color.redInt: Int
  get() = (red * 255.0f).roundToInt()

/**
 * Returns the green component of the color as an integer between 0 and 255.
 */
@Stable
public val Color.greenInt: Int
  get() = (green * 255.0f).roundToInt()

/**
 * Returns the blue component of the color as an integer between 0 and 255.
 */
@Stable
public val Color.blueInt: Int
  get() = (blue * 255.0f).roundToInt()

/**
 * Returns the alpha component of the color as an integer between 0 and 255.
 */
@Stable
public val Color.alphaInt: Int
  get() = (alpha * 255.0f).roundToInt()

/**
 * Converts the [Color] to a [CSSColorValue] in the `rgb()` format.
 *
 * @return A [CSSColorValue] representing the color in the `rgb()` format, without the alpha channel.
 * @see asRgba
 */
@Stable
public fun Color.asRgb(): CSSColorValue {
  return rgb(redInt, greenInt, blueInt)
}

/**
 * Converts the [Color] to a [CSSColorValue] in the `rgba()` format.
 *
 * @return A [CSSColorValue] representing the color in the `rgba()` format, including the alpha channel.
 * @see asRgb
 */
@Stable
public fun Color.asRgba(): CSSColorValue {
  return rgba(redInt, greenInt, blueInt, alpha)
}
