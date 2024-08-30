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

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.teogor.paletteon.icons.Icons
import dev.teogor.paletteon.icons.filled.ColorAdjustmentMode
import dev.teogor.paletteon.icons.filled.Contrast
import dev.teogor.paletteon.icons.filled.ContrastInverse
import dev.teogor.paletteon.icons.filled.DarkMode
import dev.teogor.paletteon.icons.filled.LightMode
import dev.teogor.paletteon.icons.filled.Palette
import dev.teogor.paletteon.icons.filled.Pipette
import dev.teogor.paletteon.ktx.surfaceColorAtElevation
import dev.teogor.paletteon.palettes.TonalPalette
import dev.teogor.paletteon.ui.getContainerWidthInDp
import dev.teogor.paletteon.ui.simulation.CorePalette
import dev.teogor.paletteon.ui.simulation.DeviceSimulation
import dev.teogor.paletteon.ui.simulation.DeviceType
import dev.teogor.paletteon.ui.simulation.StandardColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun ShowcaseScreen(
  insets: WindowInsets,
) {
  var paletteonThemeState by PaletteonTheme.currentState
  val scrollState = rememberLazyGridState()
  var showButtons by remember { mutableStateOf(false) }
  LaunchedEffect(scrollState.firstVisibleItemIndex) {
    showButtons = scrollState.firstVisibleItemIndex > 1
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "Paletteon",
              style = MaterialTheme.typography.titleLarge
            )
            Text(
              text = "by Teogor (Teodor G.)",
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        },
        actions = {
          if (showButtons) {
            IconButton(
              onClick = {
                paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
                  nextContrast()
                }
              },
            ) {
              Icon(
                imageVector = Icons.Filled.ColorAdjustmentMode,
                contentDescription = null,
              )
            }

            IconButton(
              onClick = {
                paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
                  nextPaletteStyle()
                }
              },
            ) {
              Icon(
                imageVector = Icons.Filled.Palette,
                contentDescription = null,
              )
            }

            IconButton(
              onClick = {
                paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
                  seedColor = StandardColors.random().color
                }
              },
            ) {
              Icon(
                imageVector = Icons.Filled.Pipette,
                contentDescription = null,
              )
            }

            if (paletteonThemeState.useDarkTheme) {
              IconButton(
                onClick = {
                  paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
                    toggleAmoled()
                  }
                },
              ) {
                Icon(
                  imageVector = if (paletteonThemeState.withAmoled) {
                    Icons.Filled.Contrast
                  } else {
                    Icons.Filled.ContrastInverse
                  },
                  contentDescription = null,
                )
              }
            }

            IconButton(
              onClick = {
                paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
                  toggleDarkTheme()
                }
              }
            ) {
              val icon = if (paletteonThemeState.useDarkTheme) {
                Icons.Filled.LightMode
              } else {
                Icons.Filled.DarkMode
              }
              Icon(icon, contentDescription = null)
            }
          }
        }
      )
    },
    content = { paddingValues ->
      Column(
        Modifier
          .padding(paddingValues)
          .padding(insets.asPaddingValues())
          .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        ShowcaseScreenContent(
          scrollState,
          insets,
        )
      }
    }
  )
}

@Composable
private fun ShowcaseScreenContent(
  scrollState: LazyGridState,
  insets: WindowInsets,
) {
  var paletteonThemeState by PaletteonTheme.currentState

  val colorSchemePairs = colorSchemePairs()

  Column(
    Modifier
      .padding(insets.asPaddingValues())
      .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

    LazyVerticalGrid(
      state = scrollState,
      columns = if (getContainerWidthInDp() < 800.dp) {
        GridCells.Adaptive(minSize = 200.dp)
      } else {
        GridCells.Fixed(4)
      },
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier
        .fillMaxWidth()
    ) {
      colorPalettePreview(
        currentSeedColor = paletteonThemeState.seedColor,
        onColorSelected = { newColor ->
          paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
            seedColor = newColor
          }
        }
      )

      themeConfigurator(
        isDarkMode = paletteonThemeState.useDarkTheme,
        onToggleDarkMode = { isOn ->
          paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
            useDarkTheme = isOn
          }
        },
        isAmoledMode = paletteonThemeState.withAmoled,
        onToggleAmoledMode = { isOn ->
          paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
            withAmoled = isOn
          }
        },
        currentStyle = paletteonThemeState.style,
        onStyleSelected = { newStyle ->
          paletteonThemeState = configurePaletteonTheme(paletteonThemeState) {
            style = newStyle
          }
        }
      )

      divider()

      iconsGallery()

      divider()

      colorRolesGallery(colorSchemePairs = colorSchemePairs)

      divider()

      playgrounds()
    }
  }
}

