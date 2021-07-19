/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Range;
import java.util.Map;

public interface RangeMap {
    public Map asDescendingMapOfRanges();

    public Map asMapOfRanges();

    public void clear();

    public boolean equals(Object var1);

    public Object get(Comparable var1);

    public Map.Entry getEntry(Comparable var1);

    public int hashCode();

    public void put(Range var1, Object var2);

    public void putAll(RangeMap var1);

    public void putCoalescing(Range var1, Object var2);

    public void remove(Range var1);

    public Range span();

    public RangeMap subRangeMap(Range var1);

    public String toString();
}

