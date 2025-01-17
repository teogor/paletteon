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

package dev.teogor.paletteon.kobweb.ui.icons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGSvgAttrsScope
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.teogor.paletteon.kobweb.ui.color.asRgba

@Composable
public fun DarkModeSvg(
  tint: Color,
  modifier: Modifier = Modifier
) {
  // Caching the SVG path and attributes
  val svgAttrs = remember(tint) {
    modifier.toAttrs<SVGSvgAttrsScope> {
      width(24)
      height(24)
      viewBox(0, 0, 24, 24)
      fill(tint.asRgba())
    }
  }

  // Using the cached attributes for the Svg component
  Svg(attrs = svgAttrs) {
    Path {
      d {
        moveTo(8.2305f, 2.2422f)
        curveTo(9.2422f, 1.7852f, 10.1211f, 2.8125f, 9.8047f, 3.6992f)
        curveTo(8.7305f, 6.7188f, 9.3906f, 10.1484f, 11.6211f, 12.375f)
        curveTo(13.8594f, 14.6172f, 17.3125f, 15.2773f, 20.3398f, 14.1836f)
        curveTo(21.2188f, 13.8633f, 22.2188f, 14.7305f, 21.7813f, 15.7188f)
        curveTo(21.7695f, 15.75f, 21.7539f, 15.7773f, 21.7422f, 15.8086f)
        curveTo(20.9688f, 17.5273f, 19.7266f, 19.1445f, 18.1211f, 20.2266f)
        curveTo(16.4141f, 21.3828f, 14.3945f, 22.0f, 12.332f, 22.0f)
        curveTo(9.9297f, 21.9961f, 7.6055f, 21.1602f, 5.7539f, 19.6328f)
        curveTo(3.9063f, 18.1055f, 2.6445f, 15.9805f, 2.1875f, 13.625f)
        curveTo(1.7305f, 11.2695f, 2.1094f, 8.8281f, 3.2578f, 6.7188f)
        curveTo(4.3477f, 4.7227f, 6.1758f, 3.168f, 8.2031f, 2.2539f)
        closePath()
        moveTo(8.2305f, 2.2422f)
      }
    }
  }
}
