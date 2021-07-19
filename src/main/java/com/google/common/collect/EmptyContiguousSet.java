/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet$SerializedForm;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;
import java.util.Set;

public final class EmptyContiguousSet
extends ContiguousSet {
    public EmptyContiguousSet(DiscreteDomain discreteDomain) {
        super(discreteDomain);
    }

    public ImmutableList asList() {
        return ImmutableList.of();
    }

    public boolean contains(Object object) {
        return false;
    }

    public ImmutableSortedSet createDescendingSet() {
        return ImmutableSortedSet.emptySet(Ordering.natural().reverse());
    }

    public UnmodifiableIterator descendingIterator() {
        return Iterators.emptyIterator();
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Set;
        if (bl2) {
            return ((Set)object).isEmpty();
        }
        return false;
    }

    public Comparable first() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public int hashCode() {
        return 0;
    }

    public ContiguousSet headSetImpl(Comparable comparable, boolean bl2) {
        return this;
    }

    public int indexOf(Object object) {
        return -1;
    }

    public ContiguousSet intersection(ContiguousSet contiguousSet) {
        return this;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isHashCodeFast() {
        return true;
    }

    public boolean isPartialView() {
        return false;
    }

    public UnmodifiableIterator iterator() {
        return Iterators.emptyIterator();
    }

    public Comparable last() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public Range range() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public Range range(BoundType object, BoundType boundType) {
        object = new NoSuchElementException();
        throw object;
    }

    public int size() {
        return 0;
    }

    public ContiguousSet subSetImpl(Comparable comparable, boolean bl2, Comparable comparable2, boolean bl3) {
        return this;
    }

    public ContiguousSet tailSetImpl(Comparable comparable, boolean bl2) {
        return this;
    }

    public String toString() {
        return "[]";
    }

    public Object writeReplace() {
        DiscreteDomain discreteDomain = this.domain;
        EmptyContiguousSet$SerializedForm emptyContiguousSet$SerializedForm = new EmptyContiguousSet$SerializedForm(discreteDomain, null);
        return emptyContiguousSet$SerializedForm;
    }
}

