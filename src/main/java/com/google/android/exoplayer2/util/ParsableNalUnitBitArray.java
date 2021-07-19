/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Assertions;

public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] byArray, int n10, int n11) {
        this.reset(byArray, n10, n11);
    }

    private void assertValidOffset() {
        int n10;
        int n11 = this.byteOffset;
        n11 = n11 >= 0 && (n11 < (n10 = this.byteLimit) || n11 == n10 && (n11 = this.bitOffset) == 0) ? 1 : 0;
        Assertions.checkState(n11 != 0);
    }

    private int readExpGolombCodeNum() {
        int n10;
        int n11 = 0;
        int n12 = 0;
        while ((n10 = this.readBit()) == 0) {
            ++n12;
        }
        n10 = 1;
        int n13 = (n10 << n12) - n10;
        if (n12 > 0) {
            n11 = this.readBits(n12);
        }
        return n13 + n11;
    }

    private boolean shouldSkipByte(int n10) {
        int n11;
        block3: {
            block2: {
                int n12;
                byte[] byArray;
                int n13;
                n11 = 1;
                int n14 = 2;
                if (n14 > n10 || n10 >= (n14 = this.byteLimit) || (n13 = (byArray = this.data)[n10]) != (n12 = 3)) break block2;
                n13 = n10 + -2;
                if ((n13 = byArray[n13]) != 0) break block2;
                n10 -= n11;
                if ((n10 = byArray[n10]) == 0) break block3;
            }
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean canReadBits(int n10) {
        int n11 = this.byteOffset;
        int n12 = n10 / 8;
        int n13 = n11 + n12;
        int n14 = this.bitOffset + n10;
        n10 = 7;
        if ((n14 -= (n12 *= 8)) > n10) {
            ++n13;
            n14 += -8;
        }
        n10 = 1;
        while ((n11 += n10) <= n13 && n13 < (n12 = this.byteLimit)) {
            n12 = (int)(this.shouldSkipByte(n11) ? 1 : 0);
            if (n12 == 0) continue;
            ++n13;
            n11 += 2;
        }
        n11 = this.byteLimit;
        if (n13 >= n11 && (n13 != n11 || n14 != 0)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean canReadExpGolombCodedNum() {
        int n10;
        int n11;
        int n12 = this.byteOffset;
        int n13 = this.bitOffset;
        int n14 = 0;
        int n15 = 0;
        while ((n11 = this.byteOffset) < (n10 = this.byteLimit) && (n11 = (int)(this.readBit() ? 1 : 0)) == 0) {
            ++n15;
        }
        n11 = this.byteOffset;
        n10 = this.byteLimit;
        int n16 = 1;
        n11 = n11 == n10 ? n16 : 0;
        this.byteOffset = n12;
        this.bitOffset = n13;
        if (n11 == 0 && (n12 = (int)(this.canReadBits(n15 = n15 * 2 + n16) ? 1 : 0)) != 0) {
            n14 = n16;
        }
        return n14 != 0;
    }

    public boolean readBit() {
        byte[] byArray = this.data;
        int n10 = this.byteOffset;
        int n11 = byArray[n10];
        n10 = this.bitOffset;
        int n12 = 128;
        if ((n11 &= (n10 = n12 >> n10)) != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            byArray = null;
        }
        this.skipBit();
        return n11 != 0;
    }

    public int readBits(int n10) {
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        this.bitOffset = n16 = this.bitOffset + n10;
        n16 = 0;
        int n17 = 0;
        while (true) {
            n15 = this.bitOffset;
            n14 = 2;
            n13 = 1;
            n12 = 8;
            if (n15 <= n12) break;
            this.bitOffset = n15 += -8;
            byte[] byArray = this.data;
            n11 = this.byteOffset;
            n12 = byArray[n11] & 0xFF;
            n15 = n12 << n15;
            n17 |= n15;
            n15 = n11 + 1;
            if ((n15 = (int)(this.shouldSkipByte(n15) ? 1 : 0)) == 0) {
                n14 = n13;
            }
            this.byteOffset = n11 += n14;
        }
        byte[] byArray = this.data;
        int n18 = this.byteOffset;
        n11 = byArray[n18] & 0xFF;
        int n19 = 8 - n15;
        n11 = -1;
        n10 = 32 - n10;
        n10 = n11 >>> n10 & (n17 |= (n11 >>= n19));
        if (n15 == n12) {
            this.bitOffset = 0;
            n16 = n18 + 1;
            if ((n16 = (int)(this.shouldSkipByte(n16) ? 1 : 0)) == 0) {
                n14 = n13;
            }
            this.byteOffset = n18 += n14;
        }
        this.assertValidOffset();
        return n10;
    }

    public int readSignedExpGolombCodedInt() {
        int n10 = this.readExpGolombCodeNum();
        int n11 = n10 % 2;
        int n12 = 1;
        n11 = n11 == 0 ? -1 : n12;
        n10 = (n10 + n12) / 2;
        return n11 * n10;
    }

    public int readUnsignedExpGolombCodedInt() {
        return this.readExpGolombCodeNum();
    }

    public void reset(byte[] byArray, int n10, int n11) {
        this.data = byArray;
        this.byteOffset = n10;
        this.byteLimit = n11;
        this.bitOffset = 0;
        this.assertValidOffset();
    }

    public void skipBit() {
        int n10 = this.bitOffset;
        int n11 = 1;
        this.bitOffset = n10 += n11;
        int n12 = 8;
        if (n10 == n12) {
            this.bitOffset = 0;
            n10 = this.byteOffset;
            n12 = n10 + 1;
            if ((n12 = (int)(this.shouldSkipByte(n12) ? 1 : 0)) != 0) {
                n11 = 2;
            }
            this.byteOffset = n10 += n11;
        }
        this.assertValidOffset();
    }

    public void skipBits(int n10) {
        int n11 = this.byteOffset;
        int n12 = n10 / 8;
        int n13 = n11 + n12;
        this.byteOffset = n13++;
        int n14 = this.bitOffset;
        this.bitOffset = n14 += (n10 -= (n12 *= 8));
        n10 = 7;
        if (n14 > n10) {
            this.byteOffset = n13;
            this.bitOffset = n14 += -8;
        }
        while (++n11 <= (n10 = this.byteOffset)) {
            n10 = (int)(this.shouldSkipByte(n11) ? 1 : 0);
            if (n10 == 0) continue;
            this.byteOffset = n10 = this.byteOffset + 1;
            n11 += 2;
        }
        this.assertValidOffset();
    }
}

