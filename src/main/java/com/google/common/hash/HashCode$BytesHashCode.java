/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import java.io.Serializable;

public final class HashCode$BytesHashCode
extends HashCode
implements Serializable {
    private static final long serialVersionUID;
    public final byte[] bytes;

    public HashCode$BytesHashCode(byte[] byArray) {
        byArray = (byte[])Preconditions.checkNotNull(byArray);
        this.bytes = byArray;
    }

    public byte[] asBytes() {
        return (byte[])this.bytes.clone();
    }

    public int asInt() {
        byte[] byArray = this.bytes;
        int n10 = byArray.length;
        int n11 = 1;
        int n12 = 4;
        n10 = n10 >= n12 ? n11 : 0;
        int n13 = byArray.length;
        Preconditions.checkState(n10 != 0, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", n13);
        byArray = this.bytes;
        n10 = byArray[0] & 0xFF;
        n11 = (byArray[n11] & 0xFF) << 8;
        n10 |= n11;
        n11 = (byArray[2] & 0xFF) << 16;
        return (byArray[3] & 0xFF) << 24 | (n10 |= n11);
    }

    public long asLong() {
        byte[] byArray = this.bytes;
        boolean bl2 = byArray.length;
        boolean bl3 = 8 != 0;
        bl2 = bl2 >= bl3;
        int n10 = byArray.length;
        Preconditions.checkState(bl2, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", n10);
        return this.padToLong();
    }

    public int bits() {
        return this.bytes.length * 8;
    }

    public boolean equalsSameBits(HashCode hashCode) {
        byte[] byArray;
        int n10;
        byte[] byArray2 = this.bytes;
        int n11 = byArray2.length;
        byte[] byArray3 = hashCode.getBytesInternal();
        int n12 = byArray3.length;
        if (n11 != n12) {
            return false;
        }
        int n13 = n11 = 1;
        byArray3 = null;
        for (n12 = 0; n12 < (n10 = (byArray = this.bytes).length); ++n12) {
            int n14 = byArray[n12];
            byte[] byArray4 = hashCode.getBytesInternal();
            n10 = byArray4[n12];
            if (n14 == n10) {
                n14 = n11;
            } else {
                n14 = 0;
                byArray = null;
            }
            n13 &= n14;
        }
        return n13 != 0;
    }

    public byte[] getBytesInternal() {
        return this.bytes;
    }

    public long padToLong() {
        byte[] byArray = this.bytes;
        int n10 = byArray[0] & 0xFF;
        long l10 = n10;
        int n11 = 1;
        while (true) {
            byte[] byArray2 = this.bytes;
            int n12 = byArray2.length;
            int n13 = 8;
            if (n11 >= (n12 = Math.min(n12, n13))) break;
            byArray2 = this.bytes;
            n12 = byArray2[n11];
            long l11 = n12;
            long l12 = 255L;
            l11 &= l12;
            int n14 = n11 * 8;
            l10 |= (l11 <<= n14);
            ++n11;
        }
        return l10;
    }

    public void writeBytesToImpl(byte[] byArray, int n10, int n11) {
        System.arraycopy(this.bytes, 0, byArray, n10, n11);
    }
}

