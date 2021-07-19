/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$MapDifferenceImpl;
import com.google.common.collect.SortedMapDifference;
import java.util.SortedMap;

public class Maps$SortedMapDifferenceImpl
extends Maps$MapDifferenceImpl
implements SortedMapDifference {
    public Maps$SortedMapDifferenceImpl(SortedMap sortedMap, SortedMap sortedMap2, SortedMap sortedMap3, SortedMap sortedMap4) {
        super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
    }

    public SortedMap entriesDiffering() {
        return (SortedMap)super.entriesDiffering();
    }

    public SortedMap entriesInCommon() {
        return (SortedMap)super.entriesInCommon();
    }

    public SortedMap entriesOnlyOnLeft() {
        return (SortedMap)super.entriesOnlyOnLeft();
    }

    public SortedMap entriesOnlyOnRight() {
        return (SortedMap)super.entriesOnlyOnRight();
    }
}

