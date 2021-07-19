/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimaps$UnmodifiableSetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;

public class Multimaps$UnmodifiableSortedSetMultimap
extends Multimaps$UnmodifiableSetMultimap
implements SortedSetMultimap {
    private static final long serialVersionUID;

    public Multimaps$UnmodifiableSortedSetMultimap(SortedSetMultimap sortedSetMultimap) {
        super(sortedSetMultimap);
    }

    public SortedSetMultimap delegate() {
        return (SortedSetMultimap)super.delegate();
    }

    public SortedSet get(Object object) {
        return Collections.unmodifiableSortedSet(this.delegate().get(object));
    }

    public SortedSet removeAll(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public SortedSet replaceValues(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Comparator valueComparator() {
        return this.delegate().valueComparator();
    }
}

