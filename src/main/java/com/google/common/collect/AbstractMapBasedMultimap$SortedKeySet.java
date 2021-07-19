/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

public class AbstractMapBasedMultimap$SortedKeySet
extends AbstractMapBasedMultimap$KeySet
implements SortedSet {
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$SortedKeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap sortedMap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, sortedMap);
    }

    public Comparator comparator() {
        return this.sortedMap().comparator();
    }

    public Object first() {
        return this.sortedMap().firstKey();
    }

    public SortedSet headSet(Object sortedMap) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        sortedMap = this.sortedMap().headMap(sortedMap);
        AbstractMapBasedMultimap$SortedKeySet abstractMapBasedMultimap$SortedKeySet = new AbstractMapBasedMultimap$SortedKeySet(abstractMapBasedMultimap, sortedMap);
        return abstractMapBasedMultimap$SortedKeySet;
    }

    public Object last() {
        return this.sortedMap().lastKey();
    }

    public SortedMap sortedMap() {
        return (SortedMap)super.map();
    }

    public SortedSet subSet(Object sortedMap, Object object) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        sortedMap = this.sortedMap().subMap(sortedMap, object);
        AbstractMapBasedMultimap$SortedKeySet abstractMapBasedMultimap$SortedKeySet = new AbstractMapBasedMultimap$SortedKeySet(abstractMapBasedMultimap, sortedMap);
        return abstractMapBasedMultimap$SortedKeySet;
    }

    public SortedSet tailSet(Object sortedMap) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        sortedMap = this.sortedMap().tailMap(sortedMap);
        AbstractMapBasedMultimap$SortedKeySet abstractMapBasedMultimap$SortedKeySet = new AbstractMapBasedMultimap$SortedKeySet(abstractMapBasedMultimap, sortedMap);
        return abstractMapBasedMultimap$SortedKeySet;
    }
}

