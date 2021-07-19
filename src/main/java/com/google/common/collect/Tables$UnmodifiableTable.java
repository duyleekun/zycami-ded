/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Tables$UnmodifiableTable
extends ForwardingTable
implements Serializable {
    private static final long serialVersionUID;
    public final Table delegate;

    public Tables$UnmodifiableTable(Table table) {
        this.delegate = table = (Table)Preconditions.checkNotNull(table);
    }

    public Set cellSet() {
        return Collections.unmodifiableSet(super.cellSet());
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Map column(Object object) {
        return Collections.unmodifiableMap(super.column(object));
    }

    public Set columnKeySet() {
        return Collections.unmodifiableSet(super.columnKeySet());
    }

    public Map columnMap() {
        Function function = Tables.access$000();
        return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), function));
    }

    public Table delegate() {
        return this.delegate;
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
        object = new UnsupportedOperationException();
        throw object;
    }

    public Map row(Object object) {
        return Collections.unmodifiableMap(super.row(object));
    }

    public Set rowKeySet() {
        return Collections.unmodifiableSet(super.rowKeySet());
    }

    public Map rowMap() {
        Function function = Tables.access$000();
        return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), function));
    }

    public Collection values() {
        return Collections.unmodifiableCollection(super.values());
    }
}

