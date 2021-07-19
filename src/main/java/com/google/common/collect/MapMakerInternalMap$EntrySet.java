/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$EntryIterator;
import com.google.common.collect.MapMakerInternalMap$SafeToArraySet;
import java.util.Iterator;
import java.util.Map;

public final class MapMakerInternalMap$EntrySet
extends MapMakerInternalMap$SafeToArraySet {
    public final /* synthetic */ MapMakerInternalMap this$0;

    public MapMakerInternalMap$EntrySet(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
        super(null);
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Map.Entry;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        Object object2 = (object = (Map.Entry)object).getKey();
        if (object2 == null) {
            return false;
        }
        Object object3 = this.this$0;
        if ((object2 = ((MapMakerInternalMap)object3).get(object2)) != null && (bl2 = ((Equivalence)(object3 = this.this$0.valueEquivalence())).equivalent(object = object.getValue(), object2))) {
            bl4 = true;
        }
        return bl4;
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Iterator iterator() {
        MapMakerInternalMap mapMakerInternalMap = this.this$0;
        MapMakerInternalMap$EntryIterator mapMakerInternalMap$EntryIterator = new MapMakerInternalMap$EntryIterator(mapMakerInternalMap);
        return mapMakerInternalMap$EntryIterator;
    }

    public boolean remove(Object object) {
        MapMakerInternalMap mapMakerInternalMap;
        boolean bl2;
        boolean bl3 = object instanceof Map.Entry;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        Object k10 = (object = (Map.Entry)object).getKey();
        if (k10 != null && (bl2 = (mapMakerInternalMap = this.this$0).remove(k10, object = object.getValue()))) {
            bl4 = true;
        }
        return bl4;
    }

    public int size() {
        return this.this$0.size();
    }
}

