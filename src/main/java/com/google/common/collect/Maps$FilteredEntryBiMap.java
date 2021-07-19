/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.BiMap;
import com.google.common.collect.Maps$FilteredEntryBiMap$1;
import com.google.common.collect.Maps$FilteredEntryMap;
import java.util.Set;

public final class Maps$FilteredEntryBiMap
extends Maps$FilteredEntryMap
implements BiMap {
    private final BiMap inverse;

    public Maps$FilteredEntryBiMap(BiMap biMap, Predicate predicate) {
        super(biMap, predicate);
        biMap = biMap.inverse();
        predicate = Maps$FilteredEntryBiMap.inversePredicate(predicate);
        Maps$FilteredEntryBiMap maps$FilteredEntryBiMap = new Maps$FilteredEntryBiMap(biMap, predicate, this);
        this.inverse = maps$FilteredEntryBiMap;
    }

    private Maps$FilteredEntryBiMap(BiMap biMap, Predicate predicate, BiMap biMap2) {
        super(biMap, predicate);
        this.inverse = biMap2;
    }

    private static Predicate inversePredicate(Predicate predicate) {
        Maps$FilteredEntryBiMap$1 maps$FilteredEntryBiMap$1 = new Maps$FilteredEntryBiMap$1(predicate);
        return maps$FilteredEntryBiMap$1;
    }

    public Object forcePut(Object object, Object object2) {
        Preconditions.checkArgument(this.apply(object, object2));
        return this.unfiltered().forcePut(object, object2);
    }

    public BiMap inverse() {
        return this.inverse;
    }

    public BiMap unfiltered() {
        return (BiMap)this.unfiltered;
    }

    public Set values() {
        return this.inverse.keySet();
    }
}

