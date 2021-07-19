/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Shorts$LexicographicalComparator;
import com.google.common.primitives.Shorts$ShortArrayAsList;
import com.google.common.primitives.Shorts$ShortConverter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    private Shorts() {
    }

    public static /* synthetic */ int access$000(short[] sArray, short s10, int n10, int n11) {
        return Shorts.indexOf(sArray, s10, n10, n11);
    }

    public static /* synthetic */ int access$100(short[] sArray, short s10, int n10, int n11) {
        return Shorts.lastIndexOf(sArray, s10, n10, n11);
    }

    public static List asList(short ... sArray) {
        int n10 = sArray.length;
        if (n10 == 0) {
            return Collections.emptyList();
        }
        Shorts$ShortArrayAsList shorts$ShortArrayAsList = new Shorts$ShortArrayAsList(sArray);
        return shorts$ShortArrayAsList;
    }

    public static short checkedCast(long l10) {
        short s10 = (short)l10;
        long l11 = s10;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "Out of range: %s", l10);
        return s10;
    }

    public static int compare(short s10, short s11) {
        return s10 - s11;
    }

    public static short[] concat(short[] ... sArray) {
        int n10;
        short[] sArray2;
        int n11;
        int n12 = sArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            sArray2 = sArray[n11];
            n10 = sArray2.length;
            n13 += n10;
        }
        short[] sArray3 = new short[n13];
        n11 = sArray.length;
        n10 = 0;
        sArray2 = null;
        for (n13 = 0; n13 < n11; ++n13) {
            short[] sArray4 = sArray[n13];
            int n14 = sArray4.length;
            System.arraycopy(sArray4, 0, sArray3, n10, n14);
            int n15 = sArray4.length;
            n10 += n15;
        }
        return sArray3;
    }

    public static short constrainToRange(short s10, short s11, short s12) {
        boolean bl2 = s11 <= s12;
        String string2 = "min (%s) must be less than or equal to max (%s)";
        Preconditions.checkArgument(bl2, string2, (int)s11, (int)s12);
        if (s10 < s11) {
            s10 = s11;
        } else if (s10 >= s12) {
            s10 = s12;
        }
        return s10;
    }

    public static boolean contains(short[] sArray, short s10) {
        for (short s11 : sArray) {
            if (s11 != s10) continue;
            return true;
        }
        return false;
    }

    public static short[] ensureCapacity(short[] sArray, int n10, int n11) {
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
        n12 = sArray.length;
        if (n12 < n10) {
            sArray = Arrays.copyOf(sArray, n10 += n11);
        }
        return sArray;
    }

    public static short fromByteArray(byte[] byArray) {
        byte by2 = byArray.length;
        byte by3 = 1;
        byte by4 = 2;
        by2 = by2 >= by4 ? by3 : (byte)0;
        int n10 = byArray.length;
        Preconditions.checkArgument(by2 != 0, "array too small: %s < %s", n10, (int)by4);
        by2 = byArray[0];
        byte by5 = byArray[by3];
        return Shorts.fromBytes(by2, by5);
    }

    public static short fromBytes(byte by2, byte by3) {
        by2 = (byte)(by2 << 8);
        by3 = (byte)(by3 & 0xFF);
        return (short)(by2 | by3);
    }

    public static int hashCode(short s10) {
        return s10;
    }

    public static int indexOf(short[] sArray, short s10) {
        int n10 = sArray.length;
        return Shorts.indexOf(sArray, s10, 0, n10);
    }

    private static int indexOf(short[] sArray, short s10, int n10, int n11) {
        while (n10 < n11) {
            short s11 = sArray[n10];
            if (s11 == s10) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public static int indexOf(short[] sArray, short[] sArray2) {
        block3: {
            Preconditions.checkNotNull(sArray, "array");
            String string2 = "target";
            Preconditions.checkNotNull(sArray2, string2);
            int n10 = sArray2.length;
            if (n10 == 0) {
                return 0;
            }
            n10 = 0;
            string2 = null;
            block0: while (true) {
                int n11 = sArray.length;
                int n12 = sArray2.length;
                if (n10 >= (n11 = n11 - n12 + 1)) break block3;
                for (n11 = 0; n11 < (n12 = sArray2.length); ++n11) {
                    n12 = n10 + n11;
                    short s10 = sArray2[n11];
                    if ((n12 = sArray[n12]) == s10) continue;
                    ++n10;
                    continue block0;
                }
                break;
            }
            return n10;
        }
        return -1;
    }

    public static String join(String string2, short ... sArray) {
        int n10;
        Preconditions.checkNotNull(string2);
        int n11 = sArray.length;
        if (n11 == 0) {
            return "";
        }
        int n12 = sArray.length * 6;
        StringBuilder stringBuilder = new StringBuilder(n12);
        n12 = sArray[0];
        stringBuilder.append(n12);
        for (n12 = 1; n12 < (n10 = sArray.length); ++n12) {
            stringBuilder.append(string2);
            n10 = sArray[n12];
            stringBuilder.append(n10);
        }
        return stringBuilder.toString();
    }

    public static int lastIndexOf(short[] sArray, short s10) {
        int n10 = sArray.length;
        return Shorts.lastIndexOf(sArray, s10, 0, n10);
    }

    private static int lastIndexOf(short[] sArray, short s10, int n10, int n11) {
        n11 += -1;
        while (n11 >= n10) {
            short s11 = sArray[n11];
            if (s11 == s10) {
                return n11;
            }
            n11 += -1;
        }
        return -1;
    }

    public static Comparator lexicographicalComparator() {
        return Shorts$LexicographicalComparator.INSTANCE;
    }

    public static short max(short ... sArray) {
        int n10;
        int n11 = sArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = sArray[0];
        for (n10 = 1; n10 < (n12 = sArray.length); ++n10) {
            n12 = sArray[n10];
            if (n12 <= n11) continue;
            n11 = sArray[n10];
        }
        return (short)n11;
    }

    public static short min(short ... sArray) {
        int n10;
        int n11 = sArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = sArray[0];
        for (n10 = 1; n10 < (n12 = sArray.length); ++n10) {
            n12 = sArray[n10];
            if (n12 >= n11) continue;
            n11 = sArray[n10];
        }
        return (short)n11;
    }

    public static void reverse(short[] sArray) {
        Preconditions.checkNotNull(sArray);
        int n10 = sArray.length;
        Shorts.reverse(sArray, 0, n10);
    }

    public static void reverse(short[] sArray, int n10, int n11) {
        Preconditions.checkNotNull(sArray);
        int n12 = sArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n11 += -1;
        while (n10 < n11) {
            short s10;
            n12 = sArray[n10];
            sArray[n10] = s10 = sArray[n11];
            sArray[n11] = n12;
            ++n10;
            n11 += -1;
        }
    }

    public static short saturatedCast(long l10) {
        long l11 = 32767L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return Short.MAX_VALUE;
        }
        l11 = -32768L;
        long l13 = l10 - l11;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            return Short.MIN_VALUE;
        }
        return (short)l10;
    }

    public static void sortDescending(short[] sArray) {
        Preconditions.checkNotNull(sArray);
        int n10 = sArray.length;
        Shorts.sortDescending(sArray, 0, n10);
    }

    public static void sortDescending(short[] sArray, int n10, int n11) {
        Preconditions.checkNotNull(sArray);
        int n12 = sArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        Arrays.sort(sArray, n10, n11);
        Shorts.reverse(sArray, n10, n11);
    }

    public static Converter stringConverter() {
        return Shorts$ShortConverter.INSTANCE;
    }

    public static short[] toArray(Collection objectArray) {
        int n10 = objectArray instanceof Shorts$ShortArrayAsList;
        if (n10 != 0) {
            return ((Shorts$ShortArrayAsList)objectArray).toShortArray();
        }
        objectArray = objectArray.toArray();
        n10 = objectArray.length;
        short[] sArray = new short[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10;
            Number number = (Number)Preconditions.checkNotNull(objectArray[i10]);
            sArray[i10] = s10 = number.shortValue();
        }
        return sArray;
    }

    public static byte[] toByteArray(short s10) {
        byte by2 = (byte)(s10 >> 8);
        byte[] byArray = new byte[]{by2, s10 = (short)((byte)s10)};
        return byArray;
    }
}

