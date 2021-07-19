/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class Collections2$FilteredCollection
extends AbstractCollection {
    public final Predicate predicate;
    public final Collection unfiltered;

    public Collections2$FilteredCollection(Collection collection, Predicate predicate) {
        this.unfiltered = collection;
        this.predicate = predicate;
    }

    public boolean add(Object object) {
        Preconditions.checkArgument(this.predicate.apply(object));
        return this.unfiltered.add(object);
    }

    public boolean addAll(Collection collection) {
        boolean bl2;
        Iterator iterator2 = collection.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Predicate predicate = this.predicate;
            bl2 = predicate.apply(e10);
            Preconditions.checkArgument(bl2);
        }
        return this.unfiltered.addAll(collection);
    }

    public void clear() {
        Collection collection = this.unfiltered;
        Predicate predicate = this.predicate;
        Iterables.removeIf(collection, predicate);
    }

    public boolean contains(Object object) {
        Collection collection = this.unfiltered;
        boolean bl2 = Collections2.safeContains(collection, object);
        if (bl2) {
            return this.predicate.apply(object);
        }
        return false;
    }

    public boolean containsAll(Collection collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    public Collections2$FilteredCollection createCombined(Predicate predicate) {
        Collection collection = this.unfiltered;
        predicate = Predicates.and(this.predicate, predicate);
        Collections2$FilteredCollection collections2$FilteredCollection = new Collections2$FilteredCollection(collection, predicate);
        return collections2$FilteredCollection;
    }

    public boolean isEmpty() {
        Collection collection = this.unfiltered;
        Predicate predicate = this.predicate;
        return Iterables.any(collection, predicate) ^ true;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.unfiltered.iterator();
        Predicate predicate = this.predicate;
        return Iterators.filter(iterator2, predicate);
    }

    public boolean remove(Object object) {
        Collection collection;
        boolean bl2;
        boolean bl3 = this.contains(object);
        if (bl3 && (bl2 = (collection = this.unfiltered).remove(object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean removeAll(Collection collection) {
        boolean bl2;
        Iterator iterator2 = this.unfiltered.iterator();
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Predicate predicate = this.predicate;
            Object e10 = iterator2.next();
            boolean bl4 = predicate.apply(e10);
            if (!bl4 || !(bl2 = collection.contains(e10))) continue;
            iterator2.remove();
            bl3 = true;
        }
        return bl3;
    }

    public boolean retainAll(Collection collection) {
        boolean bl2;
        Iterator iterator2 = this.unfiltered.iterator();
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Predicate predicate = this.predicate;
            Object e10 = iterator2.next();
            boolean bl4 = predicate.apply(e10);
            if (!bl4 || (bl2 = collection.contains(e10))) continue;
            iterator2.remove();
            bl3 = true;
        }
        return bl3;
    }

    public int size() {
        boolean bl2;
        Iterator iterator2 = this.unfiltered.iterator();
        int n10 = 0;
        while (bl2 = iterator2.hasNext()) {
            Predicate predicate = this.predicate;
            Object e10 = iterator2.next();
            bl2 = predicate.apply(e10);
            if (!bl2) continue;
            ++n10;
        }
        return n10;
    }

    public Object[] toArray() {
        return Lists.newArrayList(this.iterator()).toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return Lists.newArrayList(this.iterator()).toArray(objectArray);
    }
}

