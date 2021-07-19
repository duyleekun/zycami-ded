/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSortedSet;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;

public final class ImmutableSortedSet$Builder
extends ImmutableSet$Builder {
    private final Comparator comparator;

    public ImmutableSortedSet$Builder(Comparator comparator) {
        this.comparator = comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    public ImmutableSortedSet$Builder add(Object object) {
        super.add(object);
        return this;
    }

    public ImmutableSortedSet$Builder add(Object ... objectArray) {
        super.add(objectArray);
        return this;
    }

    public ImmutableSortedSet$Builder addAll(Iterable iterable) {
        super.addAll(iterable);
        return this;
    }

    public ImmutableSortedSet$Builder addAll(Iterator iterator2) {
        super.addAll(iterator2);
        return this;
    }

    public ImmutableSortedSet build() {
        int n10;
        Object object = this.contents;
        Comparator comparator = this.comparator;
        int n11 = this.size;
        object = ImmutableSortedSet.construct(comparator, n11, (Object[])object);
        this.size = n10 = ((AbstractCollection)object).size();
        this.forceCopy = true;
        return object;
    }
}

