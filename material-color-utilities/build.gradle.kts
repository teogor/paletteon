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
import dev.teogor.winds.api.ArtifactIdFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.teogor.winds)
}

winds {
    moduleMetadata {
        artifactDescriptor {
            name = "Material Color Utilities"
            artifactIdFormat = ArtifactIdFormat.NAME_ONLY
        }
    }
}

kotlin {
    explicitApi()

    applyDefaultHierarchyTemplate()

    jvm {
        kotlin {
            jvmToolchain(11)
        }
    }

    js(IR) {
        browser()
        nodejs()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        nodejs()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { target ->
        target.binaries.framework {
            baseName = "material-color-utilities"
        }
    }

    macosX64()
    macosArm64()

    // TODO: Add support for additional platforms when Compose support becomes available.
    //  The following platforms are currently not supported by Compose, but may be considered in the future:
    //  Linux:
    //  - linuxX64()
    //  - linuxArm64()
    //  tvOS:
    //  - tvosX64()
    //  - tvosArm64()
    //  - tvosSimulatorArm64()
    //  watchOS:
    //  - watchosX64()
    //  - watchosArm32()
    //  - watchosArm64()
    //  - watchosDeviceArm64()
    //  - watchosSimulatorArm64()

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(libs.jetbrains.kotlin.test)
            }
        }
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

