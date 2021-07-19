/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$1;
import java.util.AbstractSet;

public abstract class MapMakerInternalMap$SafeToArraySet
extends AbstractSet {
    private MapMakerInternalMap$SafeToArraySet() {
    }

    public /* synthetic */ MapMakerInternalMap$SafeToArraySet(MapMakerInternalMap.1 var1_1) {
        this();
    }

    public Object[] toArray() {
        return MapMakerInternalMap.access$900(this).toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return MapMakerInternalMap.access$900(this).toArray(objectArray);
    }
}

