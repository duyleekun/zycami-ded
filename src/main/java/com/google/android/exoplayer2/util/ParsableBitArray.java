/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;

public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        this.data = byArray;
    }

    public ParsableBitArray(byte[] byArray) {
        int n10 = byArray.length;
        this(byArray, n10);
    }

    public ParsableBitArray(byte[] byArray, int n10) {
        this.data = byArray;
        this.byteLimit = n10;
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

    public void byteAlign() {
        int n10 = this.bitOffset;
        if (n10 == 0) {
            return;
        }
        this.bitOffset = 0;
        this.byteOffset = n10 = this.byteOffset + 1;
        this.assertValidOffset();
    }

    public int getBytePosition() {
        int n10 = this.bitOffset;
        n10 = n10 == 0 ? 1 : 0;
        Assertions.checkState(n10 != 0);
        return this.byteOffset;
    }

    public int getPosition() {
        int n10 = this.byteOffset * 8;
        int n11 = this.bitOffset;
        return n10 + n11;
    }

    public void putInt(int n10, int n11) {
        byte[] byArray;
        int n12 = 1;
        int n13 = 32;
        if (n11 < n13) {
            n13 = (n12 << n11) - n12;
            n10 &= n13;
        }
        n13 = this.bitOffset;
        int n14 = 8;
        n13 = Math.min(8 - n13, n11);
        int n15 = this.bitOffset;
        int n16 = 8 - n15 - n13;
        n15 = 65280 >> n15;
        int n17 = (n12 << n16) - n12;
        n15 |= n17;
        byte[] byArray2 = this.data;
        int n18 = this.byteOffset;
        byte by2 = byArray2[n18];
        byArray2[n18] = n15 = (int)((byte)(n15 & by2));
        n15 = n10 >>> n13;
        by2 = byArray2[n18];
        byArray2[n18] = n15 = (int)((byte)(n15 << n16 | by2));
        n18 += n12;
        for (n13 = n11 - n13; n13 > n14; n13 += -8) {
            byArray = this.data;
            n16 = n18 + 1;
            n17 = n13 + -8;
            byArray[n18] = n17 = (int)((byte)(n10 >>> n17));
            n18 = n16;
        }
        n14 = 8 - n13;
        byArray = this.data;
        n16 = byArray[n18];
        n17 = (n12 << n14) - n12;
        byArray[n18] = n16 = (int)((byte)(n16 & n17));
        n13 = (n12 << n13) - n12;
        n10 &= n13;
        n12 = byArray[n18];
        byArray[n18] = n10 = (int)((byte)(n10 << n14 | n12));
        this.skipBits(n11);
        this.assertValidOffset();
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
        if (n10 == 0) {
            return 0;
        }
        this.bitOffset = n15 = this.bitOffset + n10;
        n15 = 0;
        while ((n14 = this.bitOffset) > (n13 = 8)) {
            this.bitOffset = n14 += -8;
            byte[] byArray = this.data;
            n12 = this.byteOffset;
            this.byteOffset = n11 = n12 + 1;
            n13 = byArray[n12] & 0xFF;
            n14 = n13 << n14;
            n15 |= n14;
        }
        byte[] byArray = this.data;
        n11 = this.byteOffset;
        n12 = byArray[n11] & 0xFF;
        int n16 = 8 - n14;
        n12 = -1;
        n10 = 32 - n10;
        n10 = n12 >>> n10 & (n15 |= (n12 >>= n16));
        if (n14 == n13) {
            this.bitOffset = 0;
            this.byteOffset = ++n11;
        }
        this.assertValidOffset();
        return n10;
    }

    public void readBits(byte[] byArray, int n10, int n11) {
        int n12;
        int n13;
        int n14;
        int n15;
        byte[] byArray2;
        int n16;
        int n17;
        int n18 = (n11 >> 3) + n10;
        while (true) {
            n17 = 255;
            n16 = 8;
            if (n10 >= n18) break;
            byArray2 = this.data;
            n15 = this.byteOffset;
            this.byteOffset = n14 = n15 + 1;
            n15 = byArray2[n15];
            n13 = this.bitOffset;
            byArray[n10] = n15 = (int)((byte)(n15 << n13));
            n15 = byArray[n10];
            n12 = byArray2[n14];
            n17 &= n12;
            byArray[n10] = n17 = (int)((byte)(n17 >> (n16 -= n13) | n15));
            ++n10;
        }
        n10 = n11 & 7;
        if (n10 == 0) {
            return;
        }
        n11 = byArray[n18];
        n12 = n17 >> n10;
        byArray[n18] = n11 = (int)((byte)(n11 & n12));
        n11 = this.bitOffset;
        n12 = n11 + n10;
        if (n12 > n16) {
            n12 = byArray[n18];
            byte[] byArray3 = this.data;
            n14 = this.byteOffset;
            this.byteOffset = n13 = n14 + 1;
            n15 = (byArray3[n14] & n17) << n11;
            byArray[n18] = n12 = (int)((byte)(n12 | n15));
            this.bitOffset = n11 -= n16;
        }
        this.bitOffset = n11 = this.bitOffset + n10;
        byArray2 = this.data;
        n15 = this.byteOffset;
        n12 = byArray2[n15];
        n17 &= n12;
        n12 = 8 - n11;
        n17 >>= n12;
        n12 = byArray[n18];
        n10 = 8 - n10;
        byArray[n18] = n10 = (int)((byte)((byte)(n17 << n10) | n12));
        if (n11 == n16) {
            byArray = null;
            this.bitOffset = 0;
            this.byteOffset = ++n15;
        }
        this.assertValidOffset();
    }

    public long readBitsToLong(int n10) {
        int n11 = 32;
        if (n10 <= n11) {
            return Util.toUnsignedLong(this.readBits(n10));
        }
        n10 -= n11;
        n10 = this.readBits(n10);
        n11 = this.readBits(n11);
        return Util.toLong(n10, n11);
    }

    public void readBytes(byte[] byArray, int n10, int n11) {
        int n12;
        byte[] byArray2;
        int n13 = this.bitOffset;
        if (!n13) {
            n13 = 1;
        } else {
            n13 = 0;
            byArray2 = null;
        }
        Assertions.checkState(n13 != 0);
        byArray2 = this.data;
        int n14 = this.byteOffset;
        System.arraycopy(byArray2, n14, byArray, n10, n11);
        this.byteOffset = n12 = this.byteOffset + n11;
        this.assertValidOffset();
    }

    public String readBytesAsString(int n10) {
        Charset charset = Charsets.UTF_8;
        return this.readBytesAsString(n10, charset);
    }

    public String readBytesAsString(int n10, Charset charset) {
        byte[] byArray = new byte[n10];
        this.readBytes(byArray, 0, n10);
        String string2 = new String(byArray, charset);
        return string2;
    }

    public void reset(ParsableByteArray parsableByteArray) {
        byte[] byArray = parsableByteArray.getData();
        int n10 = parsableByteArray.limit();
        this.reset(byArray, n10);
        int n11 = parsableByteArray.getPosition() * 8;
        this.setPosition(n11);
    }

    public void reset(byte[] byArray) {
        int n10 = byArray.length;
        this.reset(byArray, n10);
    }

    public void reset(byte[] byArray, int n10) {
        this.data = byArray;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = n10;
    }

    public void setPosition(int n10) {
        int n11;
        this.byteOffset = n11 = n10 / 8;
        this.bitOffset = n10 -= (n11 *= 8);
        this.assertValidOffset();
    }

    public void skipBit() {
        int n10;
        this.bitOffset = n10 = this.bitOffset + 1;
        int n11 = 8;
        if (n10 == n11) {
            this.bitOffset = 0;
            this.byteOffset = n10 = this.byteOffset + 1;
        }
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

    public void skipBytes(int n10) {
        int n11 = this.bitOffset;
        n11 = n11 == 0 ? 1 : 0;
        Assertions.checkState(n11 != 0);
        this.byteOffset = n11 = this.byteOffset + n10;
        this.assertValidOffset();
    }
}

