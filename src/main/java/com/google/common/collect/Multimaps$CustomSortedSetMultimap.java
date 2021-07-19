/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractSortedSetMultimap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class Multimaps$CustomSortedSetMultimap
extends AbstractSortedSetMultimap {
    private static final long serialVersionUID;
    public transient Supplier factory;
    public transient Comparator valueComparator;

    public Multimaps$CustomSortedSetMultimap(Map comparator, Supplier supplier) {
        super((Map)((Object)comparator));
        comparator = (Supplier)Preconditions.checkNotNull(supplier);
        this.factory = comparator;
        this.valueComparator = comparator = ((SortedSet)supplier.get()).comparator();
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        Object object2 = (Supplier)((ObjectInputStream)object).readObject();
        this.factory = object2;
        this.valueComparator = object2 = ((SortedSet)object2.get()).comparator();
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

    public SortedSet createCollection() {
        return (SortedSet)this.factory.get();
    }

    public Set createKeySet() {
        return this.createMaybeNavigableKeySet();
    }

    public Comparator valueComparator() {
        return this.valueComparator;
    }
}

