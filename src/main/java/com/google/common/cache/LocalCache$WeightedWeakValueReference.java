/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeakValueReference;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public final class LocalCache$WeightedWeakValueReference
extends LocalCache$WeakValueReference {
    public final int weight;

    public LocalCache$WeightedWeakValueReference(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry, int n10) {
        super(referenceQueue, object, referenceEntry);
        this.weight = n10;
    }

    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry) {
        int n10 = this.weight;
        LocalCache$WeightedWeakValueReference localCache$WeightedWeakValueReference = new LocalCache$WeightedWeakValueReference(referenceQueue, object, referenceEntry, n10);
        return localCache$WeightedWeakValueReference;
    }

    public int getWeight() {
        return this.weight;
    }
}

