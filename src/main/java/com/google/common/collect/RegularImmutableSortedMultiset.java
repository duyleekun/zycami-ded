/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.primitives.Ints;
import java.util.Comparator;

public final class RegularImmutableSortedMultiset
extends ImmutableSortedMultiset {
    public static final ImmutableSortedMultiset NATURAL_EMPTY_MULTISET;
    private static final long[] ZERO_CUMULATIVE_COUNTS;
    private final transient long[] cumulativeCounts;
    public final transient RegularImmutableSortedSet elementSet;
    private final transient int length;
    private final transient int offset;

    static {
        Object object = new long[]{0L};
        ZERO_CUMULATIVE_COUNTS = object;
        object = new RegularImmutableSortedMultiset;
        Ordering ordering = Ordering.natural();
        object(ordering);
        NATURAL_EMPTY_MULTISET = object;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet regularImmutableSortedSet, long[] lArray, int n10, int n11) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = lArray;
        this.offset = n10;
        this.length = n11;
    }

    public RegularImmutableSortedMultiset(Comparator object) {
        this.elementSet = object = ImmutableSortedSet.emptySet((Comparator)object);
        object = ZERO_CUMULATIVE_COUNTS;
        this.cumulativeCounts = (long[])object;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int n10) {
        long[] lArray = this.cumulativeCounts;
        int n11 = this.offset;
        int n12 = n11 + n10 + 1;
        long l10 = lArray[n12];
        long l11 = lArray[n11 += n10];
        return (int)(l10 - l11);
    }

    public int count(Object object) {
        RegularImmutableSortedSet regularImmutableSortedSet = this.elementSet;
        int n10 = regularImmutableSortedSet.indexOf(object);
        if (n10 >= 0) {
            n10 = this.getCount(n10);
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public ImmutableSortedSet elementSet() {
        return this.elementSet;
    }

    public Multiset$Entry firstEntry() {
        Multiset$Entry multiset$Entry;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            bl2 = false;
            multiset$Entry = null;
        } else {
            bl2 = false;
            multiset$Entry = this.getEntry(0);
        }
        return multiset$Entry;
    }

    public Multiset$Entry getEntry(int n10) {
        Object e10 = this.elementSet.asList().get(n10);
        n10 = this.getCount(n10);
        return Multisets.immutableEntry(e10, n10);
    }

    public ImmutableSortedMultiset getSubMultiset(int n10, int n11) {
        int n12 = this.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        if (n10 == n11) {
            return ImmutableSortedMultiset.emptyMultiset(this.comparator());
        }
        if (n10 == 0 && n11 == (n12 = this.length)) {
            return this;
        }
        RegularImmutableSortedSet regularImmutableSortedSet = this.elementSet.getSubSet(n10, n11);
        long[] lArray = this.cumulativeCounts;
        int n13 = this.offset + n10;
        RegularImmutableSortedMultiset regularImmutableSortedMultiset = new RegularImmutableSortedMultiset(regularImmutableSortedSet, lArray, n13, n11 -= n10);
        return regularImmutableSortedMultiset;
    }

    public ImmutableSortedMultiset headMultiset(Object object, BoundType object2) {
        boolean bl2;
        BoundType boundType;
        RegularImmutableSortedSet regularImmutableSortedSet = this.elementSet;
        if ((object2 = Preconditions.checkNotNull(object2)) == (boundType = BoundType.CLOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        int n10 = regularImmutableSortedSet.headIndex(object, bl2);
        return this.getSubMultiset(0, n10);
    }

    public boolean isPartialView() {
        long[] lArray;
        int n10;
        int n11 = this.offset;
        int n12 = 1;
        if (n11 <= 0 && (n11 = this.length) >= (n10 = (lArray = this.cumulativeCounts).length - n12)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public Multiset$Entry lastEntry() {
        Multiset$Entry multiset$Entry;
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = 0;
            multiset$Entry = null;
        } else {
            n10 = this.length + -1;
            multiset$Entry = this.getEntry(n10);
        }
        return multiset$Entry;
    }

    public int size() {
        long[] lArray = this.cumulativeCounts;
        int n10 = this.offset;
        int n11 = this.length + n10;
        long l10 = lArray[n11];
        long l11 = lArray[n10];
        return Ints.saturatedCast(l10 - l11);
    }

    public ImmutableSortedMultiset tailMultiset(Object object, BoundType object2) {
        int n10;
        BoundType boundType;
        RegularImmutableSortedSet regularImmutableSortedSet = this.elementSet;
        if ((object2 = Preconditions.checkNotNull(object2)) == (boundType = BoundType.CLOSED)) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        int n11 = regularImmutableSortedSet.tailIndex(object, n10 != 0);
        n10 = this.length;
        return this.getSubMultiset(n11, n10);
    }
}

