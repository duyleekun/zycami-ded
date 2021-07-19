/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Comparator;
import java.util.Map;

public final class ImmutableBiMap$Builder
extends ImmutableMap$Builder {
    public ImmutableBiMap$Builder() {
    }

    public ImmutableBiMap$Builder(int n10) {
        super(n10);
    }

    public ImmutableBiMap build() {
        int n10 = this.size;
        if (n10 == 0) {
            return ImmutableBiMap.of();
        }
        this.sortEntries();
        this.entriesUsed = true;
        Object[] objectArray = this.alternatingKeysAndValues;
        int n11 = this.size;
        RegularImmutableBiMap regularImmutableBiMap = new RegularImmutableBiMap(objectArray, n11);
        return regularImmutableBiMap;
    }

    public ImmutableBiMap$Builder orderEntriesByValue(Comparator comparator) {
        super.orderEntriesByValue(comparator);
        return this;
    }

    public ImmutableBiMap$Builder put(Object object, Object object2) {
        super.put(object, object2);
        return this;
    }

    public ImmutableBiMap$Builder put(Map.Entry entry) {
        super.put(entry);
        return this;
    }

    public ImmutableBiMap$Builder putAll(Iterable iterable) {
        super.putAll(iterable);
        return this;
    }

    public ImmutableBiMap$Builder putAll(Map map) {
        super.putAll(map);
        return this;
    }
}

