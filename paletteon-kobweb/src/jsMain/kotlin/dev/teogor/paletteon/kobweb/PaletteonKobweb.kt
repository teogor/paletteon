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

package dev.teogor.paletteon.kobweb

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.teogor.paletteon.kobweb.internal.saveColorMode

/**
 * A Composable provider for managing the Paletteon theme and color mode within a Kobweb application.
 *
 * This provider observes changes to the current Paletteon theme and updates the color mode accordingly.
 * It ensures that the color mode (light or dark) is synchronized with the theme configuration and saved
 * to local storage. This is useful for maintaining consistent theming across your application.
 *
 * @param content The composable content to be displayed within the provider. This function will be
 *                provided with the updated theme and color mode settings.
 */
@Composable
public fun PaletteonKobwebProvider(
  content: @Composable () -> Unit
) {
  val paletteonTheme = PaletteonTheme.current
  var colorMode by ColorMode.currentState
  LaunchedEffect(paletteonTheme) {
    savePaletteonTheme(paletteonTheme)
    colorMode = if (paletteonTheme.useDarkTheme) {
      ColorMode.DARK
    } else {
      ColorMode.LIGHT
    }.also {
      saveColorMode(it)
    }
  }

  content()
}
