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

package dev.teogor.paletteon.site.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import dev.teogor.paletteon.site.components.sections.NavHeader
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.fr

@Composable
fun PageLayout(title: String, content: @Composable () -> Unit) {
  LaunchedEffect(title) {
    document.title = "Paletteon - $title"
  }

  LaunchedEffect(window.location.href) {
    // See kobweb config in build.gradle.kts which sets up highlight.js
    js("hljs.highlightAll()") as Unit
  }

  // Create a box with two rows: the main content (fills as much space as it can) and the footer (which reserves
  // space at the bottom). "auto" means the use the height of the row. "1fr" means give the rest of the space to
  // that row. Since this box is set to *at least* 100%, the footer will always appear at least on the bottom but
  // can be pushed further down if the first row grows beyond the page.
  Box(
    Modifier.fillMaxSize().gridTemplateRows { size(1.fr); size(auto) },
    contentAlignment = Alignment.TopCenter
  ) {
    Column(
      modifier = Modifier.fillMaxSize().align(Alignment.TopCenter),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      NavHeader()
      content()
    }
  }
}
