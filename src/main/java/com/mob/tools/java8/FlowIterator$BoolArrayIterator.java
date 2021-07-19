/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$PrimitiveArrayIterator;

public class FlowIterator$BoolArrayIterator
extends FlowIterator$PrimitiveArrayIterator {
    private boolean[] array;

    public FlowIterator$BoolArrayIterator(boolean ... blArray) {
        this.array = blArray;
    }

    public Boolean element(int n10) {
        return this.array[n10];
    }

    public int length() {
        int n10;
        boolean[] blArray = this.array;
        if (blArray == null) {
            n10 = 0;
            blArray = null;
        } else {
            n10 = blArray.length;
        }
        return n10;
    }
}

