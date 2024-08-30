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

public val Icons.Filled.Palette: ImageVector
    get() {
        if (_palette != null) {
            return _palette!!
        }
        _palette = Builder(name = "Palette", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(10.0f, 6.0f)
                lineTo(10.0f, 18.0f)
                curveTo(10.0f, 19.3984f, 10.0f, 20.1016f, 9.7266f, 20.6367f)
                curveTo(9.4883f, 21.1055f, 9.1055f, 21.4883f, 8.6367f, 21.7266f)
                curveTo(8.1016f, 22.0f, 7.3984f, 22.0f, 6.0f, 22.0f)
                curveTo(4.6016f, 22.0f, 3.8984f, 22.0f, 3.3633f, 21.7266f)
                curveTo(2.8945f, 21.4883f, 2.5117f, 21.1055f, 2.2734f, 20.6367f)
                curveTo(2.0f, 20.1016f, 2.0f, 19.3984f, 2.0f, 18.0f)
                lineTo(2.0f, 6.0f)
                curveTo(2.0f, 4.6016f, 2.0f, 3.8984f, 2.2734f, 3.3633f)
                curveTo(2.5117f, 2.8945f, 2.8945f, 2.5117f, 3.3633f, 2.2734f)
                curveTo(3.8984f, 2.0f, 4.6016f, 2.0f, 6.0f, 2.0f)
                curveTo(7.3984f, 2.0f, 8.1016f, 2.0f, 8.6367f, 2.2734f)
                curveTo(9.1055f, 2.5117f, 9.4883f, 2.8945f, 9.7266f, 3.3633f)
                curveTo(10.0f, 3.8984f, 10.0f, 4.6016f, 10.0f, 6.0f)
                close()
                moveTo(7.0f, 19.75f)
                curveTo(7.4141f, 19.75f, 7.75f, 19.4141f, 7.75f, 19.0f)
                curveTo(7.75f, 18.5859f, 7.4141f, 18.25f, 7.0f, 18.25f)
                lineTo(5.0f, 18.25f)
                curveTo(4.5859f, 18.25f, 4.25f, 18.5859f, 4.25f, 19.0f)
                curveTo(4.25f, 19.4141f, 4.5859f, 19.75f, 5.0f, 19.75f)
                close()
                moveTo(7.0f, 19.75f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(19.0586f, 10.6133f)
                lineTo(13.2227f, 16.7031f)
                curveTo(12.4922f, 17.4648f, 12.1289f, 17.8477f, 11.8125f, 17.7188f)
                curveTo(11.5f, 17.5938f, 11.5f, 17.0664f, 11.5f, 16.0117f)
                lineTo(11.5f, 7.7734f)
                curveTo(11.5f, 7.1133f, 11.7617f, 6.4805f, 12.2305f, 6.0117f)
                lineTo(13.2852f, 4.957f)
                lineTo(13.7148f, 4.6289f)
                curveTo(14.7188f, 3.8633f, 15.2188f, 3.4766f, 15.7656f, 3.3594f)
                curveTo(16.2188f, 3.2617f, 16.6875f, 3.293f, 17.1211f, 3.4453f)
                curveTo(17.6484f, 3.6289f, 18.0977f, 4.0742f, 19.0f, 4.957f)
                curveTo(20.0f, 5.957f, 20.5f, 6.457f, 20.6836f, 7.0313f)
                curveTo(20.8438f, 7.5195f, 20.8477f, 8.043f, 20.6953f, 8.5352f)
                curveTo(20.5195f, 9.1094f, 20.0313f, 9.6094f, 19.0586f, 10.6133f)
                close()
                moveTo(19.0586f, 10.6133f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.7891f, 22.0f)
                lineTo(17.8984f, 22.0f)
                curveTo(19.3008f, 22.0f, 20.0f, 22.0f, 20.5352f, 21.7266f)
                curveTo(21.0039f, 21.4883f, 21.3867f, 21.1055f, 21.625f, 20.6367f)
                curveTo(21.8984f, 20.1016f, 21.8984f, 19.3984f, 21.8984f, 18.0f)
                curveTo(21.8984f, 16.6016f, 21.8984f, 15.8984f, 21.625f, 15.3633f)
                curveTo(21.3867f, 14.8945f, 21.0039f, 14.5117f, 20.5352f, 14.2734f)
                curveTo(20.0f, 14.0f, 19.3008f, 14.0f, 17.8984f, 14.0f)
                lineTo(17.6797f, 14.0f)
                lineTo(11.8789f, 19.7969f)
                curveTo(11.6367f, 20.0391f, 11.5f, 20.3398f, 11.5f, 20.6797f)
                curveTo(11.5f, 21.3945f, 12.0781f, 22.0f, 12.7891f, 22.0f)
                close()
                moveTo(12.7891f, 22.0f)
            }
        }
        .build()
        return _palette!!
    }

private var _palette: ImageVector? = null
