/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import java.io.Serializable;

public class ImmutableRangeMap$1
extends ImmutableList {
    public final /* synthetic */ ImmutableRangeMap this$0;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ int val$off;
    public final /* synthetic */ Range val$range;

    public ImmutableRangeMap$1(ImmutableRangeMap immutableRangeMap, int n10, int n11, Range range) {
        this.this$0 = immutableRangeMap;
        this.val$len = n10;
        this.val$off = n11;
        this.val$range = range;
    }

    public Range get(int n10) {
        int n11 = this.val$len;
        Preconditions.checkElementIndex(n10, n11);
        if (n10 != 0 && n10 != (n11 = this.val$len + -1)) {
            ImmutableList immutableList = ImmutableRangeMap.access$000(this.this$0);
            int n12 = this.val$off;
            return (Range)immutableList.get(n10 += n12);
        }
        Serializable serializable = ImmutableRangeMap.access$000(this.this$0);
        int n13 = this.val$off;
        Range range = (Range)serializable.get(n10 += n13);
        serializable = this.val$range;
        return range.intersection((Range)serializable);
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.val$len;
    }
}

