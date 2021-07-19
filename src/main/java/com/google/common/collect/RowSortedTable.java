/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.SortedMap;
import java.util.SortedSet;

public interface RowSortedTable
extends Table {
    public SortedSet rowKeySet();

    public SortedMap rowMap();
}

