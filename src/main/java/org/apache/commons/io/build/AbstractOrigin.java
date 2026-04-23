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
package org.apache.commons.io.build;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IORandomAccessFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.RandomAccessFileMode;
import org.apache.commons.io.RandomAccessFiles;
import org.apache.commons.io.file.spi.FileSystemProviders;
import org.apache.commons.io.input.BufferedFileChannelInputStream;
import org.apache.commons.io.input.CharSequenceInputStream;
import org.apache.commons.io.input.CharSequenceReader;
import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.io.output.RandomAccessFileOutputStream;
import org.apache.commons.io.output.WriterOutputStream;

/**
 * Abstracts the origin of data for builders like a {@link File}, {@link Path}, {@link Reader}, {@link Writer}, {@link InputStream}, {@link OutputStream}, and
 * {@link URI}.
 * <p>
 * Some methods may throw {@link UnsupportedOperationException} if that method is not implemented in a concrete subclass, see {@link #getFile()} and
 * {@link #getPath()}.
 * </p>
 *
 * @param <T> the type of instances to build.
 * @param <B> the type of builder subclass.
 * @since 2.12.0
 */
public abstract class AbstractOrigin<T, B extends AbstractOrigin<T, B>> extends AbstractSupplier<T, B> {

    /**
     * A {@link RandomAccessFile} origin.
     * <p>
     * This origin cannot support File and Path since you cannot query a RandomAccessFile for those attributes; Use {@link IORandomAccessFileOrigin}
     * instead.
     * </p>
     *
     * @param <T> the type of instances to build.
     * @param <B> the type of builder subclass.
     */
    public abstract static class AbstractRandomAccessFileOrigin<T extends RandomAccessFile, B extends AbstractRandomAccessFileOrigin<T, B>> extends AbstractOrigin<T, B> {

        /**
         * A {@link RandomAccessFile} origin.
         * <p>
         * Starting from this origin, you can everything except a Path and a File.
         * </p>
         *
         * @param origin The origin, not null.
         */
        public AbstractRandomAccessFileOrigin(final T origin) {
            super(origin);
        }

        @Override
        public byte[] getByteArray() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public byte[] getByteArray(final long position, final int length) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CharSequence getCharSequence(final Charset charset) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("resource")
        @Override
        public InputStream getInputStream(final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public OutputStream getOutputStream(final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public T getRandomAccessFile(final OpenOption... openOption) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Reader getReader(final Charset charset) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Writer getWriter(final Charset charset, final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long size() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@code byte[]} origin.
     */
    public static class ByteArrayOrigin extends AbstractOrigin<byte[], ByteArrayOrigin> {

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public ByteArrayOrigin(final byte[] origin) {
            super(origin);
        }

        @Override
        public byte[] getByteArray() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code options} parameter is ignored since a {@code byte[]} does not need an {@link OpenOption} to be read.
         * </p>
         */
        @Override
        public InputStream getInputStream(final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Reader getReader(final Charset charset) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long size() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link CharSequence} origin.
     */
    public static class CharSequenceOrigin extends AbstractOrigin<CharSequence, CharSequenceOrigin> {

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public CharSequenceOrigin(final CharSequence origin) {
            super(origin);
        }

        @Override
        public byte[] getByteArray() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code charset} parameter is ignored since a {@link CharSequence} does not need a {@link Charset} to be read.
         * </p>
         */
        @Override
        public CharSequence getCharSequence(final Charset charset) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code options} parameter is ignored since a {@link CharSequence} does not need an {@link OpenOption} to be read.
         * </p>
         */
        @Override
        public InputStream getInputStream(final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code charset} parameter is ignored since a {@link CharSequence} does not need a {@link Charset} to be read.
         * </p>
         */
        @Override
        public Reader getReader(final Charset charset) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long size() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link File} origin.
     * <p>
     * Starting from this origin, you can get a byte array, a file, an input stream, an output stream, a path, a reader, and a writer.
     * </p>
     */
    public static class FileOrigin extends AbstractOrigin<File, FileOrigin> {

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public FileOrigin(final File origin) {
            super(origin);
        }

        @Override
        public byte[] getByteArray(final long position, final int length) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public File getFile() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Path getPath() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * An {@link InputStream} origin.
     * <p>
     * This origin cannot provide some of the other aspects.
     * </p>
     */
    public static class InputStreamOrigin extends AbstractOrigin<InputStream, InputStreamOrigin> {

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public InputStreamOrigin(final InputStream origin) {
            super(origin);
        }

