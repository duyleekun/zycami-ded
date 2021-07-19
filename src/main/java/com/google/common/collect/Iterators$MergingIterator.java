/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Iterators$MergingIterator$1;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Iterators$MergingIterator
extends UnmodifiableIterator {
    public final Queue queue;

    public Iterators$MergingIterator(Iterable object, Comparator object2) {
        boolean bl2;
        Object object3 = new Iterators$MergingIterator$1(this, (Comparator)object2);
        int n10 = 2;
        object2 = new PriorityQueue(n10, object3);
        this.queue = object2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Iterator)object.next();
            boolean bl3 = object2.hasNext();
            if (!bl3) continue;
            object3 = this.queue;
            object2 = Iterators.peekingIterator((Iterator)object2);
            object3.add(object2);
        }
    }

    public boolean hasNext() {
        return this.queue.isEmpty() ^ true;
    }

    public Object next() {
        PeekingIterator peekingIterator = (PeekingIterator)this.queue.remove();
        Object object = peekingIterator.next();
        boolean bl2 = peekingIterator.hasNext();
        if (bl2) {
            Queue queue = this.queue;
            queue.add(peekingIterator);
        }
        return object;
    }
}

