/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator;

public class FlowIterator$ArrayIterator
implements FlowIterator {
    private Object[] array;
    private int index;

    public FlowIterator$ArrayIterator(Object ... objectArray) {
        this.array = objectArray;
    }

    public void finish() {
    }

    public boolean hasNext() {
        int n10;
        int n11;
        Object[] objectArray = this.array;
        if (objectArray != null && (n11 = this.index) < (n10 = objectArray.length)) {
            n10 = 1;
        } else {
            n10 = 0;
            objectArray = null;
        }
        return n10 != 0;
    }

    public Object next() {
        Object object = this.array;
        int n10 = this.index;
        object = object[n10];
        this.index = ++n10;
        return object;
    }
}

