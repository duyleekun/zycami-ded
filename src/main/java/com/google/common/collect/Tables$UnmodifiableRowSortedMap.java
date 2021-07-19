/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$UnmodifiableTable;
import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;

public final class Tables$UnmodifiableRowSortedMap
extends Tables$UnmodifiableTable
implements RowSortedTable {
    private static final long serialVersionUID;

    public Tables$UnmodifiableRowSortedMap(RowSortedTable rowSortedTable) {
        super(rowSortedTable);
    }

    public RowSortedTable delegate() {
        return (RowSortedTable)super.delegate();
    }

    public SortedSet rowKeySet() {
        return Collections.unmodifiableSortedSet(this.delegate().rowKeySet());
    }

    public SortedMap rowMap() {
        Function function = Tables.access$000();
        return Collections.unmodifiableSortedMap(Maps.transformValues(this.delegate().rowMap(), function));
    }
}

