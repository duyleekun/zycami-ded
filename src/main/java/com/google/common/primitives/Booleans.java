/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans$BooleanArrayAsList;
import com.google.common.primitives.Booleans$BooleanComparator;
import com.google.common.primitives.Booleans$LexicographicalComparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Booleans {
    private Booleans() {
    }

    public static /* synthetic */ int access$000(boolean[] blArray, boolean bl2, int n10, int n11) {
        return Booleans.indexOf(blArray, bl2, n10, n11);
    }

    public static /* synthetic */ int access$100(boolean[] blArray, boolean bl2, int n10, int n11) {
        return Booleans.lastIndexOf(blArray, bl2, n10, n11);
    }

    public static List asList(boolean ... blArray) {
        int n10 = blArray.length;
        if (n10 == 0) {
            return Collections.emptyList();
        }
        Booleans$BooleanArrayAsList booleans$BooleanArrayAsList = new Booleans$BooleanArrayAsList(blArray);
        return booleans$BooleanArrayAsList;
    }

    public static int compare(boolean n10, boolean n11) {
        n10 = n10 == n11 ? 0 : (n10 != 0 ? 1 : -1);
        return n10;
    }

    public static boolean[] concat(boolean[] ... blArray) {
        int n10;
        boolean[] blArray2;
        int n11;
        int n12 = blArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            blArray2 = blArray[n11];
            n10 = blArray2.length;
            n13 += n10;
        }
        boolean[] blArray3 = new boolean[n13];
        n11 = blArray.length;
        n10 = 0;
        blArray2 = null;
        for (n13 = 0; n13 < n11; ++n13) {
            boolean[] blArray4 = blArray[n13];
            int n14 = blArray4.length;
            System.arraycopy(blArray4, 0, blArray3, n10, n14);
            int n15 = blArray4.length;
            n10 += n15;
        }
        return blArray3;
    }

    public static boolean contains(boolean[] blArray, boolean bl2) {
        for (boolean bl3 : blArray) {
            if (bl3 != bl2) continue;
            return true;
        }
        return false;
    }

    public static int countTrue(boolean ... blArray) {
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static boolean[] ensureCapacity(boolean[] blArray, int n10, int n11) {
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
        n12 = blArray.length;
        if (n12 < n10) {
            blArray = Arrays.copyOf(blArray, n10 += n11);
        }
        return blArray;
    }

    public static Comparator falseFirst() {
        return Booleans$BooleanComparator.FALSE_FIRST;
    }

    /*
     * WARNING - void declaration
     */
    public static int hashCode(boolean bl2) {
        void var0_3;
        if (bl2) {
            int n10 = 1231;
        } else {
            int n11 = 1237;
        }
        return (int)var0_3;
    }

    public static int indexOf(boolean[] blArray, boolean bl2) {
        int n10 = blArray.length;
        return Booleans.indexOf(blArray, bl2, 0, n10);
    }

    private static int indexOf(boolean[] blArray, boolean bl2, int n10, int n11) {
        while (n10 < n11) {
            boolean bl3 = blArray[n10];
            if (bl3 == bl2) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public static int indexOf(boolean[] blArray, boolean[] blArray2) {
        block3: {
            Preconditions.checkNotNull(blArray, "array");
            String string2 = "target";
            Preconditions.checkNotNull(blArray2, string2);
            int n10 = blArray2.length;
            if (n10 == 0) {
                return 0;
            }
            n10 = 0;
            string2 = null;
            block0: while (true) {
                int n11 = blArray.length;
                int n12 = blArray2.length;
                if (n10 >= (n11 = n11 - n12 + 1)) break block3;
                for (n11 = 0; n11 < (n12 = blArray2.length); ++n11) {
                    n12 = n10 + n11;
                    int n13 = blArray2[n11];
                    if ((n12 = blArray[n12]) == n13) continue;
                    ++n10;
                    continue block0;
                }
                break;
            }
            return n10;
        }
        return -1;
    }

    public static String join(String string2, boolean ... blArray) {
        int n10;
        Preconditions.checkNotNull(string2);
        int n11 = blArray.length;
        if (n11 == 0) {
            return "";
        }
        int n12 = blArray.length * 7;
        StringBuilder stringBuilder = new StringBuilder(n12);
        n12 = blArray[0];
        stringBuilder.append(n12 != 0);
        for (n12 = 1; n12 < (n10 = blArray.length); ++n12) {
            stringBuilder.append(string2);
            n10 = blArray[n12];
            stringBuilder.append(n10 != 0);
        }
        return stringBuilder.toString();
    }

    public static int lastIndexOf(boolean[] blArray, boolean bl2) {
        int n10 = blArray.length;
        return Booleans.lastIndexOf(blArray, bl2, 0, n10);
    }

    private static int lastIndexOf(boolean[] blArray, boolean bl2, int n10, int n11) {
        n11 += -1;
        while (n11 >= n10) {
            boolean bl3 = blArray[n11];
            if (bl3 == bl2) {
                return n11;
            }
            n11 += -1;
        }
        return -1;
    }

    public static Comparator lexicographicalComparator() {
        return Booleans$LexicographicalComparator.INSTANCE;
    }

    public static void reverse(boolean[] blArray) {
        Preconditions.checkNotNull(blArray);
        int n10 = blArray.length;
        Booleans.reverse(blArray, 0, n10);
    }

    public static void reverse(boolean[] blArray, int n10, int n11) {
        Preconditions.checkNotNull(blArray);
        int n12 = blArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n11 += -1;
        while (n10 < n11) {
            boolean bl2;
            n12 = blArray[n10];
            blArray[n10] = bl2 = blArray[n11];
            blArray[n11] = n12;
            ++n10;
            n11 += -1;
        }
    }

    public static boolean[] toArray(Collection objectArray) {
        int n10 = objectArray instanceof Booleans$BooleanArrayAsList;
        if (n10 != 0) {
            return ((Booleans$BooleanArrayAsList)objectArray).toBooleanArray();
        }
        objectArray = objectArray.toArray();
        n10 = objectArray.length;
        boolean[] blArray = new boolean[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            Boolean bl3 = (Boolean)Preconditions.checkNotNull(objectArray[i10]);
            blArray[i10] = bl2 = bl3.booleanValue();
        }
        return blArray;
    }

    public static Comparator trueFirst() {
        return Booleans$BooleanComparator.TRUE_FIRST;
    }
}

