/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$HashIterator;

public final class MapMakerInternalMap$KeyIterator
extends MapMakerInternalMap$HashIterator {
    public final /* synthetic */ MapMakerInternalMap this$0;

    public MapMakerInternalMap$KeyIterator(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
        super(mapMakerInternalMap);
    }

    public Object next() {
        return this.nextEntry().getKey();
    }
}

