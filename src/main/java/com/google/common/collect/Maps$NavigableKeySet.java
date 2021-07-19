/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$SortedKeySet;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;

public class Maps$NavigableKeySet
extends Maps$SortedKeySet
implements NavigableSet {
    public Maps$NavigableKeySet(NavigableMap navigableMap) {
        super(navigableMap);
    }

    public Object ceiling(Object object) {
        return this.map().ceilingKey(object);
    }

    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }

    public NavigableSet descendingSet() {
        return this.map().descendingKeySet();
    }

    public Object floor(Object object) {
        return this.map().floorKey(object);
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return this.map().headMap(object, bl2).navigableKeySet();
    }

    public SortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    public Object higher(Object object) {
        return this.map().higherKey(object);
    }

    public Object lower(Object object) {
        return this.map().lowerKey(object);
    }

    public NavigableMap map() {
        return (NavigableMap)this.map;
    }

    public Object pollFirst() {
        return Maps.keyOrNull(this.map().pollFirstEntry());
    }

    public Object pollLast() {
        return Maps.keyOrNull(this.map().pollLastEntry());
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.map().subMap(object, bl2, object2, bl3).navigableKeySet();
    }

    public SortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return this.map().tailMap(object, bl2).navigableKeySet();
    }

    public SortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }
}