        @Override
        public byte[] getByteArray() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code options} parameter is ignored since a {@link InputStream} does not need an {@link OpenOption} to be read.
         * </p>
         */
        @Override
        public InputStream getInputStream(final OpenOption... options) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Reader getReader(final Charset charset) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link IORandomAccessFile} origin.
     *
     * @since 2.18.0
     */
    public static class IORandomAccessFileOrigin extends AbstractRandomAccessFileOrigin<IORandomAccessFile, IORandomAccessFileOrigin> {

        /**
         * A {@link RandomAccessFile} origin.
         *
         * @param origin The origin, not null.
         */
        public IORandomAccessFileOrigin(final IORandomAccessFile origin) {
            super(origin);
        }

        @SuppressWarnings("resource")
        @Override
        public File getFile() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Path getPath() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * An {@link OutputStream} origin.
     * <p>
     * This origin cannot provide some of the other aspects.
     * </p>
     */
    public static class OutputStreamOrigin extends AbstractOrigin<OutputStream, OutputStreamOrigin> {

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public OutputStreamOrigin(final OutputStream origin) {
            super(origin);
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code options} parameter is ignored since a {@link OutputStream} does not need an {@link OpenOption} to be written.
         * </p>
         */
        @Override
        public OutputStream getOutputStream(final OpenOption... options) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code options} parameter is ignored since a {@link OutputStream} does not need an {@link OpenOption} to be written.
         * </p>
         */
        @Override
        public Writer getWriter(final Charset charset, final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link Path} origin.
     * <p>
     * Starting from this origin, you can get a byte array, a file, an input stream, an output stream, a path, a reader, and a writer.
     * </p>
     */
    public static class PathOrigin extends AbstractOrigin<Path, PathOrigin> {

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public PathOrigin(final Path origin) {
            super(origin);
        }

        @Override
        public byte[] getByteArray(final long position, final int length) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public File getFile() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Path getPath() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link RandomAccessFile} origin.
     * <p>
     * This origin cannot support File and Path since you cannot query a RandomAccessFile for those attributes; Use {@link IORandomAccessFileOrigin}
     * instead.
     * </p>
     */
    public static class RandomAccessFileOrigin extends AbstractRandomAccessFileOrigin<RandomAccessFile, RandomAccessFileOrigin> {

        /**
         * A {@link RandomAccessFile} origin.
         * <p>
         * Starting from this origin, you can everything except a Path and a File.
         * </p>
         *
         * @param origin The origin, not null.
         */
        public RandomAccessFileOrigin(final RandomAccessFile origin) {
            super(origin);
        }
    }

    /**
     * A {@link Reader} origin.
     * <p>
     * This origin cannot provide conversions to other aspects.
     * </p>
     */
    public static class ReaderOrigin extends AbstractOrigin<Reader, ReaderOrigin> {

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public ReaderOrigin(final Reader origin) {
            super(origin);
        }

        @Override
        public byte[] getByteArray() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code charset} parameter is ignored since a {@link Reader} does not need a {@link Charset} to be read.
         * </p>
         */
        @Override
        public CharSequence getCharSequence(final Charset charset) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code options} parameter is ignored since a {@link Reader} does not need an {@link OpenOption} to be read.
         * </p>
         */
        @Override
        public InputStream getInputStream(final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code charset} parameter is ignored since a {@link Reader} does not need a {@link Charset} to be read.
         * </p>
         */
        @Override
        public Reader getReader(final Charset charset) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link URI} origin.
     */
    public static class URIOrigin extends AbstractOrigin<URI, URIOrigin> {

        private static final String SCHEME_HTTPS = "https";

        private static final String SCHEME_HTTP = "http";

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public URIOrigin(final URI origin) {
            super(origin);
        }

        @Override
        public File getFile() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public InputStream getInputStream(final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Path getPath() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link Writer} origin.
     * <p>
     * This origin cannot provide conversions to other aspects.
     * </p>
     */
    public static class WriterOrigin extends AbstractOrigin<Writer, WriterOrigin> {

