/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.ReaderInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;

public final class CharSource$AsByteSource
extends ByteSource {
    public final Charset charset;
    public final /* synthetic */ CharSource this$0;

    public CharSource$AsByteSource(CharSource object, Charset charset) {
        this.this$0 = object;
        this.charset = object = (Charset)Preconditions.checkNotNull(charset);
    }

    public CharSource asCharSource(Charset charset) {
        Charset charset2 = this.charset;
        boolean bl2 = charset.equals(charset2);
        if (bl2) {
            return this.this$0;
        }
        return super.asCharSource(charset);
    }

    public InputStream openStream() {
        Reader reader = this.this$0.openStream();
        Charset charset = this.charset;
        ReaderInputStream readerInputStream = new ReaderInputStream(reader, charset, 8192);
        return readerInputStream;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.this$0.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(".asByteSource(");
        object = this.charset;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

