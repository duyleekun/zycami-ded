/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

public abstract class TransformedIterator
implements Iterator {
    public final Iterator backingIterator;

    public TransformedIterator(Iterator iterator2) {
        this.backingIterator = iterator2 = (Iterator)Preconditions.checkNotNull(iterator2);
    }

    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    public final Object next() {
        Object e10 = this.backingIterator.next();
        return this.transform(e10);
    }

    public final void remove() {
        this.backingIterator.remove();
    }

    public abstract Object transform(Object var1);
}

