/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable$Builder;
import com.google.common.collect.ImmutableTable$SerializedForm;
import com.google.common.collect.SingletonImmutableTable;
import com.google.common.collect.SparseImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Iterator;

public abstract class ImmutableTable
extends AbstractTable
implements Serializable {
    public static ImmutableTable$Builder builder() {
        ImmutableTable$Builder immutableTable$Builder = new ImmutableTable$Builder();
        return immutableTable$Builder;
    }

    public static Table$Cell cellOf(Object object, Object object2, Object object3) {
        object = Preconditions.checkNotNull(object, "rowKey");
        object2 = Preconditions.checkNotNull(object2, "columnKey");
        object3 = Preconditions.checkNotNull(object3, "value");
        return Tables.immutableCell(object, object2, object3);
    }

    public static ImmutableTable copyOf(Table table) {
        boolean bl2 = table instanceof ImmutableTable;
        if (bl2) {
            return (ImmutableTable)table;
        }
        return ImmutableTable.copyOf(table.cellSet());
    }

    private static ImmutableTable copyOf(Iterable object) {
        boolean bl2;
        ImmutableTable$Builder immutableTable$Builder = ImmutableTable.builder();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Table$Cell table$Cell = (Table$Cell)object.next();
            immutableTable$Builder.put(table$Cell);
        }
        return immutableTable$Builder.build();
    }

    public static ImmutableTable of() {
        return SparseImmutableTable.EMPTY;
    }

    public static ImmutableTable of(Object object, Object object2, Object object3) {
        SingletonImmutableTable singletonImmutableTable = new SingletonImmutableTable(object, object2, object3);
        return singletonImmutableTable;
    }

    public final UnmodifiableIterator cellIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public ImmutableSet cellSet() {
        return (ImmutableSet)super.cellSet();
    }

    public final void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ImmutableMap column(Object object) {
        Preconditions.checkNotNull(object, "columnKey");
        object = (ImmutableMap)this.columnMap().get(object);
        ImmutableMap immutableMap = ImmutableMap.of();
        return (ImmutableMap)MoreObjects.firstNonNull(object, immutableMap);
    }

    public ImmutableSet columnKeySet() {
        return this.columnMap().keySet();
    }

    public abstract ImmutableMap columnMap();

    public boolean contains(Object object, Object object2) {
        boolean bl2;
        if ((object = this.get(object, object2)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean containsValue(Object object) {
        return this.values().contains(object);
    }

    public abstract ImmutableSet createCellSet();

    public abstract ImmutableTable$SerializedForm createSerializedForm();

    public abstract ImmutableCollection createValues();

    public final Object put(Object object, Object object2, Object object3) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void putAll(Table object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final Object remove(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableMap row(Object object) {
        Preconditions.checkNotNull(object, "rowKey");
        object = (ImmutableMap)this.rowMap().get(object);
        ImmutableMap immutableMap = ImmutableMap.of();
        return (ImmutableMap)MoreObjects.firstNonNull(object, immutableMap);
    }

    public ImmutableSet rowKeySet() {
        return this.rowMap().keySet();
    }

    public abstract ImmutableMap rowMap();

    public ImmutableCollection values() {
        return (ImmutableCollection)super.values();
    }

    public final Iterator valuesIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public final Object writeReplace() {
        return this.createSerializedForm();
    }
}

