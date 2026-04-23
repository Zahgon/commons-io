/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.commons.io.input;

import static org.apache.commons.io.IOUtils.CR;
import static org.apache.commons.io.IOUtils.EOF;
import static org.apache.commons.io.IOUtils.LF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.io.IOUtils;

/**
 * Wraps an existing {@link Reader} and buffers the input <em>without any synchronization</em>. Expensive interaction with the underlying reader is minimized,
 * since most (smaller) requests can be satisfied by accessing the buffer alone. The drawback is that some extra space is required to hold the buffer and that
 * copying takes place when filling that buffer, but this is usually outweighed by the performance benefits.
 * <p>
 * A typical application pattern for the class looks like this:
 * </p>
 *
 * <pre>{@code
 * UnsynchronizedBufferedReader buf = new UnsynchronizedBufferedReader(new FileReader("file"));
 * }</pre>
 * <p>
 * Provenance: Apache Harmony's java.io.BufferedReader, renamed, and modified.
 * </p>
 *
 * @see BufferedReader
 * @see BufferedWriter
 * @since 2.17.0
 */
public class UnsynchronizedBufferedReader extends UnsynchronizedReader {

    private static final char NUL = '\0';

    private final Reader in;

    /**
     * The characters that can be read and refilled in bulk. We maintain three indices into this buffer:
     *
     * <pre>
     *     { X X X X X X X X X X X X - - }
     *           ^     ^             ^
     *           |     |             |
     *         mark   pos           end
     * </pre>
     * <p>
     * Pos points to the next readable character. End is one greater than the last readable character. When {@code pos == end}, the buffer is empty and must be
     * {@link #fillBuf() filled} before characters can be read.
     * </p>
     * <p>
     * Mark is the value pos will be set to on calls to {@link #reset()}. Its value is in the range {@code [0...pos]}. If the mark is {@code -1}, the buffer
     * cannot be reset.
     * </p>
     * <p>
     * MarkLimit limits the distance between the mark and the pos. When this limit is exceeded, {@link #reset()} is permitted (but not required) to throw an
     * exception. For shorter distances, {@link #reset()} shall not throw (unless the reader is closed).
     * </p>
     */
    private char[] buf;

    private int pos;

    private int end;

    private int mark = -1;

    private int markLimit = -1;

    /**
     * Constructs a new BufferedReader on the Reader {@code in}. The buffer gets the default size (8 KB).
     *
     * @param in the Reader that is buffered.
     */
    public UnsynchronizedBufferedReader(final Reader in) {
        this(in, IOUtils.DEFAULT_BUFFER_SIZE);
    }

    /**
     * Constructs a new BufferedReader on the Reader {@code in}. The buffer size is specified by the parameter {@code size}.
     *
     * @param in   the Reader that is buffered.
     * @param size the size of the buffer to allocate.
     * @throws IllegalArgumentException if {@code size <= 0}.
     */
    public UnsynchronizedBufferedReader(final Reader in, final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.in = in;
        buf = new char[size];
    }

    /**
     * Peeks at the next input character, refilling the buffer if necessary. If this character is a newline character ("\n"), it is discarded.
     */
    final void chompNewline() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Closes this reader. This implementation closes the buffered source reader and releases the buffer. Nothing is done if this reader has already been
     * closed.
     *
     * @throws IOException if an error occurs while closing this reader.
     */
    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Populates the buffer with data. It is an error to call this method when the buffer still contains data; ie. if {@code pos < end}.
     *
     * @return the number of bytes read into the buffer, or -1 if the end of the source stream has been reached.
     */
    private int fillBuf() throws IOException {
        // assert(pos == end);
        if (mark == EOF || pos - mark >= markLimit) {
            /* mark isn't set or has exceeded its limit. use the whole buffer */
            final int result = in.read(buf, 0, buf.length);
            if (result > 0) {
                mark = -1;
                pos = 0;
                end = result;
            }
            return result;
        }
        if (mark == 0 && markLimit > buf.length) {
            /* the only way to make room when mark=0 is by growing the buffer */
            int newLength = buf.length * 2;
            if (newLength > markLimit) {
                newLength = markLimit;
            }
            final char[] newbuf = new char[newLength];
            System.arraycopy(buf, 0, newbuf, 0, buf.length);
            buf = newbuf;
        } else if (mark > 0) {
            /* make room by shifting the buffered data to left mark positions */
            System.arraycopy(buf, mark, buf, 0, buf.length - mark);
            pos -= mark;
            end -= mark;
            mark = 0;
        }
        /* Set the new position and mark position */
        final int count = in.read(buf, pos, buf.length - pos);
        if (count != EOF) {
            end += count;
        }
        return count;
    }

