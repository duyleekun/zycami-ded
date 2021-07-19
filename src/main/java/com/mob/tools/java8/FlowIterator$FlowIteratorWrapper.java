/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator;

public abstract class FlowIterator$FlowIteratorWrapper
implements FlowIterator {
    private FlowIterator it;

    private FlowIterator getIterator() {
        FlowIterator flowIterator = this.it;
        if (flowIterator == null) {
            this.it = flowIterator = this.initIterator();
        }
        return this.it;
    }

    public void finish() {
    }

    public boolean hasNext() {
        return this.getIterator().hasNext();
    }

    public abstract FlowIterator initIterator();

    public Object next() {
        return this.getIterator().next();
    }
}

