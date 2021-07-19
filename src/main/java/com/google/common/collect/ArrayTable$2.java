/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Tables$AbstractCell;

public class ArrayTable$2
extends Tables$AbstractCell {
    public final int columnIndex;
    public final int rowIndex;
    public final /* synthetic */ ArrayTable this$0;
    public final /* synthetic */ int val$index;

    public ArrayTable$2(ArrayTable arrayTable, int n10) {
        this.this$0 = arrayTable;
        this.val$index = n10;
        int n11 = ArrayTable.access$100(arrayTable).size();
        this.rowIndex = n11 = n10 / n11;
        int n12 = ArrayTable.access$100(arrayTable).size();
        this.columnIndex = n10 %= n12;
    }

    public Object getColumnKey() {
        ImmutableList immutableList = ArrayTable.access$100(this.this$0);
        int n10 = this.columnIndex;
        return immutableList.get(n10);
    }

    public Object getRowKey() {
        ImmutableList immutableList = ArrayTable.access$200(this.this$0);
        int n10 = this.rowIndex;
        return immutableList.get(n10);
    }

    public Object getValue() {
        ArrayTable arrayTable = this.this$0;
        int n10 = this.rowIndex;
        int n11 = this.columnIndex;
        return arrayTable.at(n10, n11);
    }
}

