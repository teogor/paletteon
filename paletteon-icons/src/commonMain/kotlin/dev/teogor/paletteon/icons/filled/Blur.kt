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

public val Icons.Filled.Blur: ImageVector
    get() {
        if (_blur != null) {
            return _blur!!
        }
        _blur = Builder(name = "Blur", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(2.0f, 12.0f)
                curveTo(2.0f, 6.4766f, 6.4766f, 2.0f, 12.0f, 2.0f)
                curveTo(17.5234f, 2.0f, 22.0f, 6.4766f, 22.0f, 12.0f)
                curveTo(22.0f, 17.5234f, 17.5234f, 22.0f, 12.0f, 22.0f)
                curveTo(6.4766f, 22.0f, 2.0f, 17.5234f, 2.0f, 12.0f)
                close()
                moveTo(13.0f, 6.0f)
                curveTo(13.0f, 5.4492f, 13.4492f, 5.0f, 14.0f, 5.0f)
                lineTo(16.0f, 5.0f)
                curveTo(16.5508f, 5.0f, 17.0f, 5.4492f, 17.0f, 6.0f)
                curveTo(17.0f, 6.5508f, 16.5508f, 7.0f, 16.0f, 7.0f)
                lineTo(14.0f, 7.0f)
                curveTo(13.4492f, 7.0f, 13.0f, 6.5508f, 13.0f, 6.0f)
                close()
                moveTo(14.0f, 9.0f)
                curveTo(13.4492f, 9.0f, 13.0f, 9.4492f, 13.0f, 10.0f)
                curveTo(13.0f, 10.5508f, 13.4492f, 11.0f, 14.0f, 11.0f)
                lineTo(19.0f, 11.0f)
                curveTo(19.5508f, 11.0f, 20.0f, 10.5508f, 20.0f, 10.0f)
                curveTo(20.0f, 9.4492f, 19.5508f, 9.0f, 19.0f, 9.0f)
                close()
                moveTo(13.0f, 14.0f)
                curveTo(13.0f, 13.4492f, 13.4492f, 13.0f, 14.0f, 13.0f)
                lineTo(19.0f, 13.0f)
                curveTo(19.5508f, 13.0f, 20.0f, 13.4492f, 20.0f, 14.0f)
                curveTo(20.0f, 14.5508f, 19.5508f, 15.0f, 19.0f, 15.0f)
                lineTo(14.0f, 15.0f)
                curveTo(13.4492f, 15.0f, 13.0f, 14.5508f, 13.0f, 14.0f)
                close()
                moveTo(14.0f, 17.0f)
                curveTo(13.4492f, 17.0f, 13.0f, 17.4492f, 13.0f, 18.0f)
                curveTo(13.0f, 18.5508f, 13.4492f, 19.0f, 14.0f, 19.0f)
                lineTo(16.0f, 19.0f)
                curveTo(16.5508f, 19.0f, 17.0f, 18.5508f, 17.0f, 18.0f)
                curveTo(17.0f, 17.4492f, 16.5508f, 17.0f, 16.0f, 17.0f)
                close()
                moveTo(14.0f, 17.0f)
            }
        }
        .build()
        return _blur!!
    }

private var _blur: ImageVector? = null
