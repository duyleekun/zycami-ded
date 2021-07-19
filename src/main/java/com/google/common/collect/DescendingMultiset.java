/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.DescendingMultiset$1EntrySetImpl;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets$NavigableElementSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

public abstract class DescendingMultiset
extends ForwardingMultiset
implements SortedMultiset {
    private transient Comparator comparator;
    private transient NavigableSet elementSet;
    private transient Set entrySet;

    public Comparator comparator() {
        Comparator comparator = this.comparator;
        if (comparator == null) {
            this.comparator = comparator = Ordering.from(this.forwardMultiset().comparator()).reverse();
        }
        return comparator;
    }

    public Set createEntrySet() {
        DescendingMultiset$1EntrySetImpl descendingMultiset$1EntrySetImpl = new DescendingMultiset$1EntrySetImpl(this);
        return descendingMultiset$1EntrySetImpl;
    }

    public Multiset delegate() {
        return this.forwardMultiset();
    }

    public SortedMultiset descendingMultiset() {
        return this.forwardMultiset();
    }

    public NavigableSet elementSet() {
        NavigableSet navigableSet = this.elementSet;
        if (navigableSet == null) {
            this.elementSet = navigableSet = new SortedMultisets$NavigableElementSet(this);
        }
        return navigableSet;
    }

    public abstract Iterator entryIterator();

    public Set entrySet() {
        Set set = this.entrySet;
        if (set == null) {
            this.entrySet = set = this.createEntrySet();
        }
        return set;
    }

    public Multiset$Entry firstEntry() {
        return this.forwardMultiset().lastEntry();
    }

    public abstract SortedMultiset forwardMultiset();

    public SortedMultiset headMultiset(Object object, BoundType boundType) {
        return this.forwardMultiset().tailMultiset(object, boundType).descendingMultiset();
    }

    public Iterator iterator() {
        return Multisets.iteratorImpl(this);
    }

    public Multiset$Entry lastEntry() {
        return this.forwardMultiset().firstEntry();
    }

    public Multiset$Entry pollFirstEntry() {
        return this.forwardMultiset().pollLastEntry();
    }

    public Multiset$Entry pollLastEntry() {
        return this.forwardMultiset().pollFirstEntry();
    }

    public SortedMultiset subMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        return this.forwardMultiset().subMultiset(object2, boundType2, object, boundType).descendingMultiset();
    }

    public SortedMultiset tailMultiset(Object object, BoundType boundType) {
        return this.forwardMultiset().headMultiset(object, boundType).descendingMultiset();
    }

    public Object[] toArray() {
        return this.standardToArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.standardToArray(objectArray);
    }

    public String toString() {
        return this.entrySet().toString();
    }
}

