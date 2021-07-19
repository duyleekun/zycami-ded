/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$Itr;

public class CompactHashMap$3
extends CompactHashMap$Itr {
    public final /* synthetic */ CompactHashMap this$0;

    public CompactHashMap$3(CompactHashMap compactHashMap) {
        this.this$0 = compactHashMap;
        super(compactHashMap, null);
    }

    public Object getOutput(int n10) {
        return this.this$0.values[n10];
    }
}

