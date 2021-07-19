/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractRangeSet;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet$1;
import com.google.common.collect.ImmutableRangeSet$AsSet;
import com.google.common.collect.ImmutableRangeSet$Builder;
import com.google.common.collect.ImmutableRangeSet$ComplementRanges;
import com.google.common.collect.ImmutableRangeSet$SerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import com.google.common.collect.TreeRangeSet;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public final class ImmutableRangeSet
extends AbstractRangeSet
implements Serializable {
    private static final ImmutableRangeSet ALL;
    private static final ImmutableRangeSet EMPTY;
    private transient ImmutableRangeSet complement;
    private final transient ImmutableList ranges;

    static {
        ImmutableRangeSet immutableRangeSet;
        ImmutableList immutableList = ImmutableList.of();
        EMPTY = immutableRangeSet = new ImmutableRangeSet(immutableList);
        immutableList = ImmutableList.of(Range.all());
        ALL = immutableRangeSet = new ImmutableRangeSet(immutableList);
    }

    public ImmutableRangeSet(ImmutableList immutableList) {
        this.ranges = immutableList;
    }

    private ImmutableRangeSet(ImmutableList immutableList, ImmutableRangeSet immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static /* synthetic */ ImmutableList access$000(ImmutableRangeSet immutableRangeSet) {
        return immutableRangeSet.ranges;
    }

    public static ImmutableRangeSet all() {
        return ALL;
    }

    public static ImmutableRangeSet$Builder builder() {
        ImmutableRangeSet$Builder immutableRangeSet$Builder = new ImmutableRangeSet$Builder();
        return immutableRangeSet$Builder;
    }

    public static ImmutableRangeSet copyOf(RangeSet object) {
        Preconditions.checkNotNull(object);
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return ImmutableRangeSet.of();
        }
        Object object2 = Range.all();
        bl2 = object.encloses((Range)object2);
        if (bl2) {
            return ImmutableRangeSet.all();
        }
        bl2 = object instanceof ImmutableRangeSet;
        if (bl2) {
            object2 = object;
            object2 = (ImmutableRangeSet)object;
            boolean bl3 = ((ImmutableRangeSet)object2).isPartialView();
            if (!bl3) {
                return object2;
            }
        }
        object = ImmutableList.copyOf((Collection)object.asRanges());
        object2 = new ImmutableRangeSet((ImmutableList)object);
        return object2;
    }

    public static ImmutableRangeSet copyOf(Iterable iterable) {
        ImmutableRangeSet$Builder immutableRangeSet$Builder = new ImmutableRangeSet$Builder();
        return immutableRangeSet$Builder.addAll(iterable).build();
    }

    private ImmutableList intersectRanges(Range range) {
        Serializable serializable = this.ranges;
        int n10 = (int)(serializable.isEmpty() ? 1 : 0);
        if (n10 == 0 && (n10 = range.isEmpty()) == 0) {
            Enum enum_;
            Object object;
            Object object2;
            Object object3;
            serializable = this.span();
            n10 = range.encloses((Range)serializable);
            if (n10 != 0) {
                return this.ranges;
            }
            n10 = range.hasLowerBound();
            if (n10 != 0) {
                serializable = this.ranges;
                object3 = Range.upperBoundFn();
                object2 = range.lowerBound;
                object = SortedLists$KeyPresentBehavior.FIRST_AFTER;
                enum_ = SortedLists$KeyAbsentBehavior.NEXT_HIGHER;
                n10 = SortedLists.binarySearch((List)((Object)serializable), (Function)object3, (Comparable)object2, object, (SortedLists$KeyAbsentBehavior)enum_);
            } else {
                n10 = 0;
                serializable = null;
            }
            int n11 = range.hasUpperBound();
            if (n11 != 0) {
                object3 = this.ranges;
                object2 = Range.lowerBoundFn();
                object = range.upperBound;
                enum_ = SortedLists$KeyPresentBehavior.FIRST_PRESENT;
                SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior = SortedLists$KeyAbsentBehavior.NEXT_HIGHER;
                n11 = SortedLists.binarySearch((List)object3, (Function)object2, (Comparable)object, (SortedLists$KeyPresentBehavior)enum_, sortedLists$KeyAbsentBehavior);
            } else {
                object3 = this.ranges;
                n11 = ((AbstractCollection)object3).size();
            }
            if ((n11 -= n10) == 0) {
                return ImmutableList.of();
            }
            object2 = new ImmutableRangeSet$1(this, n11, n10, range);
            return object2;
        }
        return ImmutableList.of();
    }

    public static ImmutableRangeSet of() {
        return EMPTY;
    }

    public static ImmutableRangeSet of(Range serializable) {
        Preconditions.checkNotNull(serializable);
        boolean bl2 = serializable.isEmpty();
        if (bl2) {
            return ImmutableRangeSet.of();
        }
        Serializable serializable2 = Range.all();
        bl2 = serializable.equals(serializable2);
        if (bl2) {
            return ImmutableRangeSet.all();
        }
        serializable = ImmutableList.of(serializable);
        serializable2 = new ImmutableRangeSet((ImmutableList)serializable);
        return serializable2;
    }

    public static ImmutableRangeSet unionOf(Iterable iterable) {
        return ImmutableRangeSet.copyOf(TreeRangeSet.create(iterable));
    }

    public void add(Range serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void addAll(RangeSet object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void addAll(Iterable object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableSet asDescendingSetOfRanges() {
        ImmutableCollection immutableCollection = this.ranges;
        boolean bl2 = immutableCollection.isEmpty();
        if (bl2) {
            return ImmutableSet.of();
        }
        ImmutableList immutableList = this.ranges.reverse();
        Ordering ordering = Range.rangeLexOrdering().reverse();
        immutableCollection = new RegularImmutableSortedSet(immutableList, ordering);
        return immutableCollection;
    }

    public ImmutableSet asRanges() {
        ImmutableCollection immutableCollection = this.ranges;
        boolean bl2 = immutableCollection.isEmpty();
        if (bl2) {
            return ImmutableSet.of();
        }
        ImmutableList immutableList = this.ranges;
        Ordering ordering = Range.rangeLexOrdering();
        immutableCollection = new RegularImmutableSortedSet(immutableList, ordering);
        return immutableCollection;
    }

    public ImmutableSortedSet asSet(DiscreteDomain object) {
        Preconditions.checkNotNull(object);
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return ImmutableSortedSet.of();
        }
        Serializable serializable = this.span().canonical((DiscreteDomain)object);
        boolean bl3 = serializable.hasLowerBound();
        if (bl3) {
            bl2 = serializable.hasUpperBound();
            if (!bl2) {
                try {
                    ((DiscreteDomain)object).maxValue();
                }
                catch (NoSuchElementException noSuchElementException) {
                    object = new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                    throw object;
                }
            }
            serializable = new ImmutableRangeSet$AsSet(this, (DiscreteDomain)object);
            return serializable;
        }
        object = new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        throw object;
    }

    public ImmutableRangeSet complement() {
        Serializable serializable;
        int n10;
        Serializable serializable2 = this.complement;
        if (serializable2 != null) {
            return serializable2;
        }
        serializable2 = this.ranges;
        boolean n11 = ((AbstractCollection)((Object)serializable2)).isEmpty();
        if (n11) {
            serializable2 = ImmutableRangeSet.all();
            this.complement = serializable2;
            return serializable2;
        }
        serializable2 = this.ranges;
        int n12 = ((AbstractCollection)((Object)serializable2)).size();
        if (n12 == (n10 = 1)) {
            serializable2 = this.ranges;
            n10 = 0;
            boolean bl2 = ((Range)(serializable2 = (Range)serializable2.get(0))).equals(serializable = Range.all());
            if (bl2) {
                serializable2 = ImmutableRangeSet.of();
                this.complement = serializable2;
                return serializable2;
            }
        }
        serializable2 = new ImmutableRangeSet$ComplementRanges(this);
        this.complement = serializable = new ImmutableRangeSet((ImmutableList)serializable2, this);
        return serializable;
    }

    public ImmutableRangeSet difference(RangeSet rangeSet) {
        TreeRangeSet treeRangeSet = TreeRangeSet.create(this);
        treeRangeSet.removeAll(rangeSet);
        return ImmutableRangeSet.copyOf(treeRangeSet);
    }

    public boolean encloses(Range range) {
        boolean bl2;
        int n10;
        SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior;
        SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior;
        Ordering ordering;
        Cut cut;
        Serializable serializable = this.ranges;
        Object object = Range.lowerBoundFn();
        int n11 = SortedLists.binarySearch((List)((Object)serializable), (Function)object, cut = range.lowerBound, ordering = Ordering.natural(), sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.ANY_PRESENT, sortedLists$KeyAbsentBehavior = SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (n11 != (n10 = -1) && (bl2 = ((Range)(serializable = (Range)(object = this.ranges).get(n11))).encloses(range))) {
            bl2 = true;
        } else {
            bl2 = false;
            range = null;
        }
        return bl2;
    }

    public ImmutableRangeSet intersection(RangeSet rangeSet) {
        TreeRangeSet treeRangeSet = TreeRangeSet.create(this);
        rangeSet = rangeSet.complement();
        treeRangeSet.removeAll(rangeSet);
        return ImmutableRangeSet.copyOf(treeRangeSet);
    }

    public boolean intersects(Range range) {
        int n10;
        block5: {
            Cut cut;
            block4: {
                boolean bl2;
                Serializable serializable = this.ranges;
                Object object = Range.lowerBoundFn();
                cut = range.lowerBound;
                Ordering ordering = Ordering.natural();
                SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.ANY_PRESENT;
                SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior = SortedLists$KeyAbsentBehavior.NEXT_HIGHER;
                int n11 = SortedLists.binarySearch((List)((Object)serializable), (Function)object, cut, ordering, sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
                object = this.ranges;
                int n12 = ((AbstractCollection)object).size();
                n10 = 1;
                if (n11 < n12 && (n12 = (int)(((Range)(object = (Range)this.ranges.get(n11))).isConnected(range) ? 1 : 0)) != 0 && (n12 = (int)(((Range)(object = ((Range)this.ranges.get(n11)).intersection(range))).isEmpty() ? 1 : 0)) == 0) {
                    return n10 != 0;
                }
                if (n11 <= 0) break block4;
                object = this.ranges;
                n12 = (int)(((Range)(object = (Range)object.get(n11 -= n10))).isConnected(range) ? 1 : 0);
                if (n12 != 0 && !(bl2 = (range = ((Range)(serializable = (Range)(object = this.ranges).get(n11))).intersection(range)).isEmpty())) break block5;
            }
            n10 = 0;
            cut = null;
        }
        return n10 != 0;
    }

    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    public Range rangeContaining(Comparable comparable) {
        boolean bl2;
        Serializable serializable = this.ranges;
        Object object = Range.lowerBoundFn();
        Serializable serializable2 = Cut.belowValue(comparable);
        Ordering ordering = Ordering.natural();
        SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.ANY_PRESENT;
        SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior = SortedLists$KeyAbsentBehavior.NEXT_LOWER;
        int n10 = SortedLists.binarySearch((List)((Object)serializable), (Function)object, serializable2, ordering, sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
        object = null;
        int n11 = -1;
        if (n10 != n11 && (bl2 = ((Range)(serializable = (Range)(serializable2 = this.ranges).get(n10))).contains(comparable))) {
            object = serializable;
        }
        return object;
    }

    public void remove(Range serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void removeAll(RangeSet object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void removeAll(Iterable object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Range span() {
        Serializable serializable = this.ranges;
        boolean bl2 = serializable.isEmpty();
        if (!bl2) {
            serializable = ((Range)this.ranges.get((int)0)).lowerBound;
            Serializable serializable2 = this.ranges;
            int n10 = serializable2.size() + -1;
            serializable2 = ((Range)serializable2.get((int)n10)).upperBound;
            return Range.create((Cut)serializable, (Cut)serializable2);
        }
        serializable = new NoSuchElementException();
        throw serializable;
    }

    public ImmutableRangeSet subRangeSet(Range serializable) {
        boolean bl2 = this.isEmpty();
        if (!bl2) {
            Serializable serializable2 = this.span();
            boolean bl3 = serializable.encloses((Range)serializable2);
            if (bl3) {
                return this;
            }
            bl2 = serializable.isConnected((Range)serializable2);
            if (bl2) {
                serializable = this.intersectRanges((Range)serializable);
                serializable2 = new ImmutableRangeSet((ImmutableList)serializable);
                return serializable2;
            }
        }
        return ImmutableRangeSet.of();
    }

    public ImmutableRangeSet union(RangeSet object) {
        ImmutableSet immutableSet = this.asRanges();
        object = object.asRanges();
        return ImmutableRangeSet.unionOf(Iterables.concat((Iterable)immutableSet, (Iterable)object));
    }

    public Object writeReplace() {
        ImmutableList immutableList = this.ranges;
        ImmutableRangeSet$SerializedForm immutableRangeSet$SerializedForm = new ImmutableRangeSet$SerializedForm(immutableList);
        return immutableRangeSet$SerializedForm;
    }
}

