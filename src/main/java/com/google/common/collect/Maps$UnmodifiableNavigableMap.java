/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

public class Maps$UnmodifiableNavigableMap
extends ForwardingSortedMap
implements NavigableMap,
Serializable {
    private final NavigableMap delegate;
    private transient Maps$UnmodifiableNavigableMap descendingMap;

    public Maps$UnmodifiableNavigableMap(NavigableMap navigableMap) {
        this.delegate = navigableMap;
    }

    public Maps$UnmodifiableNavigableMap(NavigableMap navigableMap, Maps$UnmodifiableNavigableMap maps$UnmodifiableNavigableMap) {
        this.delegate = navigableMap;
        this.descendingMap = maps$UnmodifiableNavigableMap;
    }

    public Map.Entry ceilingEntry(Object object) {
        return Maps.access$800(this.delegate.ceilingEntry(object));
    }

    public Object ceilingKey(Object object) {
        return this.delegate.ceilingKey(object);
    }

    public SortedMap delegate() {
        return Collections.unmodifiableSortedMap(this.delegate);
    }

    public NavigableSet descendingKeySet() {
        return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
    }

    public NavigableMap descendingMap() {
        Maps$UnmodifiableNavigableMap maps$UnmodifiableNavigableMap = this.descendingMap;
        if (maps$UnmodifiableNavigableMap == null) {
            NavigableMap navigableMap = this.delegate.descendingMap();
            this.descendingMap = maps$UnmodifiableNavigableMap = new Maps$UnmodifiableNavigableMap(navigableMap, this);
        }
        return maps$UnmodifiableNavigableMap;
    }

    public Map.Entry firstEntry() {
        return Maps.access$800(this.delegate.firstEntry());
    }

    public Map.Entry floorEntry(Object object) {
        return Maps.access$800(this.delegate.floorEntry(object));
    }

    public Object floorKey(Object object) {
        return this.delegate.floorKey(object);
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return Maps.unmodifiableNavigableMap(this.delegate.headMap(object, bl2));
    }

    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public Map.Entry higherEntry(Object object) {
        return Maps.access$800(this.delegate.higherEntry(object));
    }

    public Object higherKey(Object object) {
        return this.delegate.higherKey(object);
    }

    public Set keySet() {
        return this.navigableKeySet();
    }

    public Map.Entry lastEntry() {
        return Maps.access$800(this.delegate.lastEntry());
    }

    public Map.Entry lowerEntry(Object object) {
        return Maps.access$800(this.delegate.lowerEntry(object));
    }

    public Object lowerKey(Object object) {
        return this.delegate.lowerKey(object);
    }

    public NavigableSet navigableKeySet() {
        return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
    }

    public final Map.Entry pollFirstEntry() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final Map.Entry pollLastEntry() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return Maps.unmodifiableNavigableMap(this.delegate.subMap(object, bl2, object2, bl3));
    }

    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return Maps.unmodifiableNavigableMap(this.delegate.tailMap(object, bl2));
    }

    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }
}

