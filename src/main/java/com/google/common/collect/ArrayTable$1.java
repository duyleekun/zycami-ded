/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table$Cell;

public class ArrayTable$1
extends AbstractIndexedListIterator {
    public final /* synthetic */ ArrayTable this$0;

    public ArrayTable$1(ArrayTable arrayTable, int n10) {
        this.this$0 = arrayTable;
        super(n10);
    }

    public Table$Cell get(int n10) {
        return ArrayTable.access$000(this.this$0, n10);
    }
}

