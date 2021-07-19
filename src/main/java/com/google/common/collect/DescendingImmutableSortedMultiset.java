/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset$Entry;

public final class DescendingImmutableSortedMultiset
extends ImmutableSortedMultiset {
    private final transient ImmutableSortedMultiset forward;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    public int count(Object object) {
        return this.forward.count(object);
    }

    public ImmutableSortedMultiset descendingMultiset() {
        return this.forward;
    }

    public ImmutableSortedSet elementSet() {
        return ((ImmutableSortedSet)this.forward.elementSet()).descendingSet();
    }

    public Multiset$Entry firstEntry() {
        return this.forward.lastEntry();
    }

    public Multiset$Entry getEntry(int n10) {
        return (Multiset$Entry)this.forward.entrySet().asList().reverse().get(n10);
    }

    public ImmutableSortedMultiset headMultiset(Object object, BoundType boundType) {
        return this.forward.tailMultiset(object, boundType).descendingMultiset();
    }

    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    public Multiset$Entry lastEntry() {
        return this.forward.firstEntry();
    }

    public int size() {
        return this.forward.size();
    }

    public ImmutableSortedMultiset tailMultiset(Object object, BoundType boundType) {
        return this.forward.headMultiset(object, boundType).descendingMultiset();
    }
}

