/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.ArrayTable$ArrayMap;

public class ArrayTable$ArrayMap$1
extends AbstractMapEntry {
    public final /* synthetic */ ArrayTable$ArrayMap this$0;
    public final /* synthetic */ int val$index;

    public ArrayTable$ArrayMap$1(ArrayTable$ArrayMap arrayMap, int n10) {
        this.this$0 = arrayMap;
        this.val$index = n10;
    }

    public Object getKey() {
        ArrayTable$ArrayMap arrayTable$ArrayMap = this.this$0;
        int n10 = this.val$index;
        return arrayTable$ArrayMap.getKey(n10);
    }

    public Object getValue() {
        ArrayTable$ArrayMap arrayTable$ArrayMap = this.this$0;
        int n10 = this.val$index;
        return arrayTable$ArrayMap.getValue(n10);
    }

    public Object setValue(Object object) {
        ArrayTable$ArrayMap arrayTable$ArrayMap = this.this$0;
        int n10 = this.val$index;
        return arrayTable$ArrayMap.setValue(n10, object);
    }
}

