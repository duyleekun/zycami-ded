/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;

public final class VarintReader {
    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final long[] VARINT_LENGTH_MASKS;
    private int length;
    private final byte[] scratch;
    private int state;

    static {
        long[] lArray;
        long[] lArray2 = lArray = new long[8];
        long[] lArray3 = lArray;
        lArray2[0] = 128L;
        lArray3[1] = 64;
        lArray2[2] = 32;
        lArray3[3] = 16;
        lArray2[4] = 8;
        lArray3[5] = 4;
        lArray2[6] = 2;
        lArray3[7] = 1L;
        VARINT_LENGTH_MASKS = lArray;
    }

    public VarintReader() {
        byte[] byArray = new byte[8];
        this.scratch = byArray;
    }

    public static long assembleVarint(byte[] byArray, int n10, boolean n11) {
        long l10;
        int n12;
        byte by2 = byArray[0];
        long l11 = by2;
        long l12 = 255L;
        l11 &= l12;
        if (n11 != 0) {
            long[] lArray = VARINT_LENGTH_MASKS;
            n12 = n10 + -1;
            l10 = lArray[n12] ^ (long)-1;
            l11 &= l10;
        }
        for (n11 = 1; n11 < n10; ++n11) {
            l11 <<= 8;
            n12 = byArray[n11];
            l10 = (long)n12 & l12;
            l11 |= l10;
        }
        return l11;
    }

    public static int parseUnsignedVarintLength(int n10) {
        int n11;
        block1: {
            long[] lArray;
            int n12;
            for (n11 = 0; n11 < (n12 = (lArray = VARINT_LENGTH_MASKS).length); ++n11) {
                long l10 = lArray[n11];
                long l11 = n10;
                long l12 = l10 & l11;
                long l13 = 0L;
                long l14 = l12 - l13;
                Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object == false) continue;
                ++n11;
                break block1;
            }
            n11 = -1;
        }
        return n11;
    }

    public int getLastLength() {
        return this.length;
    }

    public long readUnsignedVarint(ExtractorInput object, boolean n10, boolean bl2, int n11) {
        int n12 = this.state;
        int n13 = 1;
        if (n12 == 0) {
            byte[] byArray = this.scratch;
            if ((n10 = (int)(object.readFully(byArray, 0, n13, n10 != 0) ? 1 : 0)) == 0) {
                return -1;
            }
            byte[] byArray2 = this.scratch;
            this.length = n10 = VarintReader.parseUnsignedVarintLength(byArray2[0] & 0xFF);
            n12 = -1;
            if (n10 != n12) {
                this.state = n13;
            } else {
                object = new IllegalStateException("No valid varint length mask found");
                throw object;
            }
        }
        if ((n10 = this.length) > n11) {
            this.state = 0;
            return -2;
        }
        if (n10 != n13) {
            byte[] byArray = this.scratch;
            object.readFully(byArray, n13, n10 -= n13);
        }
        this.state = 0;
        object = this.scratch;
        n10 = this.length;
        return VarintReader.assembleVarint((byte[])object, n10, bl2);
    }

    public void reset() {
        this.state = 0;
        this.length = 0;
    }
}

