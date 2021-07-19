/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Map;

public class TreeRangeSet$RangesByUpperBound$2
extends AbstractIterator {
    public final /* synthetic */ TreeRangeSet$RangesByUpperBound this$0;
    public final /* synthetic */ PeekingIterator val$backingItr;

    public TreeRangeSet$RangesByUpperBound$2(TreeRangeSet$RangesByUpperBound treeRangeSet$RangesByUpperBound, PeekingIterator peekingIterator) {
        this.this$0 = treeRangeSet$RangesByUpperBound;
        this.val$backingItr = peekingIterator;
    }

    public Map.Entry computeNext() {
        Object object = this.val$backingItr;
        boolean bl2 = object.hasNext();
        if (!bl2) {
            return (Map.Entry)this.endOfData();
        }
        object = (Range)this.val$backingItr.next();
        Cut cut = TreeRangeSet$RangesByUpperBound.access$000((TreeRangeSet$RangesByUpperBound)this.this$0).lowerBound;
        Cut cut2 = ((Range)object).upperBound;
        boolean bl3 = cut.isLessThan(cut2);
        if (bl3) {
            cut = ((Range)object).upperBound;
            object = Maps.immutableEntry(cut, object);
        } else {
            object = (Map.Entry)this.endOfData();
        }
        return object;
    }
}

