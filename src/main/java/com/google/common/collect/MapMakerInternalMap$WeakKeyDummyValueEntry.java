/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMaker$Dummy;
import com.google.common.collect.MapMakerInternalMap$AbstractWeakKeyEntry;
import com.google.common.collect.MapMakerInternalMap$StrongValueEntry;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$WeakKeyDummyValueEntry
extends MapMakerInternalMap$AbstractWeakKeyEntry
implements MapMakerInternalMap$StrongValueEntry {
    public MapMakerInternalMap$WeakKeyDummyValueEntry(ReferenceQueue referenceQueue, Object object, int n10, MapMakerInternalMap$WeakKeyDummyValueEntry mapMakerInternalMap$WeakKeyDummyValueEntry) {
        super(referenceQueue, object, n10, mapMakerInternalMap$WeakKeyDummyValueEntry);
    }

    public MapMakerInternalMap$WeakKeyDummyValueEntry copy(ReferenceQueue referenceQueue, MapMakerInternalMap$WeakKeyDummyValueEntry mapMakerInternalMap$WeakKeyDummyValueEntry) {
        Object object = this.getKey();
        int n10 = this.hash;
        MapMakerInternalMap$WeakKeyDummyValueEntry mapMakerInternalMap$WeakKeyDummyValueEntry2 = new MapMakerInternalMap$WeakKeyDummyValueEntry(referenceQueue, object, n10, mapMakerInternalMap$WeakKeyDummyValueEntry);
        return mapMakerInternalMap$WeakKeyDummyValueEntry2;
    }

    public MapMaker$Dummy getValue() {
        return MapMaker$Dummy.VALUE;
    }

    public void setValue(MapMaker$Dummy mapMaker$Dummy) {
    }
}

