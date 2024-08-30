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
 * Represents various angles for rotation in the Paletteon library.
 * This enum provides predefined angles that can be used to rotate an `ImageVector`.
 *
 * @property value The rotation angle in degrees, which can be used internally for transformations.
 */
public enum class Degrees(internal val value: Float) {

  /**
   * Represents a 0-degree rotation (no rotation).
   */
  D0(0f),

  /**
   * Represents a 45-degree rotation.
   */
  D45(45f),

  /**
   * Represents a 90-degree rotation (quarter turn).
   */
  D90(90f),

  /**
   * Represents a 135-degree rotation.
   */
  D135(135f),

  /**
   * Represents a 180-degree rotation (half turn).
   */
  D180(180f),

  /**
   * Represents a 225-degree rotation.
   */
  D225(225f),

  /**
   * Represents a 270-degree rotation (three-quarter turn).
   */
  D270(270f),

  /**
   * Represents a 315-degree rotation.
   */
  D315(315f)
}
