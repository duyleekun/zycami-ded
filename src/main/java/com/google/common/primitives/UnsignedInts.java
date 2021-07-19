/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.ParseRequest;
import com.google.common.primitives.UnsignedInts$LexicographicalComparator;
import java.util.Arrays;
import java.util.Comparator;

public final class UnsignedInts {
    public static final long INT_MASK = 0xFFFFFFFFL;

    private UnsignedInts() {
    }

    public static int checkedCast(long l10) {
        long l11 = l10 >> 32;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "out of range: %s", l10);
        return (int)l10;
    }

    public static int compare(int n10, int n11) {
        n10 = UnsignedInts.flip(n10);
        n11 = UnsignedInts.flip(n11);
        return Ints.compare(n10, n11);
    }

    public static int decode(String string2) {
        Object object;
        ParseRequest parseRequest = ParseRequest.fromString(string2);
        try {
            object = parseRequest.rawValue;
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error parsing value: ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object = new NumberFormatException(string2);
            ((Throwable)object).initCause(numberFormatException);
            throw object;
        }
        int n10 = parseRequest.radix;
        return UnsignedInts.parseUnsignedInt((String)object, n10);
    }

    public static int divide(int n10, int n11) {
        long l10 = UnsignedInts.toLong(n10);
        long l11 = UnsignedInts.toLong(n11);
        return (int)(l10 / l11);
    }

    public static int flip(int n10) {
        return n10 ^ -1 << -1;
    }

    public static String join(String string2, int ... nArray) {
        int n10;
        Preconditions.checkNotNull(string2);
        int n11 = nArray.length;
        if (n11 == 0) {
            return "";
        }
        int n12 = nArray.length * 5;
        StringBuilder stringBuilder = new StringBuilder(n12);
        String string3 = UnsignedInts.toString(nArray[0]);
        stringBuilder.append(string3);
        for (n12 = 1; n12 < (n10 = nArray.length); ++n12) {
            stringBuilder.append(string2);
            n10 = nArray[n12];
            String string4 = UnsignedInts.toString(n10);
            stringBuilder.append(string4);
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return UnsignedInts$LexicographicalComparator.INSTANCE;
    }

    public static int max(int ... nArray) {
        int n10;
        int n11 = nArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = UnsignedInts.flip(nArray[0]);
        for (n10 = 1; n10 < (n12 = nArray.length); ++n10) {
            n12 = UnsignedInts.flip(nArray[n10]);
            if (n12 <= n11) continue;
            n11 = n12;
        }
        return UnsignedInts.flip(n11);
    }

    public static int min(int ... nArray) {
        int n10;
        int n11 = nArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = UnsignedInts.flip(nArray[0]);
        for (n10 = 1; n10 < (n12 = nArray.length); ++n10) {
            n12 = UnsignedInts.flip(nArray[n10]);
            if (n12 >= n11) continue;
            n11 = n12;
        }
        return UnsignedInts.flip(n11);
    }

    public static int parseUnsignedInt(String string2) {
        return UnsignedInts.parseUnsignedInt(string2, 10);
    }

    public static int parseUnsignedInt(String string2, int n10) {
        Preconditions.checkNotNull(string2);
        long l10 = Long.parseLong(string2, n10);
        long l11 = 0xFFFFFFFFL & l10;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (l12 == false) {
            return (int)l10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Input ");
        stringBuilder.append(string2);
        stringBuilder.append(" in base ");
        stringBuilder.append(n10);
        stringBuilder.append(" is not in the range of an unsigned integer");
        string2 = stringBuilder.toString();
        NumberFormatException numberFormatException = new NumberFormatException(string2);
        throw numberFormatException;
    }

    public static int remainder(int n10, int n11) {
        long l10 = UnsignedInts.toLong(n10);
        long l11 = UnsignedInts.toLong(n11);
        return (int)(l10 % l11);
    }

    public static int saturatedCast(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return 0;
        }
        l11 = 0x100000000L;
        long l13 = l10 - l11;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0) {
            return -1;
        }
        return (int)l10;
    }

    public static void sort(int[] nArray) {
        Preconditions.checkNotNull(nArray);
        int n10 = nArray.length;
        UnsignedInts.sort(nArray, 0, n10);
    }

    public static void sort(int[] nArray, int n10, int n11) {
        Preconditions.checkNotNull(nArray);
        int n12 = nArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        for (n12 = n10; n12 < n11; ++n12) {
            int n13;
            nArray[n12] = n13 = UnsignedInts.flip(nArray[n12]);
        }
        Arrays.sort(nArray, n10, n11);
        while (n10 < n11) {
            nArray[n10] = n12 = UnsignedInts.flip(nArray[n10]);
            ++n10;
        }
    }

    public static void sortDescending(int[] nArray) {
        Preconditions.checkNotNull(nArray);
        int n10 = nArray.length;
        UnsignedInts.sortDescending(nArray, 0, n10);
    }

    public static void sortDescending(int[] nArray, int n10, int n11) {
        int n12;
        Preconditions.checkNotNull(nArray);
        int n13 = nArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n13);
        n13 = n10;
        while (true) {
            n12 = -1 >>> 1;
            if (n13 >= n11) break;
            int n14 = nArray[n13];
            nArray[n13] = n12 ^= n14;
            ++n13;
        }
        Arrays.sort(nArray, n10, n11);
        while (n10 < n11) {
            nArray[n10] = n13 = nArray[n10] ^ n12;
            ++n10;
        }
    }

    public static long toLong(int n10) {
        return (long)n10 & 0xFFFFFFFFL;
    }

    public static String toString(int n10) {
        return UnsignedInts.toString(n10, 10);
    }

    public static String toString(int n10, int n11) {
        return Long.toString((long)n10 & 0xFFFFFFFFL, n11);
    }
}

