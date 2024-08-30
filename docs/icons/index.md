# Paletteon Icons Documentation

Welcome to the Paletteon Icons documentation. This guide provides an overview of the icons available in the Paletteon library, how to implement them, and advanced techniques for manipulating vector graphics.

## Package Information

To use the Paletteon Icons library, add the following dependency to your project:

```kotlin
dependencies {
    implementation("dev.teogor.paletteon:paletteon-icons:<version>")
}
```

Replace `<version>` with the desired version of the `paletteon-icons` library.

For detailed instructions on how to implement these dependencies, please refer to the [implementation guide](../releases/index.md).

## Icons Overview

Paletteon Icons provides a range of icons to enhance your Compose Multiplatform applications. Here are a few examples:

### Animation Icon
```kotlin
import dev.teogor.paletteon.icons.Icons
import androidx.compose.material3.Icon

@Composable
fun AnimationIcon() {
    Icon(imageVector = Icons.Filled.Animation, contentDescription = "Animation Icon")
}
```

### LightMode Icon
```kotlin
import dev.teogor.paletteon.icons.Icons
import androidx.compose.material3.Icon

@Composable
fun LightModeIcon() {
    Icon(imageVector = Icons.Filled.LightMode, contentDescription = "Light Mode Icon")
}
```

For a complete list of all available icons and their usage, please refer to the [Icons Overview](./overview.md).

## Advanced Image Handling

Paletteon Icons provides utilities for advanced image handling and transformations. This includes rotating and flipping `ImageVector` instances.

### Rotation and Flipping

You can use the `ImageVectorEditor` class to apply various transformations to your icons:

#### Degrees Enum

Defines predefined rotation angles:

```kotlin
public enum class Degrees(internal val value: Float) {
    D0(0f),
    D45(45f),
    D90(90f),
    D135(135f),
    D180(180f),
    D225(225f),
    D270(270f),
    D315(315f)
}
```

#### Flip Enum

Defines flipping options:

```kotlin
public enum class Flip {
    None,
    Horizontal,
    Vertical,
    HorizontalVertical
}
```

#### ImageVectorEditor

Apply rotations and flips to an `ImageVector`:

```kotlin
import androidx.compose.ui.graphics.vector.ImageVector
import dev.teogor.paletteon.icons.Degrees
import dev.teogor.paletteon.icons.Flip
import dev.teogor.paletteon.icons.ImageVectorEditor
import dev.teogor.paletteon.PaletteonDsl

@PaletteonDsl
public fun ImageVector.applyTransformations(
    transform: ImageVectorEditor.() -> Unit,
): ImageVector {
    val editor = ImageVectorEditor(this)
    editor.transform()
    return editor.build()
}
```

**Example Usage:**

```kotlin
import dev.teogor.paletteon.icons.Icons
import dev.teogor.paletteon.icons.applyTransformations

@Composable
fun RotatedLightModeIcon() {
    val icon = Icons.Filled.LightMode.applyTransformations {
        rotate(Degrees.D90)
        flip(Flip.Horizontal)
    }
    Icon(imageVector = icon, contentDescription = "Rotated Light Mode Icon")
}
```

This example demonstrates how to apply a 90-degree rotation and horizontal flip to an icon.

## Additional Information

For more detailed usage instructions and a complete list of all available icons, please refer to the [implementation guide](../releases/index.md).
