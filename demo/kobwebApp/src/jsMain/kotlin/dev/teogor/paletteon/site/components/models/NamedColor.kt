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

package dev.teogor.paletteon.site.components.models

import androidx.compose.ui.graphics.Color

public data class NamedColor(val name: String, val color: Color)

public val SampleColors: List<NamedColor> = listOf(
  NamedColor("Red", Color(0xFFD32F2F)),
  NamedColor("Pink", Color(0xFFC2185B)),
  NamedColor("Purple", Color(0xFF7B1FA2)),
  NamedColor("Deep Purple", Color(0xFF512DA8)),
  NamedColor("Indigo", Color(0xFF303F9F)),
  NamedColor("Blue", Color(0xFF1976D2)),
  NamedColor("Light Blue", Color(0xFF0288D1)),
  NamedColor("Cyan", Color(0xFF0097A7)),
  NamedColor("Teal", Color(0xFF00796B)),
  NamedColor("Green", Color(0xFF388E3C)),
  NamedColor("Light Green", Color(0xFF689F38)),
  NamedColor("Lime", Color(0xFFAFB42B)),
  NamedColor("Yellow", Color(0xFFFBC02D)),
  NamedColor("Amber", Color(0xFFFFA000)),
  NamedColor("Orange", Color(0xFFF57C00)),
  NamedColor("Deep Orange", Color(0xFFE64A19)),
  NamedColor("Brown", Color(0xFF5D4037)),
  NamedColor("Grey", Color(0xFF616161)),
  NamedColor("Blue Grey", Color(0xFF455A64)),
  NamedColor("Charcoal", Color(0xFF263238)),
)
