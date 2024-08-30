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
import dev.teogor.paletteon.hct.Hct

/**
 * Converts a [Color] from Compose to its HCT (Hue, Chroma, Tone) representation.
 *
 * @param color The [Color] to convert.
 * @return The [Hct] representation of the specified color.
 */
public fun Hct.Companion.from(color: Color): Hct {
  return fromInt(color.toArgb())
}

/**
 * Converts an [Hct] value to a Compose [Color].
 *
 * @receiver The [Hct] value to convert.
 * @return The Compose [Color] representation of the [Hct] value.
 */
@Stable
public fun Hct.toColor(): Color {
  return Color(toInt())
}

/**
 * Converts a list of [Hct] values to a list of Compose [Color] values.
 *
 * @receiver The list of [Hct] values to convert.
 * @return A list of Compose [Color] values representing the given [Hct] values.
 */
@Stable
public fun List<Hct>.toColors(): List<Color> {
  return map { it.toColor() }
}

/**
 * Converts a Compose [Color] to its HCT (Hue, Chroma, Tone) representation.
 *
 * @receiver The [Color] to convert.
 * @return The [Hct] representation of the specified color.
 */
public fun Color.toHct(): Hct {
  return Hct.from(this)
}

/**
 * Converts a list of Compose [Color] values to a list of HCT (Hue, Chroma, Tone) values.
 *
 * @receiver The list of [Color] values to convert.
 * @return A list of [Hct] values representing the given [Color] values.
 */
public fun List<Color>.toHcts(): List<Hct> {
  return map { it.toHct() }
}
