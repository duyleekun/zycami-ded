/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$AbstractStrongKeyEntry;
import com.google.common.collect.MapMakerInternalMap$StrongValueEntry;

public final class MapMakerInternalMap$StrongKeyStrongValueEntry
extends MapMakerInternalMap$AbstractStrongKeyEntry
implements MapMakerInternalMap$StrongValueEntry {
    private volatile Object value = null;

    public MapMakerInternalMap$StrongKeyStrongValueEntry(Object object, int n10, MapMakerInternalMap$StrongKeyStrongValueEntry mapMakerInternalMap$StrongKeyStrongValueEntry) {
        super(object, n10, mapMakerInternalMap$StrongKeyStrongValueEntry);
    }

    public MapMakerInternalMap$StrongKeyStrongValueEntry copy(MapMakerInternalMap$StrongKeyStrongValueEntry object) {
        Object object2 = this.key;
        int n10 = this.hash;
        MapMakerInternalMap$StrongKeyStrongValueEntry mapMakerInternalMap$StrongKeyStrongValueEntry = new MapMakerInternalMap$StrongKeyStrongValueEntry(object2, n10, (MapMakerInternalMap$StrongKeyStrongValueEntry)object);
        mapMakerInternalMap$StrongKeyStrongValueEntry.value = object = this.value;
        return mapMakerInternalMap$StrongKeyStrongValueEntry;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object object) {
        this.value = object;
    }
}

