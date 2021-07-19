/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class HashingOutputStream
extends FilterOutputStream {
    private final Hasher hasher;

    public HashingOutputStream(HashFunction object, OutputStream outputStream) {
        outputStream = (OutputStream)Preconditions.checkNotNull(outputStream);
        super(outputStream);
        this.hasher = object = (Hasher)Preconditions.checkNotNull(object.newHasher());
    }

    public void close() {
        this.out.close();
    }

    public HashCode hash() {
        return this.hasher.hash();
    }

    public void write(int n10) {
        Hasher hasher = this.hasher;
        byte by2 = (byte)n10;
        hasher.putByte(by2);
        this.out.write(n10);
    }

    public void write(byte[] byArray, int n10, int n11) {
        this.hasher.putBytes(byArray, n10, n11);
        this.out.write(byArray, n10, n11);
    }
}

