/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.Chars;
import java.util.Comparator;

public final class Chars$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ Chars$LexicographicalComparator[] $VALUES;
    public static final /* enum */ Chars$LexicographicalComparator INSTANCE;

    static {
        Chars$LexicographicalComparator chars$LexicographicalComparator;
        INSTANCE = chars$LexicographicalComparator = new Chars$LexicographicalComparator("INSTANCE", 0);
        Chars$LexicographicalComparator[] chars$LexicographicalComparatorArray = new Chars$LexicographicalComparator[]{chars$LexicographicalComparator};
        $VALUES = chars$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Chars$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static Chars$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(Chars$LexicographicalComparator.class, string2);
    }

    public static Chars$LexicographicalComparator[] values() {
        return (Chars$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(char[] cArray, char[] cArray2) {
        int n10 = cArray.length;
        int n11 = cArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            int n12 = cArray[n11];
            char c10 = cArray2[n11];
            if ((n12 = Chars.compare((char)n12, c10)) == 0) continue;
            return n12;
        }
        int n13 = cArray.length;
        int n14 = cArray2.length;
        return n13 - n14;
    }

    public String toString() {
        return "Chars.lexicographicalComparator()";
    }
}

