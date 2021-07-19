/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints$IntArrayAsList;
import com.google.common.primitives.Ints$IntConverter;
import com.google.common.primitives.Ints$LexicographicalComparator;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 0x40000000;

    private Ints() {
    }

    public static /* synthetic */ int access$000(int[] nArray, int n10, int n11, int n12) {
        return Ints.indexOf(nArray, n10, n11, n12);
    }

    public static /* synthetic */ int access$100(int[] nArray, int n10, int n11, int n12) {
        return Ints.lastIndexOf(nArray, n10, n11, n12);
    }

    public static List asList(int ... nArray) {
        int n10 = nArray.length;
        if (n10 == 0) {
            return Collections.emptyList();
        }
        Ints$IntArrayAsList ints$IntArrayAsList = new Ints$IntArrayAsList(nArray);
        return ints$IntArrayAsList;
    }

    public static int checkedCast(long l10) {
        int n10 = (int)l10;
        long l11 = n10;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "Out of range: %s", l10);
        return n10;
    }

    public static int compare(int n10, int n11) {
        n10 = n10 < n11 ? -1 : (n10 > n11 ? 1 : 0);
        return n10;
    }

    public static int[] concat(int[] ... nArray) {
        int n10;
        int[] nArray2;
        int n11;
        int n12 = nArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            nArray2 = nArray[n11];
            n10 = nArray2.length;
            n13 += n10;
        }
        int[] nArray3 = new int[n13];
        n11 = nArray.length;
        n10 = 0;
        nArray2 = null;
        for (n13 = 0; n13 < n11; ++n13) {
            int[] nArray4 = nArray[n13];
            int n14 = nArray4.length;
            System.arraycopy(nArray4, 0, nArray3, n10, n14);
            int n15 = nArray4.length;
            n10 += n15;
        }
        return nArray3;
    }

    public static int constrainToRange(int n10, int n11, int n12) {
        boolean bl2 = n11 <= n12;
        Preconditions.checkArgument(bl2, "min (%s) must be less than or equal to max (%s)", n11, n12);
        return Math.min(Math.max(n10, n11), n12);
    }

    public static boolean contains(int[] nArray, int n10) {
        for (int n11 : nArray) {
            if (n11 != n10) continue;
            return true;
        }
        return false;
    }

    public static int[] ensureCapacity(int[] nArray, int n10, int n11) {
        int n12 = 1;
        String string2 = null;
        int n13 = n10 >= 0 ? n12 : 0;
        String string3 = "Invalid minLength: %s";
        Preconditions.checkArgument(n13 != 0, string3, n10);
        if (n11 < 0) {
            n12 = 0;
        }
        string2 = "Invalid padding: %s";
        Preconditions.checkArgument(n12 != 0, string2, n11);
        n12 = nArray.length;
        if (n12 < n10) {
            nArray = Arrays.copyOf(nArray, n10 += n11);
        }
        return nArray;
    }

    public static int fromByteArray(byte[] byArray) {
        byte by2 = byArray.length;
        byte by3 = 1;
        byte by4 = 0;
        byte by5 = 4;
        by2 = by2 >= by5 ? by3 : (byte)0;
        int n10 = byArray.length;
        Preconditions.checkArgument(by2 != 0, "array too small: %s < %s", n10, (int)by5);
        by2 = byArray[0];
        by3 = byArray[by3];
        by4 = byArray[2];
        byte by6 = byArray[3];
        return Ints.fromBytes(by2, by3, by4, by6);
    }

    public static int fromBytes(byte by2, byte by3, byte by4, byte by5) {
        by2 = (byte)(by2 << 24);
        by3 = (byte)((by3 & 0xFF) << 16);
        by2 = (byte)(by2 | by3);
        by3 = (byte)((by4 & 0xFF) << 8);
        by2 = (byte)(by2 | by3);
        by3 = (byte)(by5 & 0xFF);
        return by2 | by3;
    }

    public static int hashCode(int n10) {
        return n10;
    }

    public static int indexOf(int[] nArray, int n10) {
        int n11 = nArray.length;
        return Ints.indexOf(nArray, n10, 0, n11);
    }

    private static int indexOf(int[] nArray, int n10, int n11, int n12) {
        while (n11 < n12) {
            int n13 = nArray[n11];
            if (n13 == n10) {
                return n11;
            }
            ++n11;
        }
        return -1;
    }

    public static int indexOf(int[] nArray, int[] nArray2) {
        block3: {
            Preconditions.checkNotNull(nArray, "array");
            String string2 = "target";
            Preconditions.checkNotNull(nArray2, string2);
            int n10 = nArray2.length;
            if (n10 == 0) {
                return 0;
            }
            n10 = 0;
            string2 = null;
            block0: while (true) {
                int n11 = nArray.length;
                int n12 = nArray2.length;
                if (n10 >= (n11 = n11 - n12 + 1)) break block3;
                for (n11 = 0; n11 < (n12 = nArray2.length); ++n11) {
                    n12 = n10 + n11;
                    int n13 = nArray2[n11];
                    if ((n12 = nArray[n12]) == n13) continue;
                    ++n10;
                    continue block0;
                }
                break;
            }
            return n10;
        }
        return -1;
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
        n12 = nArray[0];
        stringBuilder.append(n12);
        for (n12 = 1; n12 < (n10 = nArray.length); ++n12) {
            stringBuilder.append(string2);
            n10 = nArray[n12];
            stringBuilder.append(n10);
        }
        return stringBuilder.toString();
    }

    public static int lastIndexOf(int[] nArray, int n10) {
        int n11 = nArray.length;
        return Ints.lastIndexOf(nArray, n10, 0, n11);
    }

    private static int lastIndexOf(int[] nArray, int n10, int n11, int n12) {
        n12 += -1;
        while (n12 >= n11) {
            int n13 = nArray[n12];
            if (n13 == n10) {
                return n12;
            }
            n12 += -1;
        }
        return -1;
    }

    public static Comparator lexicographicalComparator() {
        return Ints$LexicographicalComparator.INSTANCE;
    }

    public static int max(int ... nArray) {
        int n10;
        int n11 = nArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = nArray[0];
        for (n10 = 1; n10 < (n12 = nArray.length); ++n10) {
            n12 = nArray[n10];
            if (n12 <= n11) continue;
            n11 = nArray[n10];
        }
        return n11;
    }

    public static int min(int ... nArray) {
        int n10;
        int n11 = nArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = nArray[0];
        for (n10 = 1; n10 < (n12 = nArray.length); ++n10) {
            n12 = nArray[n10];
            if (n12 >= n11) continue;
            n11 = nArray[n10];
        }
        return n11;
    }

    public static void reverse(int[] nArray) {
        Preconditions.checkNotNull(nArray);
        int n10 = nArray.length;
        Ints.reverse(nArray, 0, n10);
    }

    public static void reverse(int[] nArray, int n10, int n11) {
        Preconditions.checkNotNull(nArray);
        int n12 = nArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n11 += -1;
        while (n10 < n11) {
            int n13;
            n12 = nArray[n10];
            nArray[n10] = n13 = nArray[n11];
            nArray[n11] = n12;
            ++n10;
            n11 += -1;
        }
    }

    public static int saturatedCast(long l10) {
        long l11 = Integer.MAX_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return -1 >>> 1;
        }
        l11 = 0x80000000L;
        long l13 = l10 - l11;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            return -1 << -1;
        }
        return (int)l10;
    }

    public static void sortDescending(int[] nArray) {
        Preconditions.checkNotNull(nArray);
        int n10 = nArray.length;
        Ints.sortDescending(nArray, 0, n10);
    }

    public static void sortDescending(int[] nArray, int n10, int n11) {
        Preconditions.checkNotNull(nArray);
        int n12 = nArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        Arrays.sort(nArray, n10, n11);
        Ints.reverse(nArray, n10, n11);
    }

    public static Converter stringConverter() {
        return Ints$IntConverter.INSTANCE;
    }

    public static int[] toArray(Collection objectArray) {
        int n10 = objectArray instanceof Ints$IntArrayAsList;
        if (n10 != 0) {
            return ((Ints$IntArrayAsList)objectArray).toIntArray();
        }
        objectArray = objectArray.toArray();
        n10 = objectArray.length;
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Number number = (Number)Preconditions.checkNotNull(objectArray[i10]);
            nArray[i10] = n11 = number.intValue();
        }
        return nArray;
    }

    public static byte[] toByteArray(int n10) {
        byte by2 = (byte)(n10 >> 24);
        by2 = (byte)(n10 >> 16);
        by2 = (byte)(n10 >> 8);
        byte[] byArray = new byte[]{by2, by2, by2, n10 = (int)((byte)n10)};
        return byArray;
    }

    public static Integer tryParse(String string2) {
        return Ints.tryParse(string2, 10);
    }

    public static Integer tryParse(String object, int n10) {
        long l10;
        long l11;
        long l12;
        if ((object = Longs.tryParse((String)object, n10)) != null && (n10 = (int)((l12 = (l11 = ((Long)object).longValue()) - (l10 = (long)((Long)object).intValue())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
            return ((Long)object).intValue();
        }
        return null;
    }
}

