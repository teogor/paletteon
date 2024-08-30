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

public val Icons.Filled.Pipette: ImageVector
    get() {
        if (_pipette != null) {
            return _pipette!!
        }
        _pipette = Builder(name = "Pipette", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.2422f, 5.7539f)
                lineTo(18.2461f, 13.7578f)
                curveTo(18.8516f, 14.3633f, 19.8281f, 14.3633f, 20.4297f, 13.7578f)
                curveTo(21.0313f, 13.1563f, 21.0313f, 12.1797f, 20.4297f, 11.5742f)
                lineTo(19.3398f, 10.4844f)
                lineTo(20.793f, 9.0273f)
                curveTo(22.4023f, 7.4219f, 22.4023f, 4.8125f, 20.793f, 3.207f)
                curveTo(19.1875f, 1.5977f, 16.5781f, 1.5977f, 14.9727f, 3.207f)
                lineTo(13.5156f, 4.6602f)
                lineTo(12.4258f, 3.5703f)
                curveTo(11.8203f, 2.9688f, 10.8438f, 2.9688f, 10.2422f, 3.5703f)
                curveTo(9.6367f, 4.1719f, 9.6367f, 5.1484f, 10.2422f, 5.7539f)
                close()
                moveTo(10.2422f, 5.7539f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.2734f, 7.9063f)
                lineTo(4.707f, 13.4688f)
                curveTo(4.2539f, 13.9258f, 4.0234f, 14.1523f, 3.8789f, 14.4258f)
                curveTo(3.7852f, 14.6094f, 3.7148f, 14.8047f, 3.6758f, 15.0078f)
                curveTo(3.6172f, 15.3086f, 3.6563f, 15.6289f, 3.7266f, 16.2695f)
                lineTo(3.7773f, 16.7461f)
                curveTo(3.7969f, 16.9219f, 3.8086f, 17.0078f, 3.8086f, 17.0938f)
                curveTo(3.8242f, 17.6016f, 3.6523f, 18.0977f, 3.3203f, 18.4844f)
                curveTo(3.2656f, 18.5508f, 3.207f, 18.6094f, 3.082f, 18.7344f)
                lineTo(2.4531f, 19.3633f)
                curveTo(1.8477f, 19.9688f, 1.8477f, 20.9453f, 2.4531f, 21.5469f)
                curveTo(3.0547f, 22.1523f, 4.0313f, 22.1523f, 4.6367f, 21.5469f)
                lineTo(5.2656f, 20.918f)
                curveTo(5.3906f, 20.793f, 5.4492f, 20.7305f, 5.5156f, 20.6797f)
                curveTo(5.9023f, 20.3477f, 6.3984f, 20.1758f, 6.9063f, 20.1914f)
                curveTo(6.9922f, 20.1914f, 7.0781f, 20.2031f, 7.2539f, 20.2227f)
                lineTo(7.7305f, 20.2734f)
                curveTo(8.3711f, 20.3438f, 8.6914f, 20.3828f, 8.9922f, 20.3242f)
                curveTo(9.1953f, 20.2852f, 9.3906f, 20.2148f, 9.5742f, 20.1211f)
                curveTo(9.8477f, 19.9766f, 10.0742f, 19.7461f, 10.5313f, 19.293f)
                lineTo(11.9688f, 17.8516f)
                lineTo(10.1172f, 16.0f)
                curveTo(9.8242f, 15.707f, 9.8242f, 15.2305f, 10.1172f, 14.9375f)
                curveTo(10.4102f, 14.6445f, 10.8828f, 14.6445f, 11.1758f, 14.9375f)
                lineTo(13.0313f, 16.793f)
                lineTo(13.9688f, 15.8516f)
                lineTo(12.1172f, 14.0f)
                curveTo(11.8242f, 13.707f, 11.8242f, 13.2305f, 12.1172f, 12.9375f)
                curveTo(12.4102f, 12.6445f, 12.8828f, 12.6445f, 13.1758f, 12.9375f)
                lineTo(15.0313f, 14.793f)
                lineTo(16.0938f, 13.7266f)
                close()
                moveTo(10.2734f, 7.9063f)
            }
        }
        .build()
        return _pipette!!
    }

private var _pipette: ImageVector? = null
