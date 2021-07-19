/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Sets$ImprovedAbstractSet;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;

public abstract class StandardTable$TableSet
extends Sets$ImprovedAbstractSet {
    public final /* synthetic */ StandardTable this$0;

    private StandardTable$TableSet(StandardTable standardTable) {
        this.this$0 = standardTable;
    }

    public /* synthetic */ StandardTable$TableSet(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }

    public void clear() {
        this.this$0.backingMap.clear();
    }

    public boolean isEmpty() {
        return this.this$0.backingMap.isEmpty();
    }
}

