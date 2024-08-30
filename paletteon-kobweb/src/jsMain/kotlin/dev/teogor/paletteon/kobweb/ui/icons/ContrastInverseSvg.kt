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
public fun ContrastInverseSvg(
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
        moveTo(12.0f, 0.0f)
        curveTo(18.6289f, 0.0f, 24.0f, 5.3711f, 24.0f, 12.0f)
        curveTo(24.0f, 18.6289f, 18.6289f, 24.0f, 12.0f, 24.0f)
        curveTo(5.3711f, 24.0f, 0.0f, 18.6289f, 0.0f, 12.0f)
        curveTo(0.0f, 5.3711f, 5.3711f, 0.0f, 12.0f, 0.0f)
        closePath()
        moveTo(12.0f, 22.0f)
        lineTo(12.0f, 2.0f)
        curveTo(6.4766f, 2.0f, 2.0f, 6.4766f, 2.0f, 12.0f)
        curveTo(2.0f, 17.5234f, 6.4766f, 22.0f, 12.0f, 22.0f)
        closePath()
        moveTo(12.0f, 22.0f)
      }
    }
  }
}
