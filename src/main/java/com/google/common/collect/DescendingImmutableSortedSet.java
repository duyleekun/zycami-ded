/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;

public final class DescendingImmutableSortedSet
extends ImmutableSortedSet {
    private final ImmutableSortedSet forward;

    public DescendingImmutableSortedSet(ImmutableSortedSet immutableSortedSet) {
        Ordering ordering = Ordering.from(immutableSortedSet.comparator()).reverse();
        super(ordering);
        this.forward = immutableSortedSet;
    }

    public Object ceiling(Object object) {
        return this.forward.floor(object);
    }

    public boolean contains(Object object) {
        return this.forward.contains(object);
    }

    public ImmutableSortedSet createDescendingSet() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public UnmodifiableIterator descendingIterator() {
        return this.forward.iterator();
    }

    public ImmutableSortedSet descendingSet() {
        return this.forward;
    }

    public Object floor(Object object) {
        return this.forward.ceiling(object);
    }

    public ImmutableSortedSet headSetImpl(Object object, boolean bl2) {
        return this.forward.tailSet(object, bl2).descendingSet();
    }

    public Object higher(Object object) {
        return this.forward.lower(object);
    }

    public int indexOf(Object object) {
        int n10;
        ImmutableSortedSet immutableSortedSet = this.forward;
        int n11 = immutableSortedSet.indexOf(object);
        if (n11 == (n10 = -1)) {
            return n11;
        }
        return this.size() + -1 - n11;
    }

    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    public UnmodifiableIterator iterator() {
        return this.forward.descendingIterator();
    }

    public Object lower(Object object) {
        return this.forward.higher(object);
    }

    public int size() {
        return this.forward.size();
    }

    public ImmutableSortedSet subSetImpl(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.forward.subSet(object2, bl3, object, bl2).descendingSet();
    }

    public ImmutableSortedSet tailSetImpl(Object object, boolean bl2) {
        return this.forward.headSet(object, bl2).descendingSet();
    }
}

