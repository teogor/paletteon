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

package dev.teogor.paletteon.site

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import dev.teogor.paletteon.PaletteonDynamicTheme
import dev.teogor.paletteon.kobweb.PaletteonKobwebProvider
import dev.teogor.paletteon.kobweb.PaletteonTheme
import dev.teogor.paletteon.kobweb.initPaletteon
import dev.teogor.paletteon.kobweb.ui.color.asRgba
import dev.teogor.paletteon.kobweb.ui.components.PaletteonSurface
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh

@InitSilk
fun initSilk(ctx: InitSilkContext) {
  initPaletteon(ctx)

  ctx.stylesheet.apply {
    registerStyleBase("body") {
      Modifier.fontFamily(
        "-apple-system", "BlinkMacSystemFont", "Segoe UI", "Roboto", "Oxygen", "Ubuntu",
        "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", "sans-serif"
      )
    }

    val headerCommon = Modifier
      .fontWeight(FontWeight.Bold)
      .textAlign(TextAlign.Center)
      .margin(bottom = 1.cssRem)

    registerStyleBase("h1") {
      headerCommon.fontSize(3.5.cssRem)
    }

    registerStyleBase("h2") {
      headerCommon.fontSize(2.5.cssRem)
    }

    registerStyleBase("h3") {
      headerCommon.fontSize(1.5.cssRem)
    }
  }
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
  SilkApp {
    val paletteonTheme by PaletteonTheme.currentState

    PaletteonKobwebProvider {
      PaletteonDynamicTheme(
        seedColor = paletteonTheme.seedColor,
        useDarkTheme = paletteonTheme.useDarkTheme,
        withAmoled = paletteonTheme.withAmoled,
        style = paletteonTheme.style,
        contrast = paletteonTheme.contrast,
        isExtendedFidelity = paletteonTheme.isExtendedFidelity,
        animate = paletteonTheme.animate
      ) {
        PaletteonSurface(
          modifier = Modifier
            .fillMaxWidth()
            .minHeight(100.vh)
            .backgroundColor(paletteonTheme.colorScheme.background.asRgba()),
          color = paletteonTheme.colorScheme.background,
        ) {
          content()
        }
      }
    }
  }
}
