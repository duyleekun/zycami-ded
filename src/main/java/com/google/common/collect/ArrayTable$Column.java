/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ImmutableMap;

public class ArrayTable$Column
extends ArrayTable$ArrayMap {
    public final int columnIndex;
    public final /* synthetic */ ArrayTable this$0;

    public ArrayTable$Column(ArrayTable serializable, int n10) {
        this.this$0 = serializable;
        serializable = ArrayTable.access$300(serializable);
        super((ImmutableMap)serializable, null);
        this.columnIndex = n10;
    }

    public String getKeyRole() {
        return "Row";
    }

    public Object getValue(int n10) {
        ArrayTable arrayTable = this.this$0;
        int n11 = this.columnIndex;
        return arrayTable.at(n10, n11);
    }

    public Object setValue(int n10, Object object) {
        ArrayTable arrayTable = this.this$0;
        int n11 = this.columnIndex;
        return arrayTable.set(n10, n11, object);
    }
}

