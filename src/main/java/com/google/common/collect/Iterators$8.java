/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

public final class Iterators$8
extends UnmodifiableIterator {
    public final /* synthetic */ Iterator val$iterator;

    public Iterators$8(Iterator iterator2) {
        this.val$iterator = iterator2;
    }

    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Object next() {
        Object e10 = this.val$iterator.next();
        this.val$iterator.remove();
        return e10;
    }

    public String toString() {
        return "Iterators.consumingIterator(...)";
    }
}

