/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$1;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$2;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableMap;

public final class TreeRangeSet$SubRangeSetRangesByLowerBound
extends AbstractNavigableMap {
    private final Range lowerBoundWindow;
    private final NavigableMap rangesByLowerBound;
    private final NavigableMap rangesByUpperBound;
    private final Range restriction;

    private TreeRangeSet$SubRangeSetRangesByLowerBound(Range object, Range range, NavigableMap navigableMap) {
        object = (Range)Preconditions.checkNotNull(object);
        this.lowerBoundWindow = object;
        object = (Range)Preconditions.checkNotNull(range);
        this.restriction = object;
        this.rangesByLowerBound = object = (NavigableMap)Preconditions.checkNotNull(navigableMap);
        this.rangesByUpperBound = object = new TreeRangeSet$RangesByUpperBound(navigableMap);
    }

    public /* synthetic */ TreeRangeSet$SubRangeSetRangesByLowerBound(Range range, Range range2, NavigableMap navigableMap, TreeRangeSet$1 treeRangeSet$1) {
        this(range, range2, navigableMap);
    }

    public static /* synthetic */ Range access$300(TreeRangeSet$SubRangeSetRangesByLowerBound treeRangeSet$SubRangeSetRangesByLowerBound) {
        return treeRangeSet$SubRangeSetRangesByLowerBound.restriction;
    }

    public static /* synthetic */ Range access$400(TreeRangeSet$SubRangeSetRangesByLowerBound treeRangeSet$SubRangeSetRangesByLowerBound) {
        return treeRangeSet$SubRangeSetRangesByLowerBound.lowerBoundWindow;
    }

    private NavigableMap subMap(Range range) {
        Object object = this.lowerBoundWindow;
        boolean bl2 = range.isConnected((Range)object);
        if (!bl2) {
            return ImmutableSortedMap.of();
        }
        range = this.lowerBoundWindow.intersection(range);
        Range range2 = this.restriction;
        NavigableMap navigableMap = this.rangesByLowerBound;
        object = new TreeRangeSet$SubRangeSetRangesByLowerBound(range, range2, navigableMap);
        return object;
    }

    public Comparator comparator() {
        return Ordering.natural();
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        if ((object = this.get(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Iterator descendingEntryIterator() {
        BoundType boundType;
        Object object = this.restriction;
        boolean bl2 = ((Range)object).isEmpty();
        if (bl2) {
            return Iterators.emptyIterator();
        }
        object = Ordering.natural();
        Object object2 = this.lowerBoundWindow.upperBound;
        Comparable comparable = Cut.belowValue(this.restriction.upperBound);
        object = (Cut)((Ordering)object).min(object2, comparable);
        object2 = this.rangesByLowerBound;
        comparable = ((Cut)object).endpoint();
        if ((object = ((Cut)object).typeAsUpperBound()) == (boundType = BoundType.CLOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object = object2.headMap(comparable, bl2).descendingMap().values().iterator();
        object2 = new TreeRangeSet$SubRangeSetRangesByLowerBound$2(this, (Iterator)object);
        return object2;
    }

    public Iterator entryIterator() {
        Object object;
        Object object2;
        Object object3 = this.restriction;
        boolean bl2 = ((Range)object3).isEmpty();
        if (bl2) {
            return Iterators.emptyIterator();
        }
        object3 = this.lowerBoundWindow.upperBound;
        Object object4 = this.restriction.lowerBound;
        bl2 = ((Cut)object3).isLessThan((Comparable)object4);
        if (bl2) {
            return Iterators.emptyIterator();
        }
        object3 = this.lowerBoundWindow.lowerBound;
        object4 = this.restriction.lowerBound;
        bl2 = ((Cut)object3).isLessThan((Comparable)object4);
        boolean bl3 = false;
        object4 = null;
        if (bl2) {
            object3 = this.rangesByUpperBound;
            object2 = this.restriction.lowerBound;
            object3 = object3.tailMap(object2, false).values().iterator();
        } else {
            BoundType boundType;
            object3 = this.rangesByLowerBound;
            object2 = this.lowerBoundWindow.lowerBound.endpoint();
            object = this.lowerBoundWindow.lowerBoundType();
            if (object == (boundType = BoundType.CLOSED)) {
                bl3 = true;
            }
            object3 = object3.tailMap(object2, bl3).values().iterator();
        }
        object4 = Ordering.natural();
        object2 = this.lowerBoundWindow.upperBound;
        object = Cut.belowValue(this.restriction.upperBound);
        object4 = (Cut)((Ordering)object4).min(object2, object);
        object2 = new TreeRangeSet$SubRangeSetRangesByLowerBound$1(this, (Iterator)object3, (Cut)object4);
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Range get(Object object) {
        int n10 = object instanceof Cut;
        if (n10 == 0) return null;
        try {
            object = (Cut)object;
            Object object2 = this.lowerBoundWindow;
            n10 = ((Range)object2).contains((Comparable)object);
            if (n10 == 0) return null;
            object2 = this.restriction;
            object2 = ((Range)object2).lowerBound;
            n10 = ((Cut)object).compareTo((Cut)object2);
            if (n10 < 0) return null;
            object2 = this.restriction;
            object2 = ((Range)object2).upperBound;
            n10 = ((Cut)object).compareTo((Cut)object2);
            if (n10 >= 0) {
                return null;
            }
            object2 = this.restriction;
            object2 = ((Range)object2).lowerBound;
            n10 = (int)(((Cut)object).equals(object2) ? 1 : 0);
            if (n10 != 0) {
                object2 = this.rangesByLowerBound;
                object = object2.floorEntry(object);
                object = Maps.valueOrNull(object);
                if ((object = (Range)object) == null) return null;
                object2 = ((Range)object).upperBound;
                Range range = this.restriction;
                Cut cut = range.lowerBound;
                n10 = ((Cut)object2).compareTo(cut);
                if (n10 <= 0) return null;
                object2 = this.restriction;
                return ((Range)object).intersection((Range)object2);
            }
            object2 = this.rangesByLowerBound;
            object = object2.get(object);
            if ((object = (Range)object) == null) return null;
            object2 = this.restriction;
            return ((Range)object).intersection((Range)object2);
        }
        catch (ClassCastException classCastException) {}
        return null;
    }

    public NavigableMap headMap(Cut serializable, boolean bl2) {
        BoundType boundType = BoundType.forBoolean(bl2);
        serializable = Range.upTo(serializable, boundType);
        return this.subMap((Range)serializable);
    }

    public int size() {
        return Iterators.size(this.entryIterator());
    }

    public NavigableMap subMap(Cut serializable, boolean bl2, Cut cut, boolean bl3) {
        BoundType boundType = BoundType.forBoolean(bl2);
        BoundType boundType2 = BoundType.forBoolean(bl3);
        serializable = Range.range(serializable, boundType, cut, boundType2);
        return this.subMap((Range)serializable);
    }

    public NavigableMap tailMap(Cut serializable, boolean bl2) {
        BoundType boundType = BoundType.forBoolean(bl2);
        serializable = Range.downTo(serializable, boundType);
        return this.subMap((Range)serializable);
    }
}

