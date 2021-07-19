/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$PrimitiveArrayIterator;

public class FlowIterator$DoubleArrayIterator
extends FlowIterator$PrimitiveArrayIterator {
    private double[] array;

    public FlowIterator$DoubleArrayIterator(double ... dArray) {
        this.array = dArray;
    }

    public Double element(int n10) {
        return this.array[n10];
    }

    public int length() {
        int n10;
        double[] dArray = this.array;
        if (dArray == null) {
            n10 = 0;
            dArray = null;
        } else {
            n10 = dArray.length;
        }
        return n10;
    }
}

