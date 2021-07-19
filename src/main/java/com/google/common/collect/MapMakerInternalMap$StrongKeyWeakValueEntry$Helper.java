/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntryHelper;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$StrongKeyWeakValueEntry;
import com.google.common.collect.MapMakerInternalMap$StrongKeyWeakValueSegment;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$StrongKeyWeakValueEntry$Helper
implements MapMakerInternalMap$InternalEntryHelper {
    private static final MapMakerInternalMap$StrongKeyWeakValueEntry$Helper INSTANCE;

    static {
        MapMakerInternalMap$StrongKeyWeakValueEntry$Helper mapMakerInternalMap$StrongKeyWeakValueEntry$Helper;
        INSTANCE = mapMakerInternalMap$StrongKeyWeakValueEntry$Helper = new MapMakerInternalMap$StrongKeyWeakValueEntry$Helper();
    }

    public static MapMakerInternalMap$StrongKeyWeakValueEntry$Helper instance() {
        return INSTANCE;
    }

    public MapMakerInternalMap$StrongKeyWeakValueEntry copy(MapMakerInternalMap$StrongKeyWeakValueSegment object, MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry, MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry2) {
        boolean bl2 = MapMakerInternalMap$Segment.isCollected(mapMakerInternalMap$StrongKeyWeakValueEntry);
        if (bl2) {
            return null;
        }
        object = MapMakerInternalMap$StrongKeyWeakValueSegment.access$100((MapMakerInternalMap$StrongKeyWeakValueSegment)object);
        return mapMakerInternalMap$StrongKeyWeakValueEntry.copy((ReferenceQueue)object, mapMakerInternalMap$StrongKeyWeakValueEntry2);
    }

    public MapMakerInternalMap$Strength keyStrength() {
        return MapMakerInternalMap$Strength.STRONG;
    }

    public MapMakerInternalMap$StrongKeyWeakValueEntry newEntry(MapMakerInternalMap$StrongKeyWeakValueSegment object, Object object2, int n10, MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry) {
        object = new MapMakerInternalMap$StrongKeyWeakValueEntry(object2, n10, mapMakerInternalMap$StrongKeyWeakValueEntry);
        return object;
    }

    public MapMakerInternalMap$StrongKeyWeakValueSegment newSegment(MapMakerInternalMap mapMakerInternalMap, int n10, int n11) {
        MapMakerInternalMap$StrongKeyWeakValueSegment mapMakerInternalMap$StrongKeyWeakValueSegment = new MapMakerInternalMap$StrongKeyWeakValueSegment(mapMakerInternalMap, n10, n11);
        return mapMakerInternalMap$StrongKeyWeakValueSegment;
    }

    public void setValue(MapMakerInternalMap$StrongKeyWeakValueSegment object, MapMakerInternalMap$StrongKeyWeakValueEntry mapMakerInternalMap$StrongKeyWeakValueEntry, Object object2) {
        object = MapMakerInternalMap$StrongKeyWeakValueSegment.access$100((MapMakerInternalMap$StrongKeyWeakValueSegment)object);
        mapMakerInternalMap$StrongKeyWeakValueEntry.setValue(object2, (ReferenceQueue)object);
    }

    public MapMakerInternalMap$Strength valueStrength() {
        return MapMakerInternalMap$Strength.WEAK;
    }
}

