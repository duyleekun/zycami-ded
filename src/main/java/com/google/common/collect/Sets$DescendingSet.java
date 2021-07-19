/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public class Sets$DescendingSet
extends ForwardingNavigableSet {
    private final NavigableSet forward;

    public Sets$DescendingSet(NavigableSet navigableSet) {
        this.forward = navigableSet;
    }

    private static Ordering reverse(Comparator comparator) {
        return Ordering.from(comparator).reverse();
    }

    public Object ceiling(Object object) {
        return this.forward.floor(object);
    }

    public Comparator comparator() {
        Comparator comparator = this.forward.comparator();
        if (comparator == null) {
            return Ordering.natural().reverse();
        }
        return Sets$DescendingSet.reverse(comparator);
    }

    public NavigableSet delegate() {
        return this.forward;
    }

    public Iterator descendingIterator() {
        return this.forward.iterator();
    }

    public NavigableSet descendingSet() {
        return this.forward;
    }

    public Object first() {
        return this.forward.last();
    }

    public Object floor(Object object) {
        return this.forward.ceiling(object);
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return this.forward.tailSet(object, bl2).descendingSet();
    }

    public SortedSet headSet(Object object) {
        return this.standardHeadSet(object);
    }

    public Object higher(Object object) {
        return this.forward.lower(object);
    }

    public Iterator iterator() {
        return this.forward.descendingIterator();
    }

    public Object last() {
        return this.forward.first();
    }

    public Object lower(Object object) {
        return this.forward.higher(object);
    }

    public Object pollFirst() {
        return this.forward.pollLast();
    }

    public Object pollLast() {
        return this.forward.pollFirst();
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.forward.subSet(object2, bl3, object, bl2).descendingSet();
    }

    public SortedSet subSet(Object object, Object object2) {
        return this.standardSubSet(object, object2);
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return this.forward.headSet(object, bl2).descendingSet();
    }

    public SortedSet tailSet(Object object) {
        return this.standardTailSet(object);
    }

    public Object[] toArray() {
        return this.standardToArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.standardToArray(objectArray);
    }

    public String toString() {
        return this.standardToString();
    }
}

