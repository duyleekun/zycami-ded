/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.SignedBytes$LexicographicalComparator;
import java.util.Arrays;
import java.util.Comparator;

public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    private SignedBytes() {
    }

    public static byte checkedCast(long l10) {
        byte by2 = (byte)l10;
        long l11 = by2;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "Out of range: %s", l10);
        return by2;
    }

    public static int compare(byte by2, byte by3) {
        return by2 - by3;
    }

    public static String join(String string2, byte ... byArray) {
        int n10;
        Preconditions.checkNotNull(string2);
        int n11 = byArray.length;
        if (n11 == 0) {
            return "";
        }
        int n12 = byArray.length * 5;
        StringBuilder stringBuilder = new StringBuilder(n12);
        n12 = byArray[0];
        stringBuilder.append(n12);
        for (n12 = 1; n12 < (n10 = byArray.length); ++n12) {
            stringBuilder.append(string2);
            n10 = byArray[n12];
            stringBuilder.append(n10);
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return SignedBytes$LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte ... byArray) {
        int n10;
        int n11 = byArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = byArray[0];
        for (n10 = 1; n10 < (n12 = byArray.length); ++n10) {
            n12 = byArray[n10];
            if (n12 <= n11) continue;
            n11 = byArray[n10];
        }
        return (byte)n11;
    }

    public static byte min(byte ... byArray) {
        int n10;
        int n11 = byArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = byArray[0];
        for (n10 = 1; n10 < (n12 = byArray.length); ++n10) {
            n12 = byArray[n10];
            if (n12 >= n11) continue;
            n11 = byArray[n10];
        }
        return (byte)n11;
    }

    public static byte saturatedCast(long l10) {
        long l11 = 127;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return 127;
        }
        l11 = -128;
        long l13 = l10 - l11;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            return -128;
        }
        return (byte)l10;
    }

    public static void sortDescending(byte[] byArray) {
        Preconditions.checkNotNull(byArray);
        int n10 = byArray.length;
        SignedBytes.sortDescending(byArray, 0, n10);
    }

    public static void sortDescending(byte[] byArray, int n10, int n11) {
        Preconditions.checkNotNull(byArray);
        int n12 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        Arrays.sort(byArray, n10, n11);
        Bytes.reverse(byArray, n10, n11);
    }
}

