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

import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

/**
 * Like {@link BaseStream} but throws {@link IOException}.
 *
 * @param <T> the type of the stream elements.
 * @param <S> the type of the IO stream extending {@code IOBaseStream}.
 * @param <B> the type of the stream extending {@code BaseStream}.
 * @since 2.12.0
 */
public interface IOBaseStream<T, S extends IOBaseStream<T, S, B>, B extends BaseStream<T, B>> extends Closeable {

    /**
     * Constructs a {@link BaseStream} for this instance that throws {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @return an {@link UncheckedIOException} {@link BaseStream}.
     */
    @SuppressWarnings("unchecked")
    default BaseStream<T, B> asBaseStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Like {@link BaseStream#close()}.
     *
     * @see BaseStream#close()
     */
    @Override
    default void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Like {@link BaseStream#isParallel()}.
     *
     * @return See {@link BaseStream#isParallel() delegate}.
     * @see BaseStream#isParallel()
     */
    // for unwrap()
    @SuppressWarnings("resource")
    default boolean isParallel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Like {@link BaseStream#iterator()}.
     *
     * @return See {@link BaseStream#iterator() delegate}.
     * @see BaseStream#iterator()
     */
    // for unwrap()
    @SuppressWarnings("resource")
    default IOIterator<T> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Like {@link BaseStream#onClose(Runnable)}.
     *
     * @param closeHandler See {@link BaseStream#onClose(Runnable) delegate}.
     * @return See {@link BaseStream#onClose(Runnable) delegate}.
     * @throws IOException if an I/O error occurs.
     * @see BaseStream#onClose(Runnable)
     */
    // throws IOException, unwrap()
    @SuppressWarnings({ "unused", "resource" })
    default S onClose(final IORunnable closeHandler) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Like {@link BaseStream#parallel()}.
     *
     * @return See {@link BaseStream#parallel() delegate}.
     * @see BaseStream#parallel()
     */
    // for unwrap(), this
    @SuppressWarnings({ "resource", "unchecked" })
    default S parallel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Like {@link BaseStream#sequential()}.
     *
     * @return See {@link BaseStream#sequential() delegate}.
     * @see BaseStream#sequential()
     */
    // for unwrap(), this
    @SuppressWarnings({ "resource", "unchecked" })
    default S sequential() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Like {@link BaseStream#spliterator()}.
     *
     * @return See {@link BaseStream#spliterator() delegate}.
     * @see BaseStream#spliterator()
     */
    // for unwrap()
    @SuppressWarnings("resource")
    default IOSpliterator<T> spliterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Like {@link BaseStream#unordered()}.
     *
     * @return See {@link BaseStream#unordered() delegate}.
     * @see java.util.stream.BaseStream#unordered()
     */
    // for unwrap()
    @SuppressWarnings("resource")
    default S unordered() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Unwraps this instance and returns the underlying {@link Stream}.
     * <p>
     * Implementations may not have anything to unwrap and that behavior is undefined for now.
     * </p>
     *
     * @return the underlying stream.
     */
    B unwrap();

    /**
     * Wraps a {@link Stream}.
     *
     * @param delegate The delegate.
     * @return An IO stream.
     */
    S wrap(B delegate);
}
