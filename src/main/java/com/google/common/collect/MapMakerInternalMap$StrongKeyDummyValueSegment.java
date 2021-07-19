/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$StrongKeyDummyValueEntry;

public final class MapMakerInternalMap$StrongKeyDummyValueSegment
extends MapMakerInternalMap$Segment {
    public MapMakerInternalMap$StrongKeyDummyValueSegment(MapMakerInternalMap mapMakerInternalMap, int n10, int n11) {
        super(mapMakerInternalMap, n10, n11);
    }

    public MapMakerInternalMap$StrongKeyDummyValueEntry castForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        return (MapMakerInternalMap$StrongKeyDummyValueEntry)mapMakerInternalMap$InternalEntry;
    }

    public MapMakerInternalMap$StrongKeyDummyValueSegment self() {
        return this;
    }
}

