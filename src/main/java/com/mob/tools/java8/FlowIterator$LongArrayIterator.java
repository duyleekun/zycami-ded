/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$PrimitiveArrayIterator;

public class FlowIterator$LongArrayIterator
extends FlowIterator$PrimitiveArrayIterator {
    private long[] array;

    public FlowIterator$LongArrayIterator(long ... lArray) {
        this.array = lArray;
    }

    public Long element(int n10) {
        return this.array[n10];
    }

    public int length() {
        int n10;
        long[] lArray = this.array;
        if (lArray == null) {
            n10 = 0;
            lArray = null;
        } else {
            n10 = lArray.length;
        }
        return n10;
    }
}

