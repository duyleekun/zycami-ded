/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedNavigableSet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSortedSet;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.Sets;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public class Multimaps$CustomSetMultimap
extends AbstractSetMultimap {
    private static final long serialVersionUID;
    public transient Supplier factory;

    public Multimaps$CustomSetMultimap(Map object, Supplier supplier) {
        super((Map)object);
        this.factory = object = (Supplier)Preconditions.checkNotNull(supplier);
    }

    private void readObject(ObjectInputStream object) {
        Supplier supplier;
        ((ObjectInputStream)object).defaultReadObject();
        this.factory = supplier = (Supplier)((ObjectInputStream)object).readObject();
        object = (Map)((ObjectInputStream)object).readObject();
        this.setMap((Map)object);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Object object = this.factory;
        objectOutputStream.writeObject(object);
        object = this.backingMap();
        objectOutputStream.writeObject(object);
    }

    public Map createAsMap() {
        return this.createMaybeNavigableAsMap();
    }

    public Set createCollection() {
        return (Set)this.factory.get();
    }

    public Set createKeySet() {
        return this.createMaybeNavigableKeySet();
    }

    public Collection unmodifiableCollectionSubclass(Collection collection) {
        boolean bl2 = collection instanceof NavigableSet;
        if (bl2) {
            return Sets.unmodifiableNavigableSet((NavigableSet)collection);
        }
        bl2 = collection instanceof SortedSet;
        if (bl2) {
            return Collections.unmodifiableSortedSet((SortedSet)collection);
        }
        return Collections.unmodifiableSet((Set)collection);
    }

    public Collection wrapCollection(Object object, Collection collection) {
        boolean bl2 = collection instanceof NavigableSet;
        if (bl2) {
            collection = (NavigableSet)collection;
            AbstractMapBasedMultimap$WrappedNavigableSet abstractMapBasedMultimap$WrappedNavigableSet = new AbstractMapBasedMultimap$WrappedNavigableSet((AbstractMapBasedMultimap)this, object, (NavigableSet)collection, null);
            return abstractMapBasedMultimap$WrappedNavigableSet;
        }
        bl2 = collection instanceof SortedSet;
        if (bl2) {
            collection = (SortedSet)collection;
            AbstractMapBasedMultimap$WrappedSortedSet abstractMapBasedMultimap$WrappedSortedSet = new AbstractMapBasedMultimap$WrappedSortedSet((AbstractMapBasedMultimap)this, object, (SortedSet)collection, null);
            return abstractMapBasedMultimap$WrappedSortedSet;
        }
        collection = (Set)collection;
        AbstractMapBasedMultimap$WrappedSet abstractMapBasedMultimap$WrappedSet = new AbstractMapBasedMultimap$WrappedSet(this, object, (Set)collection);
        return abstractMapBasedMultimap$WrappedSet;
    }
}

