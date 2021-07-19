/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ArrayTable$ArrayMap;
import java.util.Map;

public class ArrayTable$ArrayMap$2
extends AbstractIndexedListIterator {
    public final /* synthetic */ ArrayTable$ArrayMap this$0;

    public ArrayTable$ArrayMap$2(ArrayTable$ArrayMap arrayTable$ArrayMap, int n10) {
        this.this$0 = arrayTable$ArrayMap;
        super(n10);
    }

    public Map.Entry get(int n10) {
        return this.this$0.getEntry(n10);
    }
}

