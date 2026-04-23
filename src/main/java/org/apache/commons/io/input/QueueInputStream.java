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
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.output.QueueOutputStream;

/**
 * Simple alternative to JDK {@link PipedInputStream}; queue input stream provides what's written in queue output stream.
 * <p>
 * To build an instance, use {@link Builder}.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * QueueInputStream inputStream = new QueueInputStream();
 * QueueOutputStream outputStream = inputStream.newQueueOutputStream();
 *
 * outputStream.write("hello world".getBytes(UTF_8));
 * inputStream.read();
 * </pre>
 * <p>
 * Unlike JDK {@link PipedInputStream} and {@link PipedOutputStream}, queue input/output streams may be used safely in a single thread or multiple threads.
 * Also, unlike JDK classes, no special meaning is attached to initial or current thread. Instances can be used longer after initial threads exited.
 * </p>
 * <p>
 * Closing a {@link QueueInputStream} has no effect. The methods in this class can be called after the stream has been closed without generating an
 * {@link IOException}.
 * </p>
 *
 * @see Builder
 * @see QueueOutputStream
 * @since 2.9.0
 */
public class QueueInputStream extends InputStream {

    // @formatter:off
    /**
     * Builds a new {@link QueueInputStream}.
     *
     * <p>
     * For example:
     * </p>
     * <pre>{@code
     * QueueInputStream s = QueueInputStream.builder()
     *   .setBlockingQueue(new LinkedBlockingQueue<>())
     *   .setTimeout(Duration.ZERO)
     *   .get();}
     * </pre>
     *
     * @see #get()
     * @since 2.12.0
     */
    // @formatter:on
    public static class Builder extends AbstractStreamBuilder<QueueInputStream, Builder> {

        private BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        private Duration timeout = Duration.ZERO;

        /**
         * Constructs a new builder of {@link QueueInputStream}.
         */
        public Builder() {
            // empty
        }

        /**
         * Builds a new {@link QueueInputStream}.
         * <p>
         * This builder uses the following aspects:
         * </p>
         * <ul>
         * <li>{@link #setBlockingQueue(BlockingQueue)}</li>
         * <li>timeout</li>
         * </ul>
         *
         * @return a new instance.
         * @see #getUnchecked()
         */
        @Override
        public QueueInputStream get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets backing queue for the stream.
         *
         * @param blockingQueue backing queue for the stream, null resets to a new blocking queue instance.
         * @return {@code this} instance.
         */
        public Builder setBlockingQueue(final BlockingQueue<Integer> blockingQueue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the polling timeout.
         *
         * @param timeout the polling timeout.
         * @return {@code this} instance.
         */
        public Builder setTimeout(final Duration timeout) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Constructs a new {@link Builder}.
     *
     * @return a new {@link Builder}.
     * @since 2.12.0
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final BlockingQueue<Integer> blockingQueue;

    private final long timeoutNanos;

    /**
     * Constructs a new instance with no limit to its internal queue size and zero timeout.
     */
    public QueueInputStream() {
        this(new LinkedBlockingQueue<>());
    }

    /**
     * Constructs a new instance with given queue and zero timeout.
     *
     * @param blockingQueue backing queue for the stream, null maps to a new blocking queue instance.
     * @deprecated Use {@link #builder()}, {@link Builder}, and {@link Builder#get()}.
     */
    @Deprecated
    public QueueInputStream(final BlockingQueue<Integer> blockingQueue) {
        this(builder().setBlockingQueue(blockingQueue));
    }

    /**
     * Constructs a new instance.
     *
     * @param builder The builder.
     */
    private QueueInputStream(final Builder builder) {
        this.blockingQueue = Objects.requireNonNull(builder.blockingQueue, "blockingQueue");
        this.timeoutNanos = Objects.requireNonNull(builder.timeout, "timeout").toNanos();
    }

    /**
     * Gets the blocking queue.
     *
     * @return the blocking queue.
     */
    BlockingQueue<Integer> getBlockingQueue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the timeout duration.
     *
     * @return the timeout duration.
     */
    Duration getTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Constructs a new QueueOutputStream instance connected to this. Writes to the output stream will be visible to this input stream.
     *
     * @return QueueOutputStream connected to this stream.
     */
    public QueueOutputStream newQueueOutputStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads and returns a single byte.
     *
     * @return the byte read, or {@code -1} if a timeout occurs before a queue element is available.
     * @throws IllegalStateException if thread is interrupted while waiting.
     */
    @Override
    public int read() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads up to {@code length} bytes of data from the input stream into
     * an array of bytes.  The first byte is read while honoring the timeout; the rest are read while <i>not</i> honoring
     * the timeout. The number of bytes actually read is returned as an integer.
     *
     * @param b     the buffer into which the data is read.
     * @param offset   the start offset in array {@code b} at which the data is written.
     * @param length   the maximum number of bytes to read.
     * @return     the total number of bytes read into the buffer, or {@code -1} if there is no more data because the
     *              end of the stream has been reached.
     * @throws NullPointerException If {@code b} is {@code null}.
     * @throws IllegalStateException if thread is interrupted while waiting for the first byte.
     * @throws IndexOutOfBoundsException if {@code offset} is negative, {@code length} is negative, or {@code length} is
     *             greater than {@code b.length - offset}.
     * @since 2.20.0
     */
    @Override
    public int read(final byte[] b, final int offset, final int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
