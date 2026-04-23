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
package org.apache.commons.io.monitor;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Stream;
import org.apache.commons.io.ThreadUtils;

/**
 * A runnable that spawns a monitoring thread triggering any
 * registered {@link FileAlterationObserver} at a specified interval.
 *
 * @see FileAlterationObserver
 * @since 2.0
 */
public final class FileAlterationMonitor implements Runnable {

    private static final FileAlterationObserver[] EMPTY_ARRAY = {};

    private final long intervalMillis;

    private final List<FileAlterationObserver> observers = new CopyOnWriteArrayList<>();

    private Thread thread;

    private ThreadFactory threadFactory;

    private volatile boolean running;

    /**
     * Constructs a monitor with a default interval of 10 seconds.
     */
    public FileAlterationMonitor() {
        this(10_000);
    }

    /**
     * Constructs a monitor with the specified interval.
     *
     * @param intervalMillis The amount of time in milliseconds to wait between
     * checks of the file system.
     */
    public FileAlterationMonitor(final long intervalMillis) {
        this.intervalMillis = intervalMillis;
    }

    /**
     * Constructs a monitor with the specified interval and collection of observers.
     *
     * @param interval The amount of time in milliseconds to wait between
     * checks of the file system.
     * @param observers The collection of observers to add to the monitor.
     * @since 2.9.0
     */
    public FileAlterationMonitor(final long interval, final Collection<FileAlterationObserver> observers) {
        // @formatter:off
        this(interval, Optional.ofNullable(observers).orElse(Collections.emptyList()).toArray(EMPTY_ARRAY));
        // @formatter:on
    }

    /**
     * Constructs a monitor with the specified interval and set of observers.
     *
     * @param interval The amount of time in milliseconds to wait between
     * checks of the file system.
     * @param observers The set of observers to add to the monitor.
     */
    public FileAlterationMonitor(final long interval, final FileAlterationObserver... observers) {
        this(interval);
        if (observers != null) {
            Stream.of(observers).forEach(this::addObserver);
        }
    }

    /**
     * Adds a file system observer to this monitor.
     *
     * @param observer The file system observer to add
     */
    public void addObserver(final FileAlterationObserver observer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the interval.
     *
     * @return the interval
     */
    public long getInterval() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the set of {@link FileAlterationObserver} registered with
     * this monitor.
     *
     * @return The set of {@link FileAlterationObserver}
     */
    public Iterable<FileAlterationObserver> getObservers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Removes a file system observer from this monitor.
     *
     * @param observer The file system observer to remove
     */
    public void removeObserver(final FileAlterationObserver observer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs this monitor.
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the thread factory.
     *
     * @param threadFactory the thread factory
     */
    public synchronized void setThreadFactory(final ThreadFactory threadFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Starts monitoring.
     *
     * @throws Exception if an error occurs initializing the observer
     */
    public synchronized void start() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Stops monitoring.
     *
     * @throws Exception if an error occurs initializing the observer
     */
    public synchronized void stop() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Stops monitoring.
     *
     * @param stopInterval the amount of time in milliseconds to wait for the thread to finish.
     * A value of zero will wait until the thread is finished (see {@link Thread#join(long)}).
     * @throws Exception if an error occurs initializing the observer
     * @since 2.1
     */
    public synchronized void stop(final long stopInterval) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
