/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Range;
import java.io.Serializable;
import java.util.AbstractCollection;

public final class ImmutableRangeSet$ComplementRanges
extends ImmutableList {
    private final boolean positiveBoundedAbove;
    private final boolean positiveBoundedBelow;
    private final int size;
    public final /* synthetic */ ImmutableRangeSet this$0;

    public ImmutableRangeSet$ComplementRanges(ImmutableRangeSet serializable) {
        boolean bl2;
        boolean bl3;
        this.this$0 = serializable;
        Range range = (Range)ImmutableRangeSet.access$000((ImmutableRangeSet)serializable).get(0);
        this.positiveBoundedBelow = bl3 = range.hasLowerBound();
        Range range2 = (Range)Iterables.getLast(ImmutableRangeSet.access$000((ImmutableRangeSet)serializable));
        this.positiveBoundedAbove = bl2 = range2.hasUpperBound();
        serializable = ImmutableRangeSet.access$000((ImmutableRangeSet)serializable);
        int n10 = ((AbstractCollection)((Object)serializable)).size() + -1;
        if (bl3) {
            ++n10;
        }
        if (bl2) {
            ++n10;
        }
        this.size = n10;
    }

    public Range get(int n10) {
        Cut cut;
        int n11;
        Serializable serializable;
        int n12 = this.size;
        Preconditions.checkElementIndex(n10, n12);
        n12 = (int)(this.positiveBoundedBelow ? 1 : 0);
        if (n12 != 0) {
            if (n10 == 0) {
                serializable = Cut.belowAll();
            } else {
                serializable = ImmutableRangeSet.access$000(this.this$0);
                n11 = n10 + -1;
                serializable = ((Range)serializable.get((int)n11)).upperBound;
            }
        } else {
            serializable = ((Range)ImmutableRangeSet.access$000((ImmutableRangeSet)this.this$0).get((int)n10)).upperBound;
        }
        n11 = this.positiveBoundedAbove;
        if (n11 != 0 && n10 == (n11 = this.size + -1)) {
            cut = Cut.aboveAll();
        } else {
            ImmutableList immutableList = ImmutableRangeSet.access$000(this.this$0);
            int n13 = this.positiveBoundedBelow ^ 1;
            cut = ((Range)immutableList.get((int)(n10 += n13))).lowerBound;
        }
        return Range.create((Cut)serializable, cut);
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.size;
    }
}

