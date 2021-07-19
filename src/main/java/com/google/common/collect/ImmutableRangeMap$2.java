/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import java.io.Serializable;

public class ImmutableRangeMap$2
extends ImmutableRangeMap {
    public final /* synthetic */ ImmutableRangeMap this$0;
    public final /* synthetic */ ImmutableRangeMap val$outer;
    public final /* synthetic */ Range val$range;

    public ImmutableRangeMap$2(ImmutableRangeMap immutableRangeMap, ImmutableList immutableList, ImmutableList immutableList2, Range range, ImmutableRangeMap immutableRangeMap2) {
        this.this$0 = immutableRangeMap;
        this.val$range = range;
        this.val$outer = immutableRangeMap2;
        super(immutableList, immutableList2);
    }

    public ImmutableRangeMap subRangeMap(Range range) {
        Serializable serializable = this.val$range;
        boolean bl2 = ((Range)serializable).isConnected(range);
        if (bl2) {
            serializable = this.val$outer;
            Range range2 = this.val$range;
            range = range.intersection(range2);
            return ((ImmutableRangeMap)serializable).subRangeMap(range);
        }
        return ImmutableRangeMap.of();
    }
}

