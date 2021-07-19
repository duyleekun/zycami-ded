/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import java.util.Comparator;

public final class Doubles$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ Doubles$LexicographicalComparator[] $VALUES;
    public static final /* enum */ Doubles$LexicographicalComparator INSTANCE;

    static {
        Doubles$LexicographicalComparator doubles$LexicographicalComparator;
        INSTANCE = doubles$LexicographicalComparator = new Doubles$LexicographicalComparator("INSTANCE", 0);
        Doubles$LexicographicalComparator[] doubles$LexicographicalComparatorArray = new Doubles$LexicographicalComparator[]{doubles$LexicographicalComparator};
        $VALUES = doubles$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Doubles$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static Doubles$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(Doubles$LexicographicalComparator.class, string2);
    }

    public static Doubles$LexicographicalComparator[] values() {
        return (Doubles$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(double[] dArray, double[] dArray2) {
        int n10 = dArray.length;
        int n11 = dArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            double d10 = dArray[n11];
            double d11 = dArray2[n11];
            int n12 = Double.compare(d10, d11);
            if (n12 == 0) continue;
            return n12;
        }
        int n13 = dArray.length;
        int n14 = dArray2.length;
        return n13 - n14;
    }

    public String toString() {
        return "Doubles.lexicographicalComparator()";
    }
}

