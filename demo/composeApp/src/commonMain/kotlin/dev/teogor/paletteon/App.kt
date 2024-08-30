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

package dev.teogor.paletteon

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.runtime.Composable
import dev.teogor.paletteon.ui.components.PaletteonThemedSurface
import dev.teogor.paletteon.ui.simulation.StandardColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
public fun App(
  insets: WindowInsets = WindowInsets.ime,
) {
  PaletteonDynamicTheme(
    seedColor = StandardColors.first().color,
    useDarkTheme = isSystemInDarkTheme(),
    animate = true,
  ) {
    PaletteonThemedSurface {
      ShowcaseScreen(
        insets = insets,
      )
    }
  }
}
