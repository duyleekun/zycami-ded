/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public final class Sets$UnmodifiableNavigableSet
extends ForwardingSortedSet
implements NavigableSet,
Serializable {
    private static final long serialVersionUID;
    private final NavigableSet delegate;
    private transient Sets$UnmodifiableNavigableSet descendingSet;
    private final SortedSet unmodifiableDelegate;

    public Sets$UnmodifiableNavigableSet(NavigableSet sortedSet) {
        NavigableSet navigableSet;
        this.delegate = navigableSet = (NavigableSet)Preconditions.checkNotNull(sortedSet);
        sortedSet = Collections.unmodifiableSortedSet(sortedSet);
        this.unmodifiableDelegate = sortedSet;
    }

    public Object ceiling(Object object) {
        return this.delegate.ceiling(object);
    }

    public SortedSet delegate() {
        return this.unmodifiableDelegate;
    }

    public Iterator descendingIterator() {
        return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
    }

    public NavigableSet descendingSet() {
        Sets$UnmodifiableNavigableSet sets$UnmodifiableNavigableSet = this.descendingSet;
        if (sets$UnmodifiableNavigableSet == null) {
            NavigableSet navigableSet = this.delegate.descendingSet();
            this.descendingSet = sets$UnmodifiableNavigableSet = new Sets$UnmodifiableNavigableSet(navigableSet);
            sets$UnmodifiableNavigableSet.descendingSet = this;
        }
        return sets$UnmodifiableNavigableSet;
    }

    public Object floor(Object object) {
        return this.delegate.floor(object);
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return Sets.unmodifiableNavigableSet(this.delegate.headSet(object, bl2));
    }

    public Object higher(Object object) {
        return this.delegate.higher(object);
    }

    public Object lower(Object object) {
        return this.delegate.lower(object);
    }

    public Object pollFirst() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Object pollLast() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return Sets.unmodifiableNavigableSet(this.delegate.subSet(object, bl2, object2, bl3));
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return Sets.unmodifiableNavigableSet(this.delegate.tailSet(object, bl2));
    }
}

