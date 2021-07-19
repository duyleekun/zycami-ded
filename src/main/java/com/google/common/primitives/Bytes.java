/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Bytes$ByteArrayAsList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Bytes {
    private Bytes() {
    }

    public static /* synthetic */ int access$000(byte[] byArray, byte by2, int n10, int n11) {
        return Bytes.indexOf(byArray, by2, n10, n11);
    }

    public static /* synthetic */ int access$100(byte[] byArray, byte by2, int n10, int n11) {
        return Bytes.lastIndexOf(byArray, by2, n10, n11);
    }

    public static List asList(byte ... byArray) {
        int n10 = byArray.length;
        if (n10 == 0) {
            return Collections.emptyList();
        }
        Bytes$ByteArrayAsList bytes$ByteArrayAsList = new Bytes$ByteArrayAsList(byArray);
        return bytes$ByteArrayAsList;
    }

    public static byte[] concat(byte[] ... byArray) {
        int n10;
        byte[] byArray2;
        int n11;
        int n12 = byArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            byArray2 = byArray[n11];
            n10 = byArray2.length;
            n13 += n10;
        }
        byte[] byArray3 = new byte[n13];
        n11 = byArray.length;
        n10 = 0;
        byArray2 = null;
        for (n13 = 0; n13 < n11; ++n13) {
            byte[] byArray4 = byArray[n13];
            int n14 = byArray4.length;
            System.arraycopy(byArray4, 0, byArray3, n10, n14);
            int n15 = byArray4.length;
            n10 += n15;
        }
        return byArray3;
    }

    public static boolean contains(byte[] byArray, byte by2) {
        for (byte by3 : byArray) {
            if (by3 != by2) continue;
            return true;
        }
        return false;
    }

    public static byte[] ensureCapacity(byte[] byArray, int n10, int n11) {
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
        n12 = byArray.length;
        if (n12 < n10) {
            byArray = Arrays.copyOf(byArray, n10 += n11);
        }
        return byArray;
    }

    public static int hashCode(byte by2) {
        return by2;
    }

    public static int indexOf(byte[] byArray, byte by2) {
        int n10 = byArray.length;
        return Bytes.indexOf(byArray, by2, 0, n10);
    }

    private static int indexOf(byte[] byArray, byte by2, int n10, int n11) {
        while (n10 < n11) {
            byte by3 = byArray[n10];
            if (by3 == by2) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public static int indexOf(byte[] byArray, byte[] byArray2) {
        block3: {
            Preconditions.checkNotNull(byArray, "array");
            String string2 = "target";
            Preconditions.checkNotNull(byArray2, string2);
            int n10 = byArray2.length;
            if (n10 == 0) {
                return 0;
            }
            n10 = 0;
            string2 = null;
            block0: while (true) {
                int n11 = byArray.length;
                int n12 = byArray2.length;
                if (n10 >= (n11 = n11 - n12 + 1)) break block3;
                for (n11 = 0; n11 < (n12 = byArray2.length); ++n11) {
                    n12 = n10 + n11;
                    byte by2 = byArray2[n11];
                    if ((n12 = byArray[n12]) == by2) continue;
                    ++n10;
                    continue block0;
                }
                break;
            }
            return n10;
        }
        return -1;
    }

    public static int lastIndexOf(byte[] byArray, byte by2) {
        int n10 = byArray.length;
        return Bytes.lastIndexOf(byArray, by2, 0, n10);
    }

    private static int lastIndexOf(byte[] byArray, byte by2, int n10, int n11) {
        n11 += -1;
        while (n11 >= n10) {
            byte by3 = byArray[n11];
            if (by3 == by2) {
                return n11;
            }
            n11 += -1;
        }
        return -1;
    }

    public static void reverse(byte[] byArray) {
        Preconditions.checkNotNull(byArray);
        int n10 = byArray.length;
        Bytes.reverse(byArray, 0, n10);
    }

    public static void reverse(byte[] byArray, int n10, int n11) {
        Preconditions.checkNotNull(byArray);
        int n12 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n11 += -1;
        while (n10 < n11) {
            byte by2;
            n12 = byArray[n10];
            byArray[n10] = by2 = byArray[n11];
            byArray[n11] = n12;
            ++n10;
            n11 += -1;
        }
    }

    public static byte[] toArray(Collection objectArray) {
        int n10 = objectArray instanceof Bytes$ByteArrayAsList;
        if (n10 != 0) {
            return ((Bytes$ByteArrayAsList)objectArray).toByteArray();
        }
        objectArray = objectArray.toArray();
        n10 = objectArray.length;
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2;
            Number number = (Number)Preconditions.checkNotNull(objectArray[i10]);
            byArray[i10] = by2 = number.byteValue();
        }
        return byArray;
    }
}

