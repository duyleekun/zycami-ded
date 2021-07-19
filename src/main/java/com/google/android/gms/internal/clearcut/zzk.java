/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzk {
    private static int zza(byte[] byArray, int n10) {
        int n11 = byArray[n10] & 0xFF;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 16;
        return (byArray[n10 += 3] & 0xFF) << 24 | (n11 |= n12);
    }

    private static long zza(long l10, long l11, long l12) {
        l10 = (l10 ^ l11) * l12;
        int n10 = 47;
        long l13 = l10 >>> n10;
        l10 = (l10 ^ l13 ^ l11) * l12;
        l11 = l10 >>> n10;
        return (l10 ^ l11) * l12;
    }

    public static long zza(byte[] byArray) {
        int n10;
        byte[] byArray2 = byArray;
        int n11 = byArray.length;
        if (n11 >= 0 && n11 <= (n10 = byArray.length)) {
            int n12 = 37;
            n10 = 18;
            int n13 = 30;
            int n14 = 43;
            int n15 = 2;
            int n16 = 32;
            long l10 = -5435081209227447693L;
            int n17 = 16;
            int n18 = 8;
            long l11 = -7286425919675154353L;
            if (n11 <= n16) {
                if (n11 <= n17) {
                    if (n11 >= n18) {
                        long l12 = (long)(n11 << 1) + l11;
                        long l13 = zzk.zzb(byArray, 0) + l11;
                        n11 = n11 + 0 - n18;
                        long l14 = zzk.zzb(byArray, n11);
                        long l15 = Long.rotateRight(l14, n12) * l12 + l13;
                        long l16 = (Long.rotateRight(l13, 25) + l14) * l12;
                        return zzk.zza(l15, l16, l12);
                    }
                    n10 = 4;
                    if (n11 >= n10) {
                        long l17 = (long)(n11 << 1) + l11;
                        long l18 = (long)zzk.zza(byArray, 0) & 0xFFFFFFFFL;
                        long l19 = n11;
                        n11 = n11 + 0 - n10;
                        long l20 = (long)zzk.zza(byArray, n11) & 0xFFFFFFFFL;
                        return zzk.zza(l19 += (l18 <<= 3), l20, l17);
                    }
                    if (n11 > 0) {
                        n10 = byArray[0];
                        n13 = (n11 >> 1) + 0;
                        n13 = byArray[n13];
                        n14 = n11 + -1 + 0;
                        n14 = byArray[n14];
                        n10 &= 0xFF;
                        n13 = (n13 & 0xFF) << n18;
                        n10 += n13;
                        n13 = (n14 & 0xFF) << n15;
                        long l21 = (long)n10 * l11;
                        long l22 = (long)(n11 += n13) * -4348849565147123417L;
                        long l23 = l21 ^ l22;
                        long l24 = l23 >>> 47;
                        return (l23 ^ l24) * l11;
                    }
                    return l11;
                }
                long l25 = (long)(n11 << 1) + l11;
                long l26 = zzk.zzb(byArray, 0) * l10;
                long l27 = zzk.zzb(byArray, n18);
                n18 = (n11 += 0) + -8;
                long l28 = zzk.zzb(byArray, n18) * l25;
                long l29 = zzk.zzb(byArray, n11 -= n17) * l11;
                long l30 = Long.rotateRight(l26 + l27, n14);
                long l31 = Long.rotateRight(l28, n13);
                l31 = l30 + l31 + l29;
                long l32 = Long.rotateRight(l27 + l11, n10);
                long l33 = l26 + l32 + l28;
                long l34 = l31;
                return zzk.zza(l31, l33, l25);
            }
            int n19 = 64;
            if (n11 <= n19) {
                long l35 = (long)(n11 << 1) + l11;
                long l36 = zzk.zzb(byArray, 0) * l11;
                long l37 = zzk.zzb(byArray, n18);
                n18 = (n11 += 0) + -8;
                long l38 = zzk.zzb(byArray, n18) * l35;
                int n20 = n11 + -16;
                long l39 = zzk.zzb(byArray, n20) * l11;
                long l40 = Long.rotateRight(l36 + l37, n14);
                long l41 = Long.rotateRight(l38, 30);
                l41 = l40 + l41 + l39;
                l39 = Long.rotateRight(l11 + l37, 18) + l36 + l38;
                l37 = l41;
                l40 = l35;
                l38 = zzk.zza(l41, l39, l35);
                long l42 = zzk.zzb(byArray, n17) * l35;
                int n21 = 24;
                long l43 = zzk.zzb(byArray, n21);
                n19 = n11 + -32;
                l37 = zzk.zzb(byArray, n19);
                l41 += l37;
                l37 = l36;
                l36 = l41 * l35;
                l39 = zzk.zzb(byArray, n11 -= n21);
                l38 = (l38 + l39) * l35;
                long l44 = Long.rotateRight(l42 + l43, n14);
                l39 = Long.rotateRight(l36, 30);
                long l45 = l44 + l39 + l38;
                long l46 = Long.rotateRight(l43 + l37, 18);
                l39 = l42 + l46 + l36;
                l37 = l45;
                return zzk.zza(l45, l39, l35);
            }
            long l47 = 2480279821605975764L;
            long l48 = 1390051526045402406L;
            long[] lArray = new long[n15];
            long[] lArray2 = new long[n15];
            long l49 = 95310865018149119L;
            long l50 = zzk.zzb(byArray, 0) + l49;
            int n22 = 1;
            n15 = ((n11 += -1) / 64 << 6) + 0;
            n14 = n11 & 0x3F;
            n11 = n15 + n14;
            int n23 = n11 + -63;
            int n24 = 0;
            while (true) {
                l50 += l47;
                long l51 = lArray[0];
                l50 += l51;
                n11 = n24 + 8;
                l51 = zzk.zzb(byArray2, n11);
                long l52 = Long.rotateRight(l50 + l51, n12) * l10;
                l50 = lArray[n22];
                l47 += l50;
                n11 = n24 + 48;
                l50 = zzk.zzb(byArray2, n11);
                l47 = Long.rotateRight(l47 + l50, 42) * l10;
                l50 = lArray2[n22];
                l51 = lArray[0];
                n11 = n24 + 40;
                long l53 = zzk.zzb(byArray2, n11);
                l51 += l53;
                l51 = l47 + l51;
                long l54 = lArray2[0];
                n13 = 33;
                long l55 = Long.rotateRight(l48 += l54, n13) * l10;
                l48 = lArray[n22] * l10;
                l54 = lArray2[0];
                long l56 = (l52 ^= l50) + l54;
                byte[] byArray3 = byArray;
                n17 = 42;
                n10 = n24;
                n17 = n14;
                long l57 = l48;
                n18 = n15;
                long l58 = l56;
                n12 = n15;
                zzk.zza(byArray, n24, l48, l56, lArray);
                n10 = n24 + 32;
                l57 = lArray2[n22];
                l57 = l55 + l57;
                n11 = n24 + 16;
                l58 = zzk.zzb(byArray2, n11);
                l58 = l51 + l58;
                zzk.zza(byArray, n10, l57, l58, lArray2);
                n10 = 64;
                n11 = n24 + 64;
                if (n11 == n15) {
                    long l59 = ((0xFFL & l52) << n22) + l10;
                    l47 = lArray2[0];
                    l49 = n14;
                    lArray2[0] = l47 += l49;
                    l47 = lArray[0];
                    l49 = lArray2[0];
                    lArray[0] = l47 += l49;
                    l47 = lArray2[0];
                    l49 = lArray[0];
                    lArray2[0] = l47 += l49;
                    l55 += l51;
                    l47 = lArray[0];
                    n11 = n23 + 8;
                    l54 = zzk.zzb(byArray2, n11);
                    l54 = Long.rotateRight((l55 += l47) + l54, 37) * l59;
                    l57 = lArray[n22];
                    l51 += l57;
                    n13 = n23 + 48;
                    l57 = zzk.zzb(byArray2, n13);
                    l57 = Long.rotateRight(l51 + l57, 42) * l59;
                    l58 = lArray2[n22];
                    long l60 = 9;
                    long l61 = l54 ^ (l58 *= l60);
                    l58 = lArray[0] * l60;
                    n10 = n23 + 40;
                    l60 = zzk.zzb(byArray2, n10);
                    l58 += l60;
                    l60 = l57 + l58;
                    l47 = lArray2[0];
                    l52 = Long.rotateRight(l52 + l47, 33) * l59;
                    l57 = lArray[n22] * l59;
                    l58 = lArray2[0];
                    l58 = l61 + l58;
                    n10 = n23;
                    zzk.zza(byArray, n23, l57, l58, lArray);
                    n10 = n23 + 32;
                    l57 = lArray2[n22] + l52;
                    n11 = n23 + 16;
                    l58 = zzk.zzb(byArray2, n11) + l60;
                    zzk.zza(byArray, n10, l57, l58, lArray2);
                    l54 = lArray[0];
                    l58 = lArray2[0];
                    l57 = l54;
                    long l62 = l59;
                    l54 = zzk.zza(l54, l58, l59);
                    l57 = (l60 >>> 47 ^ l60) * -4348849565147123417L;
                    l54 = l54 + l57 + l61;
                    l57 = lArray[n22];
                    l58 = lArray2[n22];
                    l58 = zzk.zza(l57, l58, l59) + l52;
                    l57 = l54;
                    return zzk.zza(l54, l58, l59);
                }
                n24 = n11;
                l48 = l52;
                l50 = l55;
                n12 = 37;
                n17 = 16;
                n19 = n10;
                l47 = l51;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(67);
        stringBuilder.append("Out of bound index with offput: 0 and length: ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private static void zza(byte[] byArray, int n10, long l10, long l11, long[] lArray) {
        long l12 = zzk.zzb(byArray, n10);
        int n11 = n10 + 8;
        long l13 = zzk.zzb(byArray, n11);
        int n12 = n10 + 16;
        long l14 = zzk.zzb(byArray, n12);
        long l15 = zzk.zzb(byArray, n10 += 24);
        l11 = Long.rotateRight(l11 + (l10 += l12) + l15, 21);
        l13 = l13 + l10 + l14;
        l12 = Long.rotateRight(l13, 44);
        l11 += l12;
        lArray[0] = l13 += l15;
        lArray[1] = l11 += l10;
    }

    private static long zzb(byte[] object, int n10) {
        object = ByteBuffer.wrap((byte[])object, n10, 8);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ((ByteBuffer)object).order(byteOrder);
        return ((ByteBuffer)object).getLong();
    }
}

