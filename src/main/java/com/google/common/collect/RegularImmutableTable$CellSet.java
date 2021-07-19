/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.IndexedImmutableSet;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.RegularImmutableTable$1;
import com.google.common.collect.Table$Cell;

public final class RegularImmutableTable$CellSet
extends IndexedImmutableSet {
    public final /* synthetic */ RegularImmutableTable this$0;

    private RegularImmutableTable$CellSet(RegularImmutableTable regularImmutableTable) {
        this.this$0 = regularImmutableTable;
    }

    public /* synthetic */ RegularImmutableTable$CellSet(RegularImmutableTable regularImmutableTable, RegularImmutableTable$1 regularImmutableTable$1) {
        this(regularImmutableTable);
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof Table$Cell;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            Object object2;
            object = (Table$Cell)object;
            Object object3 = this.this$0;
            Object object4 = object.getRowKey();
            if ((object3 = ((ImmutableTable)object3).get(object4, object2 = object.getColumnKey())) != null && (bl4 = object3.equals(object = object.getValue()))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public Table$Cell get(int n10) {
        return this.this$0.getCell(n10);
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.this$0.size();
    }
}

