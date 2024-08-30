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

public val Icons.Filled.Filters: ImageVector
    get() {
        if (_filters != null) {
            return _filters!!
        }
        _filters = Builder(name = "Filters", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(18.0f, 8.0f)
                curveTo(18.0f, 11.3125f, 15.3125f, 14.0f, 12.0f, 14.0f)
                curveTo(8.6875f, 14.0f, 6.0f, 11.3125f, 6.0f, 8.0f)
                curveTo(6.0f, 4.6875f, 8.6875f, 2.0f, 12.0f, 2.0f)
                curveTo(15.3125f, 2.0f, 18.0f, 4.6875f, 18.0f, 8.0f)
                close()
                moveTo(18.0f, 8.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(5.0352f, 10.7852f)
                curveTo(3.2227f, 11.8164f, 2.0f, 13.7656f, 2.0f, 16.0f)
                curveTo(2.0f, 19.3125f, 4.6875f, 22.0f, 8.0f, 22.0f)
                curveTo(11.3125f, 22.0f, 14.0f, 19.3125f, 14.0f, 16.0f)
                curveTo(14.0f, 15.7422f, 13.9844f, 15.4922f, 13.9531f, 15.2422f)
                curveTo(13.332f, 15.4102f, 12.6758f, 15.5f, 12.0f, 15.5f)
                curveTo(8.8398f, 15.5f, 6.1406f, 13.5469f, 5.0352f, 10.7852f)
                close()
                moveTo(5.0352f, 10.7852f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.3867f, 14.6953f)
                curveTo(15.4609f, 15.1172f, 15.5f, 15.5547f, 15.5f, 16.0f)
                curveTo(15.5f, 18.0898f, 14.6445f, 19.9805f, 13.2656f, 21.3398f)
                curveTo(14.0859f, 21.7617f, 15.0156f, 22.0f, 16.0f, 22.0f)
                curveTo(19.3125f, 22.0f, 22.0f, 19.3125f, 22.0f, 16.0f)
                curveTo(22.0f, 13.7656f, 20.7773f, 11.8164f, 18.9648f, 10.7852f)
                curveTo(18.2891f, 12.4805f, 17.0078f, 13.8711f, 15.3867f, 14.6953f)
                close()
                moveTo(15.3867f, 14.6953f)
            }
        }
        .build()
        return _filters!!
    }

private var _filters: ImageVector? = null
