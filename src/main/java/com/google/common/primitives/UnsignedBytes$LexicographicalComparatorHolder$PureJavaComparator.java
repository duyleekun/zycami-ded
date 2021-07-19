/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

public final class UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[] $VALUES;
    public static final /* enum */ UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator INSTANCE;

    static {
        UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator unsignedBytes$LexicographicalComparatorHolder$PureJavaComparator;
        INSTANCE = unsignedBytes$LexicographicalComparatorHolder$PureJavaComparator = new UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator("INSTANCE", 0);
        UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[] unsignedBytes$LexicographicalComparatorHolder$PureJavaComparatorArray = new UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[]{unsignedBytes$LexicographicalComparatorHolder$PureJavaComparator};
        $VALUES = unsignedBytes$LexicographicalComparatorHolder$PureJavaComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator valueOf(String string2) {
        return Enum.valueOf(UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator.class, string2);
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[] values() {
        return (UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[])$VALUES.clone();
    }

    public int compare(byte[] byArray, byte[] byArray2) {
        int n10 = byArray.length;
        int n11 = byArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            int n12 = byArray[n11];
            byte by2 = byArray2[n11];
            if ((n12 = UnsignedBytes.compare((byte)n12, by2)) == 0) continue;
            return n12;
        }
        int n13 = byArray.length;
        int n14 = byArray2.length;
        return n13 - n14;
    }

    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }
}

