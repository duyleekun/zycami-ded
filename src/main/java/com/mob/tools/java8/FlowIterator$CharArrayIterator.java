/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator$PrimitiveArrayIterator;

public class FlowIterator$CharArrayIterator
extends FlowIterator$PrimitiveArrayIterator {
    private char[] array;

    public FlowIterator$CharArrayIterator(char ... cArray) {
        this.array = cArray;
    }

    public Character element(int n10) {
        return Character.valueOf(this.array[n10]);
    }

    public int length() {
        int n10;
        char[] cArray = this.array;
        if (cArray == null) {
            n10 = 0;
            cArray = null;
        } else {
            n10 = cArray.length;
        }
        return n10;
    }
}

