/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator;
import java.util.Iterator;

public class FlowIterator$IterableIterator
implements FlowIterator {
    private Iterator it;

    public FlowIterator$IterableIterator(Iterable object) {
        this.it = object = object.iterator();
    }

    public void finish() {
    }

    public boolean hasNext() {
        return this.it.hasNext();
    }

    public Object next() {
        return this.it.next();
    }
}

