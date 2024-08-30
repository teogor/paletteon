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
import dev.teogor.paletteon.icons.Icons.Filled

public val Icons.Filled.Animation: ImageVector
    get() {
        if (_animation != null) {
            return _animation!!
        }
        _animation = Builder(name = "Animation", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(2.332f, 15.8477f)
                curveTo(1.0469f, 17.5938f, 1.2734f, 20.0313f, 2.8672f, 21.5117f)
                curveTo(4.457f, 22.9883f, 6.9023f, 23.0391f, 8.5547f, 21.625f)
                curveTo(5.5156f, 21.1055f, 3.0781f, 18.8359f, 2.332f, 15.8477f)
                close()
                moveTo(2.332f, 15.8477f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(5.1211f, 9.6875f)
                curveTo(2.8516f, 12.1953f, 2.9258f, 16.0352f, 5.293f, 18.4531f)
                curveTo(7.6563f, 20.8711f, 11.4961f, 21.0313f, 14.0547f, 18.8203f)
                curveTo(9.1484f, 18.5742f, 5.2578f, 14.5977f, 5.1211f, 9.6875f)
                close()
                moveTo(5.1211f, 9.6875f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.5195f, 1.332f)
                curveTo(18.9805f, 1.332f, 22.5977f, 4.9453f, 22.6016f, 9.4063f)
                curveTo(22.6055f, 13.8672f, 18.9922f, 17.4844f, 14.5352f, 17.4922f)
                curveTo(10.0742f, 17.5f, 6.4492f, 13.8945f, 6.4414f, 9.4336f)
                curveTo(6.4336f, 7.2852f, 7.2852f, 5.2266f, 8.8008f, 3.707f)
                curveTo(10.3164f, 2.1875f, 12.375f, 1.332f, 14.5195f, 1.332f)
            }
        }
        .build()
        return _animation!!
    }

private var _animation: ImageVector? = null
