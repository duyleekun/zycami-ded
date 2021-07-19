/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import java.io.Serializable;

public class ImmutableRangeSet$1
extends ImmutableList {
    public final /* synthetic */ ImmutableRangeSet this$0;
    public final /* synthetic */ int val$fromIndex;
    public final /* synthetic */ int val$length;
    public final /* synthetic */ Range val$range;

    public ImmutableRangeSet$1(ImmutableRangeSet immutableRangeSet, int n10, int n11, Range range) {
        this.this$0 = immutableRangeSet;
        this.val$length = n10;
        this.val$fromIndex = n11;
        this.val$range = range;
    }

    public Range get(int n10) {
        int n11 = this.val$length;
        Preconditions.checkElementIndex(n10, n11);
        if (n10 != 0 && n10 != (n11 = this.val$length + -1)) {
            ImmutableList immutableList = ImmutableRangeSet.access$000(this.this$0);
            int n12 = this.val$fromIndex;
            return (Range)immutableList.get(n10 += n12);
        }
        Serializable serializable = ImmutableRangeSet.access$000(this.this$0);
        int n13 = this.val$fromIndex;
        Range range = (Range)serializable.get(n10 += n13);
        serializable = this.val$range;
        return range.intersection((Range)serializable);
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.val$length;
    }
}

