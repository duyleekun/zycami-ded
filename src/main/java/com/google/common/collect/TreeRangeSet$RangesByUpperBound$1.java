/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Iterator;
import java.util.Map;

public class TreeRangeSet$RangesByUpperBound$1
extends AbstractIterator {
    public final /* synthetic */ TreeRangeSet$RangesByUpperBound this$0;
    public final /* synthetic */ Iterator val$backingItr;

    public TreeRangeSet$RangesByUpperBound$1(TreeRangeSet$RangesByUpperBound treeRangeSet$RangesByUpperBound, Iterator iterator2) {
        this.this$0 = treeRangeSet$RangesByUpperBound;
        this.val$backingItr = iterator2;
    }

    public Map.Entry computeNext() {
        Object object = this.val$backingItr;
        boolean bl2 = object.hasNext();
        if (!bl2) {
            return (Map.Entry)this.endOfData();
        }
        object = (Range)this.val$backingItr.next();
        Cut cut = TreeRangeSet$RangesByUpperBound.access$000((TreeRangeSet$RangesByUpperBound)this.this$0).upperBound;
        Cut cut2 = ((Range)object).upperBound;
        boolean bl3 = cut.isLessThan(cut2);
        if (bl3) {
            return (Map.Entry)this.endOfData();
        }
        return Maps.immutableEntry(((Range)object).upperBound, object);
    }
}

