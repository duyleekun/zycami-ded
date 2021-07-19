/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapDifference;
import java.util.SortedMap;

public interface SortedMapDifference
extends MapDifference {
    public SortedMap entriesDiffering();

    public SortedMap entriesInCommon();

    public SortedMap entriesOnlyOnLeft();

    public SortedMap entriesOnlyOnRight();
}

