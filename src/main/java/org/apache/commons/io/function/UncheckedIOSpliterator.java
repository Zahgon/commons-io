/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io.function;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * A {@link Spliterator} for an {@link IOSpliterator} that throws {@link UncheckedIOException} instead of
 * {@link IOException}.
 * <p>
 * Keep package-private for now.
 * </p>
 *
 * @param <T> the type of elements returned by this iterator.
 */
final class UncheckedIOSpliterator<T> implements Spliterator<T> {

    private final IOSpliterator<T> delegate;

    UncheckedIOSpliterator(final IOSpliterator<T> delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    @Override
    public int characteristics() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long estimateSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void forEachRemaining(final Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Comparator<? super T> getComparator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getExactSizeIfKnown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasCharacteristics(final int characteristics) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean tryAdvance(final Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Spliterator<T> trySplit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
