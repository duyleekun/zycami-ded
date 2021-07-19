/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.ImmutableTable$SerializedForm;
import com.google.common.collect.Table$Cell;

public class SingletonImmutableTable
extends ImmutableTable {
    public final Object singleColumnKey;
    public final Object singleRowKey;
    public final Object singleValue;

    public SingletonImmutableTable(Table$Cell object) {
        Object object2 = object.getRowKey();
        Object object3 = object.getColumnKey();
        object = object.getValue();
        this(object2, object3, object);
    }

    public SingletonImmutableTable(Object object, Object object2, Object object3) {
        this.singleRowKey = object = Preconditions.checkNotNull(object);
        this.singleColumnKey = object = Preconditions.checkNotNull(object2);
        this.singleValue = object = Preconditions.checkNotNull(object3);
    }

    public ImmutableMap column(Object object) {
        Preconditions.checkNotNull(object);
        boolean bl2 = this.containsColumn(object);
        if (bl2) {
            object = this.singleRowKey;
            Object object2 = this.singleValue;
            object = ImmutableMap.of(object, object2);
        } else {
            object = ImmutableMap.of();
        }
        return object;
    }

    public ImmutableMap columnMap() {
        Object object = this.singleColumnKey;
        Object object2 = this.singleRowKey;
        Object object3 = this.singleValue;
        object2 = ImmutableMap.of(object2, object3);
        return ImmutableMap.of(object, object2);
    }

    public ImmutableSet createCellSet() {
        Object object = this.singleRowKey;
        Object object2 = this.singleColumnKey;
        Object object3 = this.singleValue;
        return ImmutableSet.of(ImmutableTable.cellOf(object, object2, object3));
    }

    public ImmutableTable$SerializedForm createSerializedForm() {
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 0;
        int[] nArray2 = new int[n10];
        nArray2[0] = 0;
        return ImmutableTable$SerializedForm.create(this, nArray, nArray2);
    }

    public ImmutableCollection createValues() {
        return ImmutableSet.of(this.singleValue);
    }

    public ImmutableMap rowMap() {
        Object object = this.singleRowKey;
        Object object2 = this.singleColumnKey;
        Object object3 = this.singleValue;
        object2 = ImmutableMap.of(object2, object3);
        return ImmutableMap.of(object, object2);
    }

    public int size() {
        return 1;
    }
}

