/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.SetMultimap;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

public interface SortedSetMultimap
extends SetMultimap {
    public Map asMap();

    public SortedSet get(Object var1);

    public SortedSet removeAll(Object var1);

    public SortedSet replaceValues(Object var1, Iterable var2);

    public Comparator valueComparator();
}

