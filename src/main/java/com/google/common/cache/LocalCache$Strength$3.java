/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeakValueReference;
import com.google.common.cache.LocalCache$WeightedWeakValueReference;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public final class LocalCache$Strength$3
extends LocalCache$Strength {
    public Equivalence defaultEquivalence() {
        return Equivalence.identity();
    }

    public LocalCache$ValueReference referenceValue(LocalCache$Segment object, ReferenceEntry referenceEntry, Object object2, int n10) {
        LocalCache$WeakValueReference localCache$WeakValueReference;
        int n11 = 1;
        if (n10 == n11) {
            object = ((LocalCache$Segment)object).valueReferenceQueue;
            localCache$WeakValueReference = new LocalCache$WeakValueReference((ReferenceQueue)object, object2, referenceEntry);
        } else {
            object = ((LocalCache$Segment)object).valueReferenceQueue;
            LocalCache$WeightedWeakValueReference localCache$WeightedWeakValueReference = new LocalCache$WeightedWeakValueReference((ReferenceQueue)object, object2, referenceEntry, n10);
            localCache$WeakValueReference = localCache$WeightedWeakValueReference;
        }
        return localCache$WeakValueReference;
    }
}

