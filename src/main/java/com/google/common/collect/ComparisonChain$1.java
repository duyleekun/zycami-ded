/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

public final class ComparisonChain$1
extends ComparisonChain {
    public ComparisonChain$1() {
        super(null);
    }

    public ComparisonChain classify(int n10) {
        ComparisonChain comparisonChain = n10 < 0 ? ComparisonChain.access$100() : (n10 > 0 ? ComparisonChain.access$200() : ComparisonChain.access$300());
        return comparisonChain;
    }

    public ComparisonChain compare(double d10, double d11) {
        int n10 = Double.compare(d10, d11);
        return this.classify(n10);
    }

    public ComparisonChain compare(float f10, float f11) {
        int n10 = Float.compare(f10, f11);
        return this.classify(n10);
    }

    public ComparisonChain compare(int n10, int n11) {
        n10 = Ints.compare(n10, n11);
        return this.classify(n10);
    }

    public ComparisonChain compare(long l10, long l11) {
        int n10 = Longs.compare(l10, l11);
        return this.classify(n10);
    }

    public ComparisonChain compare(Comparable comparable, Comparable comparable2) {
        int n10 = comparable.compareTo(comparable2);
        return this.classify(n10);
    }

    public ComparisonChain compare(Object object, Object object2, Comparator comparator) {
        int n10 = comparator.compare(object, object2);
        return this.classify(n10);
    }

    /*
     * WARNING - void declaration
     */
    public ComparisonChain compareFalseFirst(boolean bl2, boolean bl3) {
        void var2_3;
        int n10 = Booleans.compare(bl2, (boolean)var2_3);
        return this.classify(n10);
    }

    /*
     * WARNING - void declaration
     */
    public ComparisonChain compareTrueFirst(boolean bl2, boolean bl3) {
        void var2_3;
        int n10 = Booleans.compare((boolean)var2_3, bl2);
        return this.classify(n10);
    }

    public int result() {
        return 0;
    }
}

