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

package dev.teogor.paletteon.kobweb.internal

import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.teogor.paletteon.kobweb.Constants
import kotlinx.browser.localStorage

/**
 * Retrieves the color mode from local storage. Returns a default value if not found or invalid.
 *
 * @param defaultColorMode The default [ColorMode] to return if no value is found or if the stored value is invalid.
 * @return The retrieved or default [ColorMode].
 */
internal fun getColorModeFromLocalStorage(defaultColorMode: ColorMode = ColorMode.DARK): ColorMode {
  return localStorage.getItem(Constants.Storage.External.COLOR_MODE_KEY)?.let {
    ColorMode.valueOf(it)
  } ?: defaultColorMode
}

/**
 * Saves the color mode to local storage.
 *
 * @param colorMode The [ColorMode] to save.
 */
internal fun saveColorMode(colorMode: ColorMode) {
  localStorage.setItem(
    Constants.Storage.External.COLOR_MODE_KEY,
    colorMode.name
  )
}
