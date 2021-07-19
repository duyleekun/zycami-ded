/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

public class TreeRangeSet$SubRangeSetRangesByLowerBound$1
extends AbstractIterator {
    public final /* synthetic */ TreeRangeSet$SubRangeSetRangesByLowerBound this$0;
    public final /* synthetic */ Iterator val$completeRangeItr;
    public final /* synthetic */ Cut val$upperBoundOnLowerBounds;

    public TreeRangeSet$SubRangeSetRangesByLowerBound$1(TreeRangeSet$SubRangeSetRangesByLowerBound subRangeSetRangesByLowerBound, Iterator iterator2, Cut cut) {
        this.this$0 = subRangeSetRangesByLowerBound;
        this.val$completeRangeItr = iterator2;
        this.val$upperBoundOnLowerBounds = cut;
    }

    public Map.Entry computeNext() {
        Object object = this.val$completeRangeItr;
        boolean bl2 = object.hasNext();
        if (!bl2) {
            return (Map.Entry)this.endOfData();
        }
        object = (Range)this.val$completeRangeItr.next();
        Serializable serializable = this.val$upperBoundOnLowerBounds;
        Cut cut = ((Range)object).lowerBound;
        boolean bl3 = serializable.isLessThan(cut);
        if (bl3) {
            return (Map.Entry)this.endOfData();
        }
        serializable = TreeRangeSet$SubRangeSetRangesByLowerBound.access$300(this.this$0);
        object = ((Range)object).intersection((Range)serializable);
        return Maps.immutableEntry(((Range)object).lowerBound, object);
    }
}

