/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.LocalCache$StrongValueReference;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeightedStrongValueReference;
import com.google.common.cache.ReferenceEntry;

public final class LocalCache$Strength$1
extends LocalCache$Strength {
    public Equivalence defaultEquivalence() {
        return Equivalence.equals();
    }

    public LocalCache$ValueReference referenceValue(LocalCache$Segment object, ReferenceEntry referenceEntry, Object object2, int n10) {
        int n11 = 1;
        object = n10 == n11 ? new LocalCache$StrongValueReference(object2) : new LocalCache$WeightedStrongValueReference(object2, n10);
        return object;
    }
}

