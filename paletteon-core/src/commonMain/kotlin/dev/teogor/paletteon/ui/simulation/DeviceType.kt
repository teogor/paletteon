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

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Represents different types of devices with their dimensions and shapes.
 *
 * Each device type has a specific width, height, and shape configuration.
 */
public sealed interface DeviceType {
  /**
   * The width of the device in density-independent pixels (dp).
   */
  public val width: Dp

  /**
   * The height of the device in density-independent pixels (dp).
   */
  public val height: Dp

  /**
   * The shape of the device.
   */
  public val shape: DeviceShape

  /**
   * Represents a mobile phone device.
   *
   * @param width The width of the mobile device.
   * @param height The height of the mobile device.
   * @param shape The shape of the mobile device.
   */
  public data class Mobile(
    override val width: Dp = 100.dp,
    override val height: Dp = 200.dp,
    override val shape: DeviceShape = DeviceShape.RectangleRounded(16.dp)
  ) : DeviceType

  /**
   * Represents a tablet device.
   *
   * @param width The width of the tablet device.
   * @param height The height of the tablet device.
   * @param shape The shape of the tablet device.
   */
  public data class Tablet(
    override val width: Dp = 200.dp,
    override val height: Dp = 300.dp,
    override val shape: DeviceShape = DeviceShape.RectangleRounded(16.dp)
  ) : DeviceType

  /**
   * Represents a foldable device.
   *
   * @param width The width of the foldable device.
   * @param height The height of the foldable device.
   * @param shape The shape of the foldable device.
   */
  public data class Foldable(
    override val width: Dp = 250.dp,
    override val height: Dp = 250.dp,
    override val shape: DeviceShape = DeviceShape.RectangleRounded(16.dp)
  ) : DeviceType

  /**
   * Represents a smartwatch device.
   *
   * @param width The width of the smartwatch device.
   * @param height The height of the smartwatch device.
   * @param shape The shape of the smartwatch device.
   */
  public data class Watch(
    override val width: Dp = 40.dp,
    override val height: Dp = 40.dp,
    override val shape: DeviceShape = DeviceShape.Circular
  ) : DeviceType

  /**
   * Represents a desktop device.
   *
   * @param width The width of the desktop device.
   * @param height The height of the desktop device.
   * @param shape The shape of the desktop device.
   */
  public data class Desktop(
    override val width: Dp = 400.dp,
    override val height: Dp = 300.dp,
    override val shape: DeviceShape = DeviceShape.Rectangle
  ) : DeviceType

  /**
   * Represents a TV device.
   *
   * @param width The width of the TV device.
   * @param height The height of the TV device.
   * @param shape The shape of the TV device.
   */
  public data class TV(
    override val width: Dp = 600.dp,
    override val height:  Dp = 400.dp,
    override val shape: DeviceShape = DeviceShape.Rectangle
  ) : DeviceType
}
