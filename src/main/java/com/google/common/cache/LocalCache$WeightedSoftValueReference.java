/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$SoftValueReference;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public final class LocalCache$WeightedSoftValueReference
extends LocalCache$SoftValueReference {
    public final int weight;

    public LocalCache$WeightedSoftValueReference(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry, int n10) {
        super(referenceQueue, object, referenceEntry);
        this.weight = n10;
    }

    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry) {
        int n10 = this.weight;
        LocalCache$WeightedSoftValueReference localCache$WeightedSoftValueReference = new LocalCache$WeightedSoftValueReference(referenceQueue, object, referenceEntry, n10);
        return localCache$WeightedSoftValueReference;
    }

    public int getWeight() {
        return this.weight;
    }
}

