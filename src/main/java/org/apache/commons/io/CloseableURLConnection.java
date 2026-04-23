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
package org.apache.commons.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Delegates to a URLConnection while implementing AutoCloseable.
 */
final class CloseableURLConnection extends URLConnection implements AutoCloseable {

    static CloseableURLConnection open(final URI uri) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static CloseableURLConnection open(final URL url) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final URLConnection urlConnection;

    CloseableURLConnection(final URLConnection urlConnection) {
        super(Objects.requireNonNull(urlConnection, "urlConnection").getURL());
        this.urlConnection = urlConnection;
    }

    @Override
    public void addRequestProperty(final String key, final String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void connect() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(final Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean getAllowUserInteraction() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getConnectTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getContent() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getContent(@SuppressWarnings("rawtypes") final Class[] classes) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getContentEncoding() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getContentLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getContentLengthLong() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getContentType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getDate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean getDefaultUseCaches() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean getDoInput() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean getDoOutput() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getExpiration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getHeaderField(final int n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getHeaderField(final String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getHeaderFieldDate(final String name, final long Default) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getHeaderFieldInt(final String name, final int Default) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getHeaderFieldKey(final int n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getHeaderFieldLong(final String name, final long Default) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, List<String>> getHeaderFields() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getIfModifiedSince() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public InputStream getInputStream() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getLastModified() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Permission getPermission() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getReadTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, List<String>> getRequestProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getRequestProperty(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public URL getURL() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean getUseCaches() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setAllowUserInteraction(final boolean allowUserInteraction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setConnectTimeout(final int timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setDefaultUseCaches(final boolean defaultUseCaches) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setDoInput(final boolean doInput) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setDoOutput(final boolean doOutput) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setIfModifiedSince(final long ifModifiedSince) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setReadTimeout(final int timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setRequestProperty(final String key, final String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setUseCaches(final boolean useCaches) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
