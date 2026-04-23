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

import static org.apache.commons.io.IOUtils.EOF;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.EndianUtils;

/**
 * DataInput for systems relying on little-endian data formats. When read, values will be changed from little-endian to
 * big-endian formats for internal usage.
 * <p>
 * Provenance: Avalon Excalibur (IO)
 * </p>
 */
public class SwappedDataInputStream extends ProxyInputStream implements DataInput {

    /**
     * Constructs a SwappedDataInputStream.
     *
     * @param input InputStream to read from
     */
    public SwappedDataInputStream(final InputStream input) {
        super(input);
    }

    /**
     * Return <code>{@link #readByte()} != 0</code>
     *
     * @return false if the byte read is zero, otherwise true
     * @throws IOException if an I/O error occurs.
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @Override
    public boolean readBoolean() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code read()} method.
     *
     * @return the byte read or -1 if the end of stream
     * @throws IOException if an I/O error occurs.
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @Override
    public byte readByte() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a 2 byte, unsigned, little endian UTF-16 code point.
     *
     * @return the UTF-16 code point read or -1 if the end of stream
     * @throws IOException if an I/O error occurs.
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @Override
    public char readChar() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads an 8 byte, two's complement, little-endian long.
     *
     * @return the read long
     * @throws IOException if an I/O error occurs.
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @Override
    public double readDouble() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a 4 byte, IEEE 754, little-endian float.
     *
     * @return the read float
     * @throws IOException if an I/O error occurs.
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @Override
    public float readFloat() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code read(byte[] data, int, int)} method.
     *
     * @param data the buffer to read the bytes into
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void readFully(final byte[] data) throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code read(byte[] data, int, int)} method.
     *
     * @param data the buffer to read the bytes into
     * @param offset The start offset
     * @param length The number of bytes to read
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void readFully(final byte[] data, final int offset, final int length) throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a 4 byte, two's complement little-endian integer.
     *
     * @return the read int
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public int readInt() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Not currently supported - throws {@link UnsupportedOperationException}.
     *
     * @return the line read
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     * @throws UnsupportedOperationException always
     */
    @Override
    public String readLine() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads an 8 byte, two's complement little-endian integer.
     *
     * @return the read long
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public long readLong() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a 2 byte, two's complement, little-endian integer.
     *
     * @return the read short
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public short readShort() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code read()} method.
     *
     * @return the byte read or -1 if the end of stream
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public int readUnsignedByte() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a 2 byte, unsigned, little-endian integer.
     *
     * @return the read short
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public int readUnsignedShort() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Not currently supported - throws {@link UnsupportedOperationException}.
     *
     * @return never
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     * @throws UnsupportedOperationException always
     */
    @Override
    public String readUTF() throws IOException, EOFException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code skip(int)} method.
     *
     * @param count the number of bytes to skip
     * @return the number of bytes skipped or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @Override
    public int skipBytes(final int count) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
