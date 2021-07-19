/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSortedSet;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableSet;

public class AbstractMapBasedMultimap$WrappedNavigableSet
extends AbstractMapBasedMultimap$WrappedSortedSet
implements NavigableSet {
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$WrappedNavigableSet(AbstractMapBasedMultimap abstractMapBasedMultimap, Object object, NavigableSet navigableSet, AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, navigableSet, abstractMapBasedMultimap$WrappedCollection);
    }

    private NavigableSet wrap(NavigableSet navigableSet) {
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        Object object = this.key;
        AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection = this.getAncestor();
        abstractMapBasedMultimap$WrappedCollection = abstractMapBasedMultimap$WrappedCollection == null ? this : this.getAncestor();
        AbstractMapBasedMultimap$WrappedNavigableSet abstractMapBasedMultimap$WrappedNavigableSet = new AbstractMapBasedMultimap$WrappedNavigableSet(abstractMapBasedMultimap, object, navigableSet, abstractMapBasedMultimap$WrappedCollection);
        return abstractMapBasedMultimap$WrappedNavigableSet;
    }

    public Object ceiling(Object object) {
        return this.getSortedSetDelegate().ceiling(object);
    }

    public Iterator descendingIterator() {
        Iterator iterator2 = this.getSortedSetDelegate().descendingIterator();
        AbstractMapBasedMultimap$WrappedCollection$WrappedIterator abstractMapBasedMultimap$WrappedCollection$WrappedIterator = new AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(this, iterator2);
        return abstractMapBasedMultimap$WrappedCollection$WrappedIterator;
    }

    public NavigableSet descendingSet() {
        NavigableSet navigableSet = this.getSortedSetDelegate().descendingSet();
        return this.wrap(navigableSet);
    }

    public Object floor(Object object) {
        return this.getSortedSetDelegate().floor(object);
    }

    public NavigableSet getSortedSetDelegate() {
        return (NavigableSet)super.getSortedSetDelegate();
    }

    public NavigableSet headSet(Object navigableSet, boolean bl2) {
        navigableSet = this.getSortedSetDelegate().headSet(navigableSet, bl2);
        return this.wrap(navigableSet);
    }

    public Object higher(Object object) {
        return this.getSortedSetDelegate().higher(object);
    }

    public Object lower(Object object) {
        return this.getSortedSetDelegate().lower(object);
    }

    public Object pollFirst() {
        return Iterators.pollNext(this.iterator());
    }

    public Object pollLast() {
        return Iterators.pollNext(this.descendingIterator());
    }

    public NavigableSet subSet(Object navigableSet, boolean bl2, Object object, boolean bl3) {
        navigableSet = this.getSortedSetDelegate().subSet(navigableSet, bl2, object, bl3);
        return this.wrap(navigableSet);
    }

    public NavigableSet tailSet(Object navigableSet, boolean bl2) {
        navigableSet = this.getSortedSetDelegate().tailSet(navigableSet, bl2);
        return this.wrap(navigableSet);
    }
}