    /**
     * Sets a mark position in this reader. The parameter {@code markLimit} indicates how many characters can be read before the mark is invalidated. Calling
     * {@link #reset()} will reposition the reader back to the marked position if {@code markLimit} has not been surpassed.
     *
     * @param markLimit the number of characters that can be read before the mark is invalidated.
     * @throws IllegalArgumentException if {@code markLimit < 0}.
     * @throws IOException              if an error occurs while setting a mark in this reader.
     * @see #markSupported()
     * @see #reset()
     */
    @Override
    public void mark(final int markLimit) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tests whether this reader supports the {@link #mark(int)} and {@link #reset()} methods. This implementation returns {@code true}.
     *
     * @return {@code true} for {@code BufferedReader}.
     * @see #mark(int)
     * @see #reset()
     */
    @Override
    public boolean markSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the next character in the current reader without consuming it. So the next call to {@link #read()} will still return this value.
     *
     * @return the next character
     * @throws IOException If an I/O error occurs
     */
    public int peek() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Populates the buffer with the next {@code buf.length} characters in the current reader without consuming them. The next call to {@link #read()} will
     * still return the next value.
     *
     * @param buf the buffer to fill for the look ahead.
     * @return the buffer itself
     * @throws IOException If an I/O error occurs
     */
    public int peek(final char[] buf) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a single character from this reader and returns it with the two higher-order bytes set to 0. If possible, BufferedReader returns a character from
     * the buffer. If there are no characters available in the buffer, it fills the buffer and then returns a character. It returns -1 if there are no more
     * characters in the source reader.
     *
     * @return the character read or -1 if the end of the source reader has been reached.
     * @throws IOException if this reader is closed or some other I/O error occurs.
     */
    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads at most {@code length} characters from this reader and stores them at {@code offset} in the character array {@code buffer}. Returns the number of
     * characters actually read or -1 if the end of the source reader has been reached. If all the buffered characters have been used, a mark has not been set
     * and the requested number of characters is larger than this readers buffer size, BufferedReader bypasses the buffer and simply places the results directly
     * into {@code buffer}.
     *
     * @param buffer the character array to store the characters read.
     * @param offset the initial position in {@code buffer} to store the bytes read from this reader.
     * @param length the maximum number of characters to read, must be non-negative.
     * @return number of characters read or -1 if the end of the source reader has been reached.
     * @throws IndexOutOfBoundsException if {@code offset < 0} or {@code length < 0}, or if {@code offset + length} is greater than the size of {@code buffer}.
     * @throws IOException               if this reader is closed or some other I/O error occurs.
     */
    @Override
    public int read(final char[] buffer, int offset, final int length) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the next line of text available from this reader. A line is represented by zero or more characters followed by {@code LF}, {@code CR},
     * {@code "\r\n"} or the end of the reader. The string does not include the newline sequence.
     *
     * @return the contents of the line or {@code null} if no characters were read before the end of the reader has been reached.
     * @throws IOException if this reader is closed or some other I/O error occurs.
     */
    public String readLine() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tests whether this reader is ready to be read without blocking.
     *
     * @return {@code true} if this reader will not block when {@code read} is called, {@code false} if unknown or blocking will occur.
     * @throws IOException if this reader is closed or some other I/O error occurs.
     * @see #read()
     * @see #read(char[], int, int)
     * @see #readLine()
     */
    @Override
    public boolean ready() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Resets this reader's position to the last {@code mark()} location. Invocations of {@code read()} and {@code skip()} will occur from this new location.
     *
     * @throws IOException if this reader is closed or no mark has been set.
     * @see #mark(int)
     * @see #markSupported()
     */
    @Override
    public void reset() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Skips {@code amount} characters in this reader. Subsequent {@code read()}s will not return these characters unless {@code reset()} is used. Skipping
     * characters may invalidate a mark if {@code markLimit} is surpassed.
     *
     * @param amount the maximum number of characters to skip.
     * @return the number of characters actually skipped.
     * @throws IllegalArgumentException if {@code amount < 0}.
     * @throws IOException              if this reader is closed or some other I/O error occurs.
     * @see #mark(int)
     * @see #markSupported()
     * @see #reset()
     */
    @Override
    public long skip(final long amount) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
