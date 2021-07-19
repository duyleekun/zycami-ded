/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMaker$Dummy;
import com.google.common.collect.MapMakerInternalMap$AbstractStrongKeyEntry;
import com.google.common.collect.MapMakerInternalMap$StrongValueEntry;

public final class MapMakerInternalMap$StrongKeyDummyValueEntry
extends MapMakerInternalMap$AbstractStrongKeyEntry
implements MapMakerInternalMap$StrongValueEntry {
    public MapMakerInternalMap$StrongKeyDummyValueEntry(Object object, int n10, MapMakerInternalMap$StrongKeyDummyValueEntry mapMakerInternalMap$StrongKeyDummyValueEntry) {
        super(object, n10, mapMakerInternalMap$StrongKeyDummyValueEntry);
    }

    public MapMakerInternalMap$StrongKeyDummyValueEntry copy(MapMakerInternalMap$StrongKeyDummyValueEntry mapMakerInternalMap$StrongKeyDummyValueEntry) {
        Object object = this.key;
        int n10 = this.hash;
        MapMakerInternalMap$StrongKeyDummyValueEntry mapMakerInternalMap$StrongKeyDummyValueEntry2 = new MapMakerInternalMap$StrongKeyDummyValueEntry(object, n10, mapMakerInternalMap$StrongKeyDummyValueEntry);
        return mapMakerInternalMap$StrongKeyDummyValueEntry2;
    }

    public MapMaker$Dummy getValue() {
        return MapMaker$Dummy.VALUE;
    }

    public void setValue(MapMaker$Dummy mapMaker$Dummy) {
    }
}

