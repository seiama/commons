/*
 * This file is part of commons, licensed under the MIT License.
 *
 * Copyright (c) 2021-2023 Seiama
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.seiama.common;

import org.jetbrains.annotations.NotNull;

/**
 * A collection of utilities for working with {@link Comparable}.
 *
 * @since 1.0.0
 */
public final class Comparables {
  private Comparables() {
  }

  /**
   * Checks if {@code left} is greater than {@code right}.
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return {@code true} if {@code left} is greater than {@code right}, {@code false} otherwise
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> boolean greaterThan(final @NotNull C left, final @NotNull C right) {
    return left.compareTo(right) > 0;
  }

  /**
   * Checks if {@code left} is greater than or equal to {@code right}.
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return {@code true} if {@code left} is greater than or equal to {@code right}, {@code false} otherwise
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> boolean greaterThanOrEqual(final @NotNull C left, final @NotNull C right) {
    return left.compareTo(right) >= 0;
  }

  /**
   * Checks if {@code left} is less than {@code right}.
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return {@code true} if {@code left} is less than {@code right}, {@code false} otherwise
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> boolean lessThan(final @NotNull C left, final @NotNull C right) {
    return left.compareTo(right) < 0;
  }

  /**
   * Checks if {@code left} is less than or equal to {@code right}.
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return {@code true} if {@code left} is less than or equal to {@code right}, {@code false} otherwise
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> boolean lessThanOrEqual(final @NotNull C left, final @NotNull C right) {
    return left.compareTo(right) <= 0;
  }

  /**
   * Gets the minimum value.
   *
   * <p>If {@code left} and {@code right} are equal {@code left} will be returned.</p>
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return the minimum value
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> @NotNull C min(final @NotNull C left, final @NotNull C right) {
    return lessThanOrEqual(left, right) ? left : right;
  }

  /**
   * Gets the maximum value.
   *
   * <p>If {@code left} and {@code right} are equal {@code left} will be returned.</p>
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return the maximum value
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> @NotNull C max(final @NotNull C left, final @NotNull C right) {
    return greaterThanOrEqual(left, right) ? left : right;
  }
}
