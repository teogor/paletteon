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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import dev.teogor.paletteon.icons.Icons

public val Icons.Filled.BulbOff: ImageVector
    get() {
        if (_bulbOff != null) {
            return _bulbOff!!
        }
        _bulbOff = Builder(name = "BulbOff", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(12.0f, 6.0f)
                curveTo(8.6875f, 6.0f, 6.0f, 8.6875f, 6.0f, 12.0f)
                curveTo(6.0f, 13.6328f, 6.6523f, 15.1172f, 7.7109f, 16.1953f)
                curveTo(7.9805f, 16.4688f, 8.125f, 16.7227f, 8.168f, 16.9453f)
                lineTo(8.6992f, 19.5898f)
                curveTo(8.9766f, 20.9922f, 10.2109f, 22.0f, 11.6406f, 22.0f)
                lineTo(12.3594f, 22.0f)
                curveTo(13.7891f, 22.0f, 15.0234f, 20.9922f, 15.3008f, 19.5898f)
                lineTo(15.832f, 16.9453f)
                curveTo(15.875f, 16.7227f, 16.0195f, 16.4688f, 16.2891f, 16.1953f)
                curveTo(17.3477f, 15.1172f, 18.0f, 13.6328f, 18.0f, 12.0f)
                curveTo(18.0f, 8.6875f, 15.3125f, 6.0f, 12.0f, 6.0f)
                close()
                moveTo(11.0f, 16.0f)
                curveTo(10.4492f, 16.0f, 10.0f, 16.4492f, 10.0f, 17.0f)
                curveTo(10.0f, 17.5508f, 10.4492f, 18.0f, 11.0f, 18.0f)
                lineTo(13.0f, 18.0f)
                curveTo(13.5508f, 18.0f, 14.0f, 17.5508f, 14.0f, 17.0f)
                curveTo(14.0f, 16.4492f, 13.5508f, 16.0f, 13.0f, 16.0f)
                close()
                moveTo(11.0f, 16.0f)
            }
        }
        .build()
        return _bulbOff!!
    }

private var _bulbOff: ImageVector? = null
