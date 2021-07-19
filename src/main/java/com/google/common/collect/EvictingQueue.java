/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingQueue;
import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public final class EvictingQueue
extends ForwardingQueue
implements Serializable {
    private static final long serialVersionUID;
    private final Queue delegate;
    public final int maxSize;

    private EvictingQueue(int n10) {
        ArrayDeque arrayDeque;
        boolean bl2;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            arrayDeque = null;
        }
        Preconditions.checkArgument(bl2, "maxSize (%s) must >= 0", n10);
        this.delegate = arrayDeque = new ArrayDeque(n10);
        this.maxSize = n10;
    }

    public static EvictingQueue create(int n10) {
        EvictingQueue evictingQueue = new EvictingQueue(n10);
        return evictingQueue;
    }

    public boolean add(Object object) {
        int n10;
        Preconditions.checkNotNull(object);
        int n11 = this.maxSize;
        boolean bl2 = true;
        if (n11 == 0) {
            return bl2;
        }
        n11 = this.size();
        if (n11 == (n10 = this.maxSize)) {
            Queue queue = this.delegate;
            queue.remove();
        }
        this.delegate.add(object);
        return bl2;
    }

    public boolean addAll(Collection iterable) {
        int n10;
        int n11 = iterable.size();
        if (n11 >= (n10 = this.maxSize)) {
            this.clear();
            n10 = this.maxSize;
            iterable = Iterables.skip(iterable, n11 -= n10);
            return Iterables.addAll(this, iterable);
        }
        return this.standardAddAll((Collection)iterable);
    }

    public boolean contains(Object object) {
        Object object2 = this.delegate();
        object = Preconditions.checkNotNull(object);
        return object2.contains(object);
    }

    public Queue delegate() {
        return this.delegate;
    }

    public boolean offer(Object object) {
        return this.add(object);
    }

    public int remainingCapacity() {
        int n10 = this.maxSize;
        int n11 = this.size();
        return n10 - n11;
    }

    public boolean remove(Object object) {
        Object object2 = this.delegate();
        object = Preconditions.checkNotNull(object);
        return object2.remove(object);
    }
}

