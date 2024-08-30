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

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.DefaultFillType
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathBuilder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public object Icons {
  /**
   * The [Filled] object contains the default set of icons used in the Paletteon library.
   * These icons are styled similarly to the baseline theme in Material Design, which is the
   * standard look for filled icons.
   */
  public object Filled

  /**
   * Alias for [Filled], the baseline icon theme.
   */
  public val Default: Filled = Filled
}

/**
 * Utility function to construct an icon in the Paletteon library with default size and
 * vector information. This function is primarily used by generated icons within the library
 * and is not intended for manual use outside of icon generation.
 *
 * @param name The name of the generated icon, typically matching the corresponding icon file.
 * @param autoMirror If true, the vector asset will automatically be mirrored for right-to-left locales.
 * @param block The builder lambda where vector paths can be defined and added to this icon.
 * @return The constructed [ImageVector] instance representing the icon.
 */
public inline fun paletteonIcon(
  name: String,
  autoMirror: Boolean = false,
  block: ImageVector.Builder.() -> ImageVector.Builder
): ImageVector = ImageVector.Builder(
  name = name,
  defaultWidth = PaletteonIconDimension.dp,
  defaultHeight = PaletteonIconDimension.dp,
  viewportWidth = PaletteonIconDimension,
  viewportHeight = PaletteonIconDimension,
  autoMirror = autoMirror
).block().build()

/**
 * Adds a vector path to this icon using the default settings for the Paletteon library.
 * This function simplifies adding paths to an icon, providing default values for path
 * properties that align with Material Design standards.
 *
 * @param fillAlpha The alpha (opacity) for the fill color of this path.
 * @param strokeAlpha The alpha (opacity) for the stroke color of this path.
 * @param pathFillType The [PathFillType] that determines how the interior of the path is calculated.
 * @param fill The [Color] used to fill the path. Default is black.
 * @param stroke The [Color] used to stroke the path. If null, no stroke is applied.
 * @param strokeLineWidth The width of the stroke for this path. Default is 1dp.
 * @param strokeLineCap The [StrokeCap] that defines the shape of the ends of lines. Default is [StrokeCap.Butt].
 * @param strokeLineJoin The [StrokeJoin] that defines the shape of the corners of paths. Default is [StrokeJoin.Bevel].
 * @param strokeLineMiter The limit for the miter join. This value is used when [strokeLineJoin] is [StrokeJoin.Miter].
 * @param pathBuilder The lambda where path commands are defined to create the desired shape.
 * @return The [ImageVector.Builder] instance to continue building the vector image.
 */
public inline fun ImageVector.Builder.paletteonPath(
  fillAlpha: Float = 1f,
  strokeAlpha: Float = 1f,
  pathFillType: PathFillType = DefaultFillType,
  fill: Color = Color.Black,
  stroke: Color? = null,
  strokeLineWidth: Float = 1f,
  strokeLineCap: StrokeCap = StrokeCap.Butt,
  strokeLineJoin: StrokeJoin = StrokeJoin.Bevel,
  strokeLineMiter: Float = 1f,
  pathBuilder: PathBuilder.() -> Unit
): ImageVector.Builder =
  path(
    fill = SolidColor(fill),
    fillAlpha = fillAlpha,
    stroke = if (stroke != null) { SolidColor(stroke) } else { null },
    strokeAlpha = strokeAlpha,
    strokeLineWidth = strokeLineWidth,
    strokeLineCap = strokeLineCap,
    strokeLineJoin = strokeLineJoin,
    strokeLineMiter = strokeLineMiter,
    pathFillType = pathFillType,
    pathBuilder = pathBuilder
  )

// All Paletteon icons are defined as 24dp by 24dp with a viewport size of 24 by 24 units.
@PublishedApi
internal const val PaletteonIconDimension: Float = 24f
