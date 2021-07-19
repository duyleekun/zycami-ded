/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$AbstractWeakKeyEntry;
import com.google.common.collect.MapMakerInternalMap$WeakValueEntry;
import com.google.common.collect.MapMakerInternalMap$WeakValueReference;
import com.google.common.collect.MapMakerInternalMap$WeakValueReferenceImpl;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$WeakKeyWeakValueEntry
extends MapMakerInternalMap$AbstractWeakKeyEntry
implements MapMakerInternalMap$WeakValueEntry {
    private volatile MapMakerInternalMap$WeakValueReference valueReference;

    public MapMakerInternalMap$WeakKeyWeakValueEntry(ReferenceQueue object, Object object2, int n10, MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry) {
        super((ReferenceQueue)object, object2, n10, mapMakerInternalMap$WeakKeyWeakValueEntry);
        this.valueReference = object = MapMakerInternalMap.unsetWeakValueReference();
    }

    public static /* synthetic */ MapMakerInternalMap$WeakValueReference access$700(MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry) {
        return mapMakerInternalMap$WeakKeyWeakValueEntry.valueReference;
    }

    public static /* synthetic */ MapMakerInternalMap$WeakValueReference access$702(MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry, MapMakerInternalMap$WeakValueReference mapMakerInternalMap$WeakValueReference) {
        mapMakerInternalMap$WeakKeyWeakValueEntry.valueReference = mapMakerInternalMap$WeakValueReference;
        return mapMakerInternalMap$WeakValueReference;
    }

    public void clearValue() {
        this.valueReference.clear();
    }

    public MapMakerInternalMap$WeakKeyWeakValueEntry copy(ReferenceQueue object, ReferenceQueue referenceQueue, MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry) {
        Object object2 = this.getKey();
        int n10 = this.hash;
        MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry2 = new MapMakerInternalMap$WeakKeyWeakValueEntry((ReferenceQueue)object, object2, n10, mapMakerInternalMap$WeakKeyWeakValueEntry);
        mapMakerInternalMap$WeakKeyWeakValueEntry2.valueReference = object = this.valueReference.copyFor(referenceQueue, mapMakerInternalMap$WeakKeyWeakValueEntry2);
        return mapMakerInternalMap$WeakKeyWeakValueEntry2;
    }

    public Object getValue() {
        return this.valueReference.get();
    }

    public MapMakerInternalMap$WeakValueReference getValueReference() {
        return this.valueReference;
    }

    public void setValue(Object object, ReferenceQueue referenceQueue) {
        MapMakerInternalMap$WeakValueReference mapMakerInternalMap$WeakValueReference = this.valueReference;
        MapMakerInternalMap$WeakValueReferenceImpl mapMakerInternalMap$WeakValueReferenceImpl = new MapMakerInternalMap$WeakValueReferenceImpl(referenceQueue, object, this);
        this.valueReference = mapMakerInternalMap$WeakValueReferenceImpl;
        mapMakerInternalMap$WeakValueReference.clear();
    }
}

