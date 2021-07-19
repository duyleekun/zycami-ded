/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$PrimitiveArrayIterator;

public class FlowIterator$ByteArrayIterator
extends FlowIterator$PrimitiveArrayIterator {
    private byte[] array;

    public FlowIterator$ByteArrayIterator(byte ... byArray) {
        this.array = byArray;
    }

    public Byte element(int n10) {
        return this.array[n10];
    }

    public int length() {
        int n10;
        byte[] byArray = this.array;
        if (byArray == null) {
            n10 = 0;
            byArray = null;
        } else {
            n10 = byArray.length;
        }
        return n10;
    }
}

