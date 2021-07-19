/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.Iterators;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$TransposeTable$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tables$TransposeTable
extends AbstractTable {
    private static final Function TRANSPOSE_CELL;
    public final Table original;

    static {
        Tables$TransposeTable$1 tables$TransposeTable$1 = new Tables$TransposeTable$1();
        TRANSPOSE_CELL = tables$TransposeTable$1;
    }

    public Tables$TransposeTable(Table table) {
        this.original = table = (Table)Preconditions.checkNotNull(table);
    }

    public Iterator cellIterator() {
        Iterator iterator2 = this.original.cellSet().iterator();
        Function function = TRANSPOSE_CELL;
        return Iterators.transform(iterator2, function);
    }

    public void clear() {
        this.original.clear();
    }

    public Map column(Object object) {
        return this.original.row(object);
    }

    public Set columnKeySet() {
        return this.original.rowKeySet();
    }

    public Map columnMap() {
        return this.original.rowMap();
    }

    public boolean contains(Object object, Object object2) {
        return this.original.contains(object2, object);
    }

    public boolean containsColumn(Object object) {
        return this.original.containsRow(object);
    }

    public boolean containsRow(Object object) {
        return this.original.containsColumn(object);
    }

    public boolean containsValue(Object object) {
        return this.original.containsValue(object);
    }

    public Object get(Object object, Object object2) {
        return this.original.get(object2, object);
    }

    public Object put(Object object, Object object2, Object object3) {
        return this.original.put(object2, object, object3);
    }

    public void putAll(Table table) {
        Table table2 = this.original;
        table = Tables.transpose(table);
        table2.putAll(table);
    }

    public Object remove(Object object, Object object2) {
        return this.original.remove(object2, object);
    }

    public Map row(Object object) {
        return this.original.column(object);
    }

    public Set rowKeySet() {
        return this.original.columnKeySet();
    }

    public Map rowMap() {
        return this.original.columnMap();
    }

    public int size() {
        return this.original.size();
    }

    public Collection values() {
        return this.original.values();
    }
}

