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

package dev.teogor.paletteon.ui.simulation

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * Represents the shape of a device.
 *
 * This sealed interface allows defining different shapes for devices. Each shape
 * can be converted to a [Shape] used in Jetpack Compose.
 */
public sealed interface DeviceShape {

  /**
   * Converts the [DeviceShape] to a [Shape] used in Jetpack Compose.
   *
   * @return The [Shape] representation of the device shape.
   */
  public fun asShape(): Shape = when (this) {
    is Rectangle -> RectangleShape
    is RectangleRounded -> RoundedCornerShape(roundness)
    is Circular -> CircleShape
  }

  /**
   * Represents a circular shape for the device.
   */
  public data object Circular : DeviceShape

  /**
   * Represents a rectangular shape for the device.
   */
  public data object Rectangle : DeviceShape

  /**
   * Represents a rectangle with rounded corners.
   *
   * @param roundness The radius of the corners.
   */
  public data class RectangleRounded(
    val roundness: Dp
  ) : DeviceShape
}
