/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable$1;
import com.google.common.collect.FluentIterable$2;
import com.google.common.collect.FluentIterable$3;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

public abstract class FluentIterable
implements Iterable {
    private final Optional iterableDelegate;

    public FluentIterable() {
        Optional optional;
        this.iterableDelegate = optional = Optional.absent();
    }

    public FluentIterable(Iterable object) {
        Preconditions.checkNotNull(object);
        if (this == object) {
            object = null;
        }
        this.iterableDelegate = object = Optional.fromNullable(object);
    }

    public static FluentIterable concat(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        FluentIterable$2 fluentIterable$2 = new FluentIterable$2(iterable);
        return fluentIterable$2;
    }

    public static FluentIterable concat(Iterable iterable, Iterable iterable2) {
        Iterable[] iterableArray = new Iterable[]{iterable, iterable2};
        return FluentIterable.concatNoDefensiveCopy(iterableArray);
    }

    public static FluentIterable concat(Iterable iterable, Iterable iterable2, Iterable iterable3) {
        Iterable[] iterableArray = new Iterable[]{iterable, iterable2, iterable3};
        return FluentIterable.concatNoDefensiveCopy(iterableArray);
    }

    public static FluentIterable concat(Iterable iterable, Iterable iterable2, Iterable iterable3, Iterable iterable4) {
        Iterable[] iterableArray = new Iterable[]{iterable, iterable2, iterable3, iterable4};
        return FluentIterable.concatNoDefensiveCopy(iterableArray);
    }

    public static FluentIterable concat(Iterable ... iterableArray) {
        int n10 = iterableArray.length;
        return FluentIterable.concatNoDefensiveCopy(Arrays.copyOf(iterableArray, n10));
    }

    private static FluentIterable concatNoDefensiveCopy(Iterable ... iterableArray) {
        int n10 = iterableArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Iterable iterable = iterableArray[i10];
            Preconditions.checkNotNull(iterable);
        }
        FluentIterable$3 fluentIterable$3 = new FluentIterable$3(iterableArray);
        return fluentIterable$3;
    }

    public static FluentIterable from(FluentIterable fluentIterable) {
        return (FluentIterable)Preconditions.checkNotNull(fluentIterable);
    }

    public static FluentIterable from(Iterable iterable) {
        boolean bl2 = iterable instanceof FluentIterable;
        if (bl2) {
            iterable = (FluentIterable)iterable;
        } else {
            FluentIterable$1 fluentIterable$1 = new FluentIterable$1(iterable, iterable);
            iterable = fluentIterable$1;
        }
        return iterable;
    }

    public static FluentIterable from(Object[] objectArray) {
        return FluentIterable.from(Arrays.asList(objectArray));
    }

    private Iterable getDelegate() {
        return (Iterable)this.iterableDelegate.or(this);
    }

    public static FluentIterable of() {
        return FluentIterable.from(ImmutableList.of());
    }

    public static FluentIterable of(Object object, Object ... objectArray) {
        return FluentIterable.from(Lists.asList(object, objectArray));
    }

    public final boolean allMatch(Predicate predicate) {
        return Iterables.all(this.getDelegate(), predicate);
    }

    public final boolean anyMatch(Predicate predicate) {
        return Iterables.any(this.getDelegate(), predicate);
    }

    public final FluentIterable append(Iterable iterable) {
        return FluentIterable.concat(this.getDelegate(), iterable);
    }

    public final FluentIterable append(Object ... object) {
        Iterable iterable = this.getDelegate();
        object = Arrays.asList(object);
        return FluentIterable.concat(iterable, (Iterable)object);
    }

    public final boolean contains(Object object) {
        return Iterables.contains(this.getDelegate(), object);
    }

    public final Collection copyInto(Collection collection) {
        Preconditions.checkNotNull(collection);
        Object object = this.getDelegate();
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            object = Collections2.cast((Iterable)object);
            collection.addAll(object);
        } else {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object e10 = object.next();
                collection.add(e10);
            }
        }
        return collection;
    }

    public final FluentIterable cycle() {
        return FluentIterable.from(Iterables.cycle(this.getDelegate()));
    }

    public final FluentIterable filter(Predicate predicate) {
        return FluentIterable.from(Iterables.filter(this.getDelegate(), predicate));
    }

    public final FluentIterable filter(Class clazz) {
        return FluentIterable.from(Iterables.filter(this.getDelegate(), clazz));
    }

    public final Optional first() {
        Iterator iterator2 = this.getDelegate().iterator();
        boolean bl2 = iterator2.hasNext();
        iterator2 = bl2 ? Optional.of(iterator2.next()) : Optional.absent();
        return iterator2;
    }

    public final Optional firstMatch(Predicate predicate) {
        return Iterables.tryFind(this.getDelegate(), predicate);
    }

    public final Object get(int n10) {
        return Iterables.get(this.getDelegate(), n10);
    }

    public final ImmutableListMultimap index(Function function) {
        return Multimaps.index(this.getDelegate(), function);
    }

    public final boolean isEmpty() {
        return this.getDelegate().iterator().hasNext() ^ true;
    }

    public final String join(Joiner joiner) {
        return joiner.join(this);
    }

    public final Optional last() {
        Iterable iterable = this.getDelegate();
        int n10 = iterable instanceof List;
        if (n10 != 0) {
            n10 = (iterable = (List)iterable).isEmpty();
            if (n10 != 0) {
                return Optional.absent();
            }
            n10 = iterable.size() + -1;
            return Optional.of(iterable.get(n10));
        }
        Iterator iterator2 = iterable.iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return Optional.absent();
        }
        bl2 = iterable instanceof SortedSet;
        if (bl2) {
            return Optional.of(((SortedSet)iterable).last());
        }
        do {
            iterable = iterator2.next();
        } while (bl2 = iterator2.hasNext());
        return Optional.of(iterable);
    }

    public final FluentIterable limit(int n10) {
        return FluentIterable.from(Iterables.limit(this.getDelegate(), n10));
    }

    public final int size() {
        return Iterables.size(this.getDelegate());
    }

    public final FluentIterable skip(int n10) {
        return FluentIterable.from(Iterables.skip(this.getDelegate(), n10));
    }

    public final Object[] toArray(Class clazz) {
        return Iterables.toArray(this.getDelegate(), clazz);
    }

    public final ImmutableList toList() {
        return ImmutableList.copyOf(this.getDelegate());
    }

    public final ImmutableMap toMap(Function function) {
        return Maps.toMap(this.getDelegate(), function);
    }

    public final ImmutableMultiset toMultiset() {
        return ImmutableMultiset.copyOf(this.getDelegate());
    }

    public final ImmutableSet toSet() {
        return ImmutableSet.copyOf(this.getDelegate());
    }

    public final ImmutableList toSortedList(Comparator comparator) {
        comparator = Ordering.from(comparator);
        Iterable iterable = this.getDelegate();
        return ((Ordering)comparator).immutableSortedCopy(iterable);
    }

    public final ImmutableSortedSet toSortedSet(Comparator comparator) {
        Iterable iterable = this.getDelegate();
        return ImmutableSortedSet.copyOf(comparator, iterable);
    }

    public String toString() {
        return Iterables.toString(this.getDelegate());
    }

    public final FluentIterable transform(Function function) {
        return FluentIterable.from(Iterables.transform(this.getDelegate(), function));
    }

    public FluentIterable transformAndConcat(Function function) {
        return FluentIterable.concat((Iterable)this.transform(function));
    }

    public final ImmutableMap uniqueIndex(Function function) {
        return Maps.uniqueIndex(this.getDelegate(), function);
    }
}

