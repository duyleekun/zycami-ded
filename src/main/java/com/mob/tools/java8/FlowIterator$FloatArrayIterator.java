/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$PrimitiveArrayIterator;

public class FlowIterator$FloatArrayIterator
extends FlowIterator$PrimitiveArrayIterator {
    private float[] array;

    public FlowIterator$FloatArrayIterator(float ... fArray) {
        this.array = fArray;
    }

    public Float element(int n10) {
        return Float.valueOf(this.array[n10]);
    }

    public int length() {
        int n10;
        float[] fArray = this.array;
        if (fArray == null) {
            n10 = 0;
            fArray = null;
        } else {
            n10 = fArray.length;
        }
        return n10;
    }
}

