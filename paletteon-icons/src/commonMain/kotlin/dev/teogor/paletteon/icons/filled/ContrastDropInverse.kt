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

public val Icons.Filled.ContrastDropInverse: ImageVector
    get() {
        if (_contrastDropInverse != null) {
            return _contrastDropInverse!!
        }
        _contrastDropInverse = Builder(name = "ContrastDropInverse", defaultWidth = 24.0.dp,
                defaultHeight = 24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(5.6367f, 6.6367f)
                lineTo(12.0f, 0.2734f)
                lineTo(18.3633f, 6.6367f)
                curveTo(21.8789f, 10.1523f, 21.8789f, 15.8477f, 18.3633f, 19.3633f)
                curveTo(14.8477f, 22.8789f, 9.1523f, 22.8789f, 5.6367f, 19.3633f)
                curveTo(2.1211f, 15.8477f, 2.1211f, 10.1523f, 5.6367f, 6.6367f)
                close()
                moveTo(7.0508f, 8.0508f)
                curveTo(5.0469f, 10.0508f, 4.4492f, 13.0664f, 5.5313f, 15.6797f)
                curveTo(6.6172f, 18.2969f, 9.1719f, 20.0f, 12.0039f, 20.0f)
                lineTo(12.0f, 3.1016f)
                close()
                moveTo(7.0508f, 8.0508f)
            }
        }
        .build()
        return _contrastDropInverse!!
    }

private var _contrastDropInverse: ImageVector? = null
