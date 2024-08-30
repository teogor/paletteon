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

package dev.teogor.paletteon.ktx

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import dev.teogor.paletteon.contrast.Contrast
import dev.teogor.paletteon.utils.ColorUtils

/**
 * Calculates the contrast ratio between two colors.
 *
 * The contrast ratio is a measure of legibility, comparing the lightness of two colors.
 * It is used widely in the industry due to its compliance with WCAG (Web Content Accessibility Guidelines).
 * Colors are represented in the XYZ color space, where Y represents lightness (relative luminance).
 * The contrast ratio is calculated using the formula: `ratio = (lighter Y + 5) / (darker Y + 5)`.
 *
 * WCAG 2.0 requires a minimum contrast ratio of 4.5:1 for normal text and 3:1 for large text.
 * WCAG 2.1 requires a minimum of 3:1 for graphics and UI components. WCAG Level AAA requires
 * 7:1 for normal text and 4.5:1 for large text.
 *
 * @receiver The first [Color] to compare.
 * @param other The second [Color] to compare.
 * @return The contrast ratio between the two colors.
 */
public fun Color.calculateContrastRatio(other: Color): Double {
  val firstColorLuminance = ColorUtils.xyzFromArgb(toArgb())[1]
  val secondColorLuminance = ColorUtils.xyzFromArgb(other.toArgb())[1]
  return Contrast.ratioOfYs(firstColorLuminance, secondColorLuminance)
}

/**
 * Computes the contrast ratio of the tonal values between two colors.
 *
 * Tonal contrast ratio is based on perceptual luminance values (T in HCT, L* in L*a*b*).
 * It is more aligned with human perception of lightness compared to the XYZ color space.
 * This allows designers to assess contrast using perceptually accurate color spaces and make
 * adjustments more intuitively, based on linear differences rather than ratios.
 *
 * @receiver The first [Color] to compare.
 * @param other The second [Color] to compare.
 * @return The tonal contrast ratio between the two colors, using perceptual luminance.
 */
public fun Color.calculateTonalContrastRatio(other: Color): Double {
  val firstTonalValue = toHct().tone
  val secondTonalValue = other.toHct().tone
  return Contrast.ratioOfTones(firstTonalValue, secondTonalValue)
}

/**
 * Determines if the contrast ratio between two colors meets or exceeds a specified threshold.
 *
 * For more details on WCAG guidelines, visit [WCAG Guidelines](https://www.w3.org/WAI/standards-guidelines/wcag).
 *
 * @receiver The first [Color] to compare.
 * @param other The second [Color] to compare.
 * @param threshold The contrast ratio threshold to compare against.
 * @return `true` if the contrast ratio is greater than or equal to the threshold, `false` otherwise.
 */
public fun Color.hasSufficientContrast(
  other: Color,
  threshold: ContrastThreshold = ContrastThreshold.WCAG_AA_NORMAL_TEXT
): Boolean = calculateContrastRatio(other) >= threshold.value

/**
 * Represents the threshold values for contrast ratio compliance.
 *
 * These thresholds are based on WCAG guidelines and are used to evaluate the contrast ratio
 * between colors to ensure accessibility.
 *
 * For more information, refer to [WCAG Guidelines](https://www.w3.org/WAI/standards-guidelines/wcag).
 */
public enum class ContrastThreshold(public val value: Double) {
  WCAG_AA_NORMAL_TEXT(4.5),
  WCAG_AA_LARGE_TEXT(3.0),
  WCAG_AAA_NORMAL_TEXT(7.0),
  WCAG_AAA_LARGE_TEXT(4.5);

  public operator fun compareTo(value: Double): Int = this.value.compareTo(value)
}

private operator fun Double.compareTo(threshold: ContrastThreshold): Int {
  return compareTo(threshold.value)
}
