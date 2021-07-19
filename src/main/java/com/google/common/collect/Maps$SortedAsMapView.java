/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$AsMapView;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class Maps$SortedAsMapView
extends Maps$AsMapView
implements SortedMap {
    public Maps$SortedAsMapView(SortedSet sortedSet, Function function) {
        super(sortedSet, function);
    }

    public SortedSet backingSet() {
        return (SortedSet)super.backingSet();
    }

    public Comparator comparator() {
        return this.backingSet().comparator();
    }

    public Object firstKey() {
        return this.backingSet().first();
    }

    public SortedMap headMap(Object sortedSet) {
        sortedSet = this.backingSet().headSet(sortedSet);
        Function function = this.function;
        return Maps.asMap(sortedSet, function);
    }

    public Set keySet() {
        return Maps.access$300((SortedSet)this.backingSet());
    }

    public Object lastKey() {
        return this.backingSet().last();
    }

    public SortedMap subMap(Object sortedSet, Object object) {
        sortedSet = this.backingSet().subSet(sortedSet, object);
        object = this.function;
        return Maps.asMap(sortedSet, (Function)object);
    }

    public SortedMap tailMap(Object sortedSet) {
        sortedSet = this.backingSet().tailSet(sortedSet);
        Function function = this.function;
        return Maps.asMap(sortedSet, function);
    }
}

