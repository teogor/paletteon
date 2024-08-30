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

package dev.teogor.paletteon.icons

/**
 * Represents different flipping (mirroring) options for vector graphics in the Paletteon library.
 * This enum provides predefined options for mirroring an `ImageVector` either horizontally, vertically, or both.
 */
public enum class Flip {

  /**
   * No flipping or mirroring applied.
   */
  None,

  /**
   * Horizontal flipping or mirroring.
   * This option flips the image along the vertical axis, creating a mirror image as if it were reflected
   * in a vertical mirror.
   */
  Horizontal,

  /**
   * Vertical flipping or mirroring.
   * This option flips the image along the horizontal axis, creating a mirror image as if it were reflected
   * in a horizontal mirror.
   */
  Vertical,

  /**
   * Both horizontal and vertical flipping or mirroring.
   * This option applies both horizontal and vertical flips, which is equivalent to rotating the image by
   * 180 degrees.
   */
  HorizontalVertical
}
