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
package org.apache.commons.io.file.spi;

import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Helps to work with {@link FileSystemProvider}.
 *
 * @since 2.9.0
 */
public class // NOPMD Class will be final in 3.0.
FileSystemProviders {

    private static final String SCHEME_FILE = "file";

    private static final FileSystemProviders INSTALLED = new FileSystemProviders(FileSystemProvider.installedProviders());

    /**
     * Gets the {@link FileSystemProvider} for the given Path.
     *
     * @param path The Path to query
     * @return the {@link FileSystemProvider} for the given Path.
     */
    // FileSystem is not allocated here.
    @SuppressWarnings("resource")
    public static FileSystemProvider getFileSystemProvider(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the instance for the installed providers.
     *
     * @return the instance for the installed providers.
     * @see FileSystemProvider#installedProviders()
     */
    public static FileSystemProviders installed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final List<FileSystemProvider> providers;

    /*
     * Might make public later.
     */
    private FileSystemProviders(final List<FileSystemProvider> providers) {
        this.providers = providers != null ? providers : Collections.emptyList();
    }

    /**
     * Gets the {@link FileSystemProvider} for the given scheme.
     *
     * @param scheme The scheme to query.
     * @return the {@link FileSystemProvider} for the given URI or null.
     */
    // FileSystems.getDefault() returns a constant.
    @SuppressWarnings("resource")
    public FileSystemProvider getFileSystemProvider(final String scheme) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the {@link FileSystemProvider} for the given URI.
     *
     * @param uri The URI to query
     * @return the {@link FileSystemProvider} for the given URI or null.
     */
    public FileSystemProvider getFileSystemProvider(final URI uri) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the {@link FileSystemProvider} for the given URL.
     *
     * @param url The URL to query
     * @return the {@link FileSystemProvider} for the given URI or null.
     */
    public FileSystemProvider getFileSystemProvider(final URL url) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
