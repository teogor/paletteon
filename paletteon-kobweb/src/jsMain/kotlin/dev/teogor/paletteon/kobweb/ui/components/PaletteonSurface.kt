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

package dev.teogor.paletteon.kobweb.ui.components

import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.components.layout.Surface
import dev.teogor.paletteon.kobweb.ui.color.asRgba
import org.jetbrains.compose.web.css.vh

/**
 * A customizable surface component that applies a background color and content color to a [Surface] element.
 * This composable is designed to provide a consistent and flexible surface style with options for background
 * color, content color, and layout modifiers.
 *
 * @param modifier Modifier to be applied to the [Surface]. By default, it fills the maximum width and has a minimum
 *                 height of 100 viewport height units.
 * @param color Background color of the surface. Defaults to [Color.Unspecified], which will use a transparent background.
 * @param contentColor Color for the content inside the surface. Defaults to a color calculated to ensure good
 *                     contrast against the background color, using [contentColorFor].
 * @param content Composable lambda that represents the content to be displayed inside the surface. The lambda is
 *                applied in the context of [BoxScope].
 */
@Composable
public fun PaletteonSurface(
  modifier: Modifier = Modifier.fillMaxWidth().minHeight(100.vh),
  color: Color = Color.Unspecified,
  contentColor: Color = contentColorFor(color),
  content: @Composable BoxScope.() -> Unit
) {
  Surface(
    modifier = modifier.then(
      Modifier
        .background(color.asRgba())
        .color(contentColor.asRgba())
    ),
    content = content,
  )
}
