/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public final class VorbisBitArray {
    private int bitOffset;
    private final int byteLimit;
    private int byteOffset;
    private final byte[] data;

    public VorbisBitArray(byte[] byArray) {
        int n10;
        this.data = byArray;
        this.byteLimit = n10 = byArray.length;
    }

    private void assertValidOffset() {
        int n10;
        int n11 = this.byteOffset;
        n11 = n11 >= 0 && (n11 < (n10 = this.byteLimit) || n11 == n10 && (n11 = this.bitOffset) == 0) ? 1 : 0;
        Assertions.checkState(n11 != 0);
    }

    public int bitsLeft() {
        int n10 = this.byteLimit;
        int n11 = this.byteOffset;
        n10 = (n10 - n11) * 8;
        n11 = this.bitOffset;
        return n10 - n11;
    }

    public int getPosition() {
        int n10 = this.byteOffset * 8;
        int n11 = this.bitOffset;
        return n10 + n11;
    }

    /*
     * WARNING - void declaration
     */
    public boolean readBit() {
        void var3_8;
        byte[] byArray = this.data;
        int bl2 = this.byteOffset;
        int bl3 = byArray[bl2] & 0xFF;
        bl2 = this.bitOffset;
        int n11 = bl3 >> bl2;
        n11 = n11 & (bl2 = 1);
        if (n11 == bl2) {
            int n12 = bl2;
        } else {
            boolean bl4 = false;
            byArray = null;
        }
        this.skipBits(bl2);
        return (boolean)var3_8;
    }

    public int readBits(int n10) {
        int n11 = this.byteOffset;
        int n12 = this.bitOffset;
        n12 = 8 - n12;
        byte[] byArray = this.data;
        int n13 = n11 + 1;
        n11 = byArray[n11];
        int n14 = 255;
        n11 &= n14;
        int n15 = this.bitOffset;
        n11 >>= n15;
        n15 = 8 - n12;
        n15 = n14 >> n15;
        n11 &= n15;
        for (n12 = Math.min(n10, n12); n12 < n10; n12 += 8) {
            byte[] byArray2 = this.data;
            int n16 = n13 + 1;
            n13 = (byArray2[n13] & n14) << n12;
            n11 |= n13;
            n13 = n16;
        }
        n14 = 32 - n10;
        n12 = -1 >>> n14;
        this.skipBits(n10);
        return n11 &= n12;
    }

    public void reset() {
        this.byteOffset = 0;
        this.bitOffset = 0;
    }

    public void setPosition(int n10) {
        int n11;
        this.byteOffset = n11 = n10 / 8;
        this.bitOffset = n10 -= (n11 *= 8);
        this.assertValidOffset();
    }

    public void skipBits(int n10) {
        int n11 = n10 / 8;
        int n12 = this.byteOffset + n11;
        this.byteOffset = n12++;
        int n13 = this.bitOffset;
        this.bitOffset = n13 += (n10 -= (n11 *= 8));
        n10 = 7;
        if (n13 > n10) {
            this.byteOffset = n12;
            this.bitOffset = n13 += -8;
        }
        this.assertValidOffset();
    }
}

