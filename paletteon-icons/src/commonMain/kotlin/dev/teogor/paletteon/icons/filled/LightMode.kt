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

public val Icons.Filled.LightMode: ImageVector
    get() {
        if (_lightMode != null) {
            return _lightMode!!
        }
        _lightMode = Builder(name = "LightMode", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(8.0f, 12.0f)
                curveTo(8.0f, 9.7891f, 9.7891f, 8.0f, 12.0f, 8.0f)
                curveTo(14.2109f, 8.0f, 16.0f, 9.7891f, 16.0f, 12.0f)
                curveTo(16.0f, 14.2109f, 14.2109f, 16.0f, 12.0f, 16.0f)
                curveTo(9.7891f, 16.0f, 8.0f, 14.2109f, 8.0f, 12.0f)
                close()
                moveTo(8.0f, 12.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(12.0f, 2.0f)
                curveTo(12.5508f, 2.0f, 13.0f, 2.4492f, 13.0f, 3.0f)
                lineTo(13.0f, 5.0f)
                curveTo(13.0f, 5.5508f, 12.5508f, 6.0f, 12.0f, 6.0f)
                curveTo(11.4492f, 6.0f, 11.0f, 5.5508f, 11.0f, 5.0f)
                lineTo(11.0f, 3.0f)
                curveTo(11.0f, 2.4492f, 11.4492f, 2.0f, 12.0f, 2.0f)
                close()
                moveTo(12.0f, 2.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(19.707f, 4.293f)
                curveTo(20.0977f, 4.6836f, 20.0977f, 5.3164f, 19.707f, 5.707f)
                lineTo(17.707f, 7.707f)
                curveTo(17.3164f, 8.0977f, 16.6836f, 8.0977f, 16.293f, 7.707f)
                curveTo(15.9023f, 7.3164f, 15.9023f, 6.6836f, 16.293f, 6.293f)
                lineTo(18.293f, 4.293f)
                curveTo(18.6836f, 3.9023f, 19.3164f, 3.9023f, 19.707f, 4.293f)
                close()
                moveTo(19.707f, 4.293f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(18.0f, 12.0f)
                curveTo(18.0f, 11.4492f, 18.4492f, 11.0f, 19.0f, 11.0f)
                lineTo(21.0f, 11.0f)
                curveTo(21.5508f, 11.0f, 22.0f, 11.4492f, 22.0f, 12.0f)
                curveTo(22.0f, 12.5508f, 21.5508f, 13.0f, 21.0f, 13.0f)
                lineTo(19.0f, 13.0f)
                curveTo(18.4492f, 13.0f, 18.0f, 12.5508f, 18.0f, 12.0f)
                close()
                moveTo(18.0f, 12.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(16.293f, 16.293f)
                curveTo(16.6836f, 15.9023f, 17.3164f, 15.9023f, 17.707f, 16.293f)
                lineTo(19.707f, 18.293f)
                curveTo(20.0977f, 18.6836f, 20.0977f, 19.3164f, 19.707f, 19.707f)
                curveTo(19.3164f, 20.0977f, 18.6836f, 20.0977f, 18.293f, 19.707f)
                lineTo(16.293f, 17.707f)
                curveTo(15.9023f, 17.3164f, 15.9023f, 16.6836f, 16.293f, 16.293f)
                close()
                moveTo(16.293f, 16.293f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(12.0f, 18.0f)
                curveTo(12.5508f, 18.0f, 13.0f, 18.4492f, 13.0f, 19.0f)
                lineTo(13.0f, 21.0f)
                curveTo(13.0f, 21.5508f, 12.5508f, 22.0f, 12.0f, 22.0f)
                curveTo(11.4492f, 22.0f, 11.0f, 21.5508f, 11.0f, 21.0f)
                lineTo(11.0f, 19.0f)
                curveTo(11.0f, 18.4492f, 11.4492f, 18.0f, 12.0f, 18.0f)
                close()
                moveTo(12.0f, 18.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(7.707f, 16.293f)
                curveTo(8.0977f, 16.6836f, 8.0977f, 17.3164f, 7.707f, 17.707f)
                lineTo(5.707f, 19.707f)
                curveTo(5.3164f, 20.0977f, 4.6836f, 20.0977f, 4.293f, 19.707f)
                curveTo(3.9023f, 19.3164f, 3.9023f, 18.6836f, 4.293f, 18.293f)
                lineTo(6.293f, 16.293f)
                curveTo(6.6836f, 15.9023f, 7.3164f, 15.9023f, 7.707f, 16.293f)
                close()
                moveTo(7.707f, 16.293f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(2.0f, 12.0f)
                curveTo(2.0f, 11.4492f, 2.4492f, 11.0f, 3.0f, 11.0f)
                lineTo(5.0f, 11.0f)
                curveTo(5.5508f, 11.0f, 6.0f, 11.4492f, 6.0f, 12.0f)
                curveTo(6.0f, 12.5508f, 5.5508f, 13.0f, 5.0f, 13.0f)
                lineTo(3.0f, 13.0f)
                curveTo(2.4492f, 13.0f, 2.0f, 12.5508f, 2.0f, 12.0f)
                close()
                moveTo(2.0f, 12.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(4.293f, 4.293f)
                curveTo(4.6836f, 3.9023f, 5.3164f, 3.9023f, 5.707f, 4.293f)
                lineTo(7.707f, 6.293f)
                curveTo(8.0977f, 6.6836f, 8.0977f, 7.3164f, 7.707f, 7.707f)
                curveTo(7.3164f, 8.0977f, 6.6836f, 8.0977f, 6.293f, 7.707f)
                lineTo(4.293f, 5.707f)
                curveTo(3.9023f, 5.3164f, 3.9023f, 4.6836f, 4.293f, 4.293f)
                close()
                moveTo(4.293f, 4.293f)
            }
        }
        .build()
        return _lightMode!!
    }

private var _lightMode: ImageVector? = null
