/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$1EntrySet$1;
import com.google.common.collect.UnmodifiableIterator;

public class ImmutableSortedMap$1EntrySet
extends ImmutableMapEntrySet {
    public final /* synthetic */ ImmutableSortedMap this$0;

    public ImmutableSortedMap$1EntrySet(ImmutableSortedMap immutableSortedMap) {
        this.this$0 = immutableSortedMap;
    }

    public ImmutableList createAsList() {
        ImmutableSortedMap$1EntrySet$1 immutableSortedMap$1EntrySet$1 = new ImmutableSortedMap$1EntrySet$1(this);
        return immutableSortedMap$1EntrySet$1;
    }

    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }

    public ImmutableMap map() {
        return this.this$0;
    }
}

