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

import dev.teogor.paletteon.hct.Hct
import dev.teogor.paletteon.palettes.TonalPalette
import dev.teogor.paletteon.temperature.TemperatureCache
import kotlin.math.max

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
public class SchemeFidelity(
  sourceColorHct: Hct,
  isDark: Boolean,
  contrastLevel: Double,
) : DynamicScheme(
  sourceColorHct = sourceColorHct,
  variant = Variant.FIDELITY,
  isDark = isDark,
  contrastLevel = contrastLevel,
  primaryPalette = TonalPalette.fromHueAndChroma(
    hue = sourceColorHct.hue,
    chroma = sourceColorHct.chroma,
  ),
  secondaryPalette = TonalPalette.fromHueAndChroma(
    hue = sourceColorHct.hue,
    chroma = max(sourceColorHct.chroma - 32.0, sourceColorHct.chroma * 0.5),
  ),
  tertiaryPalette = TonalPalette.fromHct(
    hct = dev.teogor.paletteon.dislike.DislikeAnalyzer.fixIfDisliked(TemperatureCache(sourceColorHct).complement),
  ),
  neutralPalette = TonalPalette.fromHueAndChroma(
    hue = sourceColorHct.hue,
    chroma = sourceColorHct.chroma / 8.0,
  ),
  neutralVariantPalette = TonalPalette.fromHueAndChroma(
    hue = sourceColorHct.hue,
    chroma = sourceColorHct.chroma / 8.0 + 4.0,
  ),
)
