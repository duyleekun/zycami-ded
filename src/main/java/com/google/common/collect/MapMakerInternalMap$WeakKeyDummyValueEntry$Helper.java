/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMaker$Dummy;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntryHelper;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$WeakKeyDummyValueEntry;
import com.google.common.collect.MapMakerInternalMap$WeakKeyDummyValueSegment;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$WeakKeyDummyValueEntry$Helper
implements MapMakerInternalMap$InternalEntryHelper {
    private static final MapMakerInternalMap$WeakKeyDummyValueEntry$Helper INSTANCE;

    static {
        MapMakerInternalMap$WeakKeyDummyValueEntry$Helper mapMakerInternalMap$WeakKeyDummyValueEntry$Helper;
        INSTANCE = mapMakerInternalMap$WeakKeyDummyValueEntry$Helper = new MapMakerInternalMap$WeakKeyDummyValueEntry$Helper();
    }

    public static MapMakerInternalMap$WeakKeyDummyValueEntry$Helper instance() {
        return INSTANCE;
    }

    public MapMakerInternalMap$WeakKeyDummyValueEntry copy(MapMakerInternalMap$WeakKeyDummyValueSegment object, MapMakerInternalMap$WeakKeyDummyValueEntry mapMakerInternalMap$WeakKeyDummyValueEntry, MapMakerInternalMap$WeakKeyDummyValueEntry mapMakerInternalMap$WeakKeyDummyValueEntry2) {
        Object object2 = mapMakerInternalMap$WeakKeyDummyValueEntry.getKey();
        if (object2 == null) {
            return null;
        }
        object = MapMakerInternalMap$WeakKeyDummyValueSegment.access$200((MapMakerInternalMap$WeakKeyDummyValueSegment)object);
        return mapMakerInternalMap$WeakKeyDummyValueEntry.copy((ReferenceQueue)object, mapMakerInternalMap$WeakKeyDummyValueEntry2);
    }

    public MapMakerInternalMap$Strength keyStrength() {
        return MapMakerInternalMap$Strength.WEAK;
    }

    public MapMakerInternalMap$WeakKeyDummyValueEntry newEntry(MapMakerInternalMap$WeakKeyDummyValueSegment object, Object object2, int n10, MapMakerInternalMap$WeakKeyDummyValueEntry mapMakerInternalMap$WeakKeyDummyValueEntry) {
        object = MapMakerInternalMap$WeakKeyDummyValueSegment.access$200((MapMakerInternalMap$WeakKeyDummyValueSegment)object);
        MapMakerInternalMap$WeakKeyDummyValueEntry mapMakerInternalMap$WeakKeyDummyValueEntry2 = new MapMakerInternalMap$WeakKeyDummyValueEntry((ReferenceQueue)object, object2, n10, mapMakerInternalMap$WeakKeyDummyValueEntry);
        return mapMakerInternalMap$WeakKeyDummyValueEntry2;
    }

    public MapMakerInternalMap$WeakKeyDummyValueSegment newSegment(MapMakerInternalMap mapMakerInternalMap, int n10, int n11) {
        MapMakerInternalMap$WeakKeyDummyValueSegment mapMakerInternalMap$WeakKeyDummyValueSegment = new MapMakerInternalMap$WeakKeyDummyValueSegment(mapMakerInternalMap, n10, n11);
        return mapMakerInternalMap$WeakKeyDummyValueSegment;
    }

    public void setValue(MapMakerInternalMap$WeakKeyDummyValueSegment mapMakerInternalMap$WeakKeyDummyValueSegment, MapMakerInternalMap$WeakKeyDummyValueEntry mapMakerInternalMap$WeakKeyDummyValueEntry, MapMaker$Dummy mapMaker$Dummy) {
    }

    public MapMakerInternalMap$Strength valueStrength() {
        return MapMakerInternalMap$Strength.STRONG;
    }
}

