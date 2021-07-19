/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredEntryNavigableMap$1;
import com.google.common.collect.Maps$FilteredMapValues;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

public class Maps$FilteredEntryNavigableMap
extends AbstractNavigableMap {
    private final Predicate entryPredicate;
    private final Map filteredDelegate;
    private final NavigableMap unfiltered;

    public Maps$FilteredEntryNavigableMap(NavigableMap navigableMap, Predicate predicate) {
        Map map;
        this.unfiltered = map = (NavigableMap)Preconditions.checkNotNull(navigableMap);
        this.entryPredicate = predicate;
        super(navigableMap, predicate);
        this.filteredDelegate = map;
    }

    public static /* synthetic */ Predicate access$500(Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap) {
        return maps$FilteredEntryNavigableMap.entryPredicate;
    }

    public static /* synthetic */ NavigableMap access$600(Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap) {
        return maps$FilteredEntryNavigableMap.unfiltered;
    }

    public void clear() {
        this.filteredDelegate.clear();
    }

    public Comparator comparator() {
        return this.unfiltered.comparator();
    }

    public boolean containsKey(Object object) {
        return this.filteredDelegate.containsKey(object);
    }

    public Iterator descendingEntryIterator() {
        Iterator iterator2 = this.unfiltered.descendingMap().entrySet().iterator();
        Predicate predicate = this.entryPredicate;
        return Iterators.filter(iterator2, predicate);
    }

    public NavigableMap descendingMap() {
        NavigableMap navigableMap = this.unfiltered.descendingMap();
        Predicate predicate = this.entryPredicate;
        return Maps.filterEntries(navigableMap, predicate);
    }

    public Iterator entryIterator() {
        Iterator iterator2 = this.unfiltered.entrySet().iterator();
        Predicate predicate = this.entryPredicate;
        return Iterators.filter(iterator2, predicate);
    }

    public Set entrySet() {
        return this.filteredDelegate.entrySet();
    }

    public Object get(Object object) {
        return this.filteredDelegate.get(object);
    }

    public NavigableMap headMap(Object navigableMap, boolean bl2) {
        navigableMap = this.unfiltered.headMap(navigableMap, bl2);
        Predicate predicate = this.entryPredicate;
        return Maps.filterEntries(navigableMap, predicate);
    }

    public boolean isEmpty() {
        Set set = this.unfiltered.entrySet();
        Predicate predicate = this.entryPredicate;
        return Iterables.any(set, predicate) ^ true;
    }

    public NavigableSet navigableKeySet() {
        Maps$FilteredEntryNavigableMap$1 maps$FilteredEntryNavigableMap$1 = new Maps$FilteredEntryNavigableMap$1(this, this);
        return maps$FilteredEntryNavigableMap$1;
    }

    public Map.Entry pollFirstEntry() {
        Set set = this.unfiltered.entrySet();
        Predicate predicate = this.entryPredicate;
        return (Map.Entry)Iterables.removeFirstMatching(set, predicate);
    }

    public Map.Entry pollLastEntry() {
        Set set = this.unfiltered.descendingMap().entrySet();
        Predicate predicate = this.entryPredicate;
        return (Map.Entry)Iterables.removeFirstMatching(set, predicate);
    }

    public Object put(Object object, Object object2) {
        return this.filteredDelegate.put(object, object2);
    }

    public void putAll(Map map) {
        this.filteredDelegate.putAll(map);
    }

    public Object remove(Object object) {
        return this.filteredDelegate.remove(object);
    }

    public int size() {
        return this.filteredDelegate.size();
    }

    public NavigableMap subMap(Object navigableMap, boolean bl2, Object object, boolean bl3) {
        navigableMap = this.unfiltered.subMap(navigableMap, bl2, object, bl3);
        Predicate predicate = this.entryPredicate;
        return Maps.filterEntries(navigableMap, predicate);
    }

    public NavigableMap tailMap(Object navigableMap, boolean bl2) {
        navigableMap = this.unfiltered.tailMap(navigableMap, bl2);
        Predicate predicate = this.entryPredicate;
        return Maps.filterEntries(navigableMap, predicate);
    }

    public Collection values() {
        NavigableMap navigableMap = this.unfiltered;
        Predicate predicate = this.entryPredicate;
        Maps$FilteredMapValues maps$FilteredMapValues = new Maps$FilteredMapValues(this, navigableMap, predicate);
        return maps$FilteredMapValues;
    }
}

