@file:Suppress("UnstableApiUsage")

rootProject.name = "Paletteon"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
  repositories {
    google {
      mavenContent {
        includeGroupAndSubgroups("androidx")
        includeGroupAndSubgroups("com.android")
        includeGroupAndSubgroups("com.google")
      }
    }
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
  }
}

dependencyResolutionManagement {
  repositories {
    google {
      mavenContent {
        includeGroupAndSubgroups("androidx")
        includeGroupAndSubgroups("com.android")
        includeGroupAndSubgroups("com.google")
      }
    }
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
  }
}

// Include modules
// Demos
include(":demo:composeApp")
include(":demo:kobwebApp")

// Library
include(":paletteon-core")
include(":paletteon-icons")
include(":paletteon-kobweb")

// Material Color Utilities
include(":material-color-utilities")