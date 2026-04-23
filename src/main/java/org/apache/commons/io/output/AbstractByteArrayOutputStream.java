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

import static org.apache.commons.io.IOUtils.EOF;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ClosedInputStream;

/**
 * This is the base class for implementing an output stream in which the data
 * is written into a byte array. The buffer automatically grows as data
 * is written to it.
 * <p>
 * The data can be retrieved using {@code toByteArray()} and
 * {@code toString()}.
 * Closing an {@link AbstractByteArrayOutputStream} has no effect. The methods in
 * this class can be called after the stream has been closed without
 * generating an {@link IOException}.
 * </p>
 * <p>
 * This is the base for an alternative implementation of the
 * {@link java.io.ByteArrayOutputStream} class. The original implementation
 * only allocates 32 bytes at the beginning. As this class is designed for
 * heavy duty it starts at {@value #DEFAULT_SIZE} bytes. In contrast to the original it doesn't
 * reallocate the whole memory block but allocates additional buffers. This
 * way no buffers need to be garbage collected and the contents don't have
 * to be copied to the new buffer. This class is designed to behave exactly
 * like the original. The only exception is the deprecated
 * {@link java.io.ByteArrayOutputStream#toString(int)} method that has been
 * ignored.
 * </p>
 *
 * @param <T> The AbstractByteArrayOutputStream subclass
 * @since 2.7
 */
public abstract class AbstractByteArrayOutputStream<T extends AbstractByteArrayOutputStream<T>> extends OutputStream {

    /**
     * Constructor for an InputStream subclass.
     *
     * @param <T> the type of the InputStream.
     */
    @FunctionalInterface
    protected interface InputStreamConstructor<T extends InputStream> {

        /**
         * Constructs an InputStream subclass.
         *
         * @param buffer the buffer
         * @param offset the offset into the buffer
         * @param length the length of the buffer
         * @return the InputStream subclass.
         */
        T construct(byte[] buffer, int offset, int length);
    }

    static final int DEFAULT_SIZE = 1024;

    /**
     * The list of buffers, which grows and never reduces.
     */
    private final List<byte[]> buffers = new ArrayList<>();

    /**
     * The total count of bytes written.
     */
    protected int count;

    /**
     * The current buffer.
     */
    private byte[] currentBuffer;

    /**
     * The index of the current buffer.
     */
    private int currentBufferIndex = -1;

    /**
     * The total count of bytes in all the filled buffers.
     */
    private int filledBufferSum;

    /**
     * Flag to indicate if the buffers can be reused after reset
     */
    private boolean reuseBuffers = true;

    /**
     * Constructs a new instance for subclasses.
     */
    public AbstractByteArrayOutputStream() {
        // empty
    }

