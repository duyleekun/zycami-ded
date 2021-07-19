/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;

public class Range$LowerBoundFn
implements Function {
    public static final Range$LowerBoundFn INSTANCE;

    static {
        Range$LowerBoundFn range$LowerBoundFn;
        INSTANCE = range$LowerBoundFn = new Range$LowerBoundFn();
    }

    public Cut apply(Range range) {
        return range.lowerBound;
    }
}

