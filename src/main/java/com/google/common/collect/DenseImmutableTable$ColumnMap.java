/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$1;
import com.google.common.collect.DenseImmutableTable$Column;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;

public final class DenseImmutableTable$ColumnMap
extends DenseImmutableTable$ImmutableArrayMap {
    public final /* synthetic */ DenseImmutableTable this$0;

    private DenseImmutableTable$ColumnMap(DenseImmutableTable denseImmutableTable) {
        this.this$0 = denseImmutableTable;
        int n10 = DenseImmutableTable.access$500(denseImmutableTable).length;
        super(n10);
    }

    public /* synthetic */ DenseImmutableTable$ColumnMap(DenseImmutableTable denseImmutableTable, DenseImmutableTable$1 denseImmutableTable$1) {
        this(denseImmutableTable);
    }

    public ImmutableMap getValue(int n10) {
        DenseImmutableTable denseImmutableTable = this.this$0;
        DenseImmutableTable$Column denseImmutableTable$Column = new DenseImmutableTable$Column(denseImmutableTable, n10);
        return denseImmutableTable$Column;
    }

    public boolean isPartialView() {
        return false;
    }

    public ImmutableMap keyToIndex() {
        return DenseImmutableTable.access$300(this.this$0);
    }
}

