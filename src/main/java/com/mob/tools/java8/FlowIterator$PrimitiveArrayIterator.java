/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator;

public abstract class FlowIterator$PrimitiveArrayIterator
implements FlowIterator {
    private int index;

    public abstract Object element(int var1);

    public void finish() {
    }

    public boolean hasNext() {
        int n10 = this.index;
        int n11 = this.length();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public abstract int length();

    public Object next() {
        int n10;
        int n11 = this.index;
        Object object = this.element(n11);
        this.index = n10 = this.index + 1;
        return object;
    }
}

