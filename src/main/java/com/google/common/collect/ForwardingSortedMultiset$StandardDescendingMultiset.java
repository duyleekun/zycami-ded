/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.ForwardingSortedMultiset;
import com.google.common.collect.SortedMultiset;

public abstract class ForwardingSortedMultiset$StandardDescendingMultiset
extends DescendingMultiset {
    public final /* synthetic */ ForwardingSortedMultiset this$0;

    public ForwardingSortedMultiset$StandardDescendingMultiset(ForwardingSortedMultiset forwardingSortedMultiset) {
        this.this$0 = forwardingSortedMultiset;
    }

    public SortedMultiset forwardMultiset() {
        return this.this$0;
    }
}

