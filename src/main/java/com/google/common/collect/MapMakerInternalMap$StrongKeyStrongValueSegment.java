/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$StrongKeyStrongValueEntry;

public final class MapMakerInternalMap$StrongKeyStrongValueSegment
extends MapMakerInternalMap$Segment {
    public MapMakerInternalMap$StrongKeyStrongValueSegment(MapMakerInternalMap mapMakerInternalMap, int n10, int n11) {
        super(mapMakerInternalMap, n10, n11);
    }

    public MapMakerInternalMap$StrongKeyStrongValueEntry castForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        return (MapMakerInternalMap$StrongKeyStrongValueEntry)mapMakerInternalMap$InternalEntry;
    }

    public MapMakerInternalMap$StrongKeyStrongValueSegment self() {
        return this;
    }
}

