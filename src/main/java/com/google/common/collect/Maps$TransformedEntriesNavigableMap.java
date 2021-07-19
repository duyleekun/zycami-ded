/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$TransformedEntriesSortedMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;

public class Maps$TransformedEntriesNavigableMap
extends Maps$TransformedEntriesSortedMap
implements NavigableMap {
    public Maps$TransformedEntriesNavigableMap(NavigableMap navigableMap, Maps$EntryTransformer maps$EntryTransformer) {
        super(navigableMap, maps$EntryTransformer);
    }

    private Map.Entry transformEntry(Map.Entry entry) {
        if (entry == null) {
            entry = null;
        } else {
            Maps$EntryTransformer maps$EntryTransformer = this.transformer;
            entry = Maps.transformEntry(maps$EntryTransformer, entry);
        }
        return entry;
    }

    public Map.Entry ceilingEntry(Object entry) {
        entry = this.fromMap().ceilingEntry(entry);
        return this.transformEntry(entry);
    }

    public Object ceilingKey(Object object) {
        return this.fromMap().ceilingKey(object);
    }

    public NavigableSet descendingKeySet() {
        return this.fromMap().descendingKeySet();
    }

    public NavigableMap descendingMap() {
        NavigableMap navigableMap = this.fromMap().descendingMap();
        Maps$EntryTransformer maps$EntryTransformer = this.transformer;
        return Maps.transformEntries(navigableMap, maps$EntryTransformer);
    }

    public Map.Entry firstEntry() {
        Map.Entry entry = this.fromMap().firstEntry();
        return this.transformEntry(entry);
    }

    public Map.Entry floorEntry(Object entry) {
        entry = this.fromMap().floorEntry(entry);
        return this.transformEntry(entry);
    }

    public Object floorKey(Object object) {
        return this.fromMap().floorKey(object);
    }

    public NavigableMap fromMap() {
        return (NavigableMap)super.fromMap();
    }

    public NavigableMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public NavigableMap headMap(Object navigableMap, boolean bl2) {
        navigableMap = this.fromMap().headMap(navigableMap, bl2);
        Maps$EntryTransformer maps$EntryTransformer = this.transformer;
        return Maps.transformEntries(navigableMap, maps$EntryTransformer);
    }

    public Map.Entry higherEntry(Object entry) {
        entry = this.fromMap().higherEntry(entry);
        return this.transformEntry(entry);
    }

    public Object higherKey(Object object) {
        return this.fromMap().higherKey(object);
    }

    public Map.Entry lastEntry() {
        Map.Entry entry = this.fromMap().lastEntry();
        return this.transformEntry(entry);
    }

    public Map.Entry lowerEntry(Object entry) {
        entry = this.fromMap().lowerEntry(entry);
        return this.transformEntry(entry);
    }

    public Object lowerKey(Object object) {
        return this.fromMap().lowerKey(object);
    }

    public NavigableSet navigableKeySet() {
        return this.fromMap().navigableKeySet();
    }

    public Map.Entry pollFirstEntry() {
        Map.Entry entry = this.fromMap().pollFirstEntry();
        return this.transformEntry(entry);
    }

    public Map.Entry pollLastEntry() {
        Map.Entry entry = this.fromMap().pollLastEntry();
        return this.transformEntry(entry);
    }

    public NavigableMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public NavigableMap subMap(Object navigableMap, boolean bl2, Object object, boolean bl3) {
        navigableMap = this.fromMap().subMap(navigableMap, bl2, object, bl3);
        Maps$EntryTransformer maps$EntryTransformer = this.transformer;
        return Maps.transformEntries(navigableMap, maps$EntryTransformer);
    }

    public NavigableMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    public NavigableMap tailMap(Object navigableMap, boolean bl2) {
        navigableMap = this.fromMap().tailMap(navigableMap, bl2);
        Maps$EntryTransformer maps$EntryTransformer = this.transformer;
        return Maps.transformEntries(navigableMap, maps$EntryTransformer);
    }
}

