/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$SortedAsMap;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;

public class AbstractMapBasedMultimap$NavigableAsMap
extends AbstractMapBasedMultimap$SortedAsMap
implements NavigableMap {
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$NavigableAsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap navigableMap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, navigableMap);
    }

    public Map.Entry ceilingEntry(Object entry) {
        NavigableMap navigableMap = this.sortedMap();
        entry = navigableMap.ceilingEntry(entry);
        entry = entry == null ? null : this.wrapEntry(entry);
        return entry;
    }

    public Object ceilingKey(Object object) {
        return this.sortedMap().ceilingKey(object);
    }

    public NavigableSet createKeySet() {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        NavigableMap navigableMap = this.sortedMap();
        AbstractMapBasedMultimap$NavigableKeySet abstractMapBasedMultimap$NavigableKeySet = new AbstractMapBasedMultimap$NavigableKeySet(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableKeySet;
    }

    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    public NavigableMap descendingMap() {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        NavigableMap navigableMap = this.sortedMap().descendingMap();
        AbstractMapBasedMultimap$NavigableAsMap abstractMapBasedMultimap$NavigableAsMap = new AbstractMapBasedMultimap$NavigableAsMap(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableAsMap;
    }

    public Map.Entry firstEntry() {
        Map.Entry entry = this.sortedMap().firstEntry();
        entry = entry == null ? null : this.wrapEntry(entry);
        return entry;
    }

    public Map.Entry floorEntry(Object entry) {
        NavigableMap navigableMap = this.sortedMap();
        entry = navigableMap.floorEntry(entry);
        entry = entry == null ? null : this.wrapEntry(entry);
        return entry;
    }

    public Object floorKey(Object object) {
        return this.sortedMap().floorKey(object);
    }

    public NavigableMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public NavigableMap headMap(Object navigableMap, boolean bl2) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        navigableMap = this.sortedMap().headMap(navigableMap, bl2);
        AbstractMapBasedMultimap$NavigableAsMap abstractMapBasedMultimap$NavigableAsMap = new AbstractMapBasedMultimap$NavigableAsMap(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableAsMap;
    }

    public Map.Entry higherEntry(Object entry) {
        NavigableMap navigableMap = this.sortedMap();
        entry = navigableMap.higherEntry(entry);
        entry = entry == null ? null : this.wrapEntry(entry);
        return entry;
    }

    public Object higherKey(Object object) {
        return this.sortedMap().higherKey(object);
    }

    public NavigableSet keySet() {
        return (NavigableSet)super.keySet();
    }

    public Map.Entry lastEntry() {
        Map.Entry entry = this.sortedMap().lastEntry();
        entry = entry == null ? null : this.wrapEntry(entry);
        return entry;
    }

    public Map.Entry lowerEntry(Object entry) {
        NavigableMap navigableMap = this.sortedMap();
        entry = navigableMap.lowerEntry(entry);
        entry = entry == null ? null : this.wrapEntry(entry);
        return entry;
    }

    public Object lowerKey(Object object) {
        return this.sortedMap().lowerKey(object);
    }

    public NavigableSet navigableKeySet() {
        return this.keySet();
    }

    public Map.Entry pollAsMapEntry(Iterator iterator2) {
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return null;
        }
        Object object = (Map.Entry)iterator2.next();
        Collection collection = this.this$0.createCollection();
        Collection collection2 = (Collection)object.getValue();
        collection.addAll(collection2);
        iterator2.remove();
        iterator2 = object.getKey();
        object = this.this$0.unmodifiableCollectionSubclass(collection);
        return Maps.immutableEntry(iterator2, object);
    }

    public Map.Entry pollFirstEntry() {
        Iterator iterator2 = this.entrySet().iterator();
        return this.pollAsMapEntry(iterator2);
    }

    public Map.Entry pollLastEntry() {
        Iterator iterator2 = this.descendingMap().entrySet().iterator();
        return this.pollAsMapEntry(iterator2);
    }

    public NavigableMap sortedMap() {
        return (NavigableMap)super.sortedMap();
    }

    public NavigableMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public NavigableMap subMap(Object navigableMap, boolean bl2, Object object, boolean bl3) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        navigableMap = this.sortedMap().subMap(navigableMap, bl2, object, bl3);
        AbstractMapBasedMultimap$NavigableAsMap abstractMapBasedMultimap$NavigableAsMap = new AbstractMapBasedMultimap$NavigableAsMap(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableAsMap;
    }

    public NavigableMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    public NavigableMap tailMap(Object navigableMap, boolean bl2) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        navigableMap = this.sortedMap().tailMap(navigableMap, bl2);
        AbstractMapBasedMultimap$NavigableAsMap abstractMapBasedMultimap$NavigableAsMap = new AbstractMapBasedMultimap$NavigableAsMap(abstractMapBasedMultimap, navigableMap);
        return abstractMapBasedMultimap$NavigableAsMap;
    }
}

