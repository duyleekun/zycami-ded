/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$StrongValueReference;

public final class LocalCache$WeightedStrongValueReference
extends LocalCache$StrongValueReference {
    public final int weight;

    public LocalCache$WeightedStrongValueReference(Object object, int n10) {
        super(object);
        this.weight = n10;
    }

    public int getWeight() {
        return this.weight;
    }
}

