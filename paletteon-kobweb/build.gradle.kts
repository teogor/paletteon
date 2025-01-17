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
import com.varabyte.kobweb.gradle.library.util.configAsKobwebLibrary
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
    alias(libs.plugins.varabyte.kobweb.library)
    alias(libs.plugins.teogor.winds)
}

winds {
    moduleMetadata {
        artifactDescriptor {
            name = "Kobweb"
        }
    }
}

kotlin {
    explicitApi()

    applyDefaultHierarchyTemplate()

    configAsKobwebLibrary()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.material3)
                api(compose.ui)
                api(projects.paletteonCore)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.jetbrains.kotlin.test)
            }
        }

        val jsMain by getting {
            dependencies {
                api(compose.html.core)
                implementation(libs.varabyte.kobweb.core)
                implementation(libs.varabyte.kobweb.silk)
            }
        }
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

