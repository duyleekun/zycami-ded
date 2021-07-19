/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$PrimitiveArrayIterator;

public class FlowIterator$ShortArrayIterator
extends FlowIterator$PrimitiveArrayIterator {
    private short[] array;

    public FlowIterator$ShortArrayIterator(short ... sArray) {
        this.array = sArray;
    }

    public Short element(int n10) {
        return this.array[n10];
    }

    public int length() {
        int n10;
        short[] sArray = this.array;
        if (sArray == null) {
            n10 = 0;
            sArray = null;
        } else {
            n10 = sArray.length;
        }
        return n10;
    }
}

