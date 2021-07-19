/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapKeySet$KeySetSerializedForm;
import com.google.common.collect.IndexedImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

public final class ImmutableMapKeySet
extends IndexedImmutableSet {
    private final ImmutableMap map;

    public ImmutableMapKeySet(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    public boolean contains(Object object) {
        return this.map.containsKey(object);
    }

    public Object get(int n10) {
        return ((Map.Entry)this.map.entrySet().asList().get(n10)).getKey();
    }

    public boolean isPartialView() {
        return true;
    }

    public UnmodifiableIterator iterator() {
        return this.map.keyIterator();
    }

    public int size() {
        return this.map.size();
    }

    public Object writeReplace() {
        ImmutableMap immutableMap = this.map;
        ImmutableMapKeySet$KeySetSerializedForm immutableMapKeySet$KeySetSerializedForm = new ImmutableMapKeySet$KeySetSerializedForm(immutableMap);
        return immutableMapKeySet$KeySetSerializedForm;
    }
}

