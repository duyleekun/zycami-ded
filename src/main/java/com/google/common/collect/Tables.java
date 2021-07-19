/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables$1;
import com.google.common.collect.Tables$ImmutableCell;
import com.google.common.collect.Tables$TransformedTable;
import com.google.common.collect.Tables$TransposeTable;
import com.google.common.collect.Tables$UnmodifiableRowSortedMap;
import com.google.common.collect.Tables$UnmodifiableTable;
import java.util.Map;

public final class Tables {
    private static final Function UNMODIFIABLE_WRAPPER;

    static {
        Tables$1 tables$1 = new Tables$1();
        UNMODIFIABLE_WRAPPER = tables$1;
    }

    private Tables() {
    }

    public static /* synthetic */ Function access$000() {
        return Tables.unmodifiableWrapper();
    }

    public static boolean equalsImpl(Table object, Object object2) {
        if (object2 == object) {
            return true;
        }
        boolean bl2 = object2 instanceof Table;
        if (bl2) {
            object2 = (Table)object2;
            object = object.cellSet();
            object2 = object2.cellSet();
            return object.equals(object2);
        }
        return false;
    }

    public static Table$Cell immutableCell(Object object, Object object2, Object object3) {
        Tables$ImmutableCell tables$ImmutableCell = new Tables$ImmutableCell(object, object2, object3);
        return tables$ImmutableCell;
    }

    public static Table newCustomTable(Map map, Supplier supplier) {
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkNotNull(supplier);
        StandardTable standardTable = new StandardTable(map, supplier);
        return standardTable;
    }

    public static Table synchronizedTable(Table table) {
        return Synchronized.table(table, null);
    }

    public static Table transformValues(Table table, Function function) {
        Tables$TransformedTable tables$TransformedTable = new Tables$TransformedTable(table, function);
        return tables$TransformedTable;
    }

    public static Table transpose(Table table) {
        boolean bl2 = table instanceof Tables$TransposeTable;
        if (bl2) {
            table = ((Tables$TransposeTable)table).original;
        } else {
            Tables$TransposeTable tables$TransposeTable = new Tables$TransposeTable(table);
            table = tables$TransposeTable;
        }
        return table;
    }

    public static RowSortedTable unmodifiableRowSortedTable(RowSortedTable rowSortedTable) {
        Tables$UnmodifiableRowSortedMap tables$UnmodifiableRowSortedMap = new Tables$UnmodifiableRowSortedMap(rowSortedTable);
        return tables$UnmodifiableRowSortedMap;
    }

    public static Table unmodifiableTable(Table table) {
        Tables$UnmodifiableTable tables$UnmodifiableTable = new Tables$UnmodifiableTable(table);
        return tables$UnmodifiableTable;
    }

    private static Function unmodifiableWrapper() {
        return UNMODIFIABLE_WRAPPER;
    }
}

