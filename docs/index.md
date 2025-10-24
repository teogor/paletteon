# 🎨 Paletteon 🎨

**Paletteon** elevates your Compose Multiplatform UI with dynamic color themes, smooth transitions, and extensive customization options.

### Live Demo

Experience Paletteon in action and see its features in real-time on our **[Live Demo](https://teogor.dev/paletteon)**.

## Features

- **Material Design Color Palettes**: Access and utilize Material Design color palettes with ease.
- **Kotlin Multiplatform Support**: Use Paletteon across various platforms including Android, iOS, and more.
- **Flexible API**: Manage and apply colors, themes, and palettes with a straightforward and intuitive API.
- **Customizable**: Extend and customize the color palettes to fit your specific design needs.

[//]: # (REGION-DEPENDENCIES)

## Getting Started with Paletteon

**Adding Dependencies:**

* **Manual Setup:**  This section guides you through adding Paletteon dependencies directly to your project's `build.gradle` files. ([Link to Manual Dependency Setup Section](#adding-paletteon-dependencies-manually))
* **Version Catalog (Recommended):** For a more streamlined approach, consider integrating a version catalog. This allows for centralized version management and easier updates. ([Link to Version Catalog Section](#managing-paletteon-versions-with-version-catalog-recommended))

**Note:** If you prefer manual dependency setup, follow the instructions in the "Manual Setup" section. Otherwise, jump to the "Version Catalog" section for centralized management.

For information on using the KAPT plugin, see the [KAPT documentation](https://kotlinlang.org/docs/kapt.html).  
For information on using the KSP plugin, see the [KSP quick-start documentation](https://kotlinlang.org/docs/ksp-quickstart.html).  
For more information about dependencies, see [Add Build Dependencies](https://developer.android.com/studio/build/dependencies).  

### Adding Paletteon Dependencies Manually

To use Paletteon in your app, add the following dependencies to your app's `build.gradle` file:

=== "Groovy"

    ```groovy title="build.gradle"
    dependencies {
        def teogorPaletteon = "1.0.0-alpha02"
        
        implementation "dev.teogor.paletteon:material-color-utilities:$teogorPaletteon"
        implementation "dev.teogor.paletteon:paletteon-core:$teogorPaletteon"
        implementation "dev.teogor.paletteon:paletteon-icons:$teogorPaletteon"
        implementation "dev.teogor.paletteon:paletteon-kobweb:$teogorPaletteon"
    }
    ```

=== "Kotlin"

    ```kotlin title="build.gradle.kts"
    dependencies {
        val teogorPaletteon = "1.0.0-alpha02"
        
        implementation("dev.teogor.paletteon:material-color-utilities:$teogorPaletteon")
        implementation("dev.teogor.paletteon:paletteon-core:$teogorPaletteon")
        implementation("dev.teogor.paletteon:paletteon-icons:$teogorPaletteon")
        implementation("dev.teogor.paletteon:paletteon-kobweb:$teogorPaletteon")
    }
    ```

### Managing Paletteon Versions with Version Catalog (Recommended)

This section guides you through utilizing a version catalog for centralized management of Paletteon dependencies in your project. This approach simplifies updates and ensures consistency.

First, define the dependencies in the `libs.versions.toml` file:

- **Group-Name Based:** This approach is used for declaring libraries referenced by group and artifact name.
- **Module Based:** This approach is used for declaring libraries referenced by their module.

=== "Group-Name Based"

    ```toml title="gradle/libs.versions.toml"
    [versions]
    teogor-paletteon = "1.0.0-alpha02"
    
    [libraries]
    teogor-paletteon-material-color-utilities = { group = "dev.teogor.paletteon", name = "material-color-utilities", version.ref = "teogor-paletteon" }
    teogor-paletteon-core = { group = "dev.teogor.paletteon", name = "paletteon-core", version.ref = "teogor-paletteon" }
    teogor-paletteon-icons = { group = "dev.teogor.paletteon", name = "paletteon-icons", version.ref = "teogor-paletteon" }
    teogor-paletteon-kobweb = { group = "dev.teogor.paletteon", name = "paletteon-kobweb", version.ref = "teogor-paletteon" }
    ```

=== "Module Based"

    ```toml title="gradle/libs.versions.toml"
    [versions]
    teogor-paletteon = "1.0.0-alpha02"
    
    [libraries]
    teogor-paletteon-material-color-utilities = { module = "dev.teogor.paletteon:material-color-utilities", version.ref = "teogor-paletteon" }
    teogor-paletteon-core = { module = "dev.teogor.paletteon:paletteon-core", version.ref = "teogor-paletteon" }
    teogor-paletteon-icons = { module = "dev.teogor.paletteon:paletteon-icons", version.ref = "teogor-paletteon" }
    teogor-paletteon-kobweb = { module = "dev.teogor.paletteon:paletteon-kobweb", version.ref = "teogor-paletteon" }
    ```

Then, add these dependencies in your app's `build.gradle` file:

=== "Groovy"

    ```groovy title="build.gradle"
    dependencies {
        implementation libs.teogor.paletteon.material.color.utilities
        implementation libs.teogor.paletteon.core
        implementation libs.teogor.paletteon.icons
        implementation libs.teogor.paletteon.kobweb
    }
    ```

=== "Kotlin"

    ```kotlin title="build.gradle.kts"
    dependencies {
        implementation(libs.teogor.paletteon.material.color.utilities)
        implementation(libs.teogor.paletteon.core)
        implementation(libs.teogor.paletteon.icons)
        implementation(libs.teogor.paletteon.kobweb)
    }
    ```

[//]: # (REGION-DEPENDENCIES)


## Basic Usage

To get started with `PaletteonDynamicTheme`, follow these steps:

1. **Add Dependencies**

   Ensure you have the necessary dependencies in your project for using Paletteon with Compose Multiplatform. For detailed instructions on how to implement these dependencies, please refer to the [implementation guide](./docs/releases/index.md).

2. **Define Your Theme**

   Use the `PaletteonDynamicTheme` composable to apply a dynamic theme based on a seed color. Here’s a basic example:

   ```kotlin
   import androidx.compose.foundation.isSystemInDarkTheme
   import androidx.compose.runtime.Composable
   import dev.teogor.paletteon.PaletteonDynamicTheme
   import dev.teogor.paletteon.PaletteonThemedSurface
   import dev.teogor.paletteon.StandardColors

   @Composable
   fun AppTheme(
      content: @Composable () -> Unit,
   ) {
     PaletteonDynamicTheme(
       seedColor = StandardColors.first().color,
       useDarkTheme = isSystemInDarkTheme(),
       animate = true,
     ) {
       PaletteonThemedSurface {
         content()
       }
     }
   }
   ```

   In this example:
  - `seedColor` defines the base color for the theme.
  - `useDarkTheme` toggles the dark theme based on system preferences.
  - `animate` enables smooth transitions between color states.

## Advanced Usage

### Customizing the Theme

Paletteon allows extensive customization of the theme. You can configure various parameters such as contrast, theme style, and more.

#### Within a Composable Context

When working within a composable context, you can use the `@Composable` version of `configurePaletteonTheme` to apply theme modifications. This will automatically update the current theme state and recompose your UI.

Here’s how you can customize the theme within a composable:

```kotlin
import androidx.compose.runtime.Composable
import dev.teogor.paletteon.PaletteonTheme
import dev.teogor.paletteon.configurePaletteonTheme

@Composable
fun CustomThemeSetup() {
  configurePaletteonTheme {
    seedColor = Color.Red
    useDarkTheme = true
    withAmoled = true
    style = PaletteStyle.TonalSpot
    contrast = Contrast.High
    isExtendedFidelity = true
  }
}
```

#### Outside of a Composable Context

If you need to configure the theme outside of composable functions, such as in a non-composable setup or initialization code, you should use the non-composable `configurePaletteonTheme` function. This allows you to modify and apply the theme without the need for recomposition context.

Here’s how you can customize the theme outside of a composable:

```kotlin
import dev.teogor.paletteon.PaletteonTheme
import dev.teogor.paletteon.configurePaletteonTheme

fun updateTheme(paletteonThemeState: PaletteonTheme) {
  paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
    nextContrast() // Example modification
  }
}
```

### Accessing the Current Theme

You can access and manipulate the current `PaletteonTheme` using the following properties:

- **`PaletteonTheme.currentState`**: Provides a `MutableState` of the current theme. This allows you to change the theme and automatically update the UI.

  ```kotlin
  import androidx.compose.runtime.Composable
  import dev.teogor.paletteon.PaletteonTheme
  import androidx.compose.runtime.setValue
  import androidx.compose.runtime.getValue

  @Composable
  fun ThemeModifier() {
    var themeState by PaletteonTheme.currentState
    // Use themeState to observe or modify the current theme
  }
  ```

- **`PaletteonTheme.current`**: Provides read-only access to the current theme. It returns the current `PaletteonTheme` value as provided by `LocalPaletteonTheme`. Use this to access the current theme settings without modifying them.

  If you want to use colors defined by the current theme, use `PaletteonTheme.current`. For example, to access a primary color:

  ```kotlin
  import androidx.compose.runtime.Composable
  import dev.teogor.paletteon.PaletteonTheme

  @Composable
  fun ThemedComponent() {
    val currentTheme = PaletteonTheme.current
    val primaryColor = currentTheme.colorScheme.primary
  
    // Use primaryColor in your composable
  }
  ```

  Alternatively, if you want to use the default colors provided by Material Theme, you can use `MaterialTheme`:

  ```kotlin
  import androidx.compose.material3.MaterialTheme

  @Composable
  fun ThemedComponent() {
    val primaryColor = MaterialTheme.colorScheme.primary
  
    // Use primaryColor in your composable
  }
  ```

  Use `PaletteonTheme.current` if you need to apply custom colors defined in your `PaletteonTheme`. Use `MaterialTheme` for standard Material Design colors.

### Animating Color Transitions

If you want to animate color transitions, enable the `animate` parameter in `PaletteonDynamicTheme`:

```kotlin
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import dev.teogor.paletteon.PaletteonDynamicTheme
import dev.teogor.paletteon.StandardColors

@Composable
fun AnimatedThemeExample() {
  PaletteonDynamicTheme(
    seedColor = StandardColors.primary().color,
    animate = true,
    animationSpec = spring(stiffness = Spring.StiffnessHigh),
  ) {
    // Your content here
  }
}
```

## Kobweb Integration

To integrate Paletteon with Kobweb, follow these steps:

1. **Initialize Paletteon in Your Application**

   Add the following initialization code in your `@InitSilk` function:

   ```kotlin
   @InitSilk
   fun initSilk(ctx: InitSilkContext) {
     initPaletteon(ctx)
   }
   ```

2. **Wrap Your Application with Paletteon Providers**

   Use `PaletteonKobwebProvider` in your main application composable to apply the Paletteon theme:

   ```kotlin
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
   ```

3. **Using Paletteon Theme in Your Composables**

   Access and apply the Paletteon theme in your composables like this:

   ```kotlin
   @Composable
   fun NavHeader() {
     var paletteonTheme by PaletteonTheme.currentState
     Box(
       modifier = NavHeaderStyle.toModifier()
         .backgroundColor(paletteonTheme.colorScheme.background.copy(alpha = .65f)),
       contentAlignment = Alignment.Center
     ) {
       // Your content here
     }
   }
   ```

### Package Information

To use Paletteon with Kobweb, add the following dependency to your project:

```kotlin
dependencies {
  implementation("dev.teogor.paletteon:paletteon-kobweb:<version>")
}
```

Replace `<version>` with the desired version of the `paletteon-kobweb` library. For detailed instructions on how to implement these dependencies, please refer to the [implementation guide](./docs/releases/index.md).

## Paletteon Icons

Paletteon offers a diverse set of icons for enriching your user interface. Below are examples of how to use some of these icons:

### Examples

- **BulbOn**:
  ```kotlin
  import dev.teogor.paletteon.icons.Icons
  import androidx.compose.material3.Icon

  @Composable
  fun BulbOnIcon() {
      Icon(imageVector = Icons.Filled.BulbOn, contentDescription = "Bulb On Icon")
  }
  ```

- **LightMode**:
  ```kotlin
  import dev.teogor.paletteon.icons.Icons
  import androidx.compose.material3.Icon

  @Composable
  fun LightModeIcon() {
      Icon(imageVector = Icons.Filled.LightMode, contentDescription = "Light Mode Icon")
  }
  ```

### Package Information

To use the Paletteon Icons library, add the following dependency to your project:

```kotlin
dependencies {
  implementation("dev.teogor.paletteon:paletteon-icons:<version>")
}
```

Replace `<version>` with the desired version of the `paletteon-icons` library. For detailed instructions on how to implement these dependencies, please refer to the [implementation guide](./docs/releases/index.md).

### Advanced Icon Guide

For a comprehensive list of all available icons and detailed usage instructions, please refer to the [Paletteon Icons Documentation](./docs/icons/overview.md).

## Contributing

Contributions to Paletteon are welcome! If you have any ideas, bug reports, or feature requests, please open an issue or submit a pull request. For more information, please refer to our [Contributing Guidelines](CONTRIBUTING.md).

## Find this repository useful? :heart:

Support it by joining [stargazers](https://github.com/teogor/paletteon/stargazers) for this repository. :star: <br>
Also, [follow me](https://github.com/teogor) on GitHub for my next creations! 🤩

## License

```xml
  Designed and developed by 2024 Teogor (Teodor Grigor)

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
```
