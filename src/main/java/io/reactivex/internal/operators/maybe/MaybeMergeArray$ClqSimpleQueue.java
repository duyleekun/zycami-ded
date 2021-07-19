/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.operators.maybe.MaybeMergeArray$a;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class MaybeMergeArray$ClqSimpleQueue
extends ConcurrentLinkedQueue
implements MaybeMergeArray$a {
    private static final long serialVersionUID = -4025173261791142821L;
    public int consumerIndex;
    public final AtomicInteger producerIndex;

    public MaybeMergeArray$ClqSimpleQueue() {
        AtomicInteger atomicInteger;
        this.producerIndex = atomicInteger = new AtomicInteger();
    }

    public int consumerIndex() {
        return this.consumerIndex;
    }

    public void drop() {
        this.poll();
    }

    public boolean offer(Object object) {
        this.producerIndex.getAndIncrement();
        return super.offer(object);
    }

    public boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Object poll() {
        Object e10 = super.poll();
        if (e10 != null) {
            int n10;
            this.consumerIndex = n10 = this.consumerIndex + 1;
        }
        return e10;
    }

    public int producerIndex() {
        return this.producerIndex.get();
    }
}

