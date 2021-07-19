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

public class TreeRangeSet$ComplementRangesByLowerBound$2
extends AbstractIterator {
    public Cut nextComplementRangeUpperBound;
    public final /* synthetic */ TreeRangeSet$ComplementRangesByLowerBound this$0;
    public final /* synthetic */ Cut val$firstComplementRangeUpperBound;
    public final /* synthetic */ PeekingIterator val$positiveItr;

    public TreeRangeSet$ComplementRangesByLowerBound$2(TreeRangeSet$ComplementRangesByLowerBound treeRangeSet$ComplementRangesByLowerBound, Cut cut, PeekingIterator peekingIterator) {
        this.this$0 = treeRangeSet$ComplementRangesByLowerBound;
        this.val$firstComplementRangeUpperBound = cut;
        this.val$positiveItr = peekingIterator;
        this.nextComplementRangeUpperBound = cut;
    }

    public Map.Entry computeNext() {
        Object object = this.nextComplementRangeUpperBound;
        Serializable serializable = Cut.belowAll();
        if (object == serializable) {
            return (Map.Entry)this.endOfData();
        }
        object = this.val$positiveItr;
        boolean bl2 = object.hasNext();
        if (bl2) {
            object = (Range)this.val$positiveItr.next();
            serializable = ((Range)object).upperBound;
            Cut cut = this.nextComplementRangeUpperBound;
            serializable = Range.create(serializable, cut);
            this.nextComplementRangeUpperBound = object = ((Range)object).lowerBound;
            object = TreeRangeSet$ComplementRangesByLowerBound.access$100((TreeRangeSet$ComplementRangesByLowerBound)this.this$0).lowerBound;
            cut = ((Range)serializable).lowerBound;
            bl2 = ((Cut)object).isLessThan(cut);
            if (bl2) {
                return Maps.immutableEntry(((Range)serializable).lowerBound, serializable);
            }
        } else {
            object = TreeRangeSet$ComplementRangesByLowerBound.access$100((TreeRangeSet$ComplementRangesByLowerBound)this.this$0).lowerBound;
            serializable = Cut.belowAll();
            bl2 = ((Cut)object).isLessThan((Comparable)((Object)serializable));
            if (bl2) {
                object = Cut.belowAll();
                serializable = this.nextComplementRangeUpperBound;
                object = Range.create((Cut)object, serializable);
                this.nextComplementRangeUpperBound = serializable = Cut.belowAll();
                return Maps.immutableEntry(Cut.belowAll(), object);
            }
        }
        return (Map.Entry)this.endOfData();
    }
}

