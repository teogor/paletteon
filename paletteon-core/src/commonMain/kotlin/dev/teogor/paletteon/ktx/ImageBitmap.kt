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

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toArgb
import dev.teogor.paletteon.quantize.QuantizerCelebi
import dev.teogor.paletteon.score.Score

private const val MAX_COLORS_DEFAULT = 128
private const val DESIRED_COLORS_DEFAULT = 4

/**
 * Quantizes the colors in an [ImageBitmap] to a specified maximum number of colors.
 *
 * @param image The [ImageBitmap] from which colors are extracted.
 * @param maxColors The maximum number of colors to extract from the image. Fewer colors may be returned depending on the image content.
 * @return A map where keys are colors and values are their frequencies in the image.
 */
public fun QuantizerCelebi.quantize(image: ImageBitmap, maxColors: Int): Map<Int, Int> {
  val pixels = IntArray(image.width * image.height)
  image.readPixels(
    buffer = pixels,
    startX = 0,
    startY = 0,
  )

  return quantize(pixels, maxColors)
}

/**
 * Ranks colors extracted from an [ImageBitmap] by their suitability for a UI theme.
 *
 * @receiver The [ImageBitmap] to extract and rank colors from.
 * @param maxColors The maximum number of colors to extract from the image.
 * @param fallbackColor The color to return if no suitable theme colors are found. Defaults to Google Blue.
 * @param filter Whether to filter out undesirable color combinations.
 * @param numberOfColors Desired number of colors to return.
 * @return A list of colors sorted by their suitability for a UI theme. The list will always contain at least one color.
 */
@Stable
public fun ImageBitmap.themeColors(
  maxColors: Int = MAX_COLORS_DEFAULT,
  fallbackColor: Color = Color(-0xbd7a0c), // Default to Google Blue
  filter: Boolean = true,
  numberOfColors: Int = DESIRED_COLORS_DEFAULT,
): List<Color> {
  val quantizedColors = QuantizerCelebi.quantize(image = this, maxColors = maxColors)
  return Score.score(
    colorsToPopulation = quantizedColors,
    desired = numberOfColors,
    fallbackColorArgb = fallbackColor.toArgb(),
    filter = filter,
  ).map { Color(it) }
}

/**
 * Determines the most suitable color in an [ImageBitmap] for a UI theme.
 *
 * @receiver The [ImageBitmap] to extract and rank colors from.
 * @param fallbackColor The color to return if no suitable theme colors are found. Defaults to Google Blue.
 * @param filter Whether to filter out undesirable color combinations.
 * @param maxColors The maximum number of colors to extract from the image.
 * @return The most suitable color for a UI theme.
 */
@Stable
public fun ImageBitmap.themeColor(
  fallbackColor: Color = Color(-0xbd7a0c), // Default to Google Blue
  filter: Boolean = true,
  maxColors: Int = MAX_COLORS_DEFAULT,
): Color {
  return themeColors(maxColors = maxColors, fallbackColor = fallbackColor, filter = filter)
    .first()
}

/**
 * Determines the most suitable color in an [ImageBitmap] for a UI theme, or `null` if no suitable color is found.
 *
 * @receiver The [ImageBitmap] to extract and rank colors from.
 * @param filter Whether to filter out undesirable color combinations.
 * @param maxColors The maximum number of colors to extract from the image.
 * @return The most suitable color for a UI theme, or `null` if no suitable color is found.
 */
@Stable
public fun ImageBitmap.themeColorOrNull(
  filter: Boolean = true,
  maxColors: Int = MAX_COLORS_DEFAULT,
): Color? {
  val quantizedColors = QuantizerCelebi.quantize(image = this, maxColors = maxColors)
  return Score.score(
    colorsToPopulation = quantizedColors,
    desired = 1,
    fallbackColorArgb = null,
    filter = filter,
  ).firstOrNull()?.let { colorInt -> Color(colorInt) }
}

/**
 * Creates a state holder for a list of theme colors derived from an [ImageBitmap].
 *
 * @param image The [ImageBitmap] to extract colors from.
 * @param fallbackColor The color to return if no suitable theme colors are found. Defaults to the primary color of the Material theme.
 * @param maxColors The maximum number of colors to extract from the image.
 * @param filter Whether to filter out undesirable color combinations.
 * @param numberOfColors Desired number of colors to return.
 * @return A list of colors suitable for a UI theme, with the most suitable color first.
 */
@Stable
@Composable
public fun rememberThemeColors(
  image: ImageBitmap,
  fallbackColor: Color = MaterialTheme.colorScheme.primary,
  maxColors: Int = MAX_COLORS_DEFAULT,
  filter: Boolean = true,
  numberOfColors: Int = DESIRED_COLORS_DEFAULT,
): List<Color> {
  var themeColors by remember { mutableStateOf(listOf(fallbackColor)) }
  LaunchedEffect(image, fallbackColor, filter, maxColors) {
    themeColors = image.themeColors(maxColors, fallbackColor, filter, numberOfColors)
  }

  return themeColors
}

/**
 * Creates a state holder for the most suitable theme color derived from an [ImageBitmap].
 *
 * @param image The [ImageBitmap] to extract colors from.
 * @param fallbackColor The color to return if no suitable theme colors are found. Defaults to the primary color of the Material theme.
 * @param filter Whether to filter out undesirable color combinations.
 * @param maxColors The maximum number of colors to extract from the image.
 * @return The most suitable color for a UI theme.
 */
@Stable
@Composable
public fun rememberThemeColor(
  image: ImageBitmap,
  fallbackColor: Color = MaterialTheme.colorScheme.primary,
  filter: Boolean = true,
  maxColors: Int = MAX_COLORS_DEFAULT,
): Color {
  var themeColor by remember { mutableStateOf(fallbackColor) }
  LaunchedEffect(image, fallbackColor, filter, maxColors) {
    themeColor = image.themeColor(fallbackColor, filter, maxColors)
  }

  return themeColor
}
