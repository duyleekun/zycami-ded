/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap$1;
import com.google.common.collect.TreeRangeMap$AsMapOfRanges;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public final class TreeRangeMap
implements RangeMap {
    private static final RangeMap EMPTY_SUB_RANGE_MAP;
    private final NavigableMap entriesByLowerBound;

    static {
        TreeRangeMap$1 treeRangeMap$1 = new TreeRangeMap$1();
        EMPTY_SUB_RANGE_MAP = treeRangeMap$1;
    }

    private TreeRangeMap() {
        TreeMap treeMap = Maps.newTreeMap();
        this.entriesByLowerBound = treeMap;
    }

    public static /* synthetic */ NavigableMap access$000(TreeRangeMap treeRangeMap) {
        return treeRangeMap.entriesByLowerBound;
    }

    public static /* synthetic */ Range access$100(TreeRangeMap treeRangeMap, Range range, Object object) {
        return treeRangeMap.coalescedRange(range, object);
    }

    public static /* synthetic */ RangeMap access$200(TreeRangeMap treeRangeMap) {
        return treeRangeMap.emptySubRangeMap();
    }

    private static Range coalesce(Range range, Object object, Map.Entry entry) {
        boolean bl2;
        Object object2;
        boolean bl3;
        if (entry != null && (bl3 = ((Range)(object2 = ((TreeRangeMap$RangeMapEntry)entry.getValue()).getKey())).isConnected(range)) && (bl2 = (object2 = ((TreeRangeMap$RangeMapEntry)entry.getValue()).getValue()).equals(object))) {
            object = ((TreeRangeMap$RangeMapEntry)entry.getValue()).getKey();
            range = range.span((Range)object);
        }
        return range;
    }

    private Range coalescedRange(Range object, Object object2) {
        Object object3 = this.entriesByLowerBound;
        Object object4 = ((Range)object).lowerBound;
        object3 = object3.lowerEntry(object4);
        object3 = TreeRangeMap.coalesce((Range)object, object2, (Map.Entry)object3);
        object4 = this.entriesByLowerBound;
        object = ((Range)object).upperBound;
        object = object4.floorEntry(object);
        return TreeRangeMap.coalesce((Range)object3, object2, (Map.Entry)object);
    }

    public static TreeRangeMap create() {
        TreeRangeMap treeRangeMap = new TreeRangeMap();
        return treeRangeMap;
    }

    private RangeMap emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
    }

    private void putRangeMapEntry(Cut cut, Cut cut2, Object object) {
        NavigableMap navigableMap = this.entriesByLowerBound;
        TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = new TreeRangeMap$RangeMapEntry(cut, cut2, object);
        navigableMap.put(cut, treeRangeMap$RangeMapEntry);
    }

    public Map asDescendingMapOfRanges() {
        Collection collection = this.entriesByLowerBound.descendingMap().values();
        TreeRangeMap$AsMapOfRanges treeRangeMap$AsMapOfRanges = new TreeRangeMap$AsMapOfRanges(this, collection);
        return treeRangeMap$AsMapOfRanges;
    }

    public Map asMapOfRanges() {
        Collection collection = this.entriesByLowerBound.values();
        TreeRangeMap$AsMapOfRanges treeRangeMap$AsMapOfRanges = new TreeRangeMap$AsMapOfRanges(this, collection);
        return treeRangeMap$AsMapOfRanges;
    }

    public void clear() {
        this.entriesByLowerBound.clear();
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
        object = (object = this.getEntry((Comparable)object)) == null ? null : object.getValue();
        return object;
    }

    public Map.Entry getEntry(Comparable comparable) {
        boolean bl2;
        Object object = this.entriesByLowerBound;
        Object object2 = Cut.belowValue(comparable);
        if ((object = object.floorEntry(object2)) != null && (bl2 = ((TreeRangeMap$RangeMapEntry)(object2 = (TreeRangeMap$RangeMapEntry)object.getValue())).contains(comparable))) {
            return (Map.Entry)object.getValue();
        }
        return null;
    }

    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }

    public void put(Range range, Object object) {
        boolean bl2 = range.isEmpty();
        if (!bl2) {
            Preconditions.checkNotNull(object);
            this.remove(range);
            NavigableMap navigableMap = this.entriesByLowerBound;
            Cut cut = range.lowerBound;
            TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = new TreeRangeMap$RangeMapEntry(range, object);
            navigableMap.put(cut, treeRangeMap$RangeMapEntry);
        }
    }

    public void putAll(RangeMap object) {
        boolean bl2;
        object = object.asMapOfRanges().entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Range range = (Range)entry.getKey();
            entry = entry.getValue();
            this.put(range, entry);
        }
    }

    public void putCoalescing(Range range, Object object) {
        Object object2 = this.entriesByLowerBound;
        boolean bl2 = object2.isEmpty();
        if (bl2) {
            this.put(range, object);
            return;
        }
        object2 = Preconditions.checkNotNull(object);
        range = this.coalescedRange(range, object2);
        this.put(range, object);
    }

    public void remove(Range serializable) {
        Cut cut;
        Cut cut2;
        int n10;
        boolean bl2 = serializable.isEmpty();
        if (bl2) {
            return;
        }
        Object object = this.entriesByLowerBound;
        Object object2 = serializable.lowerBound;
        if ((object = object.lowerEntry(object2)) != null && (n10 = (cut2 = ((TreeRangeMap$RangeMapEntry)(object2 = (TreeRangeMap$RangeMapEntry)object.getValue())).getUpperBound()).compareTo(cut = serializable.lowerBound)) > 0) {
            cut2 = ((TreeRangeMap$RangeMapEntry)object2).getUpperBound();
            n10 = cut2.compareTo(cut = serializable.upperBound);
            if (n10 > 0) {
                cut2 = serializable.upperBound;
                cut = ((TreeRangeMap$RangeMapEntry)object2).getUpperBound();
                Object object3 = ((TreeRangeMap$RangeMapEntry)object.getValue()).getValue();
                this.putRangeMapEntry(cut2, cut, object3);
            }
            object2 = ((TreeRangeMap$RangeMapEntry)object2).getLowerBound();
            cut2 = serializable.lowerBound;
            object = ((TreeRangeMap$RangeMapEntry)object.getValue()).getValue();
            this.putRangeMapEntry((Cut)object2, cut2, object);
        }
        object = this.entriesByLowerBound;
        object2 = serializable.upperBound;
        if ((object = object.lowerEntry(object2)) != null && (n10 = (cut2 = ((TreeRangeMap$RangeMapEntry)(object2 = (TreeRangeMap$RangeMapEntry)object.getValue())).getUpperBound()).compareTo(cut = serializable.upperBound)) > 0) {
            cut2 = serializable.upperBound;
            object2 = ((TreeRangeMap$RangeMapEntry)object2).getUpperBound();
            object = ((TreeRangeMap$RangeMapEntry)object.getValue()).getValue();
            this.putRangeMapEntry(cut2, (Cut)object2, object);
        }
        object = this.entriesByLowerBound;
        object2 = serializable.lowerBound;
        serializable = serializable.upperBound;
        object.subMap(object2, serializable).clear();
    }

    public Range span() {
        Object object = this.entriesByLowerBound.firstEntry();
        Object object2 = this.entriesByLowerBound.lastEntry();
        if (object != null) {
            object = ((TreeRangeMap$RangeMapEntry)object.getValue()).getKey().lowerBound;
            object2 = ((TreeRangeMap$RangeMapEntry)object2.getValue()).getKey().upperBound;
            return Range.create((Cut)object, (Cut)object2);
        }
        object = new NoSuchElementException();
        throw object;
    }

    public RangeMap subRangeMap(Range range) {
        Object object = Range.all();
        boolean bl2 = range.equals(object);
        if (bl2) {
            return this;
        }
        object = new TreeRangeMap$SubRangeMap(this, range);
        return object;
    }

    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }
}

