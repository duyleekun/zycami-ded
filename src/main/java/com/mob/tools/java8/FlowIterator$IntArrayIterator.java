/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$PrimitiveArrayIterator;

public class FlowIterator$IntArrayIterator
extends FlowIterator$PrimitiveArrayIterator {
    private int[] array;

    public FlowIterator$IntArrayIterator(int ... nArray) {
        this.array = nArray;
    }

    public Integer element(int n10) {
        return this.array[n10];
    }

    public int length() {
        int n10;
        int[] nArray = this.array;
        if (nArray == null) {
            n10 = 0;
            nArray = null;
        } else {
            n10 = nArray.length;
        }
        return n10;
    }
}

