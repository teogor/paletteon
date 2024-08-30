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
import dev.teogor.paletteon.palettes.CorePalette

/**
 * Generates a set of key tones from the specified color.
 *
 * This function creates a [CorePalette] based on the provided color, which includes key tones
 * used for designing color palettes. The key tones are derived from the color's ARGB representation.
 *
 * @param baseColor The [Color] from which to generate key tones.
 * @return A [CorePalette] object containing the key tones derived from the specified color.
 */
public fun CorePalette.Companion.of(baseColor: Color): CorePalette = of(baseColor.toArgb())

/**
 * Generates a set of key tones from the specified color.
 *
 * This function creates a [CorePalette] based on the provided color, including key tones for use
 * in color palette design. This is an alias for [of].
 *
 * @param baseColor The [Color] from which to create key tones.
 * @return A [CorePalette] object containing the key tones derived from the specified color.
 */
public fun CorePalette.Companion.from(baseColor: Color): CorePalette = of(baseColor)

/**
 * Generates a set of content key tones from the specified color.
 *
 * This function creates a [CorePalette] with content-specific key tones derived from the provided
 * color. Content key tones are used for designing content areas and are based on the color's ARGB
 * representation.
 *
 * @param contentColor The [Color] from which to create content key tones.
 * @return A [CorePalette] object containing content key tones derived from the specified color.
 */
public fun CorePalette.Companion.contentOf(contentColor: Color): CorePalette = contentOf(contentColor.toArgb())
