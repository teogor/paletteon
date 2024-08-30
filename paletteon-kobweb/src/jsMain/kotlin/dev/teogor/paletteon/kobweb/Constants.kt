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

/**
 * Object holding all constants related to Paletteon configuration and color modes.
 */
internal object Constants {
  /**
   * Nested object for external storage-related keys.
   */
  internal object Storage {
    /**
     * Nested object for external keys used for configuration.
     */
    internal object External {
      /** Key for color mode. */
      internal const val COLOR_MODE_KEY: String = "kobweb:colorMode"
    }

    /** Key for seed color. */
    internal const val SEED_COLOR_KEY: String = "paletteon:seedColor"

    /** Key for dark theme preference. */
    internal const val DARK_THEME_KEY: String = "paletteon:darkTheme"

    /** Key for AMOLED theme preference. */
    internal const val AMOLED_KEY: String = "paletteon:amoled"

    /** Key for palette style. */
    internal const val STYLE_KEY: String = "paletteon:style"

    /** Key for contrast setting. */
    internal const val CONTRAST_KEY: String = "paletteon:contrast"

    /** Key for extended fidelity setting. */
    internal const val EXTENDED_FIDELITY_KEY: String = "paletteon:extendedFidelity"

    /** Key for animation setting. */
    internal const val ANIMATE_KEY: String = "paletteon:animate"
  }
}
