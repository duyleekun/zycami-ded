/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;
import com.google.common.util.concurrent.Striped$SmallLazyStriped$ArrayReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Striped$SmallLazyStriped
extends Striped$PowerOfTwoStriped {
    public final AtomicReferenceArray locks;
    public final ReferenceQueue queue;
    public final int size;
    public final Supplier supplier;

    public Striped$SmallLazyStriped(int n10, Supplier supplier) {
        super(n10);
        AtomicReferenceArray atomicReferenceArray;
        ReferenceQueue referenceQueue;
        this.queue = referenceQueue = new ReferenceQueue();
        n10 = this.mask;
        int n11 = -1;
        n10 = n10 == n11 ? -1 >>> 1 : ++n10;
        this.size = n10;
        this.locks = atomicReferenceArray = new AtomicReferenceArray(n10);
        this.supplier = supplier;
    }

    private void drainQueue() {
        Striped$SmallLazyStriped$ArrayReference striped$SmallLazyStriped$ArrayReference;
        while ((striped$SmallLazyStriped$ArrayReference = this.queue.poll()) != null) {
            striped$SmallLazyStriped$ArrayReference = striped$SmallLazyStriped$ArrayReference;
            AtomicReferenceArray atomicReferenceArray = this.locks;
            int n10 = striped$SmallLazyStriped$ArrayReference.index;
            atomicReferenceArray.compareAndSet(n10, striped$SmallLazyStriped$ArrayReference, null);
        }
    }

    public Object getAt(int n10) {
        int n11 = this.size;
        int n12 = -1 >>> 1;
        if (n11 != n12) {
            n11 = this.size();
            Preconditions.checkElementIndex(n10, n11);
        }
        Striped$SmallLazyStriped$ArrayReference striped$SmallLazyStriped$ArrayReference = (Striped$SmallLazyStriped$ArrayReference)this.locks.get(n10);
        n12 = 0;
        Object object = striped$SmallLazyStriped$ArrayReference == null ? null : (Object)striped$SmallLazyStriped$ArrayReference.get();
        if (object != null) {
            return object;
        }
        object = this.supplier.get();
        Object object2 = this.queue;
        Striped$SmallLazyStriped$ArrayReference striped$SmallLazyStriped$ArrayReference2 = new Striped$SmallLazyStriped$ArrayReference(object, n10, (ReferenceQueue)object2);
        while ((n11 = (int)(((AtomicReferenceArray)(object2 = this.locks)).compareAndSet(n10, striped$SmallLazyStriped$ArrayReference, striped$SmallLazyStriped$ArrayReference2) ? 1 : 0)) == 0) {
            striped$SmallLazyStriped$ArrayReference = (Striped$SmallLazyStriped$ArrayReference)this.locks.get(n10);
            object2 = striped$SmallLazyStriped$ArrayReference == null ? null : striped$SmallLazyStriped$ArrayReference.get();
            if (object2 == null) continue;
            return object2;
        }
        this.drainQueue();
        return object;
    }

    public int size() {
        return this.size;
    }
}

