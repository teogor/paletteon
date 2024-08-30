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

public val Icons.Filled.Brightness: ImageVector
    get() {
        if (_brightness != null) {
            return _brightness!!
        }
        _brightness = Builder(name = "Brightness", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(12.0f, 2.0f)
                curveTo(6.4766f, 2.0f, 2.0f, 6.4766f, 2.0f, 12.0f)
                curveTo(2.0f, 17.5234f, 6.4766f, 22.0f, 12.0f, 22.0f)
                curveTo(17.5234f, 22.0f, 22.0f, 17.5234f, 22.0f, 12.0f)
                curveTo(22.0f, 6.4766f, 17.5234f, 2.0f, 12.0f, 2.0f)
                close()
                moveTo(15.6797f, 6.3359f)
                curveTo(16.1133f, 5.9922f, 16.1797f, 5.3633f, 15.8359f, 4.9297f)
                curveTo(15.4922f, 4.5f, 14.8633f, 4.4297f, 14.4297f, 4.7734f)
                lineTo(11.375f, 7.2188f)
                curveTo(10.9453f, 7.5625f, 10.875f, 8.1953f, 11.2188f, 8.625f)
                curveTo(11.5625f, 9.0547f, 12.1953f, 9.125f, 12.625f, 8.7813f)
                close()
                moveTo(18.7813f, 7.5742f)
                curveTo(19.125f, 8.0078f, 19.0547f, 8.6367f, 18.625f, 8.9805f)
                lineTo(12.625f, 13.7813f)
                curveTo(12.1953f, 14.125f, 11.5625f, 14.0547f, 11.2188f, 13.625f)
                curveTo(10.875f, 13.1953f, 10.9453f, 12.5625f, 11.375f, 12.2188f)
                lineTo(17.375f, 7.418f)
                curveTo(17.8047f, 7.0742f, 18.4375f, 7.1445f, 18.7813f, 7.5742f)
                close()
                moveTo(19.625f, 13.1797f)
                curveTo(20.0547f, 12.8359f, 20.125f, 12.207f, 19.7813f, 11.7734f)
                curveTo(19.4375f, 11.3438f, 18.8047f, 11.2734f, 18.375f, 11.6172f)
                lineTo(11.375f, 17.2188f)
                curveTo(10.9453f, 17.5625f, 10.875f, 18.1953f, 11.2188f, 18.625f)
                curveTo(11.5625f, 19.0547f, 12.1953f, 19.125f, 12.625f, 18.7813f)
                close()
                moveTo(19.625f, 13.1797f)
            }
        }
        .build()
        return _brightness!!
    }

private var _brightness: ImageVector? = null
