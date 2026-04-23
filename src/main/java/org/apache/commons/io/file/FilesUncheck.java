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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Stream;
import org.apache.commons.io.function.Uncheck;

/**
 * Delegates to {@link Files} to uncheck calls by throwing {@link UncheckedIOException} instead of {@link IOException}.
 *
 * @see Files
 * @see IOException
 * @see UncheckedIOException
 * @since 2.12.0
 */
public final class FilesUncheck {

    /**
     * Delegates to {@link Files#copy(InputStream, Path, CopyOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param in See delegate.
     * @param target See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     * @see Files#copy(InputStream, Path,CopyOption...)
     */
    public static long copy(final InputStream in, final Path target, final CopyOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#copy(Path, OutputStream)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param source See delegate. See delegate.
     * @param out See delegate. See delegate.
     * @return See delegate. See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static long copy(final Path source, final OutputStream out) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#copy(Path, Path, CopyOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param source See delegate.
     * @param target See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path copy(final Path source, final Path target, final CopyOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createDirectories(Path, FileAttribute...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param dir See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createDirectories(final Path dir, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createDirectory(Path, FileAttribute...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param dir See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createDirectory(final Path dir, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createFile(Path, FileAttribute...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createFile(final Path path, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createLink(Path, Path)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param link See delegate.
     * @param existing See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createLink(final Path link, final Path existing) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createSymbolicLink(Path, Path, FileAttribute...)} throwing {@link UncheckedIOException}
     * instead of {@link IOException}.
     *
     * @param link See delegate.
     * @param target See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createSymbolicLink(final Path link, final Path target, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createTempDirectory(Path, String, FileAttribute...)} throwing {@link UncheckedIOException}
     * instead of {@link IOException}.
     *
     * @param dir See delegate.
     * @param prefix See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createTempDirectory(final Path dir, final String prefix, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createTempDirectory(String, FileAttribute...)} throwing {@link UncheckedIOException}
     * instead of {@link IOException}.
     *
     * @param prefix See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createTempDirectory(final String prefix, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createTempFile(Path, String, String, FileAttribute...)} throwing
     * {@link UncheckedIOException} instead of {@link IOException}.
     *
     * @param dir See delegate.
     * @param prefix See delegate.
     * @param suffix See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createTempFile(final Path dir, final String prefix, final String suffix, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#createTempFile(String, String, FileAttribute...)} throwing {@link UncheckedIOException}
     * instead of {@link IOException}.
     *
     * @param prefix See delegate.
     * @param suffix See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path createTempFile(final String prefix, final String suffix, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#delete(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     *
     * @param path See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static void delete(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#deleteIfExists(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     *
     * @param path See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static boolean deleteIfExists(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#find(Path, int, BiPredicate, FileVisitOption...)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     * <p>
     * The returned {@link Stream} wraps a {@link DirectoryStream}. When you require timely disposal of file system resources, use a {@code try}-with-resources
     * block to ensure invocation of the stream's {@link Stream#close()} method after the stream operations are completed.
     * </p>
     *
     * @param start    See delegate.
     * @param maxDepth See delegate.
     * @param matcher  See delegate.
     * @param options  See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     * @since 2.14.0
     */
    public static Stream<Path> find(final Path start, final int maxDepth, final BiPredicate<Path, BasicFileAttributes> matcher, final FileVisitOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#getAttribute(Path, String, LinkOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param attribute See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Object getAttribute(final Path path, final String attribute, final LinkOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#getFileStore(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     *
     * @param path See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static FileStore getFileStore(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#getLastModifiedTime(Path, LinkOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static FileTime getLastModifiedTime(final Path path, final LinkOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#getOwner(Path, LinkOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static UserPrincipal getOwner(final Path path, final LinkOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#getPosixFilePermissions(Path, LinkOption...)} throwing {@link UncheckedIOException} instead
     * of {@link IOException}.
     *
     * @param path See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Set<PosixFilePermission> getPosixFilePermissions(final Path path, final LinkOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#isHidden(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     *
     * @param path See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static boolean isHidden(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#isSameFile(Path, Path)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param path2 See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static boolean isSameFile(final Path path, final Path path2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#lines(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     * <p>
     * The returned {@link Stream} wraps a {@link Reader}. When you require timely disposal of file system resources, use a {@code try}-with-resources block to
     * ensure invocation of the stream's {@link Stream#close()} method after the stream operations are completed.
     * </p>
     *
     * @param path See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Stream<String> lines(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#lines(Path, Charset)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     * <p>
     * The returned {@link Stream} wraps a {@link Reader}. When you require timely disposal of file system resources, use a {@code try}-with-resources block to
     * ensure invocation of the stream's {@link Stream#close()} method after the stream operations are completed.
     * </p>
     *
     * @param path See delegate.
     * @param cs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Stream<String> lines(final Path path, final Charset cs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#list(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     * <p>
     * The returned {@link Stream} wraps a {@link DirectoryStream}. When you require timely disposal of file system resources, use a {@code try}-with-resources
     * block to ensure invocation of the stream's {@link Stream#close()} method after the stream operations are completed.
     * </p>
     *
     * @param dir See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Stream<Path> list(final Path dir) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#move(Path, Path, CopyOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param source See delegate.
     * @param target See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static Path move(final Path source, final Path target, final CopyOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newBufferedReader(Path)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static BufferedReader newBufferedReader(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newBufferedReader(Path, Charset)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param cs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static BufferedReader newBufferedReader(final Path path, final Charset cs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newBufferedWriter(Path, Charset, OpenOption...)} throwing {@link UncheckedIOException}
     * instead of {@link IOException}.
     *
     * @param path See delegate.
     * @param cs See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static BufferedWriter newBufferedWriter(final Path path, final Charset cs, final OpenOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newBufferedWriter(Path, OpenOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static BufferedWriter newBufferedWriter(final Path path, final OpenOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newByteChannel(Path, OpenOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param options See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static SeekableByteChannel newByteChannel(final Path path, final OpenOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newByteChannel(Path, Set, FileAttribute...)} throwing {@link UncheckedIOException} instead
     * of {@link IOException}.
     *
     * @param path See delegate.
     * @param options See delegate.
     * @param attrs See delegate.
     * @return See delegate.
     * @throws UncheckedIOException Wraps an {@link IOException}.
     */
    public static SeekableByteChannel newByteChannel(final Path path, final Set<? extends OpenOption> options, final FileAttribute<?>... attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newDirectoryStream(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     * <p>
     * If you don't use the try-with-resources construct, then you must call the stream's {@link Stream#close()} method after iteration is complete to free any
     * resources held for the open directory.
     * </p>
     *
     * @param dir See delegate.
     * @return See delegate.
     */
    public static DirectoryStream<Path> newDirectoryStream(final Path dir) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newDirectoryStream(Path, java.nio.file.DirectoryStream.Filter)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     * <p>
     * If you don't use the try-with-resources construct, then you must call the stream's {@link Stream#close()} method after iteration is complete to free any
     * resources held for the open directory.
     * </p>
     *
     * @param dir    See delegate.
     * @param filter See delegate.
     * @return See delegate.
     */
    public static DirectoryStream<Path> newDirectoryStream(final Path dir, final DirectoryStream.Filter<? super Path> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newDirectoryStream(Path, String)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     * <p>
     * The returned {@link Stream} wraps a {@link DirectoryStream}. When you require timely disposal of file system resources, use a {@code try}-with-resources
     * block to ensure invocation of the stream's {@link Stream#close()} method after the stream operations are completed.
     * </p>
     *
     * @param dir See delegate.
     * @param glob See delegate.
     * @return See delegate.
     */
    public static DirectoryStream<Path> newDirectoryStream(final Path dir, final String glob) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newInputStream(Path, OpenOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static InputStream newInputStream(final Path path, final OpenOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#newOutputStream(Path, OpenOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static OutputStream newOutputStream(final Path path, final OpenOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#probeContentType(Path)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @return See delegate.
     */
    public static String probeContentType(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#readAllBytes(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     *
     * @param path See delegate.
     * @return See delegate.
     */
    public static byte[] readAllBytes(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#readAllLines(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     *
     * @param path See delegate.
     * @return See delegate.
     */
    public static List<String> readAllLines(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#readAllLines(Path, Charset)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param cs See delegate.
     * @return See delegate.
     */
    public static List<String> readAllLines(final Path path, final Charset cs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#readAttributes(Path, Class, LinkOption...)} throwing {@link UncheckedIOException} instead
     * of {@link IOException}.
     *
     * @param <A> See delegate.
     * @param path See delegate.
     * @param type See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static <A extends BasicFileAttributes> A readAttributes(final Path path, final Class<A> type, final LinkOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#readAttributes(Path, String, LinkOption...)} throwing {@link UncheckedIOException} instead
     * of {@link IOException}.
     *
     * @param path See delegate.
     * @param attributes See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static Map<String, Object> readAttributes(final Path path, final String attributes, final LinkOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#readSymbolicLink(Path)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param link See delegate.
     * @return See delegate.
     */
    public static Path readSymbolicLink(final Path link) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#setAttribute(Path, String, Object, LinkOption...)} throwing {@link UncheckedIOException}
     * instead of {@link IOException}.
     *
     * @param path See delegate.
     * @param attribute See delegate.
     * @param value See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static Path setAttribute(final Path path, final String attribute, final Object value, final LinkOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#setLastModifiedTime(Path, FileTime)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param time See delegate.
     * @return See delegate.
     */
    public static Path setLastModifiedTime(final Path path, final FileTime time) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#setOwner(Path, UserPrincipal)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param owner See delegate.
     * @return See delegate.
     */
    public static Path setOwner(final Path path, final UserPrincipal owner) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#setPosixFilePermissions(Path, Set)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param perms See delegate.
     * @return See delegate.
     */
    public static Path setPosixFilePermissions(final Path path, final Set<PosixFilePermission> perms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#size(Path)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     *
     * @param path See delegate.
     * @return See delegate.
     */
    public static long size(final Path path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#walk(Path, FileVisitOption...)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     * <p>
     * The returned {@link Stream} may wrap one or more {@link DirectoryStream}s. When you require timely disposal of file system resources, use a
     * {@code try}-with-resources block to ensure invocation of the stream's {@link Stream#close()} method after the stream operations are completed. Calling a
     * closed stream causes a {@link IllegalStateException}.
     * </p>
     *
     * @param start   See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static Stream<Path> walk(final Path start, final FileVisitOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#walk(Path, int, FileVisitOption...)} throwing {@link UncheckedIOException} instead of {@link IOException}.
     * <p>
     * The returned {@link Stream} may wrap one or more {@link DirectoryStream}s. When you require timely disposal of file system resources, use a
     * {@code try}-with-resources block to ensure invocation of the stream's {@link Stream#close()} method after the stream operations are completed. Calling a
     * closed stream causes a {@link IllegalStateException}.
     * </p>
     *
     * @param start    See delegate.
     * @param maxDepth See delegate.
     * @param options  See delegate.
     * @return See delegate.
     */
    public static Stream<Path> walk(final Path start, final int maxDepth, final FileVisitOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#walkFileTree(Path, FileVisitor)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param start See delegate.
     * @param visitor See delegate.
     * @return See delegate.
     */
    public static Path walkFileTree(final Path start, final FileVisitor<? super Path> visitor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#walkFileTree(Path, Set, int, FileVisitor)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param start See delegate.
     * @param options See delegate.
     * @param maxDepth See delegate.
     * @param visitor See delegate.
     * @return See delegate.
     */
    public static Path walkFileTree(final Path start, final Set<FileVisitOption> options, final int maxDepth, final FileVisitor<? super Path> visitor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#write(Path, byte[], OpenOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param bytes See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static Path write(final Path path, final byte[] bytes, final OpenOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#write(Path, Iterable, Charset, OpenOption...)} throwing {@link UncheckedIOException}
     * instead of {@link IOException}.
     *
     * @param path See delegate.
     * @param lines See delegate.
     * @param cs See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static Path write(final Path path, final Iterable<? extends CharSequence> lines, final Charset cs, final OpenOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Delegates to {@link Files#write(Path, Iterable, OpenOption...)} throwing {@link UncheckedIOException} instead of
     * {@link IOException}.
     *
     * @param path See delegate.
     * @param lines See delegate.
     * @param options See delegate.
     * @return See delegate.
     */
    public static Path write(final Path path, final Iterable<? extends CharSequence> lines, final OpenOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * No instances.
     */
    private FilesUncheck() {
        // No instances
    }
}
