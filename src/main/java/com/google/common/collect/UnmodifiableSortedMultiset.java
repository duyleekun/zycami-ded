/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$UnmodifiableMultiset;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedMultiset;
import java.util.Comparator;
import java.util.NavigableSet;

public final class UnmodifiableSortedMultiset
extends Multisets$UnmodifiableMultiset
implements SortedMultiset {
    private static final long serialVersionUID;
    private transient UnmodifiableSortedMultiset descendingMultiset;

    public UnmodifiableSortedMultiset(SortedMultiset sortedMultiset) {
        super(sortedMultiset);
    }

    public Comparator comparator() {
        return this.delegate().comparator();
    }

    public NavigableSet createElementSet() {
        return Sets.unmodifiableNavigableSet(this.delegate().elementSet());
    }

    public SortedMultiset delegate() {
        return (SortedMultiset)super.delegate();
    }

    public SortedMultiset descendingMultiset() {
        UnmodifiableSortedMultiset unmodifiableSortedMultiset = this.descendingMultiset;
        if (unmodifiableSortedMultiset == null) {
            SortedMultiset sortedMultiset = this.delegate().descendingMultiset();
            unmodifiableSortedMultiset = new UnmodifiableSortedMultiset(sortedMultiset);
            unmodifiableSortedMultiset.descendingMultiset = this;
            this.descendingMultiset = unmodifiableSortedMultiset;
        }
        return unmodifiableSortedMultiset;
    }

    public NavigableSet elementSet() {
        return (NavigableSet)super.elementSet();
    }

    public Multiset$Entry firstEntry() {
        return this.delegate().firstEntry();
    }

    public SortedMultiset headMultiset(Object object, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().headMultiset(object, boundType));
    }

    public Multiset$Entry lastEntry() {
        return this.delegate().lastEntry();
    }

    public Multiset$Entry pollFirstEntry() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Multiset$Entry pollLastEntry() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public SortedMultiset subMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().subMultiset(object, boundType, object2, boundType2));
    }

    public SortedMultiset tailMultiset(Object object, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().tailMultiset(object, boundType));
    }
}

