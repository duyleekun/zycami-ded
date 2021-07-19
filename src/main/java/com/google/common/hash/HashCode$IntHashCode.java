/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;

public final class HashCode$IntHashCode
extends HashCode
implements Serializable {
    private static final long serialVersionUID;
    public final int hash;

    public HashCode$IntHashCode(int n10) {
        this.hash = n10;
    }

    public byte[] asBytes() {
        byte by2;
        byte[] byArray = new byte[4];
        int n10 = this.hash;
        byArray[0] = by2 = (byte)n10;
        byArray[1] = by2 = (byte)(n10 >> 8);
        byArray[2] = by2 = (byte)(n10 >> 16);
        byArray[3] = n10 = (int)((byte)(n10 >> 24));
        return byArray;
    }

    public int asInt() {
        return this.hash;
    }

    public long asLong() {
        IllegalStateException illegalStateException = new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        throw illegalStateException;
    }

    public int bits() {
        return 32;
    }

    public boolean equalsSameBits(HashCode hashCode) {
        int n10 = this.hash;
        int n11 = hashCode.asInt();
        if (n10 == n11) {
            n11 = 1;
        } else {
            n11 = 0;
            hashCode = null;
        }
        return n11 != 0;
    }

    public long padToLong() {
        return UnsignedInts.toLong(this.hash);
    }

    public void writeBytesToImpl(byte[] byArray, int n10, int n11) {
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = n10 + i10;
            int n13 = this.hash;
            int n14 = i10 * 8;
            byArray[n12] = n13 = (int)((byte)(n13 >> n14));
        }
    }
}

