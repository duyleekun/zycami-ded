/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$WeakValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class MapMakerInternalMap$WeakValueReferenceImpl
extends WeakReference
implements MapMakerInternalMap$WeakValueReference {
    public final MapMakerInternalMap$InternalEntry entry;

    public MapMakerInternalMap$WeakValueReferenceImpl(ReferenceQueue referenceQueue, Object object, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        super(object, referenceQueue);
        this.entry = mapMakerInternalMap$InternalEntry;
    }

    public MapMakerInternalMap$WeakValueReference copyFor(ReferenceQueue referenceQueue, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        Object t10 = this.get();
        MapMakerInternalMap$WeakValueReferenceImpl mapMakerInternalMap$WeakValueReferenceImpl = new MapMakerInternalMap$WeakValueReferenceImpl(referenceQueue, t10, mapMakerInternalMap$InternalEntry);
        return mapMakerInternalMap$WeakValueReferenceImpl;
    }

    public MapMakerInternalMap$InternalEntry getEntry() {
        return this.entry;
    }
}

