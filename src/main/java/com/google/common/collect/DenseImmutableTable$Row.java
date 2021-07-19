/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;

public final class DenseImmutableTable$Row
extends DenseImmutableTable$ImmutableArrayMap {
    private final int rowIndex;
    public final /* synthetic */ DenseImmutableTable this$0;

    public DenseImmutableTable$Row(DenseImmutableTable denseImmutableTable, int n10) {
        this.this$0 = denseImmutableTable;
        int n11 = DenseImmutableTable.access$200(denseImmutableTable)[n10];
        super(n11);
        this.rowIndex = n10;
    }

    public Object getValue(int n10) {
        Object[][] objectArray = DenseImmutableTable.access$400(this.this$0);
        int n11 = this.rowIndex;
        return objectArray[n11][n10];
    }

    public boolean isPartialView() {
        return true;
    }

    public ImmutableMap keyToIndex() {
        return DenseImmutableTable.access$300(this.this$0);
    }
}

