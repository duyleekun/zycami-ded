/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DescendingImmutableSortedSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableRangeSet$AsSet$1;
import com.google.common.collect.ImmutableRangeSet$AsSet$2;
import com.google.common.collect.ImmutableRangeSet$AsSetSerializedForm;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Comparator;

public final class ImmutableRangeSet$AsSet
extends ImmutableSortedSet {
    private final DiscreteDomain domain;
    private transient Integer size;
    public final /* synthetic */ ImmutableRangeSet this$0;

    public ImmutableRangeSet$AsSet(ImmutableRangeSet object, DiscreteDomain discreteDomain) {
        this.this$0 = object;
        object = Ordering.natural();
        super((Comparator)object);
        this.domain = discreteDomain;
    }

    public static /* synthetic */ DiscreteDomain access$100(ImmutableRangeSet$AsSet immutableRangeSet$AsSet) {
        return immutableRangeSet$AsSet.domain;
    }

    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        try {
            object = (Comparable)object;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        ImmutableRangeSet immutableRangeSet = this.this$0;
        return immutableRangeSet.contains((Comparable)object);
    }

    public ImmutableSortedSet createDescendingSet() {
        DescendingImmutableSortedSet descendingImmutableSortedSet = new DescendingImmutableSortedSet(this);
        return descendingImmutableSortedSet;
    }

    public UnmodifiableIterator descendingIterator() {
        ImmutableRangeSet$AsSet$2 immutableRangeSet$AsSet$2 = new ImmutableRangeSet$AsSet$2(this);
        return immutableRangeSet$AsSet$2;
    }

    public ImmutableSortedSet headSetImpl(Comparable object, boolean bl2) {
        BoundType boundType = BoundType.forBoolean(bl2);
        object = Range.upTo((Comparable)object, boundType);
        return this.subSet((Range)object);
    }

    public int indexOf(Object object) {
        boolean bl2 = this.contains(object);
        if (bl2) {
            int n10;
            object = (Comparable)object;
            long l10 = 0L;
            Object object2 = ImmutableRangeSet.access$000(this.this$0).iterator();
            while ((n10 = object2.hasNext()) != 0) {
                Serializable serializable = (Range)object2.next();
                boolean bl3 = ((Range)serializable).contains((Comparable)object);
                if (bl3) {
                    object2 = this.domain;
                    long l11 = ContiguousSet.create((Range)serializable, (DiscreteDomain)object2).indexOf(object);
                    return Ints.saturatedCast(l10 + l11);
                }
                DiscreteDomain discreteDomain = this.domain;
                serializable = ContiguousSet.create((Range)serializable, discreteDomain);
                n10 = ((AbstractCollection)((Object)serializable)).size();
                long l12 = n10;
                l10 += l12;
            }
            object = new AssertionError((Object)"impossible");
            throw object;
        }
        return -1;
    }

    public boolean isPartialView() {
        return ImmutableRangeSet.access$000(this.this$0).isPartialView();
    }

    public UnmodifiableIterator iterator() {
        ImmutableRangeSet$AsSet$1 immutableRangeSet$AsSet$1 = new ImmutableRangeSet$AsSet$1(this);
        return immutableRangeSet$AsSet$1;
    }

    public int size() {
        Integer n10 = this.size;
        if (n10 == null) {
            Object object;
            long l10 = 0L;
            UnmodifiableIterator unmodifiableIterator = ImmutableRangeSet.access$000(this.this$0).iterator();
            while ((object = unmodifiableIterator.hasNext()) != 0) {
                Serializable serializable = (Range)unmodifiableIterator.next();
                DiscreteDomain discreteDomain = this.domain;
                serializable = ContiguousSet.create((Range)serializable, discreteDomain);
                long l11 = ((AbstractCollection)((Object)serializable)).size();
                long l12 = (l10 += l11) - (l11 = Integer.MAX_VALUE);
                object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object < 0) continue;
            }
            int n11 = Ints.saturatedCast(l10);
            this.size = n10 = Integer.valueOf(n11);
        }
        return n10;
    }

    public ImmutableSortedSet subSet(Range serializable) {
        serializable = this.this$0.subRangeSet((Range)serializable);
        DiscreteDomain discreteDomain = this.domain;
        return ((ImmutableRangeSet)serializable).asSet(discreteDomain);
    }

    public ImmutableSortedSet subSetImpl(Comparable object, boolean bl2, Comparable comparable, boolean bl3) {
        int n10;
        if (!bl2 && !bl3 && (n10 = Range.compareOrThrow((Comparable)object, comparable)) == 0) {
            return ImmutableSortedSet.of();
        }
        BoundType boundType = BoundType.forBoolean(bl2);
        BoundType boundType2 = BoundType.forBoolean(bl3);
        object = Range.range((Comparable)object, boundType, comparable, boundType2);
        return this.subSet((Range)object);
    }

    public ImmutableSortedSet tailSetImpl(Comparable object, boolean bl2) {
        BoundType boundType = BoundType.forBoolean(bl2);
        object = Range.downTo((Comparable)object, boundType);
        return this.subSet((Range)object);
    }

    public String toString() {
        return ImmutableRangeSet.access$000(this.this$0).toString();
    }

    public Object writeReplace() {
        ImmutableList immutableList = ImmutableRangeSet.access$000(this.this$0);
        DiscreteDomain discreteDomain = this.domain;
        ImmutableRangeSet$AsSetSerializedForm immutableRangeSet$AsSetSerializedForm = new ImmutableRangeSet$AsSetSerializedForm(immutableList, discreteDomain);
        return immutableRangeSet$AsSetSerializedForm;
    }
}

