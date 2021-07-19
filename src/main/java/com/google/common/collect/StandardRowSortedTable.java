/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.StandardRowSortedTable$RowSortedMap;
import com.google.common.collect.StandardTable;
import java.util.SortedMap;
import java.util.SortedSet;

public class StandardRowSortedTable
extends StandardTable
implements RowSortedTable {
    private static final long serialVersionUID;

    public StandardRowSortedTable(SortedMap sortedMap, Supplier supplier) {
        super(sortedMap, supplier);
    }

    public static /* synthetic */ SortedMap access$100(StandardRowSortedTable standardRowSortedTable) {
        return standardRowSortedTable.sortedBackingMap();
    }

    private SortedMap sortedBackingMap() {
        return (SortedMap)this.backingMap;
    }

    public SortedMap createRowMap() {
        StandardRowSortedTable$RowSortedMap standardRowSortedTable$RowSortedMap = new StandardRowSortedTable$RowSortedMap(this, null);
        return standardRowSortedTable$RowSortedMap;
    }

    public SortedSet rowKeySet() {
        return (SortedSet)this.rowMap().keySet();
    }

    public SortedMap rowMap() {
        return (SortedMap)super.rowMap();
    }
}

