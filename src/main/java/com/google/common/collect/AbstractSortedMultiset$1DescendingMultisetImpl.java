/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractSortedMultiset;
import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.SortedMultiset;
import java.util.Iterator;

public class AbstractSortedMultiset$1DescendingMultisetImpl
extends DescendingMultiset {
    public final /* synthetic */ AbstractSortedMultiset this$0;

    public AbstractSortedMultiset$1DescendingMultisetImpl(AbstractSortedMultiset abstractSortedMultiset) {
        this.this$0 = abstractSortedMultiset;
    }

    public Iterator entryIterator() {
        return this.this$0.descendingEntryIterator();
    }

    public SortedMultiset forwardMultiset() {
        return this.this$0;
    }

    public Iterator iterator() {
        return this.this$0.descendingIterator();
    }
}

