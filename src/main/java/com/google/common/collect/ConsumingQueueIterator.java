/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class ConsumingQueueIterator
extends AbstractIterator {
    private final Queue queue;

    public ConsumingQueueIterator(Queue queue) {
        this.queue = queue = (Queue)Preconditions.checkNotNull(queue);
    }

    public ConsumingQueueIterator(Object ... objectArray) {
        ArrayDeque arrayDeque;
        int n10 = objectArray.length;
        this.queue = arrayDeque = new ArrayDeque(n10);
        Collections.addAll(arrayDeque, objectArray);
    }

    public Object computeNext() {
        Object object = this.queue;
        boolean bl2 = object.isEmpty();
        object = bl2 ? this.endOfData() : this.queue.remove();
        return object;
    }
}

