/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class AbstractMapBasedMultimap$SortedAsMap
extends AbstractMapBasedMultimap$AsMap
implements SortedMap {
    public SortedSet sortedKeySet;
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$SortedAsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap sortedMap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, sortedMap);
    }

    public Comparator comparator() {
        return this.sortedMap().comparator();
    }

    public SortedSet createKeySet() {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        SortedMap sortedMap = this.sortedMap();
        AbstractMapBasedMultimap$SortedKeySet abstractMapBasedMultimap$SortedKeySet = new AbstractMapBasedMultimap$SortedKeySet(abstractMapBasedMultimap, sortedMap);
        return abstractMapBasedMultimap$SortedKeySet;
    }

    public Object firstKey() {
        return this.sortedMap().firstKey();
    }

    public SortedMap headMap(Object sortedMap) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        sortedMap = this.sortedMap().headMap(sortedMap);
        AbstractMapBasedMultimap$SortedAsMap abstractMapBasedMultimap$SortedAsMap = new AbstractMapBasedMultimap$SortedAsMap(abstractMapBasedMultimap, sortedMap);
        return abstractMapBasedMultimap$SortedAsMap;
    }

    public SortedSet keySet() {
        Set set = this.sortedKeySet;
        if (set == null) {
            this.sortedKeySet = set = this.createKeySet();
        }
        return set;
    }

    public Object lastKey() {
        return this.sortedMap().lastKey();
    }

    public SortedMap sortedMap() {
        return (SortedMap)this.submap;
    }

    public SortedMap subMap(Object sortedMap, Object object) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        sortedMap = this.sortedMap().subMap(sortedMap, object);
        AbstractMapBasedMultimap$SortedAsMap abstractMapBasedMultimap$SortedAsMap = new AbstractMapBasedMultimap$SortedAsMap(abstractMapBasedMultimap, sortedMap);
        return abstractMapBasedMultimap$SortedAsMap;
    }

    public SortedMap tailMap(Object sortedMap) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        sortedMap = this.sortedMap().tailMap(sortedMap);
        AbstractMapBasedMultimap$SortedAsMap abstractMapBasedMultimap$SortedAsMap = new AbstractMapBasedMultimap$SortedAsMap(abstractMapBasedMultimap, sortedMap);
        return abstractMapBasedMultimap$SortedAsMap;
    }
}

