/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

public class ImmutableMap$1
extends UnmodifiableIterator {
    public final /* synthetic */ ImmutableMap this$0;
    public final /* synthetic */ UnmodifiableIterator val$entryIterator;

    public ImmutableMap$1(ImmutableMap immutableMap, UnmodifiableIterator unmodifiableIterator) {
        this.this$0 = immutableMap;
        this.val$entryIterator = unmodifiableIterator;
    }

    public boolean hasNext() {
        return this.val$entryIterator.hasNext();
    }

    public Object next() {
        return ((Map.Entry)this.val$entryIterator.next()).getKey();
    }
}

