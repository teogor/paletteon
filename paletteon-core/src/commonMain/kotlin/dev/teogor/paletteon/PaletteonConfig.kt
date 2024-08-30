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

package dev.teogor.paletteon


/**
 * Interface for managing Paletteon configuration settings.
 *
 * This interface defines a contract for retrieving the current Paletteon theme configuration.
 * Implementations of this interface should provide access to the configuration settings used
 * by Paletteon for theming and appearance.
 */
public interface PaletteonConfig {

  public companion object {
    /**
     * The singleton instance of [PaletteonConfig].
     *
     * This property provides access to the current configuration instance. By default,
     * it returns [MutablePaletteonConfigInstance], which is an instance of [MutablePaletteonConfig].
     *
     * @return The current instance of [PaletteonConfig].
     */
    public val Instance: PaletteonConfig
      get() = MutablePaletteonConfigInstance
  }

  /**
   * The initial Paletteon theme configuration.
   *
   * This property holds the initial configuration for the Paletteon theme, including settings
   * such as color schemes, styles, and contrast. Implementations should provide a way to
   * access and modify these settings.
   *
   * @return The [PaletteonDynamicTheme] representing the initial theme configuration.
   */
  public val initialPaletteonTheme: PaletteonTheme
}

/**
 * Mutable implementation of [PaletteonConfig] to allow changes to configuration settings.
 *
 * This class provides a mutable implementation of [PaletteonConfig], allowing for updates
 * to the Paletteon theme configuration. It is intended to be used where dynamic updates
 * to the configuration are required.
 */
public class MutablePaletteonConfig : PaletteonConfig {

  /**
   * The initial Paletteon theme configuration.
   *
   * This property is backed by a mutable implementation, allowing the theme configuration
   * to be updated dynamically. By default, it is initialized with an empty [PaletteonDynamicTheme].
   */
  override var initialPaletteonTheme: PaletteonTheme = PaletteonTheme()
}

/**
 * The singleton instance of [MutablePaletteonConfig].
 *
 * This internal property holds the single mutable instance of [MutablePaletteonConfig] used
 * throughout the application. It allows for the configuration to be accessed and modified
 * as needed.
 */
internal val MutablePaletteonConfigInstance: MutablePaletteonConfig = MutablePaletteonConfig()
