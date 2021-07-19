/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class HashingInputStream
extends FilterInputStream {
    private final Hasher hasher;

    public HashingInputStream(HashFunction object, InputStream inputStream) {
        inputStream = (InputStream)Preconditions.checkNotNull(inputStream);
        super(inputStream);
        this.hasher = object = (Hasher)Preconditions.checkNotNull(object.newHasher());
    }

    public HashCode hash() {
        return this.hasher.hash();
    }

    public void mark(int n10) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int n10;
        InputStream inputStream = this.in;
        int n11 = inputStream.read();
        if (n11 != (n10 = -1)) {
            Hasher hasher = this.hasher;
            byte by2 = (byte)n11;
            hasher.putByte(by2);
        }
        return n11;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        Object object = this.in;
        if ((n11 = ((InputStream)object).read(byArray, n10, n11)) != (n12 = -1)) {
            object = this.hasher;
            object.putBytes(byArray, n10, n11);
        }
        return n11;
    }

    public void reset() {
        IOException iOException = new IOException("reset not supported");
        throw iOException;
    }
}

