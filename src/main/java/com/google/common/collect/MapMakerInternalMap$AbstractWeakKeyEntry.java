/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class MapMakerInternalMap$AbstractWeakKeyEntry
extends WeakReference
implements MapMakerInternalMap$InternalEntry {
    public final int hash;
    public final MapMakerInternalMap$InternalEntry next;

    public MapMakerInternalMap$AbstractWeakKeyEntry(ReferenceQueue referenceQueue, Object object, int n10, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        super(object, referenceQueue);
        this.hash = n10;
        this.next = mapMakerInternalMap$InternalEntry;
    }

    public int getHash() {
        return this.hash;
    }

    public Object getKey() {
        return this.get();
    }

    public MapMakerInternalMap$InternalEntry getNext() {
        return this.next;
    }
}

