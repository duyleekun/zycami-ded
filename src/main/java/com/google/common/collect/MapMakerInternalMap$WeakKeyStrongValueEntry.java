/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$AbstractWeakKeyEntry;
import com.google.common.collect.MapMakerInternalMap$StrongValueEntry;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$WeakKeyStrongValueEntry
extends MapMakerInternalMap$AbstractWeakKeyEntry
implements MapMakerInternalMap$StrongValueEntry {
    private volatile Object value = null;

    public MapMakerInternalMap$WeakKeyStrongValueEntry(ReferenceQueue referenceQueue, Object object, int n10, MapMakerInternalMap$WeakKeyStrongValueEntry mapMakerInternalMap$WeakKeyStrongValueEntry) {
        super(referenceQueue, object, n10, mapMakerInternalMap$WeakKeyStrongValueEntry);
    }

    public MapMakerInternalMap$WeakKeyStrongValueEntry copy(ReferenceQueue object, MapMakerInternalMap$WeakKeyStrongValueEntry mapMakerInternalMap$WeakKeyStrongValueEntry) {
        Object object2 = this.getKey();
        int n10 = this.hash;
        MapMakerInternalMap$WeakKeyStrongValueEntry mapMakerInternalMap$WeakKeyStrongValueEntry2 = new MapMakerInternalMap$WeakKeyStrongValueEntry((ReferenceQueue)object, object2, n10, mapMakerInternalMap$WeakKeyStrongValueEntry);
        object = this.value;
        mapMakerInternalMap$WeakKeyStrongValueEntry2.setValue(object);
        return mapMakerInternalMap$WeakKeyStrongValueEntry2;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object object) {
        this.value = object;
    }
}

