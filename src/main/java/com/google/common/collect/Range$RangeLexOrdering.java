/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Cut;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import java.io.Serializable;

public class Range$RangeLexOrdering
extends Ordering
implements Serializable {
    public static final Ordering INSTANCE;
    private static final long serialVersionUID;

    static {
        Range$RangeLexOrdering range$RangeLexOrdering = new Range$RangeLexOrdering();
        INSTANCE = range$RangeLexOrdering;
    }

    private Range$RangeLexOrdering() {
    }

    public int compare(Range serializable, Range serializable2) {
        ComparisonChain comparisonChain = ComparisonChain.start();
        Cut cut = serializable.lowerBound;
        Cut cut2 = serializable2.lowerBound;
        comparisonChain = comparisonChain.compare(cut, cut2);
        serializable = serializable.upperBound;
        serializable2 = serializable2.upperBound;
        return comparisonChain.compare((Comparable)((Object)serializable), (Comparable)((Object)serializable2)).result();
    }
}

