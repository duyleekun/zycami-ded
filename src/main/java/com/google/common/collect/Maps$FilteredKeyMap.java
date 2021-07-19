/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

public class Maps$FilteredKeyMap
extends Maps$AbstractFilteredMap {
    public final Predicate keyPredicate;

    public Maps$FilteredKeyMap(Map map, Predicate predicate, Predicate predicate2) {
        super(map, predicate2);
        this.keyPredicate = predicate;
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        Object object2 = this.unfiltered;
        boolean bl3 = object2.containsKey(object);
        if (bl3 && (bl2 = (object2 = this.keyPredicate).apply(object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Set createEntrySet() {
        Set set = this.unfiltered.entrySet();
        Predicate predicate = this.predicate;
        return Sets.filter(set, predicate);
    }

    public Set createKeySet() {
        Set set = this.unfiltered.keySet();
        Predicate predicate = this.keyPredicate;
        return Sets.filter(set, predicate);
    }
}

