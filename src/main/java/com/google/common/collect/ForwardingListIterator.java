/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingIterator;
import java.util.ListIterator;

public abstract class ForwardingListIterator
extends ForwardingIterator
implements ListIterator {
    public void add(Object object) {
        this.delegate().add(object);
    }

    public abstract ListIterator delegate();

    public boolean hasPrevious() {
        return this.delegate().hasPrevious();
    }

    public int nextIndex() {
        return this.delegate().nextIndex();
    }

    public Object previous() {
        return this.delegate().previous();
    }

    public int previousIndex() {
        return this.delegate().previousIndex();
    }

    public void set(Object object) {
        this.delegate().set(object);
    }
}

