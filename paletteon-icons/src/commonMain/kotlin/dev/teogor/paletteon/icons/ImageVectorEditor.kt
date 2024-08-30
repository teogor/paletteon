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

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorGroup
import androidx.compose.ui.graphics.vector.VectorNode
import androidx.compose.ui.graphics.vector.VectorPath
import androidx.compose.ui.graphics.vector.group
import dev.teogor.paletteon.PaletteonDsl

/**
 * Utility class for editing and transforming [ImageVector] instances.
 * This class provides methods to apply rotation and flipping transformations to an `ImageVector`.
 *
 * @property src The source [ImageVector] that will be edited and transformed.
 */
public class ImageVectorEditor(private val src: ImageVector) {

  private var rotation: Float = 0f
  private var scaleX: Float = 1f
  private var scaleY: Float = 1f

  /**
   * Sets a rotation transformation for the `ImageVector`.
   * This method sets the rotation angle to the specified value, replacing any previous rotation.
   *
   * @param degrees The angle of rotation as a [Degrees] enum.
   */
  public fun rotate(degrees: Degrees) {
    rotation = degrees.value
  }

  /**
   * Applies a flipping transformation to the `ImageVector`.
   * The flipping affects the image's scale along the X and/or Y axis.
   *
   * @param flip The type of flipping to apply as a [Flip] enum.
   */
  public fun flip(flip: Flip) {
    when (flip) {
      Flip.Horizontal -> scaleX *= -1f
      Flip.Vertical -> scaleY *= -1f
      Flip.HorizontalVertical -> {
        scaleX *= -1f
        scaleY *= -1f
      }
      Flip.None -> {
        scaleX = 1f
        scaleY = 1f
      }
    }
  }

  /**
   * Builds and returns a new [ImageVector] with the applied transformations.
   *
   * @return A new [ImageVector] instance reflecting the applied rotation and flipping transformations.
   */
  public fun build(): ImageVector {
    return ImageVector.Builder(
      name = src.name,
      defaultWidth = src.defaultWidth,
      defaultHeight = src.defaultHeight,
      viewportWidth = src.viewportWidth,
      viewportHeight = src.viewportHeight,
      tintColor = src.tintColor,
      tintBlendMode = src.tintBlendMode,
      autoMirror = src.autoMirror,
    ).apply {
      group(
        rotate = rotation,
        pivotX = src.defaultWidth.value / 2,
        pivotY = src.defaultHeight.value / 2,
        scaleX = scaleX,
        scaleY = scaleY
      ) {
        src.root.forEach { addNode(it) }
      }
    }.build()
  }

  private fun ImageVector.Builder.addNode(node: VectorNode) {
    when (node) {
      is VectorGroup -> addGroup(node)
      is VectorPath -> addPath(node)
    }
  }

  private fun ImageVector.Builder.addGroup(src: VectorGroup) = apply {
    group(
      name = src.name,
      rotate = src.rotation,
      pivotX = src.pivotX,
      pivotY = src.pivotY,
      scaleX = src.scaleX,
      scaleY = src.scaleY,
      translationX = src.translationX,
      translationY = src.translationY,
      clipPathData = src.clipPathData,
    ) {
      src.forEach { addNode(it) }
    }
  }

  private fun ImageVector.Builder.addPath(src: VectorPath) = apply {
    addPath(
      pathData = src.pathData,
      pathFillType = src.pathFillType,
      name = src.name,
      fill = src.fill,
      fillAlpha = src.fillAlpha,
      stroke = src.stroke,
      strokeAlpha = src.strokeAlpha,
      strokeLineWidth = src.strokeLineWidth,
      strokeLineCap = src.strokeLineCap,
      strokeLineJoin = src.strokeLineJoin,
      strokeLineMiter = src.strokeLineMiter,
    )
  }
}

/**
 * Extension function for [ImageVector] that applies a series of transformations using the [ImageVectorEditor].
 * This function provides a DSL-like syntax for applying rotations, flips, and other transformations to the vector.
 *
 * @param transform The lambda where transformations are applied to the [ImageVectorEditor].
 * @return A new [ImageVector] instance with the applied transformations.
 */
@PaletteonDsl
public fun ImageVector.applyTransformations(
  transform: ImageVectorEditor.() -> Unit,
): ImageVector {
  val editor = ImageVectorEditor(this)
  editor.transform()
  return editor.build()
}
