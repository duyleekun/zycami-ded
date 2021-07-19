/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredMapValues;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class Maps$AbstractFilteredMap
extends Maps$ViewCachingAbstractMap {
    public final Predicate predicate;
    public final Map unfiltered;

    public Maps$AbstractFilteredMap(Map map, Predicate predicate) {
        this.unfiltered = map;
        this.predicate = predicate;
    }

    public boolean apply(Object object, Object object2) {
        Predicate predicate = this.predicate;
        object = Maps.immutableEntry(object, object2);
        return predicate.apply(object);
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        Map map = this.unfiltered;
        boolean bl3 = map.containsKey(object);
        if (bl3 && (bl2 = this.apply(object, map = this.unfiltered.get(object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Collection createValues() {
        Map map = this.unfiltered;
        Predicate predicate = this.predicate;
        Maps$FilteredMapValues maps$FilteredMapValues = new Maps$FilteredMapValues(this, map, predicate);
        return maps$FilteredMapValues;
    }

    public Object get(Object object) {
        boolean bl2;
        Object v10 = this.unfiltered.get(object);
        if (v10 == null || !(bl2 = this.apply(object, v10))) {
            v10 = null;
        }
        return v10;
    }

    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }

    public Object put(Object object, Object object2) {
        Preconditions.checkArgument(this.apply(object, object2));
        return this.unfiltered.put(object, object2);
    }

    public void putAll(Map map) {
        boolean bl2;
        Iterator iterator2 = map.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            bl2 = this.apply(k10, entry);
            Preconditions.checkArgument(bl2);
        }
        this.unfiltered.putAll(map);
    }

    public Object remove(Object object) {
        boolean bl2 = this.containsKey(object);
        if (bl2) {
            Map map = this.unfiltered;
            object = map.remove(object);
        } else {
            object = null;
        }
        return object;
    }
}

