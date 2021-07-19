/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class ByteSource$AsCharSource
extends CharSource {
    public final Charset charset;
    public final /* synthetic */ ByteSource this$0;

    public ByteSource$AsCharSource(ByteSource object, Charset charset) {
        this.this$0 = object;
        this.charset = object = (Charset)Preconditions.checkNotNull(charset);
    }

    public ByteSource asByteSource(Charset charset) {
        Charset charset2 = this.charset;
        boolean bl2 = charset.equals(charset2);
        if (bl2) {
            return this.this$0;
        }
        return super.asByteSource(charset);
    }

    public Reader openStream() {
        InputStream inputStream = this.this$0.openStream();
        Charset charset = this.charset;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader;
    }

    public String read() {
        byte[] byArray = this.this$0.read();
        Charset charset = this.charset;
        String string2 = new String(byArray, charset);
        return string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.this$0.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(".asCharSource(");
        object = this.charset;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

