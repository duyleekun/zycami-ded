/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

public final class TreeRangeMap$1
implements RangeMap {
    public Map asDescendingMapOfRanges() {
        return Collections.emptyMap();
    }

    public Map asMapOfRanges() {
        return Collections.emptyMap();
    }

    public void clear() {
    }

    public Object get(Comparable comparable) {
        return null;
    }

    public Map.Entry getEntry(Comparable comparable) {
        return null;
    }

    public void put(Range object, Object object2) {
        Preconditions.checkNotNull(object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot insert range ");
        stringBuilder.append(object);
        stringBuilder.append(" into an empty subRangeMap");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void putAll(RangeMap object) {
        boolean bl2 = (object = object.asMapOfRanges()).isEmpty();
        if (bl2) {
            return;
        }
        object = new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
        throw object;
    }

    public void putCoalescing(Range object, Object object2) {
        Preconditions.checkNotNull(object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot insert range ");
        stringBuilder.append(object);
        stringBuilder.append(" into an empty subRangeMap");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void remove(Range range) {
        Preconditions.checkNotNull(range);
    }

    public Range span() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public RangeMap subRangeMap(Range range) {
        Preconditions.checkNotNull(range);
        return this;
    }
}

