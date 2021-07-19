/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

public final class Iterators$1
extends UnmodifiableIterator {
    public final /* synthetic */ Iterator val$iterator;

    public Iterators$1(Iterator iterator2) {
        this.val$iterator = iterator2;
    }

    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Object next() {
        return this.val$iterator.next();
    }
}

