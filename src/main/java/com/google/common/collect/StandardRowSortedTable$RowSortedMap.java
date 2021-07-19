/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps$SortedKeySet;
import com.google.common.collect.StandardRowSortedTable;
import com.google.common.collect.StandardRowSortedTable$1;
import com.google.common.collect.StandardTable$RowMap;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

public class StandardRowSortedTable$RowSortedMap
extends StandardTable$RowMap
implements SortedMap {
    public final /* synthetic */ StandardRowSortedTable this$0;

    private StandardRowSortedTable$RowSortedMap(StandardRowSortedTable standardRowSortedTable) {
        this.this$0 = standardRowSortedTable;
        super(standardRowSortedTable);
    }

    public /* synthetic */ StandardRowSortedTable$RowSortedMap(StandardRowSortedTable standardRowSortedTable, StandardRowSortedTable$1 standardRowSortedTable$1) {
        this(standardRowSortedTable);
    }

    public Comparator comparator() {
        return StandardRowSortedTable.access$100(this.this$0).comparator();
    }

    public SortedSet createKeySet() {
        Maps$SortedKeySet maps$SortedKeySet = new Maps$SortedKeySet(this);
        return maps$SortedKeySet;
    }

    public Object firstKey() {
        return StandardRowSortedTable.access$100(this.this$0).firstKey();
    }

    public SortedMap headMap(Object sortedMap) {
        Preconditions.checkNotNull(sortedMap);
        sortedMap = StandardRowSortedTable.access$100(this.this$0).headMap(sortedMap);
        Supplier supplier = this.this$0.factory;
        StandardRowSortedTable standardRowSortedTable = new StandardRowSortedTable(sortedMap, supplier);
        return standardRowSortedTable.rowMap();
    }

    public SortedSet keySet() {
        return (SortedSet)super.keySet();
    }

    public Object lastKey() {
        return StandardRowSortedTable.access$100(this.this$0).lastKey();
    }

    public SortedMap subMap(Object sortedMap, Object object) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(object);
        sortedMap = StandardRowSortedTable.access$100(this.this$0).subMap(sortedMap, object);
        object = this.this$0.factory;
        StandardRowSortedTable standardRowSortedTable = new StandardRowSortedTable(sortedMap, (Supplier)object);
        return standardRowSortedTable.rowMap();
    }

    public SortedMap tailMap(Object sortedMap) {
        Preconditions.checkNotNull(sortedMap);
        sortedMap = StandardRowSortedTable.access$100(this.this$0).tailMap(sortedMap);
        Supplier supplier = this.this$0.factory;
        StandardRowSortedTable standardRowSortedTable = new StandardRowSortedTable(sortedMap, supplier);
        return standardRowSortedTable.rowMap();
    }
}

