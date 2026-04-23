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
package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * A file filter that always returns false.
 * <h2>Deprecating Serialization</h2>
 * <p>
 * <em>Serialization is deprecated and will be removed in 3.0.</em>
 * </p>
 *
 * @since 1.0
 * @see FileFilterUtils#falseFileFilter()
 */
public class FalseFileFilter implements IOFileFilter, Serializable {

    private static final String TO_STRING = Boolean.FALSE.toString();

    /**
     * Singleton instance of false filter.
     *
     * @since 1.3
     */
    public static final IOFileFilter FALSE = new FalseFileFilter();

    /**
     * Singleton instance of false filter. Please use the identical FalseFileFilter.FALSE constant. The new name is more
     * JDK 1.5 friendly as it doesn't clash with other values when using static imports.
     */
    public static final IOFileFilter INSTANCE = FALSE;

    private static final long serialVersionUID = 6210271677940926200L;

    /**
     * Restrictive constructor.
     */
    protected FalseFileFilter() {
    }

    /**
     * Returns false.
     *
     * @param file the file to check (ignored)
     * @return false
     */
    @Override
    public boolean accept(final File file) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns false.
     *
     * @param dir the directory to check (ignored)
     * @param name the file name (ignored)
     * @return false
     */
    @Override
    public boolean accept(final File dir, final String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns false.
     *
     * @param file the file to check (ignored)
     * @param attributes the path's basic attributes (may be null).
     * @return false
     * @since 2.9.0
     */
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IOFileFilter and(final IOFileFilter fileFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IOFileFilter negate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IOFileFilter or(final IOFileFilter fileFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
