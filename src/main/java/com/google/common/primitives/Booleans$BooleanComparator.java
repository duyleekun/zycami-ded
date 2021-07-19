/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import java.util.Comparator;

public final class Booleans$BooleanComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ Booleans$BooleanComparator[] $VALUES;
    public static final /* enum */ Booleans$BooleanComparator FALSE_FIRST;
    public static final /* enum */ Booleans$BooleanComparator TRUE_FIRST;
    private final String toString;
    private final int trueValue;

    static {
        Booleans$BooleanComparator booleans$BooleanComparator;
        Booleans$BooleanComparator booleans$BooleanComparator2;
        int n10 = 1;
        TRUE_FIRST = booleans$BooleanComparator2 = new Booleans$BooleanComparator("TRUE_FIRST", 0, n10, "Booleans.trueFirst()");
        FALSE_FIRST = booleans$BooleanComparator = new Booleans$BooleanComparator("FALSE_FIRST", n10, -1, "Booleans.falseFirst()");
        Booleans$BooleanComparator[] booleans$BooleanComparatorArray = new Booleans$BooleanComparator[2];
        booleans$BooleanComparatorArray[0] = booleans$BooleanComparator2;
        booleans$BooleanComparatorArray[n10] = booleans$BooleanComparator;
        $VALUES = booleans$BooleanComparatorArray;
    }

    /*
     * WARNING - void declaration
     */
    private Booleans$BooleanComparator() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.trueValue = var3_1;
        this.toString = var4_2;
    }

    public static Booleans$BooleanComparator valueOf(String string2) {
        return Enum.valueOf(Booleans$BooleanComparator.class, string2);
    }

    public static Booleans$BooleanComparator[] values() {
        return (Booleans$BooleanComparator[])$VALUES.clone();
    }

    public int compare(Boolean bl2, Boolean bl3) {
        int n10 = bl2.booleanValue();
        int n11 = 0;
        if (n10 != 0) {
            n10 = this.trueValue;
        } else {
            n10 = 0;
            bl2 = null;
        }
        boolean bl4 = bl3;
        if (bl4) {
            n11 = this.trueValue;
        }
        return n11 - n10;
    }

    public String toString() {
        return this.toString;
    }
}

