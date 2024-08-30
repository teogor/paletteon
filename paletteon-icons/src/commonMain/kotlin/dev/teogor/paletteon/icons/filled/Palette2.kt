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

public val Icons.Filled.Palette2: ImageVector
    get() {
        if (_palette2 != null) {
            return _palette2!!
        }
        _palette2 = Builder(name = "Palette2", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(10.8477f, 21.9336f)
                curveTo(5.8672f, 21.3633f, 2.0f, 17.1328f, 2.0f, 12.0f)
                curveTo(2.0f, 6.4766f, 6.4766f, 2.0f, 12.0f, 2.0f)
                curveTo(17.5234f, 2.0f, 22.0f, 6.4766f, 22.0f, 12.0f)
                curveTo(22.0f, 17.1563f, 18.7188f, 16.7344f, 15.9141f, 16.3711f)
                curveTo(14.2969f, 16.1602f, 12.8398f, 15.9727f, 12.2617f, 16.8867f)
                curveTo(11.8672f, 17.5117f, 12.293f, 18.293f, 12.8164f, 18.8164f)
                curveTo(13.4688f, 19.4688f, 13.4688f, 20.5313f, 12.8164f, 21.1836f)
                curveTo(12.293f, 21.707f, 11.582f, 22.0195f, 10.8477f, 21.9336f)
                close()
                moveTo(11.0859f, 7.0f)
                curveTo(11.0859f, 7.8281f, 10.4141f, 8.5f, 9.5859f, 8.5f)
                curveTo(8.7578f, 8.5f, 8.0859f, 7.8281f, 8.0859f, 7.0f)
                curveTo(8.0859f, 6.1719f, 8.7578f, 5.5f, 9.5859f, 5.5f)
                curveTo(10.4141f, 5.5f, 11.0859f, 6.1719f, 11.0859f, 7.0f)
                close()
                moveTo(6.5f, 13.0f)
                curveTo(7.3281f, 13.0f, 8.0f, 12.3281f, 8.0f, 11.5f)
                curveTo(8.0f, 10.6719f, 7.3281f, 10.0f, 6.5f, 10.0f)
                curveTo(5.6719f, 10.0f, 5.0f, 10.6719f, 5.0f, 11.5f)
                curveTo(5.0f, 12.3281f, 5.6719f, 13.0f, 6.5f, 13.0f)
                close()
                moveTo(17.5f, 13.0f)
                curveTo(18.3281f, 13.0f, 19.0f, 12.3281f, 19.0f, 11.5f)
                curveTo(19.0f, 10.6719f, 18.3281f, 10.0f, 17.5f, 10.0f)
                curveTo(16.6719f, 10.0f, 16.0f, 10.6719f, 16.0f, 11.5f)
                curveTo(16.0f, 12.3281f, 16.6719f, 13.0f, 17.5f, 13.0f)
                close()
                moveTo(14.5f, 8.5f)
                curveTo(15.3281f, 8.5f, 16.0f, 7.8281f, 16.0f, 7.0f)
                curveTo(16.0f, 6.1719f, 15.3281f, 5.5f, 14.5f, 5.5f)
                curveTo(13.6719f, 5.5f, 13.0f, 6.1719f, 13.0f, 7.0f)
                curveTo(13.0f, 7.8281f, 13.6719f, 8.5f, 14.5f, 8.5f)
                close()
                moveTo(14.5f, 8.5f)
            }
        }
        .build()
        return _palette2!!
    }

private var _palette2: ImageVector? = null
