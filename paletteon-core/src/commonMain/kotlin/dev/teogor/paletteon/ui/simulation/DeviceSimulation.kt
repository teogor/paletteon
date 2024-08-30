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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.teogor.paletteon.Contrast
import dev.teogor.paletteon.PaletteStyle
import dev.teogor.paletteon.PaletteonDynamicTheme
import dev.teogor.paletteon.PaletteonTheme

/**
 * A composable function that simulates different devices with customizable appearance.
 *
 * @param deviceType The type of the device being simulated.
 * @param color The seed color for the theme.
 * @param useDarkTheme Boolean to toggle dark theme.
 * @param style The style of the palette.
 * @param contrast The contrast level for the theme.
 * @param selectedColor The color that is currently selected.
 * @param onColorSelected Callback for when a color is selected.
 * @param selectedStateIndicator A composable that defines the visual representation of the selected state.
 */
@Composable
public fun DeviceSimulation(
  deviceType: DeviceType,
  color: Color,
  useDarkTheme: Boolean,
  style: PaletteStyle,
  contrast: Contrast,
  selectedColor: Color,
  onColorSelected: (Color) -> Unit,
  selectedStateIndicator: (@Composable BoxScope.(isSelected: Boolean) -> Unit)? = null,
) {
  PaletteonDynamicTheme(
    seedColor = color,
    useDarkTheme = useDarkTheme,
    style = style,
    contrast = contrast,
    animate = false,
  ) {
    val localTheme = PaletteonTheme.current
    Box {
      Surface(
        modifier = Modifier
          .width(deviceType.width)
          .height(deviceType.height)
          .then(
            if (color == selectedColor) {
              Modifier
                .scale(.9f)
            } else Modifier
          )
          .clip(deviceType.shape.asShape())
          .clickable {
            onColorSelected(color)
          },
        shape = deviceType.shape.asShape(),
        border = BorderStroke(
          width = 4.dp,
          color = localTheme.colorScheme.primary
        ),
      ) {
        Column(
          modifier = Modifier.fillMaxSize(),
        ) {
          when (deviceType) {
            is DeviceType.Desktop -> DesktopLayout(localTheme, deviceType)
            is DeviceType.Foldable -> FoldableLayout(localTheme, deviceType)
            is DeviceType.Mobile -> MobileLayout(localTheme, deviceType)
            is DeviceType.TV -> TVLayout(localTheme, deviceType)
            is DeviceType.Tablet -> TabletLayout(localTheme, deviceType)
            is DeviceType.Watch -> WatchLayout(localTheme, deviceType)
          }
        }
      }

      selectedStateIndicator?.invoke(this, color == selectedColor)
    }
  }
}

/**
 * Displays a simple layout for a desktop device.
 *
 * @param localTheme The current theme to be used for styling.
 * @param deviceType The device type, which in this case is a Desktop.
 */
@Composable
private fun DesktopLayout(localTheme: PaletteonTheme, deviceType: DeviceType.Desktop) {
  Column(
    modifier = Modifier.fillMaxSize(),
  ) {
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .height(24.dp),
      tonalElevation = 4.dp,
    ) {
      Text(
        text = "Paletteon",
        fontSize = 6.sp,
        textAlign = TextAlign.Center,
      )
    }

    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 6.dp, vertical = 6.dp)
        .wrapContentHeight()
    ) {
      Text(
        text = "Toggle switch",
        fontSize = 4.sp,
        lineHeight = 4.sp,
        modifier = Modifier.weight(1f),
      )
      Box(
        modifier = Modifier
          .background(
            color = localTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(10.dp),
          )
          .height(10.dp)
          .width(20.dp)
      ) {
        Box(
          modifier = Modifier
            .padding(2.dp)
            .background(
              color = localTheme.colorScheme.primary,
              shape = CircleShape,
            )
            .aspectRatio(1f)
            .align(Alignment.CenterEnd)
        )
      }
    }
  }
}

/**
 * Displays a simple layout for a foldable device.
 *
 * @param localTheme The current theme to be used for styling.
 * @param deviceType The device type, which in this case is a Foldable.
 */
@Composable
private fun FoldableLayout(localTheme: PaletteonTheme, deviceType: DeviceType.Foldable) {
  Column(
    modifier = Modifier.fillMaxSize(),
  ) {
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .height(24.dp),
      tonalElevation = 4.dp,
    ) {
      Text(
        text = "Paletteon",
        fontSize = 6.sp,
        textAlign = TextAlign.Center,
      )
    }

    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 6.dp, vertical = 6.dp)
        .wrapContentHeight()
    ) {
      Text(
        text = "Toggle switch",
        fontSize = 4.sp,
        lineHeight = 4.sp,
        modifier = Modifier.weight(1f),
      )
      Box(
        modifier = Modifier
          .background(
            color = localTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(10.dp),
          )
          .height(10.dp)
          .width(20.dp)
      ) {
        Box(
          modifier = Modifier
            .padding(2.dp)
            .background(
              color = localTheme.colorScheme.primary,
              shape = CircleShape,
            )
            .aspectRatio(1f)
            .align(Alignment.CenterEnd)
        )
      }
    }
  }
}

