/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$TransformedEntriesMap;
import java.util.Comparator;
import java.util.SortedMap;

public class Maps$TransformedEntriesSortedMap
extends Maps$TransformedEntriesMap
implements SortedMap {
    public Maps$TransformedEntriesSortedMap(SortedMap sortedMap, Maps$EntryTransformer maps$EntryTransformer) {
        super(sortedMap, maps$EntryTransformer);
    }

    public Comparator comparator() {
        return this.fromMap().comparator();
    }

    public Object firstKey() {
        return this.fromMap().firstKey();
    }

    public SortedMap fromMap() {
        return (SortedMap)this.fromMap;
    }

    public SortedMap headMap(Object sortedMap) {
        sortedMap = this.fromMap().headMap(sortedMap);
        Maps$EntryTransformer maps$EntryTransformer = this.transformer;
        return Maps.transformEntries(sortedMap, maps$EntryTransformer);
    }

    public Object lastKey() {
        return this.fromMap().lastKey();
    }

    public SortedMap subMap(Object sortedMap, Object object) {
        sortedMap = this.fromMap().subMap(sortedMap, object);
        object = this.transformer;
        return Maps.transformEntries(sortedMap, (Maps$EntryTransformer)object);
    }

    public SortedMap tailMap(Object sortedMap) {
        sortedMap = this.fromMap().tailMap(sortedMap);
        Maps$EntryTransformer maps$EntryTransformer = this.transformer;
        return Maps.transformEntries(sortedMap, maps$EntryTransformer);
    }
}

