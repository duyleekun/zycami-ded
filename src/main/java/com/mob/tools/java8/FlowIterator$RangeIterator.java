/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator;

public abstract class FlowIterator$RangeIterator
implements FlowIterator {
    private Comparable position;
    private Comparable step;
    private Comparable toExclude;

    public FlowIterator$RangeIterator(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        this.toExclude = comparable2;
        this.step = comparable3;
        this.position = comparable;
    }

    public void finish() {
    }

    public boolean hasNext() {
        Comparable comparable = this.position;
        Comparable comparable2 = this.toExclude;
        int n10 = comparable.compareTo(comparable2);
        if (n10 < 0) {
            n10 = 1;
        } else {
            n10 = 0;
            comparable = null;
        }
        return n10 != 0;
    }

    public abstract Comparable increase(Comparable var1, Comparable var2);

    public Comparable next() {
        Comparable comparable = this.position;
        Comparable comparable2 = this.step;
        this.position = comparable2 = this.increase(comparable, comparable2);
        return comparable;
    }
}

