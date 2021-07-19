/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.MapMakerInternalMap;
import java.util.Map;

public final class MapMakerInternalMap$WriteThroughEntry
extends AbstractMapEntry {
    public final Object key;
    public final /* synthetic */ MapMakerInternalMap this$0;
    public Object value;

    public MapMakerInternalMap$WriteThroughEntry(MapMakerInternalMap mapMakerInternalMap, Object object, Object object2) {
        this.this$0 = mapMakerInternalMap;
        this.key = object;
        this.value = object2;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object k10;
        Object object2;
        boolean bl3 = object instanceof Map.Entry;
        boolean bl4 = false;
        if (bl3 && (bl3 = (object2 = this.key).equals(k10 = (object = (Map.Entry)object).getKey())) && (bl2 = (object2 = this.value).equals(object = object.getValue()))) {
            bl4 = true;
        }
        return bl4;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int n10 = this.key.hashCode();
        int n11 = this.value.hashCode();
        return n10 ^ n11;
    }

    public Object setValue(Object object) {
        Object object2 = this.this$0;
        Object object3 = this.key;
        object2 = ((MapMakerInternalMap)object2).put(object3, object);
        this.value = object;
        return object2;
    }
}

