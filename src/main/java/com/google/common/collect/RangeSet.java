/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Range;
import java.util.Set;

public interface RangeSet {
    public void add(Range var1);

    public void addAll(RangeSet var1);

    public void addAll(Iterable var1);

    public Set asDescendingSetOfRanges();

    public Set asRanges();

    public void clear();

    public RangeSet complement();

    public boolean contains(Comparable var1);

    public boolean encloses(Range var1);

    public boolean enclosesAll(RangeSet var1);

    public boolean enclosesAll(Iterable var1);

    public boolean equals(Object var1);

    public int hashCode();

    public boolean intersects(Range var1);

    public boolean isEmpty();

    public Range rangeContaining(Comparable var1);

    public void remove(Range var1);

    public void removeAll(RangeSet var1);

    public void removeAll(Iterable var1);

    public Range span();

    public RangeSet subRangeSet(Range var1);

    public String toString();
}

