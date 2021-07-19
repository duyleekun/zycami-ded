/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntryHelper;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$WeakKeyStrongValueEntry;
import com.google.common.collect.MapMakerInternalMap$WeakKeyStrongValueSegment;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$WeakKeyStrongValueEntry$Helper
implements MapMakerInternalMap$InternalEntryHelper {
    private static final MapMakerInternalMap$WeakKeyStrongValueEntry$Helper INSTANCE;

    static {
        MapMakerInternalMap$WeakKeyStrongValueEntry$Helper mapMakerInternalMap$WeakKeyStrongValueEntry$Helper;
        INSTANCE = mapMakerInternalMap$WeakKeyStrongValueEntry$Helper = new MapMakerInternalMap$WeakKeyStrongValueEntry$Helper();
    }

    public static MapMakerInternalMap$WeakKeyStrongValueEntry$Helper instance() {
        return INSTANCE;
    }

    public MapMakerInternalMap$WeakKeyStrongValueEntry copy(MapMakerInternalMap$WeakKeyStrongValueSegment object, MapMakerInternalMap$WeakKeyStrongValueEntry mapMakerInternalMap$WeakKeyStrongValueEntry, MapMakerInternalMap$WeakKeyStrongValueEntry mapMakerInternalMap$WeakKeyStrongValueEntry2) {
        Object object2 = mapMakerInternalMap$WeakKeyStrongValueEntry.getKey();
        if (object2 == null) {
            return null;
        }
        object = MapMakerInternalMap$WeakKeyStrongValueSegment.access$300((MapMakerInternalMap$WeakKeyStrongValueSegment)object);
        return mapMakerInternalMap$WeakKeyStrongValueEntry.copy((ReferenceQueue)object, mapMakerInternalMap$WeakKeyStrongValueEntry2);
    }

    public MapMakerInternalMap$Strength keyStrength() {
        return MapMakerInternalMap$Strength.WEAK;
    }

    public MapMakerInternalMap$WeakKeyStrongValueEntry newEntry(MapMakerInternalMap$WeakKeyStrongValueSegment object, Object object2, int n10, MapMakerInternalMap$WeakKeyStrongValueEntry mapMakerInternalMap$WeakKeyStrongValueEntry) {
        object = MapMakerInternalMap$WeakKeyStrongValueSegment.access$300((MapMakerInternalMap$WeakKeyStrongValueSegment)object);
        MapMakerInternalMap$WeakKeyStrongValueEntry mapMakerInternalMap$WeakKeyStrongValueEntry2 = new MapMakerInternalMap$WeakKeyStrongValueEntry((ReferenceQueue)object, object2, n10, mapMakerInternalMap$WeakKeyStrongValueEntry);
        return mapMakerInternalMap$WeakKeyStrongValueEntry2;
    }

    public MapMakerInternalMap$WeakKeyStrongValueSegment newSegment(MapMakerInternalMap mapMakerInternalMap, int n10, int n11) {
        MapMakerInternalMap$WeakKeyStrongValueSegment mapMakerInternalMap$WeakKeyStrongValueSegment = new MapMakerInternalMap$WeakKeyStrongValueSegment(mapMakerInternalMap, n10, n11);
        return mapMakerInternalMap$WeakKeyStrongValueSegment;
    }

    public void setValue(MapMakerInternalMap$WeakKeyStrongValueSegment mapMakerInternalMap$WeakKeyStrongValueSegment, MapMakerInternalMap$WeakKeyStrongValueEntry mapMakerInternalMap$WeakKeyStrongValueEntry, Object object) {
        mapMakerInternalMap$WeakKeyStrongValueEntry.setValue(object);
    }

    public MapMakerInternalMap$Strength valueStrength() {
        return MapMakerInternalMap$Strength.STRONG;
    }
}

