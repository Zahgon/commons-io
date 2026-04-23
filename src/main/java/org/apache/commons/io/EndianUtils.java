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
package org.apache.commons.io;

import static org.apache.commons.io.IOUtils.EOF;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Helps with reading and writing primitive numeric types ({@code short},
 * {@code int}, {@code long}, {@code float}, and {@code double}) that are
 * encoded in little endian using two's complement or unsigned representations.
 * <p>
 * Different computer architectures have different conventions for
 * byte ordering. In "Little Endian" architectures (e.g. X86),
 * the low-order byte is stored in memory at the lowest address, and
 * subsequent bytes at higher addresses. In "Big Endian" architectures
 * (e.g. Motorola 680X0), the situation is reversed.
 * Most methods and classes throughout Java &mdash; e.g. {@code DataInputStream} and
 * {@code Double.longBitsToDouble()} &mdash; assume data is laid out
 * in big endian order with the most significant byte first.
 * The methods in this class read and write data in little endian order,
 * generally by reversing the bytes and then using the
 * regular Java methods to convert the swapped bytes to a primitive type.
 * </p>
 * <p>
 * Provenance: Excalibur
 * </p>
 *
 * @see org.apache.commons.io.input.SwappedDataInputStream
 */
public class EndianUtils {

    /**
     * Reads the next byte from the input stream.
     * @param input  the stream
     * @return the byte
     * @throws IOException if the end of file is reached
     */
    private static int read(final InputStream input) throws IOException {
        final int value = input.read();
        if (EOF == value) {
            throw new EOFException("Unexpected EOF reached");
        }
        return value;
    }

    /**
     * Reads a little endian {@code double} value from a byte array at a given offset.
     *
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 8 bytes
     */
    public static double readSwappedDouble(final byte[] data, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code double} value from an InputStream.
     *
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    public static double readSwappedDouble(final InputStream input) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code float} value from a byte array at a given offset.
     *
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 4 bytes
     */
    public static float readSwappedFloat(final byte[] data, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code float} value from an InputStream.
     *
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    public static float readSwappedFloat(final InputStream input) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code int} value from a byte array at a given offset.
     *
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 4 bytes
     */
    public static int readSwappedInteger(final byte[] data, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code int} value from an InputStream.
     *
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    public static int readSwappedInteger(final InputStream input) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code long} value from a byte array at a given offset.
     *
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 8 bytes
     */
    public static long readSwappedLong(final byte[] data, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code long} value from an InputStream.
     *
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    public static long readSwappedLong(final InputStream input) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code short} value from a byte array at a given offset.
     *
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 2 bytes
     */
    public static short readSwappedShort(final byte[] data, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian {@code short} value from an InputStream.
     *
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    public static short readSwappedShort(final InputStream input) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian unsigned integer (32-bit) value from a byte array at a given
     * offset.
     *
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 4 bytes
     */
    public static long readSwappedUnsignedInteger(final byte[] data, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a little endian unsigned integer (32-bit) from an InputStream.
     *
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    public static long readSwappedUnsignedInteger(final InputStream input) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads an unsigned short (16-bit) value from a byte array in little endian order at a given
     * offset.
     *
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 2 bytes
     */
    public static int readSwappedUnsignedShort(final byte[] data, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads an unsigned short (16-bit) from an InputStream in little endian order.
     *
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    public static int readSwappedUnsignedShort(final InputStream input) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts a {@code double} value from big endian to little endian
     * and vice versa. That is, it converts the {@code double} to bytes,
     * reverses the bytes, and then reinterprets those bytes as a new {@code double}.
     * This can be useful if you have a number that was read from the
     * underlying source in the wrong endianness.
     *
     * @param value value to convert
     * @return the converted value
     */
    public static double swapDouble(final double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts a {@code float} value from big endian to little endian and vice versa.
     *
     * @param value value to convert
     * @return the converted value
     */
    public static float swapFloat(final float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts an {@code int} value from big endian to little endian and vice versa.
     *
     * @param value value to convert
     * @return the converted value
     */
    public static int swapInteger(final int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts a {@code long} value from big endian to little endian and vice versa.
     *
     * @param value value to convert
     * @return the converted value
     */
    public static long swapLong(final long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts a {@code short} value from big endian to little endian and vice versa.
     *
     * @param value value to convert
     * @return the converted value
     */
    public static short swapShort(final short value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Validates if the provided byte array has enough data.
     *
     * @param data the input byte array
     * @param offset the input offset
     * @param byteNeeded the needed number of bytes
     * @throws IllegalArgumentException if the byte array does not have enough data
     */
    private static void validateByteArrayOffset(final byte[] data, final int offset, final int byteNeeded) {
        if (data.length < offset + byteNeeded) {
            throw new IllegalArgumentException("Data only has " + data.length + "bytes, needed " + (offset + byteNeeded) + "bytes.");
        }
    }

    /**
     * Writes the 8 bytes of a {@code double} to a byte array at a given offset in little endian order.
     *
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 8 bytes
     */
    public static void writeSwappedDouble(final byte[] data, final int offset, final double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 8 bytes of a {@code double} to an output stream in little endian order.
     *
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    public static void writeSwappedDouble(final OutputStream output, final double value) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 4 bytes of a {@code float} to a byte array at a given offset in little endian order.
     *
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 4 bytes
     */
    public static void writeSwappedFloat(final byte[] data, final int offset, final float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 4 bytes of a {@code float} to an output stream in little endian order.
     *
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    public static void writeSwappedFloat(final OutputStream output, final float value) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 4 bytes of an {@code int} to a byte array at a given offset in little endian order.
     *
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 4 bytes
     */
    public static void writeSwappedInteger(final byte[] data, final int offset, final int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 4 bytes of an {@code int} to an output stream in little endian order.
     *
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    public static void writeSwappedInteger(final OutputStream output, final int value) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 8 bytes of a {@code long} to a byte array at a given offset in little endian order.
     *
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 8 bytes
     */
    public static void writeSwappedLong(final byte[] data, final int offset, final long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 8 bytes of a {@code long} to an output stream in little endian order.
     *
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    public static void writeSwappedLong(final OutputStream output, final long value) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 2 bytes of a {@code short} to a byte array at a given offset in little endian order.
     *
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     * @throws IllegalArgumentException if the part of the byte array starting at offset does not have at least 2 bytes
     */
    public static void writeSwappedShort(final byte[] data, final int offset, final short value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes the 2 bytes of a {@code short} to an output stream using little endian encoding.
     *
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    public static void writeSwappedShort(final OutputStream output, final short value) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Instances should NOT be constructed in standard programming.
     *
     * @deprecated TODO Make private in 3.0.
     */
    @Deprecated
    public EndianUtils() {
        // empty
    }
}
