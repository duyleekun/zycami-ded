/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;

public final class Maps$NavigableAsMapView
extends AbstractNavigableMap {
    private final Function function;
    private final NavigableSet set;

    public Maps$NavigableAsMapView(NavigableSet object, Function function) {
        object = (NavigableSet)Preconditions.checkNotNull(object);
        this.set = object;
        this.function = object = (Function)Preconditions.checkNotNull(function);
    }

    public void clear() {
        this.set.clear();
    }

    public Comparator comparator() {
        return this.set.comparator();
    }

    public Iterator descendingEntryIterator() {
        return this.descendingMap().entrySet().iterator();
    }

    public NavigableMap descendingMap() {
        NavigableSet navigableSet = this.set.descendingSet();
        Function function = this.function;
        return Maps.asMap(navigableSet, function);
    }

    public Iterator entryIterator() {
        NavigableSet navigableSet = this.set;
        Function function = this.function;
        return Maps.asMapEntryIterator(navigableSet, function);
    }

    public Object get(Object object) {
        NavigableSet navigableSet = this.set;
        boolean bl2 = Collections2.safeContains(navigableSet, object);
        if (bl2) {
            return this.function.apply(object);
        }
        return null;
    }

    public NavigableMap headMap(Object navigableSet, boolean bl2) {
        navigableSet = this.set.headSet(navigableSet, bl2);
        Function function = this.function;
        return Maps.asMap(navigableSet, function);
    }

    public NavigableSet navigableKeySet() {
        return Maps.access$400(this.set);
    }

    public int size() {
        return this.set.size();
    }

    public NavigableMap subMap(Object navigableSet, boolean bl2, Object object, boolean bl3) {
        navigableSet = this.set.subSet(navigableSet, bl2, object, bl3);
        Function function = this.function;
        return Maps.asMap(navigableSet, function);
    }

    public NavigableMap tailMap(Object navigableSet, boolean bl2) {
        navigableSet = this.set.tailSet(navigableSet, bl2);
        Function function = this.function;
        return Maps.asMap(navigableSet, function);
    }
}

