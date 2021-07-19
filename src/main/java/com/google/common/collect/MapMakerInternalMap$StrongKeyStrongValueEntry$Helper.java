/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntryHelper;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$StrongKeyStrongValueEntry;
import com.google.common.collect.MapMakerInternalMap$StrongKeyStrongValueSegment;

public final class MapMakerInternalMap$StrongKeyStrongValueEntry$Helper
implements MapMakerInternalMap$InternalEntryHelper {
    private static final MapMakerInternalMap$StrongKeyStrongValueEntry$Helper INSTANCE;

    static {
        MapMakerInternalMap$StrongKeyStrongValueEntry$Helper mapMakerInternalMap$StrongKeyStrongValueEntry$Helper;
        INSTANCE = mapMakerInternalMap$StrongKeyStrongValueEntry$Helper = new MapMakerInternalMap$StrongKeyStrongValueEntry$Helper();
    }

    public static MapMakerInternalMap$StrongKeyStrongValueEntry$Helper instance() {
        return INSTANCE;
    }

    public MapMakerInternalMap$StrongKeyStrongValueEntry copy(MapMakerInternalMap$StrongKeyStrongValueSegment mapMakerInternalMap$StrongKeyStrongValueSegment, MapMakerInternalMap$StrongKeyStrongValueEntry mapMakerInternalMap$StrongKeyStrongValueEntry, MapMakerInternalMap$StrongKeyStrongValueEntry mapMakerInternalMap$StrongKeyStrongValueEntry2) {
        return mapMakerInternalMap$StrongKeyStrongValueEntry.copy(mapMakerInternalMap$StrongKeyStrongValueEntry2);
    }

    public MapMakerInternalMap$Strength keyStrength() {
        return MapMakerInternalMap$Strength.STRONG;
    }

    public MapMakerInternalMap$StrongKeyStrongValueEntry newEntry(MapMakerInternalMap$StrongKeyStrongValueSegment object, Object object2, int n10, MapMakerInternalMap$StrongKeyStrongValueEntry mapMakerInternalMap$StrongKeyStrongValueEntry) {
        object = new MapMakerInternalMap$StrongKeyStrongValueEntry(object2, n10, mapMakerInternalMap$StrongKeyStrongValueEntry);
        return object;
    }

    public MapMakerInternalMap$StrongKeyStrongValueSegment newSegment(MapMakerInternalMap mapMakerInternalMap, int n10, int n11) {
        MapMakerInternalMap$StrongKeyStrongValueSegment mapMakerInternalMap$StrongKeyStrongValueSegment = new MapMakerInternalMap$StrongKeyStrongValueSegment(mapMakerInternalMap, n10, n11);
        return mapMakerInternalMap$StrongKeyStrongValueSegment;
    }

    public void setValue(MapMakerInternalMap$StrongKeyStrongValueSegment mapMakerInternalMap$StrongKeyStrongValueSegment, MapMakerInternalMap$StrongKeyStrongValueEntry mapMakerInternalMap$StrongKeyStrongValueEntry, Object object) {
        mapMakerInternalMap$StrongKeyStrongValueEntry.setValue(object);
    }

    public MapMakerInternalMap$Strength valueStrength() {
        return MapMakerInternalMap$Strength.STRONG;
    }
}

