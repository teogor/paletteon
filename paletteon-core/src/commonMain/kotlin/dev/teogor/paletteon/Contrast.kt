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

package dev.teogor.paletteon;

/**
 * Represents different levels of contrast for UI components.
 *
 * Each contrast level is associated with a specific numeric value.
 *
 * @property value The numeric value representing the contrast level.
 */
public enum class Contrast(public val value: Double) {

  /**
   * Default contrast level with a value of `0.0`.
   */
  Default(0.0),

  /**
   * Medium contrast level with a value of `0.5`.
   */
  Medium(0.5),

  /**
   * High contrast level with a value of `1.0`.
   */
  High(1.0),

  /**
   * Reduced contrast level with a value of `-1.0`.
   */
  Reduced(-1.0);

  public companion object {

    /**
     * Retrieves the [Contrast] level corresponding to the given [value].
     *
     * @param value The numeric value to match against the contrast levels.
     * @return The matching [Contrast] level, or [Default] if no match is found.
     */
    public fun fromValue(value: Double): Contrast {
      return entries.find { it.value == value } ?: Default
    }
  }
}
