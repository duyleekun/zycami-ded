/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import java.util.Comparator;
import java.util.SortedSet;

public class AbstractMapBasedMultimap$WrappedSortedSet
extends AbstractMapBasedMultimap$WrappedCollection
implements SortedSet {
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$WrappedSortedSet(AbstractMapBasedMultimap abstractMapBasedMultimap, Object object, SortedSet sortedSet, AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, sortedSet, abstractMapBasedMultimap$WrappedCollection);
    }

    public Comparator comparator() {
        return this.getSortedSetDelegate().comparator();
    }

    public Object first() {
        this.refreshIfEmpty();
        return this.getSortedSetDelegate().first();
    }

    public SortedSet getSortedSetDelegate() {
        return (SortedSet)this.getDelegate();
    }

    public SortedSet headSet(Object sortedSet) {
        this.refreshIfEmpty();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        Object object = this.getKey();
        sortedSet = this.getSortedSetDelegate().headSet(sortedSet);
        AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection = this.getAncestor();
        abstractMapBasedMultimap$WrappedCollection = abstractMapBasedMultimap$WrappedCollection == null ? this : this.getAncestor();
        AbstractMapBasedMultimap$WrappedSortedSet abstractMapBasedMultimap$WrappedSortedSet = new AbstractMapBasedMultimap$WrappedSortedSet(abstractMapBasedMultimap, object, sortedSet, abstractMapBasedMultimap$WrappedCollection);
        return abstractMapBasedMultimap$WrappedSortedSet;
    }

    public Object last() {
        this.refreshIfEmpty();
        return this.getSortedSetDelegate().last();
    }

    public SortedSet subSet(Object sortedSet, Object object) {
        this.refreshIfEmpty();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        Object object2 = this.getKey();
        SortedSet sortedSet2 = this.getSortedSetDelegate();
        sortedSet = sortedSet2.subSet(sortedSet, object);
        object = this.getAncestor();
        object = object == null ? this : this.getAncestor();
        AbstractMapBasedMultimap$WrappedSortedSet abstractMapBasedMultimap$WrappedSortedSet = new AbstractMapBasedMultimap$WrappedSortedSet(abstractMapBasedMultimap, object2, sortedSet, (AbstractMapBasedMultimap$WrappedCollection)object);
        return abstractMapBasedMultimap$WrappedSortedSet;
    }

    public SortedSet tailSet(Object sortedSet) {
        this.refreshIfEmpty();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        Object object = this.getKey();
        sortedSet = this.getSortedSetDelegate().tailSet(sortedSet);
        AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection = this.getAncestor();
        abstractMapBasedMultimap$WrappedCollection = abstractMapBasedMultimap$WrappedCollection == null ? this : this.getAncestor();
        AbstractMapBasedMultimap$WrappedSortedSet abstractMapBasedMultimap$WrappedSortedSet = new AbstractMapBasedMultimap$WrappedSortedSet(abstractMapBasedMultimap, object, sortedSet, abstractMapBasedMultimap$WrappedCollection);
        return abstractMapBasedMultimap$WrappedSortedSet;
    }
}

