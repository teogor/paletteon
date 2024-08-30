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

package dev.teogor.paletteon.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * Applies the theme and configures the Surface component according to the provided parameters.
 *
 * @param shape The shape of the Surface.
 * @param color The background color of the Surface.
 * @param contentColor The content color to be used on the Surface.
 * @param tonalElevation The tonal elevation of the Surface.
 * @param shadowElevation The shadow elevation of the Surface.
 * @param border The border of the Surface.
 * @param content The content to be placed inside the Surface.
 */
@Composable
public fun PaletteonThemedSurface(
  modifier: Modifier = Modifier,
  shape: Shape = RectangleShape,
  color: Color = MaterialTheme.colorScheme.surface,
  contentColor: Color = contentColorFor(color),
  tonalElevation: Dp = 0.dp,
  shadowElevation: Dp = 0.dp,
  border: BorderStroke? = null,
  content: @Composable () -> Unit
) {
  // Configure and display the Surface
  Surface(
    modifier = modifier,
    shape = shape,
    color = color,
    contentColor = contentColor,
    tonalElevation = tonalElevation,
    shadowElevation = shadowElevation,
    border = border,
    content = content,
  )
}
