/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

public abstract class ForwardingSortedMultiset
extends ForwardingMultiset
implements SortedMultiset {
    public Comparator comparator() {
        return this.delegate().comparator();
    }

    public abstract SortedMultiset delegate();

    public SortedMultiset descendingMultiset() {
        return this.delegate().descendingMultiset();
    }

    public NavigableSet elementSet() {
        return this.delegate().elementSet();
    }

    public Multiset$Entry firstEntry() {
        return this.delegate().firstEntry();
    }

    public SortedMultiset headMultiset(Object object, BoundType boundType) {
        return this.delegate().headMultiset(object, boundType);
    }

    public Multiset$Entry lastEntry() {
        return this.delegate().lastEntry();
    }

    public Multiset$Entry pollFirstEntry() {
        return this.delegate().pollFirstEntry();
    }

    public Multiset$Entry pollLastEntry() {
        return this.delegate().pollLastEntry();
    }

    public Multiset$Entry standardFirstEntry() {
        Iterator iterator2 = this.entrySet().iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return null;
        }
        iterator2 = (Multiset$Entry)iterator2.next();
        Object object = iterator2.getElement();
        int n10 = iterator2.getCount();
        return Multisets.immutableEntry(object, n10);
    }

    public Multiset$Entry standardLastEntry() {
        Iterator iterator2 = this.descendingMultiset().entrySet().iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return null;
        }
        iterator2 = (Multiset$Entry)iterator2.next();
        Object object = iterator2.getElement();
        int n10 = iterator2.getCount();
        return Multisets.immutableEntry(object, n10);
    }

    public Multiset$Entry standardPollFirstEntry() {
        Iterator iterator2 = this.entrySet().iterator();
        int n10 = iterator2.hasNext();
        if (n10 == 0) {
            return null;
        }
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator2.next();
        Object object = multiset$Entry.getElement();
        n10 = multiset$Entry.getCount();
        multiset$Entry = Multisets.immutableEntry(object, n10);
        iterator2.remove();
        return multiset$Entry;
    }

    public Multiset$Entry standardPollLastEntry() {
        Iterator iterator2 = this.descendingMultiset().entrySet().iterator();
        int n10 = iterator2.hasNext();
        if (n10 == 0) {
            return null;
        }
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator2.next();
        Object object = multiset$Entry.getElement();
        n10 = multiset$Entry.getCount();
        multiset$Entry = Multisets.immutableEntry(object, n10);
        iterator2.remove();
        return multiset$Entry;
    }

    public SortedMultiset standardSubMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        return this.tailMultiset(object, boundType).headMultiset(object2, boundType2);
    }

    public SortedMultiset subMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        return this.delegate().subMultiset(object, boundType, object2, boundType2);
    }

    public SortedMultiset tailMultiset(Object object, BoundType boundType) {
        return this.delegate().tailMultiset(object, boundType);
    }
}

