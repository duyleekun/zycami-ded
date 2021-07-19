/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimaps$Keys$1;
import com.google.common.collect.Multisets$AbstractEntry;
import java.util.Collection;
import java.util.Map;

public class Multimaps$Keys$1$1
extends Multisets$AbstractEntry {
    public final /* synthetic */ Multimaps$Keys$1 this$1;
    public final /* synthetic */ Map.Entry val$backingEntry;

    public Multimaps$Keys$1$1(Multimaps$Keys$1 multimaps$Keys$1, Map.Entry entry) {
        this.this$1 = multimaps$Keys$1;
        this.val$backingEntry = entry;
    }

    public int getCount() {
        return ((Collection)this.val$backingEntry.getValue()).size();
    }

    public Object getElement() {
        return this.val$backingEntry.getKey();
    }
}

