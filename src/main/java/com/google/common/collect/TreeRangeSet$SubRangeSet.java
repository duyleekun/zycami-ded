/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound;
import java.io.Serializable;
import java.util.NavigableMap;

public final class TreeRangeSet$SubRangeSet
extends TreeRangeSet {
    private final Range restriction;
    public final /* synthetic */ TreeRangeSet this$0;

    public TreeRangeSet$SubRangeSet(TreeRangeSet object, Range range) {
        this.this$0 = object;
        Range range2 = Range.all();
        object = ((TreeRangeSet)object).rangesByLowerBound;
        TreeRangeSet$SubRangeSetRangesByLowerBound treeRangeSet$SubRangeSetRangesByLowerBound = new TreeRangeSet$SubRangeSetRangesByLowerBound(range2, range, (NavigableMap)object, null);
        super(treeRangeSet$SubRangeSetRangesByLowerBound, null);
        this.restriction = range;
    }

    public void add(Range range) {
        boolean bl2 = this.restriction.encloses(range);
        Range range2 = this.restriction;
        Preconditions.checkArgument(bl2, "Cannot add range %s to subRangeSet(%s)", (Object)range, (Object)range2);
        super.add(range);
    }

    public void clear() {
        TreeRangeSet treeRangeSet = this.this$0;
        Range range = this.restriction;
        treeRangeSet.remove(range);
    }

    public boolean contains(Comparable comparable) {
        boolean bl2;
        Serializable serializable = this.restriction;
        boolean bl3 = ((Range)serializable).contains(comparable);
        if (bl3 && (bl2 = ((TreeRangeSet)(serializable = this.this$0)).contains(comparable))) {
            bl2 = true;
        } else {
            bl2 = false;
            comparable = null;
        }
        return bl2;
    }

    public boolean encloses(Range range) {
        boolean bl2;
        Serializable serializable = this.restriction;
        boolean bl3 = serializable.isEmpty();
        boolean bl4 = false;
        if (!bl3 && (bl3 = (serializable = this.restriction).encloses(range)) && (range = TreeRangeSet.access$600((TreeRangeSet)(serializable = this.this$0), range)) != null && !(bl2 = (range = range.intersection((Range)(serializable = this.restriction))).isEmpty())) {
            bl4 = true;
        }
        return bl4;
    }

    public Range rangeContaining(Comparable object) {
        Serializable serializable = this.restriction;
        boolean bl2 = ((Range)serializable).contains((Comparable)object);
        Range range = null;
        if (!bl2) {
            return null;
        }
        serializable = this.this$0;
        if ((object = ((TreeRangeSet)serializable).rangeContaining((Comparable)object)) != null) {
            serializable = this.restriction;
            range = ((Range)object).intersection((Range)serializable);
        }
        return range;
    }

    public void remove(Range range) {
        Serializable serializable = this.restriction;
        boolean bl2 = range.isConnected((Range)serializable);
        if (bl2) {
            serializable = this.this$0;
            Range range2 = this.restriction;
            range = range.intersection(range2);
            ((TreeRangeSet)serializable).remove(range);
        }
    }

    public RangeSet subRangeSet(Range range) {
        Serializable serializable = this.restriction;
        boolean bl2 = range.encloses((Range)serializable);
        if (bl2) {
            return this;
        }
        serializable = this.restriction;
        bl2 = range.isConnected((Range)serializable);
        if (bl2) {
            range = this.restriction.intersection(range);
            serializable = new TreeRangeSet$SubRangeSet(this, range);
            return serializable;
        }
        return ImmutableRangeSet.of();
    }
}

