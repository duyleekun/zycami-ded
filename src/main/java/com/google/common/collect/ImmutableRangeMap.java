/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap$1;
import com.google.common.collect.ImmutableRangeMap$2;
import com.google.common.collect.ImmutableRangeMap$Builder;
import com.google.common.collect.ImmutableRangeMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ImmutableRangeMap
implements RangeMap,
Serializable {
    private static final ImmutableRangeMap EMPTY;
    private static final long serialVersionUID;
    private final transient ImmutableList ranges;
    private final transient ImmutableList values;

    static {
        ImmutableRangeMap immutableRangeMap;
        ImmutableList immutableList = ImmutableList.of();
        ImmutableList immutableList2 = ImmutableList.of();
        EMPTY = immutableRangeMap = new ImmutableRangeMap(immutableList, immutableList2);
    }

    public ImmutableRangeMap(ImmutableList immutableList, ImmutableList immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static /* synthetic */ ImmutableList access$000(ImmutableRangeMap immutableRangeMap) {
        return immutableRangeMap.ranges;
    }

    public static ImmutableRangeMap$Builder builder() {
        ImmutableRangeMap$Builder immutableRangeMap$Builder = new ImmutableRangeMap$Builder();
        return immutableRangeMap$Builder;
    }

    public static ImmutableRangeMap copyOf(RangeMap object) {
        boolean bl2 = object instanceof ImmutableRangeMap;
        if (bl2) {
            return (ImmutableRangeMap)object;
        }
        object = object.asMapOfRanges();
        int n10 = object.size();
        Object object2 = new ImmutableList$Builder(n10);
        int n11 = object.size();
        Object object3 = new ImmutableList$Builder(n11);
        object = object.entrySet().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = object.next();
            Object k10 = entry.getKey();
            ((ImmutableList$Builder)object2).add(k10);
            entry = entry.getValue();
            ((ImmutableList$Builder)object3).add(entry);
        }
        object2 = ((ImmutableList$Builder)object2).build();
        object3 = ((ImmutableList$Builder)object3).build();
        object = new ImmutableRangeMap((ImmutableList)object2, (ImmutableList)object3);
        return object;
    }

    public static ImmutableRangeMap of() {
        return EMPTY;
    }

    public static ImmutableRangeMap of(Range serializable, Object object) {
        serializable = ImmutableList.of(serializable);
        object = ImmutableList.of(object);
        ImmutableRangeMap immutableRangeMap = new ImmutableRangeMap((ImmutableList)serializable, (ImmutableList)object);
        return immutableRangeMap;
    }

    public ImmutableMap asDescendingMapOfRanges() {
        ImmutableCollection immutableCollection = this.ranges;
        boolean bl2 = immutableCollection.isEmpty();
        if (bl2) {
            return ImmutableMap.of();
        }
        Serializable serializable = this.ranges.reverse();
        Object object = Range.rangeLexOrdering().reverse();
        immutableCollection = new RegularImmutableSortedSet((ImmutableList)serializable, (Comparator)object);
        object = this.values.reverse();
        serializable = new ImmutableSortedMap((RegularImmutableSortedSet)immutableCollection, (ImmutableList)object);
        return serializable;
    }

    public ImmutableMap asMapOfRanges() {
        ImmutableCollection immutableCollection = this.ranges;
        boolean bl2 = immutableCollection.isEmpty();
        if (bl2) {
            return ImmutableMap.of();
        }
        Serializable serializable = this.ranges;
        Object object = Range.rangeLexOrdering();
        immutableCollection = new RegularImmutableSortedSet((ImmutableList)serializable, (Comparator)object);
        object = this.values;
        serializable = new ImmutableSortedMap((RegularImmutableSortedSet)immutableCollection, (ImmutableList)object);
        return serializable;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof RangeMap;
        if (bl2) {
            object = (RangeMap)object;
            ImmutableMap immutableMap = this.asMapOfRanges();
            object = object.asMapOfRanges();
            return immutableMap.equals(object);
        }
        return false;
    }

    public Object get(Comparable object) {
        ImmutableList immutableList = this.ranges;
        Function function = Range.lowerBoundFn();
        Serializable serializable = Cut.belowValue((Comparable)object);
        SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.ANY_PRESENT;
        SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior = SortedLists$KeyAbsentBehavior.NEXT_LOWER;
        int n10 = SortedLists.binarySearch((List)immutableList, function, (Comparable)((Object)serializable), sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
        function = null;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        serializable = (Range)this.ranges.get(n10);
        boolean bl2 = ((Range)serializable).contains((Comparable)object);
        if (bl2) {
            object = this.values;
            function = object.get(n10);
        }
        return function;
    }

    public Map.Entry getEntry(Comparable comparable) {
        ImmutableList immutableList = this.ranges;
        Object object = Range.lowerBoundFn();
        Serializable serializable = Cut.belowValue(comparable);
        SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.ANY_PRESENT;
        SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior = SortedLists$KeyAbsentBehavior.NEXT_LOWER;
        int n10 = SortedLists.binarySearch((List)immutableList, (Function)object, (Comparable)((Object)serializable), sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
        object = null;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        serializable = (Range)this.ranges.get(n10);
        boolean bl2 = ((Range)serializable).contains(comparable);
        if (bl2) {
            comparable = this.values.get(n10);
            object = Maps.immutableEntry(serializable, comparable);
        }
        return object;
    }

    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }

    public void put(Range serializable, Object object) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void putAll(RangeMap object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void putCoalescing(Range serializable, Object object) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void remove(Range serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public Range span() {
        Serializable serializable = this.ranges;
        boolean bl2 = serializable.isEmpty();
        if (!bl2) {
            serializable = (Range)this.ranges.get(0);
            Serializable serializable2 = this.ranges;
            int n10 = serializable2.size() + -1;
            serializable2 = (Range)serializable2.get(n10);
            serializable = ((Range)serializable).lowerBound;
            serializable2 = ((Range)serializable2).upperBound;
            return Range.create((Cut)serializable, (Cut)serializable2);
        }
        serializable = new NoSuchElementException();
        throw serializable;
    }

    public ImmutableRangeMap subRangeMap(Range range) {
        boolean bl2;
        Serializable serializable = (Range)Preconditions.checkNotNull(range);
        boolean n10 = ((Range)serializable).isEmpty();
        if (n10) {
            return ImmutableRangeMap.of();
        }
        serializable = this.ranges;
        boolean bl3 = ((AbstractCollection)((Object)serializable)).isEmpty();
        if (!bl3 && !(bl2 = range.encloses((Range)(serializable = this.span())))) {
            Object object;
            int n11;
            serializable = this.ranges;
            Object object2 = Range.upperBoundFn();
            Object object3 = range.lowerBound;
            Object object4 = SortedLists$KeyPresentBehavior.FIRST_AFTER;
            Object object5 = SortedLists$KeyAbsentBehavior.NEXT_HIGHER;
            int n12 = SortedLists.binarySearch((List)((Object)serializable), (Function)object2, (Comparable)object3, object4, object5);
            if (n12 >= (n11 = SortedLists.binarySearch((List)(object2 = this.ranges), (Function)(object3 = Range.lowerBoundFn()), (Comparable)(object4 = range.upperBound), object = SortedLists$KeyPresentBehavior.ANY_PRESENT, object5))) {
                return ImmutableRangeMap.of();
            }
            int n13 = n11 - n12;
            object = new ImmutableRangeMap$1(this, n13, n12, range);
            ImmutableList immutableList = this.values.subList(n12, n11);
            object4 = object3;
            object5 = this;
            object3 = new ImmutableRangeMap$2(this, (ImmutableList)object, immutableList, range, this);
            return object3;
        }
        return this;
    }

    public String toString() {
        return this.asMapOfRanges().toString();
    }

    public Object writeReplace() {
        ImmutableMap immutableMap = this.asMapOfRanges();
        ImmutableRangeMap$SerializedForm immutableRangeMap$SerializedForm = new ImmutableRangeMap$SerializedForm(immutableMap);
        return immutableRangeMap$SerializedForm;
    }
}

