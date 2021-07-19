/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$KeySet;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

public class Maps$SortedKeySet
extends Maps$KeySet
implements SortedSet {
    public Maps$SortedKeySet(SortedMap sortedMap) {
        super(sortedMap);
    }

    public Comparator comparator() {
        return this.map().comparator();
    }

    public Object first() {
        return this.map().firstKey();
    }

    public SortedSet headSet(Object sortedMap) {
        sortedMap = this.map().headMap(sortedMap);
        Maps$SortedKeySet maps$SortedKeySet = new Maps$SortedKeySet(sortedMap);
        return maps$SortedKeySet;
    }

    public Object last() {
        return this.map().lastKey();
    }

    public SortedMap map() {
        return (SortedMap)super.map();
    }

    public SortedSet subSet(Object sortedMap, Object object) {
        sortedMap = this.map().subMap(sortedMap, object);
        Maps$SortedKeySet maps$SortedKeySet = new Maps$SortedKeySet(sortedMap);
        return maps$SortedKeySet;
    }

    public SortedSet tailSet(Object sortedMap) {
        sortedMap = this.map().tailMap(sortedMap);
        Maps$SortedKeySet maps$SortedKeySet = new Maps$SortedKeySet(sortedMap);
        return maps$SortedKeySet;
    }
}

