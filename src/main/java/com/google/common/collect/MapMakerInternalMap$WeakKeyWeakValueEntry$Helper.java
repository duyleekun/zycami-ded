/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntryHelper;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$WeakKeyWeakValueEntry;
import com.google.common.collect.MapMakerInternalMap$WeakKeyWeakValueSegment;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$WeakKeyWeakValueEntry$Helper
implements MapMakerInternalMap$InternalEntryHelper {
    private static final MapMakerInternalMap$WeakKeyWeakValueEntry$Helper INSTANCE;

    static {
        MapMakerInternalMap$WeakKeyWeakValueEntry$Helper mapMakerInternalMap$WeakKeyWeakValueEntry$Helper;
        INSTANCE = mapMakerInternalMap$WeakKeyWeakValueEntry$Helper = new MapMakerInternalMap$WeakKeyWeakValueEntry$Helper();
    }

    public static MapMakerInternalMap$WeakKeyWeakValueEntry$Helper instance() {
        return INSTANCE;
    }

    public MapMakerInternalMap$WeakKeyWeakValueEntry copy(MapMakerInternalMap$WeakKeyWeakValueSegment object, MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry, MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry2) {
        Object object2 = mapMakerInternalMap$WeakKeyWeakValueEntry.getKey();
        if (object2 == null) {
            return null;
        }
        boolean bl2 = MapMakerInternalMap$Segment.isCollected(mapMakerInternalMap$WeakKeyWeakValueEntry);
        if (bl2) {
            return null;
        }
        object2 = MapMakerInternalMap$WeakKeyWeakValueSegment.access$400((MapMakerInternalMap$WeakKeyWeakValueSegment)object);
        object = MapMakerInternalMap$WeakKeyWeakValueSegment.access$500((MapMakerInternalMap$WeakKeyWeakValueSegment)object);
        return mapMakerInternalMap$WeakKeyWeakValueEntry.copy((ReferenceQueue)object2, (ReferenceQueue)object, mapMakerInternalMap$WeakKeyWeakValueEntry2);
    }

    public MapMakerInternalMap$Strength keyStrength() {
        return MapMakerInternalMap$Strength.WEAK;
    }

    public MapMakerInternalMap$WeakKeyWeakValueEntry newEntry(MapMakerInternalMap$WeakKeyWeakValueSegment object, Object object2, int n10, MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry) {
        object = MapMakerInternalMap$WeakKeyWeakValueSegment.access$400((MapMakerInternalMap$WeakKeyWeakValueSegment)object);
        MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry2 = new MapMakerInternalMap$WeakKeyWeakValueEntry((ReferenceQueue)object, object2, n10, mapMakerInternalMap$WeakKeyWeakValueEntry);
        return mapMakerInternalMap$WeakKeyWeakValueEntry2;
    }

    public MapMakerInternalMap$WeakKeyWeakValueSegment newSegment(MapMakerInternalMap mapMakerInternalMap, int n10, int n11) {
        MapMakerInternalMap$WeakKeyWeakValueSegment mapMakerInternalMap$WeakKeyWeakValueSegment = new MapMakerInternalMap$WeakKeyWeakValueSegment(mapMakerInternalMap, n10, n11);
        return mapMakerInternalMap$WeakKeyWeakValueSegment;
    }

    public void setValue(MapMakerInternalMap$WeakKeyWeakValueSegment object, MapMakerInternalMap$WeakKeyWeakValueEntry mapMakerInternalMap$WeakKeyWeakValueEntry, Object object2) {
        object = MapMakerInternalMap$WeakKeyWeakValueSegment.access$500((MapMakerInternalMap$WeakKeyWeakValueSegment)object);
        mapMakerInternalMap$WeakKeyWeakValueEntry.setValue(object2, (ReferenceQueue)object);
    }

    public MapMakerInternalMap$Strength valueStrength() {
        return MapMakerInternalMap$Strength.WEAK;
    }
}

