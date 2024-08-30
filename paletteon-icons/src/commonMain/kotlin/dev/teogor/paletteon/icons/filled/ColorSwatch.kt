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

public val Icons.Filled.ColorSwatch: ImageVector
    get() {
        if (_colorSwatch != null) {
            return _colorSwatch!!
        }
        _colorSwatch = Builder(name = "ColorSwatch", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(20.668f, 13.6602f)
                curveTo(21.0117f, 13.3164f, 21.5898f, 13.3359f, 21.7773f, 13.7813f)
                curveTo(21.9219f, 14.1289f, 22.0f, 14.5078f, 22.0f, 14.9023f)
                lineTo(22.0f, 17.6992f)
                curveTo(22.0f, 18.293f, 22.0f, 18.8008f, 21.9609f, 19.2188f)
                curveTo(21.9219f, 19.6602f, 21.832f, 20.0977f, 21.5938f, 20.5078f)
                curveTo(21.332f, 20.957f, 20.957f, 21.332f, 20.5078f, 21.5938f)
                curveTo(20.0977f, 21.832f, 19.6602f, 21.9219f, 19.2188f, 21.9609f)
                curveTo(18.8008f, 22.0f, 18.293f, 22.0f, 17.6992f, 22.0f)
                lineTo(13.2891f, 22.0f)
                curveTo(12.9609f, 22.0f, 12.7773f, 21.5508f, 13.0117f, 21.3164f)
                close()
                moveTo(20.668f, 13.6602f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.957f, 5.0f)
                curveTo(12.9219f, 4.5234f, 13.0664f, 4.0313f, 13.4336f, 3.7227f)
                curveTo(13.5117f, 3.6563f, 13.5898f, 3.5938f, 13.668f, 3.5352f)
                curveTo(14.1953f, 3.1328f, 14.7813f, 2.8281f, 15.5f, 2.8281f)
                curveTo(16.2227f, 2.8281f, 16.8047f, 3.1328f, 17.332f, 3.5352f)
                curveTo(17.8203f, 3.9063f, 18.3633f, 4.4492f, 18.9883f, 5.0742f)
                lineTo(19.9258f, 6.0117f)
                curveTo(20.5508f, 6.6367f, 21.0938f, 7.1797f, 21.4648f, 7.668f)
                curveTo(21.8672f, 8.1953f, 22.1719f, 8.7773f, 22.1719f, 9.5f)
                curveTo(22.1719f, 10.2188f, 21.8672f, 10.8047f, 21.4648f, 11.332f)
                curveTo(21.0938f, 11.8203f, 20.5508f, 12.3633f, 19.9258f, 12.9883f)
                lineTo(13.5938f, 19.3203f)
                curveTo(13.3672f, 19.5469f, 12.9336f, 19.3164f, 12.957f, 19.0f)
                curveTo(13.0f, 18.4258f, 13.0f, 17.7773f, 13.0f, 17.1172f)
                lineTo(13.0f, 13.7031f)
                curveTo(13.0f, 11.4453f, 13.0f, 9.1914f, 13.0f, 6.9336f)
                lineTo(13.0f, 6.8828f)
                curveTo(13.0f, 6.2227f, 13.0f, 5.5742f, 12.957f, 5.0f)
                close()
                moveTo(12.957f, 5.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(12.0f, 6.9336f)
                curveTo(12.0f, 10.3125f, 12.0f, 13.6875f, 12.0f, 17.0664f)
                curveTo(12.0f, 17.9531f, 12.0f, 18.7148f, 11.918f, 19.3281f)
                curveTo(11.8281f, 19.9844f, 11.6328f, 20.6133f, 11.1211f, 21.1211f)
                curveTo(10.6133f, 21.6328f, 9.9844f, 21.8281f, 9.3281f, 21.918f)
                curveTo(8.5586f, 22.0195f, 7.7734f, 22.0f, 7.0f, 22.0f)
                curveTo(6.2266f, 22.0f, 5.4414f, 22.0195f, 4.6719f, 21.918f)
                curveTo(4.0156f, 21.8281f, 3.3867f, 21.6328f, 2.8789f, 21.1211f)
                curveTo(2.3672f, 20.6133f, 2.1719f, 19.9844f, 2.082f, 19.3281f)
                curveTo(2.0f, 18.7148f, 2.0f, 17.9531f, 2.0f, 17.0664f)
                lineTo(2.0f, 6.9336f)
                curveTo(2.0f, 6.0469f, 2.0f, 5.2852f, 2.082f, 4.6719f)
                curveTo(2.1719f, 4.0156f, 2.3672f, 3.3867f, 2.8789f, 2.8789f)
                curveTo(3.3867f, 2.3672f, 4.0156f, 2.1719f, 4.6719f, 2.082f)
                curveTo(5.3008f, 1.9961f, 6.0859f, 2.0f, 7.0f, 2.0f)
                curveTo(7.7695f, 2.0f, 8.5625f, 1.9805f, 9.3281f, 2.082f)
                curveTo(9.9844f, 2.1719f, 10.6133f, 2.3672f, 11.1211f, 2.8789f)
                curveTo(11.6328f, 3.3867f, 11.8281f, 4.0156f, 11.918f, 4.6719f)
                curveTo(12.0f, 5.2852f, 12.0f, 6.0469f, 12.0f, 6.9336f)
                close()
                moveTo(7.0f, 18.0117f)
                curveTo(6.4492f, 18.0117f, 6.0f, 17.5625f, 6.0f, 17.0117f)
                lineTo(6.0f, 17.0f)
                curveTo(6.0f, 16.4492f, 6.4492f, 16.0f, 7.0f, 16.0f)
                curveTo(7.5508f, 16.0f, 8.0f, 16.4492f, 8.0f, 17.0f)
                lineTo(8.0f, 17.0117f)
                curveTo(8.0f, 17.5625f, 7.5508f, 18.0117f, 7.0f, 18.0117f)
                close()
                moveTo(7.0f, 18.0117f)
            }
        }
        .build()
        return _colorSwatch!!
    }

private var _colorSwatch: ImageVector? = null
