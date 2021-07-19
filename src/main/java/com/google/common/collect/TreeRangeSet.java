/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractRangeSet;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$AsRanges;
import com.google.common.collect.TreeRangeSet$Complement;
import com.google.common.collect.TreeRangeSet$SubRangeSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

public class TreeRangeSet
extends AbstractRangeSet
implements Serializable {
    private transient Set asDescendingSetOfRanges;
    private transient Set asRanges;
    private transient RangeSet complement;
    public final NavigableMap rangesByLowerBound;

    private TreeRangeSet(NavigableMap navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public /* synthetic */ TreeRangeSet(NavigableMap navigableMap, TreeRangeSet$1 treeRangeSet$1) {
        this(navigableMap);
    }

    public static /* synthetic */ Range access$600(TreeRangeSet treeRangeSet, Range range) {
        return treeRangeSet.rangeEnclosing(range);
    }

    public static TreeRangeSet create() {
        TreeMap treeMap = new TreeMap();
        TreeRangeSet treeRangeSet = new TreeRangeSet(treeMap);
        return treeRangeSet;
    }

    public static TreeRangeSet create(RangeSet rangeSet) {
        TreeRangeSet treeRangeSet = TreeRangeSet.create();
        treeRangeSet.addAll(rangeSet);
        return treeRangeSet;
    }

    public static TreeRangeSet create(Iterable iterable) {
        TreeRangeSet treeRangeSet = TreeRangeSet.create();
        treeRangeSet.addAll(iterable);
        return treeRangeSet;
    }

    private Range rangeEnclosing(Range range) {
        boolean bl2;
        Preconditions.checkNotNull(range);
        Object object = this.rangesByLowerBound;
        Serializable serializable = range.lowerBound;
        object = object.floorEntry(serializable);
        if (object != null && (bl2 = ((Range)(serializable = (Range)object.getValue())).encloses(range))) {
            range = (Range)object.getValue();
        } else {
            bl2 = false;
            range = null;
        }
        return range;
    }

    private void replaceRangeWithSameLowerBound(Range serializable) {
        boolean bl2 = serializable.isEmpty();
        if (bl2) {
            NavigableMap navigableMap = this.rangesByLowerBound;
            serializable = serializable.lowerBound;
            navigableMap.remove(serializable);
        } else {
            NavigableMap navigableMap = this.rangesByLowerBound;
            Cut cut = serializable.lowerBound;
            navigableMap.put(cut, serializable);
        }
    }

    public void add(Range serializable) {
        int n10;
        Cut cut;
        Preconditions.checkNotNull(serializable);
        int n11 = serializable.isEmpty();
        if (n11 != 0) {
            return;
        }
        Cut cut2 = serializable.lowerBound;
        serializable = serializable.upperBound;
        Map.Entry entry = this.rangesByLowerBound.lowerEntry(cut2);
        if (entry != null) {
            entry = (Range)entry.getValue();
            cut = ((Range)entry).upperBound;
            n10 = cut.compareTo(cut2);
            if (n10 >= 0) {
                cut2 = ((Range)entry).upperBound;
                n11 = cut2.compareTo((Cut)serializable);
                if (n11 >= 0) {
                    serializable = ((Range)entry).upperBound;
                }
                cut2 = ((Range)entry).lowerBound;
            }
        }
        if ((entry = this.rangesByLowerBound.floorEntry(serializable)) != null) {
            entry = (Range)entry.getValue();
            cut = ((Range)entry).upperBound;
            n10 = cut.compareTo((Cut)serializable);
            if (n10 >= 0) {
                serializable = ((Range)entry).upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut2, serializable).clear();
        serializable = Range.create(cut2, (Cut)serializable);
        this.replaceRangeWithSameLowerBound((Range)serializable);
    }

    public Set asDescendingSetOfRanges() {
        Set set = this.asDescendingSetOfRanges;
        if (set == null) {
            Collection collection = this.rangesByLowerBound.descendingMap().values();
            this.asDescendingSetOfRanges = set = new TreeRangeSet$AsRanges(this, collection);
        }
        return set;
    }

    public Set asRanges() {
        Set set = this.asRanges;
        if (set == null) {
            Collection collection = this.rangesByLowerBound.values();
            this.asRanges = set = new TreeRangeSet$AsRanges(this, collection);
        }
        return set;
    }

    public RangeSet complement() {
        RangeSet rangeSet = this.complement;
        if (rangeSet == null) {
            this.complement = rangeSet = new TreeRangeSet$Complement(this);
        }
        return rangeSet;
    }

    public boolean encloses(Range range) {
        boolean bl2;
        Preconditions.checkNotNull(range);
        Object object = this.rangesByLowerBound;
        Cut cut = range.lowerBound;
        object = object.floorEntry(cut);
        if (object != null && (bl2 = ((Range)(object = (Range)object.getValue())).encloses(range))) {
            bl2 = true;
        } else {
            bl2 = false;
            range = null;
        }
        return bl2;
    }

    public boolean intersects(Range range) {
        boolean bl2;
        boolean bl3;
        Serializable serializable;
        boolean bl4;
        Preconditions.checkNotNull(range);
        Object object = this.rangesByLowerBound;
        Cut cut = range.lowerBound;
        object = object.ceilingEntry(cut);
        boolean bl5 = true;
        if (object != null && (bl4 = ((Range)(serializable = (Range)object.getValue())).isConnected(range)) && !(bl3 = ((Range)(object = ((Range)object.getValue()).intersection(range))).isEmpty())) {
            return bl5;
        }
        object = this.rangesByLowerBound;
        serializable = range.lowerBound;
        if ((object = object.lowerEntry(serializable)) == null || !(bl4 = ((Range)(serializable = (Range)object.getValue())).isConnected(range)) || (bl2 = (range = ((Range)(object = (Range)object.getValue())).intersection(range)).isEmpty())) {
            bl5 = false;
            cut = null;
        }
        return bl5;
    }

    public Range rangeContaining(Comparable comparable) {
        boolean bl2;
        Preconditions.checkNotNull(comparable);
        Object object = this.rangesByLowerBound;
        Serializable serializable = Cut.belowValue(comparable);
        object = object.floorEntry(serializable);
        if (object != null && (bl2 = ((Range)(serializable = (Range)object.getValue())).contains(comparable))) {
            return (Range)object.getValue();
        }
        return null;
    }

    public void remove(Range serializable) {
        int n10;
        Cut cut;
        Preconditions.checkNotNull(serializable);
        boolean bl2 = serializable.isEmpty();
        if (bl2) {
            return;
        }
        Object object = this.rangesByLowerBound;
        Serializable serializable2 = serializable.lowerBound;
        if ((object = object.lowerEntry(serializable2)) != null) {
            object = (Range)object.getValue();
            serializable2 = ((Range)object).upperBound;
            cut = serializable.lowerBound;
            n10 = serializable2.compareTo(cut);
            if (n10 >= 0) {
                n10 = (int)(serializable.hasUpperBound() ? 1 : 0);
                if (n10 != 0 && (n10 = (serializable2 = ((Range)object).upperBound).compareTo(cut = serializable.upperBound)) >= 0) {
                    serializable2 = serializable.upperBound;
                    cut = ((Range)object).upperBound;
                    serializable2 = Range.create(serializable2, cut);
                    this.replaceRangeWithSameLowerBound((Range)serializable2);
                }
                object = ((Range)object).lowerBound;
                serializable2 = serializable.lowerBound;
                object = Range.create((Cut)object, serializable2);
                this.replaceRangeWithSameLowerBound((Range)object);
            }
        }
        object = this.rangesByLowerBound;
        serializable2 = serializable.upperBound;
        if ((object = object.floorEntry(serializable2)) != null) {
            object = (Range)object.getValue();
            n10 = (int)(serializable.hasUpperBound() ? 1 : 0);
            if (n10 != 0 && (n10 = (serializable2 = ((Range)object).upperBound).compareTo(cut = serializable.upperBound)) >= 0) {
                serializable2 = serializable.upperBound;
                object = ((Range)object).upperBound;
                object = Range.create(serializable2, (Cut)object);
                this.replaceRangeWithSameLowerBound((Range)object);
            }
        }
        object = this.rangesByLowerBound;
        serializable2 = serializable.lowerBound;
        serializable = serializable.upperBound;
        object.subMap(serializable2, serializable).clear();
    }

    public Range span() {
        Object object = this.rangesByLowerBound.firstEntry();
        Object object2 = this.rangesByLowerBound.lastEntry();
        if (object != null) {
            object = ((Range)object.getValue()).lowerBound;
            object2 = ((Range)object2.getValue()).upperBound;
            return Range.create((Cut)object, (Cut)object2);
        }
        object = new NoSuchElementException();
        throw object;
    }

    public RangeSet subRangeSet(Range range) {
        Serializable serializable = Range.all();
        boolean bl2 = range.equals(serializable);
        serializable = bl2 ? this : new TreeRangeSet$SubRangeSet(this, range);
        return serializable;
    }
}

