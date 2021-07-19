/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$1EntrySet;
import java.util.AbstractMap;
import java.util.Map;

public class ImmutableSortedMap$1EntrySet$1
extends ImmutableList {
    public final /* synthetic */ ImmutableSortedMap$1EntrySet this$1;

    public ImmutableSortedMap$1EntrySet$1(ImmutableSortedMap$1EntrySet entrySet) {
        this.this$1 = entrySet;
    }

    public Map.Entry get(int n10) {
        Object e10 = ImmutableSortedMap.access$100(this.this$1.this$0).asList().get(n10);
        Object e11 = ImmutableSortedMap.access$200(this.this$1.this$0).get(n10);
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(e10, e11);
        return simpleImmutableEntry;
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.this$1.this$0.size();
    }
}

