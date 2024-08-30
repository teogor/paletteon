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

@file:Suppress("UnusedReceiverParameter")

package dev.teogor.paletteon

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import dev.teogor.paletteon.dynamiccolor.DynamicColor
import dev.teogor.paletteon.dynamiccolor.MaterialDynamicColors

/**
 * Remembers and returns a [Color] associated with a specific [DynamicColor] role.
 *
 * @param colorRole The color role to retrieve from the [MaterialDynamicColors].
 * @return The [Color] associated with the provided [DynamicColor] role.
 */
@Composable
public fun rememberColorForRole(
  colorRole: MaterialDynamicColors.() -> DynamicColor
): Color {
  val state = PaletteonTheme.current
  return remember(state) {
    state.getColor { colorRole() }
  }
}

/**
 * Returns the success color from the current [ColorScheme].
 *
 * This color is remembered across recompositions.
 */
public val ColorScheme.success: Color
  @Composable
  get() = rememberColorForRole { success() }

/**
 * Returns the on-success color from the current [ColorScheme].
 *
 * This color is remembered across recompositions.
 */
public val ColorScheme.onSuccess: Color
  @Composable
  get() = rememberColorForRole { onSuccess() }

/**
 * Returns the success container color from the current [ColorScheme].
 *
 * This color is remembered across recompositions.
 */
public val ColorScheme.successContainer: Color
  @Composable
  get() = rememberColorForRole { successContainer() }

/**
 * Returns the on-success container color from the current [ColorScheme].
 *
 * This color is remembered across recompositions.
 */
public val ColorScheme.onSuccessContainer: Color
  @Composable
  get() = rememberColorForRole { onSuccessContainer() }

/**
 * Returns the warning color from the current [ColorScheme].
 *
 * This color is remembered across recompositions.
 */
public val ColorScheme.warning: Color
  @Composable
  get() = rememberColorForRole { warning() }

/**
 * Returns the on-warning color from the current [ColorScheme].
 *
 * This color is remembered across recompositions.
 */
public val ColorScheme.onWarning: Color
  @Composable
  get() = rememberColorForRole { onWarning() }

/**
 * Returns the warning container color from the current [ColorScheme].
 *
 * This color is remembered across recompositions.
 */
public val ColorScheme.warningContainer: Color
  @Composable
  get() = rememberColorForRole { warningContainer() }

/**
 * Returns the on-warning container color from the current [ColorScheme].
 *
 * This color is remembered across recompositions.
 */
public val ColorScheme.onWarningContainer: Color
  @Composable
  get() = rememberColorForRole { onWarningContainer() }
