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

package dev.teogor.paletteon.internal

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Animates all colors in this [ColorScheme] using the provided [animationSpec].
 *
 * This extension function facilitates animating each color component within the color scheme,
 * providing a smooth transition effect between different theme states.
 *
 * @param animationSpec The [AnimationSpec] that defines the animation parameters, such as duration and easing.
 * @return A new [ColorScheme] with all colors animated according to the provided [animationSpec].
 */
@Composable
internal fun ColorScheme.animateColors(animationSpec: AnimationSpec<Color>): ColorScheme {
  return copy(
    primary = primary.animate(animationSpec),
    primaryContainer = primaryContainer.animate(animationSpec),
    secondary = secondary.animate(animationSpec),
    secondaryContainer = secondaryContainer.animate(animationSpec),
    tertiary = tertiary.animate(animationSpec),
    tertiaryContainer = tertiaryContainer.animate(animationSpec),
    background = background.animate(animationSpec),
    surface = surface.animate(animationSpec),
    surfaceTint = surfaceTint.animate(animationSpec),
    surfaceBright = surfaceBright.animate(animationSpec),
    surfaceDim = surfaceDim.animate(animationSpec),
    surfaceContainer = surfaceContainer.animate(animationSpec),
    surfaceContainerHigh = surfaceContainerHigh.animate(animationSpec),
    surfaceContainerHighest = surfaceContainerHighest.animate(animationSpec),
    surfaceContainerLow = surfaceContainerLow.animate(animationSpec),
    surfaceContainerLowest = surfaceContainerLowest.animate(animationSpec),
    surfaceVariant = surfaceVariant.animate(animationSpec),
    error = error.animate(animationSpec),
    errorContainer = errorContainer.animate(animationSpec),
    onPrimary = onPrimary.animate(animationSpec),
    onPrimaryContainer = onPrimaryContainer.animate(animationSpec),
    onSecondary = onSecondary.animate(animationSpec),
    onSecondaryContainer = onSecondaryContainer.animate(animationSpec),
    onTertiary = onTertiary.animate(animationSpec),
    onTertiaryContainer = onTertiaryContainer.animate(animationSpec),
    onBackground = onBackground.animate(animationSpec),
    onSurface = onSurface.animate(animationSpec),
    onSurfaceVariant = onSurfaceVariant.animate(animationSpec),
    onError = onError.animate(animationSpec),
    onErrorContainer = onErrorContainer.animate(animationSpec),
    inversePrimary = inversePrimary.animate(animationSpec),
    inverseSurface = inverseSurface.animate(animationSpec),
    inverseOnSurface = inverseOnSurface.animate(animationSpec),
    outline = outline.animate(animationSpec),
    outlineVariant = outlineVariant.animate(animationSpec),
    scrim = scrim.animate(animationSpec),
  )
}

/**
 * Animates the transition of this [Color] using the provided [animationSpec].
 *
 * This extension function simplifies the process of animating a color by returning
 * the current animated color value based on the specified animation parameters.
 *
 * @param animationSpec The [AnimationSpec] that defines the animation parameters, such as duration and easing.
 * @return The current animated [Color] value.
 *
 * @see animateColorAsState
 */
@Composable
private fun Color.animate(animationSpec: AnimationSpec<Color>): Color {
  return animateColorAsState(targetValue = this, animationSpec = animationSpec).value
}
