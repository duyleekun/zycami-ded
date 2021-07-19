/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$HashIterator;
import java.util.Map;

public final class MapMakerInternalMap$EntryIterator
extends MapMakerInternalMap$HashIterator {
    public final /* synthetic */ MapMakerInternalMap this$0;

    public MapMakerInternalMap$EntryIterator(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
        super(mapMakerInternalMap);
    }

    public Map.Entry next() {
        return this.nextEntry();
    }
}

