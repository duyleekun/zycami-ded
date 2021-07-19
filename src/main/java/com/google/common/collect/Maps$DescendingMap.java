/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$DescendingMap$1EntrySetImpl;
import com.google.common.collect.Maps$NavigableKeySet;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

public abstract class Maps$DescendingMap
extends ForwardingMap
implements NavigableMap {
    private transient Comparator comparator;
    private transient Set entrySet;
    private transient NavigableSet navigableKeySet;

    private static Ordering reverse(Comparator comparator) {
        return Ordering.from(comparator).reverse();
    }

    public Map.Entry ceilingEntry(Object object) {
        return this.forward().floorEntry(object);
    }

    public Object ceilingKey(Object object) {
        return this.forward().floorKey(object);
    }

    public Comparator comparator() {
        Ordering ordering = this.comparator;
        if (ordering == null) {
            ordering = this.forward().comparator();
            if (ordering == null) {
                ordering = Ordering.natural();
            }
            ordering = Maps$DescendingMap.reverse(ordering);
            this.comparator = ordering;
        }
        return ordering;
    }

    public Set createEntrySet() {
        Maps$DescendingMap$1EntrySetImpl maps$DescendingMap$1EntrySetImpl = new Maps$DescendingMap$1EntrySetImpl(this);
        return maps$DescendingMap$1EntrySetImpl;
    }

    public final Map delegate() {
        return this.forward();
    }

    public NavigableSet descendingKeySet() {
        return this.forward().navigableKeySet();
    }

    public NavigableMap descendingMap() {
        return this.forward();
    }

    public abstract Iterator entryIterator();

    public Set entrySet() {
        Set set = this.entrySet;
        if (set == null) {
            this.entrySet = set = this.createEntrySet();
        }
        return set;
    }

    public Map.Entry firstEntry() {
        return this.forward().lastEntry();
    }

    public Object firstKey() {
        return this.forward().lastKey();
    }

    public Map.Entry floorEntry(Object object) {
        return this.forward().ceilingEntry(object);
    }

    public Object floorKey(Object object) {
        return this.forward().ceilingKey(object);
    }

    public abstract NavigableMap forward();

    public NavigableMap headMap(Object object, boolean bl2) {
        return this.forward().tailMap(object, bl2).descendingMap();
    }

    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public Map.Entry higherEntry(Object object) {
        return this.forward().lowerEntry(object);
    }

    public Object higherKey(Object object) {
        return this.forward().lowerKey(object);
    }

    public Set keySet() {
        return this.navigableKeySet();
    }

    public Map.Entry lastEntry() {
        return this.forward().firstEntry();
    }

    public Object lastKey() {
        return this.forward().firstKey();
    }

    public Map.Entry lowerEntry(Object object) {
        return this.forward().higherEntry(object);
    }

    public Object lowerKey(Object object) {
        return this.forward().higherKey(object);
    }

    public NavigableSet navigableKeySet() {
        NavigableSet navigableSet = this.navigableKeySet;
        if (navigableSet == null) {
            this.navigableKeySet = navigableSet = new Maps$NavigableKeySet(this);
        }
        return navigableSet;
    }

    public Map.Entry pollFirstEntry() {
        return this.forward().pollLastEntry();
    }

    public Map.Entry pollLastEntry() {
        return this.forward().pollFirstEntry();
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.forward().subMap(object2, bl3, object, bl2).descendingMap();
    }

    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return this.forward().headMap(object, bl2).descendingMap();
    }

    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    public String toString() {
        return this.standardToString();
    }

    public Collection values() {
        Maps$Values maps$Values = new Maps$Values(this);
        return maps$Values;
    }
}

