/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

public final class ComparisonChain$InactiveComparisonChain
extends ComparisonChain {
    public final int result;

    public ComparisonChain$InactiveComparisonChain(int n10) {
        super(null);
        this.result = n10;
    }

    public ComparisonChain compare(double d10, double d11) {
        return this;
    }

    public ComparisonChain compare(float f10, float f11) {
        return this;
    }

    public ComparisonChain compare(int n10, int n11) {
        return this;
    }

    public ComparisonChain compare(long l10, long l11) {
        return this;
    }

    public ComparisonChain compare(Comparable comparable, Comparable comparable2) {
        return this;
    }

    public ComparisonChain compare(Object object, Object object2, Comparator comparator) {
        return this;
    }

    public ComparisonChain compareFalseFirst(boolean bl2, boolean bl3) {
        return this;
    }

    public ComparisonChain compareTrueFirst(boolean bl2, boolean bl3) {
        return this;
    }

    public int result() {
        return this.result;
    }
}

