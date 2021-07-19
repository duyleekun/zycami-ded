/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.w0.b.a;
import io.reactivex.internal.operators.maybe.MaybeMergeArray$a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class MaybeMergeArray$MpscFillOnceSimpleQueue
extends AtomicReferenceArray
implements MaybeMergeArray$a {
    private static final long serialVersionUID = -7969063454040569579L;
    public int consumerIndex;
    public final AtomicInteger producerIndex;

    public MaybeMergeArray$MpscFillOnceSimpleQueue(int n10) {
        super(n10);
        AtomicInteger atomicInteger;
        this.producerIndex = atomicInteger = new AtomicInteger();
    }

    public void clear() {
        boolean bl2;
        Object object;
        while ((object = this.poll()) != null && !(bl2 = this.isEmpty())) {
        }
    }

    public int consumerIndex() {
        return this.consumerIndex;
    }

    public void drop() {
        int n10 = this.consumerIndex;
        this.lazySet(n10, null);
        this.consumerIndex = ++n10;
    }

    public boolean isEmpty() {
        int n10 = this.consumerIndex;
        int n11 = this.producerIndex();
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean offer(Object object) {
        a.g(object, "value is null");
        AtomicInteger atomicInteger = this.producerIndex;
        int n10 = atomicInteger.getAndIncrement();
        int n11 = this.length();
        if (n10 < n11) {
            this.lazySet(n10, object);
            return true;
        }
        return false;
    }

    public boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Object peek() {
        int n10 = this.consumerIndex;
        int n11 = this.length();
        if (n10 == n11) {
            return null;
        }
        return this.get(n10);
    }

    public Object poll() {
        int n10;
        int n11 = this.consumerIndex;
        int n12 = this.length();
        if (n11 == n12) {
            return null;
        }
        AtomicInteger atomicInteger = this.producerIndex;
        do {
            Object e10;
            if ((e10 = this.get(n11)) == null) continue;
            this.consumerIndex = n12 = n11 + 1;
            this.lazySet(n11, null);
            return e10;
        } while ((n10 = atomicInteger.get()) != n11);
        return null;
    }

    public int producerIndex() {
        return this.producerIndex.get();
    }
}

