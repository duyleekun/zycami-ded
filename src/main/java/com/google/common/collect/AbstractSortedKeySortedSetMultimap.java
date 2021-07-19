/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractSortedSetMultimap;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public abstract class AbstractSortedKeySortedSetMultimap
extends AbstractSortedSetMultimap {
    public AbstractSortedKeySortedSetMultimap(SortedMap sortedMap) {
        super(sortedMap);
    }

    public SortedMap asMap() {
        return (SortedMap)super.asMap();
    }

    public SortedMap backingMap() {
        return (SortedMap)super.backingMap();
    }

    public Set createKeySet() {
        return this.createMaybeNavigableKeySet();
    }

    public SortedSet keySet() {
        return (SortedSet)super.keySet();
    }
}

