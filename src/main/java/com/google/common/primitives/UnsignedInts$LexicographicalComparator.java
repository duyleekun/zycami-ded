/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedInts;
import java.util.Comparator;

public final class UnsignedInts$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ UnsignedInts$LexicographicalComparator[] $VALUES;
    public static final /* enum */ UnsignedInts$LexicographicalComparator INSTANCE;

    static {
        UnsignedInts$LexicographicalComparator unsignedInts$LexicographicalComparator;
        INSTANCE = unsignedInts$LexicographicalComparator = new UnsignedInts$LexicographicalComparator("INSTANCE", 0);
        UnsignedInts$LexicographicalComparator[] unsignedInts$LexicographicalComparatorArray = new UnsignedInts$LexicographicalComparator[]{unsignedInts$LexicographicalComparator};
        $VALUES = unsignedInts$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private UnsignedInts$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static UnsignedInts$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(UnsignedInts$LexicographicalComparator.class, string2);
    }

    public static UnsignedInts$LexicographicalComparator[] values() {
        return (UnsignedInts$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(int[] nArray, int[] nArray2) {
        int n10 = nArray.length;
        int n11 = nArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            int n12 = nArray[n11];
            int n13 = nArray2[n11];
            if (n12 == n13) continue;
            int n14 = nArray[n11];
            int n15 = nArray2[n11];
            return UnsignedInts.compare(n14, n15);
        }
        int n16 = nArray.length;
        int n17 = nArray2.length;
        return n16 - n17;
    }

    public String toString() {
        return "UnsignedInts.lexicographicalComparator()";
    }
}

