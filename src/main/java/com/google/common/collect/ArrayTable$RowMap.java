/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$Row;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class ArrayTable$RowMap
extends ArrayTable$ArrayMap {
    public final /* synthetic */ ArrayTable this$0;

    private ArrayTable$RowMap(ArrayTable serializable) {
        this.this$0 = serializable;
        serializable = ArrayTable.access$300(serializable);
        super((ImmutableMap)serializable, null);
    }

    public /* synthetic */ ArrayTable$RowMap(ArrayTable arrayTable, ArrayTable$1 arrayTable$1) {
        this(arrayTable);
    }

    public String getKeyRole() {
        return "Row";
    }

    public Map getValue(int n10) {
        ArrayTable arrayTable = this.this$0;
        ArrayTable$Row arrayTable$Row = new ArrayTable$Row(arrayTable, n10);
        return arrayTable$Row;
    }

    public Map put(Object object, Map map) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Map setValue(int n10, Map map) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

