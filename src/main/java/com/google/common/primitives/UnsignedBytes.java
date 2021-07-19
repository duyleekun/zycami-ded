/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator;
import java.util.Arrays;
import java.util.Comparator;

public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = -128;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    private UnsignedBytes() {
    }

    public static byte checkedCast(long l10) {
        long l11 = l10 >> 8;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "out of range: %s", l10);
        return (byte)l10;
    }

    public static int compare(byte by2, byte by3) {
        by2 = (byte)UnsignedBytes.toInt(by2);
        by3 = (byte)UnsignedBytes.toInt(by3);
        return by2 - by3;
    }

    private static byte flip(byte by2) {
        return (byte)(by2 ^ 0x80);
    }

    public static String join(String string2, byte ... byArray) {
        Preconditions.checkNotNull(string2);
        int n10 = byArray.length;
        if (n10 == 0) {
            return "";
        }
        int n11 = byArray.length;
        byte by2 = string2.length() + 3;
        StringBuilder stringBuilder = new StringBuilder(n11 *= by2);
        n11 = UnsignedBytes.toInt(byArray[0]);
        stringBuilder.append(n11);
        for (n11 = 1; n11 < (by2 = byArray.length); ++n11) {
            stringBuilder.append(string2);
            by2 = byArray[n11];
            String string3 = UnsignedBytes.toString(by2);
            stringBuilder.append(string3);
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return UnsignedBytes$LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    public static Comparator lexicographicalComparatorJavaImpl() {
        return UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator.INSTANCE;
    }

    public static byte max(byte ... byArray) {
        int n10;
        int n11 = byArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = UnsignedBytes.toInt(byArray[0]);
        for (n10 = 1; n10 < (n12 = byArray.length); ++n10) {
            n12 = UnsignedBytes.toInt(byArray[n10]);
            if (n12 <= n11) continue;
            n11 = n12;
        }
        return (byte)n11;
    }

    public static byte min(byte ... byArray) {
        int n10;
        int n11 = byArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = UnsignedBytes.toInt(byArray[0]);
        for (n10 = 1; n10 < (n12 = byArray.length); ++n10) {
            n12 = UnsignedBytes.toInt(byArray[n10]);
            if (n12 >= n11) continue;
            n11 = n12;
        }
        return (byte)n11;
    }

    public static byte parseUnsignedByte(String string2) {
        return UnsignedBytes.parseUnsignedByte(string2, 10);
    }

    public static byte parseUnsignedByte(String string2, int n10) {
        int n11 = Integer.parseInt(string2 = (String)Preconditions.checkNotNull(string2), n10);
        n10 = n11 >> 8;
        if (n10 == 0) {
            return (byte)n11;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("out of range: ");
        stringBuilder.append(n11);
        string2 = stringBuilder.toString();
        NumberFormatException numberFormatException = new NumberFormatException(string2);
        throw numberFormatException;
    }

    public static byte saturatedCast(long l10) {
        byte by2 = -1;
        long l11 = UnsignedBytes.toInt(by2);
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return by2;
        }
        long l13 = 0L;
        long l14 = l10 - l13;
        by2 = (byte)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (by2 < 0) {
            return 0;
        }
        return (byte)l10;
    }

    public static void sort(byte[] byArray) {
        Preconditions.checkNotNull(byArray);
        int n10 = byArray.length;
        UnsignedBytes.sort(byArray, 0, n10);
    }

    public static void sort(byte[] byArray, int n10, int n11) {
        Preconditions.checkNotNull(byArray);
        int n12 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        for (n12 = n10; n12 < n11; ++n12) {
            byte by2;
            byArray[n12] = by2 = UnsignedBytes.flip(byArray[n12]);
        }
        Arrays.sort(byArray, n10, n11);
        while (n10 < n11) {
            byArray[n10] = n12 = (int)UnsignedBytes.flip(byArray[n10]);
            ++n10;
        }
    }

    public static void sortDescending(byte[] byArray) {
        Preconditions.checkNotNull(byArray);
        int n10 = byArray.length;
        UnsignedBytes.sortDescending(byArray, 0, n10);
    }

    public static void sortDescending(byte[] byArray, int n10, int n11) {
        Preconditions.checkNotNull(byArray);
        int n12 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        for (n12 = n10; n12 < n11; ++n12) {
            byte by2;
            byArray[n12] = by2 = (byte)(byArray[n12] ^ 0x7F);
        }
        Arrays.sort(byArray, n10, n11);
        while (n10 < n11) {
            byArray[n10] = n12 = (int)((byte)(byArray[n10] ^ 0x7F));
            ++n10;
        }
    }

    public static int toInt(byte by2) {
        return by2 & 0xFF;
    }

    public static String toString(byte by2) {
        return UnsignedBytes.toString(by2, 10);
    }

    public static String toString(byte by2, int n10) {
        int n11 = 2;
        n11 = n10 >= n11 && n10 <= (n11 = 36) ? 1 : 0;
        Preconditions.checkArgument(n11 != 0, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", n10);
        return Integer.toString(UnsignedBytes.toInt(by2), n10);
    }
}

