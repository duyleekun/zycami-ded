/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractHasher;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;

public final class AbstractNonStreamingHashFunction$BufferingHasher
extends AbstractHasher {
    public final AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream stream;
    public final /* synthetic */ AbstractNonStreamingHashFunction this$0;

    public AbstractNonStreamingHashFunction$BufferingHasher(AbstractNonStreamingHashFunction object, int n10) {
        this.this$0 = object;
        this.stream = object = new AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(n10);
    }

    public HashCode hash() {
        AbstractNonStreamingHashFunction abstractNonStreamingHashFunction = this.this$0;
        byte[] byArray = this.stream.byteArray();
        int n10 = this.stream.length();
        return abstractNonStreamingHashFunction.hashBytes(byArray, 0, n10);
    }

    public Hasher putByte(byte by2) {
        this.stream.write(by2);
        return this;
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        this.stream.write(byteBuffer);
        return this;
    }

    public Hasher putBytes(byte[] byArray, int n10, int n11) {
        this.stream.write(byArray, n10, n11);
        return this;
    }
}

