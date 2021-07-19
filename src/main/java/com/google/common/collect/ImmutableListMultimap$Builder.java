/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.Multimap;
import java.util.Comparator;
import java.util.Map;

public final class ImmutableListMultimap$Builder
extends ImmutableMultimap$Builder {
    public ImmutableListMultimap build() {
        return (ImmutableListMultimap)super.build();
    }

    public ImmutableListMultimap$Builder orderKeysBy(Comparator comparator) {
        super.orderKeysBy(comparator);
        return this;
    }

    public ImmutableListMultimap$Builder orderValuesBy(Comparator comparator) {
        super.orderValuesBy(comparator);
        return this;
    }

    public ImmutableListMultimap$Builder put(Object object, Object object2) {
        super.put(object, object2);
        return this;
    }

    public ImmutableListMultimap$Builder put(Map.Entry entry) {
        super.put(entry);
        return this;
    }

    public ImmutableListMultimap$Builder putAll(Multimap multimap) {
        super.putAll(multimap);
        return this;
    }

    public ImmutableListMultimap$Builder putAll(Iterable iterable) {
        super.putAll(iterable);
        return this;
    }

    public ImmutableListMultimap$Builder putAll(Object object, Iterable iterable) {
        super.putAll(object, iterable);
        return this;
    }

    public ImmutableListMultimap$Builder putAll(Object object, Object ... objectArray) {
        super.putAll(object, objectArray);
        return this;
    }
}

