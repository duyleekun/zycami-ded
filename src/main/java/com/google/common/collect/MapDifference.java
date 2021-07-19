/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Map;

public interface MapDifference {
    public boolean areEqual();

    public Map entriesDiffering();

    public Map entriesInCommon();

    public Map entriesOnlyOnLeft();

    public Map entriesOnlyOnRight();

    public boolean equals(Object var1);

    public int hashCode();
}

