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
import dev.teogor.paletteon.hct.Hct
import dev.teogor.paletteon.palettes.TonalPalette

/**
 * Creates a [TonalPalette] based on the provided [Color].
 *
 * This function generates a tonal palette that is derived from the given color.
 *
 * @param color The [Color] from which to generate the [TonalPalette].
 * @return The generated [TonalPalette] derived from the specified color.
 */
public fun TonalPalette.Companion.from(color: Color): TonalPalette {
  return from(color.toArgb())
}

/**
 * Creates a [TonalPalette] based on the provided ARGB color integer.
 *
 * This function generates a tonal palette using the ARGB color integer value.
 *
 * @param argb The ARGB integer representation of the color to create the [TonalPalette].
 * @return The generated [TonalPalette] derived from the specified ARGB value.
 */
public fun TonalPalette.Companion.from(argb: Int): TonalPalette {
  return fromInt(argb)
}

/**
 * Creates a [TonalPalette] based on the provided [Hct] color representation.
 *
 * This function generates a tonal palette using the HCT (Hue, Chroma, Tone) color model.
 *
 * @param hct The [Hct] color representation to generate the [TonalPalette] from.
 * @return The generated [TonalPalette] derived from the specified HCT color model.
 */
public fun TonalPalette.Companion.from(hct: Hct): TonalPalette {
  return fromHct(hct)
}
