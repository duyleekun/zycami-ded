/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets$FilteredSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class Sets$FilteredSortedSet
extends Sets$FilteredSet
implements SortedSet {
    public Sets$FilteredSortedSet(SortedSet sortedSet, Predicate predicate) {
        super(sortedSet, predicate);
    }

    public Comparator comparator() {
        return ((SortedSet)this.unfiltered).comparator();
    }

    public Object first() {
        Iterator iterator2 = this.unfiltered.iterator();
        Predicate predicate = this.predicate;
        return Iterators.find(iterator2, predicate);
    }

    public SortedSet headSet(Object sortedSet) {
        sortedSet = ((SortedSet)this.unfiltered).headSet(sortedSet);
        Predicate predicate = this.predicate;
        Sets$FilteredSortedSet sets$FilteredSortedSet = new Sets$FilteredSortedSet(sortedSet, predicate);
        return sets$FilteredSortedSet;
    }

    public Object last() {
        SortedSet sortedSet = (SortedSet)this.unfiltered;
        Object e10;
        Predicate predicate;
        boolean bl2;
        while (!(bl2 = (predicate = this.predicate).apply(e10 = sortedSet.last()))) {
            sortedSet = sortedSet.headSet(e10);
        }
        return e10;
    }

    public SortedSet subSet(Object sortedSet, Object object) {
        sortedSet = ((SortedSet)this.unfiltered).subSet(sortedSet, object);
        object = this.predicate;
        Sets$FilteredSortedSet sets$FilteredSortedSet = new Sets$FilteredSortedSet(sortedSet, (Predicate)object);
        return sets$FilteredSortedSet;
    }

    public SortedSet tailSet(Object sortedSet) {
        sortedSet = ((SortedSet)this.unfiltered).tailSet(sortedSet);
        Predicate predicate = this.predicate;
        Sets$FilteredSortedSet sets$FilteredSortedSet = new Sets$FilteredSortedSet(sortedSet, predicate);
        return sets$FilteredSortedSet;
    }
}

