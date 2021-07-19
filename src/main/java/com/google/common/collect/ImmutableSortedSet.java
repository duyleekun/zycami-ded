/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet$Builder;
import com.google.common.collect.ImmutableSortedSet$SerializedForm;
import com.google.common.collect.ImmutableSortedSetFauxverideShim;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedIterable;
import com.google.common.collect.SortedIterables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class ImmutableSortedSet
extends ImmutableSortedSetFauxverideShim
implements NavigableSet,
SortedIterable {
    public final transient Comparator comparator;
    public transient ImmutableSortedSet descendingSet;

    public ImmutableSortedSet(Comparator comparator) {
        this.comparator = comparator;
    }

    public static ImmutableSortedSet construct(Comparator comparator, int n10, Object ... object) {
        int n11;
        if (n10 == 0) {
            return ImmutableSortedSet.emptySet(comparator);
        }
        ObjectArrays.checkElementsNotNull(object, n10);
        Arrays.sort(object, 0, n10, comparator);
        int n12 = n11 = 1;
        while (n11 < n10) {
            Object object2 = object[n11];
            int n13 = n12 + -1;
            Object object3 = object[n13];
            if ((n13 = comparator.compare(object2, object3)) != 0) {
                n13 = n12 + 1;
                object[n12] = object2;
                n12 = n13;
            }
            ++n11;
        }
        n11 = 0;
        Arrays.fill(object, n12, n10, null);
        n10 = ((Object[])object).length / 2;
        if (n12 < n10) {
            object = Arrays.copyOf(object, n12);
        }
        object = ImmutableList.asImmutableList(object, n12);
        RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet((ImmutableList)object, comparator);
        return regularImmutableSortedSet;
    }

    public static ImmutableSortedSet copyOf(Iterable iterable) {
        return ImmutableSortedSet.copyOf((Comparator)Ordering.natural(), iterable);
    }

    public static ImmutableSortedSet copyOf(Collection collection) {
        return ImmutableSortedSet.copyOf((Comparator)Ordering.natural(), collection);
    }

    public static ImmutableSortedSet copyOf(Comparator comparator, Iterable objectArray) {
        Preconditions.checkNotNull(comparator);
        int n10 = SortedIterables.hasSameComparator(comparator, (Iterable)objectArray);
        if (n10 != 0 && (n10 = objectArray instanceof ImmutableSortedSet) != 0) {
            Object object = objectArray;
            object = (ImmutableSortedSet)objectArray;
            boolean bl2 = ((ImmutableCollection)object).isPartialView();
            if (!bl2) {
                return object;
            }
        }
        objectArray = Iterables.toArray((Iterable)objectArray);
        n10 = objectArray.length;
        return ImmutableSortedSet.construct(comparator, n10, objectArray);
    }

    public static ImmutableSortedSet copyOf(Comparator comparator, Collection collection) {
        return ImmutableSortedSet.copyOf(comparator, (Iterable)collection);
    }

    public static ImmutableSortedSet copyOf(Comparator comparator, Iterator iterator2) {
        ImmutableSortedSet$Builder immutableSortedSet$Builder = new ImmutableSortedSet$Builder(comparator);
        return ((ImmutableSortedSet$Builder)immutableSortedSet$Builder.addAll(iterator2)).build();
    }

    public static ImmutableSortedSet copyOf(Iterator iterator2) {
        return ImmutableSortedSet.copyOf((Comparator)Ordering.natural(), iterator2);
    }

    public static ImmutableSortedSet copyOf(Comparable[] objectArray) {
        Ordering ordering = Ordering.natural();
        int n10 = objectArray.length;
        objectArray = (Object[])objectArray.clone();
        return ImmutableSortedSet.construct(ordering, n10, objectArray);
    }

    public static ImmutableSortedSet copyOfSorted(SortedSet collection) {
        Comparator comparator = SortedIterables.comparator((SortedSet)collection);
        boolean bl2 = ((AbstractCollection)(collection = ImmutableList.copyOf(collection))).isEmpty();
        if (bl2) {
            return ImmutableSortedSet.emptySet(comparator);
        }
        RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet((ImmutableList)collection, comparator);
        return regularImmutableSortedSet;
    }

    public static RegularImmutableSortedSet emptySet(Comparator comparator) {
        Object object = Ordering.natural();
        boolean bl2 = object.equals(comparator);
        if (bl2) {
            return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
        }
        ImmutableList immutableList = ImmutableList.of();
        object = new RegularImmutableSortedSet(immutableList, comparator);
        return object;
    }

    public static ImmutableSortedSet$Builder naturalOrder() {
        Ordering ordering = Ordering.natural();
        ImmutableSortedSet$Builder immutableSortedSet$Builder = new ImmutableSortedSet$Builder(ordering);
        return immutableSortedSet$Builder;
    }

    public static ImmutableSortedSet of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static ImmutableSortedSet of(Comparable object) {
        object = ImmutableList.of(object);
        Ordering ordering = Ordering.natural();
        RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet((ImmutableList)object, ordering);
        return regularImmutableSortedSet;
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        Ordering ordering = Ordering.natural();
        int n10 = 2;
        Object[] objectArray = new Comparable[n10];
        objectArray[0] = comparable;
        objectArray[1] = comparable2;
        return ImmutableSortedSet.construct(ordering, n10, objectArray);
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        Ordering ordering = Ordering.natural();
        int n10 = 3;
        Object[] objectArray = new Comparable[n10];
        objectArray[0] = comparable;
        objectArray[1] = comparable2;
        objectArray[2] = comparable3;
        return ImmutableSortedSet.construct(ordering, n10, objectArray);
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        Ordering ordering = Ordering.natural();
        int n10 = 4;
        Object[] objectArray = new Comparable[n10];
        objectArray[0] = comparable;
        objectArray[1] = comparable2;
        objectArray[2] = comparable3;
        objectArray[3] = comparable4;
        return ImmutableSortedSet.construct(ordering, n10, objectArray);
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        Ordering ordering = Ordering.natural();
        int n10 = 5;
        Object[] objectArray = new Comparable[n10];
        objectArray[0] = comparable;
        objectArray[1] = comparable2;
        objectArray[2] = comparable3;
        objectArray[3] = comparable4;
        objectArray[4] = comparable5;
        return ImmutableSortedSet.construct(ordering, n10, objectArray);
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable ... comparableArray) {
        int n10 = comparableArray.length;
        int n11 = 6;
        Object[] objectArray = new Comparable[n10 += n11];
        objectArray[0] = comparable;
        objectArray[1] = comparable2;
        objectArray[2] = comparable3;
        objectArray[3] = comparable4;
        objectArray[4] = comparable5;
        objectArray[5] = comparable6;
        int n12 = comparableArray.length;
        System.arraycopy(comparableArray, 0, objectArray, n11, n12);
        return ImmutableSortedSet.construct(Ordering.natural(), n10, objectArray);
    }

    public static ImmutableSortedSet$Builder orderedBy(Comparator comparator) {
        ImmutableSortedSet$Builder immutableSortedSet$Builder = new ImmutableSortedSet$Builder(comparator);
        return immutableSortedSet$Builder;
    }

    private void readObject(ObjectInputStream object) {
        object = new InvalidObjectException("Use SerializedForm");
        throw object;
    }

    public static ImmutableSortedSet$Builder reverseOrder() {
        Comparator comparator = Collections.reverseOrder();
        ImmutableSortedSet$Builder immutableSortedSet$Builder = new ImmutableSortedSet$Builder(comparator);
        return immutableSortedSet$Builder;
    }

    public static int unsafeCompare(Comparator comparator, Object object, Object object2) {
        return comparator.compare(object, object2);
    }

    public Object ceiling(Object object) {
        return Iterables.getFirst(this.tailSet(object, true), null);
    }

    public Comparator comparator() {
        return this.comparator;
    }

    public abstract ImmutableSortedSet createDescendingSet();

    public abstract UnmodifiableIterator descendingIterator();

    public ImmutableSortedSet descendingSet() {
        ImmutableSortedSet immutableSortedSet = this.descendingSet;
        if (immutableSortedSet == null) {
            this.descendingSet = immutableSortedSet = this.createDescendingSet();
            immutableSortedSet.descendingSet = this;
        }
        return immutableSortedSet;
    }

    public Object first() {
        return this.iterator().next();
    }

    public Object floor(Object object) {
        return Iterators.getNext(this.headSet(object, true).descendingIterator(), null);
    }

    public ImmutableSortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    public ImmutableSortedSet headSet(Object object, boolean bl2) {
        object = Preconditions.checkNotNull(object);
        return this.headSetImpl(object, bl2);
    }

    public abstract ImmutableSortedSet headSetImpl(Object var1, boolean var2);

    public Object higher(Object object) {
        return Iterables.getFirst(this.tailSet(object, false), null);
    }

    public abstract int indexOf(Object var1);

    public abstract UnmodifiableIterator iterator();

    public Object last() {
        return this.descendingIterator().next();
    }

    public Object lower(Object object) {
        return Iterators.getNext(this.headSet(object, false).descendingIterator(), null);
    }

    public final Object pollFirst() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final Object pollLast() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ImmutableSortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    /*
     * WARNING - void declaration
     */
    public ImmutableSortedSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        void var6_9;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Comparator comparator = this.comparator;
        int bl4 = comparator.compare(object, object2);
        if (bl4 <= 0) {
            boolean bl5 = true;
        } else {
            boolean bl6 = false;
            comparator = null;
        }
        Preconditions.checkArgument((boolean)var6_9);
        return this.subSetImpl(object, bl2, object2, bl3);
    }

    public abstract ImmutableSortedSet subSetImpl(Object var1, boolean var2, Object var3, boolean var4);

    public ImmutableSortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }

    public ImmutableSortedSet tailSet(Object object, boolean bl2) {
        object = Preconditions.checkNotNull(object);
        return this.tailSetImpl(object, bl2);
    }

    public abstract ImmutableSortedSet tailSetImpl(Object var1, boolean var2);

    public int unsafeCompare(Object object, Object object2) {
        return ImmutableSortedSet.unsafeCompare(this.comparator, object, object2);
    }

    public Object writeReplace() {
        Comparator comparator = this.comparator;
        Object[] objectArray = this.toArray();
        ImmutableSortedSet$SerializedForm immutableSortedSet$SerializedForm = new ImmutableSortedSet$SerializedForm(comparator, objectArray);
        return immutableSortedSet$SerializedForm;
    }
}

