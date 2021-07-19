/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$AbstractStrongKeyEntry;
import com.google.common.collect.MapMakerInternalMap$WeakValueEntry;
import com.google.common.collect.MapMakerInternalMap$WeakValueReference;
import com.google.common.collect.MapMakerInternalMap$WeakValueReferenceImpl;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$StrongKeyWeakValueEntry
extends MapMakerInternalMap$AbstractStrongKeyEntry
implements MapMakerInternalMap$WeakValueEntry {
    private volatile MapMakerInternalMap$WeakValueReference valueReference;

    public MapMakerInternalMap$StrongKeyWeakValueEntry(Object object, int n10, MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry) {
        super(object, n10, mapMakerInternalMap$StrongKeyWeakValueEntry);
        this.valueReference = object = MapMakerInternalMap.unsetWeakValueReference();
    }

    public static /* synthetic */ MapMakerInternalMap$WeakValueReference access$600(MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry) {
        return mapMakerInternalMap$StrongKeyWeakValueEntry.valueReference;
    }

    public static /* synthetic */ MapMakerInternalMap$WeakValueReference access$602(MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry, MapMakerInternalMap$WeakValueReference mapMakerInternalMap$WeakValueReference) {
        mapMakerInternalMap$StrongKeyWeakValueEntry.valueReference = mapMakerInternalMap$WeakValueReference;
        return mapMakerInternalMap$WeakValueReference;
    }

    public void clearValue() {
        this.valueReference.clear();
    }

    public MapMakerInternalMap$StrongKeyWeakValueEntry copy(ReferenceQueue object, MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry) {
        Object object2 = this.key;
        int n10 = this.hash;
        MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry2 = new MapMakerInternalMap$StrongKeyWeakValueEntry(object2, n10, mapMakerInternalMap$StrongKeyWeakValueEntry);
        mapMakerInternalMap$StrongKeyWeakValueEntry2.valueReference = object = this.valueReference.copyFor((ReferenceQueue)object, mapMakerInternalMap$StrongKeyWeakValueEntry2);
        return mapMakerInternalMap$StrongKeyWeakValueEntry2;
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

