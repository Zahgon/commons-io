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
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/**
 * An {@link BaseStream} for a {@link IOBaseStream} that throws {@link UncheckedIOException} instead of
 * {@link IOException}.
 *
 * Keep package-private for now.
 *
 * @param <T> the type of the stream elements.
 * @param <S> the type of the IO stream extending {@code IOBaseStream}.
 * @param <B> the type of the stream extending {@code BaseStream}.
 */
final class UncheckedIOBaseStream<T, S extends IOBaseStream<T, S, B>, B extends BaseStream<T, B>> implements BaseStream<T, B> {

    private final S delegate;

    UncheckedIOBaseStream(final S delegate) {
        this.delegate = delegate;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isParallel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("resource")
    @Override
    public B onClose(final Runnable closeHandler) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("resource")
    @Override
    public B parallel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("resource")
    @Override
    public B sequential() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("resource")
    @Override
    public B unordered() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
