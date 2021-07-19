/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractNavigableMap$DescendingMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Maps$NavigableKeySet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

public abstract class AbstractNavigableMap
extends Maps$IteratorBasedAbstractMap
implements NavigableMap {
    public Map.Entry ceilingEntry(Object object) {
        return this.tailMap(object, true).firstEntry();
    }

    public Object ceilingKey(Object object) {
        return Maps.keyOrNull(this.ceilingEntry(object));
    }

    public abstract Iterator descendingEntryIterator();

    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    public NavigableMap descendingMap() {
        AbstractNavigableMap$DescendingMap abstractNavigableMap$DescendingMap = new AbstractNavigableMap$DescendingMap(this, null);
        return abstractNavigableMap$DescendingMap;
    }

    public Map.Entry firstEntry() {
        return (Map.Entry)Iterators.getNext(this.entryIterator(), null);
    }

    public Object firstKey() {
        Object object = this.firstEntry();
        if (object != null) {
            return object.getKey();
        }
        object = new NoSuchElementException();
        throw object;
    }

    public Map.Entry floorEntry(Object object) {
        return this.headMap(object, true).lastEntry();
    }

    public Object floorKey(Object object) {
        return Maps.keyOrNull(this.floorEntry(object));
    }

    public abstract Object get(Object var1);

    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public Map.Entry higherEntry(Object object) {
        return this.tailMap(object, false).firstEntry();
    }

    public Object higherKey(Object object) {
        return Maps.keyOrNull(this.higherEntry(object));
    }

    public Set keySet() {
        return this.navigableKeySet();
    }

    public Map.Entry lastEntry() {
        return (Map.Entry)Iterators.getNext(this.descendingEntryIterator(), null);
    }

    public Object lastKey() {
        Object object = this.lastEntry();
        if (object != null) {
            return object.getKey();
        }
        object = new NoSuchElementException();
        throw object;
    }

    public Map.Entry lowerEntry(Object object) {
        return this.headMap(object, false).lastEntry();
    }

    public Object lowerKey(Object object) {
        return Maps.keyOrNull(this.lowerEntry(object));
    }

    public NavigableSet navigableKeySet() {
        Maps$NavigableKeySet maps$NavigableKeySet = new Maps$NavigableKeySet(this);
        return maps$NavigableKeySet;
    }

    public Map.Entry pollFirstEntry() {
        return (Map.Entry)Iterators.pollNext(this.entryIterator());
    }

    public Map.Entry pollLastEntry() {
        return (Map.Entry)Iterators.pollNext(this.descendingEntryIterator());
    }

    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }
}

