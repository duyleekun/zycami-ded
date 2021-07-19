/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;
import java.util.SortedSet;

public abstract class ForwardingSortedSetMultimap
extends ForwardingSetMultimap
implements SortedSetMultimap {
    public abstract SortedSetMultimap delegate();

    public SortedSet get(Object object) {
        return this.delegate().get(object);
    }

    public SortedSet removeAll(Object object) {
        return this.delegate().removeAll(object);
    }

    public SortedSet replaceValues(Object object, Iterable iterable) {
        return this.delegate().replaceValues(object, iterable);
    }

    public Comparator valueComparator() {
        return this.delegate().valueComparator();
    }
}

