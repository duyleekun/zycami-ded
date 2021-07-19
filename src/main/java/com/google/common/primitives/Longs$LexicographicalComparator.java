/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.Longs;
import java.util.Comparator;

public final class Longs$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ Longs$LexicographicalComparator[] $VALUES;
    public static final /* enum */ Longs$LexicographicalComparator INSTANCE;

    static {
        Longs$LexicographicalComparator longs$LexicographicalComparator;
        INSTANCE = longs$LexicographicalComparator = new Longs$LexicographicalComparator("INSTANCE", 0);
        Longs$LexicographicalComparator[] longs$LexicographicalComparatorArray = new Longs$LexicographicalComparator[]{longs$LexicographicalComparator};
        $VALUES = longs$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Longs$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static Longs$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(Longs$LexicographicalComparator.class, string2);
    }

    public static Longs$LexicographicalComparator[] values() {
        return (Longs$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(long[] lArray, long[] lArray2) {
        int n10 = lArray.length;
        int n11 = lArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            long l10 = lArray[n11];
            long l11 = lArray2[n11];
            int n12 = Longs.compare(l10, l11);
            if (n12 == 0) continue;
            return n12;
        }
        int n13 = lArray.length;
        int n14 = lArray2.length;
        return n13 - n14;
    }

    public String toString() {
        return "Longs.lexicographicalComparator()";
    }
}

