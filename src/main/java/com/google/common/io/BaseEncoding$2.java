/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import java.io.InputStream;
import java.io.Reader;

public class BaseEncoding$2
extends ByteSource {
    public final /* synthetic */ BaseEncoding this$0;
    public final /* synthetic */ CharSource val$encodedSource;

    public BaseEncoding$2(BaseEncoding baseEncoding, CharSource charSource) {
        this.this$0 = baseEncoding;
        this.val$encodedSource = charSource;
    }

    public InputStream openStream() {
        BaseEncoding baseEncoding = this.this$0;
        Reader reader = this.val$encodedSource.openStream();
        return baseEncoding.decodingStream(reader);
    }
}