/**
 * Displays a simple layout for a mobile device.
 *
 * @param localTheme The current theme to be used for styling.
 * @param deviceType The device type, which in this case is a Mobile.
 */
@Composable
private fun MobileLayout(localTheme: PaletteonTheme, deviceType: DeviceType.Mobile) {
  Column(
    modifier = Modifier.fillMaxSize(),
  ) {
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .height(24.dp),
      tonalElevation = 4.dp,
    ) {
      Text(
        text = "Paletteon",
        fontSize = 6.sp,
        textAlign = TextAlign.Center,
      )
    }

    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 6.dp, vertical = 6.dp)
        .wrapContentHeight()
    ) {
      Text(
        text = "Toggle switch",
        fontSize = 4.sp,
        lineHeight = 4.sp,
        modifier = Modifier.weight(1f),
      )
      Box(
        modifier = Modifier
          .background(
            color = localTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(10.dp),
          )
          .height(10.dp)
          .width(20.dp)
      ) {
        Box(
          modifier = Modifier
            .padding(2.dp)
            .background(
              color = localTheme.colorScheme.primary,
              shape = CircleShape,
            )
            .aspectRatio(1f)
            .align(Alignment.CenterEnd)
        )
      }
    }
  }
}

/**
 * Displays a simple layout for a TV device.
 *
 * @param localTheme The current theme to be used for styling.
 * @param deviceType The device type, which in this case is a TV.
 */
@Composable
private fun TVLayout(localTheme: PaletteonTheme, deviceType: DeviceType.TV) {
  Column(
    modifier = Modifier.fillMaxSize(),
  ) {
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .height(24.dp),
      tonalElevation = 4.dp,
    ) {
      Text(
        text = "Paletteon",
        fontSize = 6.sp,
        textAlign = TextAlign.Center,
      )
    }

    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 6.dp, vertical = 6.dp)
        .wrapContentHeight()
    ) {
      Text(
        text = "Toggle switch",
        fontSize = 4.sp,
        lineHeight = 4.sp,
        modifier = Modifier.weight(1f),
      )
      Box(
        modifier = Modifier
          .background(
            color = localTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(10.dp),
          )
          .height(10.dp)
          .width(20.dp)
      ) {
        Box(
          modifier = Modifier
            .padding(2.dp)
            .background(
              color = localTheme.colorScheme.primary,
              shape = CircleShape,
            )
            .aspectRatio(1f)
            .align(Alignment.CenterEnd)
        )
      }
    }
  }
}

/**
 * Displays a simple layout for a tablet device.
 *
 * @param localTheme The current theme to be used for styling.
 * @param deviceType The device type, which in this case is a Tablet.
 */
@Composable
private fun TabletLayout(localTheme: PaletteonTheme, deviceType: DeviceType.Tablet) {
  Column(
    modifier = Modifier.fillMaxSize(),
  ) {
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .height(24.dp),
      tonalElevation = 4.dp,
    ) {
      Text(
        text = "Paletteon",
        fontSize = 6.sp,
        textAlign = TextAlign.Center,
      )
    }

    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 6.dp, vertical = 6.dp)
        .wrapContentHeight()
    ) {
      Text(
        text = "Toggle switch",
        fontSize = 4.sp,
        lineHeight = 4.sp,
        modifier = Modifier.weight(1f),
      )
      Box(
        modifier = Modifier
          .background(
            color = localTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(10.dp),
          )
          .height(10.dp)
          .width(20.dp)
      ) {
        Box(
          modifier = Modifier
            .padding(2.dp)
            .background(
              color = localTheme.colorScheme.primary,
              shape = CircleShape,
            )
            .aspectRatio(1f)
            .align(Alignment.CenterEnd)
        )
      }
    }
  }
}

/**
 * Displays a simple layout for a watch device.
 *
 * @param localTheme The current theme to be used for styling.
 * @param deviceType The device type, which in this case is a Watch.
 */
@Composable
private fun WatchLayout(localTheme: PaletteonTheme, deviceType: DeviceType.Watch) {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .height(12.dp),
      tonalElevation = 4.dp
    ) {

    }

    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(4.dp)
    ) {
      Box(
        modifier = Modifier
          .align(Alignment.Center)
          .background(
            color = localTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(8.dp)
          )
          .width(24.dp)
          .height(12.dp)
      ) {
        Box(
          modifier = Modifier
            .padding(2.dp)
            .background(
              color = localTheme.colorScheme.primary,
              shape = CircleShape
            )
            .size(8.dp)
            .align(Alignment.CenterEnd)
        )
      }
    }
  }
}
