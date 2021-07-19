/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound;
import java.io.Serializable;
import java.util.Map;

public class TreeRangeSet$ComplementRangesByLowerBound$1
extends AbstractIterator {
    public Cut nextComplementRangeLowerBound;
    public final /* synthetic */ TreeRangeSet$ComplementRangesByLowerBound this$0;
    public final /* synthetic */ Cut val$firstComplementRangeLowerBound;
    public final /* synthetic */ PeekingIterator val$positiveItr;

    public TreeRangeSet$ComplementRangesByLowerBound$1(TreeRangeSet$ComplementRangesByLowerBound complementRangesByLowerBound, Cut cut, PeekingIterator peekingIterator) {
        this.this$0 = complementRangesByLowerBound;
        this.val$firstComplementRangeLowerBound = cut;
        this.val$positiveItr = peekingIterator;
        this.nextComplementRangeLowerBound = cut;
    }

    public Map.Entry computeNext() {
        Object object = TreeRangeSet$ComplementRangesByLowerBound.access$100((TreeRangeSet$ComplementRangesByLowerBound)this.this$0).upperBound;
        Serializable serializable = this.nextComplementRangeLowerBound;
        boolean bl2 = ((Cut)object).isLessThan((Comparable)((Object)serializable));
        if (!bl2 && (object = this.nextComplementRangeLowerBound) != (serializable = Cut.aboveAll())) {
            object = this.val$positiveItr;
            bl2 = object.hasNext();
            if (bl2) {
                object = (Range)this.val$positiveItr.next();
                serializable = this.nextComplementRangeLowerBound;
                Cut cut = ((Range)object).lowerBound;
                serializable = Range.create(serializable, cut);
                this.nextComplementRangeLowerBound = object = ((Range)object).upperBound;
            } else {
                object = this.nextComplementRangeLowerBound;
                serializable = Cut.aboveAll();
                serializable = Range.create((Cut)object, serializable);
                this.nextComplementRangeLowerBound = object = Cut.aboveAll();
            }
            return Maps.immutableEntry(((Range)serializable).lowerBound, serializable);
        }
        return (Map.Entry)this.endOfData();
    }
}

