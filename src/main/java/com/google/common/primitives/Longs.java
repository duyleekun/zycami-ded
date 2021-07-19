/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs$AsciiDigits;
import com.google.common.primitives.Longs$LexicographicalComparator;
import com.google.common.primitives.Longs$LongArrayAsList;
import com.google.common.primitives.Longs$LongConverter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 0x4000000000000000L;

    private Longs() {
    }

    public static /* synthetic */ int access$000(long[] lArray, long l10, int n10, int n11) {
        return Longs.indexOf(lArray, l10, n10, n11);
    }

    public static /* synthetic */ int access$100(long[] lArray, long l10, int n10, int n11) {
        return Longs.lastIndexOf(lArray, l10, n10, n11);
    }

    public static List asList(long ... lArray) {
        int n10 = lArray.length;
        if (n10 == 0) {
            return Collections.emptyList();
        }
        Longs$LongArrayAsList longs$LongArrayAsList = new Longs$LongArrayAsList(lArray);
        return longs$LongArrayAsList;
    }

    public static int compare(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object < 0 ? (Object)-1 : (object > 0 ? (Object)1 : (Object)0);
        return (int)object;
    }

    public static long[] concat(long[] ... lArray) {
        int n10;
        long[] lArray2;
        int n11;
        int n12 = lArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            lArray2 = lArray[n11];
            n10 = lArray2.length;
            n13 += n10;
        }
        long[] lArray3 = new long[n13];
        n11 = lArray.length;
        n10 = 0;
        lArray2 = null;
        for (n13 = 0; n13 < n11; ++n13) {
            long[] lArray4 = lArray[n13];
            int n14 = lArray4.length;
            System.arraycopy(lArray4, 0, lArray3, n10, n14);
            int n15 = lArray4.length;
            n10 += n15;
        }
        return lArray3;
    }

    public static long constrainToRange(long l10, long l11, long l12) {
        Object object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "min (%s) must be less than or equal to max (%s)", l11, l12);
        return Math.min(Math.max(l10, l11), l12);
    }

    public static boolean contains(long[] lArray, long l10) {
        for (long l11 : lArray) {
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) continue;
            return true;
        }
        return false;
    }

    public static long[] ensureCapacity(long[] lArray, int n10, int n11) {
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
        n12 = lArray.length;
        if (n12 < n10) {
            lArray = Arrays.copyOf(lArray, n10 += n11);
        }
        return lArray;
    }

    public static long fromByteArray(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 1;
        int n12 = 8;
        n10 = n10 >= n12 ? n11 : 0;
        int n13 = byArray.length;
        Preconditions.checkArgument(n10 != 0, "array too small: %s < %s", n13, n12);
        byte by2 = byArray[0];
        byte by3 = byArray[n11];
        byte by4 = byArray[2];
        byte by5 = byArray[3];
        byte by6 = byArray[4];
        byte by7 = byArray[5];
        byte by8 = byArray[6];
        byte by9 = byArray[7];
        return Longs.fromBytes(by2, by3, by4, by5, by6, by7, by8, by9);
    }

    public static long fromBytes(byte by2, byte by3, byte by4, byte by5, byte by6, byte by7, byte by8, byte by9) {
        long l10 = by2;
        long l11 = 255L;
        l10 = (l10 & l11) << 56;
        long l12 = ((long)by3 & l11) << 48 | l10;
        l10 = ((long)by4 & l11) << 40;
        l12 |= l10;
        long l13 = ((long)by5 & l11) << 32;
        l12 |= l13;
        l13 = ((long)by6 & l11) << 24;
        l12 |= l13;
        l13 = ((long)by7 & l11) << 16;
        l12 |= l13;
        l13 = ((long)by8 & l11) << 8;
        l12 |= l13;
        l13 = (long)by9 & l11;
        return l12 | l13;
    }

    public static int hashCode(long l10) {
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    public static int indexOf(long[] lArray, long l10) {
        int n10 = lArray.length;
        return Longs.indexOf(lArray, l10, 0, n10);
    }

    private static int indexOf(long[] lArray, long l10, int n10, int n11) {
        while (n10 < n11) {
            long l11 = lArray[n10];
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public static int indexOf(long[] lArray, long[] lArray2) {
        block3: {
            Preconditions.checkNotNull(lArray, "array");
            String string2 = "target";
            Preconditions.checkNotNull(lArray2, string2);
            int n10 = lArray2.length;
            if (n10 == 0) {
                return 0;
            }
            n10 = 0;
            string2 = null;
            block0: while (true) {
                int n11 = lArray.length;
                int n12 = lArray2.length;
                if (n10 >= (n11 = n11 - n12 + 1)) break block3;
                for (n11 = 0; n11 < (n12 = lArray2.length); ++n11) {
                    n12 = n10 + n11;
                    long l10 = lArray[n12];
                    long l11 = lArray2[n11];
                    long l12 = l10 - l11;
                    if ((n12 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) continue;
                    ++n10;
                    continue block0;
                }
                break;
            }
            return n10;
        }
        return -1;
    }

    public static String join(String string2, long ... lArray) {
        int n10;
        Preconditions.checkNotNull(string2);
        int n11 = lArray.length;
        if (n11 == 0) {
            return "";
        }
        int n12 = lArray.length * 10;
        StringBuilder stringBuilder = new StringBuilder(n12);
        long l10 = lArray[0];
        stringBuilder.append(l10);
        for (n12 = 1; n12 < (n10 = lArray.length); ++n12) {
            stringBuilder.append(string2);
            long l11 = lArray[n12];
            stringBuilder.append(l11);
        }
        return stringBuilder.toString();
    }

    public static int lastIndexOf(long[] lArray, long l10) {
        int n10 = lArray.length;
        return Longs.lastIndexOf(lArray, l10, 0, n10);
    }

    private static int lastIndexOf(long[] lArray, long l10, int n10, int n11) {
        n11 += -1;
        while (n11 >= n10) {
            long l11 = lArray[n11];
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                return n11;
            }
            n11 += -1;
        }
        return -1;
    }

    public static Comparator lexicographicalComparator() {
        return Longs$LexicographicalComparator.INSTANCE;
    }

    public static long max(long ... lArray) {
        int n10;
        int n11;
        int n12 = lArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        long l10 = lArray[0];
        for (n11 = 1; n11 < (n10 = lArray.length); ++n11) {
            long l11 = lArray[n11];
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 <= 0) continue;
            l10 = lArray[n11];
        }
        return l10;
    }

    public static long min(long ... lArray) {
        int n10;
        int n11;
        int n12 = lArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        long l10 = lArray[0];
        for (n11 = 1; n11 < (n10 = lArray.length); ++n11) {
            long l11 = lArray[n11];
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 >= 0) continue;
            l10 = lArray[n11];
        }
        return l10;
    }

    public static void reverse(long[] lArray) {
        Preconditions.checkNotNull(lArray);
        int n10 = lArray.length;
        Longs.reverse(lArray, 0, n10);
    }

    public static void reverse(long[] lArray, int n10, int n11) {
        Preconditions.checkNotNull(lArray);
        int n12 = lArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n11 += -1;
        while (n10 < n11) {
            long l10;
            long l11 = lArray[n10];
            lArray[n10] = l10 = lArray[n11];
            lArray[n11] = l11;
            ++n10;
            n11 += -1;
        }
    }

    public static void sortDescending(long[] lArray) {
        Preconditions.checkNotNull(lArray);
        int n10 = lArray.length;
        Longs.sortDescending(lArray, 0, n10);
    }

    public static void sortDescending(long[] lArray, int n10, int n11) {
        Preconditions.checkNotNull(lArray);
        int n12 = lArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        Arrays.sort(lArray, n10, n11);
        Longs.reverse(lArray, n10, n11);
    }

    public static Converter stringConverter() {
        return Longs$LongConverter.INSTANCE;
    }

    public static long[] toArray(Collection objectArray) {
        int n10 = objectArray instanceof Longs$LongArrayAsList;
        if (n10 != 0) {
            return ((Longs$LongArrayAsList)objectArray).toLongArray();
        }
        objectArray = objectArray.toArray();
        n10 = objectArray.length;
        long[] lArray = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            Number number = (Number)Preconditions.checkNotNull(objectArray[i10]);
            lArray[i10] = l10 = number.longValue();
        }
        return lArray;
    }

    public static byte[] toByteArray(long l10) {
        int n10 = 8;
        byte[] byArray = new byte[n10];
        for (int i10 = 7; i10 >= 0; i10 += -1) {
            byte by2;
            long l11 = 0xFFL & l10;
            byArray[i10] = by2 = (byte)l11;
            l10 >>= n10;
        }
        return byArray;
    }

    public static Long tryParse(String string2) {
        return Longs.tryParse(string2, 10);
    }

    public static Long tryParse(String string2, int n10) {
        int n11;
        Object object = string2;
        int n112 = n10;
        CharSequence charSequence = (String)Preconditions.checkNotNull(string2);
        boolean n12 = ((String)charSequence).isEmpty();
        if (n12) {
            return null;
        }
        int n13 = 2;
        if (n10 >= n13 && n10 <= (n11 = 36)) {
            int n14;
            int n15;
            boolean bl2 = false;
            charSequence = null;
            int n16 = string2.charAt(0);
            if (n16 == (n15 = 45)) {
                n14 = 1;
            }
            if (n14 == (n16 = string2.length())) {
                return null;
            }
            n16 = n14 + 1;
            n15 = Longs$AsciiDigits.digit(((String)object).charAt(n14));
            if (n15 >= 0 && n15 < n112) {
                int n17;
                n15 = -n15;
                long l10 = n15;
                long l11 = n112;
                long l12 = Long.MIN_VALUE;
                long l13 = l12 / l11;
                while (n16 < (n17 = string2.length())) {
                    long l14;
                    n17 = n16 + 1;
                    if ((n16 = Longs$AsciiDigits.digit(((String)object).charAt(n16))) >= 0 && n16 < n112 && (l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) >= 0) {
                        long l15 = n16;
                        long l16 = l15 + l12;
                        long l17 = (l10 *= l11) - l16;
                        if ((n16 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1))) < 0) {
                            return null;
                        }
                        l10 -= l15;
                        n16 = n17;
                        continue;
                    }
                    return null;
                }
                if (n14 != 0) {
                    return l10;
                }
                Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                if (object2 == false) {
                    return null;
                }
                return -l10;
            }
            return null;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("radix must be between MIN_RADIX and MAX_RADIX but was ");
        ((StringBuilder)charSequence).append(n112);
        String string3 = ((StringBuilder)charSequence).toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }
}

