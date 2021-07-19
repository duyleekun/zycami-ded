/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import java.util.NoSuchElementException;
import java.util.Queue;

public abstract class ForwardingQueue
extends ForwardingCollection
implements Queue {
    public abstract Queue delegate();

    public Object element() {
        return this.delegate().element();
    }

    public boolean offer(Object object) {
        return this.delegate().offer(object);
    }

    public Object peek() {
        return this.delegate().peek();
    }

    public Object poll() {
        return this.delegate().poll();
    }

    public Object remove() {
        return this.delegate().remove();
    }

    public boolean standardOffer(Object object) {
        try {
            return this.add(object);
        }
        catch (IllegalStateException illegalStateException) {
            return false;
        }
    }

    public Object standardPeek() {
        try {
            return this.element();
        }
        catch (NoSuchElementException noSuchElementException) {
            return null;
        }
    }

    public Object standardPoll() {
        try {
            return this.remove();
        }
        catch (NoSuchElementException noSuchElementException) {
            return null;
        }
    }
}

