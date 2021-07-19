/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ConsumingQueueIterator;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.Queue;

public final class Iterables$8
extends FluentIterable {
    public final /* synthetic */ Iterable val$iterable;

    public Iterables$8(Iterable iterable) {
        this.val$iterable = iterable;
    }

    public Iterator iterator() {
        Iterator iterator2;
        Object object = this.val$iterable;
        boolean bl2 = object instanceof Queue;
        if (bl2) {
            object = (Queue)object;
            iterator2 = new ConsumingQueueIterator((Queue)object);
        } else {
            object = object.iterator();
            iterator2 = Iterators.consumingIterator((Iterator)object);
        }
        return iterator2;
    }

    public String toString() {
        return "Iterables.consumingIterable(...)";
    }
}

