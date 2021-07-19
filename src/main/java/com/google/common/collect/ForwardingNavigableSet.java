/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class ForwardingNavigableSet
extends ForwardingSortedSet
implements NavigableSet {
    public Object ceiling(Object object) {
        return this.delegate().ceiling(object);
    }

    public abstract NavigableSet delegate();

    public Iterator descendingIterator() {
        return this.delegate().descendingIterator();
    }

    public NavigableSet descendingSet() {
        return this.delegate().descendingSet();
    }

    public Object floor(Object object) {
        return this.delegate().floor(object);
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return this.delegate().headSet(object, bl2);
    }

    public Object higher(Object object) {
        return this.delegate().higher(object);
    }

    public Object lower(Object object) {
        return this.delegate().lower(object);
    }

    public Object pollFirst() {
        return this.delegate().pollFirst();
    }

    public Object pollLast() {
        return this.delegate().pollLast();
    }

    public Object standardCeiling(Object object) {
        return Iterators.getNext(this.tailSet(object, true).iterator(), null);
    }

    public Object standardFirst() {
        return this.iterator().next();
    }

    public Object standardFloor(Object object) {
        return Iterators.getNext(this.headSet(object, true).descendingIterator(), null);
    }

    public SortedSet standardHeadSet(Object object) {
        return this.headSet(object, false);
    }

    public Object standardHigher(Object object) {
        return Iterators.getNext(this.tailSet(object, false).iterator(), null);
    }

    public Object standardLast() {
        return this.descendingIterator().next();
    }

    public Object standardLower(Object object) {
        return Iterators.getNext(this.headSet(object, false).descendingIterator(), null);
    }

    public Object standardPollFirst() {
        return Iterators.pollNext(this.iterator());
    }

    public Object standardPollLast() {
        return Iterators.pollNext(this.descendingIterator());
    }

    public NavigableSet standardSubSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.tailSet(object, bl2).headSet(object2, bl3);
    }

    public SortedSet standardSubSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    public SortedSet standardTailSet(Object object) {
        return this.tailSet(object, true);
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.delegate().subSet(object, bl2, object2, bl3);
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return this.delegate().tailSet(object, bl2);
    }
}

