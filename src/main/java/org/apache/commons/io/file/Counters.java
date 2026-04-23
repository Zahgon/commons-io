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

import java.math.BigInteger;
import java.util.Objects;

/**
 * Provides counters for files, directories, and sizes, as a visit proceeds.
 *
 * @since 2.7
 */
public class Counters {

    /**
     * Counts files, directories, and sizes, as a visit proceeds.
     */
    private static class AbstractPathCounters implements PathCounters {

        private final Counter byteCounter;

        private final Counter directoryCounter;

        private final Counter fileCounter;

        /**
         * Constructs a new instance.
         *
         * @param byteCounter the byte counter.
         * @param directoryCounter the directory counter.
         * @param fileCounter the file counter.
         */
        protected AbstractPathCounters(final Counter byteCounter, final Counter directoryCounter, final Counter fileCounter) {
            this.byteCounter = byteCounter;
            this.directoryCounter = directoryCounter;
            this.fileCounter = fileCounter;
        }

        @Override
        public boolean equals(final Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Counter getByteCounter() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Counter getDirectoryCounter() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Gets the count of visited files.
         *
         * @return the byte count of visited files.
         */
        @Override
        public Counter getFileCounter() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void reset() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Counts using a {@link BigInteger} number.
     */
    private static final class BigIntegerCounter implements Counter {

        private BigInteger value = BigInteger.ZERO;

        @Override
        public void add(final long val) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(final Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public BigInteger getBigInteger() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Long getLong() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void increment() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void reset() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Counts files, directories, and sizes, as a visit proceeds, using BigInteger numbers.
     */
    private static final class BigIntegerPathCounters extends AbstractPathCounters {

        /**
         * Constructs a new initialized instance.
         */
        protected BigIntegerPathCounters() {
            super(bigIntegerCounter(), bigIntegerCounter(), bigIntegerCounter());
        }
    }

    /**
     * Counts using a number.
     */
    public interface Counter {

        /**
         * Adds the given number to this counter.
         *
         * @param val the value to add.
         */
        void add(long val);

        /**
         * Gets the counter as a long.
         *
         * @return the counter as a long.
         */
        long get();

        /**
         * Gets the counter as a BigInteger.
         *
         * @return the counter as a BigInteger.
         */
        BigInteger getBigInteger();

        /**
         * Gets the counter as a Long.
         *
         * @return the counter as a Long.
         */
        Long getLong();

        /**
         * Adds one to this counter.
         */
        void increment();

        /**
         * Resets this count to 0.
         */
        default void reset() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Counts using a {@code long} number.
     */
    private static final class LongCounter implements Counter {

        private long value;

        @Override
        public void add(final long add) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(final Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public BigInteger getBigInteger() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Long getLong() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void increment() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void reset() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Counts files, directories, and sizes, as a visit proceeds, using long numbers.
     */
    private static final class LongPathCounters extends AbstractPathCounters {

        /**
         * Constructs a new initialized instance.
         */
        protected LongPathCounters() {
            super(longCounter(), longCounter(), longCounter());
        }
    }

    /**
     * Counts nothing.
     */
    private static final class NoopCounter implements Counter {

        static final NoopCounter INSTANCE = new NoopCounter();

        @Override
        public void add(final long add) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public BigInteger getBigInteger() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Long getLong() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void increment() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Returns {@code "0"}, always.
         *
         * @return {@code "0"}, always.
         * @since 2.12.0
         */
        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Counts nothing.
     */
    private static final class NoopPathCounters extends AbstractPathCounters {

        static final NoopPathCounters INSTANCE = new NoopPathCounters();

        /**
         * Constructs a new initialized instance.
         */
        private NoopPathCounters() {
            super(noopCounter(), noopCounter(), noopCounter());
        }
    }

    /**
     * Counts files, directories, and sizes, as a visit proceeds.
     */
    public interface PathCounters {

        /**
         * Gets the byte counter.
         *
         * @return the byte counter.
         */
        Counter getByteCounter();

        /**
         * Gets the directory counter.
         *
         * @return the directory counter.
         */
        Counter getDirectoryCounter();

        /**
         * Gets the file counter.
         *
         * @return the file counter.
         */
        Counter getFileCounter();

        /**
         * Resets the counts to 0.
         */
        default void reset() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Returns a new BigInteger Counter.
     *
     * @return a new BigInteger Counter.
     */
    public static Counter bigIntegerCounter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new BigInteger PathCounters.
     *
     * @return a new BigInteger PathCounters.
     */
    public static PathCounters bigIntegerPathCounters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new long Counter.
     *
     * @return a new long Counter.
     */
    public static Counter longCounter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new BigInteger PathCounters.
     *
     * @return a new BigInteger PathCounters.
     */
    public static PathCounters longPathCounters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the no-op Counter.
     *
     * @return the no-op Counter.
     * @since 2.9.0
     */
    public static Counter noopCounter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the no-op PathCounters.
     *
     * @return the no-op PathCounters.
     * @since 2.9.0
     */
    public static PathCounters noopPathCounters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a new instance.
     *
     * @deprecated Will be private in 4.0
     */
    @Deprecated
    public Counters() {
        // empty
    }
}
