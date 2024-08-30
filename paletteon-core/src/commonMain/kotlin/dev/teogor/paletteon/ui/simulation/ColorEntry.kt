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

package dev.teogor.paletteon.ui.simulation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

public open class ColorEntry(
  public open val name: String,
  public open val color: Color,
) {
  public fun copy(name: String = this.name, color: Color = this.color): ColorEntry {
    return ColorEntry(name, color)
  }
  override fun toString(): String {
    return "ColorEntry(name='$name', color=$color)"
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is ColorEntry) return false
    return name == other.name && color == other.color
  }

  // Generates a hash code for the ColorEntry instance
  override fun hashCode(): Int {
    var hashCode = name.hashCode()
    hashCode = 31 * hashCode + color.hashCode()
    return hashCode
  }
}

public class CustomColor(
  override val name: String,
  override var color: Color
) : ColorEntry(name, color) {
  override fun toString(): String {
    return "CustomColor(name='$name', color=$color)"
  }
}

public class DynamicColor(
  override val name: String,
  override var color: Color,
) : ColorEntry(name, color) {
  override fun toString(): String {
    return "DynamicColor(name='$name', color=$color)"
  }
}

public val StandardColors: List<ColorEntry> = listOf(
  ColorEntry("Crimson Red", Color(0xFFD32F2F)),
  ColorEntry("Raspberry Pink", Color(0xFFC2185B)),
  ColorEntry("Royal Purple", Color(0xFF7B1FA2)),
  ColorEntry("Midnight Purple", Color(0xFF512DA8)),
  ColorEntry("Deep Indigo", Color(0xFF303F9F)),
  ColorEntry("Sky Blue", Color(0xFF1976D2)),
  ColorEntry("Ocean Blue", Color(0xFF0288D1)),
  ColorEntry("Turquoise Cyan", Color(0xFF0097A7)),
  ColorEntry("Jade Teal", Color(0xFF00796B)),
  ColorEntry("Forest Green", Color(0xFF388E3C)),
  ColorEntry("Moss Green", Color(0xFF689F38)),
  ColorEntry("Lemon Lime", Color(0xFFAFB42B)),
  ColorEntry("Sunshine Yellow", Color(0xFFFBC02D)),
  ColorEntry("Golden Amber", Color(0xFFFFA000)),
  ColorEntry("Sunset Orange", Color(0xFFF57C00)),
  ColorEntry("Blazing Orange", Color(0xFFE64A19)),
  ColorEntry("Earth Brown", Color(0xFF5D4037)),
  ColorEntry("Slate Grey", Color(0xFF616161)),
  ColorEntry("Steel Blue Grey", Color(0xFF455A64)),
  ColorEntry("Charcoal Black", Color(0xFF263238)),
)

public class ColorPalette(
  initialEntries: List<ColorEntry> = emptyList()
) : Collection<ColorEntry> {

  private val colorEntries: MutableList<ColorEntry> = initialEntries.toMutableList()

  public fun addCustomColor(customColor: CustomColor) {
    colorEntries.add(customColor)
  }

  public fun addDynamicColor(dynamicColor: DynamicColor) {
    colorEntries.add(dynamicColor)
  }

  public fun removeCustomColor() {
    colorEntries.removeAll { it is CustomColor }
  }

  public fun removeCustomColor(customColor: CustomColor) {
    colorEntries.remove(customColor)
  }

  public fun removeDynamicColor() {
    colorEntries.removeAll { it is DynamicColor }
  }

  public fun removeDynamicColor(dynamicColor: DynamicColor) {
    colorEntries.remove(dynamicColor)
  }

  override val size: Int
    get() = colorEntries.size

  override fun contains(element: ColorEntry): Boolean {
    return colorEntries.contains(element)
  }

  override fun containsAll(elements: Collection<ColorEntry>): Boolean {
    return colorEntries.containsAll(elements)
  }

  override fun isEmpty(): Boolean {
    return colorEntries.isEmpty()
  }

  override fun iterator(): Iterator<ColorEntry> {
    return colorEntries.iterator()
  }

  public fun toList(): List<ColorEntry> {
    return colorEntries.toList()
  }

  override fun toString(): String {
    return "ColorPalette(colorEntries=$colorEntries)"
  }
}

@Composable
public fun CorePalette() : ColorPalette {
  return remember {
    ColorPalette(
      initialEntries = StandardColors,
    )
  }
}
