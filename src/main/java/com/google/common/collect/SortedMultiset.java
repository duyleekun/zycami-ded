/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.SortedIterable;
import com.google.common.collect.SortedMultisetBridge;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

public interface SortedMultiset
extends SortedMultisetBridge,
SortedIterable {
    public Comparator comparator();

    public SortedMultiset descendingMultiset();

    public NavigableSet elementSet();

    public Set entrySet();

    public Multiset$Entry firstEntry();

    public SortedMultiset headMultiset(Object var1, BoundType var2);

    public Iterator iterator();

    public Multiset$Entry lastEntry();

    public Multiset$Entry pollFirstEntry();

    public Multiset$Entry pollLastEntry();

    public SortedMultiset subMultiset(Object var1, BoundType var2, Object var3, BoundType var4);

    public SortedMultiset tailMultiset(Object var1, BoundType var2);
}

