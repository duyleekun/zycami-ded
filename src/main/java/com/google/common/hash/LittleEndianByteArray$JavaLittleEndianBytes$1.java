/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes;
import com.google.common.primitives.Longs;

public final class LittleEndianByteArray$JavaLittleEndianBytes$1
extends LittleEndianByteArray$JavaLittleEndianBytes {
    public long getLongLittleEndian(byte[] byArray, int n10) {
        int n11 = n10 + 7;
        byte by2 = byArray[n11];
        n11 = n10 + 6;
        byte by3 = byArray[n11];
        n11 = n10 + 5;
        byte by4 = byArray[n11];
        n11 = n10 + 4;
        byte by5 = byArray[n11];
        n11 = n10 + 3;
        byte by6 = byArray[n11];
        n11 = n10 + 2;
        byte by7 = byArray[n11];
        n11 = n10 + 1;
        byte by8 = byArray[n11];
        byte by9 = byArray[n10];
        return Longs.fromBytes(by2, by3, by4, by5, by6, by7, by8, by9);
    }

    public void putLongLittleEndian(byte[] byArray, int n10, long l10) {
        int n11;
        long l11 = 255L;
        for (int i10 = 0; i10 < (n11 = 8); ++i10) {
            byte by2;
            int n12 = n10 + i10;
            long l12 = l10 & l11;
            int n13 = i10 * 8;
            byArray[n12] = by2 = (byte)(l12 >>= n13);
            l11 <<= n11;
        }
    }
}

