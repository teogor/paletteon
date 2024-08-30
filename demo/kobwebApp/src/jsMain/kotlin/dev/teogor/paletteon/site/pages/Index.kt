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

package dev.teogor.paletteon.site.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import dev.teogor.paletteon.kobweb.PaletteonTheme
import dev.teogor.paletteon.kobweb.ui.modifiers.background
import dev.teogor.paletteon.kobweb.ui.modifiers.border
import dev.teogor.paletteon.site.components.layouts.PageLayout
import dev.teogor.paletteon.site.components.models.NamedColor
import dev.teogor.paletteon.site.components.models.SampleColors
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
  var paletteonTheme by PaletteonTheme.currentState
  var selectedColor by remember { mutableStateOf(paletteonTheme.seedColor) }

  PageLayout("Home") {
    Column(
      Modifier.width(100.percent),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Box(
        modifier = Modifier.width(100.percent).padding(16.px),
        contentAlignment = Alignment.Center
      ) {
        ColorPicker(
          colors = SampleColors,
          selectedColor = selectedColor,
          onColorSelected = { color ->
            println("On Color Selected: $color")
            paletteonTheme = paletteonTheme.copy(
              seedColor = color.color
            )
          }
        )
      }
    }
  }
}

@Composable
fun ColorPicker(
  colors: List<NamedColor>,
  selectedColor: Color,
  onColorSelected: (NamedColor) -> Unit
) {
  Row(
    modifier = Modifier
      .padding(8.px)
  ) {
    colors.forEach { item ->
      val color = item.color
      Box(
        modifier = Modifier
          .padding(4.px)
          .size(50.px)
          .padding(4.px)
          .background(color)
          .apply {
            if (color == selectedColor) {
              border(
                width = 10.px,
                color = Color.Red,
              )
              padding(4.px)
            }
          }
          .onClick {
            onColorSelected(item)
          }
      )
    }
  }
}
