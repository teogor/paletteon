import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import dev.teogor.winds.api.ArtifactIdFormat
import dev.teogor.winds.api.License
import dev.teogor.winds.api.NameFormat
import dev.teogor.winds.api.Person
import dev.teogor.winds.api.Scm.GitHub
import dev.teogor.winds.api.TicketSystem
import dev.teogor.winds.ktx.createVersion
import dev.teogor.winds.ktx.person
import dev.teogor.winds.ktx.scm
import dev.teogor.winds.ktx.ticketSystem
import org.gradle.api.internal.catalog.DelegatingProjectDependency
import org.jetbrains.dokka.gradle.DokkaPlugin

plugins {
    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.jetbrains.compose.compiler) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.multiplatform) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.kotlin.multiplatform.library) apply false

    alias(libs.plugins.teogor.winds)
    alias(libs.plugins.vanniktech.maven)
    alias(libs.plugins.jetbrains.dokka)
    alias(libs.plugins.diffplug.spotless)
    alias(libs.plugins.jetbrains.kotlinx.binary.compatibility)
}

winds {
    features {
        mavenPublishing = true
        docsGenerator = true
        workflowSynthesizer = true
    }

    moduleMetadata {
        name = "Paletteon"
        description = """
        |🎨 Paletteon elevates your Compose Multiplatform UI with dynamic color themes, smooth transitions, and extensive customization options.
        |""".trimMargin()

        yearCreated = 2024
        websiteUrl = "https://source.teogor.dev/paletteon/"
        apiDocsUrl = "https://source.teogor.dev/paletteon/html/"

        artifactDescriptor {
            group = "dev.teogor.paletteon"
            name = "paletteon"
            version = createVersion(1, 0, 0) {
                alphaRelease(2)
            }
            nameFormat = NameFormat.FULL
            artifactIdFormat = ArtifactIdFormat.MODULE_NAME_ONLY
        }

        // Providing SCM (Source Control Management)
        scm<GitHub> {
            owner = "teogor"
            repository = "paletteon"
        }

        // Providing Ticket System
        ticketSystem<TicketSystem.GitHub> {
            owner = "teogor"
            repository = "paletteon"
        }

        // Providing Licenses
        licensedUnder(License.Apache2())

        // Providing Persons
        person<Person.DeveloperContributor> {
            id = "teogor"
            name = "Teodor Grigor"
            email = "open-source@teogor.dev"
            url = "https://teogor.dev"
            roles = listOf("Code Owner", "Developer", "Designer", "Maintainer")
            timezone = "UTC+2"
            organization = "Teogor"
            organizationUrl = "https://github.com/teogor"
        }
    }

    publishing {
        enabled = false
        enablePublicationSigning = true
        optInForVanniktechPlugin = true
        cascade = true
        automaticPublishing = true
    }

    documentationBuilder {
        htmlPath = "html/"
    }
}

subprojects {
    apply<SpotlessPlugin>()
    configure<SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            targetExclude(
                "**/build/**/*.kt",

                // Blend
                "**/dev/teogor/paletteon/blend/Blend.kt",

                // Contrast
                "**/dev/teogor/paletteon/contrast/Contrast.kt",

                // Dislike
                "**/dev/teogor/paletteon/dislike/DislikeAnalyzer.kt",

                // Dynamic Color
                "**/dev/teogor/paletteon/dynamiccolor/ContrastCurve.kt",
                "**/dev/teogor/paletteon/dynamiccolor/DynamicColor.kt",
                "**/dev/teogor/paletteon/dynamiccolor/MaterialDynamicColors.kt",
                "**/dev/teogor/paletteon/dynamiccolor/ToneDeltaPair.kt",
                "**/dev/teogor/paletteon/dynamiccolor/TonePolarity.kt",

                // Hct
                "**/dev/teogor/paletteon/hct/Cam16.kt",
                "**/dev/teogor/paletteon/hct/Hct.kt",
                "**/dev/teogor/paletteon/hct/HctSolver.kt",
                "**/dev/teogor/paletteon/hct/ViewingConditions.kt",

                // Palettes
                "**/dev/teogor/paletteon/palettes/CorePalette.kt",
                "**/dev/teogor/paletteon/palettes/TonalPalette.kt",

                // Quantize
                "**/dev/teogor/paletteon/quantize/PointProvider.kt",
                "**/dev/teogor/paletteon/quantize/PointProviderLab.kt",
                "**/dev/teogor/paletteon/quantize/Quantizer.kt",
                "**/dev/teogor/paletteon/quantize/QuantizerCelebi.kt",
                "**/dev/teogor/paletteon/quantize/QuantizerMap.kt",
                "**/dev/teogor/paletteon/quantize/QuantizerResult.kt",
                "**/dev/teogor/paletteon/quantize/QuantizerWsmeans.kt",
                "**/dev/teogor/paletteon/quantize/QuantizerWu.kt",

                // Scheme
                "**/dev/teogor/paletteon/scheme/DynamicScheme.kt",
                "**/dev/teogor/paletteon/scheme/Scheme.kt",
                "**/dev/teogor/paletteon/scheme/SchemeContent.kt",
                "**/dev/teogor/paletteon/scheme/SchemeExpressive.kt",
                "**/dev/teogor/paletteon/scheme/SchemeFidelity.kt",
                "**/dev/teogor/paletteon/scheme/SchemeFruitSalad.kt",
                "**/dev/teogor/paletteon/scheme/SchemeMonochrome.kt",
                "**/dev/teogor/paletteon/scheme/SchemeNeutral.kt",
                "**/dev/teogor/paletteon/scheme/SchemeRainbow.kt",
                "**/dev/teogor/paletteon/scheme/SchemeTonalSpot.kt",
                "**/dev/teogor/paletteon/scheme/SchemeVibrant.kt",
                "**/dev/teogor/paletteon/scheme/Variant.kt",

                // Score
                "**/dev/teogor/paletteon/score/Score.kt",

                // Temperature
                "**/dev/teogor/paletteon/temperature/TemperatureCache.kt",

                // Utils
                "**/dev/teogor/paletteon/utils/ColorUtils.kt",
                "**/dev/teogor/paletteon/utils/MathUtils.kt",
            )
            licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
            trimTrailingWhitespace()
            endWithNewline()
        }
        format("kts") {
            target("**/*.kts")
            targetExclude("**/build/**/*.kts")
            // Look for the first line that doesn't have a block comment (assumed to be the license)
            licenseHeaderFile(rootProject.file("spotless/copyright.kts"), "(^(?![\\/ ]\\*).*$)")
        }
        format("xml") {
            target("**/*.xml")
            targetExclude("**/build/**/*.xml")
            // Look for the first XML tag that isn't a comment (<!--) or the xml declaration (<?xml)
            licenseHeaderFile(rootProject.file("spotless/copyright.xml"), "(<[^!?])")
        }
    }
}

val excludedProjectsPaths = listOf(
    projects.paletteon,
    projects.demo,
).map { it.path }

subprojects {
    if (!excludedProjectsPaths.contains(this.path)) {
        apply<DokkaPlugin>()
    }
}
