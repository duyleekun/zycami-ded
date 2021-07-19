/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.HashCode;
import java.io.Serializable;

public final class HashCode$LongHashCode
extends HashCode
implements Serializable {
    private static final long serialVersionUID;
    public final long hash;

    public HashCode$LongHashCode(long l10) {
        this.hash = l10;
    }

    public byte[] asBytes() {
        byte by2;
        int n10 = 8;
        byte[] byArray = new byte[n10];
        long l10 = this.hash;
        byArray[0] = by2 = (byte)l10;
        byArray[1] = n10 = (int)((byte)(l10 >> n10));
        byArray[2] = n10 = (int)((byte)(l10 >> 16));
        byArray[3] = n10 = (int)((byte)(l10 >> 24));
        byArray[4] = n10 = (int)((byte)(l10 >> 32));
        byArray[5] = n10 = (int)((byte)(l10 >> 40));
        byArray[6] = n10 = (int)((byte)(l10 >> 48));
        byArray[7] = n10 = (int)((byte)(l10 >> 56));
        return byArray;
    }

    public int asInt() {
        return (int)this.hash;
    }

    public long asLong() {
        return this.hash;
    }

    public int bits() {
        return 64;
    }

    public boolean equalsSameBits(HashCode hashCode) {
        long l10 = this.hash;
        long l11 = hashCode.asLong();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            hashCode = null;
        }
        return (boolean)object;
    }

    public long padToLong() {
        return this.hash;
    }

    public void writeBytesToImpl(byte[] byArray, int n10, int n11) {
        for (int i10 = 0; i10 < n11; ++i10) {
            byte by2;
            int n12 = n10 + i10;
            long l10 = this.hash;
            int n13 = i10 * 8;
            byArray[n12] = by2 = (byte)(l10 >>= n13);
        }
    }
}

