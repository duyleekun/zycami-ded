/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator;
import java.util.Enumeration;

public class FlowIterator$EnumerationIterator
implements FlowIterator {
    private Enumeration enumeration;

    public FlowIterator$EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    public void finish() {
    }

    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    public Object next() {
        return this.enumeration.nextElement();
    }
}

