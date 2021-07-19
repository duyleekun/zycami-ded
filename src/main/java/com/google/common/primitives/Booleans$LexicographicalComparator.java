/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.Booleans;
import java.util.Comparator;

public final class Booleans$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ Booleans$LexicographicalComparator[] $VALUES;
    public static final /* enum */ Booleans$LexicographicalComparator INSTANCE;

    static {
        Booleans$LexicographicalComparator booleans$LexicographicalComparator;
        INSTANCE = booleans$LexicographicalComparator = new Booleans$LexicographicalComparator("INSTANCE", 0);
        Booleans$LexicographicalComparator[] booleans$LexicographicalComparatorArray = new Booleans$LexicographicalComparator[]{booleans$LexicographicalComparator};
        $VALUES = booleans$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Booleans$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static Booleans$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(Booleans$LexicographicalComparator.class, string2);
    }

    public static Booleans$LexicographicalComparator[] values() {
        return (Booleans$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(boolean[] blArray, boolean[] blArray2) {
        int n10 = blArray.length;
        int n11 = blArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            int n12 = blArray[n11];
            boolean bl2 = blArray2[n11];
            if ((n12 = Booleans.compare(n12 != 0, bl2)) == 0) continue;
            return n12;
        }
        int n13 = blArray.length;
        int n14 = blArray2.length;
        return n13 - n14;
    }

    public String toString() {
        return "Booleans.lexicographicalComparator()";
    }
}

