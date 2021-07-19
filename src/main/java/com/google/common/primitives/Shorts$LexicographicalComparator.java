/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.Shorts;
import java.util.Comparator;

public final class Shorts$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ Shorts$LexicographicalComparator[] $VALUES;
    public static final /* enum */ Shorts$LexicographicalComparator INSTANCE;

    static {
        Shorts$LexicographicalComparator shorts$LexicographicalComparator;
        INSTANCE = shorts$LexicographicalComparator = new Shorts$LexicographicalComparator("INSTANCE", 0);
        Shorts$LexicographicalComparator[] shorts$LexicographicalComparatorArray = new Shorts$LexicographicalComparator[]{shorts$LexicographicalComparator};
        $VALUES = shorts$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Shorts$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static Shorts$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(Shorts$LexicographicalComparator.class, string2);
    }

    public static Shorts$LexicographicalComparator[] values() {
        return (Shorts$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(short[] sArray, short[] sArray2) {
        int n10 = sArray.length;
        int n11 = sArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            int n12 = sArray[n11];
            short s10 = sArray2[n11];
            if ((n12 = Shorts.compare((short)n12, s10)) == 0) continue;
            return n12;
        }
        int n13 = sArray.length;
        int n14 = sArray2.length;
        return n13 - n14;
    }

    public String toString() {
        return "Shorts.lexicographicalComparator()";
    }
}

