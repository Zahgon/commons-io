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
package org.apache.commons.io.output;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.build.AbstractOrigin;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.Uncheck;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;

/**
 * Implements a version of {@link AbstractByteArrayOutputStream} <strong>without</strong> any concurrent thread safety.
 * <p>
 * To build an instance, use {@link Builder}.
 * </p>
 *
 * @see Builder
 * @since 2.7
 */
//@NotThreadSafe
public final class UnsynchronizedByteArrayOutputStream extends AbstractByteArrayOutputStream<UnsynchronizedByteArrayOutputStream> {

    // @formatter:off
    /**
     * Builds a new {@link UnsynchronizedByteArrayOutputStream}.
     *
     * <p>
     * Using File IO:
     * </p>
     * <pre>{@code
     * UnsynchronizedByteArrayOutputStream s = UnsynchronizedByteArrayOutputStream.builder()
     *   .setBufferSize(8192)
     *   .get();}
     * </pre>
     * <p>
     * Using NIO Path:
     * </p>
     * <pre>{@code
     * UnsynchronizedByteArrayOutputStream s = UnsynchronizedByteArrayOutputStream.builder()
     *   .setBufferSize(8192)
     *   .get();}
     * </pre>
     *
     * @see #get()
     */
    // @formatter:on
    public static class Builder extends AbstractStreamBuilder<UnsynchronizedByteArrayOutputStream, Builder> {

        /**
         * Constructs a new builder of {@link UnsynchronizedByteArrayOutputStream}.
         */
        public Builder() {
            // empty
        }

        /**
         * Builds a new {@link UnsynchronizedByteArrayOutputStream}.
         *
         * <p>
         * This builder uses the following aspects:
         * </p>
         * <ul>
         * <li>{@link #getBufferSize()}</li>
         * </ul>
         *
         * @return a new instance.
         * @see AbstractOrigin#getByteArray()
         * @see #getUnchecked()
         */
        @Override
        public UnsynchronizedByteArrayOutputStream get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Constructs a new {@link Builder}.
     *
     * @return a new {@link Builder}.
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Fetches entire contents of an {@link InputStream} and represent same data as result InputStream.
     * <p>
     * This method is useful where,
     * </p>
     * <ul>
     * <li>Source InputStream is slow.</li>
     * <li>It has network resources associated, so we cannot keep it open for long time.</li>
     * <li>It has network timeout associated.</li>
     * </ul>
     * It can be used in favor of {@link #toByteArray()}, since it avoids unnecessary allocation and copy of byte[].<br>
     * This method buffers the input internally, so there is no need to use a {@link BufferedInputStream}.
     *
     * @param input Stream to be fully buffered.
     * @return A fully buffered stream.
     * @throws IOException if an I/O error occurs.
     */
    public static InputStream toBufferedInputStream(final InputStream input) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Fetches entire contents of an {@link InputStream} and represent same data as result InputStream.
     * <p>
     * This method is useful where,
     * </p>
     * <ul>
     * <li>Source InputStream is slow.</li>
     * <li>It has network resources associated, so we cannot keep it open for long time.</li>
     * <li>It has network timeout associated.</li>
     * </ul>
     * It can be used in favor of {@link #toByteArray()}, since it avoids unnecessary allocation and copy of byte[].<br>
     * This method buffers the input internally, so there is no need to use a {@link BufferedInputStream}.
     *
     * @param input Stream to be fully buffered.
     * @param size the initial buffer size
     * @return A fully buffered stream.
     * @throws IOException if an I/O error occurs.
     */
    public static InputStream toBufferedInputStream(final InputStream input, final int size) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Constructs a new byte array output stream. The buffer capacity is initially
     *
     * {@value AbstractByteArrayOutputStream#DEFAULT_SIZE} bytes, though its size increases if necessary.
     * @deprecated Use {@link #builder()}, {@link Builder}, and {@link Builder#get()}.
     */
    @Deprecated
    public UnsynchronizedByteArrayOutputStream() {
        this(DEFAULT_SIZE);
    }

    private UnsynchronizedByteArrayOutputStream(final Builder builder) {
        this(builder.getBufferSize());
    }

    /**
     * Constructs a new byte array output stream, with a buffer capacity of the specified size, in bytes.
     *
     * @param size the initial size
     * @throws IllegalArgumentException if size is negative
     * @deprecated Use {@link #builder()}, {@link Builder}, and {@link Builder#get()}. Will be private in 3.0.0.
     */
    @Deprecated
    public UnsynchronizedByteArrayOutputStream(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative initial size: " + size);
        }
        needNewBuffer(size);
    }

    /**
     * @see java.io.ByteArrayOutputStream#reset()
     */
    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] toByteArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public InputStream toInputStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(final byte[] b, final int off, final int len) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int write(final InputStream in) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(final int b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void writeTo(final OutputStream out) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
