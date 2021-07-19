/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;

public final class DenseImmutableTable$Column
extends DenseImmutableTable$ImmutableArrayMap {
    private final int columnIndex;
    public final /* synthetic */ DenseImmutableTable this$0;

    public DenseImmutableTable$Column(DenseImmutableTable denseImmutableTable, int n10) {
        this.this$0 = denseImmutableTable;
        int n11 = DenseImmutableTable.access$500(denseImmutableTable)[n10];
        super(n11);
        this.columnIndex = n10;
    }

    public Object getValue(int n10) {
        Object[] objectArray = DenseImmutableTable.access$400(this.this$0)[n10];
        int n11 = this.columnIndex;
        return objectArray[n11];
    }

    public boolean isPartialView() {
        return true;
    }

    public ImmutableMap keyToIndex() {
        return DenseImmutableTable.access$600(this.this$0);
    }
}

