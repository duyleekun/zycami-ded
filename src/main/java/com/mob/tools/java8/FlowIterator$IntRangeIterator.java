/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$RangeIterator;

public class FlowIterator$IntRangeIterator
extends FlowIterator$RangeIterator {
    public FlowIterator$IntRangeIterator(Integer n10, Integer n11, Integer n12) {
        super(n10, n11, n12);
    }

    public Integer increase(Integer n10, Integer n11) {
        int n12 = n10;
        int n13 = n11;
        return n12 + n13;
    }
}

