/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Iterator;

public class DescendingMultiset$1EntrySetImpl
extends Multisets$EntrySet {
    public final /* synthetic */ DescendingMultiset this$0;

    public DescendingMultiset$1EntrySetImpl(DescendingMultiset descendingMultiset) {
        this.this$0 = descendingMultiset;
    }

    public Iterator iterator() {
        return this.this$0.entryIterator();
    }

    public Multiset multiset() {
        return this.this$0;
    }

    public int size() {
        return this.this$0.forwardMultiset().entrySet().size();
    }
}

