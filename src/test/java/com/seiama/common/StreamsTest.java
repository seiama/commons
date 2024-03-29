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
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth8.assertThat;

class StreamsTest {
  @Test
  void testConcat() {
    final Stream<String> stream = Streams.concat(
      Stream.of("abc"),
      Stream.of("def", "ghi"),
      Stream.of("jkl")
    );
    assertThat(stream).containsExactly("abc", "def", "ghi", "jkl").inOrder();
  }

  @SuppressWarnings({
    "EmptyLineSeparator",
    "RightCurlyAlone"
  })
  @Test
  void testInstancesOf() {
    class A {}
    class B {}
    final A a0 = new A();
    final A a1 = new A();
    final B b0 = new B();
    final B b1 = new B();
    assertThat(Streams.instancesOf(Stream.of(a0, b0, a1, b1), A.class)).containsExactly(a0, a1).inOrder();
  }
}