    /**
     * Returns this instance typed to {@code T}.
     *
     * @return this instance
     */
    @SuppressWarnings("unchecked")
    protected T asThis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Does nothing.
     *
     * The methods in this class can be called after the stream has been closed without generating an {@link IOException}.
     *
     * @throws IOException never (this method should not declare this exception but it has to now due to backwards
     *         compatibility)
     */
    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Makes a new buffer available either by allocating
     * a new one or re-cycling an existing one.
     *
     * @param newCount  the size of the buffer if one is created
     */
    protected void needNewBuffer(final int newCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * See {@link ByteArrayOutputStream#reset()}.
     *
     * @see ByteArrayOutputStream#reset()
     */
    public abstract void reset();

    /**
     * Implements a default reset behavior.
     *
     * @see ByteArrayOutputStream#reset()
     */
    protected void resetImpl() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the current size of the byte array.
     *
     * @return the current size of the byte array
     */
    public abstract int size();

    /**
     * Gets the current contents of this byte stream as a byte array.
     * The result is independent of this stream.
     *
     * @return the current contents of this output stream, as a byte array
     * @see java.io.ByteArrayOutputStream#toByteArray()
     */
    public abstract byte[] toByteArray();

    /**
     * Gets the current contents of this byte stream as a byte array.
     * The result is independent of this stream.
     *
     * @return the current contents of this output stream, as a byte array
     * @see java.io.ByteArrayOutputStream#toByteArray()
     */
    protected byte[] toByteArrayImpl() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the current contents of this byte stream as an Input Stream. The
     * returned stream is backed by buffers of {@code this} stream,
     * avoiding memory allocation and copy, thus saving space and time.<br>
     *
     * @return the current contents of this output stream.
     * @see java.io.ByteArrayOutputStream#toByteArray()
     * @see #reset()
     * @since 2.5
     */
    public abstract InputStream toInputStream();

    /**
     * Gets the current contents of this byte stream as an Input Stream. The
     * returned stream is backed by buffers of {@code this} stream,
     * avoiding memory allocation and copy, thus saving space and time.<br>
     *
     * @param <T> the type of the InputStream which makes up
     *            the {@link SequenceInputStream}.
     * @param isConstructor A constructor for an InputStream which makes
     *                     up the {@link SequenceInputStream}.
     *
     * @return the current contents of this output stream.
     * @see java.io.ByteArrayOutputStream#toByteArray()
     * @see #reset()
     * @since 2.7
     */
    // The result InputStream MUST be managed by the call site.
    @SuppressWarnings("resource")
    protected <T extends InputStream> InputStream toInputStream(final InputStreamConstructor<T> isConstructor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the current contents of this byte stream as a string using the virtual machine's {@link Charset#defaultCharset() default charset}.
     *
     * @return the contents of the byte array as a String
     * @see java.io.ByteArrayOutputStream#toString()
     * @see Charset#defaultCharset()
     * @deprecated Use {@link #toString(String)} instead
     */
    @Override
    @Deprecated
    public String toString() {
        // make explicit the use of the default charset
        return new String(toByteArray(), Charset.defaultCharset());
    }

    /**
     * Gets the current contents of this byte stream as a string
     * using the specified encoding.
     *
     * @param charset  the character encoding
     * @return the string converted from the byte array
     * @see java.io.ByteArrayOutputStream#toString(String)
     * @since 2.5
     */
    public String toString(final Charset charset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the current contents of this byte stream as a string
     * using the specified encoding.
     *
     * @param enc  the name of the character encoding
     * @return the string converted from the byte array
     * @throws UnsupportedEncodingException if the encoding is not supported
     * @see java.io.ByteArrayOutputStream#toString(String)
     */
    public String toString(final String enc) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes {@code b.length} bytes from the given byte array to this output stream. This has same effect as {@code write(b, 0, b.length)}.
     *
     * @param b the data.
     * @see #write(byte[], int, int)
     * @since 2.19.0
     */
    @Override
    public void write(final byte[] b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public abstract void write(byte[] b, int off, int len);

    /**
     * Writes the bytes for given CharSequence encoded using a Charset.
     *
     * @param data    The String to convert to bytes. not null.
     * @param charset The {@link Charset} o encode the {@code String}, null means the default encoding.
     * @return this instance.
     * @since 2.19.0
     */
    public T write(final CharSequence data, final Charset charset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the entire contents of the specified input stream to this
     * byte stream. Bytes from the input stream are read directly into the
     * internal buffer of this stream.
     *
     * @param in the input stream to read from
     * @return total number of bytes read from the input stream
     *         (and written to this stream)
     * @throws IOException if an I/O error occurs while reading the input stream
     * @since 1.4
     */
    public abstract int write(InputStream in) throws IOException;

    @Override
    public abstract void write(int b);

    /**
     * Writes the bytes to the byte array.
     * @param b the bytes to write
     * @param off The start offset
     * @param len The number of bytes to write
     */
    protected void writeImpl(final byte[] b, final int off, final int len) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the entire contents of the specified input stream to this
     * byte stream. Bytes from the input stream are read directly into the
     * internal buffer of this stream.
     *
     * @param in the input stream to read from
     * @return total number of bytes read from the input stream
     *         (and written to this stream)
     * @throws IOException if an I/O error occurs while reading the input stream
     * @since 2.7
     */
    protected int writeImpl(final InputStream in) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes a byte to byte array.
     * @param b the byte to write
     */
    protected void writeImpl(final int b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the entire contents of this byte stream to the
     * specified output stream.
     *
     * @param out  the output stream to write to
     * @throws IOException if an I/O error occurs, such as if the stream is closed
     * @see java.io.ByteArrayOutputStream#writeTo(OutputStream)
     */
    public abstract void writeTo(OutputStream out) throws IOException;

    /**
     * Writes the entire contents of this byte stream to the
     * specified output stream.
     *
     * @param out  the output stream to write to
     * @throws IOException if an I/O error occurs, such as if the stream is closed
     * @see java.io.ByteArrayOutputStream#writeTo(OutputStream)
     */
    protected void writeToImpl(final OutputStream out) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
