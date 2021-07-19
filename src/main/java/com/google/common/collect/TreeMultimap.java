/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractSortedKeySortedSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMultimap
extends AbstractSortedKeySortedSetMultimap {
    private static final long serialVersionUID;
    private transient Comparator keyComparator;
    private transient Comparator valueComparator;

    public TreeMultimap(Comparator comparator, Comparator comparator2) {
        TreeMap treeMap = new TreeMap(comparator);
        super(treeMap);
        this.keyComparator = comparator;
        this.valueComparator = comparator2;
    }

    private TreeMultimap(Comparator comparator, Comparator comparator2, Multimap multimap) {
        this(comparator, comparator2);
        this.putAll(multimap);
    }

    public static TreeMultimap create() {
        Ordering ordering = Ordering.natural();
        Ordering ordering2 = Ordering.natural();
        TreeMultimap treeMultimap = new TreeMultimap(ordering, ordering2);
        return treeMultimap;
    }

    public static TreeMultimap create(Multimap multimap) {
        Ordering ordering = Ordering.natural();
        Ordering ordering2 = Ordering.natural();
        TreeMultimap treeMultimap = new TreeMultimap(ordering, ordering2, multimap);
        return treeMultimap;
    }

    public static TreeMultimap create(Comparator comparator, Comparator comparator2) {
        comparator = (Comparator)Preconditions.checkNotNull(comparator);
        comparator2 = (Comparator)Preconditions.checkNotNull(comparator2);
        TreeMultimap treeMultimap = new TreeMultimap(comparator, comparator2);
        return treeMultimap;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        TreeMap treeMap = (Comparator)Preconditions.checkNotNull((Comparator)objectInputStream.readObject());
        this.keyComparator = treeMap;
        treeMap = (Comparator)Preconditions.checkNotNull((Comparator)objectInputStream.readObject());
        this.valueComparator = treeMap;
        Comparator comparator = this.keyComparator;
        treeMap = new TreeMap(comparator);
        this.setMap(treeMap);
        Serialization.populateMultimap(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Comparator comparator = this.keyComparator();
        objectOutputStream.writeObject(comparator);
        comparator = this.valueComparator();
        objectOutputStream.writeObject(comparator);
        Serialization.writeMultimap(this, objectOutputStream);
    }

    public NavigableMap asMap() {
        return (NavigableMap)super.asMap();
    }

    public Map createAsMap() {
        return this.createMaybeNavigableAsMap();
    }

    public Collection createCollection(Object object) {
        if (object == null) {
            Comparator comparator = this.keyComparator();
            comparator.compare(object, object);
        }
        return super.createCollection(object);
    }

    public SortedSet createCollection() {
        Comparator comparator = this.valueComparator;
        TreeSet treeSet = new TreeSet(comparator);
        return treeSet;
    }

    public NavigableSet get(Object object) {
        return (NavigableSet)super.get(object);
    }

    public Comparator keyComparator() {
        return this.keyComparator;
    }

    public NavigableSet keySet() {
        return (NavigableSet)super.keySet();
    }

    public Comparator valueComparator() {
        return this.valueComparator;
    }
}

