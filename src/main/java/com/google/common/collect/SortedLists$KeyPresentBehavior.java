/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.SortedLists$1;
import com.google.common.collect.SortedLists$KeyPresentBehavior$1;
import com.google.common.collect.SortedLists$KeyPresentBehavior$2;
import com.google.common.collect.SortedLists$KeyPresentBehavior$3;
import com.google.common.collect.SortedLists$KeyPresentBehavior$4;
import com.google.common.collect.SortedLists$KeyPresentBehavior$5;
import java.util.Comparator;
import java.util.List;

public abstract class SortedLists$KeyPresentBehavior
extends Enum {
    private static final /* synthetic */ SortedLists$KeyPresentBehavior[] $VALUES;
    public static final /* enum */ SortedLists$KeyPresentBehavior ANY_PRESENT;
    public static final /* enum */ SortedLists$KeyPresentBehavior FIRST_AFTER;
    public static final /* enum */ SortedLists$KeyPresentBehavior FIRST_PRESENT;
    public static final /* enum */ SortedLists$KeyPresentBehavior LAST_BEFORE;
    public static final /* enum */ SortedLists$KeyPresentBehavior LAST_PRESENT;

    static {
        SortedLists$KeyPresentBehavior$1 sortedLists$KeyPresentBehavior$1 = new SortedLists$KeyPresentBehavior$1();
        ANY_PRESENT = sortedLists$KeyPresentBehavior$1;
        int n10 = 1;
        SortedLists$KeyPresentBehavior$2 sortedLists$KeyPresentBehavior$2 = new SortedLists$KeyPresentBehavior$2();
        LAST_PRESENT = sortedLists$KeyPresentBehavior$2;
        int n11 = 2;
        SortedLists$KeyPresentBehavior$3 sortedLists$KeyPresentBehavior$3 = new SortedLists$KeyPresentBehavior$3();
        FIRST_PRESENT = sortedLists$KeyPresentBehavior$3;
        int n12 = 3;
        SortedLists$KeyPresentBehavior$4 sortedLists$KeyPresentBehavior$4 = new SortedLists$KeyPresentBehavior$4();
        FIRST_AFTER = sortedLists$KeyPresentBehavior$4;
        int n13 = 4;
        SortedLists$KeyPresentBehavior$5 sortedLists$KeyPresentBehavior$5 = new SortedLists$KeyPresentBehavior$5();
        LAST_BEFORE = sortedLists$KeyPresentBehavior$5;
        SortedLists$KeyPresentBehavior[] sortedLists$KeyPresentBehaviorArray = new SortedLists$KeyPresentBehavior[5];
        sortedLists$KeyPresentBehaviorArray[0] = sortedLists$KeyPresentBehavior$1;
        sortedLists$KeyPresentBehaviorArray[n10] = sortedLists$KeyPresentBehavior$2;
        sortedLists$KeyPresentBehaviorArray[n11] = sortedLists$KeyPresentBehavior$3;
        sortedLists$KeyPresentBehaviorArray[n12] = sortedLists$KeyPresentBehavior$4;
        sortedLists$KeyPresentBehaviorArray[n13] = sortedLists$KeyPresentBehavior$5;
        $VALUES = sortedLists$KeyPresentBehaviorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SortedLists$KeyPresentBehavior() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ SortedLists$KeyPresentBehavior(SortedLists$1 sortedLists$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static SortedLists$KeyPresentBehavior valueOf(String string2) {
        return Enum.valueOf(SortedLists$KeyPresentBehavior.class, string2);
    }

    public static SortedLists$KeyPresentBehavior[] values() {
        return (SortedLists$KeyPresentBehavior[])$VALUES.clone();
    }

    public abstract int resultIndex(Comparator var1, Object var2, List var3, int var4);
}

