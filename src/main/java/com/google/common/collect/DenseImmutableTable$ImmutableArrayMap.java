/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap$1;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

public abstract class DenseImmutableTable$ImmutableArrayMap
extends ImmutableMap$IteratorBasedImmutableMap {
    private final int size;

    public DenseImmutableTable$ImmutableArrayMap(int n10) {
        this.size = n10;
    }

    private boolean isFull() {
        int n10 = this.size;
        ImmutableMap immutableMap = this.keyToIndex();
        int n11 = immutableMap.size();
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public ImmutableSet createKeySet() {
        boolean bl2 = this.isFull();
        ImmutableSet immutableSet = bl2 ? this.keyToIndex().keySet() : super.createKeySet();
        return immutableSet;
    }

    public UnmodifiableIterator entryIterator() {
        DenseImmutableTable$ImmutableArrayMap$1 denseImmutableTable$ImmutableArrayMap$1 = new DenseImmutableTable$ImmutableArrayMap$1(this);
        return denseImmutableTable$ImmutableArrayMap$1;
    }

    public Object get(Object object) {
        ImmutableMap immutableMap = this.keyToIndex();
        object = (Integer)immutableMap.get(object);
        if (object == null) {
            boolean bl2 = false;
            object = null;
        } else {
            int n10 = (Integer)object;
            object = this.getValue(n10);
        }
        return object;
    }

    public Object getKey(int n10) {
        return this.keyToIndex().keySet().asList().get(n10);
    }

    public abstract Object getValue(int var1);

    public abstract ImmutableMap keyToIndex();

    public int size() {
        return this.size;
    }
}

