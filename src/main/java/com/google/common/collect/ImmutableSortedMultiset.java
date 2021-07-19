/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.DescendingImmutableSortedMultiset;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSortedMultiset$Builder;
import com.google.common.collect.ImmutableSortedMultiset$SerializedForm;
import com.google.common.collect.ImmutableSortedMultisetFauxverideShim;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedMultiset;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedMultiset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class ImmutableSortedMultiset
extends ImmutableSortedMultisetFauxverideShim
implements SortedMultiset {
    public transient ImmutableSortedMultiset descendingMultiset;

    public static ImmutableSortedMultiset copyOf(Iterable iterable) {
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), iterable);
    }

    public static ImmutableSortedMultiset copyOf(Comparator comparator, Iterable iterable) {
        Object object;
        boolean bl2 = iterable instanceof ImmutableSortedMultiset;
        if (bl2) {
            object = iterable;
            object = (ImmutableSortedMultiset)iterable;
            Comparator comparator2 = ((ImmutableSortedMultiset)object).comparator();
            boolean bl3 = comparator.equals(comparator2);
            if (bl3) {
                boolean bl4 = ((ImmutableCollection)object).isPartialView();
                if (bl4) {
                    iterable = ((ImmutableMultiset)object).entrySet().asList();
                    return ImmutableSortedMultiset.copyOfSortedEntries(comparator, (Collection)iterable);
                }
                return object;
            }
        }
        object = new ImmutableSortedMultiset$Builder(comparator);
        return ((ImmutableSortedMultiset$Builder)((ImmutableSortedMultiset$Builder)object).addAll(iterable)).build();
    }

    public static ImmutableSortedMultiset copyOf(Comparator comparator, Iterator iterator2) {
        Preconditions.checkNotNull(comparator);
        ImmutableSortedMultiset$Builder immutableSortedMultiset$Builder = new ImmutableSortedMultiset$Builder(comparator);
        return ((ImmutableSortedMultiset$Builder)immutableSortedMultiset$Builder.addAll(iterator2)).build();
    }

    public static ImmutableSortedMultiset copyOf(Iterator iterator2) {
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), iterator2);
    }

    public static ImmutableSortedMultiset copyOf(Comparable[] object) {
        Ordering ordering = Ordering.natural();
        object = Arrays.asList(object);
        return ImmutableSortedMultiset.copyOf((Comparator)ordering, (Iterable)object);
    }

    public static ImmutableSortedMultiset copyOfSorted(SortedMultiset collection) {
        Comparator comparator = collection.comparator();
        collection = Lists.newArrayList(collection.entrySet());
        return ImmutableSortedMultiset.copyOfSortedEntries(comparator, collection);
    }

    private static ImmutableSortedMultiset copyOfSortedEntries(Comparator comparator, Collection collection) {
        boolean bl2;
        boolean bl3 = collection.isEmpty();
        if (bl3) {
            return ImmutableSortedMultiset.emptyMultiset(comparator);
        }
        int n10 = collection.size();
        Object object = new ImmutableList$Builder(n10);
        n10 = collection.size() + 1;
        long[] lArray = new long[n10];
        Object object2 = collection.iterator();
        int n11 = 0;
        RegularImmutableSortedSet regularImmutableSortedSet = null;
        while (bl2 = object2.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)object2.next();
            Object object3 = multiset$Entry.getElement();
            ((ImmutableList$Builder)object).add(object3);
            int n12 = n11 + 1;
            long l10 = lArray[n11];
            long l11 = multiset$Entry.getCount();
            lArray[n12] = l10 += l11;
            n11 = n12;
        }
        object = ((ImmutableList$Builder)object).build();
        regularImmutableSortedSet = new RegularImmutableSortedSet((ImmutableList)object, comparator);
        int n13 = collection.size();
        object2 = new RegularImmutableSortedMultiset(regularImmutableSortedSet, lArray, 0, n13);
        return object2;
    }

    public static ImmutableSortedMultiset emptyMultiset(Comparator comparator) {
        Object object = Ordering.natural();
        boolean bl2 = object.equals(comparator);
        if (bl2) {
            return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        object = new RegularImmutableSortedMultiset(comparator);
        return object;
    }

    public static ImmutableSortedMultiset$Builder naturalOrder() {
        Ordering ordering = Ordering.natural();
        ImmutableSortedMultiset$Builder immutableSortedMultiset$Builder = new ImmutableSortedMultiset$Builder(ordering);
        return immutableSortedMultiset$Builder;
    }

    public static ImmutableSortedMultiset of() {
        return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static ImmutableSortedMultiset of(Comparable object) {
        object = (RegularImmutableSortedSet)ImmutableSortedSet.of((Comparable)object);
        long[] lArray = new long[]{0L, 1L};
        RegularImmutableSortedMultiset regularImmutableSortedMultiset = new RegularImmutableSortedMultiset((RegularImmutableSortedSet)object, lArray, 0, 1);
        return regularImmutableSortedMultiset;
    }

    public static ImmutableSortedMultiset of(Comparable object, Comparable comparable) {
        Ordering ordering = Ordering.natural();
        Comparable[] comparableArray = new Comparable[]{object, comparable};
        object = Arrays.asList(comparableArray);
        return ImmutableSortedMultiset.copyOf((Comparator)ordering, (Iterable)object);
    }

    public static ImmutableSortedMultiset of(Comparable object, Comparable comparable, Comparable comparable2) {
        Ordering ordering = Ordering.natural();
        Comparable[] comparableArray = new Comparable[]{object, comparable, comparable2};
        object = Arrays.asList(comparableArray);
        return ImmutableSortedMultiset.copyOf((Comparator)ordering, (Iterable)object);
    }

    public static ImmutableSortedMultiset of(Comparable object, Comparable comparable, Comparable comparable2, Comparable comparable3) {
        Ordering ordering = Ordering.natural();
        Comparable[] comparableArray = new Comparable[]{object, comparable, comparable2, comparable3};
        object = Arrays.asList(comparableArray);
        return ImmutableSortedMultiset.copyOf((Comparator)ordering, (Iterable)object);
    }

    public static ImmutableSortedMultiset of(Comparable object, Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        Ordering ordering = Ordering.natural();
        Comparable[] comparableArray = new Comparable[]{object, comparable, comparable2, comparable3, comparable4};
        object = Arrays.asList(comparableArray);
        return ImmutableSortedMultiset.copyOf((Comparator)ordering, (Iterable)object);
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable ... comparableArray) {
        int n10 = comparableArray.length;
        int n11 = 6;
        ArrayList arrayList = Lists.newArrayListWithCapacity(n10 + n11);
        Comparable[] comparableArray2 = new Comparable[n11];
        comparableArray2[0] = comparable;
        comparableArray2[1] = comparable2;
        comparableArray2[2] = comparable3;
        comparableArray2[3] = comparable4;
        comparableArray2[4] = comparable5;
        comparableArray2[5] = comparable6;
        Collections.addAll(arrayList, comparableArray2);
        Collections.addAll(arrayList, comparableArray);
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), arrayList);
    }

    public static ImmutableSortedMultiset$Builder orderedBy(Comparator comparator) {
        ImmutableSortedMultiset$Builder immutableSortedMultiset$Builder = new ImmutableSortedMultiset$Builder(comparator);
        return immutableSortedMultiset$Builder;
    }

    public static ImmutableSortedMultiset$Builder reverseOrder() {
        Ordering ordering = Ordering.natural().reverse();
        ImmutableSortedMultiset$Builder immutableSortedMultiset$Builder = new ImmutableSortedMultiset$Builder(ordering);
        return immutableSortedMultiset$Builder;
    }

    public final Comparator comparator() {
        return ((ImmutableSortedSet)this.elementSet()).comparator();
    }

    public ImmutableSortedMultiset descendingMultiset() {
        ImmutableSortedMultiset immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            boolean bl2 = this.isEmpty();
            immutableSortedMultiset = bl2 ? ImmutableSortedMultiset.emptyMultiset(Ordering.from(this.comparator()).reverse()) : new DescendingImmutableSortedMultiset(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    public abstract ImmutableSortedSet elementSet();

    public abstract ImmutableSortedMultiset headMultiset(Object var1, BoundType var2);

    public final Multiset$Entry pollFirstEntry() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final Multiset$Entry pollLastEntry() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ImmutableSortedMultiset subMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        Comparator comparator = this.comparator();
        int n10 = comparator.compare(object, object2);
        if (n10 <= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            comparator = null;
        }
        Preconditions.checkArgument(n10 != 0, "Expected lowerBound <= upperBound but %s > %s", object, object2);
        return this.tailMultiset(object, boundType).headMultiset(object2, boundType2);
    }

    public abstract ImmutableSortedMultiset tailMultiset(Object var1, BoundType var2);

    public Object writeReplace() {
        ImmutableSortedMultiset$SerializedForm immutableSortedMultiset$SerializedForm = new ImmutableSortedMultiset$SerializedForm(this);
        return immutableSortedMultiset$SerializedForm;
    }
}

