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

package dev.teogor.paletteon.kobweb.ui.modifiers

import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.background
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import dev.teogor.paletteon.kobweb.ui.color.asRgba
import org.jetbrains.compose.web.css.backgroundColor

/**
 * Sets the background color and other background properties.
 *
 * @param color The color to be used as the background color, converted to RGBA.
 * @param backgrounds Other background properties to be applied.
 */
public fun Modifier.background(
  color: Color?,
  vararg backgrounds: Background.Repeatable
): Modifier = styleModifier {
  background(color?.asRgba(), *backgrounds)
}

/**
 * Sets the background color of the modifier.
 *
 * @param color The color to be used as the background color, converted to RGBA.
 * @return A [Modifier] with the specified background color.
 */
public fun Modifier.backgroundColor(color: Color): Modifier = styleModifier {
  backgroundColor(color.asRgba())
}
