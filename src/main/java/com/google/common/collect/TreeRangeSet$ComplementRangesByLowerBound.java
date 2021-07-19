/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound$1;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound$2;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableMap;

public final class TreeRangeSet$ComplementRangesByLowerBound
extends AbstractNavigableMap {
    private final Range complementLowerBoundWindow;
    private final NavigableMap positiveRangesByLowerBound;
    private final NavigableMap positiveRangesByUpperBound;

    public TreeRangeSet$ComplementRangesByLowerBound(NavigableMap navigableMap) {
        Range range = Range.all();
        this(navigableMap, range);
    }

    private TreeRangeSet$ComplementRangesByLowerBound(NavigableMap navigableMap, Range range) {
        this.positiveRangesByLowerBound = navigableMap;
        TreeRangeSet$RangesByUpperBound treeRangeSet$RangesByUpperBound = new TreeRangeSet$RangesByUpperBound(navigableMap);
        this.positiveRangesByUpperBound = treeRangeSet$RangesByUpperBound;
        this.complementLowerBoundWindow = range;
    }

    public static /* synthetic */ Range access$100(TreeRangeSet$ComplementRangesByLowerBound treeRangeSet$ComplementRangesByLowerBound) {
        return treeRangeSet$ComplementRangesByLowerBound.complementLowerBoundWindow;
    }

    private NavigableMap subMap(Range range) {
        Object object = this.complementLowerBoundWindow;
        boolean bl2 = ((Range)object).isConnected(range);
        if (!bl2) {
            return ImmutableSortedMap.of();
        }
        object = this.complementLowerBoundWindow;
        range = range.intersection((Range)object);
        NavigableMap navigableMap = this.positiveRangesByLowerBound;
        object = new TreeRangeSet$ComplementRangesByLowerBound(navigableMap, range);
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
        block9: {
            Object object;
            Object object2;
            Object object3;
            block8: {
                boolean bl2;
                block7: {
                    object3 = this.complementLowerBoundWindow;
                    boolean bl3 = ((Range)object3).hasUpperBound();
                    object3 = bl3 ? (Cut)this.complementLowerBoundWindow.upperEndpoint() : Cut.aboveAll();
                    object2 = this.complementLowerBoundWindow;
                    bl2 = ((Range)object2).hasUpperBound();
                    if (bl2 && (object2 = this.complementLowerBoundWindow.upperBoundType()) == (object = BoundType.CLOSED)) {
                        bl2 = true;
                    } else {
                        bl2 = false;
                        object2 = null;
                    }
                    object = this.positiveRangesByUpperBound;
                    object3 = Iterators.peekingIterator(object.headMap(object3, bl2).descendingMap().values().iterator());
                    bl2 = object3.hasNext();
                    if (!bl2) break block7;
                    object2 = ((Range)object3.peek()).upperBound;
                    object = Cut.aboveAll();
                    if (object2 == object) {
                        object2 = ((Range)object3.next()).lowerBound;
                    } else {
                        object2 = this.positiveRangesByLowerBound;
                        object = ((Range)object3.peek()).upperBound;
                        object2 = (Cut)object2.higherKey(object);
                    }
                    break block8;
                }
                object2 = this.complementLowerBoundWindow;
                object = Cut.belowAll();
                bl2 = ((Range)object2).contains((Comparable)object);
                if (!bl2 || (bl2 = (object2 = this.positiveRangesByLowerBound).containsKey(object = Cut.belowAll()))) break block9;
                object2 = this.positiveRangesByLowerBound;
                object = Cut.belowAll();
                object2 = (Cut)object2.higherKey(object);
            }
            object = Cut.aboveAll();
            object2 = (Cut)MoreObjects.firstNonNull(object2, object);
            object = new TreeRangeSet$ComplementRangesByLowerBound$2(this, (Cut)object2, (PeekingIterator)object3);
            return object;
        }
        return Iterators.emptyIterator();
    }

    public Iterator entryIterator() {
        block9: {
            Object object;
            Object object2;
            Object object3;
            block8: {
                boolean bl2;
                block7: {
                    object3 = this.complementLowerBoundWindow;
                    boolean bl3 = ((Range)object3).hasLowerBound();
                    if (bl3) {
                        boolean bl4;
                        BoundType boundType;
                        object3 = this.positiveRangesByUpperBound;
                        object2 = this.complementLowerBoundWindow.lowerEndpoint();
                        object = this.complementLowerBoundWindow.lowerBoundType();
                        if (object == (boundType = BoundType.CLOSED)) {
                            bl4 = true;
                        } else {
                            bl4 = false;
                            object = null;
                        }
                        object3 = object3.tailMap(object2, bl4).values();
                    } else {
                        object3 = this.positiveRangesByUpperBound.values();
                    }
                    object3 = Iterators.peekingIterator(object3.iterator());
                    object2 = this.complementLowerBoundWindow;
                    object = Cut.belowAll();
                    bl2 = ((Range)object2).contains((Comparable)object);
                    if (!bl2 || (bl2 = object3.hasNext()) && (object2 = ((Range)object3.peek()).lowerBound) == (object = Cut.belowAll())) break block7;
                    object2 = Cut.belowAll();
                    break block8;
                }
                bl2 = object3.hasNext();
                if (!bl2) break block9;
                object2 = ((Range)object3.next()).upperBound;
            }
            object = new TreeRangeSet$ComplementRangesByLowerBound$1(this, (Cut)object2, (PeekingIterator)object3);
            return object;
        }
        return Iterators.emptyIterator();
    }

    public Range get(Object object) {
        block10: {
            boolean bl2 = object instanceof Cut;
            if (bl2) {
                try {
                    object = (Cut)object;
                    bl2 = true;
                }
                catch (ClassCastException classCastException) {}
                Object object2 = this.tailMap((Cut)object, bl2);
                object2 = object2.firstEntry();
                if (object2 == null) break block10;
                Object object3 = object2.getKey();
                object3 = (Cut)object3;
                boolean bl3 = ((Cut)object3).equals(object);
                if (!bl3) break block10;
                object = object2.getValue();
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

