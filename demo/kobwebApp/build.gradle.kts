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
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
  alias(libs.plugins.jetbrains.kotlin.multiplatform)
  alias(libs.plugins.jetbrains.compose.compiler)
  alias(libs.plugins.varabyte.kobweb.application)
  alias(libs.plugins.varabyte.kobwebx.markdown)
}

group = "dev.teogor.paletteon.site"

kobweb {
  app {
    index {
      head.add {
        link {
          rel = "stylesheet"
          href = "/highlight.js/styles/dracula.css"
        }
        script {
          src = "/highlight.js/highlight.min.js"
        }
      }
    }
  }
}

kotlin {
  configAsKobwebApplication("paletteon-site")

  js {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions.target = "es2015"
  }

  sourceSets {
    val jsMain by getting {
      dependencies {
        // implementation(libs.compose.html.core)
        implementation(libs.varabyte.kobweb.core)
        implementation(libs.varabyte.kobweb.silk)
        // implementation(libs.varabyte.silk.icons.fa)
        // implementation(libs.varabyte.kobwebx.markdown)

        implementation(projects.paletteonKobweb)
      }
    }
  }
}
