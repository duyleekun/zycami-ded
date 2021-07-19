/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets;
import com.google.common.collect.SortedMultisets$ElementSet;
import java.util.Iterator;
import java.util.NavigableSet;

public class SortedMultisets$NavigableElementSet
extends SortedMultisets$ElementSet
implements NavigableSet {
    public SortedMultisets$NavigableElementSet(SortedMultiset sortedMultiset) {
        super(sortedMultiset);
    }

    public Object ceiling(Object object) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.CLOSED;
        return SortedMultisets.access$100(multiset.tailMultiset(object, boundType).firstEntry());
    }

    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }

    public NavigableSet descendingSet() {
        SortedMultiset sortedMultiset = this.multiset().descendingMultiset();
        SortedMultisets$NavigableElementSet sortedMultisets$NavigableElementSet = new SortedMultisets$NavigableElementSet(sortedMultiset);
        return sortedMultisets$NavigableElementSet;
    }

    public Object floor(Object object) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.CLOSED;
        return SortedMultisets.access$100(multiset.headMultiset(object, boundType).lastEntry());
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.forBoolean(bl2);
        object = multiset.headMultiset(object, boundType);
        SortedMultisets$NavigableElementSet sortedMultisets$NavigableElementSet = new SortedMultisets$NavigableElementSet((SortedMultiset)object);
        return sortedMultisets$NavigableElementSet;
    }

    public Object higher(Object object) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.OPEN;
        return SortedMultisets.access$100(multiset.tailMultiset(object, boundType).firstEntry());
    }

    public Object lower(Object object) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.OPEN;
        return SortedMultisets.access$100(multiset.headMultiset(object, boundType).lastEntry());
    }

    public Object pollFirst() {
        return SortedMultisets.access$100(this.multiset().pollFirstEntry());
    }

    public Object pollLast() {
        return SortedMultisets.access$100(this.multiset().pollLastEntry());
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.forBoolean(bl2);
        BoundType boundType2 = BoundType.forBoolean(bl3);
        object = multiset.subMultiset(object, boundType, object2, boundType2);
        SortedMultisets$NavigableElementSet sortedMultisets$NavigableElementSet = new SortedMultisets$NavigableElementSet((SortedMultiset)object);
        return sortedMultisets$NavigableElementSet;
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        Multiset multiset = this.multiset();
        BoundType boundType = BoundType.forBoolean(bl2);
        object = multiset.tailMultiset(object, boundType);
        SortedMultisets$NavigableElementSet sortedMultisets$NavigableElementSet = new SortedMultisets$NavigableElementSet((SortedMultiset)object);
        return sortedMultisets$NavigableElementSet;
    }
}

