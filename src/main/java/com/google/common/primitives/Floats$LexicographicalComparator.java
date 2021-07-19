/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import java.util.Comparator;

public final class Floats$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ Floats$LexicographicalComparator[] $VALUES;
    public static final /* enum */ Floats$LexicographicalComparator INSTANCE;

    static {
        Floats$LexicographicalComparator floats$LexicographicalComparator;
        INSTANCE = floats$LexicographicalComparator = new Floats$LexicographicalComparator("INSTANCE", 0);
        Floats$LexicographicalComparator[] floats$LexicographicalComparatorArray = new Floats$LexicographicalComparator[]{floats$LexicographicalComparator};
        $VALUES = floats$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Floats$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static Floats$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(Floats$LexicographicalComparator.class, string2);
    }

    public static Floats$LexicographicalComparator[] values() {
        return (Floats$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(float[] fArray, float[] fArray2) {
        int n10 = fArray.length;
        int n11 = fArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            float f10 = fArray[n11];
            float f11 = fArray2[n11];
            int n12 = Float.compare(f10, f11);
            if (n12 == 0) continue;
            return n12;
        }
        int n13 = fArray.length;
        int n14 = fArray2.length;
        return n13 - n14;
    }

    public String toString() {
        return "Floats.lexicographicalComparator()";
    }
}

