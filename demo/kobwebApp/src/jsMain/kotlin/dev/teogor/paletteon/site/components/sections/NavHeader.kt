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

package dev.teogor.paletteon.site.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.accentColor
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import dev.teogor.paletteon.kobweb.PaletteonTheme
import dev.teogor.paletteon.kobweb.ui.color.asRgba
import dev.teogor.paletteon.kobweb.ui.icons.ContrastInverseSvg
import dev.teogor.paletteon.kobweb.ui.icons.ContrastSvg
import dev.teogor.paletteon.kobweb.ui.icons.DarkModeSvg
import dev.teogor.paletteon.kobweb.ui.icons.LightModeSvg
import dev.teogor.paletteon.kobweb.ui.modifiers.background
import dev.teogor.paletteon.kobweb.ui.modifiers.backgroundColor
import dev.teogor.paletteon.site.components.style.boxShadow
import dev.teogor.paletteon.site.components.widgets.ButtonShape
import dev.teogor.paletteon.site.components.widgets.ThemedButton
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import kotlin.random.Random

val NavHeaderStyle = CssStyle {
  base {
    Modifier
      .fillMaxWidth()
      .position(Position.Sticky)
      .top(0.percent)
      .backdropFilter(saturate(180.percent), blur(5.px))
      .boxShadow(colorMode)
  }
}

@Composable
private fun HomeLogo() {
  Anchor(
    href = "/",
  ) {
    Box(Modifier.margin(4.px)) {
      Img(
        "images/logo.png",
        attrs = Modifier.height(32.px).toAttrs()
      )
    }
  }
}

private val BUTTON_MARGIN = Modifier.margin(0.px, 10.px)

@Composable
fun NavHeader() {
  var paletteonTheme by PaletteonTheme.currentState
  Box(
    modifier = NavHeaderStyle.toModifier()
      .backgroundColor(paletteonTheme.colorScheme.background.copy(alpha = .65f)),
    contentAlignment = Alignment.Center
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(90.percent).margin(1.em),
      verticalAlignment = Alignment.CenterVertically
    ) {
      HomeLogo()
      Spacer()
      Row(
        modifier = Modifier.margin(0.px, 12.px),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        if (paletteonTheme.useDarkTheme) {
          val modifier = Modifier
            .margin(0.px, 10.px)
            .onClick {
              paletteonTheme = paletteonTheme.copy(
                withAmoled = !paletteonTheme.withAmoled,
              )
            }
            .size(30.px)
            .color(paletteonTheme.colorScheme.onBackground.asRgba())
            .accentColor(paletteonTheme.colorScheme.onBackground.asRgba())
            .background(paletteonTheme.colorScheme.background)
          if (paletteonTheme.withAmoled) {
            ContrastSvg(paletteonTheme.colorScheme.onBackground, modifier)
          } else {
            ContrastInverseSvg(paletteonTheme.colorScheme.onBackground, modifier)
          }
        }
        val modifier = Modifier
          .margin(0.px, 10.px)
          .onClick {
            paletteonTheme = paletteonTheme.copy(
              useDarkTheme = !paletteonTheme.useDarkTheme,
            )
          }
          .size(30.px)
          .color(paletteonTheme.colorScheme.onBackground.asRgba())
          .accentColor(paletteonTheme.colorScheme.onBackground.asRgba())
          .background(paletteonTheme.colorScheme.background)
        if (paletteonTheme.useDarkTheme) {
          LightModeSvg(paletteonTheme.colorScheme.onBackground, modifier)
        } else {
          DarkModeSvg(paletteonTheme.colorScheme.onBackground, modifier)
        }
        ThemedButton(
          onClick = {
            paletteonTheme = paletteonTheme.copy(
              useDarkTheme = !paletteonTheme.useDarkTheme,
              seedColor = Color(Random.nextLong()),
            )
          },
          BUTTON_MARGIN,
          shape = ButtonShape.CIRCLE
        ) {
          Span(
            attrs = Modifier.toAttrs {
              title("Toggle color mode")
            }
          )
        }
        Tooltip(
          target = ElementTarget.PreviousSibling,
          text = "Toggle color mode",
        )
      }
    }
  }
}
