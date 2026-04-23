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
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.io.IOExceptionList;
import org.apache.commons.io.IOIndexedException;

/**
 * Keep this code package-private for now.
 */
final class IOStreams {

    static final Object NONE = new Object();

    static <T> void forAll(final Stream<T> stream, final IOConsumer<T> action) throws IOExceptionList {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // adapt()
    @SuppressWarnings("resource")
    static <T> void forAll(final Stream<T> stream, final IOConsumer<T> action, final BiFunction<Integer, IOException, IOException> exSupplier) throws IOExceptionList {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // IOStreams.rethrow() throws
    @SuppressWarnings("unused")
    static <T> void forEach(final Stream<T> stream, final IOConsumer<T> action) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Null-safe version of {@link StreamSupport#stream(java.util.Spliterator, boolean)}.
     *
     * Copied from Apache Commons Lang.
     *
     * @param <T> the type of stream elements.
     * @param values the elements of the new stream, may be {@code null}.
     * @return the new stream on {@code values} or {@link Stream#empty()}.
     */
    static <T> Stream<T> of(final Iterable<T> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> Stream<T> of(final Stream<T> stream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Null-safe version of {@link Stream#of(Object[])}.
     *
     * Copied from Apache Commons Lang.
     *
     * @param <T> the type of stream elements.
     * @param values the elements of the new stream, may be {@code null}.
     * @return the new stream on {@code values} or {@link Stream#empty()}.
     */
    // Creating a stream from an array is safe
    @SafeVarargs
    static <T> Stream<T> of(final T... values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> IOConsumer<T> toIOConsumer(final IOConsumer<T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private IOStreams() {
        // no instances
    }
}
