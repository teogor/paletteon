/*
 * Copyright 2022 Google LLC
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

package dev.teogor.paletteon.scheme

/**
 * Themes for Dynamic Color.
 */
public enum class Variant {

  /**
   * A monochrome theme, colors are purely black / white / gray.
   */
  MONOCHROME,

  /**
   * A theme that's slightly more chromatic than monochrome, which is purely black / white / gray.
   */
  NEUTRAL,

  /**
   * A calm theme, sedated colors that aren't particularly chromatic.
   */
  TONAL_SPOT,

  /**
   * A loud theme, colorfulness is maximum for Primary palette, increased for others.
   */
  VIBRANT,

  /**
   * A playful theme - the source color's hue does not appear in the theme.
   */
  EXPRESSIVE,

  /**
   * A scheme that places the source color in Scheme.primaryContainer.
   *
   * Primary Container is the source color, adjusted for color relativity. It maintains constant
   * appearance in light mode and dark mode. This adds ~5 tone in light mode, and subtracts ~5 tone in
   * dark mode.
   *
   * Tertiary Container is the complement to the source color, using TemperatureCache. It also
   * maintains constant appearance.
   */
  FIDELITY,

  /**
   * A scheme that places the source color in Scheme.primaryContainer.
   *
   * Primary Container is the source color, adjusted for color relativity. It maintains constant
   * appearance in light mode and dark mode. This adds ~5 tone in light mode, and subtracts ~5 tone in
   * dark mode.
   *
   * Tertiary Container is an analogous color, specifically, the analog of a color wheel divided
   * into 6, and the precise analog is the one found by increasing hue. This is a scientifically
   * grounded equivalent to rotating hue clockwise by 60 degrees. It also maintains constant
   * appearance.
   */
  CONTENT,

  /**
   * A playful theme - the source color's hue does not appear in the theme.
   */
  RAINBOW,

  /**
   * A playful theme - the source color's hue does not appear in the theme.
   */
  FRUIT_SALAD,
}
