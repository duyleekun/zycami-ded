/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;

public abstract class MapMakerInternalMap$AbstractStrongKeyEntry
implements MapMakerInternalMap$InternalEntry {
    public final int hash;
    public final Object key;
    public final MapMakerInternalMap$InternalEntry next;

    public MapMakerInternalMap$AbstractStrongKeyEntry(Object object, int n10, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        this.key = object;
        this.hash = n10;
        this.next = mapMakerInternalMap$InternalEntry;
    }

    public int getHash() {
        return this.hash;
    }

    public Object getKey() {
        return this.key;
    }

    public MapMakerInternalMap$InternalEntry getNext() {
        return this.next;
    }
}

