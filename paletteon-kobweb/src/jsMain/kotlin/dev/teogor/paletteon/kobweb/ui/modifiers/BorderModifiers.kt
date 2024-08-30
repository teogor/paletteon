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
import com.varabyte.kobweb.compose.css.CSSLengthNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import dev.teogor.paletteon.kobweb.ui.color.asRgba
import org.jetbrains.compose.web.css.CSSLengthValue
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.border

public fun Modifier.border(
  width: CSSLengthNumericValue? = null,
  style: LineStyle? = null,
  color: Color? = null
): Modifier = styleModifier {
  border(width.unsafeCast<CSSLengthValue>(), style, color?.asRgba())
}
