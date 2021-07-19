/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedLongs;
import java.util.Comparator;

public final class UnsignedLongs$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ UnsignedLongs$LexicographicalComparator[] $VALUES;
    public static final /* enum */ UnsignedLongs$LexicographicalComparator INSTANCE;

    static {
        UnsignedLongs$LexicographicalComparator unsignedLongs$LexicographicalComparator;
        INSTANCE = unsignedLongs$LexicographicalComparator = new UnsignedLongs$LexicographicalComparator("INSTANCE", 0);
        UnsignedLongs$LexicographicalComparator[] unsignedLongs$LexicographicalComparatorArray = new UnsignedLongs$LexicographicalComparator[]{unsignedLongs$LexicographicalComparator};
        $VALUES = unsignedLongs$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private UnsignedLongs$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static UnsignedLongs$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(UnsignedLongs$LexicographicalComparator.class, string2);
    }

    public static UnsignedLongs$LexicographicalComparator[] values() {
        return (UnsignedLongs$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(long[] lArray, long[] lArray2) {
        int n10 = lArray.length;
        int n11 = lArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            long l10 = lArray[n11];
            long l11 = lArray2[n11];
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) continue;
            l10 = lArray[n11];
            long l13 = lArray2[n11];
            return UnsignedLongs.compare(l10, l13);
        }
        int n12 = lArray.length;
        int n13 = lArray2.length;
        return n12 - n13;
    }

    public String toString() {
        return "UnsignedLongs.lexicographicalComparator()";
    }
}

