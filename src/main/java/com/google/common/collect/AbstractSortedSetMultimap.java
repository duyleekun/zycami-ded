/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedNavigableSet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSortedSet;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class AbstractSortedSetMultimap
extends AbstractSetMultimap
implements SortedSetMultimap {
    private static final long serialVersionUID = 430848587173315748L;

    public AbstractSortedSetMultimap(Map map) {
        super(map);
    }

    public Map asMap() {
        return super.asMap();
    }

    public abstract SortedSet createCollection();

    public SortedSet createUnmodifiableEmptyCollection() {
        Collection collection = this.createCollection();
        return this.unmodifiableCollectionSubclass(collection);
    }

    public SortedSet get(Object object) {
        return (SortedSet)super.get(object);
    }

    public SortedSet removeAll(Object object) {
        return (SortedSet)super.removeAll(object);
    }

    public SortedSet replaceValues(Object object, Iterable iterable) {
        return (SortedSet)super.replaceValues(object, iterable);
    }

    public SortedSet unmodifiableCollectionSubclass(Collection collection) {
        boolean bl2 = collection instanceof NavigableSet;
        if (bl2) {
            return Sets.unmodifiableNavigableSet((NavigableSet)collection);
        }
        return Collections.unmodifiableSortedSet((SortedSet)collection);
    }

    public Collection values() {
        return super.values();
    }

    public Collection wrapCollection(Object object, Collection collection) {
        boolean bl2 = collection instanceof NavigableSet;
        if (bl2) {
            collection = (NavigableSet)collection;
            AbstractMapBasedMultimap$WrappedNavigableSet abstractMapBasedMultimap$WrappedNavigableSet = new AbstractMapBasedMultimap$WrappedNavigableSet((AbstractMapBasedMultimap)this, object, (NavigableSet)collection, null);
            return abstractMapBasedMultimap$WrappedNavigableSet;
        }
        collection = (SortedSet)collection;
        AbstractMapBasedMultimap$WrappedSortedSet abstractMapBasedMultimap$WrappedSortedSet = new AbstractMapBasedMultimap$WrappedSortedSet((AbstractMapBasedMultimap)this, object, (SortedSet)collection, null);
        return abstractMapBasedMultimap$WrappedSortedSet;
    }
}

