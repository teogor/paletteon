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

package dev.teogor.paletteon.icons.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import dev.teogor.paletteon.icons.Icons

public val Icons.Filled.ContrastInverse: ImageVector
    get() {
        if (_contrastInverse != null) {
            return _contrastInverse!!
        }
        _contrastInverse = Builder(name = "ContrastInverse", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.0f, 0.0f)
                curveTo(18.6289f, 0.0f, 24.0f, 5.3711f, 24.0f, 12.0f)
                curveTo(24.0f, 18.6289f, 18.6289f, 24.0f, 12.0f, 24.0f)
                curveTo(5.3711f, 24.0f, 0.0f, 18.6289f, 0.0f, 12.0f)
                curveTo(0.0f, 5.3711f, 5.3711f, 0.0f, 12.0f, 0.0f)
                close()
                moveTo(12.0f, 22.0f)
                lineTo(12.0f, 2.0f)
                curveTo(6.4766f, 2.0f, 2.0f, 6.4766f, 2.0f, 12.0f)
                curveTo(2.0f, 17.5234f, 6.4766f, 22.0f, 12.0f, 22.0f)
                close()
                moveTo(12.0f, 22.0f)
            }
        }
        .build()
        return _contrastInverse!!
    }

private var _contrastInverse: ImageVector? = null
