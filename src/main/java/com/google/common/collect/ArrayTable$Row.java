/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ImmutableMap;

public class ArrayTable$Row
extends ArrayTable$ArrayMap {
    public final int rowIndex;
    public final /* synthetic */ ArrayTable this$0;

    public ArrayTable$Row(ArrayTable serializable, int n10) {
        this.this$0 = serializable;
        serializable = ArrayTable.access$600(serializable);
        super((ImmutableMap)serializable, null);
        this.rowIndex = n10;
    }

    public String getKeyRole() {
        return "Column";
    }

    public Object getValue(int n10) {
        ArrayTable arrayTable = this.this$0;
        int n11 = this.rowIndex;
        return arrayTable.at(n11, n10);
    }

    public Object setValue(int n10, Object object) {
        ArrayTable arrayTable = this.this$0;
        int n11 = this.rowIndex;
        return arrayTable.set(n11, n10, object);
    }
}