private fun LazyGridScope.iconsGallery() {
  item(
    span = {
      GridItemSpan(maxLineSpan)
    }
  ) {
    Text(text = "Icons", fontSize = 20.sp)
  }

  items(PaletteonIcons.AllIcons) { icon ->
    IconItem(icon)
  }
}

@Composable
private fun IconItem(icon: ImageVector) {
  val tonalElevation = 1.dp
  val color = MaterialTheme.colorScheme.surface
  val absoluteElevation = LocalAbsoluteTonalElevation.current + tonalElevation
  val colorScheme = MaterialTheme.colorScheme

  val shape = remember { RoundedCornerShape(10.dp) }
  Column(
    modifier = Modifier
      .background(
        color = surfaceColorAtElevation(
          color = color,
          elevation = absoluteElevation
        ),
        shape = shape
      )
      .padding(vertical = 6.dp, horizontal = 4.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(4.dp)
  ) {
    Text(
      text = icon.name,
      fontSize = 12.sp,
      color = colorScheme.onSurface,
    )
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      Icon(
        modifier = Modifier
          .clip(shape)
          .background(
            color = colorScheme.primaryContainer,
            shape = shape
          )
          .clickable { }
          .size(40.dp)
          .padding(8.dp),
        imageVector = icon,
        contentDescription = null,
        tint = colorScheme.onPrimaryContainer
      )
      Icon(
        modifier = Modifier
          .clip(shape)
          .background(
            color = colorScheme.onPrimary,
            shape = shape
          )
          .clickable { }
          .size(40.dp)
          .padding(8.dp),
        imageVector = icon,
        contentDescription = null,
        tint = colorScheme.primary
      )
    }
  }
}

private fun LazyGridScope.colorPalettePreview(
  currentSeedColor: Color,
  onColorSelected: (Color) -> Unit
): Unit = item(
  span = {
    GridItemSpan(maxLineSpan)
  }
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      Text(modifier = Modifier.weight(1f), text = "Color Preview", fontSize = 20.sp)

      Text(text = "Selected:", fontSize = 20.sp)
      Box(
        modifier = Modifier
          .size(height = 32.dp, width = 60.dp)
          .clip(MaterialTheme.shapes.medium)
          .background(currentSeedColor)
      )
    }

    val theme = PaletteonTheme.current
    val colors = CorePalette()

    val device = rememberSaveable {
      listOf(
        DeviceType.TV(),
        DeviceType.Mobile(),
        DeviceType.Watch(),
        DeviceType.Desktop(),
        DeviceType.Tablet(),
        DeviceType.Foldable(),
      ).random()
    }

    device.let { deviceType ->
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState())
          .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        colors.forEach { colorEntry ->
          DeviceSimulation(
            color = colorEntry.color,
            useDarkTheme = theme.useDarkTheme,
            style = theme.style,
            contrast = theme.contrast,
            selectedColor = currentSeedColor,
            onColorSelected = onColorSelected,
            deviceType = deviceType,
            selectedStateIndicator = { isSelected ->
              if (isSelected) {
                Icon(
                  modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(
                      color = MaterialTheme.colorScheme.successContainer,
                      shape = CircleShape,
                    )
                    .padding(6.dp)
                    .size(16.dp),
                  imageVector = androidx.compose.material.icons.Icons.Filled.Check,
                  tint = MaterialTheme.colorScheme.onSuccessContainer,
                  contentDescription = null
                )
              }
            }
          )
        }
      }
    }
  }
}

