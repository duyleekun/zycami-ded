/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHasher;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class AbstractByteHasher
extends AbstractHasher {
    private final ByteBuffer scratch;

    public AbstractByteHasher() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.scratch = byteBuffer = byteBuffer.order(byteOrder);
    }

    private Hasher update(int n10) {
        try {
            Object object = this.scratch;
            object = ((ByteBuffer)object).array();
            this.update((byte[])object, 0, n10);
            return this;
        }
        finally {
            this.scratch.clear();
        }
    }

    public Hasher putByte(byte by2) {
        this.update(by2);
        return this;
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        this.update(byteBuffer);
        return this;
    }

    public Hasher putBytes(byte[] byArray) {
        Preconditions.checkNotNull(byArray);
        this.update(byArray);
        return this;
    }

    public Hasher putBytes(byte[] byArray, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        this.update(byArray, n10, n11);
        return this;
    }

    public Hasher putChar(char c10) {
        this.scratch.putChar(c10);
        return this.update(2);
    }

    public Hasher putInt(int n10) {
        this.scratch.putInt(n10);
        return this.update(4);
    }

    public Hasher putLong(long l10) {
        this.scratch.putLong(l10);
        return this.update(8);
    }

    public Hasher putShort(short s10) {
        this.scratch.putShort(s10);
        return this.update(2);
    }

    public abstract void update(byte var1);

    public void update(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.hasArray();
        if (n10 != 0) {
            byte[] byArray = byteBuffer.array();
            int n11 = byteBuffer.arrayOffset();
            int n12 = byteBuffer.position();
            n11 += n12;
            n12 = byteBuffer.remaining();
            this.update(byArray, n11, n12);
            n10 = byteBuffer.limit();
            byteBuffer.position(n10);
        } else {
            for (n10 = byteBuffer.remaining(); n10 > 0; n10 += -1) {
                byte by2 = byteBuffer.get();
                this.update(by2);
            }
        }
    }

    public void update(byte[] byArray) {
        int n10 = byArray.length;
        this.update(byArray, 0, n10);
    }

    public void update(byte[] byArray, int n10, int n11) {
        byte by2;
        for (int i10 = n10; i10 < (by2 = n10 + n11); ++i10) {
            by2 = byArray[i10];
            this.update(by2);
        }
    }
}

