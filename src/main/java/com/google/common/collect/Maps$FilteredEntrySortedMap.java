/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntrySortedMap$SortedKeySet;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

public class Maps$FilteredEntrySortedMap
extends Maps$FilteredEntryMap
implements SortedMap {
    public Maps$FilteredEntrySortedMap(SortedMap sortedMap, Predicate predicate) {
        super(sortedMap, predicate);
    }

    public Comparator comparator() {
        return this.sortedMap().comparator();
    }

    public SortedSet createKeySet() {
        Maps$FilteredEntrySortedMap$SortedKeySet maps$FilteredEntrySortedMap$SortedKeySet = new Maps$FilteredEntrySortedMap$SortedKeySet(this);
        return maps$FilteredEntrySortedMap$SortedKeySet;
    }

    public Object firstKey() {
        return this.keySet().iterator().next();
    }

    public SortedMap headMap(Object sortedMap) {
        sortedMap = this.sortedMap().headMap(sortedMap);
        Predicate predicate = this.predicate;
        Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap = new Maps$FilteredEntrySortedMap(sortedMap, predicate);
        return maps$FilteredEntrySortedMap;
    }

    public SortedSet keySet() {
        return (SortedSet)super.keySet();
    }

    public Object lastKey() {
        SortedMap sortedMap = this.sortedMap();
        Object object;
        boolean bl2;
        while (!(bl2 = this.apply(sortedMap = sortedMap.lastKey(), object = this.unfiltered.get(sortedMap)))) {
            object = this.sortedMap();
            sortedMap = object.headMap((SortedMap)sortedMap);
        }
        return sortedMap;
    }

    public SortedMap sortedMap() {
        return (SortedMap)this.unfiltered;
    }

    public SortedMap subMap(Object sortedMap, Object object) {
        sortedMap = this.sortedMap().subMap(sortedMap, object);
        object = this.predicate;
        Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap = new Maps$FilteredEntrySortedMap(sortedMap, (Predicate)object);
        return maps$FilteredEntrySortedMap;
    }

    public SortedMap tailMap(Object sortedMap) {
        sortedMap = this.sortedMap().tailMap(sortedMap);
        Predicate predicate = this.predicate;
        Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap = new Maps$FilteredEntrySortedMap(sortedMap, predicate);
        return maps$FilteredEntrySortedMap;
    }
}