private fun LazyGridScope.themeConfigurator(
  isDarkMode: Boolean,
  onToggleDarkMode: (Boolean) -> Unit,
  isAmoledMode: Boolean,
  onToggleAmoledMode: (Boolean) -> Unit,
  currentStyle: PaletteStyle,
  onStyleSelected: (PaletteStyle) -> Unit,
): Unit = item(
  span = {
    GridItemSpan(maxLineSpan)
  }
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Row(
      modifier = Modifier
        .weight(1f)
        .horizontalScroll(rememberScrollState()),
      horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
      PaletteStyle.entries.forEach { paletteStyle ->
        FilterChip(
          label = { Text(text = paletteStyle.name) },
          selected = currentStyle == paletteStyle,
          onClick = {
            onStyleSelected(paletteStyle)
          },
        )
      }
    }
    if (isDarkMode) {
      Icon(
        modifier = Modifier
          .clip(RoundedCornerShape(10.dp))
          .background(
            color = MaterialTheme.colorScheme.secondary,
            shape = RoundedCornerShape(10.dp),
          )
          .clickable {
            onToggleAmoledMode(!isAmoledMode)
          }
          .size(30.dp)
          .padding(4.dp),
        tint = MaterialTheme.colorScheme.onSecondary,
        imageVector = if (isAmoledMode) {
          Icons.Filled.Contrast
        } else {
          Icons.Filled.ContrastInverse
        },
        contentDescription = null
      )
    }
    Icon(
      modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .background(
          color = MaterialTheme.colorScheme.secondary,
          shape = RoundedCornerShape(10.dp),
        )
        .clickable {
          onToggleDarkMode(!isDarkMode)
        }
        .size(30.dp)
        .padding(4.dp),
      tint = MaterialTheme.colorScheme.onSecondary,
      imageVector = if (isDarkMode) {
        Icons.Filled.LightMode
      } else {
        Icons.Filled.DarkMode
      },
      contentDescription = null
    )
  }
}

private fun LazyGridScope.divider() = item(
  span = {
    GridItemSpan(maxLineSpan)
  }
) {
  HorizontalDivider(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 4.dp, vertical = 6.dp),
  )
}

private fun LazyGridScope.colorRolesGallery(
  colorSchemePairs: List<Pair<String, Pair<Color, Color>>>
) {
  item(
    span = {
      GridItemSpan(maxLineSpan)
    }
  ) {
    Text(text = "Color Roles", fontSize = 20.sp)
  }

  items(colorSchemePairs) { (name, colors) ->
    val (color, onColor) = colors
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(color)
        .clickable { },
      contentAlignment = Alignment.Center,
    ) {
      Text(
        text = name,
        color = onColor,
      )
    }
  }
}

@Composable
private fun colorSchemePairs(): List<Pair<String, Pair<Color, Color>>> = listOf(
  "Primary" to (colorScheme.primary to colorScheme.onPrimary),
  "OnPrimary" to (colorScheme.onPrimary to colorScheme.primary),
  "PrimaryContainer" to (colorScheme.primaryContainer to colorScheme.onPrimaryContainer),
  "OnPrimaryContainer" to (colorScheme.onPrimaryContainer to colorScheme.primaryContainer),

  "Secondary" to (colorScheme.secondary to colorScheme.onSecondary),
  "OnSecondary" to (colorScheme.onSecondary to colorScheme.secondary),
  "SecondaryContainer" to (colorScheme.secondaryContainer to colorScheme.onSecondaryContainer),
  "OnSecondaryContainer" to (colorScheme.onSecondaryContainer to colorScheme.secondaryContainer),

  "Tertiary" to (colorScheme.tertiary to colorScheme.onTertiary),
  "OnTertiary" to (colorScheme.onTertiary to colorScheme.tertiary),
  "TertiaryContainer" to (colorScheme.tertiaryContainer to colorScheme.onTertiaryContainer),
  "OnTertiaryContainer" to (colorScheme.onTertiaryContainer to colorScheme.tertiaryContainer),

  "Success" to (colorScheme.success to colorScheme.onSuccess),
  "OnSuccess" to (colorScheme.onSuccess to colorScheme.success),
  "SuccessContainer" to (colorScheme.successContainer to colorScheme.onSuccessContainer),
  "OnSuccessContainer" to (colorScheme.onSuccessContainer to colorScheme.successContainer),

  "Warning" to (colorScheme.warning to colorScheme.onWarning),
  "OnWarning" to (colorScheme.onWarning to colorScheme.warning),
  "WarningContainer" to (colorScheme.warningContainer to colorScheme.onWarningContainer),
  "OnWarningContainer" to (colorScheme.onWarningContainer to colorScheme.warningContainer),

  "Error" to (colorScheme.error to colorScheme.onError),
  "OnError" to (colorScheme.onError to colorScheme.error),
  "ErrorContainer" to (colorScheme.errorContainer to colorScheme.onErrorContainer),
  "OnErrorContainer" to (colorScheme.onErrorContainer to colorScheme.errorContainer),

  "Background" to (colorScheme.background to colorScheme.onBackground),
  "OnBackground" to (colorScheme.onBackground to colorScheme.background),

  "Surface" to (colorScheme.surface to colorScheme.onSurface),
  "OnSurface" to (colorScheme.onSurface to colorScheme.surface),
  "SurfaceVariant" to (colorScheme.surfaceVariant to colorScheme.onSurfaceVariant),
  "OnSurfaceVariant" to (colorScheme.onSurfaceVariant to colorScheme.surfaceVariant),
)

