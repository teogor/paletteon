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

@file:Suppress("unused")

package dev.teogor.paletteon.utils

import kotlin.math.pow

/**
 * Returns the result of raising the [base] to the power of [exponent] for `Double` values.
 *
 * This function is a utility for performing exponentiation with `Double` types. It wraps the
 * [kotlin.math.pow] function to provide a more concise and specific API for power calculations.
 *
 * @param base The base value to be raised to the power of [exponent].
 * @param exponent The exponent to which the base value is raised.
 * @return The result of [base] raised to the power of [exponent].
 */
internal fun pow(base: Double, exponent: Double): Double = base.pow(exponent)

/**
 * Returns the result of raising the [base] to the power of [exponent] for `Float` values.
 *
 * This function is a utility for performing exponentiation with `Float` types. It wraps the
 * [kotlin.math.pow] function to provide a more concise and specific API for power calculations.
 *
 * @param base The base value to be raised to the power of [exponent].
 * @param exponent The exponent to which the base value is raised.
 * @return The result of [base] raised to the power of [exponent].
 */
internal fun pow(base: Float, exponent: Float): Float = base.pow(exponent)
