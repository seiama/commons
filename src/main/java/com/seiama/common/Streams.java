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

import java.util.stream.Stream;
import org.jspecify.annotations.NullMarked;

/**
 * A collection of utilities for working with streams.
 *
 * @since 1.0.0
 */
@NullMarked
public final class Streams {
  private Streams() {
  }

  /**
   * Creates a stream whose elements are all the elements of the first stream followed by all the elements of the second stream, and so on.
   *
   * @param streams the streams
   * @param <T> the element type
   * @return the concatenated stream
   * @see Stream#concat(Stream, Stream)
   * @since 1.0.0
   */
  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <T> Stream<T> concat(final Stream<? extends T>... streams) {
    @SuppressWarnings("unchecked")
    final Stream<T> stream = (Stream<T>) Stream.of(streams).reduce(Stream.empty(), Stream::concat);
    return stream;
  }

  /**
   * Transforms a {@link Stream} by filtering and casting its elements to a specified class.
   *
   * @param stream the original stream of elements
   * @param type the type
   * @param <T> the type
   * @return a stream containing elements that are instances of {@code type}
   * @since 1.0.0
   */
  public static <T> Stream<T> instancesOf(final Stream<?> stream, final Class<T> type) {
    return stream
      .filter(type::isInstance)
      .map(type::cast);
  }
}
