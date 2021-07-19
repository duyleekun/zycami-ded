/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners$1;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$Dummy;
import com.google.common.collect.MapMakerInternalMap;

public final class Interners$InternerImpl
implements Interner {
    public final MapMakerInternalMap map;

    private Interners$InternerImpl(MapMaker object) {
        Equivalence equivalence = Equivalence.equals();
        this.map = object = MapMakerInternalMap.createWithDummyValues(((MapMaker)object).keyEquivalence(equivalence));
    }

    public /* synthetic */ Interners$InternerImpl(MapMaker mapMaker, Interners$1 interners$1) {
        this(mapMaker);
    }

    public Object intern(Object object) {
        MapMaker$Dummy mapMaker$Dummy;
        Object object2;
        do {
            if ((object2 = this.map.getEntry(object)) != null && (object2 = object2.getKey()) != null) {
                return object2;
            }
            object2 = this.map;
        } while ((object2 = (MapMaker$Dummy)((Object)((MapMakerInternalMap)object2).putIfAbsent(object, (Object)(mapMaker$Dummy = MapMaker$Dummy.VALUE)))) != null);
        return object;
    }
}

