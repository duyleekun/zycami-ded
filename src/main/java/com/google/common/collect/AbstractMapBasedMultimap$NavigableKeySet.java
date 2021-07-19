/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;

public class AbstractMapBasedMultimap$NavigableKeySet
extends AbstractMapBasedMultimap$SortedKeySet
implements NavigableSet {
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$NavigableKeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap navigableMap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, navigableMap);
    }

    public Object ceiling(Object object) {
        return this.sortedMap().ceilingKey(object);
    }

    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }

    public NavigableSet descendingSet() {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        NavigableMap navigableMap = this.sortedMap().descendingMap();
        AbstractMapBasedMultimap$NavigableKeySet abstractMapBasedMultimap$NavigableKeySet = new AbstractMapBasedMultimap$NavigableKeySet(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableKeySet;
    }

    public Object floor(Object object) {
        return this.sortedMap().floorKey(object);
    }

    public NavigableSet headSet(Object object) {
        return this.headSet(object, false);
    }

    public NavigableSet headSet(Object navigableMap, boolean bl2) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        navigableMap = this.sortedMap().headMap(navigableMap, bl2);
        AbstractMapBasedMultimap$NavigableKeySet abstractMapBasedMultimap$NavigableKeySet = new AbstractMapBasedMultimap$NavigableKeySet(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableKeySet;
    }

    public Object higher(Object object) {
        return this.sortedMap().higherKey(object);
    }

    public Object lower(Object object) {
        return this.sortedMap().lowerKey(object);
    }

    public Object pollFirst() {
        return Iterators.pollNext(this.iterator());
    }

    public Object pollLast() {
        return Iterators.pollNext(this.descendingIterator());
    }

    public NavigableMap sortedMap() {
        return (NavigableMap)super.sortedMap();
    }

    public NavigableSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    public NavigableSet subSet(Object navigableMap, boolean bl2, Object object, boolean bl3) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        navigableMap = this.sortedMap().subMap(navigableMap, bl2, object, bl3);
        AbstractMapBasedMultimap$NavigableKeySet abstractMapBasedMultimap$NavigableKeySet = new AbstractMapBasedMultimap$NavigableKeySet(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableKeySet;
    }

    public NavigableSet tailSet(Object object) {
        return this.tailSet(object, true);
    }

    public NavigableSet tailSet(Object navigableMap, boolean bl2) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        navigableMap = this.sortedMap().tailMap(navigableMap, bl2);
        AbstractMapBasedMultimap$NavigableKeySet abstractMapBasedMultimap$NavigableKeySet = new AbstractMapBasedMultimap$NavigableKeySet(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableKeySet;
    }
}

