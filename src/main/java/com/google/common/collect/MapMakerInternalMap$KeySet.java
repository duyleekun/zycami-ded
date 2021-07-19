/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$KeyIterator;
import com.google.common.collect.MapMakerInternalMap$SafeToArraySet;
import java.util.Iterator;

public final class MapMakerInternalMap$KeySet
extends MapMakerInternalMap$SafeToArraySet {
    public final /* synthetic */ MapMakerInternalMap this$0;

    public MapMakerInternalMap$KeySet(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
        super(null);
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Iterator iterator() {
        MapMakerInternalMap mapMakerInternalMap = this.this$0;
        MapMakerInternalMap$KeyIterator mapMakerInternalMap$KeyIterator = new MapMakerInternalMap$KeyIterator(mapMakerInternalMap);
        return mapMakerInternalMap$KeyIterator;
    }

    public boolean remove(Object object) {
        boolean bl2;
        MapMakerInternalMap mapMakerInternalMap = this.this$0;
        if ((object = mapMakerInternalMap.remove(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int size() {
        return this.this$0.size();
    }
}

