/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.SingletonImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables$ImmutableCell;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class ImmutableTable$Builder {
    private final List cells;
    private Comparator columnComparator;
    private Comparator rowComparator;

    public ImmutableTable$Builder() {
        ArrayList arrayList = Lists.newArrayList();
        this.cells = arrayList;
    }

    public ImmutableTable build() {
        Object object = this.cells;
        int n10 = object.size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = this.cells;
                Comparator comparator = this.rowComparator;
                Comparator comparator2 = this.columnComparator;
                return RegularImmutableTable.forCells((List)object, comparator, comparator2);
            }
            Table$Cell table$Cell = (Table$Cell)Iterables.getOnlyElement(this.cells);
            object = new SingletonImmutableTable(table$Cell);
            return object;
        }
        return ImmutableTable.of();
    }

    public ImmutableTable$Builder orderColumnsBy(Comparator comparator) {
        this.columnComparator = comparator = (Comparator)Preconditions.checkNotNull(comparator, "columnComparator");
        return this;
    }

    public ImmutableTable$Builder orderRowsBy(Comparator comparator) {
        this.rowComparator = comparator = (Comparator)Preconditions.checkNotNull(comparator, "rowComparator");
        return this;
    }

    public ImmutableTable$Builder put(Table$Cell object) {
        boolean bl2 = object instanceof Tables.ImmutableCell;
        if (bl2) {
            Preconditions.checkNotNull(object.getRowKey(), "row");
            Preconditions.checkNotNull(object.getColumnKey(), "column");
            Object object2 = ((Table$Cell)object).getValue();
            String string2 = "value";
            Preconditions.checkNotNull(object2, string2);
            object2 = this.cells;
            object2.add(object);
        } else {
            Object object3 = object.getRowKey();
            Object object4 = object.getColumnKey();
            object = object.getValue();
            this.put(object3, object4, object);
        }
        return this;
    }

    public ImmutableTable$Builder put(Object object, Object object2, Object object3) {
        List list = this.cells;
        object = ImmutableTable.cellOf(object, object2, object3);
        list.add(object);
        return this;
    }

    public ImmutableTable$Builder putAll(Table object) {
        boolean bl2;
        object = object.cellSet().iterator();
        while (bl2 = object.hasNext()) {
            Table$Cell table$Cell = (Table$Cell)object.next();
            this.put(table$Cell);
        }
        return this;
    }
}

