/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound$1;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound$2;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

public final class TreeRangeSet$RangesByUpperBound
extends AbstractNavigableMap {
    private final NavigableMap rangesByLowerBound;
    private final Range upperBoundWindow;

    public TreeRangeSet$RangesByUpperBound(NavigableMap object) {
        this.rangesByLowerBound = object;
        this.upperBoundWindow = object = Range.all();
    }

    private TreeRangeSet$RangesByUpperBound(NavigableMap navigableMap, Range range) {
        this.rangesByLowerBound = navigableMap;
        this.upperBoundWindow = range;
    }

    public static /* synthetic */ Range access$000(TreeRangeSet$RangesByUpperBound treeRangeSet$RangesByUpperBound) {
        return treeRangeSet$RangesByUpperBound.upperBoundWindow;
    }

    private NavigableMap subMap(Range range) {
        Object object = this.upperBoundWindow;
        boolean bl2 = range.isConnected((Range)object);
        if (bl2) {
            NavigableMap navigableMap = this.rangesByLowerBound;
            Range range2 = this.upperBoundWindow;
            range = range.intersection(range2);
            object = new TreeRangeSet$RangesByUpperBound(navigableMap, range);
            return object;
        }
        return ImmutableSortedMap.of();
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
        Cut cut;
        Object object;
        Object object2 = this.upperBoundWindow;
        boolean bl2 = ((Range)object2).hasUpperBound();
        if (bl2) {
            object2 = this.rangesByLowerBound;
            object = this.upperBoundWindow.upperEndpoint();
            cut = null;
            object2 = object2.headMap(object, false).descendingMap().values();
        } else {
            object2 = this.rangesByLowerBound.descendingMap().values();
        }
        object2 = Iterators.peekingIterator(object2.iterator());
        boolean bl3 = object2.hasNext();
        if (bl3 && (bl3 = ((Cut)(object = this.upperBoundWindow.upperBound)).isLessThan(cut = ((Range)object2.peek()).upperBound))) {
            object2.next();
        }
        object = new TreeRangeSet$RangesByUpperBound$2(this, (PeekingIterator)object2);
        return object;
    }

    public Iterator entryIterator() {
        Object object;
        Object object2 = this.upperBoundWindow;
        boolean bl2 = ((Range)object2).hasLowerBound();
        if (!bl2) {
            object2 = this.rangesByLowerBound.values().iterator();
        } else {
            object2 = this.rangesByLowerBound;
            object = this.upperBoundWindow.lowerEndpoint();
            if ((object2 = object2.lowerEntry(object)) == null) {
                object2 = this.rangesByLowerBound.values().iterator();
            } else {
                object = this.upperBoundWindow.lowerBound;
                Cut cut = ((Range)object2.getValue()).upperBound;
                boolean bl3 = ((Cut)object).isLessThan(cut);
                boolean bl4 = true;
                if (bl3) {
                    object = this.rangesByLowerBound;
                    object2 = object2.getKey();
                    object2 = object.tailMap(object2, bl4).values().iterator();
                } else {
                    object2 = this.rangesByLowerBound;
                    object = this.upperBoundWindow.lowerEndpoint();
                    object2 = object2.tailMap(object, bl4).values().iterator();
                }
            }
        }
        object = new TreeRangeSet$RangesByUpperBound$1(this, (Iterator)object2);
        return object;
    }

    public Range get(Object object) {
        block14: {
            boolean bl2 = object instanceof Cut;
            if (bl2) {
                Map.Entry entry;
                block13: {
                    try {
                        object = (Cut)object;
                    }
                    catch (ClassCastException classCastException) {}
                    entry = this.upperBoundWindow;
                    bl2 = ((Range)((Object)entry)).contains((Comparable)object);
                    if (bl2) break block13;
                    return null;
                }
                entry = this.rangesByLowerBound;
                entry = entry.lowerEntry(object);
                if (entry == null) break block14;
                Object object2 = entry.getValue();
                object2 = (Range)object2;
                object2 = ((Range)object2).upperBound;
                boolean bl3 = ((Cut)object2).equals(object);
                if (!bl3) break block14;
                object = entry.getValue();
                return (Range)object;
            }
        }
        return null;
    }

    public NavigableMap headMap(Cut serializable, boolean bl2) {
        BoundType boundType = BoundType.forBoolean(bl2);
        serializable = Range.upTo(serializable, boundType);
        return this.subMap((Range)serializable);
    }

    public boolean isEmpty() {
        Object object = this.upperBoundWindow;
        Range range = Range.all();
        boolean bl2 = ((Range)object).equals(range);
        if (bl2) {
            object = this.rangesByLowerBound;
            bl2 = object.isEmpty();
        } else {
            object = this.entryIterator();
            bl2 = object.hasNext();
            if (!bl2) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
        }
        return bl2;
    }

    public int size() {
        Range range = this.upperBoundWindow;
        Range range2 = Range.all();
        boolean bl2 = range.equals(range2);
        if (bl2) {
            return this.rangesByLowerBound.size();
        }
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

