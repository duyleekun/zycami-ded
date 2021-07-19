/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$Column;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class ArrayTable$ColumnMap
extends ArrayTable$ArrayMap {
    public final /* synthetic */ ArrayTable this$0;

    private ArrayTable$ColumnMap(ArrayTable serializable) {
        this.this$0 = serializable;
        serializable = ArrayTable.access$600(serializable);
        super((ImmutableMap)serializable, null);
    }

    public /* synthetic */ ArrayTable$ColumnMap(ArrayTable arrayTable, ArrayTable$1 arrayTable$1) {
        this(arrayTable);
    }

    public String getKeyRole() {
        return "Column";
    }

    public Map getValue(int n10) {
        ArrayTable arrayTable = this.this$0;
        ArrayTable$Column arrayTable$Column = new ArrayTable$Column(arrayTable, n10);
        return arrayTable$Column;
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

