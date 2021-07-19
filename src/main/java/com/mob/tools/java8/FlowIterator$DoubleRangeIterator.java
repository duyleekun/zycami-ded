/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$RangeIterator;

public class FlowIterator$DoubleRangeIterator
extends FlowIterator$RangeIterator {
    public FlowIterator$DoubleRangeIterator(Double d10, Double d11, Double d12) {
        super(d10, d11, d12);
    }

    public Double increase(Double d10, Double d11) {
        double d12 = d10;
        double d13 = d11;
        return d12 + d13;
    }
}

