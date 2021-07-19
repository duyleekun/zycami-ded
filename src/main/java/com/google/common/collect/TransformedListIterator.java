/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.TransformedIterator;
import java.util.ListIterator;

public abstract class TransformedListIterator
extends TransformedIterator
implements ListIterator {
    public TransformedListIterator(ListIterator listIterator) {
        super(listIterator);
    }

    private ListIterator backingIterator() {
        return Iterators.cast(this.backingIterator);
    }

    public void add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean hasPrevious() {
        return this.backingIterator().hasPrevious();
    }

    public final int nextIndex() {
        return this.backingIterator().nextIndex();
    }

    public final Object previous() {
        Object e10 = this.backingIterator().previous();
        return this.transform(e10);
    }

    public final int previousIndex() {
        return this.backingIterator().previousIndex();
    }

    public void set(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

