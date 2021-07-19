/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ComparisonChain$1;
import com.google.common.collect.ComparisonChain$InactiveComparisonChain;
import java.util.Comparator;

public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE;
    private static final ComparisonChain GREATER;
    private static final ComparisonChain LESS;

    static {
        ComparisonChain comparisonChain = new ComparisonChain$1();
        ACTIVE = comparisonChain;
        comparisonChain = new ComparisonChain$InactiveComparisonChain(-1);
        LESS = comparisonChain;
        comparisonChain = new ComparisonChain$InactiveComparisonChain(1);
        GREATER = comparisonChain;
    }

    private ComparisonChain() {
    }

    public /* synthetic */ ComparisonChain(ComparisonChain$1 var1_1) {
        this();
    }

    public static /* synthetic */ ComparisonChain access$100() {
        return LESS;
    }

    public static /* synthetic */ ComparisonChain access$200() {
        return GREATER;
    }

    public static /* synthetic */ ComparisonChain access$300() {
        return ACTIVE;
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(double var1, double var3);

    public abstract ComparisonChain compare(float var1, float var2);

    public abstract ComparisonChain compare(int var1, int var2);

    public abstract ComparisonChain compare(long var1, long var3);

    public final ComparisonChain compare(Boolean bl2, Boolean bl3) {
        boolean bl4 = bl2;
        boolean bl5 = bl3;
        return this.compareFalseFirst(bl4, bl5);
    }

    public abstract ComparisonChain compare(Comparable var1, Comparable var2);

    public abstract ComparisonChain compare(Object var1, Object var2, Comparator var3);

    public abstract ComparisonChain compareFalseFirst(boolean var1, boolean var2);

    public abstract ComparisonChain compareTrueFirst(boolean var1, boolean var2);

    public abstract int result();
}

