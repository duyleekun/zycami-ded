/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$1;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.DenseImmutableTable$Row;
import com.google.common.collect.ImmutableMap;

public final class DenseImmutableTable$RowMap
extends DenseImmutableTable$ImmutableArrayMap {
    public final /* synthetic */ DenseImmutableTable this$0;

    private DenseImmutableTable$RowMap(DenseImmutableTable denseImmutableTable) {
        this.this$0 = denseImmutableTable;
        int n10 = DenseImmutableTable.access$200(denseImmutableTable).length;
        super(n10);
    }

    public /* synthetic */ DenseImmutableTable$RowMap(DenseImmutableTable denseImmutableTable, DenseImmutableTable$1 denseImmutableTable$1) {
        this(denseImmutableTable);
    }

    public ImmutableMap getValue(int n10) {
        DenseImmutableTable denseImmutableTable = this.this$0;
        DenseImmutableTable$Row denseImmutableTable$Row = new DenseImmutableTable$Row(denseImmutableTable, n10);
        return denseImmutableTable$Row;
    }

    public boolean isPartialView() {
        return false;
    }

    public ImmutableMap keyToIndex() {
        return DenseImmutableTable.access$600(this.this$0);
    }
}

