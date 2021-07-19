/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables$TransformedTable$1;
import com.google.common.collect.Tables$TransformedTable$2;
import com.google.common.collect.Tables$TransformedTable$3;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tables$TransformedTable
extends AbstractTable {
    public final Table fromTable;
    public final Function function;

    public Tables$TransformedTable(Table object, Function function) {
        object = (Table)Preconditions.checkNotNull(object);
        this.fromTable = object;
        this.function = object = (Function)Preconditions.checkNotNull(function);
    }

    public Function cellFunction() {
        Tables$TransformedTable$1 tables$TransformedTable$1 = new Tables$TransformedTable$1(this);
        return tables$TransformedTable$1;
    }

    public Iterator cellIterator() {
        Iterator iterator2 = this.fromTable.cellSet().iterator();
        Function function = this.cellFunction();
        return Iterators.transform(iterator2, function);
    }

    public void clear() {
        this.fromTable.clear();
    }

    public Map column(Object object) {
        object = this.fromTable.column(object);
        Function function = this.function;
        return Maps.transformValues((Map)object, function);
    }

    public Set columnKeySet() {
        return this.fromTable.columnKeySet();
    }

    public Map columnMap() {
        Tables$TransformedTable$3 tables$TransformedTable$3 = new Tables$TransformedTable$3(this);
        return Maps.transformValues(this.fromTable.columnMap(), (Function)tables$TransformedTable$3);
    }

    public boolean contains(Object object, Object object2) {
        return this.fromTable.contains(object, object2);
    }

    public Collection createValues() {
        Collection collection = this.fromTable.values();
        Function function = this.function;
        return Collections2.transform(collection, function);
    }

    public Object get(Object object, Object object2) {
        boolean bl2 = this.contains(object, object2);
        if (bl2) {
            Function function = this.function;
            Table table = this.fromTable;
            object = table.get(object, object2);
            object = function.apply(object);
        } else {
            object = null;
        }
        return object;
    }

    public Object put(Object object, Object object2, Object object3) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void putAll(Table object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Object remove(Object object, Object object2) {
        boolean bl2 = this.contains(object, object2);
        if (bl2) {
            Function function = this.function;
            Table table = this.fromTable;
            object = table.remove(object, object2);
            object = function.apply(object);
        } else {
            object = null;
        }
        return object;
    }

    public Map row(Object object) {
        object = this.fromTable.row(object);
        Function function = this.function;
        return Maps.transformValues((Map)object, function);
    }

    public Set rowKeySet() {
        return this.fromTable.rowKeySet();
    }

    public Map rowMap() {
        Tables$TransformedTable$2 tables$TransformedTable$2 = new Tables$TransformedTable$2(this);
        return Maps.transformValues(this.fromTable.rowMap(), (Function)tables$TransformedTable$2);
    }

    public int size() {
        return this.fromTable.size();
    }
}

