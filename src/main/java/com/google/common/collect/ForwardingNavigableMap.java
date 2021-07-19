/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSortedMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

public abstract class ForwardingNavigableMap
extends ForwardingSortedMap
implements NavigableMap {
    public Map.Entry ceilingEntry(Object object) {
        return this.delegate().ceilingEntry(object);
    }

    public Object ceilingKey(Object object) {
        return this.delegate().ceilingKey(object);
    }

    public abstract NavigableMap delegate();

    public NavigableSet descendingKeySet() {
        return this.delegate().descendingKeySet();
    }

    public NavigableMap descendingMap() {
        return this.delegate().descendingMap();
    }

    public Map.Entry firstEntry() {
        return this.delegate().firstEntry();
    }

    public Map.Entry floorEntry(Object object) {
        return this.delegate().floorEntry(object);
    }

    public Object floorKey(Object object) {
        return this.delegate().floorKey(object);
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return this.delegate().headMap(object, bl2);
    }

    public Map.Entry higherEntry(Object object) {
        return this.delegate().higherEntry(object);
    }

    public Object higherKey(Object object) {
        return this.delegate().higherKey(object);
    }

    public Map.Entry lastEntry() {
        return this.delegate().lastEntry();
    }

    public Map.Entry lowerEntry(Object object) {
        return this.delegate().lowerEntry(object);
    }

    public Object lowerKey(Object object) {
        return this.delegate().lowerKey(object);
    }

    public NavigableSet navigableKeySet() {
        return this.delegate().navigableKeySet();
    }

    public Map.Entry pollFirstEntry() {
        return this.delegate().pollFirstEntry();
    }

    public Map.Entry pollLastEntry() {
        return this.delegate().pollLastEntry();
    }

    public Map.Entry standardCeilingEntry(Object object) {
        return this.tailMap(object, true).firstEntry();
    }

    public Object standardCeilingKey(Object object) {
        return Maps.keyOrNull(this.ceilingEntry(object));
    }

    public NavigableSet standardDescendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    public Map.Entry standardFirstEntry() {
        return (Map.Entry)Iterables.getFirst(this.entrySet(), null);
    }

    public Object standardFirstKey() {
        Object object = this.firstEntry();
        if (object != null) {
            return object.getKey();
        }
        object = new NoSuchElementException();
        throw object;
    }

    public Map.Entry standardFloorEntry(Object object) {
        return this.headMap(object, true).lastEntry();
    }

    public Object standardFloorKey(Object object) {
        return Maps.keyOrNull(this.floorEntry(object));
    }

    public SortedMap standardHeadMap(Object object) {
        return this.headMap(object, false);
    }

    public Map.Entry standardHigherEntry(Object object) {
        return this.tailMap(object, false).firstEntry();
    }

    public Object standardHigherKey(Object object) {
        return Maps.keyOrNull(this.higherEntry(object));
    }

    public Map.Entry standardLastEntry() {
        return (Map.Entry)Iterables.getFirst(this.descendingMap().entrySet(), null);
    }

    public Object standardLastKey() {
        Object object = this.lastEntry();
        if (object != null) {
            return object.getKey();
        }
        object = new NoSuchElementException();
        throw object;
    }

    public Map.Entry standardLowerEntry(Object object) {
        return this.headMap(object, false).lastEntry();
    }

    public Object standardLowerKey(Object object) {
        return Maps.keyOrNull(this.lowerEntry(object));
    }

    public Map.Entry standardPollFirstEntry() {
        return (Map.Entry)Iterators.pollNext(this.entrySet().iterator());
    }

    public Map.Entry standardPollLastEntry() {
        return (Map.Entry)Iterators.pollNext(this.descendingMap().entrySet().iterator());
    }

    public SortedMap standardSubMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public SortedMap standardTailMap(Object object) {
        return this.tailMap(object, true);
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.delegate().subMap(object, bl2, object2, bl3);
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return this.delegate().tailMap(object, bl2);
    }
}

