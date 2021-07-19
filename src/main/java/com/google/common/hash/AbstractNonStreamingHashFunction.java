/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHashFunction;
import com.google.common.hash.AbstractNonStreamingHashFunction$BufferingHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public abstract class AbstractNonStreamingHashFunction
extends AbstractHashFunction {
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        return this.newHasher(n10).putBytes(byteBuffer).hash();
    }

    public abstract HashCode hashBytes(byte[] var1, int var2, int var3);

    public HashCode hashInt(int n10) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byte[] byArray = byteBuffer.order(byteOrder).putInt(n10).array();
        return this.hashBytes(byArray);
    }

    public HashCode hashLong(long l10) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byte[] byArray = byteBuffer.order(byteOrder).putLong(l10).array();
        return this.hashBytes(byArray);
    }

    public HashCode hashString(CharSequence object, Charset charset) {
        object = object.toString().getBytes(charset);
        return this.hashBytes((byte[])object);
    }

    public HashCode hashUnencodedChars(CharSequence object) {
        int n10 = object.length();
        int n11 = n10 * 2;
        ByteBuffer byteBuffer = ByteBuffer.allocate(n11);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBuffer = byteBuffer.order(byteOrder);
        byteOrder = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = object.charAt(i10);
            byteBuffer.putChar(c10);
        }
        object = byteBuffer.array();
        return this.hashBytes((byte[])object);
    }

    public Hasher newHasher() {
        return this.newHasher(32);
    }

    public Hasher newHasher(int n10) {
        AbstractNonStreamingHashFunction$BufferingHasher abstractNonStreamingHashFunction$BufferingHasher;
        boolean bl2;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            abstractNonStreamingHashFunction$BufferingHasher = null;
        }
        Preconditions.checkArgument(bl2);
        abstractNonStreamingHashFunction$BufferingHasher = new AbstractNonStreamingHashFunction$BufferingHasher(this, n10);
        return abstractNonStreamingHashFunction$BufferingHasher;
    }
}

