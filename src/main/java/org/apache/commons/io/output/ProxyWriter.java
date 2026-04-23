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

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.io.IOUtils;

/**
 * A Proxy stream which acts as expected, that is it passes the method calls on to the proxied stream and doesn't
 * change which methods are being called. It is an alternative base class to FilterWriter to increase reusability,
 * because FilterWriter changes the methods being called, such as {@code write(char[]) to write(char[], int, int)}
 * and {@code write(String) to write(String, int, int)}.
 */
public class ProxyWriter extends FilterWriter {

    /**
     * Constructs a new ProxyWriter.
     *
     * @param delegate  the Writer to delegate to
     */
    public ProxyWriter(final Writer delegate) {
        // the delegate is stored in a protected superclass variable named 'out'
        super(delegate);
    }

    /**
     * Invoked by the write methods after the proxied call has returned
     * successfully. The number of chars written (1 for the
     * {@link #write(int)} method, buffer length for {@link #write(char[])},
     * etc.) is given as an argument.
     * <p>
     * Subclasses can override this method to add common post-processing
     * functionality without having to override all the write methods.
     * The default implementation does nothing.
     * </p>
     *
     * @param n number of chars written
     * @throws IOException if the post-processing fails
     * @since 2.0
     */
    // Possibly thrown from subclasses.
    @SuppressWarnings("unused")
    protected void afterWrite(final int n) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code append(char)} method.
     * @param c The character to write
     * @return this writer
     * @throws IOException if an I/O error occurs.
     * @since 2.0
     */
    @Override
    public Writer append(final char c) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code append(CharSequence)} method.
     * @param csq The character sequence to write
     * @return this writer
     * @throws IOException if an I/O error occurs.
     * @since 2.0
     */
    @Override
    public Writer append(final CharSequence csq) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code append(CharSequence, int, int)} method.
     * @param csq The character sequence to write
     * @param start The index of the first character to write
     * @param end  The index of the first character to write (exclusive)
     * @return this writer
     * @throws IOException if an I/O error occurs.
     * @since 2.0
     */
    @Override
    public Writer append(final CharSequence csq, final int start, final int end) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invoked by the write methods before the call is proxied. The number
     * of chars to be written (1 for the {@link #write(int)} method, buffer
     * length for {@link #write(char[])}, etc.) is given as an argument.
     * <p>
     * Subclasses can override this method to add common pre-processing
     * functionality without having to override all the write methods.
     * The default implementation does nothing.
     * </p>
     *
     * @param n number of chars to be written
     * @throws IOException if the pre-processing fails
     * @since 2.0
     */
    // Possibly thrown from subclasses.
    @SuppressWarnings("unused")
    protected void beforeWrite(final int n) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code close()} method.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code flush()} method.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void flush() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Handles any IOExceptions thrown.
     * <p>
     * This method provides a point to implement custom exception
     * handling. The default behavior is to re-throw the exception.
     * </p>
     *
     * @param e The IOException thrown
     * @throws IOException if an I/O error occurs.
     * @since 2.0
     */
    protected void handleIOException(final IOException e) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code write(char[])} method.
     * @param cbuf the characters to write
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void write(final char[] cbuf) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code write(char[], int, int)} method.
     * @param cbuf the characters to write
     * @param off The start offset
     * @param len The number of characters to write
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void write(final char[] cbuf, final int off, final int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code write(int)} method.
     * @param c the character to write
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void write(final int c) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code write(String)} method.
     * @param str the string to write
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void write(final String str) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Invokes the delegate's {@code write(String)} method.
     * @param str the string to write
     * @param off The start offset
     * @param len The number of characters to write
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void write(final String str, final int off, final int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
