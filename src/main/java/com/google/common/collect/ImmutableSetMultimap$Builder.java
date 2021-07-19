/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Platform;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public final class ImmutableSetMultimap$Builder
extends ImmutableMultimap$Builder {
    public ImmutableSetMultimap build() {
        Collection collection = this.builderMap.entrySet();
        Comparator comparator = this.keyComparator;
        if (comparator != null) {
            comparator = Ordering.from(comparator).onKeys();
            collection = ((Ordering)comparator).immutableSortedCopy(collection);
        }
        comparator = this.valueComparator;
        return ImmutableSetMultimap.fromMapEntries(collection, comparator);
    }

    public Collection newMutableValueCollection() {
        return Platform.preservesInsertionOrderOnAddsSet();
    }

    public ImmutableSetMultimap$Builder orderKeysBy(Comparator comparator) {
        super.orderKeysBy(comparator);
        return this;
    }

    public ImmutableSetMultimap$Builder orderValuesBy(Comparator comparator) {
        super.orderValuesBy(comparator);
        return this;
    }

    public ImmutableSetMultimap$Builder put(Object object, Object object2) {
        super.put(object, object2);
        return this;
    }

    public ImmutableSetMultimap$Builder put(Map.Entry entry) {
        super.put(entry);
        return this;
    }

    public ImmutableSetMultimap$Builder putAll(Multimap object) {
        boolean bl2;
        object = object.asMap().entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Object k10 = object2.getKey();
            object2 = (Iterable)object2.getValue();
            this.putAll(k10, (Iterable)object2);
        }
        return this;
    }

    public ImmutableSetMultimap$Builder putAll(Iterable iterable) {
        super.putAll(iterable);
        return this;
    }

    public ImmutableSetMultimap$Builder putAll(Object object, Iterable iterable) {
        super.putAll(object, iterable);
        return this;
    }

    public ImmutableSetMultimap$Builder putAll(Object object, Object ... object2) {
        object2 = Arrays.asList(object2);
        return this.putAll(object, (Iterable)object2);
    }
}

