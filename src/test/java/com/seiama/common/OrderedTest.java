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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderedTest {
  @Test
  void testGreaterThan() {
    assertFalse(Thing.ABC.greaterThan(Thing.DEF));
    assertFalse(Thing.DEF.greaterThan(Thing.DEF));
    assertTrue(Thing.GHI.greaterThan(Thing.DEF));
  }

  @Test
  void testNoLessThan() {
    assertFalse(Thing.ABC.noLessThan(Thing.DEF));
    assertTrue(Thing.DEF.noLessThan(Thing.DEF));
    assertTrue(Thing.GHI.noLessThan(Thing.DEF));
  }

  @Test
  void testLessThan() {
    assertTrue(Thing.ABC.lessThan(Thing.DEF));
    assertFalse(Thing.DEF.lessThan(Thing.DEF));
    assertFalse(Thing.GHI.lessThan(Thing.DEF));
  }

  @Test
  void testNoGreaterThan() {
    assertTrue(Thing.ABC.noGreaterThan(Thing.ABC));
    assertFalse(Thing.DEF.noGreaterThan(Thing.ABC));
  }

  @Test
  void testNoGreaterOrLessThan() {
    assertFalse(Thing.DEF.noGreaterOrLessThan(Thing.ABC));
    assertTrue(Thing.DEF.noGreaterOrLessThan(Thing.DEF));
    assertFalse(Thing.DEF.noGreaterOrLessThan(Thing.GHI));
  }

  private enum Thing implements Ordered<Thing> {
    ABC,
    DEF,
    GHI;
  }
}
