/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset$EntrySet;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ConcurrentHashMultiset$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentHashMultiset$EntrySet
extends AbstractMultiset$EntrySet {
    public final /* synthetic */ ConcurrentHashMultiset this$0;

    private ConcurrentHashMultiset$EntrySet(ConcurrentHashMultiset concurrentHashMultiset) {
        this.this$0 = concurrentHashMultiset;
        super(concurrentHashMultiset);
    }

    public /* synthetic */ ConcurrentHashMultiset$EntrySet(ConcurrentHashMultiset concurrentHashMultiset, ConcurrentHashMultiset$1 concurrentHashMultiset$1) {
        this(concurrentHashMultiset);
    }

    private List snapshot() {
        ArrayList arrayList = Lists.newArrayListWithExpectedSize(this.size());
        Iterator iterator2 = this.iterator();
        Iterators.addAll(arrayList, iterator2);
        return arrayList;
    }

    public ConcurrentHashMultiset multiset() {
        return this.this$0;
    }

    public Object[] toArray() {
        return this.snapshot().toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.snapshot().toArray(objectArray);
    }
}

