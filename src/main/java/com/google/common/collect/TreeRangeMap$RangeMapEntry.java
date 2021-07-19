/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;

public final class TreeRangeMap$RangeMapEntry
extends AbstractMapEntry {
    private final Range range;
    private final Object value;

    public TreeRangeMap$RangeMapEntry(Cut serializable, Cut cut, Object object) {
        serializable = Range.create(serializable, cut);
        this((Range)serializable, object);
    }

    public TreeRangeMap$RangeMapEntry(Range range, Object object) {
        this.range = range;
        this.value = object;
    }

    public boolean contains(Comparable comparable) {
        return this.range.contains(comparable);
    }

    public Range getKey() {
        return this.range;
    }

    public Cut getLowerBound() {
        return this.range.lowerBound;
    }

    public Cut getUpperBound() {
        return this.range.upperBound;
    }

    public Object getValue() {
        return this.value;
    }
}

