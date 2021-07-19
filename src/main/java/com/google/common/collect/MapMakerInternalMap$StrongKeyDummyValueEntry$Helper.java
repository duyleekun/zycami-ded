/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMaker$Dummy;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntryHelper;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$StrongKeyDummyValueEntry;
import com.google.common.collect.MapMakerInternalMap$StrongKeyDummyValueSegment;

public final class MapMakerInternalMap$StrongKeyDummyValueEntry$Helper
implements MapMakerInternalMap$InternalEntryHelper {
    private static final MapMakerInternalMap$StrongKeyDummyValueEntry$Helper INSTANCE;

    static {
        MapMakerInternalMap$StrongKeyDummyValueEntry$Helper mapMakerInternalMap$StrongKeyDummyValueEntry$Helper;
        INSTANCE = mapMakerInternalMap$StrongKeyDummyValueEntry$Helper = new MapMakerInternalMap$StrongKeyDummyValueEntry$Helper();
    }

    public static MapMakerInternalMap$StrongKeyDummyValueEntry$Helper instance() {
        return INSTANCE;
    }

    public MapMakerInternalMap$StrongKeyDummyValueEntry copy(MapMakerInternalMap$StrongKeyDummyValueSegment mapMakerInternalMap$StrongKeyDummyValueSegment, MapMakerInternalMap$StrongKeyDummyValueEntry mapMakerInternalMap$StrongKeyDummyValueEntry, MapMakerInternalMap$StrongKeyDummyValueEntry mapMakerInternalMap$StrongKeyDummyValueEntry2) {
        return mapMakerInternalMap$StrongKeyDummyValueEntry.copy(mapMakerInternalMap$StrongKeyDummyValueEntry2);
    }

    public MapMakerInternalMap$Strength keyStrength() {
        return MapMakerInternalMap$Strength.STRONG;
    }

    public MapMakerInternalMap$StrongKeyDummyValueEntry newEntry(MapMakerInternalMap$StrongKeyDummyValueSegment object, Object object2, int n10, MapMakerInternalMap$StrongKeyDummyValueEntry mapMakerInternalMap$StrongKeyDummyValueEntry) {
        object = new MapMakerInternalMap$StrongKeyDummyValueEntry(object2, n10, mapMakerInternalMap$StrongKeyDummyValueEntry);
        return object;
    }

    public MapMakerInternalMap$StrongKeyDummyValueSegment newSegment(MapMakerInternalMap mapMakerInternalMap, int n10, int n11) {
        MapMakerInternalMap$StrongKeyDummyValueSegment mapMakerInternalMap$StrongKeyDummyValueSegment = new MapMakerInternalMap$StrongKeyDummyValueSegment(mapMakerInternalMap, n10, n11);
        return mapMakerInternalMap$StrongKeyDummyValueSegment;
    }

    public void setValue(MapMakerInternalMap$StrongKeyDummyValueSegment mapMakerInternalMap$StrongKeyDummyValueSegment, MapMakerInternalMap$StrongKeyDummyValueEntry mapMakerInternalMap$StrongKeyDummyValueEntry, MapMaker$Dummy mapMaker$Dummy) {
    }

    public MapMakerInternalMap$Strength valueStrength() {
        return MapMakerInternalMap$Strength.STRONG;
    }
}

