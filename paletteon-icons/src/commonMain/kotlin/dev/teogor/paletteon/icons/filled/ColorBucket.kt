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

public val Icons.Filled.ColorBucket: ImageVector
    get() {
        if (_colorBucket != null) {
            return _colorBucket!!
        }
        _colorBucket = Builder(name = "ColorBucket", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(21.75f, 20.25f)
                lineTo(2.25f, 20.25f)
                curveTo(1.8008f, 20.25f, 1.5f, 20.5508f, 1.5f, 21.0f)
                curveTo(1.5f, 21.4492f, 1.8008f, 21.75f, 2.25f, 21.75f)
                lineTo(21.75f, 21.75f)
                curveTo(22.1992f, 21.75f, 22.5f, 21.4492f, 22.5f, 21.0f)
                curveTo(22.5f, 20.5508f, 22.1992f, 20.25f, 21.75f, 20.25f)
                close()
                moveTo(21.75f, 20.25f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(4.8008f, 12.5234f)
                lineTo(10.0508f, 17.7734f)
                curveTo(10.1992f, 17.9258f, 10.3516f, 18.0f, 10.5742f, 18.0f)
                curveTo(10.8008f, 18.0f, 10.9492f, 17.9258f, 11.1016f, 17.7734f)
                lineTo(17.3984f, 11.4766f)
                curveTo(17.6992f, 11.1758f, 17.6992f, 10.7266f, 17.3984f, 10.4258f)
                lineTo(10.7266f, 3.6758f)
                lineTo(8.8516f, 1.8008f)
                curveTo(8.5508f, 1.5f, 8.1016f, 1.5f, 7.8008f, 1.8008f)
                curveTo(7.5f, 2.1016f, 7.5f, 2.5508f, 7.8008f, 2.8516f)
                lineTo(9.1484f, 4.1992f)
                lineTo(3.375f, 9.9766f)
                curveTo(3.0742f, 10.2734f, 3.0742f, 10.7266f, 3.375f, 11.0234f)
                close()
                moveTo(10.1992f, 5.25f)
                lineTo(10.5f, 5.625f)
                lineTo(15.75f, 10.875f)
                lineTo(15.4492f, 11.25f)
                lineTo(5.625f, 11.25f)
                lineTo(4.875f, 10.5f)
                close()
                moveTo(10.1992f, 5.25f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(18.75f, 18.0f)
                curveTo(20.0234f, 18.0f, 21.0f, 17.0234f, 21.0f, 15.75f)
                curveTo(21.0f, 14.6992f, 19.6484f, 13.3516f, 19.2734f, 12.9766f)
                curveTo(18.9766f, 12.6758f, 18.5234f, 12.6758f, 18.2266f, 12.9766f)
                curveTo(17.8516f, 13.3516f, 16.5f, 14.6992f, 16.5f, 15.75f)
                curveTo(16.5f, 17.0234f, 17.4766f, 18.0f, 18.75f, 18.0f)
                close()
                moveTo(18.75f, 18.0f)
            }
        }
        .build()
        return _colorBucket!!
    }

private var _colorBucket: ImageVector? = null
