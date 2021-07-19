/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$ElementSet;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class SortedMultisets$ElementSet
extends Multisets$ElementSet
implements SortedSet {
    private final SortedMultiset multiset;

    public SortedMultisets$ElementSet(SortedMultiset sortedMultiset) {
        this.multiset = sortedMultiset;
    }

    public Comparator comparator() {
        return this.multiset().comparator();
    }

    public Object first() {
        return SortedMultisets.access$000(this.multiset().firstEntry());
    }

    public SortedSet headSet(Object object) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.OPEN;
        return multiset.headMultiset(object, boundType).elementSet();
    }

    public Iterator iterator() {
        return Multisets.elementIterator(this.multiset().entrySet().iterator());
    }

    public Object last() {
        return SortedMultisets.access$000(this.multiset().lastEntry());
    }

    public final SortedMultiset multiset() {
        return this.multiset;
    }

    public SortedSet subSet(Object object, Object object2) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.CLOSED;
        BoundType boundType2 = BoundType.OPEN;
        return multiset.subMultiset(object, boundType, object2, boundType2).elementSet();
    }

    public SortedSet tailSet(Object object) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.CLOSED;
        return multiset.tailMultiset(object, boundType).elementSet();
    }
}

