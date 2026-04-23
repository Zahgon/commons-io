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
package org.apache.commons.io.file;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.function.UnaryOperator;
import org.apache.commons.io.file.Counters.PathCounters;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SymbolicLinkFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.function.IOBiFunction;

/**
 * Counts files, directories, and sizes, as a visit proceeds.
 *
 * @since 2.7
 */
public class CountingPathVisitor extends SimplePathVisitor {

    /**
     * Builds instances of {@link CountingPathVisitor}.
     *
     * @param <T> The CountingPathVisitor type.
     * @param <B> The AbstractBuilder type.
     * @since 2.19.0
     */
    public abstract static class AbstractBuilder<T, B extends AbstractBuilder<T, B>> extends SimplePathVisitor.AbstractBuilder<T, B> {

        private PathCounters pathCounters = defaultPathCounters();

        private PathFilter fileFilter = defaultFileFilter();

        private PathFilter directoryFilter = defaultDirectoryFilter();

        private UnaryOperator<Path> directoryPostTransformer = defaultDirectoryTransformer();

        /**
         * Constructs a new builder for subclasses.
         */
        public AbstractBuilder() {
            // empty.
        }

        PathFilter getDirectoryFilter() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        UnaryOperator<Path> getDirectoryPostTransformer() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        PathFilter getFileFilter() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        PathCounters getPathCounters() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets how to filter directories.
         *
         * @param directoryFilter how to filter files.
         * @return this instance.
         */
        public B setDirectoryFilter(final PathFilter directoryFilter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets how to transform directories, defaults to {@link UnaryOperator#identity()}.
         *
         * @param directoryTransformer how to filter files.
         * @return this instance.
         */
        public B setDirectoryPostTransformer(final UnaryOperator<Path> directoryTransformer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets how to filter files.
         *
         * @param fileFilter how to filter files.
         * @return this instance.
         */
        public B setFileFilter(final PathFilter fileFilter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets how to count path visits.
         *
         * @param pathCounters How to count path visits.
         * @return this instance.
         */
        public B setPathCounters(final PathCounters pathCounters) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Builds instances of {@link CountingPathVisitor}.
     *
     * @since 2.18.0
     */
    public static class Builder extends AbstractBuilder<CountingPathVisitor, Builder> {

        /**
         * Constructs a new builder.
         */
        public Builder() {
            // empty.
        }

        @Override
        public CountingPathVisitor get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static final String[] EMPTY_STRING_ARRAY = {};

    static IOFileFilter defaultDirectoryFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static UnaryOperator<Path> defaultDirectoryTransformer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static IOFileFilter defaultFileFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static PathCounters defaultPathCounters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Constructs a new instance configured with a {@link BigInteger} {@link PathCounters}.
     *
     * @return a new instance configured with a {@link BigInteger} {@link PathCounters}.
     */
    public static CountingPathVisitor withBigIntegerCounters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Constructs a new instance configured with a {@code long} {@link PathCounters}.
     *
     * @return a new instance configured with a {@code long} {@link PathCounters}.
     */
    public static CountingPathVisitor withLongCounters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final PathCounters pathCounters;

    private final PathFilter fileFilter;

    private final PathFilter directoryFilter;

    private final UnaryOperator<Path> directoryPostTransformer;

    CountingPathVisitor(final AbstractBuilder<?, ?> builder) {
        super(builder);
        this.pathCounters = builder.getPathCounters();
        this.fileFilter = builder.getFileFilter();
        this.directoryFilter = builder.getDirectoryFilter();
        this.directoryPostTransformer = builder.getDirectoryPostTransformer();
    }

    /**
     * Constructs a new instance.
     *
     * @param pathCounters How to count path visits.
     * @see Builder
     */
    public CountingPathVisitor(final PathCounters pathCounters) {
        this(new Builder().setPathCounters(pathCounters));
    }

    /**
     * Constructs a new instance.
     *
     * @param pathCounters    How to count path visits.
     * @param fileFilter      Filters which files to count.
     * @param directoryFilter Filters which directories to count.
     * @see Builder
     * @since 2.9.0
     */
    public CountingPathVisitor(final PathCounters pathCounters, final PathFilter fileFilter, final PathFilter directoryFilter) {
        this.pathCounters = Objects.requireNonNull(pathCounters, "pathCounters");
        this.fileFilter = Objects.requireNonNull(fileFilter, "fileFilter");
        this.directoryFilter = Objects.requireNonNull(directoryFilter, "directoryFilter");
        this.directoryPostTransformer = UnaryOperator.identity();
    }

    /**
     * Constructs a new instance.
     *
     * @param pathCounters    How to count path visits.
     * @param fileFilter      Filters which files to count.
     * @param directoryFilter Filters which directories to count.
     * @param visitFileFailed Called on {@link #visitFileFailed(Path, IOException)}.
     * @since 2.12.0
     * @deprecated Use {@link Builder}.
     */
    @Deprecated
    public CountingPathVisitor(final PathCounters pathCounters, final PathFilter fileFilter, final PathFilter directoryFilter, final IOBiFunction<Path, IOException, FileVisitResult> visitFileFailed) {
        super(visitFileFailed);
        this.pathCounters = Objects.requireNonNull(pathCounters, "pathCounters");
        this.fileFilter = Objects.requireNonNull(fileFilter, "fileFilter");
        this.directoryFilter = Objects.requireNonNull(directoryFilter, "directoryFilter");
        this.directoryPostTransformer = UnaryOperator.identity();
    }

    /**
     * Tests whether the given file is accepted by the file filter.
     *
     * @param file       the visited file.
     * @param attributes the visited file attributes.
     * @return true to copy the given file, false if not.
     * @since 2.20.0
     */
    protected boolean accept(final Path file, final BasicFileAttributes attributes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(final Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the visitation counts.
     *
     * @return the visitation counts.
     */
    public PathCounters getPathCounters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attributes) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Updates the counter for visiting the given directory.
     *
     * @param dir the visited directory.
     * @param exc Encountered exception.
     * @since 2.9.0
     */
    protected void updateDirCounter(final Path dir, final IOException exc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Updates the counters for visiting the given file.
     *
     * @param file       the visited file.
     * @param attributes the visited file attributes.
     */
    protected void updateFileCounters(final Path file, final BasicFileAttributes attributes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attributes) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
