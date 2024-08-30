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
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import dev.teogor.paletteon.icons.Icons

public val Icons.Filled.PaletteRound: ImageVector
    get() {
        if (_paletteRound != null) {
            return _paletteRound!!
        }
        _paletteRound = Builder(name = "PaletteRound", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(17.8984f, 22.0f)
                curveTo(20.1094f, 22.0f, 21.8984f, 20.2109f, 21.8984f, 18.0f)
                curveTo(21.8984f, 15.7891f, 20.1094f, 14.0f, 17.8984f, 14.0f)
                lineTo(17.6797f, 14.0f)
                lineTo(11.8789f, 19.7969f)
                curveTo(11.6367f, 20.0391f, 11.5f, 20.3398f, 11.5f, 20.6797f)
                curveTo(11.5f, 21.3945f, 12.0781f, 22.0f, 12.7891f, 22.0f)
                close()
                moveTo(17.8984f, 22.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(13.2852f, 4.957f)
                lineTo(12.2305f, 6.0117f)
                curveTo(11.7617f, 6.4805f, 11.5f, 7.1133f, 11.5f, 7.7734f)
                lineTo(11.5f, 16.0117f)
                curveTo(11.5f, 17.0664f, 11.5f, 17.5938f, 11.8125f, 17.7188f)
                curveTo(12.1289f, 17.8477f, 12.4922f, 17.4648f, 13.2227f, 16.7031f)
                lineTo(19.0586f, 10.6133f)
                curveTo(20.582f, 9.0273f, 20.5547f, 6.5156f, 19.0f, 4.957f)
                curveTo(17.4219f, 3.3789f, 14.8633f, 3.3789f, 13.2852f, 4.957f)
                close()
                moveTo(13.2852f, 4.957f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(10.0f, 6.0f)
                lineTo(10.0f, 18.0f)
                curveTo(10.0f, 20.2109f, 8.2109f, 22.0f, 6.0f, 22.0f)
                curveTo(3.7891f, 22.0f, 2.0f, 20.2109f, 2.0f, 18.0f)
                lineTo(2.0f, 6.0f)
                curveTo(2.0f, 3.7891f, 3.7891f, 2.0f, 6.0f, 2.0f)
                curveTo(8.2109f, 2.0f, 10.0f, 3.7891f, 10.0f, 6.0f)
                close()
                moveTo(6.0f, 19.0f)
                curveTo(6.5508f, 19.0f, 7.0f, 18.5508f, 7.0f, 18.0f)
                curveTo(7.0f, 17.4492f, 6.5508f, 17.0f, 6.0f, 17.0f)
                curveTo(5.4492f, 17.0f, 5.0f, 17.4492f, 5.0f, 18.0f)
                curveTo(5.0f, 18.5508f, 5.4492f, 19.0f, 6.0f, 19.0f)
                close()
                moveTo(6.0f, 19.0f)
            }
        }
        .build()
        return _paletteRound!!
    }

private var _paletteRound: ImageVector? = null
