/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators$MergingIterator;
import com.google.common.collect.PeekingIterator;
import java.util.Comparator;

public class Iterators$MergingIterator$1
implements Comparator {
    public final /* synthetic */ Iterators.MergingIterator this$0;
    public final /* synthetic */ Comparator val$itemComparator;

    public Iterators$MergingIterator$1(Iterators.MergingIterator mergingIterator, Comparator comparator) {
        this.this$0 = mergingIterator;
        this.val$itemComparator = comparator;
    }

    public int compare(PeekingIterator object, PeekingIterator object2) {
        Comparator comparator = this.val$itemComparator;
        object = object.peek();
        object2 = object2.peek();
        return comparator.compare(object, object2);
    }
}

