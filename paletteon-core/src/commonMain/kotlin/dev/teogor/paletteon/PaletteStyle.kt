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

import dev.teogor.paletteon.scheme.Variant

/**
 * Represents different styles for generating color palettes,
 * aligned with [Variant] in the Material Design guidelines.
 *
 * Each style defines a unique approach to how colors are chosen and combined,
 * ranging from subtle to vibrant, playful, or monochromatic themes.
 */
public enum class PaletteStyle {

  /**
   * A calm theme with subdued colors that are not overly chromatic.
   * Ideal for designs that require a more muted and relaxed color palette.
   */
  TonalSpot,

  /**
   * A theme with slightly more chromatic intensity than pure monochrome,
   * featuring a balanced mix of neutral tones. Suitable for designs
   * that aim for a minimalist yet colorful appearance.
   */
  Neutral,

  /**
   * A vibrant theme where colorfulness is at its peak, especially for the primary palette.
   * Other palettes also feature enhanced chromatic intensity, making this theme
   * perfect for lively and dynamic designs.
   */
  Vibrant,

  /**
   * A playful theme where the source color's hue is intentionally omitted from the palette.
   * This creates a unique and unexpected color scheme, adding an element of surprise
   * to the design. Suitable for creative and non-traditional color schemes.
   */
  Expressive,

  /**
   * A playful and colorful theme similar to [Expressive], where the source color's hue
   * is excluded, leading to a diverse and lively palette. Ideal for designs
   * that aim to be bold and eye-catching.
   */
  Rainbow,

  /**
   * Another playful theme where the source color's hue is excluded, resulting in
   * a palette reminiscent of a colorful fruit salad. This theme is perfect for
   * fun, vibrant designs that want to evoke a sense of joy and energy.
   */
  FruitSalad,

  /**
   * A monochrome theme where colors are purely black, white, and shades of gray.
   * This style is ideal for designs that require a classic, timeless look with no chromatic distractions.
   */
  Monochrome,

  /**
   * A scheme where the source color is placed in the `primaryContainer`.
   *
   * - **Primary Container**: The source color, adjusted for color relativity,
   *   maintaining a consistent appearance across light and dark modes.
   * - **Tertiary Container**: The complementary color, calculated using `TemperatureCache`,
   *   also maintaining a consistent appearance across different modes.
   *
   * This theme is suitable for designs that require harmony and consistency in color presentation.
   */
  Fidelity,

  /**
   * Similar to [Fidelity], but with a slight variation:
   *
   * - **Primary Container**: The source color, adjusted for color relativity,
   *   maintaining a consistent appearance across light and dark modes.
   * - **Tertiary Container**: An analogous color, derived by increasing the hue,
   *   ensuring a scientifically grounded color relationship.
   *
   * This theme is ideal for designs that seek a coherent yet varied color scheme,
   * maintaining a balance between primary and analogous colors.
   */
  Content,
}
