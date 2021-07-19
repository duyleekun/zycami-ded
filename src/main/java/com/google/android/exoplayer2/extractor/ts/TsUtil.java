/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;

public final class TsUtil {
    private TsUtil() {
    }

    public static int findSyncBytePosition(byte[] byArray, int n10, int n11) {
        byte by2;
        byte by3;
        while (n10 < n11 && (by3 = byArray[n10]) != (by2 = 71)) {
            ++n10;
        }
        return n10;
    }

    public static long readPcrFromPacket(ParsableByteArray parsableByteArray, int n10, int n11) {
        int n12;
        parsableByteArray.setPosition(n10);
        n10 = parsableByteArray.bytesLeft();
        long l10 = -9223372036854775807L;
        int n13 = 5;
        if (n10 < n13) {
            return l10;
        }
        n10 = parsableByteArray.readInt();
        n13 = 0x800000 & n10;
        if (n13 != 0) {
            return l10;
        }
        n13 = (0x1FFF00 & n10) >> 8;
        if (n13 != n11) {
            return l10;
        }
        n11 = 1;
        n13 = 0;
        n10 = (n10 &= 0x20) != 0 ? n11 : 0;
        if (n10 == 0) {
            return l10;
        }
        n10 = parsableByteArray.readUnsignedByte();
        if (n10 >= (n12 = 7) && (n10 = parsableByteArray.bytesLeft()) >= n12) {
            byte[] byArray;
            n10 = parsableByteArray.readUnsignedByte();
            n12 = 16;
            if ((n10 &= n12) != n12) {
                n11 = 0;
                byArray = null;
            }
            if (n11 != 0) {
                n10 = 6;
                byArray = new byte[n10];
                parsableByteArray.readBytes(byArray, 0, n10);
                return TsUtil.readPcrValueFromPcrBytes(byArray);
            }
        }
        return l10;
    }

    private static long readPcrValueFromPcrBytes(byte[] byArray) {
        long l10 = byArray[0];
        long l11 = 255L;
        l10 = (l10 & l11) << 25;
        int n10 = 1;
        long l12 = ((long)byArray[n10] & l11) << 17;
        l10 |= l12;
        l12 = ((long)byArray[2] & l11) << 9;
        l10 |= l12;
        long l13 = ((long)byArray[3] & l11) << n10;
        l10 |= l13;
        l13 = byArray[4];
        l11 = (l11 & l13) >> 7;
        return l10 | l11;
    }
}

