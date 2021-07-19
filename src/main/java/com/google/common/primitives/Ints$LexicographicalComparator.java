/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.Ints;
import java.util.Comparator;

public final class Ints$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ Ints$LexicographicalComparator[] $VALUES;
    public static final /* enum */ Ints$LexicographicalComparator INSTANCE;

    static {
        Ints$LexicographicalComparator ints$LexicographicalComparator;
        INSTANCE = ints$LexicographicalComparator = new Ints$LexicographicalComparator("INSTANCE", 0);
        Ints$LexicographicalComparator[] ints$LexicographicalComparatorArray = new Ints$LexicographicalComparator[]{ints$LexicographicalComparator};
        $VALUES = ints$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Ints$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static Ints$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(Ints$LexicographicalComparator.class, string2);
    }

    public static Ints$LexicographicalComparator[] values() {
        return (Ints$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(int[] nArray, int[] nArray2) {
        int n10 = nArray.length;
        int n11 = nArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            int n12 = nArray[n11];
            int n13 = nArray2[n11];
            if ((n12 = Ints.compare(n12, n13)) == 0) continue;
            return n12;
        }
        int n14 = nArray.length;
        int n15 = nArray2.length;
        return n14 - n15;
    }

    public String toString() {
        return "Ints.lexicographicalComparator()";
    }
}

