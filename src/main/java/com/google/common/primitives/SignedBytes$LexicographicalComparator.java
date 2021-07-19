/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.SignedBytes;
import java.util.Comparator;

public final class SignedBytes$LexicographicalComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ SignedBytes$LexicographicalComparator[] $VALUES;
    public static final /* enum */ SignedBytes$LexicographicalComparator INSTANCE;

    static {
        SignedBytes$LexicographicalComparator signedBytes$LexicographicalComparator;
        INSTANCE = signedBytes$LexicographicalComparator = new SignedBytes$LexicographicalComparator("INSTANCE", 0);
        SignedBytes$LexicographicalComparator[] signedBytes$LexicographicalComparatorArray = new SignedBytes$LexicographicalComparator[]{signedBytes$LexicographicalComparator};
        $VALUES = signedBytes$LexicographicalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SignedBytes$LexicographicalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static SignedBytes$LexicographicalComparator valueOf(String string2) {
        return Enum.valueOf(SignedBytes$LexicographicalComparator.class, string2);
    }

    public static SignedBytes$LexicographicalComparator[] values() {
        return (SignedBytes$LexicographicalComparator[])$VALUES.clone();
    }

    public int compare(byte[] byArray, byte[] byArray2) {
        int n10 = byArray.length;
        int n11 = byArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            int n12 = byArray[n11];
            byte by2 = byArray2[n11];
            if ((n12 = SignedBytes.compare((byte)n12, by2)) == 0) continue;
            return n12;
        }
        int n13 = byArray.length;
        int n14 = byArray2.length;
        return n13 - n14;
    }

    public String toString() {
        return "SignedBytes.lexicographicalComparator()";
    }
}

