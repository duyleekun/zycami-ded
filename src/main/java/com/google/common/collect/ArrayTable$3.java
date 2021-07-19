/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ArrayTable;

public class ArrayTable$3
extends AbstractIndexedListIterator {
    public final /* synthetic */ ArrayTable this$0;

    public ArrayTable$3(ArrayTable arrayTable, int n10) {
        this.this$0 = arrayTable;
        super(n10);
    }

    public Object get(int n10) {
        return ArrayTable.access$800(this.this$0, n10);
    }
}

