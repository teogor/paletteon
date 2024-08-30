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
import dev.teogor.paletteon.dynamiccolor.DynamicColor
import dev.teogor.paletteon.scheme.DynamicScheme

/**
 * Retrieves the [Color] that corresponds to this [DynamicColor] based on the provided [DynamicScheme].
 *
 * This function returns a [Color] that reflects how this dynamic color should appear according to the
 * given scheme, which specifies user interface conditions such as dark mode, light mode, or desired
 * contrast levels.
 *
 * @param dynamicScheme The [DynamicScheme] that defines the user interface conditions, including
 *                      whether the mode is dark or light, and the desired contrast level.
 * @return The [Color] that represents this [DynamicColor] as specified by the [dynamicScheme].
 */
public fun DynamicColor.getColor(dynamicScheme: DynamicScheme): Color {
  return Color(getArgb(dynamicScheme))
}