        /**
         * Constructs a new instance for the given origin.
         *
         * @param origin The origin, not null.
         */
        public WriterOrigin(final Writer origin) {
            super(origin);
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code options} parameter is ignored since a {@link Writer} does not need an {@link OpenOption} to be written.
         * </p>
         */
        @Override
        public OutputStream getOutputStream(final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         * <p>
         * The {@code charset} parameter is ignored since a {@link Writer} does not need a {@link Charset} to be written.
         * </p>
         * <p>
         * The {@code options} parameter is ignored since a {@link Writer} does not need an {@link OpenOption} to be written.
         * </p>
         */
        @Override
        public Writer getWriter(final Charset charset, final OpenOption... options) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * The non-null origin.
     */
    final T origin;

    /**
     * Constructs a new instance for subclasses.
     *
     * @param origin The origin, not null.
     */
    protected AbstractOrigin(final T origin) {
        this.origin = Objects.requireNonNull(origin, "origin");
    }

    /**
     * Gets the origin.
     *
     * @return the origin.
     */
    @Override
    public T get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets this origin as a byte array, if possible.
     *
     * @return this origin as a byte array, if possible.
     * @throws IOException                   if an I/O error occurs.
     * @throws UnsupportedOperationException if the origin cannot be converted to a Path.
     */
    public byte[] getByteArray() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets a portion of this origin as a byte array, if possible.
     *
     * @param position the initial index of the range to be copied, inclusive.
     * @param length   How many bytes to copy.
     * @return this origin as a byte array, if possible.
     * @throws UnsupportedOperationException if the origin cannot be converted to a Path.
     * @throws ArithmeticException           if the {@code position} overflows an int
     * @throws IOException                   if an I/O error occurs.
     * @since 2.13.0
     */
    public byte[] getByteArray(final long position, final int length) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets this origin as a byte array, if possible.
     *
     * @param charset The charset to use if conversion from bytes is needed.
     * @return this origin as a byte array, if possible.
     * @throws IOException                   if an I/O error occurs.
     * @throws UnsupportedOperationException if the origin cannot be converted to a Path.
     */
    public CharSequence getCharSequence(final Charset charset) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets this origin as a Path, if possible.
     *
     * @return this origin as a Path, if possible.
     * @throws UnsupportedOperationException if this method is not implemented in a concrete subclass.
     */
    public File getFile() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets this origin as an InputStream, if possible.
     *
     * @param options options specifying how the file is opened
     * @return this origin as an InputStream, if possible.
     * @throws IOException                   if an I/O error occurs.
     * @throws UnsupportedOperationException if the origin cannot be converted to a Path.
     */
    public InputStream getInputStream(final OpenOption... options) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets this origin as an OutputStream, if possible.
     *
     * @param options options specifying how the file is opened
     * @return this origin as an OutputStream, if possible.
     * @throws IOException                   if an I/O error occurs.
     * @throws UnsupportedOperationException if the origin cannot be converted to a Path.
     */
    public OutputStream getOutputStream(final OpenOption... options) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets this origin as a Path, if possible.
     *
     * @return this origin as a Path, if possible.
     * @throws UnsupportedOperationException if this method is not implemented in a concrete subclass.
     */
    public Path getPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets this origin as a RandomAccessFile, if possible.
     *
     * @param openOption options like {@link StandardOpenOption}.
     * @return this origin as a RandomAccessFile, if possible.
     * @throws FileNotFoundException         See {@link RandomAccessFile#RandomAccessFile(File, String)}.
     * @throws UnsupportedOperationException if this method is not implemented in a concrete subclass.
     * @since 2.18.0
     */
    public RandomAccessFile getRandomAccessFile(final OpenOption... openOption) throws FileNotFoundException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets a new Reader on the origin, buffered by default.
     *
     * @param charset the charset to use for decoding, null maps to the default Charset.
     * @return a new Reader on the origin.
     * @throws IOException if an I/O error occurs opening the file.
     */
    public Reader getReader(final Charset charset) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String getSimpleClassName() {
        return getClass().getSimpleName();
    }

    /**
     * Gets a new Writer on the origin, buffered by default.
     *
     * @param charset the charset to use for encoding
     * @param options options specifying how the file is opened
     * @return a new Writer on the origin.
     * @throws IOException                   if an I/O error occurs opening or creating the file.
     * @throws UnsupportedOperationException if the origin cannot be converted to a Path.
     */
    public Writer getWriter(final Charset charset, final OpenOption... options) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the size of the origin, if possible.
     *
     * @return the size of the origin in bytes or characters.
     * @throws IOException if an I/O error occurs.
     * @since 2.13.0
     */
    public long size() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
