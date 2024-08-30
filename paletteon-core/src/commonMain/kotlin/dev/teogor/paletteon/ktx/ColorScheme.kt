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
import androidx.compose.material3.LocalTonalElevationEnabled
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

/**
 * Computes the surface color at a given elevation using the current [MaterialTheme]'s color scheme.
 *
 * This function adjusts the color based on the elevation provided, applying tonal elevation
 * if enabled in the [MaterialTheme].
 *
 * @param color The base [Color] to adjust based on elevation.
 * @param elevation The [Dp] value representing the elevation for the surface.
 * @return A [Color] that represents the surface color at the given elevation.
 */
@Composable
public fun surfaceColorAtElevation(
  color: Color,
  elevation: Dp
): Color = MaterialTheme.colorScheme.applyTonalElevation(color, elevation)

/**
 * Applies tonal elevation to a background color based on the current [ColorScheme] and elevation.
 *
 * This function checks if tonal elevation is enabled and, if so, computes the surface color at the
 * given elevation. If tonal elevation is not enabled or the background color is the same as the surface
 * color, it returns the original background color.
 *
 * @param backgroundColor The [Color] to adjust based on elevation.
 * @param elevation The [Dp] value representing the elevation for the surface.
 * @return A [Color] that represents the adjusted color at the given elevation.
 */
@Composable
@ReadOnlyComposable
public fun ColorScheme.applyTonalElevation(
  backgroundColor: Color,
  elevation: Dp
): Color {
  val tonalElevationEnabled = LocalTonalElevationEnabled.current
  return if (backgroundColor == surface && tonalElevationEnabled) {
    surfaceColorAtElevation(elevation)
  } else {
    backgroundColor
  }
}
