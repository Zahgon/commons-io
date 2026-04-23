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
package org.apache.commons.io.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

/**
 * Works with {@link FileChannel}.
 *
 * @since 2.15.0
 */
public final class FileChannels {

    /**
     * Tests if two file channel contents are equal starting at their respective current positions.
     *
     * @param channel1       A file channel.
     * @param channel2       Another file channel.
     * @param bufferCapacity The two internal buffer capacities, in bytes.
     * @return true if the contents of both RandomAccessFiles are equal, false otherwise.
     * @throws IOException if an I/O error occurs.
     * @deprecated Use {@link #contentEquals(SeekableByteChannel, SeekableByteChannel, int)}.
     */
    @Deprecated
    public static boolean contentEquals(final FileChannel channel1, final FileChannel channel2, final int bufferCapacity) throws IOException {
        return contentEquals((SeekableByteChannel) channel1, channel2, bufferCapacity);
    }

    /**
     * Tests if two readable byte channel contents are equal starting at their respective current positions.
     *
     * @param channel1       A readable byte channel.
     * @param channel2       Another readable byte channel.
     * @param bufferCapacity The two internal buffer capacities, in bytes.
     * @return true if the contents of both RandomAccessFiles are equal, false otherwise.
     * @throws IOException if an I/O error occurs or the timeout is met.
     * @since 2.19.0
     */
    public static boolean contentEquals(final ReadableByteChannel channel1, final ReadableByteChannel channel2, final int bufferCapacity) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tests if two seekable byte channel contents are equal starting at their respective current positions.
     * <p>
     * If the two channels have different sizes, no content comparison takes place, and this method returns false.
     * </p>
     *
     * @param channel1       A seekable byte channel.
     * @param channel2       Another seekable byte channel.
     * @param bufferCapacity The two internal buffer capacities, in bytes.
     * @return true if the contents of both RandomAccessFiles are equal, false otherwise.
     * @throws IOException if an I/O error occurs or the timeout is met.
     * @since 2.19.0
     */
    public static boolean contentEquals(final SeekableByteChannel channel1, final SeekableByteChannel channel2, final int bufferCapacity) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a sequence of bytes from a channel into the given buffer until the buffer reaches its limit or the channel has reaches end-of-stream.
     * <p>
     * The buffer's limit is not changed.
     * </p>
     *
     * @param channel The source channel.
     * @param dst     The buffer into which bytes are to be transferred.
     * @return The number of bytes read, <em>never</em> zero, or {@code -1} if the channel has reached end-of-stream
     * @throws IOException              If some other I/O error occurs.
     * @throws IllegalArgumentException If there is room in the given buffer.
     */
    private static int readToLimit(final ReadableByteChannel channel, final ByteBuffer dst) throws IOException {
        if (!dst.hasRemaining()) {
            throw new IllegalArgumentException();
        }
        int totalRead = 0;
        while (dst.hasRemaining()) {
            final int numRead;
            if ((numRead = channel.read(dst)) == IOUtils.EOF) {
                break;
            }
            if (numRead == 0) {
                // 0 may be returned from a non-blocking channel.
                Thread.yield();
            } else {
                totalRead += numRead;
            }
        }
        return totalRead != 0 ? totalRead : IOUtils.EOF;
    }

    private static long size(final SeekableByteChannel channel) throws IOException {
        return channel != null ? channel.size() : 0;
    }

    /**
     * Don't instantiate.
     */
    private FileChannels() {
        // no-op
    }
}
