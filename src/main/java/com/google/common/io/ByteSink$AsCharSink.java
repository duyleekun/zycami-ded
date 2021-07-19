/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSink$1;
import com.google.common.io.CharSink;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public final class ByteSink$AsCharSink
extends CharSink {
    private final Charset charset;
    public final /* synthetic */ ByteSink this$0;

    private ByteSink$AsCharSink(ByteSink object, Charset charset) {
        this.this$0 = object;
        this.charset = object = (Charset)Preconditions.checkNotNull(charset);
    }

    public /* synthetic */ ByteSink$AsCharSink(ByteSink byteSink, Charset charset, ByteSink$1 byteSink$1) {
        this(byteSink, charset);
    }

    public Writer openStream() {
        OutputStream outputStream = this.this$0.openStream();
        Charset charset = this.charset;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.this$0.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(".asCharSink(");
        object = this.charset;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