private fun LazyGridScope.playgrounds() = item(
  span = {
    GridItemSpan(maxLineSpan)
  }
) {
  // State to manage hue and chroma
  val hue = remember { mutableStateOf(0f) }  // Hue ranges from 0 to 360
  val chroma = remember { mutableStateOf(84f) }  // Chroma range can be adjusted as needed

  // UI to display and control hue and chroma
  Column(
    verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    Text(text = "Adjust Hue and Chroma", fontSize = 20.sp)

    // SeekBar for Hue
    Text(text = "Hue: ${hue.value.toInt()}")
    Slider(
      value = hue.value,
      onValueChange = { hue.value = it },
      valueRange = 0f..360f,
      modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
    )

    // SeekBar for Chroma
    Text(text = "Chroma: ${chroma.value.toInt()}")
    Slider(
      value = chroma.value,
      onValueChange = { chroma.value = it },
      valueRange = 0f..100f,
      modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
    )

    val errorPalette = TonalPalette.fromHueAndChroma(
      hue = ensureRedHue(hue.value.toDouble()),
      chroma = chroma.value.toDouble(),
    )
    val successPalette = TonalPalette.fromHueAndChroma(
      hue = ensureGreenHue(hue.value.toDouble()),
      chroma = chroma.value.toDouble(),
    )
    val warningPalette = TonalPalette.fromHueAndChroma(
      hue = ensureWarningHue(hue.value.toDouble()),
      chroma = chroma.value.toDouble(),
    )

    val recommendedTones = listOf(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 95, 99, 100)
    Row(
      modifier = Modifier.fillMaxWidth(),
    ) {
      recommendedTones.forEachIndexed { index, tone ->
        val color = Color(successPalette.tone(tone))
        val shape = when (index) {
          0 -> RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
          recommendedTones.lastIndex -> RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
          else -> RoundedCornerShape(0.dp)
        }
        Box(
          modifier = Modifier
            .background(Color.Unspecified, shape = shape)
            .border(
              width = 1.dp,
              color = MaterialTheme.colorScheme.outline,
              shape = shape
            )
            .height(100.dp)
            .weight(1f)
        ) {
          Text(
            text = "$tone",
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Center),
          )
        }
      }
    }
    Row(
      modifier = Modifier.fillMaxWidth(),
    ) {
      recommendedTones.forEachIndexed { index, tone ->
        val color = Color(successPalette.tone(tone))
        val shape = when (index) {
          0 -> RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
          recommendedTones.lastIndex -> RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
          else -> RoundedCornerShape(0.dp)
        }
        Box(
          modifier = Modifier
            .background(color, shape = shape)
            .height(100.dp)
            .weight(1f)
        )
      }
    }
    Row(
      modifier = Modifier.fillMaxWidth(),
    ) {
      recommendedTones.forEachIndexed { index, tone ->
        val color = Color(warningPalette.tone(tone))
        val shape = when (index) {
          0 -> RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
          recommendedTones.lastIndex -> RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
          else -> RoundedCornerShape(0.dp)
        }
        Box(
          modifier = Modifier
            .background(color, shape = shape)
            .height(100.dp)
            .weight(1f)
        )
      }
    }
    Row(
      modifier = Modifier.fillMaxWidth(),
    ) {
      recommendedTones.forEachIndexed { index, tone ->
        val color = Color(errorPalette.tone(tone))
        val shape = when (index) {
          0 -> RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
          recommendedTones.lastIndex -> RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
          else -> RoundedCornerShape(0.dp)
        }
        Box(
          modifier = Modifier
            .background(color, shape = shape)
            .height(100.dp)
            .weight(1f)
        )
      }
    }
  }
}

private fun ensureRedHue(hue: Double): Double {
  return when {
    hue < 350.0 -> 0.0
    hue > 10.0 -> 0.0
    else -> hue
  }
}

private fun ensureGreenHue(hue: Double): Double {
  return when {
    hue < 90.0 -> 120.0
    hue > 150.0 -> 120.0
    else -> hue
  }
}

private fun ensureWarningHue(hue: Double): Double {
  return when {
    hue < 30.0 -> 45.0
    hue > 60.0 -> 45.0
    else -> hue
  }
}
