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
package org.apache.commons.io.input;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.io.build.AbstractOrigin;
import org.apache.commons.io.build.AbstractStreamBuilder;

/**
 * This is an alternative to {@link ByteArrayInputStream} which removes the synchronization overhead for non-concurrent access; as such this class is
 * not thread-safe.
 * <p>
 * To build an instance, use {@link Builder}.
 * </p>
 *
 * @see Builder
 * @see ByteArrayInputStream
 * @since 2.7
 */
//@NotThreadSafe
public class UnsynchronizedByteArrayInputStream extends InputStream {

    // @formatter:off
    /**
     * Builds a new {@link UnsynchronizedByteArrayInputStream}.
     *
     * <p>
     * Using a Byte Array:
     * </p>
     * <pre>{@code
     * UnsynchronizedByteArrayInputStream s = UnsynchronizedByteArrayInputStream.builder()
     *   .setByteArray(byteArray)
     *   .setOffset(0)
     *   .setLength(byteArray.length)
     *   .get();
     * }
     * </pre>
     * <p>
     * Using File IO:
     * </p>
     * <pre>{@code
     * UnsynchronizedByteArrayInputStream s = UnsynchronizedByteArrayInputStream.builder()
     *   .setFile(file)
     *   .setOffset(0)
     *   .setLength(byteArray.length)
     *   .get();
     * }
     * </pre>
     * <p>
     * Using NIO Path:
     * </p>
     * <pre>{@code
     * UnsynchronizedByteArrayInputStream s = UnsynchronizedByteArrayInputStream.builder()
     *   .setPath(path)
     *   .setOffset(0)
     *   .setLength(byteArray.length)
     *   .get();
     * }
     * </pre>
     *
     * @see #get()
     */
    // @formatter:on
    public static class Builder extends AbstractStreamBuilder<UnsynchronizedByteArrayInputStream, Builder> {

        private int offset;

        private int length;

        /**
         * Constructs a builder of {@link UnsynchronizedByteArrayInputStream}.
         */
        public Builder() {
            // empty
        }

        private byte[] checkOriginByteArray() throws IOException {
            return checkOrigin().getByteArray();
        }

        /**
         * Builds a new {@link UnsynchronizedByteArrayInputStream}.
         * <p>
         * You must set an aspect that supports {@code byte[]} on this builder, otherwise, this method throws an exception.
         * </p>
         * <p>
         * This builder uses the following aspects:
         * </p>
         * <ul>
         * <li>{@code byte[]}</li>
         * <li>offset</li>
         * <li>length</li>
         * </ul>
         *
         * @return a new instance.
         * @throws UnsupportedOperationException if the origin cannot provide a {@code byte[]}.
         * @throws IllegalStateException         if the {@code origin} is {@code null}.
         * @throws IOException                   if an I/O error occurs converting to an {@code byte[]} using {@link AbstractOrigin#getByteArray()}.
         * @see AbstractOrigin#getByteArray()
         * @see #getUnchecked()
         */
        @Override
        public UnsynchronizedByteArrayInputStream get() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Builder setByteArray(final byte[] origin) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the length.
         *
         * @param length Must be greater or equal to 0.
         * @return {@code this} instance.
         */
        public Builder setLength(final int length) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the offset.
         *
         * @param offset Must be greater or equal to 0.
         * @return {@code this} instance.
         */
        public Builder setOffset(final int offset) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * The end of stream marker.
     */
    public static final int END_OF_STREAM = -1;

    /**
     * Constructs a new {@link Builder}.
     *
     * @return a new {@link Builder}.
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static int minPosLen(final byte[] data, final int defaultValue) {
        requireNonNegative(defaultValue, "defaultValue");
        return Math.min(defaultValue, data.length > 0 ? data.length : defaultValue);
    }

    private static int requireNonNegative(final int value, final String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be negative");
        }
        return value;
    }

    /**
     * The underlying data buffer.
     */
    private final byte[] data;

    /**
     * End Of Data.
     *
     * Similar to data.length, which is the last readable offset + 1.
     */
    private final int eod;

    /**
     * Current offset in the data buffer.
     */
    private int offset;

    /**
     * The current mark (if any).
     */
    private int markedOffset;

    private UnsynchronizedByteArrayInputStream(final Builder builder) throws IOException {
        this(builder.checkOriginByteArray(), builder.offset, builder.length);
    }

    /**
     * Constructs a new byte array input stream.
     *
     * @param data the buffer
     * @deprecated Use {@link #builder()}, {@link Builder}, and {@link Builder#get()}.
     */
    @Deprecated
    public UnsynchronizedByteArrayInputStream(final byte[] data) {
        this(data, data.length, 0, 0);
    }

    /**
     * Constructs a new byte array input stream.
     *
     * @param data   the buffer
     * @param offset the offset into the buffer
     * @throws IllegalArgumentException if the offset is less than zero
     * @deprecated Use {@link #builder()}, {@link Builder}, and {@link Builder#get()}.
     */
    @Deprecated
    public UnsynchronizedByteArrayInputStream(final byte[] data, final int offset) {
        this(data, data.length, Math.min(requireNonNegative(offset, "offset"), minPosLen(data, offset)), minPosLen(data, offset));
    }

    /**
     * Constructs a new byte array input stream.
     *
     * @param data   the buffer
     * @param offset the offset into the buffer
     * @param length the length of the buffer
     * @throws IllegalArgumentException if the offset or length less than zero
     * @deprecated Use {@link #builder()}, {@link Builder}, and {@link Builder#get()}.
     */
    @Deprecated
    public UnsynchronizedByteArrayInputStream(final byte[] data, final int offset, final int length) {
        requireNonNegative(offset, "offset");
        requireNonNegative(length, "length");
        this.data = Objects.requireNonNull(data, "data");
        this.eod = Math.min(minPosLen(data, offset) + length, data.length);
        this.offset = minPosLen(data, offset);
        this.markedOffset = minPosLen(data, offset);
    }

    private UnsynchronizedByteArrayInputStream(final byte[] data, final int eod, final int offset, final int markedOffset) {
        this.data = Objects.requireNonNull(data, "data");
        this.eod = eod;
        this.offset = offset;
        this.markedOffset = markedOffset;
    }

    @Override
    public int available() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("sync-override")
    @Override
    public void mark(final int readLimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean markSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int read() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int read(final byte[] dest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int read(final byte[] dest, final int off, final int len) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("sync-override")
    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long skip(final long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
