/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream
extends ByteArrayOutputStream {
    public AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(int n10) {
        super(n10);
    }

    public byte[] byteArray() {
        return this.buf;
    }

    public int length() {
        return this.count;
    }

    public void write(ByteBuffer byteBuffer) {
        int n10;
        byte[] byArray;
        byte[] byArray2;
        int n11;
        int n12 = this.count;
        int n13 = byteBuffer.remaining();
        int n14 = n12 + n13;
        if (n14 > (n11 = (byArray2 = this.buf).length)) {
            this.buf = byArray = Arrays.copyOf(byArray2, n12 += n13);
        }
        byArray = this.buf;
        n14 = this.count;
        byteBuffer.get(byArray, n14, n13);
        this.count = n10 = this.count + n13;
    }
}

