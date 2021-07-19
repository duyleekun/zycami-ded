/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TreeRangeMap$SubRangeMap
implements RangeMap {
    private final Range subRange;
    public final /* synthetic */ TreeRangeMap this$0;

    public TreeRangeMap$SubRangeMap(TreeRangeMap treeRangeMap, Range range) {
        this.this$0 = treeRangeMap;
        this.subRange = range;
    }

    public static /* synthetic */ Range access$300(TreeRangeMap$SubRangeMap treeRangeMap$SubRangeMap) {
        return treeRangeMap$SubRangeMap.subRange;
    }

    public Map asDescendingMapOfRanges() {
        TreeRangeMap$SubRangeMap$1 treeRangeMap$SubRangeMap$1 = new TreeRangeMap$SubRangeMap$1(this);
        return treeRangeMap$SubRangeMap$1;
    }

    public Map asMapOfRanges() {
        TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap = new TreeRangeMap$SubRangeMap$SubRangeMapAsMap(this);
        return treeRangeMap$SubRangeMap$SubRangeMapAsMap;
    }

    public void clear() {
        TreeRangeMap treeRangeMap = this.this$0;
        Range range = this.subRange;
        treeRangeMap.remove(range);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof RangeMap;
        if (bl2) {
            object = (RangeMap)object;
            Map map = this.asMapOfRanges();
            object = object.asMapOfRanges();
            return map.equals(object);
        }
        return false;
    }

    public Object get(Comparable object) {
        Object object2 = this.subRange;
        boolean bl2 = ((Range)object2).contains((Comparable)object);
        if (bl2) {
            object2 = this.this$0;
            object = ((TreeRangeMap)object2).get((Comparable)object);
        } else {
            object = null;
        }
        return object;
    }

    public Map.Entry getEntry(Comparable object) {
        Object object2 = this.subRange;
        boolean bl2 = ((Range)object2).contains((Comparable)object);
        if (bl2 && (object = ((TreeRangeMap)(object2 = this.this$0)).getEntry((Comparable)object)) != null) {
            object2 = (Range)object.getKey();
            Range range = this.subRange;
            object2 = ((Range)object2).intersection(range);
            object = object.getValue();
            return Maps.immutableEntry(object2, object);
        }
        return null;
    }

    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }

    public void put(Range range, Object object) {
        boolean bl2 = this.subRange.encloses(range);
        Range range2 = this.subRange;
        Preconditions.checkArgument(bl2, "Cannot put range %s into a subRangeMap(%s)", (Object)range, (Object)range2);
        this.this$0.put(range, object);
    }

    public void putAll(RangeMap rangeMap) {
        Object object = rangeMap.asMapOfRanges();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return;
        }
        object = rangeMap.span();
        boolean bl3 = this.subRange.encloses((Range)object);
        Range range = this.subRange;
        Preconditions.checkArgument(bl3, "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", object, (Object)range);
        this.this$0.putAll(rangeMap);
    }

    public void putCoalescing(Range range, Object object) {
        Object object2 = TreeRangeMap.access$000(this.this$0);
        boolean bl2 = object2.isEmpty();
        if (!bl2 && !(bl2 = range.isEmpty()) && (bl2 = ((Range)(object2 = this.subRange)).encloses(range))) {
            object2 = this.this$0;
            Object object3 = Preconditions.checkNotNull(object);
            range = TreeRangeMap.access$100((TreeRangeMap)object2, range, object3);
            object2 = this.subRange;
            range = range.intersection((Range)object2);
            this.put(range, object);
            return;
        }
        this.put(range, object);
    }

    public void remove(Range range) {
        Object object = this.subRange;
        boolean bl2 = range.isConnected((Range)object);
        if (bl2) {
            object = this.this$0;
            Range range2 = this.subRange;
            range = range.intersection(range2);
            ((TreeRangeMap)object).remove(range);
        }
    }

    public Range span() {
        Object object;
        block6: {
            Object object2;
            block5: {
                int n10;
                block4: {
                    int n11;
                    object = TreeRangeMap.access$000(this.this$0);
                    object2 = this.subRange.lowerBound;
                    if ((object = object.floorEntry(object2)) == null || (n11 = ((Cut)(object = ((TreeRangeMap$RangeMapEntry)object.getValue()).getUpperBound())).compareTo((Cut)(object2 = this.subRange.lowerBound))) <= 0) break block4;
                    object = this.subRange.lowerBound;
                    break block5;
                }
                object = TreeRangeMap.access$000(this.this$0);
                object2 = this.subRange.lowerBound;
                if ((object = object.ceilingKey(object2)) == null || (n10 = ((Cut)object).compareTo((Cut)(object2 = this.subRange.upperBound))) >= 0) break block6;
            }
            object2 = TreeRangeMap.access$000(this.this$0);
            Cut cut = this.subRange.upperBound;
            object2 = object2.lowerEntry(cut);
            if (object2 != null) {
                Cut cut2;
                cut = ((TreeRangeMap$RangeMapEntry)object2.getValue()).getUpperBound();
                int n12 = cut.compareTo(cut2 = this.subRange.upperBound);
                object2 = n12 >= 0 ? this.subRange.upperBound : ((TreeRangeMap$RangeMapEntry)object2.getValue()).getUpperBound();
                return Range.create((Cut)object, (Cut)object2);
            }
            object = new NoSuchElementException();
            throw object;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public RangeMap subRangeMap(Range range) {
        Object object = this.subRange;
        boolean bl2 = range.isConnected((Range)object);
        if (!bl2) {
            return TreeRangeMap.access$200(this.this$0);
        }
        object = this.this$0;
        Range range2 = this.subRange;
        range = range.intersection(range2);
        return ((TreeRangeMap)object).subRangeMap(range);
    }

    public String toString() {
        return this.asMapOfRanges().toString();
    }
}

