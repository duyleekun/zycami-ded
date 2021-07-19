/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.ImmutableTable$SerializedForm;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.Table$Cell;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Map;

public final class DenseImmutableTable
extends RegularImmutableTable {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final ImmutableMap columnKeyToIndex;
    private final ImmutableMap columnMap;
    private final int[] rowCounts;
    private final ImmutableMap rowKeyToIndex;
    private final ImmutableMap rowMap;
    private final Object[][] values;

    public DenseImmutableTable(ImmutableList serializable, ImmutableSet object, ImmutableSet object2) {
        int n10 = ((AbstractCollection)object).size();
        int n11 = ((AbstractCollection)object2).size();
        Object object3 = 2;
        Object object4 = new int[object3];
        int n12 = 1;
        object4[n12] = n11;
        object4[0] = n10;
        Object object5 = (Object[][])Array.newInstance(Object.class, object4);
        this.values = object5;
        object = Maps.indexMap((Collection)object);
        this.rowKeyToIndex = object;
        object2 = Maps.indexMap((Collection)object2);
        this.columnKeyToIndex = object2;
        object = new int[object.size()];
        this.rowCounts = (int[])object;
        object = new int[object2.size()];
        this.columnCounts = (int[])object;
        int n13 = serializable.size();
        object = new int[n13];
        int n14 = serializable.size();
        object2 = new int[n14];
        for (n11 = 0; n11 < (n10 = serializable.size()); ++n11) {
            object5 = (Table$Cell)serializable.get(n11);
            object4 = object5.getRowKey();
            Object object6 = object5.getColumnKey();
            Integer n15 = (Integer)this.rowKeyToIndex.get(object4);
            int n16 = n15;
            Integer n17 = (Integer)this.columnKeyToIndex.get(object6);
            int n18 = n17;
            Object object7 = this.values[n16][n18];
            Object object8 = object5.getValue();
            this.checkNoDuplicate(object4, object6, object7, object8);
            object4 = this.values[n16];
            object5 = object5.getValue();
            object4[n18] = (int)object5;
            object5 = this.rowCounts;
            object3 = object5[n16] + n12;
            object5[n16] = (Object[])object3;
            object5 = this.columnCounts;
            object3 = object5[n18] + n12;
            object5[n18] = (Object[])object3;
            object[n11] = n16;
            object2[n11] = n18;
        }
        this.cellRowIndices = (int[])object;
        this.cellColumnIndices = (int[])object2;
        super(this, null);
        this.rowMap = serializable;
        super(this, null);
        this.columnMap = serializable;
    }

    public static /* synthetic */ int[] access$200(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.rowCounts;
    }

    public static /* synthetic */ ImmutableMap access$300(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.columnKeyToIndex;
    }

    public static /* synthetic */ Object[][] access$400(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.values;
    }

    public static /* synthetic */ int[] access$500(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.columnCounts;
    }

    public static /* synthetic */ ImmutableMap access$600(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.rowKeyToIndex;
    }

    public ImmutableMap columnMap() {
        return ImmutableMap.copyOf((Map)this.columnMap);
    }

    public ImmutableTable$SerializedForm createSerializedForm() {
        int[] nArray = this.cellRowIndices;
        int[] nArray2 = this.cellColumnIndices;
        return ImmutableTable$SerializedForm.create(this, nArray, nArray2);
    }

    public Object get(Object object, Object object2) {
        object = (Integer)this.rowKeyToIndex.get(object);
        Object[][] objectArray = this.columnKeyToIndex;
        object2 = (Integer)objectArray.get(object2);
        if (object != null && object2 != null) {
            objectArray = this.values;
            int n10 = object.intValue();
            object = objectArray[n10];
            int n11 = (Integer)object2;
            object = object[n11];
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public Table$Cell getCell(int n10) {
        int n11 = this.cellRowIndices[n10];
        n10 = this.cellColumnIndices[n10];
        Object e10 = this.rowKeySet().asList().get(n11);
        Object e11 = this.columnKeySet().asList().get(n10);
        Object object = this.values[n11][n10];
        return ImmutableTable.cellOf(e10, e11, object);
    }

    public Object getValue(int n10) {
        Object[][] objectArray = this.values;
        int n11 = this.cellRowIndices[n10];
        objectArray = objectArray[n11];
        n10 = this.cellColumnIndices[n10];
        return objectArray[n10];
    }

    public ImmutableMap rowMap() {
        return ImmutableMap.copyOf((Map)this.rowMap);
    }

    public int size() {
        return this.cellRowIndices.length;
    }
}

