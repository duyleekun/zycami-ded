/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMultiset$2
extends AbstractIterator {
    private final Iterator mapEntries;
    public final /* synthetic */ ConcurrentHashMultiset this$0;

    public ConcurrentHashMultiset$2(ConcurrentHashMultiset object) {
        this.this$0 = object;
        this.mapEntries = object = ConcurrentHashMultiset.access$100((ConcurrentHashMultiset)object).entrySet().iterator();
    }

    public Multiset$Entry computeNext() {
        Object object;
        AtomicInteger atomicInteger;
        int n10;
        do {
            boolean bl2;
            if (bl2 = (object = this.mapEntries).hasNext()) continue;
            return (Multiset$Entry)this.endOfData();
        } while ((n10 = (atomicInteger = (AtomicInteger)(object = (Map.Entry)this.mapEntries.next()).getValue()).get()) == 0);
        return Multisets.immutableEntry(object.getKey(), n10);
    }
}

