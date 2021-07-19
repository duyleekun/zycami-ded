/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.PeekingIterator;
import java.util.Iterator;

public class Iterators$PeekingImpl
implements PeekingIterator {
    private boolean hasPeeked;
    private final Iterator iterator;
    private Object peekedElement;

    public Iterators$PeekingImpl(Iterator iterator2) {
        this.iterator = iterator2 = (Iterator)Preconditions.checkNotNull(iterator2);
    }

    public boolean hasNext() {
        Iterator iterator2;
        boolean bl2 = this.hasPeeked;
        if (!bl2 && !(bl2 = (iterator2 = this.iterator).hasNext())) {
            bl2 = false;
            iterator2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object next() {
        boolean bl2 = this.hasPeeked;
        if (!bl2) {
            return this.iterator.next();
        }
        Object object = this.peekedElement;
        this.hasPeeked = false;
        this.peekedElement = null;
        return object;
    }

    public Object peek() {
        boolean bl2 = this.hasPeeked;
        if (!bl2) {
            Object e10 = this.iterator.next();
            this.peekedElement = e10;
            this.hasPeeked = bl2 = true;
        }
        return this.peekedElement;
    }

    public void remove() {
        Preconditions.checkState(this.hasPeeked ^ true, "Can't remove after you've peeked at next");
        this.iterator.remove();
    }
}

