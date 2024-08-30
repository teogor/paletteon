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

package dev.teogor.paletteon.internal

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import com.github.ajalt.colormath.model.LABColorSpaces
import com.github.ajalt.colormath.model.RGBColorSpaces
import com.github.ajalt.colormath.model.RGBInt
import com.github.ajalt.colormath.model.SRGB
import com.github.ajalt.colormath.model.XYZColorSpaces

/**
 * Convert this color to a Colormath [Color] instance.
 *
 * ColorMath's Compose extensions don't currently support JS/WASM, so I've copied it here.
 * [See](https://github.com/ajalt/colormath/blob/master/extensions/colormath-ext-jetpack-compose/src/commonMain/kotlin/com/github/ajalt/colormath/extensions/android/composecolor/ComposeColorExtensions.kt).
 */
internal fun Color.toColormathColor(): com.github.ajalt.colormath.Color {
  return when (colorSpace) {
    ColorSpaces.Srgb -> SRGB(red, green, blue, alpha)
    ColorSpaces.Aces -> RGBColorSpaces.ACES(red, green, blue, alpha)
    ColorSpaces.Acescg -> RGBColorSpaces.ACEScg(red, green, blue, alpha)
    ColorSpaces.AdobeRgb -> RGBColorSpaces.AdobeRGB(red, green, blue, alpha)
    ColorSpaces.Bt2020 -> RGBColorSpaces.BT2020(red, green, blue, alpha)
    ColorSpaces.Bt709 -> RGBColorSpaces.BT709(red, green, blue, alpha)
    ColorSpaces.CieLab -> LABColorSpaces.LAB50(red, green, blue, alpha)
    ColorSpaces.CieXyz -> XYZColorSpaces.XYZ50(red, green, blue, alpha)
    ColorSpaces.DciP3 -> RGBColorSpaces.DCI_P3(red, green, blue, alpha)
    ColorSpaces.DisplayP3 -> RGBColorSpaces.DisplayP3(red, green, blue, alpha)
    ColorSpaces.LinearSrgb -> RGBColorSpaces.LinearSRGB(red, green, blue, alpha)
    ColorSpaces.ProPhotoRgb -> RGBColorSpaces.ROMM_RGB(red, green, blue, alpha)
    else -> convert(ColorSpaces.Srgb).let { SRGB(it.red, it.green, it.blue, it.alpha) }
  }
}

/**
 * Convert this color to a Jetpack Compose [Color][androidx.compose.ui.graphics.Color] instance.
 *
 * ColorMath's Compose extensions don't currently support JS/WASM, so I've copied it here.
 * [See](https://github.com/ajalt/colormath/blob/master/extensions/colormath-ext-jetpack-compose/src/commonMain/kotlin/com/github/ajalt/colormath/extensions/android/composecolor/ComposeColorExtensions.kt).
 */
internal fun com.github.ajalt.colormath.Color.toComposeColor(): Color {
  if (this is RGBInt) return Color(argb.toInt())
  val s = when {
    space === SRGB -> ColorSpaces.Srgb
    space === RGBColorSpaces.ACES -> ColorSpaces.Aces
    space === RGBColorSpaces.ACEScg -> ColorSpaces.Acescg
    space === RGBColorSpaces.AdobeRGB -> ColorSpaces.AdobeRgb
    space === RGBColorSpaces.BT2020 -> ColorSpaces.Bt2020
    space === RGBColorSpaces.BT709 -> ColorSpaces.Bt709
    space === LABColorSpaces.LAB50 -> ColorSpaces.CieLab
    space === XYZColorSpaces.XYZ50 -> ColorSpaces.CieXyz
    space === RGBColorSpaces.DCI_P3 -> ColorSpaces.DciP3
    space === RGBColorSpaces.DisplayP3 -> ColorSpaces.DisplayP3
    space === RGBColorSpaces.LinearSRGB -> ColorSpaces.LinearSrgb
    space === RGBColorSpaces.ROMM_RGB -> ColorSpaces.ProPhotoRgb
    else -> null
  }

  return if (s == null) {
    val (r, g, b, a) = toSRGB()
    Color(r, g, b, a)
  } else {
    val (r, g, b, a) = toArray()
    Color(r, g, b, a, s)
  }
}
