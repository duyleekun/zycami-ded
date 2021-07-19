/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.LittleEndianByteArray;

public final class FarmHashFingerprint64
extends AbstractNonStreamingHashFunction {
    public static final HashFunction FARMHASH_FINGERPRINT_64;
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    static {
        FarmHashFingerprint64 farmHashFingerprint64 = new FarmHashFingerprint64();
        FARMHASH_FINGERPRINT_64 = farmHashFingerprint64;
    }

    public static long fingerprint(byte[] byArray, int n10, int n11) {
        int n12 = 32;
        if (n11 <= n12) {
            n12 = 16;
            if (n11 <= n12) {
                return FarmHashFingerprint64.hashLength0to16(byArray, n10, n11);
            }
            return FarmHashFingerprint64.hashLength17to32(byArray, n10, n11);
        }
        n12 = 64;
        if (n11 <= n12) {
            return FarmHashFingerprint64.hashLength33To64(byArray, n10, n11);
        }
        return FarmHashFingerprint64.hashLength65Plus(byArray, n10, n11);
    }

    private static long hashLength0to16(byte[] byArray, int n10, int n11) {
        int n12 = 8;
        long l10 = -7286425919675154353L;
        if (n11 >= n12) {
            long l11 = (long)(n11 * 2) + l10;
            long l12 = LittleEndianByteArray.load64(byArray, n10) + l10;
            n10 = n10 + n11 - n12;
            long l13 = LittleEndianByteArray.load64(byArray, n10);
            long l14 = Long.rotateRight(l13, 37) * l11 + l12;
            long l15 = (Long.rotateRight(l12, 25) + l13) * l11;
            return FarmHashFingerprint64.hashLength16(l14, l15, l11);
        }
        int n13 = 4;
        if (n11 >= n13) {
            long l16 = (long)(n11 * 2) + l10;
            long l17 = LittleEndianByteArray.load32(byArray, n10);
            long l18 = 0xFFFFFFFFL;
            l17 &= l18;
            long l19 = n11;
            n10 = n10 + n11 - n13;
            long l20 = (long)LittleEndianByteArray.load32(byArray, n10) & l18;
            return FarmHashFingerprint64.hashLength16(l19 += (l17 <<= 3), l20, l16);
        }
        if (n11 > 0) {
            n13 = byArray[n10];
            int n14 = (n11 >> 1) + n10;
            n14 = byArray[n14];
            int n15 = n11 + -1;
            int n16 = byArray[n10 += n15];
            n10 = n13 & 0xFF;
            n12 = (n14 & 0xFF) << 8;
            n16 = (n16 & 0xFF) << 2;
            long l21 = (long)(n10 += n12) * l10;
            long l22 = (long)(n11 += n16) * -4348849565147123417L;
            return FarmHashFingerprint64.shiftMix(l21 ^ l22) * l10;
        }
        return l10;
    }

    private static long hashLength16(long l10, long l11, long l12) {
        l10 = (l10 ^ l11) * l12;
        int n10 = 47;
        long l13 = l10 >>> n10;
        l10 = (l10 ^ l13 ^ l11) * l12;
        l11 = l10 >>> n10;
        return (l10 ^ l11) * l12;
    }

    private static long hashLength17to32(byte[] byArray, int n10, int n11) {
        long l10 = n11 * 2;
        long l11 = -7286425919675154353L;
        long l12 = l10 + l11;
        l10 = LittleEndianByteArray.load64(byArray, n10) * -5435081209227447693L;
        int n12 = n10 + 8;
        long l13 = LittleEndianByteArray.load64(byArray, n12);
        int n13 = n10 + n11;
        int n14 = n13 + -8;
        long l14 = LittleEndianByteArray.load64(byArray, n14) * l12;
        long l15 = LittleEndianByteArray.load64(byArray, n13 += -16) * l11;
        long l16 = Long.rotateRight(l10 + l13, 43);
        long l17 = Long.rotateRight(l14, 30);
        l11 = Long.rotateRight(l13 + l11, 18);
        long l18 = l10 + l11 + l14;
        l13 = l15 += (l16 += l17);
        l15 = l18;
        return FarmHashFingerprint64.hashLength16(l13, l18, l12);
    }

    private static long hashLength33To64(byte[] byArray, int n10, int n11) {
        long l10 = n11 * 2;
        long l11 = -7286425919675154353L;
        long l12 = LittleEndianByteArray.load64(byArray, n10) * l11;
        int n12 = n10 + 8;
        long l13 = LittleEndianByteArray.load64(byArray, n12);
        int n13 = n10 + n11;
        int n14 = n13 + -8;
        long l14 = LittleEndianByteArray.load64(byArray, n14) * (l10 += l11);
        int n15 = n13 + -16;
        long l15 = LittleEndianByteArray.load64(byArray, n15) * l11;
        long l16 = l12 + l13;
        int n16 = 43;
        l16 = Long.rotateRight(l16, n16);
        long l17 = Long.rotateRight(l14, 30);
        l16 = l16 + l17 + l15;
        l13 = Long.rotateRight(l13 + -7286425919675154353L, 18) + l12;
        l14 += l13;
        l13 = l16;
        l15 = l10;
        l13 = FarmHashFingerprint64.hashLength16(l16, l14, l10);
        n14 = n10 + 16;
        l14 = LittleEndianByteArray.load64(byArray, n14) * l10;
        n15 = n10 + 24;
        l15 = LittleEndianByteArray.load64(byArray, n15);
        int n17 = n13 + -32;
        long l18 = LittleEndianByteArray.load64(byArray, n17);
        l16 = (l16 + l18) * l10;
        l18 = LittleEndianByteArray.load64(byArray, n13 += -24);
        l13 = (l13 + l18) * l10;
        l18 = l10;
        long l19 = Long.rotateRight(l14 + l15, n16);
        long l20 = Long.rotateRight(l16, 30);
        l19 = Long.rotateRight(l15 + l12, 18);
        l14 = l14 + l19 + l16;
        l15 = l10;
        return FarmHashFingerprint64.hashLength16(l13 += (l19 += l20), l14, l10);
    }

    private static long hashLength65Plus(byte[] byArray, int n10, int n11) {
        byte[] byArray2 = byArray;
        long l10 = FarmHashFingerprint64.shiftMix(-7956866745689871395L) * -7286425919675154353L;
        int n12 = 2;
        long[] lArray = new long[n12];
        long[] lArray2 = new long[n12];
        long l11 = LittleEndianByteArray.load64(byArray, n10);
        long l12 = 95310865018149119L + l11;
        int n13 = 1;
        n12 = n11 + -1;
        int n14 = n12 / 64 * 64;
        int n15 = n10 + n14;
        int n16 = n12 & 0x3F;
        n12 = n15 + n16;
        int n17 = n12 + -63;
        l11 = 2480279821605975764L;
        int n18 = n10;
        while (true) {
            l12 += l11;
            long l13 = lArray[0];
            l12 += l13;
            int n19 = n18 + 8;
            l13 = LittleEndianByteArray.load64(byArray2, n19);
            l12 = Long.rotateRight(l12 + l13, 37);
            l13 = -5435081209227447693L;
            long l14 = lArray[n13];
            l11 += l14;
            n19 = n18 + 48;
            l14 = LittleEndianByteArray.load64(byArray2, n19);
            l11 = Long.rotateRight(l11 + l14, 42) * l13;
            l14 = lArray2[n13];
            l14 = (l12 *= l13) ^ l14;
            l12 = lArray[0];
            n19 = n18 + 40;
            long l15 = LittleEndianByteArray.load64(byArray2, n19);
            l12 += l15;
            l15 = l11 + l12;
            l11 = lArray2[0];
            n19 = 33;
            long l16 = Long.rotateRight(l10 += l11, n19) * l13;
            l11 = lArray[n13] * l13;
            l10 = lArray2[0];
            l12 = l14 + l10;
            int n20 = n18;
            FarmHashFingerprint64.weakHashLength32WithSeeds(byArray, n18, l11, l12, lArray);
            n20 = n18 + 32;
            l11 = lArray2[n13];
            l11 = l16 + l11;
            int n21 = n18 + 16;
            l12 = LittleEndianByteArray.load64(byArray2, n21);
            l12 = l15 + l12;
            FarmHashFingerprint64.weakHashLength32WithSeeds(byArray, n20, l11, l12, lArray2);
            if ((n18 += 64) == n15) {
                l13 = ((l14 & 0xFFL) << n13) + l13;
                l10 = lArray2[0];
                l11 = n16;
                lArray2[0] = l10 += l11;
                l10 = lArray[0];
                l11 = lArray2[0];
                lArray[0] = l10 += l11;
                l10 = lArray2[0];
                l11 = lArray[0];
                lArray2[0] = l10 += l11;
                l16 += l15;
                l10 = lArray[0];
                l16 += l10;
                n21 = n17 + 8;
                l10 = LittleEndianByteArray.load64(byArray2, n21);
                l10 = Long.rotateRight(l16 + l10, 37) * l13;
                l11 = lArray[n13];
                l15 += l11;
                n12 = n17 + 48;
                l11 = LittleEndianByteArray.load64(byArray2, n12);
                l11 = Long.rotateRight(l15 + l11, 42) * l13;
                l12 = lArray2[n13];
                long l17 = 9;
                l15 = l10 ^ (l12 *= l17);
                l10 = lArray[0] * l17;
                int n22 = n17 + 40;
                l12 = LittleEndianByteArray.load64(byArray2, n22);
                l17 = l11 + (l10 += l12);
                l10 = lArray2[0];
                l14 = Long.rotateRight(l14 + l10, 33) * l13;
                l11 = lArray[n13] * l13;
                l10 = lArray2[0];
                l12 = l15 + l10;
                n20 = n17;
                FarmHashFingerprint64.weakHashLength32WithSeeds(byArray, n17, l11, l12, lArray);
                n20 = n17 + 32;
                l11 = lArray2[n13];
                l11 = l14 + l11;
                l12 = LittleEndianByteArray.load64(byArray2, n17 += 16) + l17;
                FarmHashFingerprint64.weakHashLength32WithSeeds(byArray, n20, l11, l12, lArray2);
                l11 = lArray[0];
                l12 = lArray2[0];
                l10 = FarmHashFingerprint64.hashLength16(l11, l12, l13);
                l11 = FarmHashFingerprint64.shiftMix(l17) * -4348849565147123417L;
                l10 = l10 + l11 + l15;
                l11 = lArray[n13];
                l12 = lArray2[n13];
                l12 = FarmHashFingerprint64.hashLength16(l11, l12, l13) + l14;
                l11 = l10;
                return FarmHashFingerprint64.hashLength16(l10, l12, l13);
            }
            l10 = l14;
            l11 = l15;
            l12 = l16;
        }
    }

    private static long shiftMix(long l10) {
        long l11 = l10 >>> 47;
        return l10 ^ l11;
    }

    private static void weakHashLength32WithSeeds(byte[] byArray, int n10, long l10, long l11, long[] lArray) {
        long l12 = LittleEndianByteArray.load64(byArray, n10);
        int n11 = n10 + 8;
        long l13 = LittleEndianByteArray.load64(byArray, n11);
        int n12 = n10 + 16;
        long l14 = LittleEndianByteArray.load64(byArray, n12);
        long l15 = LittleEndianByteArray.load64(byArray, n10 += 24);
        l11 = Long.rotateRight(l11 + (l10 += l12) + l15, 21);
        l13 = l13 + l10 + l14;
        l12 = Long.rotateRight(l13, 44);
        l11 += l12;
        lArray[0] = l13 += l15;
        lArray[1] = l11 += l10;
    }

    public int bits() {
        return 64;
    }

    public HashCode hashBytes(byte[] byArray, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        return HashCode.fromLong(FarmHashFingerprint64.fingerprint(byArray, n10, n11));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}

