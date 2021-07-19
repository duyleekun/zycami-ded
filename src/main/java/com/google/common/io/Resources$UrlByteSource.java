/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.Resources$1;
import java.io.InputStream;
import java.net.URL;

public final class Resources$UrlByteSource
extends ByteSource {
    private final URL url;

    private Resources$UrlByteSource(URL uRL) {
        this.url = uRL = (URL)Preconditions.checkNotNull(uRL);
    }

    public /* synthetic */ Resources$UrlByteSource(URL uRL, Resources$1 resources$1) {
        this(uRL);
    }

    public InputStream openStream() {
        return this.url.openStream();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resources.asByteSource(");
        URL uRL = this.url;
        stringBuilder.append(uRL);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

